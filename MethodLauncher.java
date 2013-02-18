import java.util.List;
import java.util.ArrayList;

public class MethodLauncher {

	public static void main(String[] args) {
		MethodLauncher launcher = new MethodLauncher();
		launcher.launch();
	}
	
	public void launch() {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0 ; i<1000 ; i++) {
			list.add((int)(Math.abs(50 * Math.random())));
		}
		
		RecursiveMethods.mergeSort(list);
		
		for(Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
		if(RecursiveMethods.binarySearch(list, 42)) {
			System.out.println("42 is present");
		} else {
			System.out.println("42 is not present");
		}
	}
}
