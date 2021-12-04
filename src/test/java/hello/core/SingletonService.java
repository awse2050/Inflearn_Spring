package hello.core;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 기본생성자로 못만들게 막아버린다.
    private SingletonService() {}



}
