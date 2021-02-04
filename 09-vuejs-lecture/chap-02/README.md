# Vue 애플리케이션
- Vue 인스턴스 생성
  ```html
    <div id="app"></div>
    <script>
      new Vue({
        el:"#app"
      })
    </script>
  ```
- Vue 생명주기 정의
  ```html
    <div id="app"></div>
    <script>
      new Vue({
        el:"#app"
      }),
      beforeCreate() { ... },
      created() { ... },
      beforeMount() { ... },
      mounted() { ... },
      beforeUpdate() { ... },
      updated() { ... },
      beforeDestroy() { ... },
      destroyed() { ... }
    </script>
  ```
- Vue 인스턴스에 데이터 추가
  ```html
    <div id="app"></div>
    <script>
      new Vue({
        el:"#app",
        data: {
          siteName: "애완동물샵",
          product: {
            id: 1000,
            title: "고양이 사료"
            description: "맛있는 고양이 사료입니다.",
            price: 25000
          }
        }
      })
    </script>
  ```
- 마크업에 데이터 바인딩
  ```html
    <div id="app">
      <h1>{{stieName}}</h1>
      <p>{{product.title}}</p>
      <p v-html="product.description"></p>
      <p>{{product.price | formatPrice}}</p>
    </div>
    <script>
      new Vue({
        el:"#app",
        data: {
          siteName: "애완동물샵",
          product: {
            id: 1000,
            title: "고양이 사료"
            description: "맛있는 고양이 사료입니다.",
            price: 25000
          }
        }
      })
    </script>
  ```
  
- 출력값 서식 지정
  ```html
    <div id="app">
      <h1>{{stieName}}</h1>
      <p>{{product.title}}</p>
      <p v-html="product.description"></p>
      <p>{{product.price}}</p>
    </div>
    <script>
      new Vue({
        el:"#app",
        data: {
          siteName: "애완동물샵",
          product: {
            id: 1000,
            title: "고양이 사료"
            description: "맛있는 고양이 사료입니다.",
            price: 25000
          }
        },
        filters: {
          formatPrice: function(price) {
            return new Number(price).toLocaleString();
          }
        }
      })
    </script>
  ```