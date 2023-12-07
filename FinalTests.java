/**
 * 
 */
package finalProjectFF;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS152 - Spring 2023
 * Dec 4, 2023
 */
class FinalTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
    void addItem() {
        Inventory inventory = new Inventory();
        Product item = new Product(1, "Test Item", 10, 25.99);

        inventory.addItem(item);

        assertEquals(1, inventory.size());
        assertEquals(item, inventory.getProductByName("Test Item"));
    }

    @Test
    void removeItem() {
        Inventory inventory = new Inventory();
        Product item = new Product(1, "Test Item", 10, 25.99);

        inventory.addItem(item);
        inventory.removeItem(1);

        assertEquals(0, inventory.size());
        assertNull(inventory.getProductByName("Test Item"));
    }

    @Test
    void editItem() {
        Inventory inventory = new Inventory();
        Product item = new Product(1, "Test Item", 10, 25.99);

        inventory.addItem(item);

        // Simulate user input for editing
        System.setIn(new java.io.ByteArrayInputStream("Edited Item\n15\n30.99\n".getBytes()));
        inventory.editItem(1);

        assertEquals("Edited Item", item.getName());
        assertEquals(15, item.getQuantity());
        assertEquals(30.99, item.getPrice());
    }

    @Test
    void sortByPriceHighToLow() {
        Inventory inventory = new Inventory();
        Product item1 = new Product(1, "Item1", 10, 25.99);
        Product item2 = new Product(2, "Item2", 5, 19.99);
        Product item3 = new Product(3, "Item3", 20, 35.99);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        inventory.sortByPriceHighToLow();

        // The correct sorted order in descending price: item3, item1, item2
        assertEquals(item3, inventory.items.get(0));
        assertEquals(item1, inventory.items.get(1));
        assertEquals(item2, inventory.items.get(2));
    }


    @Test
    void sortByPriceLowToHigh() {
        Inventory inventory = new Inventory();
        Product item1 = new Product(1, "Item1", 10, 25.99);
        Product item2 = new Product(2, "Item2", 5, 19.99);
        Product item3 = new Product(3, "Item3", 20, 35.99);

        inventory.addItem(item1);
        inventory.addItem(item2);
        inventory.addItem(item3);

        inventory.sortByPriceLowToHigh();

        // Assuming the sorted order is item2, item1, item3
        assertEquals(item2, inventory.items.get(0));
        assertEquals(item1, inventory.items.get(1));
        assertEquals(item3, inventory.items.get(2));
    }

    @Test
    void getProductByName() {
        Inventory inventory = new Inventory();
        Product item1 = new Product(1, "Item1", 10, 25.99);
        Product item2 = new Product(2, "Item2", 5, 19.99);

        inventory.addItem(item1);
        inventory.addItem(item2);

        assertEquals(item1, inventory.getProductByName("Item1"));
        assertEquals(item2, inventory.getProductByName("Item2"));
        assertNull(inventory.getProductByName("NonexistentItem"));
    }
    
    @Test
    void toStringFormat() {
        Product item = new Product(1, "Test Item", 10, 25.99);

        String expected = "Product [id=1, name=Test Item, quantity=10, price=25.99]";
        String actual = item.toString();

        assertEquals(expected, actual);
    }

}
