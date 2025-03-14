package pattern.singleton;

public class SingletonSyncronized {

    private static volatile SingletonSyncronized instance;
    private final String _data;

    private SingletonSyncronized(String value) {
        _data = value;
    }

    public static SingletonSyncronized getInstance(String value) {
        if (instance == null) {
            synchronized (SingletonSyncronized.class) {
                if (instance == null) {
                    instance = new SingletonSyncronized(value);
                }
            }
        }
        return instance;
    }

    public String getData() {
        return _data;
    }
}
