# CSS(Cascading Style Sheets)

+ HTML 문서가 웹브라우져의 화면, 인쇄물 혹은 여러 미디어에 어떻게 표현될지를 정의하는 언어다.
+ CSS는 화면의 레이아웃, 텍스트 형식, 애니메이션 효과, 3D효과 등을 설정할 수 있다.
+ HTML 문서에 대한 디자인적인 요소를 담당한다.
+ 문법
```
  Selector(선택자)	Declaration(CSS 선언)
  h1                {color:blue;  font-size:12px;}

  * 선택자
    스타일을 적용할 대상 엘리먼트(태그)를 지정한다.
  * CSS 선언
    선택자에서 지정한 엘리먼트에 적용할 스타일을 선언한다.
    각각의 CSS선언은 세미콜론으로 구분한다.
    CSS선언은 PropertyName:PropertyValue로 구성된다.
```
## CSS 적용하기
+ Inline CSS
  + 하나의 엘리먼트에만 적용할 스타일을 정의할 때 사용한다.
  + 엘리먼트에 CSS선언을 정의하는 것
  ```html
    <h1 style="color:red; font-size:12px;">컨텐츠</h1>
    <!-- CSS선언이 정의된 그 태그에만 스타일이 적용된다. --> 
  ```
+ Internal CSS
  + 하나의 HTML문서에만 적용할 스타일을 정의할 때 사용한다.
  + HTML문서의 헤더부분에서 &lt;style&gt;태그 안에 CSS선언을 정의하는 것
  ```html
    <style>
      h1 {color:red; font-size:12px;}
      p {margin: 10px; padding:6px;}
    </style>
    <!-- HTML문서에 있는 모든 <h1>, <p> 태그에 스타일이 적용된다. -->
  ```
+ External CSS
  + 프로젝트 내의 모든 HTML문서에 적용할 스타일을 정의할 때 사용한다.
  + 별도의 css파일에 CSS선언을 정의하고, &lt;link&gt;태그를 이용해서 css파일을 html문서와 연결시킨다.
  + 하나의 css파일만 변경하면 프로젝트 내의 모든 HTML문서의 스타일을 변경할 수 있다.
  ```css
    h1 {color:red; font-size:12px;}
    p {margin: 10px; padding:6px;}
  ```
  ```html
    <link rel="stylesheet" type="text/css" href="style.css">
  ```

## CSS 선택자
+ HTML문서에서 스타일을 적용할 대상을 선택할 때 사용한다.
	
### 기본 선택자

|선택자|작성예|설명|
|---|---|---|
|태그|p {style정의}|모든 p엘리먼트를 선택|
|#아이디|#news {style정의}|id="news" 인 엘리먼트를 선택|
|.클래스|.intro {style정의}|class="intro"인 모든 엘리먼트를 선택|
|*|* {style정의}|모든 엘리먼트를 선택|
|태그, 태그|h1, h2 {style정의}|모든 h1, 모든 h2엘리먼트를 선택|
|태그, .클래스|p, .intro {style정의}|모든 p엘리먼트, class="intro"인 모든 엘리먼트 선택|
|태그.클래스|p.intro {style정의}|&lt;p&gt; class="intro">인 엘리먼트를 선택|
|.클래스.클래스|.intro.heading {style정의}|&lt;p class="intro heading"&gt;인 엘리먼트를 선택|
	
### 자손, 자식, 형제 선택자
|선택자|작성예|설명|
|---|---|---|
|태그 태그|div p {style정의}|div 엘리먼트 안에 있는 p엘리먼트가 선택|
|.클래스 .클래스|.box .intro {style정의}|class="box"인 안에 있는 class="intro" 선택|
|태그 > 태그|div > p {style정의}|div가 부모엘리먼트인 p엘리먼트 선택|
|.클래스 > 태그|.box > p {style정의}|class="box"가 부모인 p엘리먼트 선택|
|.클래스 > .클래스|.box > .item {style정의}|class="box"가 부모인 class="item"엘리먼트 선택|
|#id > 태그|#section > p {style정의}|id="section"가 부모인 p엘리먼트 선택|
|#id > .클래스|#section > .heading{style정의}|id="section"가 부모인 class="heading"엘리먼트 선택|
|태그 + 태그|h3 + p {style정의}	|h3엘리먼트 바로 다음에 있는 p엘리먼트 선택|
|태그 ~ 태그|h3 ~ p {style정의}|h3엘리먼트 다음에 있는 모든 p엘리먼트 선택|

### 속성 선택자
|선택자|작성예|설명|
|---|---|---|
|[속성명]|[target]|target속성을 가지고 있는 모든 엘리먼트를 선택|
|[속성명=속성값]|[name='username']|name="username"인 모든 엘리먼트를 선택|
|[속성명^=속성값]|[href^='http']|href속성의 속성값이 http로 시작하는 모든 엘리먼트 선택|
|[속성명$=속성값]|[href$='com']|href속성의 속성값이 com으로 끝나는 모든 엘리먼트 선택|
|[속성명*=속성값]|[alt*='사진']|alt속성의 속성값에 '사진'이 포함되어 있는 모든 엘리먼트 선택|
|[속성명~=속성값]|[alt~='겨울']|alt속성의 속성값에 '겨울'이라는 단어(공백으로 다른 글자와 구분되는)가 포함되어 있는 모든 엘리먼트 선택|

### 필터 선택자
|선택자|작성예|설명|
|---|---|---|
|:first-child|p:first-child|P엘리먼트중에서 p의 부모를 기준으로 첫번째 자식엘리먼트를 선택|
|:last-child|p:last-child|P엘리먼트중에서 p의 부모를 기준으로 마지막번째 자식엘리먼트를 선택|
|:nth-child(n)|p:nth-child(2)|p엘리먼트중에서 p의 부모를 기준으로 두번째 자식 엘리먼트를 선택|
|:not(selector)|p:not(:first-child)|p엘리먼트중에서 첫번째 자식이 아닌 p를 선택|

### 가상 선택자
|선택자|작성예|설명|
|---|---|---|
|:hover|img:hover|,img엘리먼트중에서 마우스가 올라가 있는 것 선택|
|:focus|input:focus|inut엘리먼트중에서 포커스를 가지고 있는 것 선택|
|a:link|a:link|a엘리먼트 중에서 방문적이 없는 링크|
|a:visited|a:visited|a엘리먼트 중에서 방문한적인 있는 링크|
|a:active|a:active|a엘리먼트 중에서 지금 선택한 링크|
