package troubleShootSearch.search;

import troubleShootSearch.util.Results;
import java.util.ArrayList;
import java.util.List;

public class ExactMatch implements SearchI {
    private Results results;

    public ExactMatch(Results results) {
        this.results = results;
    }

    public boolean search(List<String> lt, int id, String keyword) {
        for (String s: lt) {
            int index = s.indexOf(keyword);

            if (index >= 0) {
                String msg = "[Exact Match] Product(" + id + ") with keyword (" + keyword + "): " + s;
                results.addResult(msg);
                return true;
            }
        }

        return false;
    }
}