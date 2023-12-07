package finalProjectFF;

import java.util.Scanner;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS152 - Spring 2023
 * Nov 7, 2023
 */
public class Driver {
	public static void main(String[] args) {
		Inventory inventory = new Inventory();
		Boolean done = false;
		Scanner scan = new Scanner(System.in);
		int userInputInt = 0;
		String userInput;
		
		Product item1 = new Product(111, "Motor", 5, 545.59);
		Product item2 = new Product(121, "Seal kit", 50, 49.99);
		Product item3 = new Product(131, "O ring", 500, 2.99);
		Product item4 = new Product(141, "Hose end", 5000, 20.00);
		Product item5 = new Product(151, "adapter", 5000, 14.99);
		
		inventory.addItem(item1);
		inventory.addItem(item2);
		inventory.addItem(item3);
		inventory.addItem(item4);
		inventory.addItem(item5);
		
		while(done != true) {
			System.out.println("Welcome");
			System.out.println("1.Add item.\n2.Delete item.\n3.Look up item.\n4.Edit a item\n5.View Inventory\n6.Sort inventory\nEnter 99 to exit.\n");
			
			System.out.println("What would you like to do?");
			userInputInt = getUserInputInt(scan);
			
			done = checkIfDone(userInputInt);
			
			if(done != true && userInputInt == 1) {
				Product item = new Product();
				item = enterItem();
				inventory.addItem(item);
			}
			
			else if(done != true && userInputInt == 2) {
				if(inventory.size() > 0) {
					System.out.println("Enter the ID number of the item you would like to delete: ");
					inventory.printItemsSortedById();
					userInputInt = getUserInputInt(scan);
					inventory.removeItem(userInputInt);
				}
				else {
					System.out.println("The inventory is empty!");
				}
			}
			
			else if(done != true && userInputInt == 3) {
				System.out.println("Enter the name of the item you are looking for: ");
				inventory.printItemsSortedById();
				userInput = scan.nextLine();
				System.out.println(inventory.getProductByName(userInput));
			}
			
			else if(done != true && userInputInt == 4) {
				System.out.println("Enter the ID of the item you are looking for: ");
				inventory.printItemsSortedById();
				userInputInt = getUserInputInt(scan);
				inventory.editItem(userInputInt);
			}
			
			else if(done != true && userInputInt == 5) {
				inventory.printItemsSortedById();
			}
			
			else if(done != true && userInputInt == 6) {
				System.out.println("How would you like to sort the inventory?\n1.High to low\n2.Low to high");
				userInputInt = getUserInputInt(scan);
				
				if(userInputInt == 1) {
					inventory.sortByPriceHighToLow();
				}
				
				else if(userInputInt == 2) {
					inventory.sortByPriceLowToHigh();
				}
			}
		}
		
		
		
		
	}
	
	public static Boolean checkIfDone(int userInput) {
		if(userInput >= 99) {
			return true;
		}
		return false;
	}
	
	public static Product enterItem() {
		int id;
		String name;
		int quantity;
		double price;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter item details.\n");
		
		System.out.println("Please enter the name.");
		name = scan.nextLine();
		
		System.out.println("Please enter item ID.");
        id = getUserInputInt(scan);

        System.out.println("Please enter item quantity.");
        quantity = getUserInputInt(scan);

        System.out.println("Please enter item price.");
        price = getUserInputDouble(scan);

        System.out.println("Item Entered.");
        return new Product(id, name, quantity, price);
	}

public static int getUserInputInt(Scanner scan) {
    while (true) {
        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        }
    }
}

public static double getUserInputDouble(Scanner scan) {
    while (true) {
        try {
            return Double.parseDouble(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid double.");
        }
    }
}

}


