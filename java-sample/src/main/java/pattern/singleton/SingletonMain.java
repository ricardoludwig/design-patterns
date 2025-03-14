package pattern.singleton;

public class SingletonMain {
    public static void main(String[] args) {
        runSingletonSync();

        runSingletonHolder();
    }

    public static void runSingletonSync() {
        SingletonSyncronized singleton = SingletonSyncronized.getInstance("First instance!");
        System.out.println(STR."Show data: \{singleton.getData()}");
        SingletonSyncronized anotherReference = SingletonSyncronized.getInstance("Second instance?");
        System.out.println(STR."Show data from another reference: \{anotherReference.getData()}");
        System.out.println(STR."Is it the same instance? \{singleton == anotherReference}");
    }
    public static void runSingletonHolder() {
        SingletonHolder singleton = SingletonHolder.getInstance();
        System.out.println(STR."Show data: \{singleton.getData()}");
        SingletonHolder anotherReference = SingletonHolder.getInstance();
        System.out.println(STR."Show data from another reference: \{anotherReference.getData()}");
        System.out.println(STR."Is it the same instance? \{singleton == anotherReference}");
    }
}
