package factory;
import Cache.Cache;

import policies.EvictionPolicy;
import policies.LRUEvictionPolicy;
import storage.HashMapBasedStorage;
import storage.Storage;

public class CacheFactory <Key, Value>{

    private static CacheFactory<?, ?> instance;

    private  CacheFactory(){}
    public static synchronized <Key, Value>CacheFactory<Key, Value> getInstance()
    {
        if(instance==null)
        {
            instance = new CacheFactory<>();
        }
        return (CacheFactory<Key, Value>) instance;
    }

    public  Cache<Key, Value> getCacheObject(final int capacity)
    {
        return new Cache<Key, Value>(new HashMapBasedStorage<Key, Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
