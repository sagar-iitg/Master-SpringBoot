package com.sagar.services.impl;

import com.sagar.dtos.AddItemToCartRequest;
import com.sagar.dtos.CartDto;
import com.sagar.entities.Cart;
import com.sagar.entities.CartItem;
import com.sagar.entities.Product;
import com.sagar.entities.User;
import com.sagar.exceptions.BadApiRequestException;
import com.sagar.exceptions.ResourceNotFoundException;
import com.sagar.repositories.CartItemRepository;
import com.sagar.repositories.CartRepository;
import com.sagar.repositories.ProductRepository;
import com.sagar.repositories.UserRepository;
import com.sagar.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public CartDto addItemToCart(String userId, AddItemToCartRequest request) {

        int quantity = request.getQuantity();
        String productId = request.getProductId();

        if (quantity <= 0) {
            throw new BadApiRequestException("Requested quantity is not valid !!");
        }

        //fetch the product
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found in database !!"));
        //fetch the user from db
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found in database!!"));

        Cart cart = null;
        try {
            cart = cartRepository.findByUser(user).get();
        } catch (NoSuchElementException e) {
            cart = new Cart();
            cart.setCartId(UUID.randomUUID().toString());
            cart.setCreatedAt(new Date());
        }

        //perform cart operations
        //if cart items already present; then update
        AtomicReference<Boolean> updated = new AtomicReference<>(false);
        List<CartItem> items = cart.getItems();
        items = items.stream().map(item -> {

            if (item.getProduct().getProductId().equals(productId)) {
                //item already present in cart
                item.setQuantity(quantity);
                item.setTotalPrice(quantity * product.getDiscountedPrice());
                updated.set(true);
            }
            return item;
        }).collect(Collectors.toList());

//        cart.setItems(updatedItems);

        //create items
        if (!updated.get()) {
            CartItem cartItem = CartItem.builder()
                    .quantity(quantity)
                    .totalPrice(quantity * product.getDiscountedPrice())
                    .cart(cart)
                    .product(product)
                    .build();
            cart.getItems().add(cartItem);
        }


        cart.setUser(user);
        Cart updatedCart = cartRepository.save(cart);
        return mapper.map(updatedCart, CartDto.class);


    }

    @Override
    public void removeItemFromCart(String userId, int cartItem) {
        //conditions
        CartItem cartItem1 = cartItemRepository.findById(cartItem).orElseThrow(() -> new ResourceNotFoundException("Cart Item not found !!"));
        cartItemRepository.delete(cartItem1);

    }

    @Override
    public void clearCart(String userId) {
        //fetch the user from db
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found in database!!"));
        Cart cart = cartRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Cart of given user not found !!"));
        cart.getItems().clear();
        cartRepository.save(cart);
    }

    @Override
    public CartDto getCartByUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found in database!!"));
        Cart cart = cartRepository.findByUser(user).orElseThrow(() -> new ResourceNotFoundException("Cart of given user not found !!"));

        return mapper.map(cart, CartDto.class);
    }
}
