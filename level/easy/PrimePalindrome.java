public class Main {
    public static void findPrimePalindrome(int number){
	while(number>0){
	    if(isPalindrome(number) && (isPrime(number))){
		System.out.println(number);
		break;
	    }
	    number -= 1;
	}
	
    }
    
    public static boolean isPalindrome(int number){
	int orgNumber = number;
	int multiplier =10;
	int res = 0;
	while (number>0){
	    int last = number %multiplier;
	    res = (res*multiplier)+last;
	    number /= multiplier;
	    
	    
	}
	//System.out.println(res);
	if(res == orgNumber){
	    //System.out.println("no is palindroe");
	    return true;
	}
	return false;
    }
    
    public static boolean isPrime(int number){
	if((number % 2)==0){
	    return false;
	}
	for(int i=3;i<= Math.sqrt(number);i++){
	    if((number%i)==0){
		return false;
	    }
	}
	return true;
    }
    public static void main(String [] args){
	int n =1000;
	findPrimePalindrome(n);
    }
}

