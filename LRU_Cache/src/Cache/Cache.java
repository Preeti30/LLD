package Cache;

import exception.NotFoundException;
import exception.StorageFullException;
import policies.EvictionPolicy;
import storage.Storage;

public class Cache <Key, Value>{

    private final Storage<Key, Value> storage;
    private final EvictionPolicy<Key> evictionPolicy;
    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy )
    {
            this.storage = storage;
            this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value) throws NotFoundException {
        try
        {
            this.storage.add(key, value);
            this.evictionPolicy.KeyAccessed(key);
        }
        catch(StorageFullException storageFullException)
        {
            System.out.println("Storage is full, need to evict");
            Key evictKey = evictionPolicy.evictKey();
            if(evictKey == null)
                System.out.println("No key to evict");
            this.storage.remove(evictKey) ;
            put(key, value);
        }
    }

    public Value get(Key key) throws NotFoundException {
        try
        {
            Value value = storage.get(key);
            this.evictionPolicy.KeyAccessed(key);
            return value;
        }
        catch (NotFoundException notFoundException){
            System.out.println("Key is not here");

        }
        return null;
    }

    public void showCurrentCache()
    {
        evictionPolicy.show();
    }
}
