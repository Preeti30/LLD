package storage;

import algorithms.DoublyLinkedListNode;
import exception.NotFoundException;
import exception.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity)
    {
        this.capacity = capacity;
        storage = new HashMap<>();
    }

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        if(storageNotFull())
        {
            System.out.println("Storage is full");
        }
        storage.put(key, value);
    }

    private boolean storageNotFull() {
        if(storage.size() == capacity)
        {
            return true;
        }
        return false;
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        if(!storage.containsKey(key))
        {
            System.out.println("Storage donot have key");
            throw new NotFoundException("Storage donot have key");
        }
        return storage.get(key);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        if(!storage.containsKey(key))
        {
            System.out.println("Storage donot have key");
        }
        storage.remove(key);

    }


}
