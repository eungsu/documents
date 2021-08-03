# 박스모델
+ 모든 HTML 엘리먼트(태그) 박스처럼 다루어진다.
+ 화면 디자인, 화면의 레이아웃을 구성할 때 HTML 엘리먼트(태그)를 박스처럼 다루게 되는데, 이를 박스모델이라고 한다.
+ 박스모델의 구성
  + HTML의 모든 엘리먼트(태그)는 margin, border, padding, content로 구성된다.
  + margin : 테두리(border)의 바깥여백, 다른 엘리먼트와의 경계
  + border : 엘리먼트의 테두리, padding과 contents를 감싸고 있다.
  + padding : 테두리(border)와 contents 사이의 여백, contents를 감싸고 있다.
  + contents : 박스모델이 가지는 실제 내용(텍스트 혹은 이미지) 

+ 박스모델에서 엘리먼트의 실제 너비와 높이
  + box-sizing이 content-box인 경우
    + css에서 정의한 width가 contents의 너비로 정의 된다. 
  ```
    디폴트너비 = leftmargin + leftborder + leftpadding  + content(width) + rightpadding + rightborder + rightmargin
  ```  
  + boz-sizing이 border-box인 경우
    + css에서 정의한 width가 border와 padding, content의 너비를 합한 것으로 정의된다.
  ```
    너비 = leftmargin + width + rightmargin
  ```
