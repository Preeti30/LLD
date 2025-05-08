package storage;

import exception.NotFoundException;
import exception.StorageFullException;

public interface Storage<Key, Value> {

    public void add(Key key, Value value ) throws StorageFullException;
    public Value get(Key key) throws NotFoundException;
    void remove(Key key) throws NotFoundException;
}
