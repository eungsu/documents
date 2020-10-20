# String
- 문자열을 표현하는 객체다.
- 문자열(String)은 불변객체다.
  + 한번 생성된 문자열은 절대로 변하지 않는다.
- String객체를 생성하는 방법
  ```java
    String s = "abc";
    String s = new String("abc");
    
    char[] data = {'a', 'b', 'c'};
    String s = new String(data);
  ```
- String객체는 문자열과 관련된 다양한 기능들을 제공한다.

## String의 주요 메소드
- int **length()**
  + 문자열의 길이를 반환한다.
  ```java
    String str = "abcdefg";
    int len = str.length();
    System.out.println(len);	// 7이 출력됨
  ```
- boolean **equals(Object str)**
  + 문자열의 내용을 비교해서 동등성 여부를 반환한다.
  ```java
    String str1 = "hello";
    String str2 = "Hello";
    String str3 = "hello";

    boolean result1 = str1.equals(str2);	// false
    boolean result2 = str1.equals(str3);	// true
  ```
- boolean **equalsIgnoreCase(String str)**
  + 문자열의 내용을 비교해서 동등성 여부를 반환한다.
  + 대/소문자를 구분하지 않고 비교한다.
  ```java
    String str1 = "hello";
    String str2 = "Hello";
    String str3 = "hello";

    boolean result1 = str1.equalsIgnoreCase(str2);	// true
    boolean result2 = str1.equalsIgnoreCase(str3);	// true
  ```
- boolean **isEmpty()**
  + 문자열의 길이가 0인 경우 true를 반환한다.
  ```java
    String str1 = "";
    String str2 = " ";
    String str3 = "abc";

    boolean result1 = str1.isEmpty();	// true
    boolean result2 = str2.isEmpty(); // false
    boolean result3 = str3.isEmpty(); // false
  ```
- boolean **contains(CharSequence s)**
  + 지정된 문자열이 포함되어 있으면 true를 반환한다.
  ```java
    String str = "Hello, java!";
    boolean result1 = str.contains("java");			// true
    boolean result2 = str.contains('hello');		// false
  ```
- int indexOf(String str)
  + 지정된 문자열이 처음으로 등장하는 위치를 반환한다.
  ```java
    String str = "My car is red car";
    int index = str.indexOf("car");	// 3
  ```
- int lastIndexOf(String str)
  + 지정된 문자열이 마지막으로 등장하는 위치를 반환한다.
  ```java
    String str = "My car is red car";
    int index = str.lastiIndexOf("car");	// 14
  ```
- String **substring(int beginIndex)**
  + 지정된 위치부터 끝까지의 문자열을 새로 만들어서 반환한다.
  ```java
    String str = "abcdefg";
    String result = str.substring(2);	// "cdefg"		
  ```
- String **substring(int beginIndex, int lastIndex)**
  + 지정된 시작위치부터 끝위치 앞까지의 문자열을 새로 만들어서 반환한다.
  ```java
    String str = "abcdefg";
    String result = str.substring(2, 5);	// "cde"
  ```
- String **replace(CharSequenct target, CharSequence replacement)**
  + 대상 문자열을 지정된 문자열로 대체한 새로운 문자열을 반환한다.
  ```java
    String str = "My car is red car";
    String result = str.replace("car", "house");	// "My house is red house"
  ```
- String **toLowerCase()**
  + 문자열을 소문자로 새로 만들어서 반환한다.
  ```java
    String str = "Hello, Java!";
    String result = str.toLowerCase();	// "hello, java!"
  ```
- String **toUpperCase()**
  + 문자열을 대문자로 새로 만들어서 반환한다.
  ```java
    String str = "Hello, Java!";
    String result = str.toUpperCase();	// "HELLO, JAVA!"
  ```
- String trim()
  + 문자열의 좌우 불필요한 공백이 제거된 새로운 문자열을 만들어서 반환한다.
  ```java
    String str = "     안녕     하세요     ";
    String result = str.trim();		// "안녕     하세요"
  ```
- boolean startsWith(String prefix)
  + 문자열이 지정된 문자열로 시작하면 true를 반환한다.
  ```java
    String str1 = "이력서_홍길동.hwp";
    String str2 = "이력서_김유신.hwp";
    String str3 = "강감찬.hwp";

    boolean result1 = str1.startsWith("이력서");	// true
    boolean result2 = str2.startsWith("이력서");	// true
    boolean result3 = str3.startsWith("이력서");	// false
  ```
- boolean endsWith(String suffix)
  + 문자열이 지정된 문자열로 끝나면 true를 반환한다.
  ```java
    String str1 = "logo.png";
    String str2 = "이력서.hwp";

    boolean result1 = str1.endsWith("png");		// true
    boolean result2 = str2.endsWith("png");		// false
  ```
- String[] **split(String regex)**
  + 문자열을 지정된 구분문자열로 잘라서 각각의 요소를 배열에 담아서 반환한다.
  ```java
    String str = "김유신,강감찬,이순신,홍길동";
    String[] arr = str.split(",");	// {"김유신", "강감찬", "이순신", "홍길동"}
	```
- int **compareTo(String other)**
  + 지정된 다른 문자와 사전 순서대로 비교한다
  + 배열이나 콜렉션에 저장된 문자열을 정렬할 때 사용된다.
- char charAt(int index)
  + 문자열에서 지정된 위치의 글자를 문자로 반환한다.
  ```java
    String str = "abc";
    char c = str.charAt(0);	// 'a' 
  ```
- static String **valueOf(다양한 값)**
  + 전달받은 다양한 타입의 값을 문자열로 바꿔서 반환한다.
  + 정적메소드다.
  ```java
    String result1 = String.valueOf(10);	// "10"
    String result2 = String.valueOf(3.14);	// "3.14"
    String result3 = String.valueOf(true);	// "true"
    
