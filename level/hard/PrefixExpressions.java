import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    
    public static void readInput(String fileName) throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	String line;
	while((line = reader.readLine())!=null){
	     String [] elements = line.split(" ");
	     float res = evaluate(elements);
	     if(res != -1){
		 System.out.println(Math.round(res));
	     }
	}
    }
    
    public static float evaluate(String [] elements){
	Stack<Float> stack = new Stack<>();
	for(int i=(elements.length)-1;i>=0;i--){
	    String ch = elements[i];
	    //System.out.println(ch);
	    if(!((ch.equals("+"))||(ch.equals("*"))||(ch.equals("/")))){
		Float number = Float.parseFloat(ch);
		stack.push(number);
	    }else{
		Float popItem1 = stack.pop();
		Float popItem2 = stack.pop();
		char [] opArray = ch.toCharArray();
		char operator = opArray[0];
		switch (operator){
		
		case '+':stack.push(popItem1+popItem2);
			break;
		case '*':stack.push(popItem1*popItem2);
			break;
		case '/':stack.push(popItem1/popItem2);
			break;
		default: break;
		
		}
	    }
	}
	if(stack.size()==1){
	    return stack.pop();
	}else{
	    return -1;
	}
    }
    
    public static void main(String [] args) throws IOException{
	String fileName = args[0];
	readInput(fileName);
    }

}

