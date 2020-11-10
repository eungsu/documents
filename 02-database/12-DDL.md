# 데이터 정의어(DDL)
- 오라클 데이터베이스 객체 생성, 변경, 삭제에 사용되는 명령어
- CREATE, ALTER, DROP, TRUNCATE

## 주요 데이터베이스 객체
- 테이블
  + 데이터의 기본 저장단위, 행과 열로 구성되어 있다.
- 뷰
  + 하나 이상의 테이블을 사용해서 만든 가상의 테이블
- 시퀀스
  + 일련번호 생성기
- 인덱스
  + 검색성능을 향상시키기 위해 데이터에 대한 색인을 가지고 있다.
- 동의어
  + 객체에 대한 다른 이름을 제공한다.

### 테이블
- 테이블과 컬럼의 이름규칙
  + 문자로 시작, 30자까지 가능, A-Za-z0-9_$# 만 허용, 
  + 오라클 예약어 사용금지
- 테이블 생성하기
```sql
  CREATE TABLE 테이블명 (
    컬럼명 데이터타입(크기) [DEFAULT 기본값],
    ...
  )
```
- 테이블 삭제
```sql
  DROP TABLE 테이블명
```
- 테이블 변경
  + 컬럼추가
  ```sql
    ALTER TABLE 테이블명 ADD (컬럼명 데이터타입(크기) [DEFAULT 기본값]);	
  ```
  + 컬럼수정
  ```sql
    ALTER TABLE 테이블명 MODIFY (컬럼명 테이터타입(크기) [DEFAULT 기본값]);
  ```
  + 컬럼삭제
  ```sql
    ALTER TABLE 테이블명 DROP 컬럼명;
  ```
  + 테이블 이름 변경
  ```sql
    RENAME 테이블명 TO 새테이블명
  ```
  + 테이블 절단하기
  ```sql
    TRUNCATE TABLE 테이블명;
    
    -- truncate는 테이블에서 모든 행을 제거한다.
    -- 해당 테이블이 사용하는 저장공간을 해제한다.
    -- truncate로 제거된 행은 rollback할 수 없다.
  ```
    

### 시퀀스
- 일련번호를 자동으로 생성하는 데이터베이스 객체다.
- 기본키 값(행을 대표하는 값)을 생성하는데 주로 사용됩니다.
- 시퀀스 생성
```sql
  CREATE SEQUENCE 시퀀스명;	
  -- 1부터 1씩 증가하는 번호가 발행된다.
```
```sql
  CREATE SEQUENCE 시퀀스명
  [INCREMENT BY a]		a씩 증가한다.
  [START WITH   b]		b부터 시작한다.
  [{MAXVALUE c | NOMAXVALUE}]	c가 최대값이다.
  [{MINVALUE d | NOMINVALUE}]	d가 최소값이다.
  [{CYCLE | NOCYCLE}]		최대값/최소값이 도달했을 때 반복여부를 결정한다.
  [{CACHE e | NOCACHE}]		일련번호를 e개 만큼 미리 할당해서 메모리에 캐시하거나, 캐시를 활용하지 않는다.
```
- 시퀀스 생성하기 예제
```sql
  CREATE SEQUENCE 시퀀스명
  INCREMENT BY 1		
  START WITH   1	
  NOMAXVALUE
  NOMINVALUE
  NOCYCLE		
  CACHE 20;	
```
- 시퀀스의 삭제
```sql
  DROP SEQUENCE 시퀀스명
```
- 시퀀스의 수정
```sql
  ALTER SEQUENCE 시퀀스명
  [INCREMENT BY a]		
  [{MAXVALUE c | NOMAXVALUE}]	
  [{MINVALUE d | NOMINVALUE}]	
  [{CYCLE | NOCYCLE}]		
  [{CACHE e | NOCACHE}]		
  
  -- START WITH를 제외한 나머지 설정을 변경할 수 있다.
```
- 시퀀스의 사용
  + 시퀀스명.NEXTVAL
    * 새로운 일련번호를 반환한다.
  + 시퀀스명.CURRVAL
    * 현재 시퀀스의 일련번호를 반환한다.
    * CURRVAL을 사용하려면 해당 시퀀스에 대한 NEXTVAL이 실행된 후에만 가능한다.

### 뷰
- 테이블 혹은 다른 뷰를 기반으로 하는 가상의 테이블(논리적인 테이블)이다.
- 특징
  + 물리적인 저장공간을 가지지 않는다.
  + INSERT, UPDATE, DETELE 작업의 수행이 불편하다.
- 목적
  + 복잡한 SQL문을 간단하게 작성하기 위해서 사용
  + 데이터의 엑세스를 제한하기 위해서 사용(데이터에 대한 보안성 강화)
  + 동일한 데이터로부터 다양한 결과를 얻기 위해서 사용
- 종류
  + 단순 뷰
    * 한 테이블에서만 데이터를 가져온다.
    * 함수 또는 데이터 그룹을 사용하지 않았음
    * DML(INSERT/UPDATE/DELETE가 가능은 하다)
  + 복합 뷰
    * 여러 테이블에 데이터를 가져온다.
    * 함수 또는 데이터 그룹을 포함하고 있음
    * DML 거의 불가능하다.
