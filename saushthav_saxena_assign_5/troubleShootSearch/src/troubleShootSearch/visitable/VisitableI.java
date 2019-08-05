package troubleShootSearch.visitable;

import troubleShootSearch.visitor.VisitorI;
import java.util.List;

/**
 * The main visitable interface for the assignment5
 * @author Saushthav Saxena
 */
public interface VisitableI {
    public void apply(VisitorI visit, String keyword);
    public List<String> getList();
}