package jogoblackjack.util;

public interface Ilist{
    
    public void addFirst(Object data);
    
    public void addLast(Object data);
    
    public Object removeFirst();
    
    public Object removeLast();    
 
    public int size();
    
    public boolean isEmpty();
    
    public Iterator iterator();
    
} 