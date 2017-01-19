import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T>{
	private Comparator<T> proxyComparator;
	public  ReverseComparator(Comparator<T> c) {
		// TODO Auto-generated constructor stub
		this.proxyComparator=c;
				
	}
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return -1*proxyComparator.compare(o1, o2);
	}

}
