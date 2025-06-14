package com.sk.springtransaction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="address_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String city;
    String pincode;
    String state;

}
