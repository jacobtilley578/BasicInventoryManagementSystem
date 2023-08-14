// Programmer: Jacob Tilley
// Date: 8/10/2023
// Program: Simple Inventory Management System
// Purpose: User interface used to simplify code in the system

public interface UserInterface {
   final String WELCOME_MESSAGE = "Welcome!\n" + 
                                  "Inventory Management System";
                                         
   final String DISPLAY_MENU = "\n(a)dd item\n" + 
                               "(u)pdate quantity\n" +
                               "(s)earch inventory\n" + 
                               "(v)iew inventory\n" +
                               "(q)uit program";
                                                                            
   final String INVALID_INPUT_MESSAGE = "Invalid input";
    
   final String QUITING_MESSAGE = "quiting program...";
   
   /* Helper functions, declared in InventoryMain, to simplify and de-clutter code*/   
   
   String nextLine();
   int nextInt();
   void println();
   void println(String s);
   void print(String s);    
   
}  // end of UserInterface