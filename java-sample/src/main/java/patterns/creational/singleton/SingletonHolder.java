package patterns.creational.singleton;

public final class SingletonHolder {
    private final String _data;

    private SingletonHolder() {
        _data = "Singleton data";
    }

    private static final class InstanceHolder {
        private static final SingletonHolder instance = new SingletonHolder();
    }

    public static SingletonHolder getInstance() {
        return InstanceHolder.instance;
    }

    public String getData() {
        return _data;
    }
}
