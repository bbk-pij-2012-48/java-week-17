import java.util.List;
import java.util.ArrayList;

public class RecursiveMethods {

	public static <T extends Comparable<T>> boolean binarySearch(List<T> list, T elt) {
		if(list.size() == 0) {
			return false;
		}

		switch (elt.compareTo(list.get(list.size()/2))) {
			case -1: if(0 >= (list.size()/2)-1) { 
				return false; // to avoid possible IndexOutOfBoundsException below
		} else {	
			return binarySearch(list.subList(0,(list.size()/2)-1), elt);
		}

		case 0: return true;

		case 1: if((list.size()/2)+1 >= list.size()-1) { 
			return false; // to avoid possible IndexOutOfBoundsException below
		} else {	
			return binarySearch(list.subList((list.size()/2)+1,list.size()-1), elt);
		}
		}

		return false;  // for the compiler
	}
	
	public static <T extends Comparable<T>> List<T> mergeSort(List<T> list) {
		if(list.size() == 0 || list.size() == 1) {
			return list;
		}
		
		// Split the list in half(ish)
		List<T> lower = list.subList(0, (list.size()/2)-1);
		List<T> upper = list.subList((list.size()/2), list.size()-1);
		
		// Sort the sublists
		lower = mergeSort(lower);
		upper = mergeSort(upper);
		
		// Merge the sublists
		List<T> result = new ArrayList<T>();
		while(lower.size() > 0 && upper.size() > 0) {
			if(lower.get(0).compareTo(upper.get(0)) < 1) {
				result.add(lower.get(0));
				lower.remove(0);
			} else {
				result.add(upper.get(0));
				upper.remove(0);
			}
		}
		if(lower.size() != 0) {
			result.addAll(lower);
		} else {
			result.addAll(upper);
		}
		
		return result;
	}
	
}
