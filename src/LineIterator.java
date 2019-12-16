import java.util.ArrayList;
import java.util.Iterator;
//ITERATOR PATTERN
public class LineIterator implements Iterator {
    private ArrayList<Object> objects;
    private int index = 0;

    public LineIterator(){
        objects = new ArrayList<Object>();
    }

    public void add(Object e) {
        objects.add(e);
    }

    @Override
    public boolean hasNext() {
        return ((objects.size() - index) != 0); //TODO change the logic for default arraylist size, size can be 10 and list can be empty
    }

    @Override
    public Object next() {
        Object obj = objects.get(index);
        index++;
        return obj;
    }
}
