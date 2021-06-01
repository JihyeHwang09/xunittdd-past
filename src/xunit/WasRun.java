package xunit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WasRun {
  private final String name;
  public boolean wasRun;

  public WasRun(String name) {
    // 생성자에서 이름을 받고 버리면 안되므로 name이라는 필드를 만들어 저장해준다
    this.name = name;
  }

  public void testMethod() {
    wasRun = true;
  }

  public void run() {
    // reflect를 이용해서 메서드를 가져올 수 있다
    // 생성자에서 받은 메서드 이름으로 메서드를 가져온다
    try {
      Method method = getClass().getMethod(name);
      /*  메서드를 가져온 후에는 invoke()를 이용해서 실행해야 함
       메서드를 찾아오긴 했지만, invoke()에는 어 Object의 메서드라는 걸 정해줘야 한다
       run()을 실행할 때는 wasRun의 인스턴스가 만들어져 있을 테니까 this라고 자기 자신을 넘겨주면 된다
       */
      method.invoke(this);
      /*
       메타 정보로 하는 거다보니 컴파일 시점에 완벽하게 체크가 되지 않는다
       getMethod(name); 이 이름이 실제로 존재하는지 여부를 알 수 없다
      -> 따라서 각종 Exception이 발생하게 된다(잘못된 메서드 이름을 던지거나 할 때)
      어쨌든 이 부분에서 몽땅 Exception 잡아서 던지게 했음
       */
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//      e.printStackTrace();는 너무 무책임하므로 RuntimeException으로 래핑해서 던지게 했음
      throw new RuntimeException(e);
    }
  }
}
