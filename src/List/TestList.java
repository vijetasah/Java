package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestList {
public static void main(String args[]){
	List<String> lst = new ArrayList<>();
	lst.add("abc");
	lst.add("def");
	System.out.println(lst);
	ListIterator<String> i = lst.listIterator();
	while(i.hasNext()){
		((ListIterator<String>) i).set(i.next()+"88");
	}
	System.out.println(lst);
}
}
