# System 클래스
- 자바실행환경이 설치된 시스템(컴퓨터)에 대한 유용한 값과 객체를 제공하는 클래스다.
- java.lang 패키지에 속해있다.
- System 클래스의 모든 필드와 모든 메소드는 정적필드, 정적메소드다.
- 제공하는 것
  + 표준입력장치, 표준출력장치, 표준에러출력장치와 연결된 스트림
  + 컴퓨터의 환경변수, 프로퍼티 값을 제공한다.
  + 컴퓨터의 현재시간정보를 제공한다.

## 주요 메소드
- long System.currentTimeMillis()
  + 현재 시간에 대한 유닉스타임을 제공한다.
  + 유닉스타임:1970/1/1 00:00:00부터 지금까지의 시간을 1/1000초 단위로 표현한 값이다
  ```java
    long time = System.currentTimeMillis();	// 13자리 정수가 획득된다.
  ```
- void System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
  + 배열의 요소를 다른 배열에 복사한다.
  + 매개변수 
    * src:원본배열
  	* srcPos:원본배열의 복사시작위치
  	* dest:대상배열
  	* destPos:대상배열의 저장시작위치
    * length: 복사할 요소의 갯수
  ```java
    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = new int[20];
    int[] arr2 = new int[20];
    
    // 원본배열의 0번째부터 10개를 arr2의 0번째 위치에 복사하기
    System.arraycopy(arr1, 0, arr2, 0, 10);
    // arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    
    // 원본배열의 4번째부터 5개를 arr2의 0번째 위치에 복사하기
    System.arraycopy(arr1, 4, arr2, 0, 5);
    // arr2 = {5, 6, 7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
  ```
- void System.exit(int status)
  + 프로그램을 종료시킨다
  + 정상적인 종료일 때는 status값을 0으로 설정한다
- String System.getenv(String name)
  + 시스템의 환경변수 설정값을 조회한다  
  ```java
    String value1 = System.getenv("JAVA_HOME");
    System.out.println(value1);	// "C:\Program Files\Java\jdk-11.0.8" 가 출력됨
  ```
- String System.getProperty(String name)
  + 운영체제의 설정정보를 조회한다
  ```java
    // 사용자의 홈 디렉토리 경로를 반환한다.
    String value1 = System.getProperty("user.dir");
    
    // 시스템의 줄바꿈 문자를 반환한다.
    String value2 = System.getProperty("line.separator");
    
    // 시스템의 디렉토리 경로 구분문자를 반환한다.
    String value3 = System.getProperty("file.separator");
  ```
