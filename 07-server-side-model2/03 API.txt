# Java 웹의 주요 클래스

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

## javax.servlet.Servlet	
- 인터페이스
- 모든 서블릿이 반드시 구현할 메소드를 정의하고 있다.
- 주요 메소드

| 반환타입 | 메소드명 | 설명 |
| --- | --- | --- |
| void | init() | 서블릿 객체 생성후 초기화 작업을 수행하기 위해 웹서버가 호출한다. |
| void | service(ServletRequest req, ServletResponse res) |  클라이언트의 요청이 접수되면 웹서버가 호출한다.|
| void | destroy() | 서블릿 객체를 폐기하기 전에 웹서버가 호출한다. |
| ServletConfig | getServletConfig() | 서블릿과 관련된 초기화파라미터값을 가진 ServletConfig객체를 반환한다. |

## javax.servlet.http.HttpServlet
- 클래스
- HTTP 기반의 서블릿이 반드시 상속받아야하는 클래스다.
- init(), service(ServletRequest req, ServletResponse res), destroy(), getServletConfig() 등의 메소드에 대한 기본구현을 제공한다.
- 주요 메소드

| 반환타입 | 메소드명 | 설명 |
| --- | --- | --- |
| void | doGet(HttpServletRequest req, HttpServletResponse res) | GET방식의 요청이 접수되면 웹서버가 호출한다. |
| void | doPost(HttpServletRequest req, HttpServletResponse res) | POST방식의 요청이 접수되면 웹서버가 호출한다. |
| void | service(HttpServletRequest req, HttpServletResponse res) | 클라이언트의 요청이 접수되면 웹서버가 호출한다. |
| ServletContext | getServletContext() | 웹 애플리케이션과 관련된 초기화파라미터 정보를 가진  ServletContext객체를 반환한다. |

## javax.servlet.ServletContext
- 인터페이스
- 웹서버가 구현을 담당한다.
- 웹 애플리케이션당 하나씩 생성된다.
- 애플리케이션 스코프를 제공한다.
- 초기화 파라미터값을 가지고 있다.
- 주요 API
			void		setAttribute(String name, String value)
				- 지정된 이름으로 속성(객체)를 저장한다.
			Object		getAttribute(String name)
				- 지정된 이름의 속성(객체)를 반환한다.
			void 		removeAttribute(String name)
				- 지정된 이름의 속성(객체)을 삭제한다.
			String		getInitParameter(String name)
				- 지정된 이름의 초기화 파라미터값을 반환한다.
			String		getRealPath(String path)
				- 지정된 경로에 대한 실제 경로를 반환한다.

	javax.servlet.ServletConfig
		- 인터페이스
		- 웹서버가 구현을 담당한다.
		- 서블릿의 초기화 파라미터값을 제공한다.
		- 서블릿, JSP마다 하나씩 생성된다.
		- 주요 API
			String		getInitParameter(String name)
				- 지정된 이름의 초기화 파라미터값을 반환한다.
			ServletContext  getServletContext()
				- ServletContext객체를 반환한다.

	javax.servlet.http.HttpSession
		- 인터페이스
		- 웹서버가 구현을 담당한다.
		- 클라이언트 식별하기 위한 정보를 저장한다.
		- 세션 스코프를 지원한다.
		- 주요 API
			void		setAttribute(String name, String value)
			Object		getAttribute(String name)
			void 		removeAttribute(String name)
			String		getId()
				- 세션 아이디를 반환한다.
			void		setMaxInactiveInterval(int second)
				- 세션 종료시간을 초단위로 지정한다.
			void 		invalidate()
				- 세션을 무효화시킨다.
			ServletContext	getServletContext()
				- ServletContext객체를 반환한다.

	javax.servlet.http.HttpServletRequest
		- 인터페이스
		- 웹서버가 구현을 담당한다.
		- 클라이언트가 서버로 보낸 요청메세지정보를 제공한다.
		- Request Scope를 제공한다.
		- 주요 API
			void		setAttribute(String name, String value)
			Object		getAttribute(String name)
			void 		removeAttribute(String name)
			String 		getParameter(String name)
				- 지정된 이름의 요청파라미터값을 반환한다.
			String[]	getParameterValues(String name)
				- 지정된 이름의 요청파라미터값을 배열에 담아서 반환한다.
			Cookie[]	getCookies()
				- 쿠키를 반환한다.
			HttpSession	getSession()
				- 세션아이디에 해당하는 HttpSession을 찾아서 반환한다.
				- HttpSession이 검색되지 않으면 새로 생성해서 반환한다.
			HttpSession	getSession(boolean create)
				- true인 경우 getSession() 메소드와 동일하게 동작한다.
				- false인 경우 HttpSession이 찾아지면 반환하고,
				  검색되지 않으면 null을 반환한다.
			Locale		getLocale()
				- 클라이언트의 로케일정보(국가, 사용언어)를 반환한다.
			String		getRemoteAddr()
				- 클라이언트의 ip주소를 반환한다.
			String		getRequestURI()
				- 요청URI를 반환한다.
			String 		getHeader(String name)
				- 지정된 이름의 요청헤더값을 반환한다.
			String		getMethod()
				- 클라이언트의 요청방식을 반환한다.(GET/POST 등)
			void		setCharacterEncoding(String charset)
				- 요청파라미터의 문자인코딩 방식을 지정한다.(한글처리)
			RequestDispatcher getRequestDispatcher(String path)
				- forward, include 기능을 제공하는 RequestDispatcher객체를 반환한다.
	
	javax.servlet.http.HttpServletResponse
		- 인터페이스
		- 웹서버가 구현을 담당한다.
		- 클라이언트로 보내는 응답을 담당한다.
		- 주요 API
			void		sendRedirect(String path)
				- 지정된 경로를 재요청하는 응답을 서버로 보낸다.
			void		setContentType(String contentType)
				- 응답데이터의 컨텐츠 타입을 지정한다.
				- 파일다운로드 구현시 사용된다.
			void 		addCookie(Cookie cookie)
				- 응답에 쿠키를 포함시킨다.
			void		setHeader(String name, String value)
				- 응답메세지에 지정된 이름과 값을 가진 헤더정보를 설정한다.
				- 파일다운로드 구현시 사용된다.
			void 		setStatus(int httpResponseCode)
				- HTTP 응답코드를 설정한다.(200, 404, 500)
			OutputStream	getOutputStream()
				- 클라이언트에게 바이너리데이터를 전송하는 스트림을 반환한다.
				- 파일다운로드 구현시 사용된다.
			PrintWriter	getWriter()
				- 클라이언트에게 문자데이터를 전송하는 스트림을 반환한다.
			
			
			
			




















			
	








			







		
