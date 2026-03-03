package com.javabeans.model.Staff;

public interface IStaff {

    String getStaffId();       
    String getUsername();      //username
    String getPassword();      //password

    String getPosition();      //manger, cashier, e
    boolean can (String action); 
}
