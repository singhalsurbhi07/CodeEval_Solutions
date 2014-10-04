import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void fizzBuzzEval(String filename) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(filename));
	String line;
	while ((line = br.readLine()) != null) {
	    String[] temp = line.split(" ");
	    for (int i = 1; i <= Integer.parseInt(temp[temp.length - 1]); i++) {
		if (i % Integer.parseInt(temp[0]) == 0 && i % Integer.parseInt(temp[1]) == 0) {
		    System.out.print("FB ");

		} else if (i % Integer.parseInt(temp[0]) == 0) {
		    System.out.print("F ");
		} else if (i % Integer.parseInt(temp[1]) == 0) {
		    System.out.print("B ");
		} else {
		    System.out.print(i + " ");
		}
	    }
	    System.out.println();
	}
	br.close();
    }

    public static void main(String[] args) throws IOException {
	String filename = args[0];
	// System.out.println(filename);
	fizzBuzzEval(filename);
	System.exit(0);
    }
}