- 뷰 생성
```sql
  CREATE [OR REPLACE] VIEW 뷰이름
  AS 서브쿼리
  WITH READ ONLY
  
  -- 서브쿼리는 가상의 테이블이 포함할 데이터를 조회하는 SELECT문
```
- 뷰 수정
```sql
  CREATE OR REPLACE VIEW 뷰이름
  AS 서브쿼리
  
  -- 뷰이름을 수정하려는 기존 뷰이름과 동일하게 지정하면 된다.
```
- 뷰 삭제
```sql
  DROP VIEW 뷰이름
```

### 인라인 뷰
- SELECT 문의 FROM절에 서브쿼리를 정의하고, 이 서브쿼리로 조회된 결과를 가상의 테이블로 취급하고, 별칭을 부여한 것
- 데이터베이스 객체가 아니다.
- 형식
```sql
  SELECT A.column, A.column, A.column
  FROM (SELECT column, column, column, ...
        FROM table1
        WHERE 조건식) A
   WHERE 조건식
```

### 인덱스(색인)
- 데이터 행의 검색 속도를 향상시키기 위해서 사용되는 데이터베이스 객체다.
- 데이터의 위치를 빠르게 찾는 신속한 경로 엑세스 방법을 사용하여 디스크 I/O를 줄여 준다.
- 인덱스는 테이블과 독립적으로 존재한다.
- 한 번 생성된 인덱스는 Oracle이 자동으로 유지 관리한다.
- 테이블이 삭제되면 그 테이블의 데이터를 색인화하고 있는 인덱스도 같이 삭제된다.
- 인덱스 생성
  + 자동 생성
    * 테이블 정의할 때 primary key 제약조건, unique 제약조건이 정의된 컬럼의 값들은 자동으로 인덱스가 생성된다.
  + 수동 생성
    * 사용자가 행에 대한 엑세스 시간을 줄이기 위해서 특정 열을 대상으로 인덱스를 생성할 수 있다.
- 인덱스 생성하기
```sql
  CREATE INDEX 인덱스명
  ON 테이블명 (컬럼명, ....)
```
- 인덱스 삭제하기
```sql
  DROP INDEX 인덱스명
```
- 함수 기반 인덱스 생성하기
```sql
  CREATE INDEX 인덱스명
  ON 테이블명 (오라클함수)
```
- 인덱스를 생성이 필요한 경우
  + where절이나 조인조건에 자주 사용되는 경우
  + 컬럼이 매우 다양한 값을 포함하고 있는 경우
  + 데이터가 아주 많은 테이블을 대상으로 조회작업을 했을 때 대부분의 조회작업에서 검색되는 행이 전체 데이터의 2%~4%미만인 경우
- 인덱스 생성이 필요하지 않는 경우
  + 테이블이 작은 경우
  + 테이블이 자주 갱신되는 경우
  + 인덱스화된 열이 표현식의 일부로 사용되는 경우
  + where절의 조회 조건으로 자주 사용되지 않는 경우
  + 대부분의 조회작업에서 전체 데이터의 2%~4%이상 검색되는 경우

### 트리거
- 특정 테이블에 INSERT, UPDATE, DELETE 작업이 수행될 때 자동으로 실행되는 것이다.
- 트리거는 데이터베이스 객체다.
- 종류
  + 행 트리거
    * 테이블의 데이터가 변경될 때 실행되는 트리거
  + 문장 트리거
    * 영향을 받는 행이 없더라고 실행되는 트리거
    * 특정 시간에 실행되는 트리거
- 형식
```sql
  CREATE OR REPLACE TRIGGER 트리거명
  {BEFORE | AFTER} 			-- 트리거 실행 싯점
  {INSERT, UPDATE, DELETE} ON 테이블명 	-- 이벤트종류	
  FOR EACH ROW				-- 데이터 행의 변화가 생길 때 마다 실행된다
  BEGIN
    실행할 SQL
  END;
```
- 트리거의 접두어(OLD, NEW)
  +  OLD, NEW 접두어는 행 트리거에서만 사용가능하다.
  + 트리거 수행문에서 변경이 발생한 행의 이전값, 변경된(추가된 값)을 사용할 수 있다.

  |작업 | OLD값 | NEW값 |
  | --- | --- | --- |
  | INSERT | NULL | 추가된 값 |
  | UPDATE | 갱신전의 값 | 갱신후의 값 |
  | DELETE | 삭제전의 값 | NULL |

  

- 작성예
  + 주문정보 이력 저장하기
    * 주문정보가 추가되거나, 주문상태가 변경될 때마다 그 이력을 저장하기
    * 주문정보 이력을 저장하는 테이블 생성하기
  ```sql  
    create table tb_order_history (
    order_no number(7),
    cust_no number(5),
    order_status varchar2(20),
    order_update_date date
    );
  ```
  + 주문정보 추가/변경시 실행될 트리거 생성하기
  ```sql
    CREATE OR REPLACE TRIGGER order_history_trigger
    AFTER 
    INSERT OR UPDATE ON tb_orders 
    FOR EACH ROW     
    BEGIN
      insert into tb_order_history
      (order_no, cust_no, order_status, order_update_date)
      values
      (:new.order_no, :new.cust_no, :new.order_status, sysdate);
    END;
  ```
- 트리거 활성화 비활성화 하기
```sql
  ALTER TRIGGER 트리거명 ENABLE;
  ALTER TRIGGER 트리거명 DISABLE;
```
- 트리거 삭제하기
```sql
  DROP TRIGGER 트리거명;
```
