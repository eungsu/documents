# Spring framework
- POJO기반의 JAVA EE 애플리케이션 개발을 지원하는 경량(light-weight)의 프레임워크다.
  * POJO (Plain Old Java Object)
    - 평범한 옛날 자바 객체
    - Plain : 특별한 라이브러리, 특별한 실행환경이 필요하지 않는 객체, 특정환경에 종속되지 않는 객체
      * 개발하기 쉽다.
      * 재사용성이 높다.
      * 테스트가 용이하다.
    - Old : EJB 등장이전의 평범한 자바객체로 개발하던 시절
      * new 키워드로 객체를 생성하고 사용하던 시절
      * 특별한 실행환경이 필요없던 시절
      * 특별한 환경 혹은 라이브러리에 종속되지 않는 재사용성이 높고, 테스트하기 쉬운 객체
- 특징
  * 경량의 프레임워크다.
  * IoC의 구현체다.
  * AOP의 구현체다.

## Spring Container
- 스프링 프레임워크의 가장 중요한 기능을 담당하는 것이다.
  * 다양한 인터페이스와 다양한 구현클래스로 구성되어 있다.
- 객체의 라이프사이클을 관리한다.
  * 객체의 생성, 객체의 유지/관리/실행, 객체의 폐기
- 스프링 설정파일을 기반으로 객체의 조립(제어역전, 의존성 주입)을 지원한다.
- 스프링 설정파일을 기반으로 관점지향프로그램을 지원한다.
- 종류
  - BeanFactory 인터페이스
    * spring-core.jar
    * 객체의 라이프사이클 관리, 객체의 조립을 지원
    * 다양한 구현클래스가 존재한다.
      - XMLBeanFactory
  - ApplicationContext 인터페이스
    * spring-context.jar
    * 객체의 라이프사이클 관리, 객체의 조립, AOP지원, 국제화지원, EJB와의 연동
    * 다양한 구현클래스가 존재한다.
      - FileSystemXmlApplicationContext
      - ClasspathXmlApplicationContext
      - GenericXmlApplicationContext
      - AnnotationConfigApplicationContext
  - WebApplicationContext 인터페이스
    * spring-web.jar
    * 웹 애플리케이션환경에 특화되어 있는 ApplicationContext다.
    * 제공하는 기능은 ApplicationContext와 동일한다.
    * 다양한 구현클래스가 존재한다.
      - XmlWebApplicationContext

- 주요 API
  - Object getBean(String name)
    - 스프링 컨테이너로부터 지정된 이름에 해당하는 객체를 가져온다.
  - T getBean(String name, Class<T> requiredType)
    - 스프링 컨테이너로부터 지정된 이름, 지정된 클래스타입의 객체를 가져온다.

## IoC(Inversion of Control : 제어 역전)
- 어떤 모듈이 사용할 모듈을 스스로 결정하는 것이 아니라, 다른 모듈에게 선택권을 넘겨준다는 것을 의미한다.
  * 사용할 모듈을 직접 생성하는 것이 아니라, 제 3자로부터 제공받는 것이다.
- 방법
  - DI(Dependency Injection : 의존성 주입)
    - 모듈간의 의존성을 외부(컨테이너)에서 주입시켜주는 것이다.
    - 스프링 컨테이너는 DI에 대한 강력한 기능을 지원한다.
  - DL(Dependency Lookup : 의존성 검색)
    - 컨테이너가 관리중인 객체 저장소에서 객체를 검색해서 참조하는 것이다.

### 스프링 빈 설정 파일 정의하기
* 스프링 빈 설정파일은 스프링 컨테이너에게 빈(객체) 생성 및 조립 정보를 전달하기 위해서 정의한다.
* 형식
```xml
  <beans>
    <bean id="식별자명" class="클래스전체이름"></bean>
  </beans>
```
  * <beans/> 루트 엘리먼트를 가지고 있다.
  * 스프링 컨테이너가 관리할 빈(객체)으로 등록하기 위해서 <bean>태그를 사용한다.
  - id
    * 빈을 식별하기 위한 고유한 이름
    * 지정하지 않으면 클래스이름의 첫글자를 소문자로 바꿔서 식별자명으로 사용한다.
  - class
    * 스프링의 빈으로 등록할 클래스명을 정의한다.
    * 패키지명을 포함한 클래스의 전체 이름을 기술하여야 한다.
	
### 의존성 주입하기
* 스프링의 빈으로 등록된 객체는 다른 객체에 주입(조립)할 수 있다.
* 의존성 주입 방법
  - Setter Injection
    * setter 메소드를 이용한 의존성 주입이다.
    * 작성예
