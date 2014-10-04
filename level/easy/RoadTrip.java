import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void sort(List<Integer> list) {
	for (int i = 0; i < list.size() - 1; i++) {
	    for (int j = i + 1; j < list.size(); j++) {
		if (list.get(i) > list.get(j)) {
		    // System.out.println("Reached here" + list.get(i) +
		    // list.get(j));
		    int temp = list.get(i);
		    list.set(i, list.get(j));
		    list.set(j, temp);
		}
	    }
	}
    }

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(args[0]));
	String line;
	while ((line = br.readLine()) != null) {
	    List<Integer> allDistanceList = new ArrayList<>();
	    String[] lineArray = line.split(";");
	    for (int i = 0; i < lineArray.length; i++) {
		String[] temp = new String[2];
		temp = lineArray[i].split(",");
		// citiesMap.put(temp[0], Integer.parseInt(temp[1]));
		allDistanceList.add(Integer.parseInt(temp[1]));
	    }
	    // ollection<Integer> allDistanceList = citiesMap.values();
	    sort(allDistanceList);
	    for (int i = 0; i < allDistanceList.size(); i++) {
		if (i == 0) {
		    System.out.print((allDistanceList).get(i) + ",");
		}
		else if (i == allDistanceList.size() - 1) {
		    System.out.print((allDistanceList).get(i)
			    - (allDistanceList).get(i - 1));
		}
		else {

		    System.out.print((allDistanceList).get(i)
			    - (allDistanceList).get(i - 1) + ",");
		}
	    }
	    System.out.println();
	}
	br.close();
	System.exit(0);
    }
}

