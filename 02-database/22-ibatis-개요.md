# ibatis
- SQL Mapper Framework
- JDBC를 사용해서 DB Access작업을 할 때보다 자바코드를 현저하게 줄일 수 있도록 돕는다.
- ibats는 자바객체와 SQL구문을 매핑시켜서 실행하는 프레임워크다.
  + ibatis는 XML 파일을 사용해서 자바객체와 SQL구문을 매핑한다.

## Mapper 파일 작성 예
- insert SQL구문 작성예
```xml
  <insert id="insertCategory" parameterClass="demo.vo.Category">
    insert into tb_categories(cate_no, cate_name, cate_parent_no)
    values(cate_seq.nextval, #name#, #parentNo#)
  </insert>
```
  + id는 SQL 구문을 식별하기 위한 고유한 이름이다. id의 값은 중복을 허용하지 않는다.
  + parameterClass는 SQL구문 실행에 필요한 값을 담고 있는 자바객체를 정의한다. 자바객체는 패키지명을 포함한 클래스의 전체 이름이다.
  + SQL구문내의 #이름#은 쿼리 실행에 필요한 실제값으로 치환되는 부분이다.
  + parameterClass에 자바객체(VO)나 Map객체가 지정되었을 경우에는 변수명 혹은 Map의 key이름이다.
		
- delete SQL구문 작성예
```xml
  <delete id="deleteCategory" parameterClass="int">
    delete from tb_categories
    where cate_no = #value#
  </delete>
```
  + 위의 경우와 같이 SQL구문의 실행에 필요한 값이 기본자료형타입의 값 혹은 String값 하나인 경우 parameterClass에는 int, double, long, string과 같이 적는다.
	+ 기본자료형타입의 값 혹은 String값 하나인 경우 SQL구문에 실제값으로 치환되는 부분은 #value#로 적는다.

- select SQL구문 작성예
```xml
  <select id="getMainCategories" resultClass="demo.vo.Category">
    select
      cate_no as no,
      cate_name	as name,
      cate_parent_no	as parentNo
    from
      tb_categories
    order by
      cate_no asc
</select>
```
  + SQL구문 실행에 필요한 값이 없는 경우에는 parameterClass는 생략한다.
  + select 쿼리는 실행 후 조회결과를 반환하기 때문에 조회 결과를 담는 객체를 매핑해야 한다. 
  + 조회결과와 자바객체의 매핑은 resultClass를 사용한다. 위의 SQL 구문은 카테고리 정보를 담을 수 있는 Category클래스를 매핑시킨다.
  + resultClass="demo.vo.Category"라고 적으면 조회된 행의 갯수만큼 Category객체를 생성하고, Category객체에 각 컬럼의 값을 저장한다.

- select SQL구문 작성예
```xml
  <select id="getCountByDeptId" parameterClass="int" resultClass="int">
    select 
      count(*)
    from 
      employees 
    where 
      department_id = #value# 
</select>
```
- select SQL구문 작성예
```xml
  <select id="getCategoryByNo" parameterClass="int" resultClass="demo.vo.Category">
    select
      cate_no as no,
      cate_name	as name,
      cate_parent_no	as parentNo
    from
      tb_categories
    where
      cate_no = #value#
</select>
```
  + SQL구문의 실행결과로 획득되는 조회결과가 정수값, 문자값 하나인 경우 resultClass에는 int, long, double, string등을 적는다.
  + 별도의 별칭을 적을 필요가 없다.

## ibatis 설정파일
- ibatis 환경설정 파일
  + 데이터베이스 연결 정보
  + 매핑파일 정보
- SQL-자바객체 매핑 파일xN
  + SQL구문 정의

## ibatis 핵심 객체
- SqlMapClient 
  + INSERT, UPDATE, DELETE, SELECT SQL구문을 실행시킨다.
	+ 주요 메소드
    * INSERT
      - Object insert(String id)
      - Object insert(String id, Object param)
    * UPDATE
      - int update(String id)
      - int update(String id, Object param)
    * DELETE
      - int  delete(String id)
      - int delete(String id, Object param)
    * SELECT
      - 한 행만 조회될 때
        + Object queryForObject(String id)
        + Object queryForObject(String id, Object param)
      - 여러 행 조회될 때
      + List   queryForList(String id)
      + List   queryForList(String id, Object param)
        * queryForObject는 resultClass에 지정된 객체를 생성해서 값을 담고 반환한다.
	      * queryForObject는 조회된 행이 없으면 null을 반환한다.
        * queryForList는 List객체를 미리 만들고, resultClass에 지정된 객체를 행의 갯수만큼 생성해서 값을 저장한 다음 그 객체들을 List에 담고, List객체를 반환한다.
        * queryForList는 조회된 행이 없으면 비어있는 List객체가 반환된다.(절대로 null이 반환되지 않음)			

- 파라미터클래스와 리절트클래스가 지원하는 타입과 별칭
| --- | --- | --- |
| 자바 타입 | 별칭 | parameterClass | resultClass |
| java.lang.Boolean | boolean | 사용가능 | 사용가능 |
| java.lang.Integer | int | 사용가능 | 사용가능 |
| java.lang.Long | long | 사용가능 | 사용가능 |
| java.lang.Double | double | 사용가능 | 사용가능 |
| java.lang.String | string | 사용가능 | 사용가능 |
| java.util.Date | date | 사용가능 | 사용가능 |
| java.math.BigDecimal | decimal | 사용가능 | 사용가능 |
| java.util.Map | map | 사용가능 | 사용불가 |
| java.util.HashMap | hashmap | 사용가능 | 사용가능 |




	    
