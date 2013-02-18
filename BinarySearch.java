import java.util.List;

@SupressWarnings("all")
public class BinarySearch {
	public static <T extends Comparable> boolean search(List<T> list, T elt) {
		if(list.size() == 0) {
			return false;
		}
		switch (elt.compareTo(list.get(list.size()/2))) {
			case -1: if(list.size() == 1) { 
					return false; // to avoid possible IndexOutOfBoundsException below
				 } else {	
				 	 return search(list.sublist(0,(list.size()/2)-1), elt);
				 }
				break;
				
			case 0: return true;
				break;
				
			case 1: if(list.size() == 1) { 
					return false; // to avoid possible IndexOutOfBoundsException below
				 } else {	
				 	 return search(list.sublist((list.size()/2)+1,list.size()-1), elt);
				 }
				break;
		}
		return false;  // for the compiler
	}
}