package com.javabeans.model.Staff;




/**
 * ManagerStaff — can do EVERYTHING in the shop.
 */
public class ManagerStaff implements IStaff {
    public ManagerStaff() {
    this.staffId = "M001";
    this.username = "admin";
    this.password = "1234";
}
     @Override
    public void staffLogin(String username, String password) {
      if(this.username.equals(username) && this.password.equals(password)){
        System.out.println("Manager login successful.");
      } else {
        System.out.println("Invalid credentials.");
      }
    }
    private String staffId;
    private String username;
    private String password;

    public ManagerStaff(String staffId, String username, String password) {
        this.staffId  = staffId;
        this.username = username;
        this.password = password;
    }

    @Override public String getStaffId()  { return staffId;   }
    @Override public String getUsername() { return username;  }
    @Override public String getPassword() { return password;  }
    @Override public String getPosition() { return "Manager"; }

    @Override
    public boolean can(String action) {
        // Manager has full access — no restrictions
        return true;
    }
}

