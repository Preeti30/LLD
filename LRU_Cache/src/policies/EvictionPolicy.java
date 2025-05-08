package policies;

public interface EvictionPolicy <Key>{

    Key evictKey();

    void KeyAccessed(Key key);

    void show();
}
