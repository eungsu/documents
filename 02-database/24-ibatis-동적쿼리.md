# ibatis의 다이나믹  쿼리
- 파라미터으로 전달받은 값에 따라서 쿼리를 동적으로 생성하는 것
- 형식
```xml
  select column, column, ...
  from table
  <dynamic>
    동적 SQL 요소를 정의한다.
  </dynamic>
```

## 동적 SQL 태그
- 이항연산 태그
  + &lt;isEqual          property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isEqual&gt;
  + &lt;isNotEqual       property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isNotEqual&gt;
  + &lt;isGreaterThan    property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isGreaterThan&gt;
  + &lt;isGreaterEqual   property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isGreaterEqual&gt;
  + &lt;isLessThan       property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isLessThan&gt;
  + &lt;isLessEqual      property="필드명"     compareValue="값" &gt; SQL구문 &lt;/isLessEqual&gt;
		* property : 전달받은 값을 담고 있는 필드명
		* compareValue : 필드에 들어있는 값과 비교할 값
		
- 단항연산 태그
  + &lt;isNull          property="필드명" &gt; SQL구문 &lt;/isNull>
  + &lt;isNotNull       property="필드명" &gt; SQL구문 &lt;/isNotNull>
  + &lt;isEmpty	        property="필드명" &gt; SQL구문 &lt;/isEmpty>
  + &lt;isNotEmpty      property="필드명" &gt; SQL구문 &lt;/isNotEmpty>
  
## 사용예
```xml
  <select id="searchProducts" parameterClass="map" resultClass="Product"> 
    select *
    from tb_products
    <dynamic>
      <isEqual property="opt" compareValue="NAME">
        where prod_name = #keyword#
      </isEqual>
      <isEqual property="opt" compareValue="MAKER">
        where prod_maker = #keyword#
      </isEqual>
      <isEqual property="opt" compareValue="PRICE">
        where prod_price >= #keyword#
      </isEqual>
    </dynamic>
</select>
```

			
		
