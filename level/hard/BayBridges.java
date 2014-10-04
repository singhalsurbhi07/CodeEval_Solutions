import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private int id;
    private float x1;
    private float y1;
    private float x2;
    private float y2;
    private static List<Main> bridgeList = new ArrayList<>();
    private static Map<Integer, List<Integer>> outputMap = new HashMap<>();
    private static List<Integer> finalOut = new ArrayList<>();

    public Main(int id, float x1, float x2, float y1, float y2) {
	this.id = id;
	this.x1 = x1;
	this.x2 = x2;
	this.y1 = y1;
	this.y2 = y2;
    }

    public float getX1() {
	return x1;
    }

    public void setX1(float x1) {
	this.x1 = x1;
    }

    public float getY1() {
	return y1;
    }

    public void setY1(float y1) {
	this.y1 = y1;
    }

    public float getX2() {
	return x2;
    }

    public void setX2(float x2) {
	this.x2 = x2;
    }

    public float getY2() {
	return y2;
    }

    public void setY2(float y2) {
	this.y2 = y2;
    }

 
    private List<Float> getLineCoefficients(Main bridge) {
	List<Float> temp = new ArrayList<>();
	temp.add(bridge.getY2() - bridge.getY1());
	temp.add(bridge.getX1() - bridge.getX2());
	temp.add(temp.get(0) * bridge.getX1() + temp.get(1) * bridge.getY1());
	return temp;
    }

    private boolean liesInBetween(float par1, float par2, double valTocheck) {
	if (par1 > par2) {
	    if ((par1 > valTocheck) && (valTocheck > par2)) {
		// System.out.println("par 1 > valtoCheck <par2 ");
		return true;
	    }
	} else {
	    // System.out.println("par 1 <valtoCheck <par2 ");
	    if ((par2 > valTocheck) && (valTocheck > par1)) {
		return true;
	    }
	}
	return false;
    }

    private boolean isParallel(Main bridge) {
	List<Float> firstBridgeList = getLineCoefficients(this);
	List<Float> secondBridgeList = getLineCoefficients(bridge);
	double det = firstBridgeList.get(0) * secondBridgeList.get(1) - secondBridgeList.get(0)
		* firstBridgeList.get(1);
	if (det == 0) {
	    return true;
	} else {
	    double x = (secondBridgeList.get(1) * firstBridgeList.get(2) - firstBridgeList.get(1)
		    * secondBridgeList.get(2))
		    / det;
	    double y = (firstBridgeList.get(0) * secondBridgeList.get(2) - secondBridgeList.get(0)
		    * firstBridgeList.get(2))
		    / det;
	    // System.out.println(x + "  " + y);
	    if ((x == this.getX1() && y == this.getY1())
		    || (x == bridge.getX1() && y == bridge.getY1())
		    || (x == this.getX2() && y == this.getY2())
		    || (x == bridge.getX2() && y == bridge.getY2())) {
		return true;
	    }
	    if (liesInBetween(this.getX1(), this.getX2(), x)
		    && (liesInBetween(this.getY1(), this.getY2(), y)
			    && liesInBetween(bridge.getX1(), bridge.getX2(), x) && liesInBetween(
				bridge.getY1(), bridge.getY2(), y))) {
		return false;
	    }

	}
	return true;
    }

    private static List<Float> getInput(String str) {
	List<Float> input = new ArrayList<>();
	StringBuilder s = new StringBuilder();
	for (int i = 0; i < str.length(); i++) {
	    if (!(str.charAt(i) == ' ' || str.charAt(i) == '[' || str.charAt(i) == ']'
		    || str.charAt(i) == '(' || str.charAt(i) == ')')) {
		s.append(str.charAt(i));

	    }
	}
	String[] temp = s.toString().split(",");
	for (String eachStr : temp) {
	    float num = Float.parseFloat(eachStr);
	    input.add(num);
	}

	return input;
    }

    private static void sort(List<Integer> list) {
	for (int i = 0; i < list.size() - 1; i++) {
	    for (int j = i + 1; j < list.size(); j++) {
		if (list.get(i) > list.get(j)) {
		    // System.out.println("Reached here" + list.get(i) +
		    // list.get(j));
		    int temp = list.get(i);
		    list.set(i, list.get(j));
		    list.set(j, temp);
		}
	    }
	}
    }

    public int getId() {
	return id;
    }

    public static void readInput(String filename) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader(filename));
	String line;
	while ((line = br.readLine()) != null) {
	    String[] temp = line.split(":");
	    int id = Integer.parseInt(temp[0]);
	    List<Float> input = getInput(temp[1]);
	    Main b = new Main(id, input.get(0), input.get(2), input.get(1), input.get(3));
	    bridgeList.add(b);
	}
	br.close();
    }

    public static void main(String[] args) throws IOException {
	readInput(args[0]);
	for (int i = 0; i < bridgeList.size(); i++) {
	    List<Integer> temp = new ArrayList<>();
	    for (int j = 0; j < bridgeList.size(); j++) {
		// boolean flag = true;
		// System.out.println(i + " " + j);
		if (i != j) {
		    if (!bridgeList.get(i).isParallel(bridgeList.get(j))) {
			// System.out.println(bridgeList.get(j).getId() +
			// "goes to temp list ");
			temp.add(bridgeList.get(j).getId());
		    }
		}
	    }
	    if (temp.isEmpty()) {
		// System.out.println(bridgeList.get(i).getId() +
		// " goes in finalOut List");
		finalOut.add(bridgeList.get(i).getId());
	    } else {
		// System.out.println(bridgeList.get(i).getId() +
		// " goes in OutputMap");
		outputMap.put(bridgeList.get(i).getId(), temp);
	    }

	}

	while (!outputMap.isEmpty()) {
	    // System.out.println("Map not empty");
	    // Set<Integer> keeeys = outputMap.keySet();
	    // for (int eachkey : keeeys) {
	    // System.out.println(eachkey);
	    // List<Integer> keysList = outputMap.get(eachkey);
	    // for (int i = 0; i < keysList.size(); i++) {
	    // System.out.println(keysList.get(i));
	    // }
	    // }
	    @SuppressWarnings("unchecked")
	    Set<Integer> keys = outputMap.keySet();
	    int max = 0;
	    int maxCollideId = 0;
	    for (Integer num : keys) {
		// System.out.println("num=" + num);
		// for (int i = 0; i < outputMap.get(num).size(); i++) {
		// System.out.print(outputMap.get(num).get(i) + " ");
		// }
		int tempMax = outputMap.get(num).size();
		if (tempMax > max) {
		    max = tempMax;
		    maxCollideId = num;
		}
	    }
	    // System.out.println("MaxCollide=" + maxCollideId);
	    outputMap.remove(maxCollideId);
	    @SuppressWarnings("unchecked")
	    Set<Integer> newkeys = outputMap.keySet();
	    List<Integer> tempList = new ArrayList<>();
	    for (Integer num : newkeys) {
		// System.out.println("Num-->>>" + num);
		// for (int i = 0; i < outputMap.get(num).size(); i++) {
		// System.out.print(outputMap.get(num).get(i) + " ");
		// }
		// System.out.println(num);
		if (outputMap.get(num).contains(maxCollideId)) {
		    // System.out.println("MaxCollide is there in" + num);
		    outputMap.get(num).remove(outputMap.get(num).indexOf(maxCollideId));
		    if (outputMap.get(num).isEmpty()) {
			// outputMap.remove(num);
			tempList.add(num);
			// System.out.println("Adding " + num + " yo finalOut");
			// finalOut.add(num);

		    }
		}

	    }
	    for (int i = 0; i < tempList.size(); i++) {
		int var = tempList.get(i);
		// System.out.println("Adding " + var + " yo finalOut");
		finalOut.add(var);
		outputMap.remove(var);
	    }
	    // System.out.println("Raeched at the end of while");

	}
	// System.out.println("Out of while");
	sort(finalOut);
	for (int i = 0; i < finalOut.size(); i++) {
	    System.out.println(finalOut.get(i));
	}
	System.exit(0);

    }
}

