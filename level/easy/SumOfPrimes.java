
public class Main {
	static int number = 1000;
	static boolean [] output;
	
	public static void  findSumofprimes(){
		int count =2;
		int sum = 5;
		int i=5;
		boolean isPrime = true;
		while(count < number){
			for(int j=3;j*j<=i ;j=j+1){
				isPrime = true;
				if(i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				count+=1;
				sum+=i;
			}
			i=i+2;
		}
		System.out.println(sum);
		
		
	}
	
	public static void main(String [] args){
		findSumofprimes();
	}
}
