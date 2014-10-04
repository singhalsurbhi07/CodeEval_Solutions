import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void readInput(String fileName) throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	String line;
	while((line = reader.readLine())!=null){
	    changeToRollerCoster(line);
	}
    }
    
    public static void changeToRollerCoster(String line){
	StringBuilder res = new StringBuilder();
	boolean isCap = false;
	int inputLen = line.length();
	int i=0;
	while(i<inputLen){
	    char ch = line.charAt(i);
	    if(Character.isLetter(ch)){
		if(!isCap){
		    res.append(Character.toUpperCase(ch));
		    
		}else{
		    res.append(Character.toLowerCase(ch));
		}
		isCap = (!isCap);
	    }else{
		res.append(ch);
	    }
	    i+=1;
	}
	System.out.println(res.toString());
    }
    public static void main(String [] args) throws IOException{
	readInput(args[0]);
    }
}

