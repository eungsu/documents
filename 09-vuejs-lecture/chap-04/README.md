# 폼과 입력
- v-model 지시자를 사용하면 애플리케이션 모델에 폼 데이터를 연결할 수 있다.
- v-model 지시자는 폼의 input, textarea, checkbox, radio, select를 포함한 여러 종류의 폼 요소와 애플리케이션 모델을 연결할 수 있다.  

## v-model 바인딩
- v-model 지시자는 v-bind 지시자를 사용한다.
- &lt;input v-model="프로퍼티" &gt;은 &lt;input v-bind="프로퍼티" v-on:input="프로퍼티=$event.target" &gt;의 문법적 설탕이다.


## 폼 요소에 값 바인딩 하기
- 체크박스에 값 바인딩
  - v-bind 지시자는 HTML 요소의 속성에 값을 바인딩한다.
  - 체크박스는 v-bind:true-value와 v-bind:false-value로 체크박스의 체크 여부에 특정 속성의 값을 연결 지을 수 있다.
  - 체크박스가 체크되면 v-model로 연결된 모델의 속성에 v-bind:true-value로 연결된 속성이 바인딩된다.
  - 체크박스가 체크되어 있지 않으면 v-model로 연결된 모델의 속성에 v-bind:false-value로 연결된 속성이 바인딩된다.  
```html
  <input type="checkbox"
    v-bind:true-value="order.sendGift"      
    v-bind:false-value="order.dontSendGift"
    v-model="order.gift">
  <!-- 
    체크박스가 체크되면 order.sendGift의 값이 order.gift의 값이 된다.
    체크박스가 체크되어 있지 않으면 order.dontSendGift의 값이 order.gift의 값이 된다.

    Vue인스턴스의 order.gift="선물 보내기"로 기본값이 지정되어 있다.
    "선물 보내기"는 체크박스가 체크되어 있을 때의 값인 order.sendGift의 값이고, order.sendGift는 v-bind:true-value="order.sendGift"의 설정에 의해
    체크박스가 체크되어 있을 때의 값으로 설정되어 있기 때문에 페이지 로딩시 체크박스는 체크상태로 된다.
   -->
    
  <script>
    new Vue({
      data: {
        order: {
          gift: '선물 보내기',              // 체크박스의 기본값을 '선물 보내기'로 지정한다.
          sendGift: '선물 보내기',          // 체크박스가 체크되어 있을 때 gift의 값이다.       v-bind:true-value="order.sendGift"
          dontSendGift: '선물 보내기 않기'  // 체크박스가 체크되어 있지 않을 때 gift의 값이다.  v-bind:false-value="order.dontSendGift"
        }
      }
    });
  </script>
```

- 라디오버튼에 값 바인딩
  - 라디오버튼은 v-bind:value로 각각의 라디오버튼이 체크되었을 때 특정 속성의 값을 연결 지을 수 있다.
```html
  <input type="radio"
    v-bind:value="order.home"
    v-model="order.method"> 
  <input type="radio"
    v-bind:value="order.business"
    v-model="order.method">

  <!--
    v-bind는 첫번째 라디오 버튼에 order.home을 바인딩하고, 두번째 버튼에 order.business를 바딩시킨다.
    Vue 인스턴스의 order 속성에 home, business 속성을 추가한다.
   -->

  <script>
    new Vue({
      data:{
        order: {
          method: '자택',     // 라디오 버튼의 기본값을 '자택'으로 지정한다.
          business: '직장',   // 두번째 라디오 버튼이 선택되면 order.business 속성의 값이 order.method 속성의 값이 된다.
          home: '자택'        // 첫번째 라이도 버튼이 선택되면 order.home 속성의 값이 order.method 속성의 값이 된다.
        }
      }
    })
  </script>
```

- 콤보박스에 값 바인딩
  - select박스에도 v-bind 지시자로 값을 설정한다.
  - v-for 지시자를 사용하면 코드나 객체의 값을 쉽게 나열할 수 있다.
```html
  <select v-model="order.state">
    <option v-for="(state, key) in states"
      v-bind:value="state"> {{key}} </option>
  </select>

  <!--
    <option value="AL"> Alabama</option>
    <option value="AR"> Arkansas</option>
    <option value="CA"> California</option>
    <option value="NY"> New York</option>
   -->


  <script>
    new Vue({
      data: {
        states: [{AL:'Alabama'}, {AR:'Arkansas'}, {CA:'California'}]
      }
    })
  </script>
```

- 입력값 다듬기
  - v-model 지시자의 수식어를 사용하면 입력값을 다듬을 수 있다.
  - 수식어 종류    
  
  | 수식어 | 설명 |
  | --- | --- |
  | .number | v-model 지시자의 값을 숫자로 자동 타입 변환한다. <br/>앞에 있는 0은 모두 무시한다 |
  | .trim | v-model 지시자의 값에서 자동으로 모든 여백을 없앤다 |
  | .lazy | 텍스트 박스에서 글자를 입력할 때마다 v-model의 속성과 동기화시키는 대신, onchange 이벤트와 동기화 시킨다. |

