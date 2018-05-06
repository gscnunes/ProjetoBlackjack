package jogoblackjack.util;

public interface Ilist{
    public void add(Object data);
    
    public void set(int index, Object data);
    
    public Object get(int index);
    
    public boolean contains(Object obj);
    
    public void remove(int index);
    
    public void remove(Object data);
    
    public int size();
    
    public Iterator iterator();
    
} 