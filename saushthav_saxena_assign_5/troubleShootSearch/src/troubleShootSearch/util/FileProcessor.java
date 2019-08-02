package troubleShootSearch.util;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

/** File I/O code referenced from:
* 1) https://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
* 2) https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
* FileProcessor for the assignment5 implementation
* @author Saushthav Saxena
*/

public class FileProcessor {
    private BufferedReader reader;
    private String filename;
    private int iostream;
    private PrintWriter writer;

    // Default Constructor with filename and 0 for reader and 1 for writer
    public FileProcessor(String name, int io) {
        MyLogger.writeMessage("[FILEPROCESSOR CONSTRUCTOR]: Initializing FileProcessor constructor.", MyLogger.DebugLevel.CONSTRUCTOR);

        filename = name;
        iostream = io;

        try {
            if (iostream == 0) {
                reader = new BufferedReader(new FileReader(filename));
            } else {
                writer = new PrintWriter(filename, "UTF-8");
            }
        } catch (IOException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Readline Implementation
    public String readLine() {
        if (reader == null) {
            System.err.println("[Err]: No read file exists.");
            return null;
        }

        try {
            String newLine = reader.readLine();
            return newLine;
        } catch (IOException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }

        return null;
    }

    // Write to output.txt Implementation
    public void writeLine(String s) {
        if (writer == null) {
            System.err.println("[Err]: No write file exists.");
            return;
        }

        try {
            writer.println(s);
        } catch (Exception e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Close the file i/o stream
    public void closeFile() {
        try {
            if (iostream == 0)
                reader.close();
            else
                writer.close();
        } catch (IOException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}