```java
  public class HelloService {
    private Greeting greeting;                          // 주입받는 객체를 담는 필드
    public void setGreeting(Greeting greeting) {        // 주입받기 위한 setter 메소드
      this.greeting = greeting;
    }

    public void sayHello() {
      greeting.hi();
    }
  }

  public interface Greeting {
    void hi();
  }

  public class GreetingImpl extends Greeting {
    public void hi() {
      System.out.println("안녕하세요");
    }
  }
```
```xml
  <bean id="greetImpl" class="x.y.z.GreetingImpl"/>
  <bean id="service" class="x.y.z.HelloService">
    <!-- setter injection -->
    <!-- setGreet(Greeting greet) 메소드의 인자로 greetImpl을 전달한다. -->
    <!-- name은 setter 메소드의 이름이다 -->
    <!-- ref는 조립한 빈의 이름이다. -->
    <property name="greeting" ref="greetImpl"/>
  </bean>
```
  - Constructor Injection
    * 기본 생성자 외의 생성자가 정의되어 있는 경우에 의존하는 객체나 값을 생성자의 매개변수를 사용해서 의존성을 주입하는 것이다.
    * 작성예
```java
  public class Connector {
    private String ip;
    private int port;
    private String username;
    private String password;

    public Connector(String username, String password) {
      this.ip = "localhost"; 
      this.port = 1521;
      this.username = username;
      this.password = password
    }
    public Connector(String ip, int port, String username, String password) {
      this.ip = ip; 
      this.port = port;
      this.username = username;
      this.password = password
    }
  }
```
```xml
  <bean class="x.y.z.Connector">
    <constructor-arg name="username" value="hong"/>
    <constructor-arg name="password" value="zxcv1234"/>
  </bean>

  <bean class="x.y.z.Connector">
    <constructor-arg name="ip" value="192.168.10.65"/>
    <constructor-arg name="port" value="2000"/>
    <constructor-arg name="username" value="kim"/>
    <constructor-arg name="password" value="1234zxcv"/>
  </bean>
```
* <constructor-arg> 태그 하나당 생성자 매개변수 하나에 대응된다.
* 클래스에 정의된 생성자의 매개변수 갯수에 맞게 <constructor-arg>를 정의해야한다.

### 빈 자동으로 설정
  * 스프링 컨테이너는 지정된 패키지의 클래스를 스캔해서 스프링 컨테이너의 빈으로 등록할 수 있다.
  * 스프링 컨테이너는 스프링 컨테이너의 빈들끼리 자동으로 의존관계을 묶을 수 있다.
  * 클래스 스캔해서 스프링의 빈으로 자동 등록하기
  * 스캔대상이 되는 클래스에 @Component, @Controller, @Service, @Repository, @RestController, @ControllerAdvice를 붙인다.
  * 작성예
```java
  @Component
  public class HelloService {
    public void say() { ... }
  }
```
```xml
  <!-- 스캔대상 패키지 스캔하기-->
  <context:component-scan base-package="스캔대상 패키지명" />
```

  * 빈 들끼리 자동으로 묶어주기
```java
  // Language 구현객체가 필요한 객체
  @Component
  public class HelloService {
    @AutoWired	
    private Languae language;
  }
  // Language 인터페이스
  public interface Language {
    void getWord();
  }
  // Language 인터페이스 구현 클래스	
  @Component
  public class KoreanLanguage implements Language {
    public void getWord() { return .... }
  }
```	
    * @AutoWired
      - 필드, setter메소드, 생성자메소드에 붙일 수 있다.
      - 해당 어노테이션이 부착된 필드 및 메소드의 인자와 동일하거나 유사한 타입의 객체를 찾아서 자동 조립시킨다.
      - 해당되는 타입의 객체를 찾지 못하거나, 2개 이상 발견되면 에러 발생
    * @Resource
      - @AutoWored와 동일한 일을 수행한다.
      - @Resource(name="빈의 식별자")을 이용해서 지정된 이름의 빈이 조립되게 한다.
      - 동일한 타입의 객체가 여러 개 찾아져도 에러가 발생되지 않는다.

### 기본자료형(boolean, 정수, 실수, 문자, 문자열)값 주입하기
* 스프링의 빈으로 등록되는 객체가 프로그램 실행에 필요한 정보를 전달받는 방법이다.
  - 실행에 필요한 정보 : ip주소, 저장경로, 업로드사이즈, db 연결정보
  - 작성예
```java
  public class MailService {
    private String host;
    private int port;
    // setter 메소드를 작성한다.
  }
```
    * 수동으로 주입하기
      * spring 환경설정파일에서 직접 값을 설정한다.
