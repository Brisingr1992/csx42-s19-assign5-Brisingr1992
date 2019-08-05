package troubleShootSearch.visitor;

import troubleShootSearch.search.ExactMatch;
import troubleShootSearch.search.SemanticMatch;
import troubleShootSearch.search.StemmingMatch;
import troubleShootSearch.util.Results;
import troubleShootSearch.visitable.VisitableI;
import troubleShootSearch.util.FileProcessor;

/**
 * The main visitor class for the assignment5
 * @author Saushthav Saxena
 */
public class MatchingVisitor implements VisitorI {
    private ExactMatch exact;
    private SemanticMatch semantic;
    private StemmingMatch stemming;

    public MatchingVisitor(FileProcessor fp, Results results) {
        try {
            this.exact = new ExactMatch(results);
            this.semantic = new SemanticMatch(fp, results);
            this.stemming = new StemmingMatch(results);
            this.semantic.init();
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

    }

    @Override
    public void visit(VisitableI product, String keyword) {
        exact.search(product.getList(), product.getId(), keyword);
        semantic.search(product.getList(), product.getId(), keyword);
        stemming.search(product.getList(), product.getId(), keyword);
    }
}