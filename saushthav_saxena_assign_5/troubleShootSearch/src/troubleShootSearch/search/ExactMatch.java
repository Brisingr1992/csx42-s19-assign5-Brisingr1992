package troubleShootSearch.search;

import troubleShootSearch.util.Results;
import java.util.ArrayList;
import java.util.List;

public class ExactMatch implements SearchI {
    private Results results;

    public ExactMatch(Results results) {
        this.results = results;
    }

    public void search(List<String> lt, String keyword) {

    }
}