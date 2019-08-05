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
    private Results results;
    private ExactMatch exact;
    private SemanticMatch semantic;
    private StemmingMatch stemming;

    public MatchingVisitor(FileProcessor fp, Results results) {
        this.results = results;
        this.exact = new ExactMatch();
        this.semantic = new SemanticMatch();
        // this.stemming = new StemmingMatch(fp);
        this.stemming = new StemmingMatch();
    }

    @Override
    public void visit(VisitableI product, String keyword) {
        // TODO: Implement all the searches
    }
}