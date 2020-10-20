# Wrapper 클래스와 Auto-Boxing/Unboxing

## Wrapper 클래스
- 기본자료형 타입에 대응되는 클래스다.
- 기본자료형 값을 가지고 있는 객체를 만들 수 있다.
- java.lang 패키지에 정의되어 있다.
- 사용해야 할 때
  + 기본자료값이 아닌 객체로 저장해야할 때
  + 호출할 메소드의 매개변수가 객체를 요구할 때
  + null값이 저장될 가능성이 있을 때
  + 해당 기본자료형값에 대한 다양한 기능을 실행해야 할 때
- 지원하는 Wrapper 클래스
  | 기본자료형 | Wrapper 클래스|
  | --- | --- |
  | byte | Byte |
  | short | Short |
  | int | Integer |
  | long | Long |
  | float | Float |
  | double | Double |
  | char | Character |
  | boolean | Boolean |
  
## 오토박싱/오토언박싱
- JAVA 1.5버전부터 도입된 기능
- 기본자료형 타입과 Wrapper객체 타입간의 변환을 자동으로 지원한다.
- 오토박싱
  ```java
    Integer instance = new Integer(10);  // 박싱
    
    Integer instance = 10;  // 오토박싱 
    // Integer instance = new Integer(10); // 실제로 실행되는 코드
   ```
- 오토언박싱
  ```java
    Integer instance = new Integer(10);  // 박싱
    int value = instance.intValue();      // 언박싱

    int value = instance; // 오토 언박싱
    // int value = instance.intValue(); // 실제로 실행되는 코드
  ```
 - 실제 활용 예제
   ```java
     public class Sample {
       public void test1(int value) {
         수행문
       }
       
       public void test2(Integer instance) {
         수행문
       }
     }
   ```
   ```java
     public static void main(String args) {
       Sample sample = new Sample();

       sample.test1(1);
       sample.test2(1); // 실제 실행되는 코드 sample.test2(new Integer(1));
     }
   ```
