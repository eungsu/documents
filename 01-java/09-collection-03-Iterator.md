# Iterator&lt;E&gt; 인터페이스
- 자료구조내의 각 요소를 순회하는 반복자 객체의 표준 인터페이스다.
- 모든 자료구조 구현클래스는 자신의 자료구조객체에 저장된 데이터를 하나씩 반복해서 조회할 수 있는 Iterator객체를 구현하고 있다.
- 모든 자료구조 구현객체는 Iterator 인터페이스를 구현한 Iterator객체를 제공한다.
- 모든 자료구조 구현객체가 제공하는 Iterator구현객체는 구현내용은 다를 수 있지만 사용방법은 동일하다.
- 즉, 모든 자료구조 구현객체는 동일한 사용법으로 자료구조내에 저장된 객체를 하나씩 조회할 수 있는 Iterator구현객체를 제공하는 것이다.
- 주요 메소드
  + boolean hasNext()
    * 반복할 요소가 남아있으면 true를 반환한다.
  + E next()
    * 현재 반복대상이 되는 요소를 꺼낸다.
  + void remove()
    * 현재 반복대상이 되는 요소를 삭제한다

## Iterator&lt;E&gt;
- Collection&lt;E&gt; 인터페이스의 모든 구현 클래스들은 Iterator<E> iterator() 메소드를 구현하고 있다.
  + ArrayList&lt;E&gt;객체의 iterator()를 실행하면 
    * ArrayList의 각 요소를 순회하는 Iterator구현객체가 획득된다.
  + HashSet&lt;E&gt;객체의 iterator()를 실행하면
    * HahsSet의 각 요소를 순회하는 Iterator구현객체가 획득된다. 
  + LinkedList&lt;E&gt;객체의 iterator()를 실행하면
    * LinkedList의 각 요소를 순회하는 Iterator구현객체가 획득된다.
- 사용예제
  ```java
    ArrayList<String> list = new ArrayList<>();
    list.add("김유신");
    list.add("강감찬");
    list.add("류관순");
  
    // 향상된 for문으로 ArrayList에 저장된 요소를 반복해서 조회하기
    for (String name : names) {
      System.out.println(name);
    }
    
    // Iterator의 구현객체를 이용해서 ArrayList에 저정된 요소를 반복해서 조회하기
    Iterator<String> it = list.iterator();
    while (it.hasNext()) {
      String name = it.next();
      System.out.println(name);
    }
  ```
  ```java
    HashSet<String> list = new HashSet<>();
    list.add("김유신");
    list.add("강감찬");
    list.add("류관순");
  
    // 향상된 for문으로 HashSet에 저장된 요소를 반복해서 조회하기
    for (String name : names) {
      System.out.println(name);
    }
    
    // Iterator의 구현객체를 이용해서 HashSet에 저정된 요소를 반복해서 조회하기
    Iterator<String> it = list.iterator();
    while (it.hasNext()) {
      String name = it.next();
      System.out.println(name);
    }
  ```
  ```java
    HashMap<String, String> map = new HashMap<>();
    map.put("hong", "홍길동");
    map.put("kim", "김유신");
    map.put("lee", "이순신");
  
    Set<String> keySet = map.keySet();
    // 맵에서 조회된 key의 집합에 저장된 key값을 반복해서 조회하기
    for (String key : keySet) {
      System.out.print(key);
    }
  
    Iterator<String> it = keySet.iterator();
    while (it.hasNext()) {
      String key = it.next();
      System.out.println(key);
    }
  ```
  
- 결론
  + Collection<E>를 구현한 자료구조 구현클래스들은 자신의 자료구조에 저장된 각 요소를 순회하는 자신만의 Iterator구현객체를 제공한다.
  + 각 자료구조 구현클래스들의 Iterator 구현내용은 다를 수 있지만, 사용방법은 동일한 구현Iterator객체를 제공한다.
  + 자료구조객체에 저장된 데이터를 순회하면서 현재 반복대상이 되는 객체를 삭제해야하는 경우에는 반드시 Iterator를 사용해야 한다.
    * 향상된-for문의 내부에서는 자료구조객체에 저장된 객체를 삭제할 수 없다.
	
