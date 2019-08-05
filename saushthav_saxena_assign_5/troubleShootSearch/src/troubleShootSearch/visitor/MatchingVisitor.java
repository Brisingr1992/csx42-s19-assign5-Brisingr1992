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
        this.exact = new ExactMatch(results);
        this.semantic = new SemanticMatch(results);
        this.stemming = new StemmingMatch(fp, results);
    }

    @Override
    public void visit(VisitableI product, String keyword) {
        exact.search(product.getTroubleshoot(), keyword);
        semantic.search(product.getTroubleshoot(), keyword);
        stemming.search(product.getTroubleshoot(), keyword);
    }
}