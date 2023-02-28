package com.sk.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sk.entities.Cart;
import com.sk.entities.CartItem;
import com.sk.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

	
	private String cartId;
	private Date createdAt;
	private UserDto user;	
	private List<CartItemDto> items=new ArrayList<>();
	


}

