# DOM(Document Object Model)
- 문서객체 모델
- HTML, XML 등의 문서를 엑세스하는 표준을 정의하고 있다.
  - DOM은 w3c에서 HTML, XML 문서를 다루는 표준(인터페이스)를 정의한 것이다.
  - DOM에 정의된 표준에 대한 구현은 브라우저 제조사, 프로그래밍 언어 개발사, 라이브러러 개발자가 담당한다.
  - DOM에서 정의한 표준은 브라우저 종류나, 프로그래밍 언어의 종류에 상관없이 동일한 API로 구현되어 있다.

## DOM의 특징
- 모든 엘리먼트는 객체다.
- 모든 엘리먼트의 프로퍼티를 정의하고 있다.
- 엘리먼트를 엑세스하는 메소드를 정의하고 있다.
- 모든 엘리먼트의 이벤트를 정의하고 있다.

## DOM의 주요 객체

| 객체 | 설명 |
|---|---|
| Document | 웹 브라우저 HTML 문서를 로딩했을 때, Document 객체가 된다.|
| Element| HTML의 태그를 표현하는 객체다.<br> Document객체에는 현재 로딩된 HTML문서의 모든 태그에 대한 Element객체가 포함되어있다.|
| Attr | HTML 태그의 속성을 표현하는 객체다. |
| HTMLCollection | Element객체를 여러 개 포함할 수 있는 배열유사객체다. |
| Event |사용자가 웹 페이지와 상호작용할 때 마다 엘리먼트에서 발생되는 객체다.|

## DOM의 주요 API
### Document 객체
#### 메소드

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| Element | createElement("태그명") | 지정된 태그명의 Element 객체 생성한다.|
| Attr | createAttribute("속성명", "속성값")| 지정된 속성정보를 가진 Attr 객체를 생성한다. |
| TextNode | createTextNode("텍스트컨텐츠")| 지정된 텍스트내용을 가지는 TextNode객체를 생성한다. |
| Element | **getElementById("id")** |지정된 id에 해당하는 Element객체를 반환한다. |
| HTMLCollection | getElementsByTagName("태그명")| 지정된 태그명에 해당하는 모든 Element객체를 HTMLCollection에 담아서 반환한다.|
| HTMLCollection | getElementsByClassName("클래스")| 지정된 클래스를 가지고 있는 모든 Element객체를 HTMLCollection에 담아서 반환한다.|
| Element | **querySelector("CSS선택자")** | 지정된 선택자로 검색된 첫번째 Elemenet객체를 반환한다.|
| HTMLCollection | **querySelectorAll("CSS선택자")** | 지정된 선택자로 검색된 모든 Element객체를 HTMLCollection에 담아서 반환한다.|

### Element 객체
#### Property

|프로퍼티명|설명|
|---|---|
| tagName | Element의 태그명을 반환한다.|
| **textContent** | Element의 텍스트 컨텐츠를 조회/변경할 수 있다.|
| **innerHTML** | Element의 html 컨텐츠를 조회/변경할 수 있다. |
| id | Element의 id값을 반환한다. |
| style | 해당 엘리먼트의 style 정보가 포함된 객체를 반환한다 | 
| children | 해당 엘리먼트의 자식엘리먼트들을 반환한다 |
| parentElement | 해당 엘리먼트의 부모 엘리먼트를 반환한다. |
| **value** | input, select, textarea Element의 값을 조회/변경할 수 있다.|
| **disabled** | input, select, textarea, button Element의 비활성화 여부를 조회/변경할 수 있다. <br> true는 비활성화, false는 활성화 |
| readOnly |  input, select, textarea, button Element의 읽기전용 여부를 조회/변경할 수 있다. <br>true는 읽기전용, false는 편집가능 |
| **checked** | checkbox, radio Element의 비활성화 여부를 조회/변경할 수 있다. <br> true는 체크상태, false는 체그상태아님 |
| options | select Element의 모든 option Element객체를 HTMLCollection에 담아서를 반환한다.|
| selectedIndex | select Element의 현재 선택된 옵션의 인덱스를 조회/변경할 수 있다. |
	
