import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class CollectionsBasics {

	public static void main(String args[]){
		Product door = new Product("Door",50);
		Product window = new Product("Window",15);
		Product brick = new Product("Brick", 5);
		List<Product> products = new ArrayList<>();
		products.add(brick);
		products.add(window);
		products.add(door);
		List<Product> newProducts = new ArrayList<>();
		newProducts.add(door);
		newProducts.add(window);
		//Iterate using an iterator
		Iterator<Product> productIterator = products.iterator();
		while(productIterator.hasNext()){
			Product p = productIterator.next();
			System.out.println(p.getProductName() + " "+p.getProductWeight());
			if(p.getProductWeight() < 10){
				System.out.println(p.getProductName() + " has a weight less than 10 Kgs and will be deleted");
				productIterator.remove();
			}
		}
		
		//Iterate using a for each loop
		for(Product product: products){
			System.out.println(product.getProductName() + " "+product.getProductWeight());
			if(product.getProductName().equals("Door")){ //This will throw error because we cannot modify an arraylist while iterating using for each loop
				//System.out.println("Deleting door");
				//products.remove(door);
			}
			//products.add(brick); This will also give error
		}
		
		products.add(brick);
		for(Product product: products){
			System.out.println(product.toString());
		}
		products.removeAll(newProducts);
		for(Product product: products){
			System.out.println(product.toString());
		}
		
		int windowIndex=newProducts.indexOf(window);
		System.out.println("Index: "+windowIndex);
		for (Product product: newProducts){
			System.out.println(product.toString());
		}
		
		newProducts.set(1, brick);
		for (Product product: newProducts){
			System.out.println(product.getProductName());
			System.out.println(product.toString());

		}
		System.out.println(newProducts.contains(door));
		products.add(door);
		products.add(window);
		
		System.out.println("*****************Trying to sort*************************");
		for(Product product: products){
			System.out.println(product.getProductWeight());
		}
		Collections.sort(products, new ProductComparator());
		for(Product product: products){
			System.out.println(product.getProductWeight());
		}
		
		System.out.println("*****************Trying to sort in reverse*************************");
		Collections.sort(products, new ReverseComparator<>(new ProductComparator()));
		for(Product product: products){
			System.out.println(product.getProductWeight());
		}
		
		System.out.println("*****************Get the minimum weight product*************************");
		Product p = (Product) min(products, new ProductComparator());
		System.out.println(p.getProductName());
		
		System.out.println("*****************Get the minimum weight product*************************");
		Product p1 = minGeneric(products, new ProductComparator());
		System.out.println(p1.getProductName());
		
		List<Integer> str = new ArrayList<>();
		str.add(100);
		str.add(200);
		Integer s = minGeneric(str, new IntegerComparator());
		System.out.println(s);
	}

	private static Object min(List products, Comparator productComparator) {
		// TODO Auto-generated method stub
		if(products.isEmpty()){
			throw new IllegalStateException("List is empty");
		}
		else{
		Object res = products.get(0);
		for(Object p:products){
			if(productComparator.compare(res, p)>0){
				res=p;
			}
		}
		return res;}
	}
	
	private static<T> T minGeneric(List<T> products, Comparator<T> productComparator) {
		// TODO Auto-generated method stub
		if(products.isEmpty()){
			throw new IllegalStateException("List is empty");
		}
		else{
		T res = products.get(0);
		for(T p:products){
			if(productComparator.compare(res, p)>0){
				res=p;
			}
		}
		return res;}
	}
}
