# JSP
- JavaServer Pages
- 동적 웹 컨텐츠를 응답으로 제공하는 웹애플리케이션을 개발할 때 사용되는 자바의 웹 기술
  + 동적 웹 컨텐츠 = HTML, XML, JSON, 바이너리 파일
- JSP는 HTML 태그로 구성된 문서내에서 자바코딩이 가능한 파일이다.
  + 자바코딩이 가능하기 때문에 DB Acess작업, 동적으로 태그를 생성하는 것도 가능
- JSP를 사용해서 개발된 웹 애플리케이션을 실행하기 위해서는 웹 애플리케이션 서버가 필요하다.
  + 대표적인 웹 애플리케이션 서버
    * Tomcat, Jetty, Jboss, Weblogic, JEUS

## Dynamic Web Project 구성
```
  src/main/java
    자바패키지 및 자바 클래스 정의
  src/main/webapp
    웹관련 리소스가 위치하는 폴더
  html, css, images, jsp등을 정의하거나 혹은 저장한다.
    (각각 파일마다 별도의 폴더를 만들어서 저장하는 것도 가능)
  META-INF폴더와 WEB-INF폴더는 클라이언트 접근이 차단된 폴더다.
    웹프로젝트와 관련된 설정파일들이 정의된다.
  WEB-INF/lib폴더는 웹프로젝트에서 사용되는 라이브러리 파일을 저장하는 폴더다.
    ibatis, jdbc driver, log4j 등의 jar파일을 저장함
```
## JSP의 실행 순서
1 브라우저의 주소창에 JSP의 실행을 요청하는 URL을 적는다.
2 브라우저는 주소창의 URL이 포함된 HTTP 요청메세지를 만들어서 서버로 보낸다.
3 Tomcat의 브라우저의 요청메세지를 접수받는다.
4 요청객체(HttpServletRequest)와 응답객체(HttpServletResponse)객체를 생성한다.
  + 요청메세지를 분석해서 요청객체에 전부 저장한다.
  + 응답메세지 제공을 책임질 응답객체도 함께 생성한다.
5 Tomcat이 요청URL을 분석해서 JSP 파일을 찾아서 로드한다.
6 JSP파일을 java파일로 변환한다
7 java파일을 컴파일해서 class파일을 만든다.
8 컴파일된 class파일 로드해서 객체를 생성한다.
9 Tomcat이 \_jspService(HttpServletRequest request, HttpServletResponse response)를 실행한다.
  + 실행시 4번에서 생성된 요청객체와 응답객체를 각각 request와 response 변수에 전달한다.
    * \_jspService 메소드는 jsp에서 진입점이 되는 메소드다.
    * \_jspService 메소드에는 jsp파일에서 작성한 모든 자바코드와 html 태그가 포함되어 있다.
    * jsp의 실행을 요청하는 것은 결국, \_jspService 메소드의 실행을 요청하는 것이다
    * jsp 파일을 작성한다는 것은 결국, \_jspService 메소드에 포함될 코드 및 태그를 작성하는 것이다.
10 \_jspService 메소드가 실행되면 응답컨텐츠가 스트림을 통해서 클라이언트로 보내진다.
11 브라우저는 응답메세지에 포함된(응답컨텐츠)를 화면에 표시한다.

## JSP의 구성요소
- 디렉티브(지시어)
  + &lt;%@ jsp 페이지 설정 정보%&gt;
	+ JSP 페이지에 대한 설정정보를 정의하는 JSP의 구성요소다.
  ```jsp
    <%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
    <%@ include file="common/header.jsp" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  ```
- 스크립틀릿
  + &lt;% 자바 코드 %&gt;
  + JSP 페이지에서 java 코딩영역을 생성하는 JSP의 구성요소다.
  ```jsp
    <%
      BookService bookService = BookService.getInstance();
      List<Book> books = bookService.getAllBooks();
      
      for (Book book : books) {
      
      }
    %>
  ```
- 표현식
  + &lt;%=변수명 혹은 반환값이 있는 메소드%&gt;
  + 변수의 값을 출력에 포함시킬 때 사용하는 JSP의 구성요소다.
  ```jsp
    <%
      int bookNo = Integer.parseInt(request.getParameter("no"));
      BookService bookService = BookService.getInstance();
      Book book = bookService.getBookInfo(bookNo);
    %>
    <dl>
      <dt>제목</dt><dd><%=book.getTitle() %></dd>
      <dt>저자</dt><dd><%=book.getWrite() %></dd>
      <dt>쟝르</dt><dd><%=book.getGenre() %></dd>
      <dt>가격</dt><dd><%=book.getPrice() %></dd>
      <dt>재고량</dt><dd><%=book.getStock() %></dd>
      <dt>상태</dt><dd><%=book.getStatus() %></dd>
    </dl>
  ```
- 선언식	
  + &lt;%! 변수 선언 혹은 메소드 정의 %&gt;
  + 스크립틀릿이나 표현식에서 사용가능한 메소드를 작성할 때 사용하는 JSP의 구성요소다.
  ```jsp
    <%-- 스크립틀릿과 표현식에서 사용할 수 있는 메소드 정의 --%>
    <%!
      private DecimalFormat df = new DecimalFormat("##,###");
      private String numberToCurrency(long number) {
        return df.format(number);
      }
    %>
    
    <%-- 선언식에 정의한 메소드 사용하기 --%>
    <%
      int bookNo = Integer.parseInt(request.getParameter("no"));
      BookService bookService = BookService.getInstance();
      Book book = bookService.getBookInfo(bookNo);
      
      String currency = numerToCurrency(book.getPrice());
    %>
    <dl>
      <dt>제목</dt><dd><%=currency %> 원</dd>
    </dl>
  ```
- 주석	
  + &lt;%-- 주석문--%&gt; 
  + JSP 페이지의 코드를 주석처리할 때 사용하는 JSP의 구성요소다.
  ```jsp
    <%-- jsp 주석을 여기에 적는다. -->
    
    <%-- 아래의 모든 코드는 주석처리되어서 실행되지 않는다. --%>
    <%--
      int bookNo = Integer.parseInt(request.getParameter("no"));
      BookService bookService = BookService.getInstance();
      Book book = bookService.getBookInfo(bookNo);
    --%>
  ```
	
