package com.pinto.ReactEcommerceBackend.entity;


import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name="phone")
    private String phone;
    @Column(name = "is_admin")
    private boolean isAdmin = false;
    
    
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Order> orders;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    private List<Address> addresses;

//
//    public List<Order> getOrders() { return orders; }
//    public void setOrders(List<Order> orders) { this.orders = orders; }
//
//    public List<Address> getAddresses() { return addresses; }
//    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }
}