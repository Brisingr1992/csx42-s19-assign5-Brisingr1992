package troubleShootSearch.visitable;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;;
import troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;

/**
 * The main visitable interface for the assignment5
 * @author Saushthav Saxena
 */
public class Product implements VisitableI {
    private ArrayList<String> troubleshoot;
    private FileProcessor fp;

    public Product(FileProcessor fp) {
        this.fp = fp;
    }

    public void init() {
        String sentence = "";
        while (sentence != null) {
            MyLogger.writeMessage("Initializing product...", MyLogger.DebugLevel.IN_RUN);
            sentence = fp.readLine();

            if (sentence != null) {
                troubleshoot.add(sentence);
            }
        }
    }

    @Override
    public void apply(VisitorI visitor, String keyword) {
        visitor.visit(this, keyword);
    }
}