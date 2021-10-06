public class CircularList<T> {
    static int count = -1;
    T[] elements;

    public CircularList(final T... elements) {
        if (elements.length == 0){
            throw new IllegalArgumentException();
        }
        this.elements = elements;
    }

    T next() {
        count++;
        if (count > elements.length - 1){
            count = 0;
        }
        T element = elements[count];
        return element;
    }

    T prev() {
        count--;
        if (count < 0){
            count = elements.length - 1;
        }
        T element = elements[count];
        return element;
    }
}
