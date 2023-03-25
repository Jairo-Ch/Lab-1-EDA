import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadAndSplitCSV {

    public static ArrayList<ArrayList<String>> ReadCSVToArray2D(String file){
        String string;
        ArrayList<ArrayList<String>> dataset = new ArrayList<ArrayList<String>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            int counter = 0;
            boolean inQuotes = false;
            int start = 0;
            while((string = br.readLine()) != null){
                for (int i=0; i < string.length()  ; i ++){
                    if (string[i] == "\""){
                        string = string.substring(1,string.length()-1);
                    } else {
                        break;
                    }
                }
                ArrayList<String> newLines = new ArrayList<>();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '\"') {
                        inQuotes = !inQuotes;
                    }
                    if (string.charAt(i) != '\"') {
                        if(string.charAt(i) == ',' && inQuotes == false){
                            newLines.add(string.substring(start, i + 1));
                            start = i - 1;
                            inQuotes = false;
                        }
                    }
                }
                newLines.add(string.substring(start));
                dataset[counter] = newLines;
                counter ++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String file = "C:\\YoutubeDTSV2.csv";
        ArrayList<ArrayList<String>> dataset = ReadCSVToArray2D(file);
        if(dataset.size() != 0){
            dataset.forEach(System.out::println);
            System.out.println("Number of columns " + dataset.toArray().length);
            System.out.println("Number of columns " + dataset[0].size());
        }
    }

}