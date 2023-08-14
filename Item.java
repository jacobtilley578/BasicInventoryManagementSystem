// Programmer: Jacob Tilley
// Date: 8/10/2023
// Program: Simple Inventory Management System
// Purpose: Creates each item for use in the inventory management system

public class Item {
   private String name;
   private int id;
   private int quantity;
   
   // creates a new item
   public Item (String name, int quantity, int id) {
      this.name = name;
      this.id = id;
      this.quantity = quantity;
   }  // end of item constructor
   
   // gets item id
   public int getId() {
      return id;
   }  // end of getId method
   
   public String getName() {
      return name;
   }  // end of getName method
   
   // gets item quantity
   public int getQuantity() {
      return quantity;
   }  // end of getQuantity method
   
   public void setQuantity(int newQuantity) {
      quantity = newQuantity;
   }  // end of setQuantity method
   
}  // end of item class