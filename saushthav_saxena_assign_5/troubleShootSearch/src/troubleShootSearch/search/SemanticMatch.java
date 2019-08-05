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
    }

    public void init() {
        try {
            String sentence = "";
            while (sentence != null) {
                MyLogger.writeMessage("Initializing semantic meanings...", MyLogger.DebugLevel.IN_RUN);
                sentence = this.fp.readLine();

                if (sentence != null) {
                    String[] arr = sentence.split(":");
                    hm.put(arr[0], arr[1]);
                    hm.put(arr[1], arr[0]);
                }
            }
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void search(List<String> lt, int id, String keyword) {
        try {
            for (String s: lt) {
                String[] str = keyword.split(" ");
    
                for (String temp: str) {
                    int index = s.indexOf(temp);
                    int index1 =  hm.containsKey(temp) ? s.indexOf(hm.get(temp)) : -1;
    
                    if (index >= 0 || index1 >= 0) {
                        String msg = "[Semantic Match] Product(" + id + ") with keyword (" + keyword + "): " + s;
                        results.addResult(msg);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}