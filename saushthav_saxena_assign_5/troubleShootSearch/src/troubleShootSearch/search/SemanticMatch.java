package troubleShootSearch.search;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.visitable.VisitableI;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;

public class SemanticMatch implements SearchI {
    private Results results;
    private FileProcessor fp;
    private Map<String, String> hm;

    public SemanticMatch(FileProcessor fp, Results results) {
        this.fp = fp;
        this.results = results;
        this.hm = new HashMap<String, String>();

        init();
    }

    private void init() {
        String sentence = "";
        while (sentence != null) {
            MyLogger.writeMessage("Initializing product...", MyLogger.DebugLevel.IN_RUN);
            sentence = fp.readLine();

            String[] arr = sentence.split(":");
            if (sentence != null) {
                hm.put(arr[0], arr[1]);
                hm.put(arr[1], arr[0]);
            }
        }
    }

    public void search(List<String> lt, int id, String keyword) {
        for (String s: lt) {
            String[] str = keyword.split(" ");

            for (String temp: str) {
                int index = s.indexOf(temp);
                int index1 = s.indexOf(hm.get(temp));

                if (index >= 0 || index1 >= 0) {
                    String msg = "[Stemming Match] Product(" + id + ") with keyword (" + keyword + "): " + s;
                    results.addResult(msg);
                    break;
                }
            }
        }
    }
}