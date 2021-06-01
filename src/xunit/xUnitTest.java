package xunit;

public class xUnitTest {
  public static void main(String[] args) {
    // WasRun이라는 테스트 클래스에 어느 테스트를 실행할 것인지 테스트 이름을 넘긴다
    WasRun wasRun = new WasRun("testMethod");
    // 이 테스트 메서드가 실행되었었는지 어떻게 검증할것인가?
    // flag를 단다.
    System.out.println(wasRun.wasRun); // false
    wasRun.run();
    System.out.println(wasRun.wasRun); // true

  }
}
