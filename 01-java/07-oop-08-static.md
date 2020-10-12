# static변수와 static 메소드
- static(정적)은 고정된 것이란 의미를 가지고 있다.
- static 키워드를 사용해서 static 변수와 static 메소드를 만들 수 있다.
- static변수와 static메소드는 정적필드와 정적메소드라고 부른다.(클래스변수, 클래스메소드라고도 부른다)
- 정적필드와 정적메소드는 객체(인스턴스)에 소속된 멤버가 아니라 클래스에 고정된 멤버다
- 클래스 로더가 클래스를 로딩해서 메로리 영역에 적재할 때 클래스별로 관리하는데, 클래스의 로딩이 끝나는 즉시 정적변수와 정적메소드는 즉시 사용할 수 있게 된다.
  <kbd>![alt static영역과 heap영역](/images/java/static1.PNG)</kbd>
  * 클래스 로더는 클래스파일을 메모리에 로딩하는 프로그램이다.
  * 수행문에 클래스 이름이 등장할때 클래스 로더가 클래스 파일을 메모리에 로딩한다.
  * 메모리에 로딩된 클래스(설계도)는 클래스별로 관리된다.
  * 클래스의 로딩이 완료되면 정적변수와 정적메소드는 즉시 사용가능하게 된다.
  * static 영역에 생성된 정적변수와 정적메소드도 클래스별로 관리되기 때문에, 정적변수와 정적메소드를 사용할 때는 클래스이름으로 사용한다. 
  
## 정적(static변수와 static메소드) 멤버와 인스턴스(instance변수와 instance메소드) 멤버
- 인스턴스 멤버와 정적 멤버의 특징
  | 구분 | 정적 멤버 | 인스턴스 멤버 |
  | --- | --- | --- |
  | 메모리 영역 | static 영역 | heap 영역 |
  | 사용싯점 | 클래스 로딩 즉시 | 객체 생성 후 |
  | 공유여부 | 모든 객체에 공유됨 | 공유되지 않음 |
  | 생성갯수 | 단 한번만 생성됨 | new 연산자로 여러번 생성할 수 있음 |
  | 소멸싯점 | 프로그램 종료시 | 참조변수가 참조하지 않을 때 |
- 필드나 메소드를 인스턴스로 생성할 것인지 정적으로 생성할 것인지에 대한 판단 기준은 공용으로 사용하는 경우 정적멤버로 선언하고, 그렇지 않은 경우 인스턴스로 선언한다.
- 인스턴스 변수를 사용하는 메소드는 반드시 인스턴스 메소드로 선언해야 한다.
  
## 정적변수와 인스턴스 변수
- 정적변수 선언하고 사용하기 
  | 구분 | 문법 |
  | --- | --- |
  | 정적변수 선언 | static 데이터타입 변수명; |
  | 정적변수 선언 | static 데이터타입 변수명 = 값; |
  | 정적변수 사용 | 클래스이름.변수명 |  
- 정적변수는 클래스 변수다.
- 정적변수는 모든 객체에 공유된다.
- 정적변수는 객체 생성없이 사용가능하다.
  ```java
    public class Sample {
      // 정적변수 선언하기
      // static 데이터타입 변수명

      // 정적 변수
      static int x;
      static int y = 10;

      // 인스턴스 변수
      int z;
    }
  ```
  ```java
    public static void main(String[] args) {
      // 정적변수 사용하기
      Sample.x = 100;

      // 정적변수 사용하기
      System.out.println(Sample.x);
      System.out.println(Sample.y);

      // 인스턴스 변수 사용하기
      Sample s = new Sample();
      s.z = 200;
      System.out.println(s.z);
    }
  ```
## 정적메소드와 인스턴스 메소드
- 정적메소드와 인스턴스 메소드의 특징
  | 구분 | 정적메소드 | 인스턴스메소드 |
  | --- | --- | --- |
  | 사용싯점 | 클래스 로딩 즉시 | 객체 생성 후 |
  | 정적변수 | 사용가능 | 사용가능 |
  | 정적메소드 | 사용가능 | 사용가능 |
  | 인스턴스변수 | 사용불가능 | 사용가능 |
  | 인스턴스메소드 | 사용불가능 | 사용가능 |
- 정적메소드 선언하고 사용하기
  | 구분 | 문법 |
  | --- | --- |
  | 정적메소드 선언 | static 반환타입 메소드명(타입 변수, 타입 변수, ...) { ... } |
  | 정적메소드 사용 | 클래스이름.메소드명(인자, 인자, ...); |
  ```java 
    public class Sample {
      // 정적 변수
      static int x = 10;
      // 인스턴스 변수
      int y = 20;

      // 정적 메소드
      static void test1() {
        // 정적변수 사용
        System.out.println(Sample.x);
      }
      // 정적 메소드
      static void test2() {
        // 인스턴스변수 사용
        System.out.println(y);  // 컴파일 오류
      }
      // 정적 메소드
      static void test3() {
        // 정적메소드 호출
        Sample.test1();
      }
      // 정적 메소드
      static void test4() {
        // 인스턴스메소드 호출
        test5();  // 컴파일 오류
      }

      // 인스턴스 메소드
      void test5() {
        // 정적변수 사용
        System.out.println(Sample.x);
        // 인스턴스변수 사용
        System.out.println(y);
        // 정적메소드 호출
        Sample.test1();
      }
    }
  ```
## static변수와 static메소드의 활용
- static 변수
  * static 변수는 **상수**를 선언할 때 사용한다.
  * 상수는 한 번 정해진 값을 변경할 수 없는 저장소다.
    ```java
      public class FileUploader {
        // 상수 정의하기
        static final long MAX_FILE_UPLOAD_SIZE = 1024*1024*10;
        static final String FILE_UPLOAD_PATH = "/appliation/resources/images"
      }
    ```
- static 메소드
  * static 메소드는 유틸리티 클래스에서 주로 사용된다.
  * 유틸리티 클래스의 메소드들은 멤버변수와 상호작용이 없고, 여러 객체에서 자주 사용하는 기능들이다.
  * 대표적인 유틸리티 클래스는 java.lang.Math, java.util.Arrays, java.util.Collections, java.util.Objects 등의 클래스다.
  * 유틸리티 클래스의 static 메소드 사용예
    ```java
      public static void main(String[] args) {

        double result1 = Math.random();
        double result2 = Math.ceil(2.3);
        double result3 = Math.floor(2.3);

        int[] numbers = {4, 1, 7, 4, 8, 2, 9, 5};
        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
      }
    ```
   
