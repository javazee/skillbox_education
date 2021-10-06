
public class Main {
    public static void main(String[] args) {
        CircularList circularList = new CircularList(1, 2, 3, 4, 5);
        System.out.println(circularList.prev());
        System.out.println(circularList.prev());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.prev());
        System.out.println(circularList.prev());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
        System.out.println(circularList.next());
    }
}

