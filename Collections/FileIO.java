import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
    public static void main(String[] args) {

        String[] numbers = {"one", "two", "three", "four"};
        String line;

    try {
        BufferedReader reader = new BufferedReader (new FileReader("C:\\Users\\lkrgn\\JavaRest\\file.txt"));

        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\lkrgn\\JavaRest\\file.txt"));
        writer.write("\n\nThis text was writer by the writer!");
        for (String string : numbers) {
            writer.write("\n" + string);
        }
        writer.close();

        while((line = reader.readLine()) != null){
        System.out.println(line);
        }
        reader.close();
        } catch (IOException e) {e.printStackTrace();}
    }
}
