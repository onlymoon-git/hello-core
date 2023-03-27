package hello.core.singleton;

public class SingletonService {

    /* 자기자신(SingletonService)을 내부에 private 으로 하나 가지고 있는데 static 으로 가지고 있다
       static 으로 선언을 하면 Class level 로 올라가기때문에 딱 하나면 존재하게 된다. */
    /* Java 가 뜰때 SingletonService 의 static 영역에, 오른쪽의 new 를 내부적으로 실행해서
       자기자신인 SingletonService 객체를 생성하여 "instance" 참조변수에 넣는다. */
    private static final SingletonService instance = new SingletonService();

    /* instance 참조변수를 꺼낼 수 있는 방법은 이 함수를 호출하는 것 밖에는 없다.
       따라서 다른 class 에서 "new SingletonService()"를 실행시켜 객체를 생성할 수 없다. */
    public static SingletonService getInstance() {
        return instance;
    }
    /* 생성자: private 으로 선언을 했기때문에 밖에서 "new SingletonService()"를 할 수 없다 */
    private SingletonService() {
    }
}
