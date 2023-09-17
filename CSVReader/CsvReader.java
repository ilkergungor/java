import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    public static void main(String[] args) {

        String path = "C:\\Users\\lkrgn\\JavaRest\\CSVReader\\SacramentocrimeJanuary2006.csv";
        String line = "";
            
        try {
            BufferedReader r = new BufferedReader(new FileReader(path));
            while((line = r.readLine()) != null){
                String[] values = line.split(",");
                System.out.println(values[0]+ values[5]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
