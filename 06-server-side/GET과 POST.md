# 클라이언트의 요청방식
- 클라이언트가 서버로 요청 메세지를 보내는 방식
	
## GET 방식의 요청
- 주소창에 주소를 입력해서 요청하는 경우

### GET 방식의 요청이 발생하는 경우
- 링크를 클릭해서 요청하는 경우
```
<a href="web/about.jsp">회사소개</a>일 때 회사소개를 클릭한 경우
```
- form태그의 method 속성을 지정하지 않고, 폼 입력값을 서버로 체출하는 경우
```html
  <form action="search.jsp">
    <input type="text" name="keyword" placeholder="검색어를 입력하세요" />
    <button type="submit">검색</button>
  </form>
  <!-- 위와 같이 작성된 웹 페이지에서 검색버튼을 클릭했을 때  -->
```
- form태그의 method 속성을 GET으로 지정하고, 폼 입력값을 서버로 제출하는 경우
```html
  <form method="GET" action="search.jsp">
    <input type="text" name="keyword" placeholder="검색어를 입력하세요" />
    <button type="submit">검색</button>  
  </form>
  <!-- 위와 같이 작성된 웹 페이지에서 검색버튼을 클릭했을 때 -->
```

### GET방식의 요청을 사용할 때
- 서버로부터 데이터를 조회할 때
- 데이터의 흐름 : 서버에서 클라이언트 방향이다.
  - 주소창에 주소를 입력해서 웹 페이지를 요청한다.
  - 링크를 클릭해서 링크에 지정된 주소의 웹 페이지를 요청한다.
  - 검색창에 검색어를 입력하고, 해당 검색 결과 페이지를 요청한다.

### GET방식의 특징
- 서버로 전달되는 값이 요청URL에 뒤에 붙어서 전달된다.
```html
  <form action="search.jsp">
    <input type="text" name="keyword" placeholder="검색어를 입력하세요" />
    <button type="submit">검색</button>
  </form>
  <!-- 검색버튼을 클릭하면 아래와 같은 URL을 서버로 보낸다. -->
  <!-- http://localhost/web/search.jsp?keyword=자바 -->
```
- 서버로 전달되는 데이터의 크기에 제한이 있다.
- 첨부파일을 보낼 수 없다.

### GET 방식 요청일 때 요청 메세지
- 요청메세지의 바디부가 비어있다.
```
  GET search.jsp?keyword=자바 HTTP/1.1
  Accept=text/html,application/xhtml+xml,application/xml;q=0.9
  Accept-Encoding=gzip, deflate, br
  Accept-Language=ko,en;q=0.9,en-US;q=0.8

```

## POST 방식의 요청

### POST 방식의 요청이 발생하는 경우
- form태그의 method 속성을 POST로 지정하고, 폼 입력값을 서버로 제출하는 경우
```html
  <form method="POST" action="register.jsp">
    <input type="text" name="name" placeholder="이름을 입력하세요" />
    <input type="text" name="id" placeholder="아이디를 입력하세요" />
    <input type="password" name="pwd" placeholder="비밀번호를 입력하세요" />
    <input type="text" name="tel" placeholder="전화번호를 입력하세요" />
    <input type="text" name="email" placeholder="이메일을 입력하세요" />
    <input type="text" name="zipcode" placeholder="우편번호를 입력하세요" />
    <input type="text" name="address" placeholder="주소를 입력하세요" />
    <button type="submit">회원가입</button>
  </form>
  <!-- 위와 같이 작성된 웹 페이지에서 회원가입버튼을 클릭했을 때 -->
```

### POST방식의 요청을 사용할 때
- 클라이언트에서 서버로 데이터를 보낼 때
- 데이터의 흐름 : 클라이언트 ---> 서버
  - 회원가입폼에서 회원정보를 입력하고 서버로 제출한다.
  - 주문정보입력폼에서 주문정보를 입력하고 서버로 제출한다.
  - 게시글 작성폼에서 게시글정보를 입력하고 서버로 제출한다.
  - 로그인폼에서 아이디와 비밀정보를 입력하고 서버로 제출한다.
  - 인스타그램에서 사진과 내용을 입력하고 게시한다.
 
### POST방식의 특징
- 입력폼에 입력한 모든 정보가 요청메세지의 바디부에 담겨서 서버로 제출된다.
- 서버로 전달되는 데이터의 크기에 제한이 없다.
- 첨부파일 업로드가 가능하다.

### POST 방식 요청일 때 요청 메세지
- 요청 메세지의 바디부에 폼입력값이 포함되어 있다.
```
  POST register.jsp HTTP/1.1
  Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9		
  Accept-Encoding=gzip, deflate, br
  Accept-Language=ko,en;q=0.9,en-US;q=0.8
  
  name=홍길동&id=hong&pwd=zxcv1234&tel=010-1234-5678&email=hong@gmail.com
```
				
