package policies;

import algorithms.DoublyLinkedList;
import algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

    DoublyLinkedList<Key> dll;
    Map<Key, DoublyLinkedListNode<Key>> mapper;

    public LRUEvictionPolicy()
    {
        this.dll = new DoublyLinkedList<>();
        this.mapper = new HashMap<>();
    }
    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> evictNode = dll.getFirstNode();
        if(evictNode==null)
            return null;
        dll.detachNode(evictNode);
        return evictNode.getElement();
    }

    @Override
    public void KeyAccessed(Key key) {
        if(mapper.containsKey(key))
        {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        }
        else
        {
            DoublyLinkedListNode<Key> newNode = new DoublyLinkedListNode<Key>(key);
            mapper.put(key, newNode);
            dll.addNodeAtLast(newNode);
        }
    }

    @Override
    public void show()
    {
        dll.traverseLL();


    }

}
