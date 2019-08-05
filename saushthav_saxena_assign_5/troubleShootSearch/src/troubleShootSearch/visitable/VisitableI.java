package troubleShootSearch.visitable;

import troubleShootSearch.visitor.VisitorI;
/**
 * The main visitable interface for the assignment5
 * @author Saushthav Saxena
 */
public interface VisitableI {
    public void apply(VisitorI visit, String keyword);
}