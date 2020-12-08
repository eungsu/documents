# JSP의 내장객체
- JSP 페이지가 자바로 변환될 때 _jspService메소드에서 사용가능한 객체
- JSP는 웹 애플리케이션 개발에 필요한 객체를 미리 생성(획득)해서 적절한 변수에 저장하고, 스크립트릿에서 사용가능한 상태로 초기화시켜놓는다.

| 변수명 | 클래스명 | 설명 |
| --- | --- | --- |
| **request** | **HttpServletRequest** | **클라이언트가 보낸 요청메세지 정보를 저장한다.** |
| **response** | **HttpServletResponse** | **클라이언트로 보낼 응답메세지 정보를 저장한다.** |
| **session** | **HttpSession** | **세션정보를 저장한다.(로그인처리와 관련)** |
| out | JspWriter | 응답컨텐츠를 클라이언트로 출력하는 스트림 |
| application | ServletContext | 웹 애플리케이션 프로젝트 정보를 저장한다. |
| config | ServletConfig | JSP 페이지와 관련된 설정 정보를 저장한다. | 
| pageContext| PageContext | JSP 페이지에 대한 정보를 저장한다. |
| exception | Throwable | 에러정보를 저장한다.(isErrorPage="true")에서만 사용가능 |
| page | Object | JSP 페이지를 구현한 자바객체가 저장된다. |

## HttpServletRequest
- request 변수에 저장된다.
- 클라이언트가 서버로 보낸 요청 메세지를 저장하고 있다
- 요청메세지정보를 획득할 수 있는 다양한 getXXX() 메소드를 제공한다.
- 주요 메소드

| 반환타입 | 메소드명 | 설명 |
| --- | --- | --- |
| String | **getParameter(String name)** | 지정된 이름의 요청파라미터값을 반환한다.<br/>요청파라미터값이 없으면 null을 반환한다 |
| String[] | **getParameterValues(String name)** | 지정된 이름의 모든 요청파라미터값을 배열의 형태로 반환한다<br/>요청파라미터값이 없으면 null을 반환한다 |
| void | **setCharacterEncoding(String encoding)** | 요청파라미터값을 지정된 인코딩방식으로 복원한다 |
| void | **setAttribute(String name, Object value)** | 요청객체에 이름,객체 쌍의 속성(객체)을 저장한다. |
| Object | **getAttribute(String name)** | 요청객체에서 지정된 이름으로 저장된 속성(객체)를 반환한다.<br/>지정된 이름의 속성이 존재하지 않으면 null을 반환한다. |
| void | **removeAttribute(String name)** | 요청객체에서 지정된 이름으로 저장된 속성(객체)을 삭제하다. |
| HttpSession | getSession() | 요청객체의 세션아이디에 해당하는 세션객체를 반환한다.<br/>세션아이디가 없으면 세션객체를 새로 생성한 후 반환한다.<br/>세션아이디에 해당하는 세션객체가 없으면 새로 생성한 후 반환한다 |
| HttpSession | getSession(boolean create) | create값을 true로 설정하면 위의 getSession() 메소드와 동일.<br/>create값을 false로 설정하면 세션아이디에 해당하는 세션객체가 <br/> 있을 때만 세션객체를 반환하고, 아닌 경우 null을 반환한다 |
| String | getHeader(String name) | 지정된 이름의 요청헤더값을 반환한다 |
| String | getRequestURI() | 요청 URI 경로를 반환한다 |
| String | getContextPath() | 현재 웹애플리케이션의 컨텍스트 경로를 반환한다 |
| String | getRemoteAddr() | 요청을 보낸 클라이언트의 ip주소를 반환한다 |

## HttpServletResponse
- response 변수에 저장된다.
- 서버가 클라이언트로 보낼 응답 메세지를 책임진다.
- 응답메세지에 대한 다양한 정보를 설정할 수 있는 setXXX() 메소드를 제공한다.
- 주요 메소드

| 반환타입 | 메소드명 | 설명 |
| --- | --- | --- |
| void | **sendRedirect(String url)** | 지정된 url을 재요청하게 하는 응답을 보낸다 |
| void | setContentType(String type) | 응답컨텐츠의 타입을 설정한다 |
| void | setStatus(int statuscode) | HTTP 응답코드를 설정한다 |
| void | setHeader(String name, String value) | 응답헤더값을 설정한다 |

## HttpSession
- session 변수에 저장된다.
- 클라이언트별로 고유하게 사용되는 객체다.
- 고유한 아이디를 가지고 있다. 
- 클라이언트가 처음 접속할 때 자동 생성되고, 생성된 HttpSession객체의 아이디가 응답으로 클라이언트에게 보내진다.
- 세션아이디를 전달받은 클라이언트는 요청할 때 마다 세션아이디를 요청헤더에 담아서 서버로 전송한다.
- 서버는 요청헤더의 세션아이디를 조회해서 그 아이디에 해당하는 세션객체를 실행되는 JSP의 sessioin변수에 저장한다.
- 용도
  + 클라이언트의 정보를 보관하기
    * 클라이언트별로 각각 다른 세션객체를 사용하기 때문에 
    * 로그인한 사용자정보, 장바구니정보, 최근 본 상품정보 (클라이언트의 private한 정보)
  + 클라이언트의 상태 유지
    * 접속한 클라이언트를 식별해서(누군지 안다.) 
    * 해당 클라이언트에게 적절한 응답을 제공할 수 있다.
- 주요 메소드

| 반환타입 | 메소드명 | 설명 |
| --- | --- | --- |
| void | **setAttribute(String name, Object value)** | 세션객체에 이름,객체 쌍의 속성(객체)을 저장한다. |
| Object | **getAttribute(String name)** | 세션객체에서 지정된 이름으로 저장된 속성(객체)를 반환한다.<br/>지정된 이름의 속성이 존재하지 않으면 null을 반환한다. |
| void | **removeAttribute(String name)** | 세션객체에서 지정된 이름으로 저장된 속성(객체)을 삭제하다. |
| void | **invalidate()** | 세션객체를 무효화시킨다.<br/>로그아웃 요청시 실행한다 |
| void | setMaxInactiveInterval(int second) | 세션객체의 최대 비활성화 시간을 초단위로 설정한다<br/>지정된 시간동안 세션객체에 대한 엑세스가 없으면 세션객체는 무효화된다 |
| String | getId() | 세션객체의 고유한 아이디를 반환한다 |



