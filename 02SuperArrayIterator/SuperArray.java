import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArray implements Iterable<String>{
	private String[] data;
	private int size;
	private int capacity;

	public SuperArray() {
		size = 0;
		capacity = 10;
		data = new String[10];
	}

	public SuperArray(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}
		size = 0;
		capacity = initialCapacity;
		data = new String[initialCapacity];
	}

	public int size() {
		return size;
	}

	public boolean add(String element) {
		if (size < capacity) {
			data[size] = element;
			size += 1;
		} else {
			grow();
			add(element);
		}
		return true;
	}

	public void add(int index, String element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (size >= capacity) {
			grow();
		}
		String[] copy = new String[capacity];
		for (int i = 0; i < size; i++) {
			copy[i] = data[i];
		}
		data[index] = element;
		size += 1;
		for (int i = index + 1; i < size; i++) {
			data[i] = copy[i - 1];
		}
	}

	public String remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		String value = data[index];
		size -= 1;
		for (int i = index + 1; i < size; i++) {
			data[i] = data[i + 1];
		}
		return value;
	}

	public String get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}

	public void grow() {
		capacity = data.length * 2 + 1;
		String[] temp = new String[capacity];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public void clear() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public String set(int index, String element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}
		String value = data[index];
		data[index] = element;
		return value;
	}

	public String toString() {
		String result = "[ ";
		if (size == 0) {
			return "[]";
		}
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				result += ", " + data[i] +  "]";
			} else if (i == 0){
				result += data[i];
			} else {
				result += ", " + data[i];
			}
		}
		return result;
	}

	public String toStringDebug() {
		String result = "[ ";
		for (int i = 0; i < capacity; i++) {
			if (i < size) {
				if (i == capacity - 1) {
					result += data[i] + "]";
				} else {
					result += data[i]+ ", ";
				}
			} else {
				if (i == size) {
					result += "_";
				} else if (i == capacity - 1) {
					result += ", _]";
				} else {
					result += ", _";
				}
			}
		}
		return result;
	}

	public String[] toArray() {
		String[] result = new String[data.length];
		for (int i = 0; i < data.length; i++) {
			result[i] = data[i];
		}
		return result;
	}

	public int indexOf(String element) {
		int index = -1;
		for (int i = 0; i < size; i++) {
			if (data[i] == element) {
				index = i;
				return index;
			}
		}
		return index;
	}

	public int lastIndexOf(String element) {
		int index = -1;
		for (int i = size - 1; i > -1; i--) {
			if (data[i] == element) {
				index = i;
				return index;
			}
		}
		return index;
	}

	public void trimToSize() {
		String[] temp = new String[size()];
		for (int i = 0; i < size(); i++) {
			temp[i] = data[i];
		}
		data = temp;
		size = data.length;
	}

	public Iterator<String> iterator(){
		return new SuperArrayIterator(this);
    }
}