#### Method

| 반환값 | 메소드명 | 설명 |
|---|---|--|
| HTMLCollection | getElementsByTagName("태그명")| 지정된 태그명에 해당하는 모든 Element객체를 HTMLCollection에 담아서 반환한다.|
| HTMLCollection | getElementsByClassName("클래스")| 지정된 클래스를 가지고 있는 모든 Element객체를 HTMLCollection에 담아서 반환한다.|
| Element | **querySelector("CSS선택자")** | 지정된 선택자로 검색된 첫번째 Elemenet객체를 반환한다.|
| HTMLCollection | **querySelectorAll("CSS선택자")** | 지정된 선택자로 검색된 모든 Element객체를 HTMLCollection에 담아서 반환한다
|  | **remove()** | 엘리먼트를 삭제한다 |
| Node | insertBefore(Element) | 지정된 엘리먼트를 첫 번째 자식노드로 추가한다. |
| Node | **appendChild(Element)** |지정된 엘리먼트를 맨 마지막 자식노드로 추가한다.|
| Node | **removeChild(Element)** | 지정된 자식 엘리먼트를 삭제한다. |
| Element | firstElementChild() |해당 엘리먼트의 첫번째 자식 엘리먼트를 반환한다. |
| Element | lastElementChild() |해당 엘리먼트의 마지막 자식 엘리먼트를 반환한다. |
| Element | previousElementSibling() | 해당 엘리먼트의 형제 중 바로 앞에 위치한 엘리먼트를 반환한다. |
| Element | nextSibling(), nextElementSibling() | 해당 엘리먼트의 형제 중 바로 뒤에 위치한 엘리먼트를 반환한다. |
| String | **getAttribute("속성명")** | 해당 엘리먼트에서 지정된 속성명에 해당하는 속성값을 반환한다. |
|  | **setAttribute("속성명", "속성값")** | 해당 엘리먼트에서 속성을 변경/추가한다.|
|  | removeAttribute("속성명") |  해당 엘리먼트에서 지정된 속성을 삭제한다. |
| boolean | hasAttribute("속성명") | 해당 엘리먼트가 지정된 속성을 가지고 있으면 true를 반환한다. |
	
### HTMLCollection 객체
#### Property

|프로퍼티명|설명 |
|---|---|
| **length** |  저장된 갯수를 반환한다. |

#### Method

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| Element | **item(index)** | 인덱스 번호에 해당하는 Element객체를 반환한다.|

```javascript
  var collections = document.getElementsByTagName("p")
  for (var i=0; i<collections.length; i++) {
    var el = collections.item(i);
    var el = collections[i];
  }
```

### Event 객체
#### 프로퍼티

|프로퍼티명|설명 |
|---|---|
| **target** | 이벤트가 발생된 엘리먼트객체를 반환한다.|
| type | 발생된 이벤트이름을 반환한다. |
| dataTransfer | drag & drop에서 값을 전달하기 위한 객체를 반환한다.|
| pageX, pageY | 마우스의 현재 좌표를 반환한다. |
| which | 입력한 문자의 아스키코드값을 반환한다. |

#### Method

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| | **preventDefault()** |  해당 엘리먼트에 특정 이벤트 발생시 실행할 기본동작이 지정되어 있는 경우 그 동작의 실행을 취소시킨다.<br> &lt;form&gt; 태그 안에서 button, submit 버튼 클릭시 폼이 전송되는 것 &lt;a&gt; 태그 클릭시 지정된 링크로 이동하는 것 |
| | stopPropagation() | 이벤트 버블링을 중지시킨다. |
| | **stopImmediatePropagation()** | 이벤트 버블링을 중지시킨다. |

## BOM(Browser Object Model)
- Browser Object Model
- 브라우저에 빌트인된 객체들이다.
- 자바스크립트를 사용해서 BOM객체들과 상호작용할 수 있다.
### 종류
#### Window
- 브라우저의 윈도우를 표현하는 객체다.
- 다른 BOM객체를 저장하고 있다.
- Docoument 객체를 저장하고 있다.
- 자바스크립트의 전역객체(Global Object)다.
  - (자바스크립트로 생성하는 객체, 함수, 변수는 자동으로 Window객체의 멤버가 된다.)
