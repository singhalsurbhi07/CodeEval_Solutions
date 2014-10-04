import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private static List<Integer> stack ;
	
	public static void push(String input){
		stack = new ArrayList<>();
		String [] inputArray = input.split(" ");
		for (int i=0;i<inputArray.length;i++){
			stack.add(Integer.parseInt(inputArray[i]));
		}
	}
	
	public static void pop(){
		for (int i=stack.size()-1;i>=0;i=i-2){
			System.out.print(stack.get(i)+" ");
		}
		System.out.println();
	}
	public static void main(String [] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		String line;
		while((line = reader.readLine())!=null){
			push(line);
			pop();
		}
	}
}

