package com.javabeans;

import com.javabeans.model.Staff.IStaff;
import com.javabeans.model.Staff.ManagerStaff;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== STAFF LOGIN =====");

        System.out.print("Enter Staff ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        IStaff staff = new ManagerStaff(id, username, password);

        staff.staffLogin(username, password);

        sc.close();
    }
}