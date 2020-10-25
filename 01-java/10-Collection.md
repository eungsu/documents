# Collection Framework
- 자바가 자료구조를 구현해 놓은 것
  * 자료구조 - 객체의 저장/삭제/조회 등의 기능을 제공하는 것
- 자바의 모든 자료구조 구현 클래스는 Collection<E> 인터페이스를 구현한 클래스다.
  * Collection<E> 인터페이스에 정의된 모든 기능을 구현하고 있다.
- 자바의 자료구조 특징
  * 객체만 저장할 수 있다.
  * 크기가 가변적이다.
  * 다양한 메소드를 지원한다.

## Collection<E>
- 모든 자료구조 클래스의 최상위 인터페이스다.
- 주요 메소드
  + boolean add(E e)
    * 자료구조에 새로운 요소를 추가한다.
  + boolean addAll(Collection<? extends E> c)
    * 자료구조에 다른 자료구조의 모든 요소를 추가한다.
  + void clear()
    * 자료구조의 모든 요소를 삭제한다.
  + boolean contains(Object e)
    * 자료구조에 지정된 객체가 존재하는지 조회한다.
  + boolean isEmpty()
    * 자료구조가 비었는지 조회한다.
  + Iterator<E>	iterator()
    * 자료구조의 각 요소를 반복해서 추출해주는 반복자객체를 반환한다.
  + boolean remove(Object e)
    * 자료구조에서 지정된 객체를 삭제한다.
  + int	size()
    * 자료구조에 저장된 요소의 갯수를 반환한다.
  + Object[] toArray()
    * 자료구조에 저장된 요소를 배열로 반환한다.

