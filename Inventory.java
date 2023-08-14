// Programmer: Jacob Tilley
// Date: 8/10/2023
// Program: Simple Inventory Management System
// Purpose: Creates the inventory and contains the methods used to edit the inventory

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;

public class Inventory {
   private Map <Integer, Item> inventory;
   private int id = 1000;
   private UserInterface ui;
   
   // creates a new inventory
   public Inventory(UserInterface ui) {
      this.inventory = new HashMap<Integer, Item>();
      this.ui = ui;
   }  // end of Inventory contructor
   
   
   // adds a new item to the inventory
   public void addNewItem() {
      ui.println("Note: once an item is created it cannot be deleted");
      ui.print("Name/description: ");
      String name = ui.nextLine();
      ui.print("Quantity: ");
      try {
         int quantity = Integer.parseInt(ui.nextLine());                  
         Item item = new Item(name, quantity, id);      
         inventory.put(id, item);
         ui.println("Item#" + id + " created");
      } catch (NumberFormatException e) {
         ui.println("Item could not be created");
      }      
   }  // end of addNewItem method
   
   
   // updates the quantity of the item id entered
   public void updateQuantity() {
      boolean found = false;
      try {
         ui.print("Enter ID: ");
         int idToSearch = ui.nextInt();
         ui.print("New Quantity: ");
         int newQuantity = ui.nextInt();
         for (int idSearch : inventory.keySet()) {
            if (idToSearch == idSearch) {            
               Item itemToUpdate = inventory.get(idSearch);
               itemToUpdate.setQuantity(newQuantity);
               found = true;
               ui.println("Quantity updated");
            }
         }
         if (!found) {ui.println("Item not found");}         
      } catch (InputMismatchException e) {         
         ui.nextLine();
         ui.println("Invalid input");
      };       
   }  // end of updateQuantity method
   
   
   // searches the inventory for the item id
   public String search() {
      ui.print("Enter ID: ");
      try {
         int idToSearch = ui.nextInt();         
         for (int idSearch : inventory.keySet()) {
            if (idToSearch == idSearch) {            
               Item itemToReturn = inventory.get(idSearch);
               return "\tItem#" + itemToReturn.getId() + "\t" + 
                  itemToReturn.getName() + "\tQuantity: " + itemToReturn.getQuantity();
            }
         }
      } catch (InputMismatchException e) {ui.nextLine();} // clears scanner
      return "Item does not exist";
   }  // end of search method
   
   
   // views the entire inventory
   public String view() {
      String inventoryToString = "View inventory:\n";
      if (inventory.size() == 0) {
         inventoryToString += "no items";
      } else {
         for (Item item : inventory.values()) {
            inventoryToString += "\tItem#" + item.getId();
            inventoryToString += "   " + item.getName();
            inventoryToString += "   Quantity: " + item.getQuantity() + "\n";
         }
      }      
      return inventoryToString; 
   }  // end of view method
   
   
   // saves the inventory to a file, same file used in load method
   public void save() throws FileNotFoundException {
      String saveData = "";
      PrintStream out = new PrintStream(new File("save.txt"));
      for (Item item : inventory.values()) {
         saveData += item.getId() + "\n";
         saveData += item.getName() + "\n";
         saveData += item.getQuantity() + "\n";
      }
      out.print(saveData);
   }  // end of save method
   
   
   // loads the inventory into the system from a file
   public void loadInventory() throws FileNotFoundException {
      Scanner fileScan = new Scanner(new File("save.txt"));
      while (fileScan.hasNextLine()) {
         int id = fileScan.nextInt();
         fileScan.nextLine();
         String name = fileScan.nextLine();         
         int quantity = fileScan.nextInt();
         fileScan.nextLine();         
         Item item = new Item(name, quantity, id);
         inventory.put(id, item);
         this.id++;
      }
   }  // end of load method   
   
   
}  // end of Inventory class