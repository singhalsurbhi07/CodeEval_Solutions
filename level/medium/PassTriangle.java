import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void process(String filename) throws IOException {
		List<Integer> output = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		int lineNo = 0;

		while ((line = br.readLine()) != null) {
			lineNo += 1;
			String[] numbers = line.split(" ");

			if (lineNo == 1) {
				output.add(Integer.parseInt(numbers[0]));
			} else {
				int parentValue = 0;
				for (int i = 0; i < numbers.length; i++) {
					if (i == 0) {
						parentValue = output.get(output.size() - lineNo + 1);
					} else if (i == (numbers.length - 1)) {
						parentValue = output.get(output.size() - lineNo);
					} else {
						parentValue = Math.max(
								output.get(output.size() - lineNo),
								output.get(output.size() - lineNo + 1));
					}
					output.add(parentValue + Integer.parseInt(numbers[i]));
				}
			}
		}
		br.close();
		System.out.println(Collections.max(output.subList(output.size()
				- lineNo - 1, output.size() - 1)));
	}

	public static void main(String[] args) throws IOException {
		process(args[0]);
	}
}
