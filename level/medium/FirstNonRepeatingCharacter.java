import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static void readInput(String fileName) throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	String line;
	while((line = reader.readLine())!=null){
	    getFirstNonRepeatingChar(line);
	}
	
    }
    
    public static void getFirstNonRepeatingChar(String input){
	Map <Character,Integer> charMap = new HashMap<>();
	MyQueue myqueue = new MyQueue();
	for(int i=0;i<input.length();i++){
	    char c = input.charAt(i);
	    //System.out.println(c);
	    if(!(charMap.containsKey(c))){
		//System.out.println("map doesnt has the character");
		myqueue.add(c);
		charMap.put(c,1);
	    }else{
		//System.out.println("map has the character");
		int noOfOccurence = charMap.get(c);
		//System.out.println(noOfOccurence);
		if(noOfOccurence==1){
		    myqueue.removeChar(c);
		}
		charMap.put(c, noOfOccurence+1);
	    }
	}
	if(!myqueue.isEmpty()){
	    System.out.println(myqueue.getFirstElement());
	}else{
	    System.out.println("-1");

	}
    }
    public static void main(String [] args) throws IOException{
	readInput(args[0]);
    }
}

class MyQueue{
    List<Character> q = new ArrayList<>();
    public void add(Character element){
	q.add(element);
    }
    public void removeChar(char c){
	//System.out.println(c+" is to be removed");
	for(int i=0;i<q.size();i++){
	    if(q.get(i)==c){
		q.remove(i);
	    }
	}
    }
    public int getSize(){
	return q.size();
    }
    public boolean isEmpty(){
	return (q.isEmpty());
    }
    public char getFirstElement(){
	return q.get(0);
    }
    
}

