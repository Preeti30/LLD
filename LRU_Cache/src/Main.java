import Cache.Cache;
import exception.NotFoundException;
import factory.CacheFactory;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws NotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        CacheFactory<Integer, String> factory  = CacheFactory.getInstance();
        Cache<Integer, String> cache = factory.getCacheObject(30);
        cache.put(1, "One");
        cache.showCurrentCache();

        cache.put(2,"Two");
        cache.showCurrentCache();
        cache.put(3,"Three");
        cache.showCurrentCache();
        cache.get(1);
        cache.showCurrentCache();
        cache.get(3);
        cache.showCurrentCache();
        cache.get(30);
        cache.showCurrentCache();
    }
}