```xml
  <bean class="x.y.z.MailService">
    <property name="host" value="smtp.google.com"/>
    <property name="port" value="587" />	
  </bean>	
```
    * 프로그램 실행에 필요한 정보를 별도의 properties 파일로 관리하는 경우
      * &lt;context:property-placeholder location="설정파일의 전체경로 및 이름"/&gt; 태그를 사용한다.
      * 해당  설정파일을 읽어서 PropertyPlaceholder객체를 생성하고, 설정된 값을 보관한다.
      * ${표현식}을 사용해서 PropertyPlaceholder가 보관하고 있는 값을 조회할 수 있다.
      * 설정파일 작성
```properties
  # config.properties
  mail.host=smtp.google.com
  mail.port=587
```
      * 스프링 컨테이너가 설정파일 로드
```xml
  <context:property-placeholder location="config.properties" />
```
      * ${표현식}으로 설정파일의 값으로 치환시키기
```xml
  <bean class="x.y.z.MailService">
    <property name="host" value="${mail.host}"/>
    <property name="port" value="${mail.port}" />	
  </bean>
```
    * 자동으로 주입하기
      * &lt;context:component-scan /&gt;을 사용해서 자동으로 스프링 빈으로 등록하는 경우
      * @Value("${표현식}")을 사용해서 설정파일에 정의된 값을 주입할 수 있다.
      * 작성예
```java
  @Service
  public class MainService {

    @Value("${mail.host}")
    private String host;
    @Value("${mail.port}")
    private int port
  }
```

## 스프링의 데이터베이스 엑세스 처리
* 스프링은 다양한 데이터베이스 엑세스 기술을 지원한다.
  - spring-jdbc, ibatis, mybatis, jpa, hibernate 등의 데이터베이스 엑세스 기술을 지원하거나, 해당 기술과의 연동을 지원한다.
* Template 기반의 클래스를 지원한다.
  - 데이터베이스 엑세스 작업을 할 때 전처리작업과 후처리 작업이 미리 구현되어 있는 메소드를 제공한다. 개발자는 SQL과 파라미터값, 응답결과 처리만 구현하면 된다.
* 데이터베이스 엑세스 작업 중 오류가 발생하면 SQLException이 발생하게 되는데, 발생된 SQLException 대신 DataAccessException 을 던진다.
  - DataAccessException
    * unchecked 예외 
    * 예외처리를 강제하지 않는다.
    * 오류 상황에 맞는 다양한 DataAccessException의 하위 클래스를 제공한다.
* javax.sql.DataSource 인터페이스를 구현한 Connection Pool을 스프링을 빈으로 등록해야 한다.
  - 어떤 DB Access 기술을 사용하던지 데이터베이스와의 연결은 Connection Pool이 제공하는 Connection을 이용한다.
  - Connection Pool을 사용함으로써 일관된 방식으로 Connection을 획득할 수 있다.
  - DB Access 작업의 실행 속도도 향상된다.
* 선언적 트랜잭션 처리를 지원한다.
  - 트랜잭션 처리를 코드의 구현없이 간단한 설정만으로 필요한 곳에 적용시킬 수 있다.

### Spring JDBC
  * Java의 JDBC을 단순화시킨 데이터베이스 엑세스 기술이다.
  * 데이터베이스에 대한 CRUD 기능을 제공하는 JdbcTemplate 클래스를 활용한다.
  * 주요 API
    - int update(String sql, Object... args)
      * INSERT, UPDATE, DELETE sql을 실행한다.
    - T queryForObject(String sql,  RowMapper<T> rowmapper, Object... args)
      * SELECT sql을 실행한다.
      * 반드시 한 건의 데이터가 조회되어야 한다.
    - List<T> list(String sql, Rowmapper<T> rompper, Object... args)
      * Select sql을 실행한다.
      * 여러 건의 데이터를 조회한다.
  * 구현 절차
    1. pom.xml에 의존성 추가
      - spring-context, spring-jdbc, jdbc driver
    2. 어플리케이션 설정 파일 추가
      - src/main/resource/META-INF/config/application.properties
        * DB 연결 정보 설정
    3. Spring Bean Configuration  파일 추가
      - src/main/resource/META-INF/spring/context.xml
    4. Spring Bean Configuration 파일에 Connection Pool 빈으로 등록하기
     - 개발할 때는 DriverManagerDataSource를 스프링 빈으로 등록하기
     - DB 연결정보는 application.properties로부터 읽어온다.
     - &lt; context:property-placeholder location="설정파일 경로 및 파일명" /&gt;
    5. CRUD 기능을 포함하고 있는 JdbcTemplate를 스프링 빈으로 등록하기
      - CRUD작업시 필요한 Connection 획득을 위해서 Connection Pool빈을 참조해야 한다.
    6. 각각의 테이블에 대해서 데이터 엑세스 작업이 구현된 xxxDaoImpl을 스프링의 빈으로 등록
      - CRUD작업의 실행을 위해서 JdbcTemplate빈을 참조해야 한다.




