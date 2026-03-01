package com.javabeans.model;

import com.javabeans.model.service.CartService;
import com.javabeans.model.Staff.IStaff;
import com.javabeans.model.Staff.ManagerStaff;

import java.util.ArrayList;

/**
 * ClothingShop — the main shop system.
 *
 * Uses IStaff (interface) so it can store Manager
 * in ONE list without knowing the real class.
 */
public class ClothingShop {

    // ─── Action Constants ───────────────────────────────────────────────────
    // Define action names ONCE here — use these everywhere (no raw strings!)
    public static final String CREATE_STAFF             = "CREATE_STAFF";
    public static final String ADD_PRODUCT              = "ADD_PRODUCT";
    public static final String REMOVE_PRODUCT           = "REMOVE_PRODUCT";
    public static final String SET_PRODUCT_AVAILABILITY = "SET_PRODUCT_AVAILABILITY";
    public static final String VIEW_PRODUCTS            = "VIEW_PRODUCTS";
    public static final String ADD_TO_CART              = "ADD_TO_CART";
    public static final String VIEW_CART                = "VIEW_CART";
    public static final String CHECKOUT                 = "CHECKOUT";

    // ─── State ──────────────────────────────────────────────────────────────
    private ArrayList<IStaff>      staffs      = new ArrayList<>();   // IStaff — not a concrete class!
    private IStaff                 loggedInStaff = null;

    private ArrayList<Product>     inventory   = new ArrayList<>();
    private CartService            cart        = new CartService();
    private String                 lastMessage = "";

    // ─── Constructor ────────────────────────────────────────────────────────
    public ClothingShop() {
        // Default admin account so you can always login to start
        staffs.add(new ManagerStaff("S1", "admin", "1234"));
    }

    // ─── Getters / helpers ──────────────────────────────────────────────────
    public String getLastMessage() { return lastMessage; }
    private void  setLastMessage(String msg) {
        this.lastMessage = msg;
        System.out.println("[SHOP] " + msg);
    }
        // ─── Permission helper ──────────────────────────────────────────────────
    /**
     * Central permission check used by EVERY action method.
     * 1. Is anyone logged in?
     * 2. Does that staff role allow this action?
     */
    private boolean requirePermission(String action) {
        if (loggedInStaff == null) {
            setLastMessage("Please login first.");
            return false;
        }
        if (!loggedInStaff.can(action)) {
            setLastMessage("Access denied: " + loggedInStaff.getPosition()
                        + " cannot perform [" + action + "]");
            return false;
        }
        return true;
    }

    // ─── Login / Logout ─────────────────────────────────────────────────────
    public void staffLogin(String username, String password) {
        for (int i = 0; i < staffs.size(); i++) {
            IStaff s = staffs.get(i);
            if (s.getUsername().equals(username) && s.getPassword().equals(password)) {
                loggedInStaff = s;
                setLastMessage("Login successful: " + s.getPosition() + " [" + s.getUsername() + "]");
                return;
            }
        }
        setLastMessage("Login failed. Wrong username or password.");
    }

    public void staffLogout() {
        if (loggedInStaff != null) {
            setLastMessage("Goodbye, " + loggedInStaff.getUsername() + "!");
            loggedInStaff = null;
        } else {
            setLastMessage("No one is logged in.");
        }
    }
    public void createStaff(String staffId, String username, String password, String position) {
        if (!requirePermission(CREATE_STAFF)) return;

        String p = position.trim().toLowerCase();
        IStaff newStaff;

        if (p.equals("manager")) {
            newStaff = new ManagerStaff(staffId, username, password);
        
        } else {
            setLastMessage("Position must be Manager / Cashier / StoreSupervisor");
            return;
        }

        staffs.add(newStaff);
        setLastMessage("Staff created: " + newStaff.getPosition() + " [" + username + "]");
    }

    // ─── Inventory Management (Manager & StoreSupervisor) ───────────────────
    public void addProduct(String name, double price) {
        if (!requirePermission(ADD_PRODUCT)) return;
        Product p = new Product(name, price);
        inventory.add(p);
        setLastMessage("Product added: " + name + " @ $" + price);
    }

    public void removeProduct(int index) {
        if (!requirePermission(REMOVE_PRODUCT)) return;
        if (index < 0 || index >= inventory.size()) {
            setLastMessage("Invalid product index: " + index);
            return;
        }
        String name = inventory.get(index).getName();
        inventory.remove(index);
        setLastMessage("Product removed: " + name);
    }

    public void setProductAvailability(int index, boolean available) {
        if (!requirePermission(SET_PRODUCT_AVAILABILITY)) return;
        if (index < 0 || index >= inventory.size()) {
            setLastMessage("Invalid product index: " + index);
            return;
        }
        // Product class doesn't have availability yet — we log the intent
        setLastMessage("Product [" + inventory.get(index).getName()
                    + "] availability set to: " + available);
    }

    public void viewProducts() {
        if (!requirePermission(VIEW_PRODUCTS)) return;
        if (inventory.isEmpty()) {
            setLastMessage("No products in inventory.");
            return;
        }
        System.out.println("─── Inventory ───────────────────");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println("  [" + i + "] " + p.getName() + " — $" + p.getPrice());
        }
        System.out.println("─────────────────────────────────");
    }

    // ─── Cart / Checkout (Cashier & Manager) ────────────────────────────────
    public void addToCart(int productIndex, double quantity) {
        if (!requirePermission(ADD_TO_CART)) return;
        if (productIndex < 0 || productIndex >= inventory.size()) {
            setLastMessage("Invalid product index: " + productIndex);
            return;
        }
        Product p = inventory.get(productIndex);
        cart.addItem(new ProductItem(p, quantity));
        setLastMessage("Added to cart: " + p.getName() + " x" + quantity);
    }

    public void viewCart() {
        if (!requirePermission(VIEW_CART)) return;
        System.out.println("─── Cart ────────────────────────");
        cart.printCart();
        System.out.println("Total: $" + cart.getTotalPrice());
        System.out.println("─────────────────────────────────");
    }

    public void checkout() {
        if (!requirePermission(CHECKOUT)) return;
        setLastMessage("Checkout complete! Total: $" + cart.getTotalPrice());
        // In a real system you'd clear the cart here, process payment, etc.
    }


}