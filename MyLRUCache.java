// LRU Cache

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;


class MyLRUCache<K, V> // Lets make it a templatized
{
    private HashMap<K, V> hm;
    
    private LinkedList<K> ll;
    
    private int size;
    
    
    MyLRUCache(int size) {
        this.size = size;
        
        hm = new HashMap();
        ll = new LinkedList();
    }
    
    
    public V get(K key) {
        if (hm.containsKey(key)) {
            V val = hm.get(key);
            ll.remove(key);
            ll.addFirst(key);
            return val;
        }
        return null;
    }
    
    public void set(K key, V val) {
        hm.put(key, val);
        if (ll.size() == this.size) {
            ll.removeLast();
            ll.addFirst(key);
        }
        else {
            ll.addFirst(key);
        }
    
    }
    
    public void printLL() {
        System.out.println(ll.toString());
    }
    
    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println("Hello Rajesh");
        
        MyLRUCache<Integer, Integer> cache = new MyLRUCache(10);
        assert cache.get(6) == null;
        
        //3,4,5,9
        cache.set(6, 89);
        cache.set(3, 90);
        cache.set(4, 91);
        cache.set(5, 92);
        
        
        cache.printLL();
        
        assert cache.get(3) == 90;
        cache.printLL();
        
        assert cache.get(6) == 89;
        cache.printLL();
        
        
        
        
    }
}
