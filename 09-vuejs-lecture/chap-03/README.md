# 애플리케이션에 상호 작용성 추가
- DOM 이벤트 바인딩
  + 애플리케이션에 상호 작용 요소를 추가하려면 Vue 인스턴스에서 정의한 함수를 DOM 요소에 연결해야 한다.
  + 이벤트 바인딩을 사용해서 click, mouseup, keyup 등 기본 DOM 이벤트와 요소를 연결할 수 있다.
  + 이벤트 바인딩 하기
  ```html
    <button v-on:click="addToCart">장바구니 담기</button>
    <script>
      new Vue({
        el:"#app",
        data: { ... },
        methods: {
          addTocart: function() {
            this.cart.push(this.product.id);
          }
        }
      })
    </script>
  ``` 
- 계산된 속성의 사용
  + 계산된 속성(computed property)은 Vue 인스턴스에서 정의된다.
  + 계산된 속성은 DOM과 바인딩시킬 수 있다.
  + 계산된 속성은 애플리케이션의 현재 상태에서 새로운 정보를 가져오는 기능을 제공한다.
  ```html
    <span>{{fullname}}</span>
    <script>
      new Vue({
        el:"#app",
        data: {
          firstname: "Steven",
          lastname: "King"
        },
        computed: {
          fullname: function() {
            return [this.firstname, this.lastname].join(',');
          }
        }
      })
    </script>
  ```
  + 계산된 속성은 인스턴스 데이터를 사용해서 계산된다.
  + 계산된 속성은 기본 데이터가 변경되면 자동으로 업데이트되고, 모든 뷰 마크업은 새 값을 반영하기 위해 업데이트된다.
- v-show와 v-if/v-else
  + v-show 지시자
    * v-show 지시자는 표현식이 거짓이면, Vue는 인라인으로 CSS의 display 속성을 none로 지정한다.
    * v-show 지시자로 숨겨진 엘리먼트는 DOM에는 그대로 남아있다.
    * v-show 지시자는 여러 근접한 요소에 적용하기 보다는 하나의 요소에 적용하는 것이 더 효과적인다.
    ```html
      // 이것보다는 
      <p v-show="showMe">Some Text</p>
      <p v-show="showMe">Some Text</p>
      <p v-show="showMe">Some Text</p>

      // 이것이 낫다.
      <div v-show="showMe">
        <p>Some Text</p>
        <p>Some Text</p>
        <p>Some Text</p>
      </div>
    ```
  + v-if와 v-else 지시자
    * v-if와 v-else 지시자는 주어진 표현식의 값에 따라서 두 가진 선택 중 하나를 표시할 때 사용한다.
    * v-if와 v-else를 같이 사용할 때 마크업에는 조건이 참일 때 표시할 것과 거짓일 때 표시할 요소 2개가 필요하고, 두 요소는 서로 나란히 인접해 있어야 한다.
    * v-if와 v-else 지사자를 사용하면 Vue는 표현식의 값에 따라서 요소를 DOM에서 삭제한다.
  + v-shwo와 v-if/v-else 비교
    * v-show는 다른 사례가 없는 경우 적합하다.
      * 이벤트 발표나 일시적인 메세지 배너
      * 사용자가 로그인하지 않았을 때 가입이나 기타 유도 광고
      * 여러 웹 페이지에서 사용하는 리스트 페이징 요소
    * v-if와 v-else는 마크업 덩어리 2개 중 하나가 렌더링되어야 할 때 적합하며, 적어도 하나는 무조건 보여야 하는 곳에 적합하다.
      * 로그아웃된 사용자에게는 로그인 링크를 보여주고, 로그인된 사용자에게는 로그아웃 링크를 보여주는 것
      * 검색결과가 있을 때와 없을 때를 표시하는 것