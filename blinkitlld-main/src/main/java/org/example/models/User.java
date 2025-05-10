package org.example.models;

import org.example.models.Address;
import org.example.models.Cart;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int userId;
    public String userName;
    public Address address;
    Cart userCartDetails;
    List<Integer> orderIds;

    public User(){
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    //get UserCart
    public Cart getUserCart(){
        return userCartDetails;
    }
}
