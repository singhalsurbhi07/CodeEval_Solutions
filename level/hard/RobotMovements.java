public class Main{

    
    
 
    
    public static  int no_of_paths(int [][]grid,int size,int current_row,int current_col,int total){
	//System.out.println(current_row+" "+current_col+" "+total);
	if((current_row == size-1)&&(current_col == size-1)){
	    total += 1;
	    //System.out.println("------"+total);
	    return total;
	}
	if (is_left_valid(current_col,size)){
	    if(grid[current_row][current_col-1]==0){
		grid[current_row][current_col-1]=1;
		total = no_of_paths(grid,size,current_row,current_col-1,total);
		grid[current_row][current_col-1]=0;
		
	    }
	    
	}else{
	    //System.out.println("left not poss");
	}
	if (is_right_valid(current_col,size)){
	    if(grid[current_row][current_col+1]==0){
		grid[current_row][current_col+1]=1;
		total = no_of_paths(grid,size,current_row,current_col+1,total);
		grid[current_row][current_col+1]=0;
		
	    }
	    
	}else{
	    //System.out.println("right not poss");
	}
	
	if (is_Up_valid(current_row,size)){
	    if(grid[current_row-1][current_col]==0){
		grid[current_row-1][current_col]=1;
		total = no_of_paths(grid,size,current_row-1,current_col,total);
		grid[current_row-1][current_col]=0;
		
	    }
	    
	}else{
	    //System.out.println("Up not poss");
	}
	
	if (is_Down_valid(current_row,size)){
	    if(grid[current_row+1][current_col]==0){
		grid[current_row+1][current_col]=1;
		total = no_of_paths(grid,size,current_row+1,current_col,total);
		grid[current_row+1][current_col]=0;
		
	    }
	    
	}else{
	    //System.out.println("down not poss");
	}
	
	
	return total;
    }
    
    public static boolean is_left_valid(int current_col,int size){
	if(current_col == 0){
	    return false;
	}else{
	    return true;
	}
	    
    }
    
    public static boolean is_right_valid(int current_col,int size){
	if(current_col == size-1){
	    return false;
	}else{
	    return true;
	}
	    
    }
    
    public static boolean is_Up_valid(int current_row,int size){
	if(current_row == 0){
	    return false;
	}else{
	    return true;
	}
	    
    }
    
    public static boolean is_Down_valid(int current_row,int size){
	if(current_row == size-1){
	    return false;
	}else{
	    return true;
	}
	    
    }
    
    public static void main(String [] args){
	//Robot r = new Robot(4);
	int size=4;
    int [][] surface=new int [4][4];
    for (int i=0;i<size;i++){
	    for(int j=0;j<size;j++){
		if((i==0)&&(j==0)){
		    surface[i][j]=1;
		}else{
		    surface[i][j]=0;
		}
	    }
	}
	int result = no_of_paths(surface, size, 0, 0,0);
	System.out.println(result);
    }
    
    
    
}



