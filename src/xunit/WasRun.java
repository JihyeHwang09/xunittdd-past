package xunit;

public class WasRun extends TestCase {
  public boolean wasRun;

  public WasRun(String name) {
    super(name);
    // 생성자에서 이름을 받고 버리면 안되므로 name이라는 필드를 만들어 저장해준다
  }

  public void testMethod() {
    wasRun = true;
  }

}
