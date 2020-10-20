# 제네릭(Generic)
- 소스 레벨에서 데이터 타입이 결정되지 않고, 별칭(타입파라미터)만 지정한다.
  * 데이터 타입은 필드의 타입, 매개변수 타입, 리턴타입 등이다.
- 객체 생성싯점, 구현클래스 구현싯점, 메소드 실행싯점에 별칭을 대신할 데이터 타입을 외부에서 지정하는 것이다.
- 제네릭은 <> 다이아몬드 표기법으로 타입파라미터(별칭)를 지정한다.
  * 객체 생성싯점, 구현클래스 구현싯점, 메소드 실행싯점에 데이터타입을 지정한다.
  * 데이터타입은 클래스 혹은 인터페이스 타입만 가능하다.
  * 기본 자료형은 제네릭의 데이터 타입으로 지정할 수 없다.
  
## 제네릭 클래스
- 타입 파라미터를 하나 이상 가지고 있는 클래스
- 여러 종류의 객체를 다루는 클래스를 제네릭 클래스로 정의하면
  타입의 안전성을 보장받고, 형변환 코드를 제거할 수 있다.
- 제네릭 클래스 예)
  * 자료구조(Set<E>, List<E>, Map<K, V>)
  * 데이터를 반복처리하는 것(Iterator<E>, Enumeration<E>)
- 제네릭 클래스 구현시 주의사항
  * T타입의 배열을 생성할 수 없다.
  * T타입의 클래스 변수를 생성할 수 없다.
  ```java
    class Box<T> {
      static T t;	      // 오류, 클래스 변수를 선언할 수 없다.
      T[] data = new T[10];   // 오류, T타입의 배열은 생성할 수 없다.
      T[] data;	              // 정상, T타입의 배열에 대한 변수는 선언할 수 있다.
      public Box() {
        data = (T[]) new Object[10];
      } 	
    }
  ```
  * 제네릭 클래스 정의하고 
  ```java
    public class Sample<T> {
      private T data; 
      public void setData(T t) { 
        this.data = t; 
      }
    }
  ```
  ```java
    public static void main(String[] args) {
      // T의 타입이 String 클래스가 된다.
      Sample<String> s1 = new Sample<String>();		
      
      // T의 타입이 Customer 클래스가 된다.
      Sample<Customer> s2 = new Sample<Customer>();
      
      // T의타입이 Apple 클래스가 된다.
      Sample<Box<Apple>> s3 = new Sample<Box<Apple>>();	
      
      // T의 타입이 Object가 된다
      Sample s4 = new Sample();	
      Sample<Object> s5 = new Sample<Object>();

      // Sample<int> s4 = new Sample<int>(); // 컴파일 오류
      // T의 타입이 Integer가 된다.
      Sample<Integer> s5 = new Sample<Integer>();
  ```
## 제네릭 클래스를 사용하는 이유
  + 클래스내부에서 사용할 데이터의 타입을 외부에서 지정하는 것이다.
  + 객체 생성싯점에 데이터 타입을 지정한다.
  + 사과만 담을 수 있는 Box 클래스
  ```java
    public class Box {
      private Apple fruit;
      public void setFruit(Apple fruit) {
        this.fruit = fruit;
      }
      public Apple getFruit() {
        return fruit;
      }
    }
  ```
  + 다양한 과일을 담을 수 있는 Box 클래스
  ```java
    public class Box {
      private Object fruit;
      public void setFruit(Object fruit) {
        this.fruit = fruit;
      }
      public Object getFruit() {
        return fruit;
      }
    }
  ```
    * 과일만 저장된다는 보장이 없다.
    * 한 종류의 과일만 저장된다는 보장이 없다.
    * 꺼냈을 때 어떤 과일이 나올지 예상할 수 없다.
  + 객체 생성시 지정된 타입의 과일만 담을 수 있는 Box 클래스
  ```java
    public class Box<T> {
      private T fruit;
      public void setFruit(T fruit) {
        this.fruit = fruit;
      }
      public T getFruit() {
        return fruit;
      }
    }
  ```
  ```java
    Box<Apple> box = new Box<Apple>();
    /* 실제 생성된 객체의 클래스
      public class Box<Apple> {
        private Apple fruit;
        public void setFruit(Apple fruit) {
          this.fruit = fruit;
        }
        public Apple getFruit() {
          return fruit;
        }
      }
    */
    Box<Banana> box = new Bax<Banana>();
    /* 실제 생성된 객체
      public class Box<Banana> {
        private Banana fruit;
        public void setFruit(Banana fruit) {
          this.fruit = fruit;
        }
        public Banana getFruit() {
          return fruit;
        }
      }
  ```
    * 제네릭을 활용해서 Box클래스를 구현한 경우의 잇점
      - 원하지 않는 자료형의 값이 입력되는 것을 컴파일 싯점에 알아낼 수 있다.
      - 값을 꺼낼 때 타입변환이 필요없다.
	
