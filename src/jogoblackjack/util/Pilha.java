package jogoblackjack.util;

public class Pilha implements IStack {

    private Node top;

    @Override
    public void push(Object data) {
        Node temp = top;
        top = new Node(data);
        top.setNext(temp);
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
            Object temp = top.getData();
            top = top.getNext();
            return temp;
        }
        return null;
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return top.getData();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

}
