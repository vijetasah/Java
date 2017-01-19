import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {

	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return Integer.compare(p1.getProductWeight(), p2.getProductWeight());
	}

}
