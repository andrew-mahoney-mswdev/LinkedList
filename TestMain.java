import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		LinkedList<Integer> myList = new LinkedList<Integer>();

		myList.add(1);
		myList.add(0);
		myList.add(100);
		myList.add(101);
		myList.add(42);

		for (Integer i : myList) {
			System.out.println(i);
		}
	}

}
