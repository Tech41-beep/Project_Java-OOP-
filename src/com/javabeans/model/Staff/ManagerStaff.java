
package com.javabeans.model.Staff;  // Same package

public class ManagerStaff implements IStaff {
    private String staffId;
    private String username;
    private String password;

    public ManagerStaff(String staffId, String username, String password) {
        this.staffId = staffId;
        this.username = username;
        this.password = password;
    }

    @Override public String getStaffId() { return staffId; }
    @Override public String getUsername() { return username; }
    @Override public String getPassword() { return password; }
    @Override public String getPosition() { return "Manager"; }

    @Override
    public boolean can(String action) {
        // Manager has full access — no restrictions
        return true;
    }
}