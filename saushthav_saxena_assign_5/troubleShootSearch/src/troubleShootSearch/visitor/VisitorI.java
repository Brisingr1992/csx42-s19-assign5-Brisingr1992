package troubleShootSearch.visitor;

import troubleShootSearch.visitable.VisitableI;

/**
 * The main visitor interface for the assignment5
 * @author Saushthav Saxena
 */
public interface VisitorI {
    public void visit(VisitableI product, String keyword);
}