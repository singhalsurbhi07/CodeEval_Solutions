import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    
    public static void findAncestors(String fileName,Node root) throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader(fileName));
	String line;
	while((line = reader.readLine())!=null){
	    String [] temp = line.split(" ");
	    int node1 = Integer.parseInt(temp[0]);
	    int node2 = Integer.parseInt(temp[1]);
	    Node result = findLeastCommonAncestor(root,node1,node2);
	    if(result != null){
		System.out.println(result.data);
	    }
	    
	}
    }
    
    public static Node findLeastCommonAncestor(Node root,int node1,int node2){
	if(root == null){
	    return null;
	}
	int data = root.data;
	if(((node1< data) && (node2 > data))||((node1 > data) && (node2 < data))){
	    return root;
	}else{
	    //Node result;
	    if((node1 > data) && (node2 > data)){
		return findLeastCommonAncestor(root.right, node1, node2);
	    }else if((node1 < data) && (node2 < data)){
		return findLeastCommonAncestor(root.left, node1, node2);
	    }else{
		return root;
	    }
	    
	}
	//return null;
	
    }
    
    public static void main(String [] args) throws IOException{
	String fileName  = args[0];
	Node first = new Node (30);
	Node second = new Node(8);
	Node third = new Node(52);
	Node fourth = new Node(3);
	Node fifth = new Node(20);
	Node sixth = new Node (10);
	Node seventh = new Node (29);
	first.left = second;
	first.right = third;
	second.left = fourth;
	second.right = fifth;
	fifth.left = sixth;
	fifth.right = seventh;
	findAncestors(fileName,first);
	
	
    }

    
    
}

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
	    this.data = data;
	    this.left = null;
	    this.right = null;
	}
}

