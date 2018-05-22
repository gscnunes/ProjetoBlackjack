package jogoblackjack.util;

public class LinkedList implements Ilist {

    private Node head;
    private int totalDeElementos;

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setO(Object data) {
            this.data = data;
        }
    }
    
    
    
    
    
    public class MyIterator implements Iterator {

    private Node temp;

    public MyIterator(Node head) {
        this.temp = head;
    }

    @Override
    public boolean hasNext() {
        return temp != null;
    }

    @Override
    public Object next() {
        Object aux = temp.getData();
        temp = temp.getNext();
        return aux;
    }

}
    
    
    
    

    @Override
    public void addFirst(Object data) {
        Node nova = head;
        head = new Node(data);
        head.setNext(nova);
        this.totalDeElementos++;
    }

    @Override
    public void addLast(Object data) {
        if (isEmpty()) {
            addFirst(data);
        } else {
            Node n = getNode(size() - 1);
            n.setNext(new Node(data));
            totalDeElementos++;
        }
    }

    @Override
    public Object removeFirst() {
        Object p = this.head.getData();
        this.head = this.head.getNext();
        this.totalDeElementos--;

        return p;
    }

    @Override
    public Object removeLast() {
        Node n = this.head;
        Node ant = this.head;
        while (n.getNext() != null) {
            ant = n;
            n = n.getNext();
        }
        Object p = n.getData();
        ant.setNext(null);
        this.totalDeElementos--;
        return p;
    }

    @Override
    public int size() {
        return this.totalDeElementos;
    }

    @Override
    public boolean isEmpty() {
        return this.totalDeElementos == 0;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(head);
    }

    //Método para retornar um determinado Node a partir de uma posição 
    private Node getNode(int index) {
        if (index >= 0 && index < size()) {
            Node n = this.head;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n;
        }
        return null;
    }
}
