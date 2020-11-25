# 웹 애플리케이션 개요

## Tomcat
- Web Application Server(WAS)
- Web Application Program을 실행시켜주는 서버다.
- 웹 애플리케이션 전용 서버다.
- Servlet/JSP 엔진, Servlet/JSP 컨테이너의 역할을 수행하는 서버다.

## URL과 웹페이지 vs URL과 웹애플리케이션
- URL(Uniform Resource Locator)
  + 자원(웹페이지, 웹애플리케이션, 그림, 동영상, 파일)의 위치를 나타내는 주소다.
  + 서버에 있는 자원을 요청할 때 클라이언트가 입력하는 주소다.
  + 일반적으로 웹에서 웹브라우져(클라이언트)의 주소창에 URL을 입력하면
	  * 웹브라우져가 해당 URL을 서버로 전달한다. (웹서버는 URL이 나타내는 주소에 해당 자원이 존재하면 그 자원을 응답으로 제공한다.)
  + URL 형식
    * http://jhta.co.kr/page/edu/view.php?type=1&id=179
      - http : 프로토콜
      - jhta.co.kr: 호스트명, 서버명, 도메인네임
      - /page/edu/view.php : 실제 자원의 위치(웹애플리케이션의 위치)
			- type=1&id=179 : 쿼리스트링(서버에 보내는 추가정보)
- 웹페이지와 웹애플리케이션
  + 웹 페이지
    * 정적 자원(정적 HTML 컨텐츠) 제공
    * 미리 작성해둔 html문서가 응답으로 제공되는 것
  + 웹 애플리케이션
    * 동적 자원(동적 HTML 컨텐츠) 제공
    * 동적 웹 컨텐츠를 제공하는 프로그램(Servlet/JSP)이다.

## 웹브라우저와 웹서버
- 웹브라우저
  + 클라이언트의 역할을 수행한다.
  + URL을 서버로 전송해서 웹페이지를 요청하거나 웹애플리케이션의 실행을 요청한다.
- 웹서버
  + 서버의 역할을 수행한다.
  + 클라이언트가 전송한 URL을 분석해서 해당 웹페이지를 응답으로 제공하거나, 해당 웹애플리케이션을 실행해서 동적 컨텐츠를 응답으로 제공한다.
  + 웹서버(HTTP 프로코롤을 사용하는)는 일반적으로 80포트에 바인딩된다.
    * 80포트에서 실행중인 웹서버에 요청을 보낼때는 URL에서 포트번호를 생략할 수 있다.
    * 80포트가 아니면 http://호스트명:/경로/파일명?쿼리스트링

## HTTP
- HyperText Transfer Protocol
- 웹브라우져와 웹서버 간의 메세지 교환시 사용되는 규칙을 정의하고 있다.
- 요청메세지와 응답메세지의 작성규칙을 정의하고 있다.
- HTTP의 메세지 작성 규칙
  + 요청 메세지
    * 클라이언트(웹브라우저)가 서버로 보내는 메세지
    * 요청 메세지 = Request Header + 빈줄 + Request Body
    * 요청헤더부 = 요청라인 + 요청헤더정보
  + 응답 메세지 
    * 서버가 클라이언트로 보내는 메세지
    * 응답 메세지 = Response Header + 빈줄 + Response Body
    * 응답헤더부 = 응답라인 + 응답헤더정보

## JSP
- JavaServer Pages
- 동적 웹 컨텐츠를 응답으로 제공하는 웹애플리케이션을 개발할 때 사용되는 자바의 웹 기술
  + 동적 웹 컨텐츠 = HTML, XML, JSON, 바이너리 파일
- JSP는 HTML 태그로 구성된 문서내에서 자바코딩이 가능한 파일이다.
  + 자바코딩이 가능하기 때문에 DB Acess작업, 동적으로 태그를 생성하는 것도 가능
- JSP를 사용해서 개발된 웹 애플리케이션을 실행하기 위해서는 웹 애플리케이션 서버가 필요하다.
  + 대표적인 웹 애플리케이션 서버
    * Tomcat, Jetty, Jboss, Weblogic, JEUS

### Dynamic Web Project 구성
```
  java Resources의 src
    자바패키지 및 자바 클래스 정의
  WebContent
    웹관련 리소스가 위치하는 폴더
  html, css, images, jsp등을 정의하거나 혹은 저장한다.
    (각각 파일마다 별도의 폴더를 만들어서 저장하는 것도 가능)
  META-INF폴더와 WEB-INF폴더는 클라이언트 접근이 차단된 폴더다.
    웹프로젝트와 관련된 설정파일들이 정의된다.
  WEB-INF/lib폴더는 웹프로젝트에서 사용되는 라이브러리 파일을 저장하는 폴더다.
    ibatis, jdbc driver, log4j 등의 jar파일을 저장함
```
### JSP의 실행 순서
- 브라우저의 주소창에 JSP의 실행을 요청하는 URL을 적는다.
- 브라우저는 주소창의 URL의 포함된 HTTP 요청메세지를 만들어서 서버로 보낸다.
- Tomcat의 브라우저의 요청메세지를 접수받는다.
- 요청객체(HttpServletRequest)와 응답객체(HttpServletResponse)객체를 생성한다.
  + 요청메세지를 분석해서 요청객체에 전부 저장한다.
  + 응답메세지 제공을 책임질 응답객체도 함께 생성한다.
- Tomcat이 요청URL을 분석해서 JSP 파일을 찾아서 로드한다.
- JSP파일을 java파일로 변환한다
- java파일을 컴파일해서 class파일을 만든다.
- 컴파일된 class파일 로드해서 객체를 생성한다.
- Tomcat이 \_jspService(HttpServletRequest request, HttpServletResponse response)를 실행한다.
  + 실행시 4번에서 생성된 요청객체와 응답객체를 각각 request와 response 변수에 전달한다.
    * \_jspService 메소드는 jsp에서 진입점이 되는 메소드다.
    * \_jspService 메소드에는 jsp파일에서 작성한 모든 자바코드와 html 태그가 포함되어 있다.
    * jsp의 실행을 요청하는 것은 결국, \_jspService 메소드의 실행을 요청하는 것이다
    * jsp 파일을 작성한다는 것은 결국, \_jspService 메소드에 포함될 코드 및 태그를 작성하는 것이다.
- \_jspService 메소드가 실행되면 응답컨텐츠가 스트림을 통해서 클라이언트로 보내진다.
- 브라우저는 응답메세지에 포함된(응답컨텐츠)를 화면에 표시한다.


### JSP의 구성요소
- 디렉티브(지시어)
  + &lt;%@ jsp 페이지 설정 정보%&gt;
	+ JSP 페이지에 대한 설정정보를 정의하는 JSP의 구성요소다.
  ```jsp
    <%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-9" %>
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
      <dt>제목</dt><dd><<%=book.getTitle())/dd>
      <dt>저자</dt><dd><<%=book.getWrite())/dd>
      <dt>쟝르</dt><dd><<%=book.getGenre())/dd>
      <dt>가격</dt><dd><<%=book.getPrice())/dd>
      <dt>재고량</dt><dd><<%=book.getStock())/dd>
      <dt>상태</dt><dd><<%=book.getStatus())/dd>
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
      <dt>제목</dt><dd><%=currency%> 원</dd>
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
	
