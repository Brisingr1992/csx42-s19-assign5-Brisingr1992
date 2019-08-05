package troubleShootSearch.search;

import troubleShootSearch.util.Results;
import java.util.ArrayList;
import java.util.List;

public class StemmingMatch implements SearchI {
    private Results results;

    public StemmingMatch(Results results) {
        this.results = results;
    }

    public void search(List<String> lt, int id, String keyword) {
        for (String s: lt) {
            
            String[] str = keyword.split(" ");
            if (str != null) {
                int index = s.indexOf(str[0]);

                if (index >= 0) {
                    String msg = "[Stemming Match] Product(" + id + ") with keyword (" + keyword + "): " + s;
                    results.addResult(msg);
                }
            }
        }
    }
}