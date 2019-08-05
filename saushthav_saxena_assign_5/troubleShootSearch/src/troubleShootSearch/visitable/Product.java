package troubleShootSearch.visitable;

import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.util.MyLogger;
import troubleShootSearch.visitor.VisitorI;
import java.util.ArrayList;
import java.util.List;

/**
 * The main visitable interface for the assignment5
 * @author Saushthav Saxena
 */
public class Product implements VisitableI {
    private List<String> troubleshoot;
    private FileProcessor fp;

    public Product(FileProcessor fp) {
        this.fp = fp;
        this.troubleshoot = new ArrayList<String>();
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

    public List<String> getList() {
        return this.troubleshoot;
    }

    @Override
    public void apply(VisitorI visitor, String keyword) {
        visitor.visit(this, keyword);
    }
}