package troubleShootSearch.visitable;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;
import java.util.List;
import java.lang.InstantiationError;

/**
 * The main visitable interface for the assignment5
 * @author Saushthav Saxena
 */
public class Product implements VisitableI {
    private List<String> troubleshoot;
    private FileProcessor fp;
    private int id;

    public Product(FileProcessor fp, int id) {
        try {
            if (fp == null) throw new InstantiationError("Failed to instantialte Product strings...");
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    
        this.fp = fp;
        this.troubleshoot = new ArrayList<String>();
        this.id = id;
    }

    public void init() {
        try {
            String sentence = "";
            while (sentence != null) {
                MyLogger.writeMessage("Initializing product(" + id + ")...", MyLogger.DebugLevel.IN_RUN);
                sentence = this.fp.readLine();

                if (sentence != null) {
                    troubleshoot.add(sentence);
                }
            }
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<String> getList() {
        return this.troubleshoot;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void apply(VisitorI visitor, String keyword) {
        visitor.visit(this, keyword);
    }
}