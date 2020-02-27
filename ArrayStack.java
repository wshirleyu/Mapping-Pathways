public class ArrayStack<T> implements ArrayStackADT<T> {
	private T[] stack; // store the data items of the stack
	private int top; // stores the position of the last data item in the stack; -1 = empty
	private int initialCapacity; // this is the initial size of the array stack.
	private int sizeIncrease; // the size of the array will increase by this amount
	private int sizeDecrease;

	public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
		// Creates an empty stack using an array of length equal to the value of the
		// first parameter
		stack = (T[]) (new Object[initialCap]);
		initialCapacity = initialCap;
		sizeIncrease = sizeInc;
		sizeDecrease = sizeDec;
		top = -1;
	}

	private void expandCapacity(int sizeIncrease) {
		T[] larger = (T[]) (new Object[stack.length + sizeIncrease]);
		for (int i = 0; i < stack.length; i++)
			larger[i] = stack[i];

		stack = larger;
	}

	private void shrinkCapacity(int sizeDecrease) {
		T[] smaller = (T[]) (new Object[stack.length - sizeDecrease]);
		for (int i = 0; i < stack.length; i++)
			smaller[i] = stack[i];

		stack = smaller;

	}

	public void push(T dataItem) {
		// Adds dataItem to the top of the stack and updates the value of top
		if (size() == stack.length) {
			expandCapacity(sizeIncrease);
		}
		top++;
		stack[top] = dataItem;
	}

	public T pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Empty stack");
		if (top < (0.25 * stack.length) && stack.length > initialCapacity) {
			shrinkCapacity(sizeDecrease);
		}
		T topItem = stack[top];
		stack[top] = null;
		top--;
		return topItem;

	}

	public T peek() throws EmptyStackException {
		// Returns the data item at the top of the stack without removing it
		if (isEmpty())
			throw new EmptyStackException("Empty stack");
		return stack[top];
	}

	public boolean isEmpty() {
		// Returns true if the stack is empty and it returns false otherwise.
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		// Returns the number of data items in the stack.
		return top + 1;
	}

	public int length() {
		// Returns the length or capacity of the array stack
		return stack.length;
	}

	public String toString() {
		// Returns a String representation of the stack of the form:
		String stackString = "Stack: ";
		for (int i = 0; i <= top; i++) {
			stackString += stack[i] + ", ";
		}
		return stackString;
	}

}
