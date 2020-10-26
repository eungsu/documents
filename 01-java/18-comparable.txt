# Comparable&lt;T&gt; 인터페이스
- Comparable 인터페이스를 구현한 객체는 오름차순으로 정렬가능한 객체가 된다.
- Comparable 인터페이스의 compareto메소드를 재정의해서 어떤 값을 기준으로 정렬할 것인지 구현할 수 있다.
- 주요 메소드
  + int compareTo(T other)
    * 반환값이 양의 정수면 비교대상이 되는 other보다 큰 값을 가지는 객체다.
    * 반환값이 0이면 비교대상이 되는 other과 같은 값을 가지는 객체다.
    * 반환값이 음의 정수면 비교대상이 되는 other보다 작은 값을 가지는 객체다.
- Comparable 인터페이스를 구현한 객체는 Arrays.sort(T[] array), Collections.sort(List<T> list) 메소드를 이용해서 정렬할 수 있다.
- 대표적인 Comparable 인터페이스의 구현 클래스
 + String
 + Date
 + Byte, Short, Integer, Long, Float, Double, Character
- Comparable&lt;E&gt; 인터페이스 구현하기
  + 번호를 기준으로 오름차순 정렬되도록 Comparable인터페이스 구현하기
  ```java
    public class Person implements Comparable<Person> {
      private int no;
      private String name;
      
      public int compareTo(Person other) {
        return this.no - other.no;
      }
    }
  ```java
  + 이름을 기준으로 오름차순 정렬되도록 Comparable인터페이스 구현하기
  ```java
    public class Person implements Comparable<Person> {
      private int no;
      private String name;
      
      public int compareTo(Person other) {
        return this.name.compareTo(other.name);
      }
    }
  ```
