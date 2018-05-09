package jogoblackjack.util;

public interface Ilist{
    
    public void addFirst(Object data);
    
    public void addLast(Object data);
    
    public Object removeFirst(Object data);
    
    public Object removeLast(Object data);    
    
    public void set(int index, Object data);
    
    public Object get(int index);
    
    public boolean contains(Object obj); 
    
    public int size();
    
    public boolean isEmpty();
    
    public Iterator iterator();
    
} 