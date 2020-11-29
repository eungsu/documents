# Vue 계산기
- 데이터바인딩과 반응성을 활용해서 애플리케이션 개발하기

```html
  <!doctype html>
  <html>
    <head>
      <meta charset="utf-8">
      <title>계산기</title>
    </head>
    <body>
      <div id="app">
        <div><label>x</label> <input type="text" v-model="x" />/div>
        <div><label>x</label> <input type="text" v-model="y" />/div>
        <div>Result : <span>{{result}}</span></div>
      </div>
      <script src="https://unpkg.com/vue/dist/vue.js"></script>
      <script>
        function isNotNumericValue(value) {
          return isNaN(value) || !isFinite(value);
        }
        
        new Vue({
          el: "app",
          data: {x:0, y:0, result:0},
          computed: {
            result: function() {
              let x = parseFloat(this.x);
              if (isNotNumbericValue(x)) {
                return this.result;
              }
              let y = parseFloat(this.y);
              if (isNotNumericValue(y)) {
                return this.result;
              }
              this.result = x + y;
              return this.result;
            } 
          }
        })
      </script>
    </body>
  </html>
```
