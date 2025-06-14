package com.sk.springtransaction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="emp_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "emp_name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // optional, specifies FK column
    private Address address;

}


