package patterns.creational.singleton;

// Double-Locking
public class SingletonSynchronized {

    private static volatile SingletonSynchronized instance;
    private final String _data;

    private SingletonSynchronized(String value) {
        _data = value;
    }

    public static SingletonSynchronized getInstance(String value) {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized(value);
                }
            }
        }
        return instance;
    }

    public String getData() {
        return _data;
    }
}
