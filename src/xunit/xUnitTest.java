package xunit;

public class xUnitTest {
  public static void main(String[] args) {
    WasRun wasRun = new WasRun();
    // 이 테스트 메서드가 실행되었었는지 어떻게 검증할것인가?
    // flag를 단다.
    System.out.println(wasRun.wasRun); // false
    wasRun.testMethod();
    System.out.println(wasRun.wasRun); // true

  }
}
