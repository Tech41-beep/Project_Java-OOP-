package com.javabeans.model.Staff;

public interface IStaff {

    void staffLogin(String username, String password);

    String getStaffId();       
    String getUsername();      //username
    String getPassword();      //password

    String getPosition();      //manger, cashier, e
    boolean can (String action); 
}
