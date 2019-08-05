
package troubleShootSearch.driver;

// Import all the classes and interfaces
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.visitable.Product;
import troubleShootSearch.visitor.VisitorI;
import troubleShootSearch.visitor.MatchingVisitor;

/**
 * The main driver for the assignment5
 * @author Saushthav Saxena
 */
public class Driver {
	public static void main(String[] args) {
        if (args.length < 7) {
            System.err.println("Error: Incorrect number of arguments...");
		    System.err.println("N input1.txt .. inputN.txt output.txt debugValue");            
		    System.exit(0);
        }

        int debug_level = 0;
        try {
			debug_level = Integer.parseInt(args[7]);
			if(debug_level < 0 || debug_level > 4)
				throw new IllegalArgumentException("Debug levels 0-4(inclusive) supported.");
		} catch(Exception e){
			System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
		}

        // Set Degug level
        MyLogger.setDebugValue(debug_level);
		
		String line = "";
        FileProcessor userInput = new FileProcessor(args[4], 0);
        Results mainResults = new Results(args[5]);
        VisitorI visitor = new MatchingVisitor(new FileProcessor(args[6], 0), mainResults);

        MyLogger.writeMessage("Initializing products...", MyLogger.DebugLevel.IN_RUN);
        Product[] products = new Product[4];
        for (int i = 0; i < products.length; i++) {
            products[i] = new Product(new FileProcessor(args[i], i), i + 1);
            products[i].init();
        }

        MyLogger.writeMessage("Reading User input file...", MyLogger.DebugLevel.IN_RUN);
		for (int i = 0; line != null; i++) {
            try {
                MyLogger.writeMessage("Reading line...", MyLogger.DebugLevel.IN_RUN);
                line = userInput.readLine();

                if (line == null) break;
                
                for (Product p: products) {
                    p.apply(visitor, line);
                }
            } catch (Exception e) {
                System.err.println("[Exception Caught]: " + e.getMessage());
                e.printStackTrace();
                System.exit(1);
            }
		}
        
        mainResults.dumpToFile();
        mainResults.closeIO();
	}
}
