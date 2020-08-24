import java.io.*;

public class Solution {

    final static String INPUT = ".../input.txt";
    final static String OUTPUT = ".../output.txt";

    public static void main (String[] args) {

        BufferedReader reader;
        BufferedWriter writer;

        try {
            reader = new BufferedReader(new FileReader(INPUT));

            File output = new File(OUTPUT);
            if (!output.exists())
                output.createNewFile();
            writer = new BufferedWriter(new FileWriter(output));

            String line = reader.readLine();

            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
