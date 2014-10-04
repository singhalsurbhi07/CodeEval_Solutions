import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	static int numOfDoors;
	static int numOfAttempts;
	
	public static void readInput(String filename) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		while((line = br.readLine())!=null){
			int count =1;
			String [] temp = line.split(" ");
			numOfDoors = Integer.parseInt(temp[0]);
			numOfAttempts = Integer.parseInt(temp[1]);
			findNumOfDoorsUnlocked(numOfDoors,numOfAttempts);
			
			
		}
	}
	
	public static void findNumOfDoorsUnlocked(int doors,int attempts){
		boolean [] unlocked = new boolean[doors];
		for(int i=0;i<doors;i++){
			unlocked[i]=true;
		}
		for (int i=1;i<attempts;i++){
			int k = 2;
			while(k<=3){
				for(int j=1;j*k<=doors;j=j+1){
					int ind = j*k;
					if(k==2){
						unlocked[ind-1]=false;
					}else{
						if(unlocked[ind-1]==true){
							unlocked[ind-1]=false;
						}else{
						unlocked[ind-1]=true;
						}
					}
				}
				k+=1;
			}
		}
		if(unlocked[doors-1]==true){
			unlocked[doors-1] = false;
		}else{
			unlocked[doors-1]=true;
		}
		int count=0;
		for(int i=0;i<doors;i=i+1){
			if(unlocked[i]==true){
				count+=1;
			}
		}
		System.out.println(count);
	}
	
	public static void main(String [] args) throws IOException{
		readInput(args[0]);
	}
}