## 인터페이스에 제네릭 사용하기
  + 구현 클래스가 사용할 데이터타입을 외부에서 지정하게 하는 것
  + 제네릭 타입 지정하기
    * 구현클래스 정의 싯점에 데이터타입을 지정하기
    ```java
      public inteface Comparable<T> {
        int compareTo(T other);
      }
      
      //제네릭 인터페이스를 구현한 클래스의 T가 Product로 대체된다.
      public class Product implements Comparable<Product> {
        private String name;
        private int price;
        
	public int compareTo(Product other) {
          return this.price - other.price;
        }
      }
    ```
    * 구현클래스 정의 싯점에 데이터타입을 지정하지 않고, 객체 생성싯점에 지정하게 하기
    ```java
      public interface Collection<E> {
        boolean add(E e);
      }

      public class ArrayList<E> implements Collection<E> {
        ...
        public boolean add(E e) {
	  수행문
        }
      }
    ```
    ```java
      ArrayList<Product> products = new ArrayList<Product>();
    ```

## 와일드 카드
- 제네릭 타입에 다형성을 적용할 때 사용한다.
- '?', 'extends', 'super'를 사용해서 다룰 객체의 상한과 하한을 지정할 수 있다.
- 한 종류의 제네릭 타입 참조변수로 다른 타입이 지정된 객체를 다루기
```java
  ArrayList<? extends Product> list = new ArrayList<Tv>();
  ArrayList<? extends Product> list = new ArrayList<SmartPhone>();
  // list 참조변수는 Product 및 그 자손이 제네릭타입으로 지정된 ArrayList를 참조할 수 있다.
```
- 메소드의 매개변수에서 와일드카드 사용하기
```java
    public void 전공과정등록(Course<? extends Student> course) { ... }
    // Course<Student> c = new Course<>();		
    // Course<CollegeStudent> c = new Course<>();
    // Course<PostGraduatedStudent> c= new Course<>();
    // 위의 3개 과정은 전공과정등록() 메소드의 매개변수에 전달할 수 있는 과정이다.

    public void 대학원과정등록(Course<? extends PostGraduatedStudent> course) { ... }
    // Course<PostGraduatedStudent> c= new Course<>();
    // 위의 과정은 전공과정등록() 메소드의 매개변수에 전달할 수 있는 과정이다.

    public void 직장인및일반인과정등록(Course<? super Worker> course) { ... }
    // Course<Worker> c = new Course<>();		
    // Course<Person> c = new Course<>();
    // 위의 2개 과정은 전공과정등록() 메소드의 매개변수에 전달할 수 있는 과정이다.
```
## 제네릭 메소드
- 메소드의 선언부에 타입파라미터가 선언된 메소드다.
```java
   class Box<T> {
	public void add(T t) { ... }	// 제네릭 메소드 아님
	public T get(int index) { ... } // 제네릭 메소드 아님

	public <T> T[] toArray(T[] arr) { ... } // 제네릭 메소드
	//메소드의 선언부에 <T>와 같은 타입파라미터 정의가 있어야 된다.
	//이 메소드의 T는 Box<T>와 아무 상관이 없다.
	//이 메소드의 T는 메소드 실행시 전달된 배열의 타입에 전적으로 의존한다.
   }

   class Arrays {
	public static <T> void sort(T[] arr) { ... }	// 제네릭 메소드
	//제네릭 메소드는 제네릭클래스가 아닌 곳에서도 정의할 수 있다.
	//sort() 메소드 실행시 전달받은 배열의 타입이 T의 타입이 된다.
	//Arrays.sort(new String[]{"김유신", "강감찬"}); ---> <T>는 <String>이 된다.
   }
   class ApplicationContext {
	public <T> T getBean(String beanName, Class<T> clazz) { ... }
	//getBean() 메소드 실행시 전달받은 객체의 설계도 타입이 T의 타입이 된다.
	//ctx.getBean("service", UserService.class) ---> <T>는 <UserService>가 된다.
   }
```
	   
