import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        check(list.size() == 0, "Empty list has size 0.", "Empty list should have size zero.");
        check(list.isEmpty(), "Empty list is empty.", "Empty list should be empty.");
        list.add("hello");
        check(list.size() == 1, "Adding first item makes size 1.", "Adding first item should update size.");
        check(!list.isEmpty(), "List with 1 item is not empty.", "List with 1 item should not be empty.");
        String tmp = list.get(0);
        check("hello".equals(tmp), "Can get first item from list.", "Should be able to get first item from list.");
        list.add("world");
        check(list.size() == 2, "Adding second item makes size 2.", "Adding second item should update size.");
        check(!list.isEmpty(), "List with 2 items is not empty.", "List with 2 items should definitely not be empty.");
        tmp = list.get(1);
        check("world".equals(tmp), "Can get second item from list.", "Should be able to get second item from list.");
        list.add("another");
        list.add("more");
        list.set(2, "different");
        tmp = list.get(2);
        check("different".equals(tmp), "Setting item updates value.", "Setting item 2 should update the value when retrieved later.");
    }

    private static void check(boolean ok, String correct, String incorrect) {
        if (ok)
            System.out.println(correct);
        else
            System.out.println(incorrect);
    }
}
