// Programmer: Jacob Tilley
// Date: 8/10/2023
// Program: Simple Inventory Management System
// Purpose: Allows businesses to keep up to date information about their inventories,
//          with options to add new items, update quantites, search, and view inventory.

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;

public class InventoryMain implements UserInterface {
   private Scanner console;
   private Inventory inventory;  
   
   public static void main(String[] args) throws FileNotFoundException {
      InventoryMain invMain = new InventoryMain();
      invMain.run();
   }  // end of main method
   
   public InventoryMain () {
      console = new Scanner(System.in);
      inventory = new Inventory(this);
   }  // end of InventoryMain contructor
   
   // runs the inventory management system
   private void run() throws FileNotFoundException {
      char selection = 'Z';
      inventory.loadInventory();
      println(WELCOME_MESSAGE);      
      while (selection != 'Q') {
         println(DISPLAY_MENU);
         selection = menuSelection();
         switch (selection) {
            case 'A':
               inventory.addNewItem();
               break;
            case 'U':
               inventory.updateQuantity();
               break;
            case 'S':
               println(inventory.search());
               break;
            case 'V':
               print(inventory.view());
               break;
            case 'Q':
               println(QUITING_MESSAGE);
               break;
            default:
               println(INVALID_INPUT_MESSAGE);
         }  // end of switch/case      
      }  // end of while loop
      inventory.save();
   }  // end of run method   
   
   
   // returns the user's menu selection
   public char menuSelection() {
      char selection = 'Z';
      try {
         selection = nextLine().toUpperCase().charAt(0);
      } catch (StringIndexOutOfBoundsException e) {}  
      return selection;
   }  // end of menuSelection method                    
   
   
   /* Helper functions to simplify and de-clutter code*/   
   
   // receives user input in the console for strings
   public String nextLine() {
      return console.nextLine();
   }  // end of nextLine method
   
   // receives user input in the console for integers
   public int nextInt() {
      int value = console.nextInt(); 
      console.nextLine();  // clears scanner
      return value;
   }  // end of nextInt method
   
   // prints a string, does not advance to next line
   public void print(String s) {
      System.out.print(s);
   }  // end of print method

   // prints a string, then advances to next line
   public void println(String s) {
      System.out.println(s);
   }  // end of println method 1
      
   // prints a blank line, then advances to next line
   public void println() {
      System.out.println();
   }  // end of println method 2

}  // end of InventoryMain class