- 자바스크립트에서 특별한 객체의 이름을 지정하지 않고 변수, 함수를 사용하는 경우 기본적으로 Window객체에서 찾는다.

#### 프로퍼티

|프로퍼티명|설명 |
|---|---|
| document| Document 객체를 반환한다.|
| location |Location 객체를 반환한다. |
| history |History 객체를 반환한다.|
| navigator |Navigator 객체를 반환한다.|
| screen | Screen 객체를 반환한다. |
| console | Console 객체를 반환한다. |
| opener | 현재 윈도우를 생성한 윈도우객체를 반환한다. <br>팝업창에서 그 팝업창을 생성한 윈도우가 opener다. |

#### 메소드

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| | **alert("메세지")** | 경고메세지창을 표시한다.|
| boolean | confirm("메세지")| 확인/취소 버튼을 포함하고 있는 확인창을 표시한다.<br>확인을 클릭하면 true값이 반환된다.|
| Window | open("url", "name", specs) | 새로운 창을 연다.|
| | close() | 현재 창을 닫는다. |
| 정수 | **parseInt('문자열')** | 문자열을 정수로 변환한다. <br>문자열의 첫글자는 반드시 숫자여야 한다.<br>첫글자가 숫자가 아닌경우 NaN이 반환된다.|
| 실수 | **parseFloat('문자열')** | 문자열을 실수로 변환한다.<br>문자열의 첫글자는 반드시 숫자여야 한다.<br>첫글자가 숫자가 아닌경우 NaN이 반환된다. |
| 정수 | **setTimeout(함수, 밀리초)** | 지정된 시간만큼 경과된 후 해당 함수가 한번 실행된다. |
| 정수 | **setInterval(함수, 밀리초)** | 지정된 시간간격이 경과될 때마다 해당 함수가 반복 실행된다. |
| | **clearTimeout(숫자값)** | 실행중인 setTimeout()을 중지시킨다. <br>숫자값은 setTimeout()함수가 반환하는 숫자값을 넣는다.  |
| | **clearInterval(숫자값)** | 실행중인 setInterval()을 중지시킨다.<br>숫자값은 setInterval()함수가 반환하는 숫자값을 넣는다. |

### Location
- 현재 URL 정보를 표현하는 객체다.(주소창의 URL정보)
#### 프로퍼티

|프로퍼티명|설명 |
|---|---|
| hostname | 호스트명을 반환한다.|
| **href** | 현재 URL을 조회/변경할 수 있다. |
| origin | 프로토콜+호스트명+포트번호를 반환한다. |
			
#### Method

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| | reload() | 현재 페이지를 리로딩시킨다. |

### History
- 페이지방문기록정보를 가지고 있다.

#### 메소드

| 반환값 | 메소드명 | 설명 |
|---|---|---|
| | back()	| 이전페이지로 이동한다. |
| | forward() | 다음페이지로 이동한다. |
| | go(숫자) | 지정된 숫자만큼 이전/다음페이지로 이동한다. |

### Navigator
- 브라우저 정보를 가지고 있다.
#### 프로퍼티

|프로퍼티명|설명 |
|---|---|
| appName | 브라우져명을 반환한다. |
| appVerson | 브라우저의 버전을 반환한다. |
| platform | 브라우저가 실행중인 운영체제 정보를 반환한다. |
| language | 브라우저의 사용언어를 반환한다.
| geolocation | 브라우저가 현재 위치에서 위치정보 제공이 가능하면 Geolocation객체를 반환한다.|				  
| userAgent | 서버로 보내진 user-agent정보를 반환한다.
		
### Screen
- 사용자의 스크린정보를 가지고 있다.
- #### 프로퍼티

|프로퍼티명|설명 |
|---|---|
| width | 스크린의 전체 너비를 반환한다. |
| height | 스크린의 전체 높이를 반환한다. |


