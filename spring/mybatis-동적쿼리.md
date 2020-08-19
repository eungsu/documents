# mybatis 동적쿼리

## 검색 조건이 다양한 경우 
  아래 자바코드는 제목, 출판사, 최저가격, 최고가격, 평점 등의 조건으로 책을 검색하는 경우  
  * 제목, 출판사, 최저가격, 최고가격, 평점은 값이 없을 수 있다.
  * 입력값이 존재하지 않는 경우 문자열인 경우 null이나 "" 문자열을 저장하고, 정수값인 경우는 절대로 존재할 수 없는 값(가격, 평점은 -1값을 가질 수 없다.)을 기본값으로 저장한다.
  * 검색조건은 주로 Map객체에 저장한다.
  * 매개변수에 null이나 빈 문자열, -1 등의 값이 들어있는 경우는 Map객체에 저장하지 않는다.
  * 따라서, Map에는 title, publisher, minPrice, maxPrice, score라는 Key가 존재할 수도 있고, 존재하지 않을 수도 있다.
  * mybatis의 동적쿼리의 &lt;if&gt; 태그에서 key에 해당하는 값을 찾아서 null이 아닌 경우에만 그 값을 검색조건에 포함시키면 된다.
  
```java
@GetMapping("/seach.do")
public String searchBooks(@RequestMapping(value="title", required="false") String title, 
    @RequestMapping(value="publisher", required="false") String publisher,
    @RequestMapping(value="minPrice", required="false", defaultValue="-1") int minPrice,
    @RequestMapping(value="maxPrice", required="false", defaultValue="-1") int maxPrice,
    @RequestMapping(value="score", required="false", defaultValue="-1") int score,
    Model model) {  
  
  Map<String, Object> params = new HashMap<String, Object>();
  if (title != null && !title.isEmpty()) {
    params.put("title", title);
  }
  if (publisher != null && !publisher.isEmpty()) {
    params.put("publisher", publisher);
  }
  if (minPrice != -1) {
    params.put("minPrice", minPrice);
  }
  if (maxPrice != -1) {
    params.put("maxPrice", maxPrice);
  }
  if (score != -1) {
    params.put("score", score);
  }
  List<Book> books = bookService.searchBooks(params);
  model.addAttribute("books", books);
  
  return "/book/list";
}
  
```
```xml
<select id="searchBooks" parameterType="map" resultType="Book">
  select
    book_no         as no,
    book_title      as title,
    book_writer     as writer,
    book_publisher  as publisher,
    book_price      as price
  from
    books
  <where>
    <if test="title != null">
      book_title like '%' || #{title} || '%'
    </if>
    <if test="publisher != null">
      and book_publisher like '%' || #{puhlisher} || '%'
    </if>
    <if test="minPrice != null">
      and book_price >= #{minPrice}
    </if>
    <if test="maxPrice != null">
      and book_price like <= #{maxPrice}
    </if>
    <if test="score != null">
      and book_score = #{score}
    </if>
  </where>
</select>
```

## 검색조건 중에서 특정한 검색조건 하나만 선택해서 검색하는 경우
아래의 자바코드는 제목, 출판사, 설명 중에 하나를 선택하고, 선택된 항목에 맞는 검색어를 입력해서 검색하는 경우다.  
  * 제목, 출판사, 설명 중에서 하나의 조건만 고를 수 있다.
  * 검색어를 입력하지 않은 경우에는 검색조건에 포함시키지 않는다.
  * 따라서, 검색어가 null아니고, 빈 문자열도 아닌 경우에만 검색옵션과 검색키워드를 Map에 저장한다.
```java
@GetMappgin("/search.do")
public String searchBooks(@RequestParam(value="opt", required=false) String opt,
    @RequestParam(value="keyword", required=false) String keyword,
    Model model) {  
  
    Map<String, Object> params = new HashMap<String, Object>();
    if (keyword != null && !keyword.isEmpty()) {
      params.put("opt", opt);
      params.put("keyword", keyword);
    }
    
    List<Book> books = bookService.searchBooks(params);
    model.addAttribute("books", books);

    return "book/list";
}
```
```xml
<select id="searchBooks" parameterType="map" resultType="Book">
  select
    book_no         as no,
    book_title      as title,
    book_writer     as writer,
    book_publisher  as publisher,
    book_price      as price
  from
    books
  <where>
    <if test="opt != null &amp;&amp;  keyword != null">
      <choose>
        <when test="opt == 'title'">
          book_title like '%' || #{keyword} || '%'
        </when>
        <when test="opt == 'publisher'">
          book_publisher like '%' || #{keyword} || '%'
        </when>
        <when test="opt == 'summary'">
          book_summary like '%' || #{keyword} || '%'
        </when>
      </choose>
    </if>
  </where>
</select>
```

