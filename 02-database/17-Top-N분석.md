# TOP-N 분석

## TOP-N 분석
- TOP-N 분석은 조건에 맞는 최상위 레코드 n개 혹은 최하위 레코드 n개를 조회하는 쿼리다.
- 사용예
  + 급여를 가장 많이 받는 사원 3명
  + 가장 최근에 입사한 사원 5명
  + 최근 3개월동안 가진 많이 판매된 상품 10 가지
  + 판매실적이 가장 높은 영업사원 3명
- 형식
```sql
  SELECT ROWNUM, column, column, column
  FROM (SELET column, column, column
        FROM table
        ORDER BY 분석대상컬럼이 정렬기준이된다)
  WHERE ROWNUM <= N

  -- 인라인뷰 :  order by절을 사용해서 데이터를 원하는 순서로 정렬한다.
  -- ROWNUM : 서브쿼리에서 반환되는 각 행에 1부터 시작하는 순번을 할당한다.
  -- WHERE절 : 최종적으로 반환될 행의 갯수를 지정한다.
```







		
