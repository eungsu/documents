# 조건부, 반복, 리스트

## 조건부 사용
- v-if, v-else=if, v-else를 사용하면 조건에 따라서 특정 엘리먼트를 화면에 표시하는 조건부 로직을 구현할 수 있다.
- v-if, v-else-if, v-else 사용시 주의점
  + v-if를 사용할 때마다 v-else-if 혹은 v-else가 바로 따라와야 한다.
  ```html
    <!-- v-if 사용시 v-else-if 혹은 v-else가 바로 따라오는 경우  -->
    <div v-if="계산된 속성 혹은 메소드">  컨텐츠 </div>
    <div v-else-if="계산된 속성 혹은 메소드">  컨텐츠 </div>
    <div v-else-if="계산된 속성 혹은 메소드">  컨텐츠 </div>
    <div v-else="계산된 속성 혹은 메소드">  컨텐츠 </div>
    
    <!-- 
      v-if 사용시 v-else-if 혹은 v-else가 바로 따라오지 않는 경우  
      v-else-if 혹은 v-else를 인식하지 못한다.
    -->
    <div>
      <p v-if="계산된 속성 혹은 메소드"> 컨텐츠</p>
    </div>
    <div>
      <p v-else-if="계산된 속성 혹은 메소드"> 컨텐츠</p>
    </div>
    <div>
      <p v-if="계산된 속성 혹은 메소드"> 컨텐츠</p>
    </div>
  ```
  + 조건부 사이에 다른 엘리먼트 요소가 위치할 수 없다.
  + v-else-if 지시자는 같은 블록에서 여러 번 사용할 수 있다.
  + 템플릿에 너무 많은 조건부나 로직을 사용하지 않도록 하자
    * 필요할 때 계산된 속성이나 메소드를 사용하면 코드의 가독성을 쉽게 향상 시킬 수 있다.

## 반복부 사용
- v-for 범위를 이용한 반복
  + v-for 지시자에 정수값을 요소로 추가하면 해당 값만큼 반복작업을 수행한다.
  ```html
    <span v-for="n in 5">{{n}}<span>
  ```
- v-for 배열을 이용한 반복
  ```html
    <div class="col-4 mb-3" v-for="product in products">
      <h4>{{product.title}}</h4>
      <div>{{product.description}}</div>
      <div><span class="text-danger font-weight-bold">{{product.price | formatPrice}}</span> 원</div>
    </div>
  ```

## 리스트 정렬하기
- Vue.js의 계산된 속성을 사용하면 v-for 지시자로 표시할 데이터를 정렬해서 표시할 수 있다.
```javascript
  new Vue({
    data: {
      products: [];
    },
    computed: {
      // 상품 리스트를 상품명을 기준으로 오름차순 정렬하기
      sortedProducts: function() {
        return this.products.sort(function(product, otherProduct) {
          if (product.title > otherProduct.title) {
            return 1;
          }
          if (product.title < otherProduct.title) {
            return -1;
          }
          return 0;
        });
      }
    },
    created() {
      axios.get('./products.json')
        .then((response) => {
          this.products = response.data.products;
        });
    });
  });
```