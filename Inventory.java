package finalProjectFF;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    List<Product> items = new LinkedList<>();
    Map<Integer, Product> itemsById = new HashMap<>();

    // Method to add an item to the inventory
    public void addItem(Product item) {
        items.add(item);
        itemsById.put(item.getId(), item);
    }

 // Method to remove an item from the inventory based on its ID
    public void removeItem(int itemId) {
        Product removedItem = itemsById.remove(itemId);
        if (removedItem != null) {
            items.remove(removedItem);
        }
    }

 // Method to print items sorted by price from high to low using insertion sort
    public void sortByPriceHighToLow() {
        insertionSortByPrice(items, Comparator.comparingDouble(Product::getPrice).reversed());

        // Print the sorted items
        System.out.println("Sorted by Price (High to Low):");
        for (Product item : items) {
            System.out.println("Item ID: " + item.getId() + ", Name: " + item.getName() +
                    ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
        }
    }

    // Method to print items sorted by price from low to high using insertion sort
    public void sortByPriceLowToHigh() {
        insertionSortByPrice(items, Comparator.comparingDouble(Product::getPrice));

        // Print the sorted items
        System.out.println("Sorted by Price (Low to High):");
        for (Product item : items) {
            System.out.println("Item ID: " + item.getId() + ", Name: " + item.getName() +
                    ", Quantity: " + item.getQuantity() + ", Price: " + item.getPrice());
        }
    }
    
 // Method to get a product by name
    public Product getProductByName(String name) {
        for (Product item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null; // Product not found
    }
    
	//Method to print items sorted by ID
	public void printItemsSortedById() {
		if(items.size() > 0) {
	        for (Product item : items) {
	            System.out.println("Item ID: " + item.id + ", Name: " + item.name + ", Quantity: " + item.quantity + ", Price: " + item.price);
	        }
		}
		else {
			System.out.println("The inventory is empty!");
		}
    }
	
	//Method to get the size of the inventory
	public int size() {
		return items.size();
	}
    
	// Method to edit an item by its ID
	public void editItem(int itemId) {
	    Product item = getItemById(itemId);
	    if (item != null) {
	        Scanner scan = new Scanner(System.in);

	        // Display current details
	        System.out.println("Current details of the item:");
	        System.out.println(item);

	        // Prompt user for new details
	        System.out.println("Enter new details for the item:");

	        System.out.print("New Name: ");
	        String newName = scan.nextLine();
	        item.setName(newName);

	        System.out.print("New Quantity: ");
	        int newQuantity = getUserInputInt(scan);
	        item.setQuantity(newQuantity);

	        System.out.print("New Price: ");
	        double newPrice = getUserInputDouble(scan);
	        item.setPrice(newPrice);

	        System.out.println("Item updated successfully.");
	    } else {
	        System.out.println("Item not found with ID: " + itemId);
	    }
	}

 // Helper method to get a product by its ID
    private Product getItemById(int itemId) {
        return itemsById.get(itemId);
    }

 // Insertion sort implementation for sorting by price
    private void insertionSortByPrice(List<Product> list, Comparator<Product> comparator) {
        for (int i = 1; i < list.size(); i++) {
            Product current = list.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(list.get(j), current) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, current);
        }
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
