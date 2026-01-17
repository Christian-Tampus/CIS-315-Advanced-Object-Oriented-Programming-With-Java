/**
 * Assignment: Program 6 | Tech Items
 * Instructions: Follow the uml diagram
 * Design Notes: Follow the uml diagram
 * Version: 1.0, 10/23/2025
 * Author: Christian Tampus
 * Class: CIS-315
 **/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.acme.*;
/*
 * DO NOT Change the Driver!
 * 
 * comment/uncomment only
 * 
 */
public class Driver {

    public static void main(String[] args) {

        TechItem[] items = null;

        items = readFile("equipment.csv");
        Inventory inv = new Inventory(items);

        System.out.println("# of items: " + inv.getInventorySize());

        System.out.println("\nUnsorted: ");
        inv.displayInventory();

        inv.sort();

        System.out.println("\nSorted: ");
        inv.displayInventory();

    }
    
	private static TechItem[] readFile(String filename) {
		// Create array to return
		TechItem[] items = new TechItem[100];

		// Create a File instance
		File file = new File(filename);

		try {
			// Create a Scanner for the file
			Scanner input = new Scanner(file);
			
			// Skip header
			if (input.hasNext()) {
				input.nextLine();
			}
			
			int i = 0;

			// Read data from a file
			while (input.hasNext()) {
				String line = input.nextLine();
				StringTokenizer st = new StringTokenizer(line, ",");
				
				String name = st.nextToken();
				String date = st.nextToken();
				String cost = st.nextToken();
				String location = st.nextToken();
				String company = st.nextToken();
				String ordNum = st.nextToken();
				String quantity = st.nextToken();
				String sku = st.nextToken();
				
				items[i++] = new TechItem(Integer.parseInt(sku), ordNum, 
						company, Integer.parseInt(quantity));
			}

			// Close the file
			input.close();
		} catch (FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe);
		}

		return items;
	}

}