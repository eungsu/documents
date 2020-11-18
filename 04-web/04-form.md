# 폼과 폼요소
## 폼
- 폼은 사용자가 값을 입력할 수 있는 입력요소(입력필드, 체크박스, 라디오버튼, 콤보박스 등)를 제공하는 것이다.
- 모든 입력요소들은 &lt;form&gt; 태그 안에 정의되어야 한다.

## 폼요소
- 폼요소는 사용자가 값을 입력하거나, 선택하거나, 체크할 수 있는 것들이다.
- 대표적인 폼요소 태그
  + &lt;input&gt;, &lt;select&gt;, &lt;textarea&gt;, &lt;button&gt;
- 입력폼 예시
```html
  <form>
    <label>이름</label>
    <input type="text" />
    
    <label>아이디</label>
    <input type="text" />		
    
    <label비밀번호</label>
    <input type="password" />
    
    <label>나이</label>
    <input type="number" />
    
    <label>생일</label>
    <input type="date" />
    
    <label>프로필사진</label>
    <input type="file" />
    
    <label>학력</label>
    <select>
      <option> 고등학교졸업</option>
      <option> 초대졸</option>
      <option> 4년제 졸</option>
    </select>
    
    <label>자기 소개</label>
    <textarea></textarea>
</form>
```

### form 태그
- <form> 태그의 주요 속성
* action
form입력값을 전달받을 서버측의 웹애플리케이션 이름
(이름은 폴더경로를 포함하는 jsp파일의 이름이다.)
* method
form입력값을 서버로 전달하는 방식(GET, POST 중 하나)을 정의하는 속성
GET  : form 입력값을 url뒤에 붙여서 보낸다.
설정하지 않으면 기본값이 GET이다.
예)register.jsp?username=홍길동&userid=hong&age=10
POST : form 입력값을 요청메세지의 body에 담아서 서버로 보낸다.
* 첨부파일을 서버로 보낼 때
* 많은 입력값(종류가 많거나 크기가 크거나)를 서버로 보낼 때
* 서버로 보내는 입력값을 url에 노출시키고 싶지 않을 때 
* 서버로 전달되는 데이터에 대한 사이즈 제한이 없다.
* enctype
form입력값을 서버로 보낼 때 어떤 방식으로 변환해서 보낼 것인지를 정의하는 속성
application/x-www-form-urlencoded 
* 기본값이다.
* 입력필드이름=입력값&입력필드이름=입력값&입력필드이름=입력값 <----- 이와 같은 형식으로 변환해서 보낸다.
* 서버로 전달할 폼입력값을 변환하는 가장 일반적인 방식이다.
(단, 폼입력값에 첨부파일이 있는 경우에는 사용할 수 없다
       첨부파일(프로필사진, 이력서, 동영상 등)을 전달할 수 없다.)
multipart/form-data  
* 폼입력값에 첨부파일이 있는 경우 사용되는 폼입력값 변환방식이다.
(첨부파일이 있는 폼은 반드시 <form method="post" enctype="multipart/form-data">로 설정해야 한다.)
* 변환예
------------------------------------임의의16진수 숫자
Content-Disposition: form-data; name="username"
홍길동 
------------------------------------임의의16진수 숫자       
Content-Disposition: form-data; name="userid"
hong
------------------------------------임의의16진수 숫자
Content-Disposition: form-data; name="photo"; filename="a.jpg"
Content-Type: image/jpg
------------------------------------임의의16진수 숫자
- <input> 태그의 주요 속성
* type
- 폼입력요소의 타입을 결정한다.
- 타입의 종류
type="text"		: 입력필드가 된다.
type="password"		: 비밀번호 입력필드가 된다.
type="date"		: 날짜 입력필드가 된다.(달력표시)
type="number"		: 숫자 입력필드가 된다 (숫자만 입력가능)
type="email"		: 이메일 입력필드가 된다.(유효하지 않은 이메일 형식인 경우 에러발생)
type="url"		: url 입력필드가 된다.
type="file"		: 첨부파일 폼요소가 된다.
type="radio"		: 하나만 선택가능한 라디오 버튼이 된다.
type="checkbox"		: 복수개 선택가능한 체크박스가 된다.
type="reset"		: 폼의 입력값을 초기상태로 리셋한다.
type="submit"		: 폼의 입력값을 서버로 제출한다.
type="hidden"		: 해당 폼 입력요소는 화면에 표시되지 않는다.
* name
- 폼입력요소의 이름을 정의한다.
- 입력값이 서버로 전달될 때 name속성에 지정된 이름과 입력값의 쌍으로 전달된다.
- 모든 입력요소에는 name속성을 꼭 설정하자.
- 체크박스나 라디오버튼의 경우 같은 종류의 항목들은 같은 이름을 설정한다.
* value
- 폼입력요소의 입력값을 정의한다.
- 라디오버튼, 체크박스, 옵션태그는 value를 사용해서 미리 값을 설정해야 한다. 
* checked
- 라디오버튼과 체크박스를 체크상태로 만든다.
* selected
- <select>태그의 특정 옵션을 선택된 상태로 만든다.
* readonly
- 입력필드를 읽기전용으로 만든다. 수정이 불가능해진다.
- 주로 입력필드, textarea에서 사용된다.
* disabled
- 폼요소를 비활성화 시킨다.
- 비활성화된 폼요소의 입력값은 서버로 제출되지 않는다.
* maxlength
- 텍스트를 입력하는 폼요소의 입력글자수를 제한한다.
* placeholder
- 입력값에 대한 힌트를 제공한다.
- <select> 태그
* 드롭다운 리스트를 만든다.
* 사용자가 입력해야 되는 값이 미리 결정되어 있는 경우에 사용한다.
* 예) 학력사항, 통신사, 지역 ...
- <textarea> 태그
* 여러 줄의 텍스트가 입력 가능한 입력필드이다.
* <textarea>에 입력값을 정의할 때는 value를 사용하지 않는다.
<textarea>미리 정의할 입력값</textarea>
* rows 속성 : textarea가 표시할 줄 수를 지정한다.
* cols 속성 : textarea가 표시할 너비를 지정한다.
- <button> 태그
* 클릭가능한 버튼을 정의한다.
* <button> 태그가 <form>태그 안에 있을 때는 
폼 입력값을 서버로 제출하는 submit버튼처럼 동작한다.









