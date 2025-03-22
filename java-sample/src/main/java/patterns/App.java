package patterns;

import patterns.creational.singleton.SingletonHolder;

public class App {
    public static void main(String[] args) {
        runSingletonSync();
        //runSingletonHolder();
    }

    public static void runSingletonSync() {
        patterns.creational.singleton.SingletonSynchronized singleton = patterns.creational.singleton.SingletonSynchronized.getInstance("First instance!");
        System.out.println(STR."Show data: \{singleton.getData()}");
        patterns.creational.singleton.SingletonSynchronized anotherReference = patterns.creational.singleton.SingletonSynchronized.getInstance("Second instance?");
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