## Collection<E>의 주요 하위 인터페이스
- Set<E>
  + 중복을 허용하지 않는다.(동일한 객체를 2개 저장할 수 없다.
  + 주요 구현 클래스
    * HashSet<E> : 가장 많이 사용하는 Set구현 클래스 
    * TreeSet<E> : 저장되는 요소가 오름차순으로 정렬되어서 저장된다
  + Set의 구현객체 생성하기
    ```java
      // String 객체를 여러 개 저장하는 HashSet객체 생성하기
      Set<String> set1 = new HashSet<String>();
      // 정수를 여러 개 저장하는 HashSet객체 생성하기
      Set<Integer> set2 = new HashSet<Integer>();
  
      // Book객체를 여러 개 저장하는 HashSet객체 생성하기
      Set<Book> set3 = new HashSet<Book>();
      // Account객체를 여러 개 저장하는 HashSet객체 생성하기
      Set<Account> set4 = new HashSet<Account>();
    ```
  + HashSet<E> 활용하기
    ```java
      public static void main(String[] args) {
        // String객체를 여러 개 저장하는 HashSet객체 생성하기
        Set<String> set = new HashSet<String>();
	
        // HashSet에 객체 저장하기
        set.add("홍길동");
        set.add("김유신");
        set.add("이순신");
        set.add("강감찬");
        set.add("류관순");
        set.add("강감찬");	// 동일한 객체가 저장되어 있기 때문에 저장되지 않음

        // HashSet에 저장된 객체의 갯수 조회하기
        int count = set.size();
        System.out.println("저장된 객체의 갯수: " + count);	// 5가 출력됨

        // HashSet이 지정된 객체를 포함하고 있는지 조회하기
        boolean hasElement = set.contains("김유신");
        System.out.println("김유신을 포함하고 있는가?" + hasElement); // true가 출력됨

        // HashSet에서 지정된 객체를 삭제하기
        set.remove("홍길동");

        // HashSet이 비어있는지 조회하기
        boolean empty = set.isEmpty);
        System.out.println("비어있는가?" + empty);		// false가 출력됨

        // HashSet에 저장된 객체를 향상된 for문을 사용해서 순회하기
        for (String name : set) {
          System.out.println("저장된 이름: " + name);
        }
        // HashSet에 저장된 모든 객체 삭제하기		
        set.clear();
      }
    ```
- List<E>
  + 순서가 유지된다.(저장된 순서대로 다시 꺼낼 수 있다.)
  + 요소가 저장될 때 마다 index(순번)이 자동으로 부여된다.
  + 특정위치에 요소 저장하기, 특정위치의 요소 삭제하기, 특정위치의 요소 꺼내기
  + List<E>가 지원하는 추가 메소드
    * void add(int index, E e)
      - 지정된 위치에 요소를 저장한다.
    * E get(int index)
      - 지정된 위치의 요소를 꺼낸다
    * E remove(int index)
      - 지정된 위치의 요소를 삭제한다.
    * E set(int index, E e)
      - 지정된 위치의 요소를 새 요소로 교체한다.
  + 주요 구현 클래스
    * ArrayList<E> : 가장 많이 사용하는 List구현 클래스(전체 자료구조 클래스 중에서 가장 많이 사용)
    * LinkedList<E> : 더블링크로 List를 구현한 클래스(요소의 추가/삭제 성능이 우수하다.)
    * Vector<E>	: ArrayList와 유사하는 List구현 클래스(멀티스레드 환경에 안전하다.)
    * Stack<E>	: LIFO(Last-In-First-Out)으로 구현된 List구현 클래스
  + List<E>의 구현객체 생성하기
    ```java
      // String객체를 여러 개 저장하는 ArrayList객체 생성하기
      List<String> list1 = new ArrayList<String>();
      // 실수를 여러 개 저장하는 ArrayList객체 생성하기
      List<Double> list2 = new ArrayList<Double>();
      
      // Person객체를 여러 개 저장하는 ArrayList객체 생성하기
      List<Person> list3 = new ArrayList<Person>();
    ```
  + ArrayList<E> 활용하기
    ```java
      public class Person {
        private int no;
        private String name;
        public Person() {}
        public Person(int no, String) {
          this.no = no;
          this.name = name;
        }
        public int getNo() {
          return no;
        }
        public String name() {
          return name;
        }
      }
      public static void main(String[] args) {
        // Person객체를 여러 개 저장할 수 있는 ArrayList객체 생
        List<Person> personList = new ArrayList<Person>();
        
        // ArrayList객체에 Person객체생성하기
        personList.add(new Person(100, "김유신"));
        personList.add(new Person(200, "강감찬"));
        personList.add(new Person(300, "이순신"));
        personList.add(new Person(400, "류관순"));
        
        // ArrayList객체에 저장된 Person객체의 갯수를 조회하기
        int count = personList.size();
        System.out.println("저장된 갯수: " + count); // 4가 출력됨
        
        // 향상된 for문을 사용해서 ArrayList객체에 저장된 Person객체를 순회하기
        for (Person person : personList) {
          int no = person.getNo();
          String name = person.getName();
          System.out.println("번호:" + no + ", 이름:" + name);
        }
        
        // ArrayList객체에서 0번에 저장된 Person객체 조회하기
        Person person0 = personList.get(0);
        
        // ArrayList객체에서 2번에 칸에 저장된 Person객체 삭제하기
        personList.remove(2)
        
        // ArrayList객체에서 1번에 저장된 객체를 새로운 Person객체로 변경하기
        personList.set(1, new Person(500, "안중근"));
        
        // ArrayList객체에 저장된 모든 객체 삭제하기
        personList.clear()
      }
    ```
  + Stack<E> 객체 사용하기
    ```java
      public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        
      }
    ```
    
    
## 배열과 콜렉션의 비교
| 구분 | 배열 | 콜렉션 |
| --- | --- | --- |
| 데이터 | 기본자료형, 객체 | 객체 |
| 길이 | 불변 | 가변적 |
| 저장 | 인덱스필요 | 맨 마지막요소의 끝에 자동으로 저장 |
| 삭제 | 인덱스필요 | 삭제 후 다음요소로 해당 위치가 |
| 삭제 | 해당부분 데이터가 비어있음 |	자동으로 채워짐 |
| Enhanced-for | 배열의 끝까지 반복 | 요소가 있는 부분까지만 반복 |

