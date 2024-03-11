public class _02_StackImpl {
    public static void main(String[] args) {
        Stack_Array stk1 = new Stack_Array(5);

        testArrayStack(stk1);
    }

    
    private static void testArrayStack(Stack_Array stk1) {
        stk1.push(209);
        stk1.push(345);
        stk1.push(45);

        System.out.println("Top element of the array stack: " + stk1.peek());
        System.out.println("Is empty: " + stk1.isEmpty());
        System.out.println("Is full: " + stk1.isFull());

        stk1.push(24);
        stk1.push(25);
        stk1.push(25);

        System.out.println("Is full: " + stk1.isFull());

        stk1.pop();
        stk1.pop();
        stk1.pop();
        stk1.pop();
        stk1.pop();
        stk1.pop();
    }

}

class Stack_Array {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack_Array(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack overflow! " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed " + value);
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
            return -1;
        }
        int poppedElement = stackArray[top--];
        System.out.println("Popped " + poppedElement);
        return poppedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

}
