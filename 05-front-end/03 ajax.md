# Ajax(Asynchronous JavaScript and XML)
- 자바스크립와 XML(JSON)을 활용한 서버와의 비동기 데이터 통신
- XMLHttpRequest 객체를 활용해서 서버와 데이터 통신을 한다.
## 특징
- 자바스크립트로 서버와 데이터 통신이 가능해졌다.
- 페이지의 리로딩없이 화면을 일부분을 갱신하는게 가능해졌다. (서버로부터 데이터를 가져와서.)
## 대표적인 기능
- 구글 맵
- 포털사이트 검색기능
- 대분류의 하위분류를 조회하는 기능
- 
## XMLHttpRequest
- 웹브라우저의 화면 뒤에서 웹서버와 HTTP통신으로 데이터교환이 가능한 객체
-전체 페이지의 리로딩없이 웹페이지의 일부분을 서버로부터 받아온 데이터로 갱신하는 것이 가능하다
- 모든 브라우저에 내장되어 있다. (Chrome, Firefox, IE7+, Edge, Safari, Opera)
### 주요 API
- Property
  - onreadystatechange
    - XMLHttpReqest의 readyState 상태가 변경될 때 마다 실행될 콜백함수를 정의한다.
```javascript
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
      // 서버가 보낸 데이터 조회
      // 데이터를 사용해서 HTML 컨텐츠 제작
      // HTML 컨텐츠를 화면의 특정위치에 반영
    }
  }
```
  - readyState
    - XMLHttpRequest객체의 현재 상태를 반환한다.
      - 0 : 요청이 초기화되지 않았다.
      - 1 : 서버와 연결되었다.
      - 2 : 서버가 요청을 받았다.
      - 3 : 서버가 요청을 처리하는 중이다.
      - 4 : 서버가 요청처리를 끝내고 응답데이터를 보낼 준비가 되었다.
  - status
    - 요청에 대한 HTTP 응답코드를 반환한다.
      - 200 : OK
      - 404 : Not Found
      - 500 : Server Error
  - responseText
    - 서버로부터 받은 데이터를 문자열로 반환한다.
  - responseXML
    - 서버로부터 받은 데이터를 XML Document객체로 반환한다.
- Method
    - var xhr = new XMLHttpRequest()
      - XMLHttpRequest 객체 생성
    - xhr.open(method, url, async, user, password)
      - XMLHttpRequest 객체를 초기화한다.
        - method : "GET", "POST"
        - url    : 요청URL
        - async  : true(비동기 동작), false(동기식동작)
        - user/password : 사용자 인증정보
    - xhr.send()	
      - 서버로 요청을 보낸다.(GET방식의 요청일 때 사용)
    - xhr.setRequestHeader()
      - POST방식일 때 HTTP 요청메세지의 헤더정보를 설정한다.
        - xhr.open("POST", "test.jsp")
        - xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    - xhr.send(string)
      - 서버로 요청을 보낸다.(POST방식의 요청일 때 사용)
        - xhr.send("title=안녕&contents=안녕하세요");


## JSON(JavaScript Object Notation)
- 경량의 DATA-교환 형식이다.
- 경량의 DATA-표기법 이다.
### 특징
- 사람이 읽고 쓰기 쉽다.
- 기계로 분석하고 생성하기 쉽다.(코드가 단순해진다.)
- 프로그램언어로부터 완전히 독립적이다.
- 서로 다른 시스템간의 데이터교환에 이상적인 DATA-교환 형식이다.
### 형식
- Object 표기법
  - {name:value, name:value, name:value}
  - name/value쌍으로 구성된 콜렉션 <--- 자바의 ValueObject/Map, 자바스크립트의 Object
  - name은 문자열만 가능
  - value는 문자열, 숫자, Object, Array, true, false, null
  - 작성예
```
public class Book {
	int no; String title; String writer; String publisher; int price;
}

{"no":10, "title":"이것이 자바다", "writer":"홍길동", "price":31000}
```
```
public class Team {
	String name; List<String> members;
}

{"name":"트와이스", "members":["나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"]}
```
```
public class Student {
	String name; Major major;
}
public class Major {
	String name; String grade;
}

{"name":"홍길동", "major":{"name":"전자공학", "grade":"석사"}}
```
```
Map<String, Object> map = new HashMap<String, Object>();
map.put("keyword", "자바");
map.put("records", 3);
map.put("items", books)	<- List<Book> books = bookDao.searchBooks(title);

{"keyword":"자바", 
 "records":3, 
 "items":[
     {"title":"이것이 자바다", "publisher":"한빛미디어"},
     {"title":"자바의 정석", "publisher":"한빛미디어"},
     {"title":"생활코딩 자바편", "publisher":"한빛미디어"}	
  ]
}
```
- Array 표기법
  - [value, value, value]
  - 값들의 순서화된 리스트 , 자바의 배열/List, 자바스크립트의 배열
  - 작성예
``` 
  String[] names = {"김유신", "강감찬", "홍길동"}
  
  ["김유신", "강감찬", "홍길동", "이순신"]
```
```
  public class Category {
	int no; String name;
  }
  List<Category> categories = categoryDao.getAllCategories();
  
  [{"no":100, "name":"가구"}, {"no":"200", "name":"가전제품"}]
```

## 자바와 자바스크립트에서 JSON
|--|--|--|--|
| Java | json 텍스트 | JavaScript | 타입 |
| VO, Map | {"name":value, "name":value} |  JSON.parse(text) | 객체 |
| 배열,List | [value, value, value, value] | JSON.parse(text) | 배열 |
| VO, Map | {"name":value, "name":value} | JSON.stringify(객체) | 객체 |
| 배열,List |[value, value, value, value] | JSON.stringify(배열) | 배열 |

- 자바의 VO, Map, 배열, List 등에 저장된 데이터를 다른 시스템으로 전달할 때 JSON텍스트로 변환해서 전달할 수 있다.
- 자바의 VO, Map, 배열, List를 JSON 텍스트로 변환할 때 다양한 라이브러리를 사용할 수 있다.
- 자바스크립트는 JSON.parse()와 JSON.stringify()를 사용해서 간단하게 JSON 표기법의 텍스트를 자바스크립틔 객체와 배열로 변경할 수 있고,  자바스크립트의 객체 및 배열을 JSON 표기법의 텍스트로 변경할 수 있다.










	
		
