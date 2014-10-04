import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	static int numLines = 0;
	static List<String> output;
	static Queue<String> minHeap;
	
	private static void readInputs(String filename) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		numLines = Integer.parseInt(br.readLine());
		minHeap = new PriorityQueue<>(numLines, new StringLengthComparator());
		for(int i = 0; i < numLines; i++) {
			minHeap.add(br.readLine());	
		}
		String line;
		while((line=br.readLine()) !=null){
			if(minHeap.peek().length() < line.length()){
				minHeap.poll();
				minHeap.add(line);
				
			}
		}
		output = new ArrayList<>();
		String heapOut;
		while((heapOut = minHeap.poll()) != null){
			output.add(heapOut);
		}
		
		
		int outputArrayLen = output.size();
		int i = outputArrayLen -1;
		while(i>=0){
			System.out.println(output.get(i));
			i=i-1;
		}
		
		
		
	}
	
	
	 
	 public static void main(String [] args) throws IOException{
		 readInputs(args[0]);
		 
		 
	 }
	 
	 private static class StringLengthComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			// TODO Auto-generated method stub
			if(s1.length() > s2.length())
				return 1;
			else return -1;
		}
		 
	 }
}

