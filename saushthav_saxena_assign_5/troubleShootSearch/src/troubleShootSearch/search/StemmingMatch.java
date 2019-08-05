package troubleShootSearch.search;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import troubleShootSearch.util.FileProcessor;
import troubleShootSearch.visitable.VisitableI;
import troubleShootSearch.util.Results;
import troubleShootSearch.util.MyLogger;

public class StemmingMatch implements SearchI {
    private Results results;
    private FileProcessor fp;
    private Map<String, String> hm;

    public StemmingMatch(FileProcessor fp, Results results) {
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
            }
        }
    }

    public void search(List<String> lt, String keyword) {

    }
}