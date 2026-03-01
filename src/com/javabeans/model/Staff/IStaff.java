package com.javabeans.model.Staff;

public interface IStaff {
    String getStaffId();
    String getUsername();
    String getPassword();
    String getPosition();
    boolean can(String action);
}