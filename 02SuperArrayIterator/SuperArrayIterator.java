import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String> {
    private SuperArray array;
    private int pos;

    public SuperArrayIterator(SuperArray data) {
	array = data;
	pos = 0;
    }

    public boolean hasNext() {
	return pos < array.size();
    }

    public String next() {
	if (hasNext()) {
	    pos++;
	    return array.get(pos - 1);
	}
	else {
	    throw new NoSuchElementException();
	}
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }
    
}