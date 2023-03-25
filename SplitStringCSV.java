import java.util.ArrayList;
public class SplitStringCSV {
    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>();
        // Ejemplos de entrada
        lines.add("1232,,video title");
        lines.add("1342,video \"title\"");
        lines.add("1342,\"video, title\"");
        lines.add("1342,\"video, \"\"title\"\"\"");

        ArrayList<ArrayList<String>> dataset = new ArrayList<>();

        lines.forEach(string -> {
            boolean inQuotes = false;
            int start = 0;
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
            dataset.add(newLines);
        });
        // Cantidad de campos en cada arreglo
        dataset.forEach( element -> System.out.println(element + " size " + element.size()));
    }
}

