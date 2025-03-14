package pattern.singleton;

public class SingletonNaive {

    private static SingletonNaive instance;
    private final String _data;

    private SingletonNaive(String value) {
        _data = value;
    }

    public static SingletonNaive getInstance(String value) {
        if (instance == null) {
            instance = new SingletonNaive(value);
        }
        return instance;
    }

    public String getData() {
        return _data;
    }
}
