# id와 class 속성
- id와 class는 모든 태그들이 가지는 공통 속성이다.
- id 속성
  + 특정 엘리먼트(태그)를 식별하기 위한 용도로 사용된다.
  + 웹문서 전체에서 똑같은 id 속성값을 가진 태그는 없어야 한다.
  + id의 속성의 값은 고유해야 한다.
  + id 속성의 값은 숫자로 시작할 수 없다.
  ```html
    <h3>학생 테이블</h3>
    <table id="student-table"> ... </table>
    <h3>교수 테이블</h3>
    <table id="professor-table"> ... </table>
    <h3>교직언 테이블</h3>
    <table id="employee-table"> ... </table>
    
    <form id="register-form">
      <label>이름</label> <input type="text" id="user-name" />
      <label>비밀번호</label> <input type="password" id="user-password" />
    </form>
    
    <div id="image-gallary">
      <img src="/resources/images/product1.png" alt="1번상품이미지" id="img-thumb-1" />
      <img src="/resources/images/product1.png" alt="1번상품이미지" id="img-thumb-2" />
      <img src="/resources/images/product1.png" alt="1번상품이미지" id="img-thumb-3" />
      <img src="/resources/images/product1.png" alt="1번상품이미지" id="img-thumb-4" />
    </div>
  ```
  + id 속성의 용도
    * 특정 아이디값을 가진 태그(엘리먼트)에만 스타일을 지정할 때
    * 특정 아이디값을 가진 태그를 선택해서 javascript로 조작해야 할 때	
    
- class 속성
  + 같은 클래스값을 가진 태그는 같은 스타일이 적용되게 하기위한 용도로 사용된다.
  + html 파일내에 같은 클래스값을 가진 태그들이 여러 개 있을 수 있다.
  ```html
    <div id="wrapper">
      <div class="row"> ... </div>
      <div class="row"> ... </div>
      <div class="row"> ... </div>
      <div class="row"> ... </div>
    </div>
  ```
  + class속성은 여러 개의 속성값을 가지는 것이 가능하다.
  ```html
    <div id="container" class="nav navbar navbar-default">
    <button class="btn btn-primary btn-sm">등록</button>
  ```
