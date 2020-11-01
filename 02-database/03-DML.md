# DML
- 데이터 조작어다.
- 데이터의 추가, 조회, 변경, 삭제 명령어다.

## 데이터 조회(SELECT)
### 데이터 조회하기
- 테이블의 모든 행, 모든 컬럼을 조회
  ```sql
    SELECT *
    FROM   테이블명;
  ```
- 테이블의 모든 행, 특정 컬럼을 조회
  ```sql
    SELECT 컬럼명, 컬럼명, ...
    FROM   테이블명;
  ```
- 테이블의 특정 행, 모든 컬럼을 조회
  ```sql
    SELECT *
    FROM   테이블명
    WHERE  조회조건식
  ```
- 테이블의 특정 행, 특정 컬럼을 조회
  ```sql
    SELECT 컬럼명, 컬럼명, ...
    FROM   테이블명
    WHERE  조회조건식
  ```
- 산술식 사용하기
  + select절, where절, group by절, having절 등에서 산술연산자를 사용할 수 있다.
  + 숫자와 날짜 데이터를 대상으로 만 사용할 수 있다.
- 중복 제거하기
  + 동일한 컬럼값을 가진 행이 한 번만 조회된다.
  ```sql
    SELECT DISTINCT 컬럼명, ...
    FROM 테이블;
  ```
- 별칭 사용하기
  + select절과 from 절에서는 별칭을 정의할 수 있다.
  + 별칭이 특수문자, 공백을 포함하고 있을 때는 ""안에 적는다.
  ```sql
    SELECT 컬럼명 as 별칭, 컬럼명 as "별칭", 연산식 as 별칭, ...
    FROM  테이블명
 
    SELECT 컬럼명 별칭, 컬럼명 "별칭", 연산식 별칭, ...
    FROM   테이블명
  ```
### 행의 제한(데이터 필터링)
- WHERE 절을 사용한다.
- 제시된 조건식을 만족하는 행만 조회된다.
  ```sql
    SELECT 컬럼명, 컬럼명,....
    FROM 테이블
    WHERE  조건식;
  ```
- 논리 연산자
  + 두 개이상의 조건식으로 데이터를 제한할 수 있다.
  + AND, OR, NOT
  ```sql
    SELECT 컬럼명, 컬럼명,....
    FROM   테이블명
    WHERE 조건식 AND 조건식;
    
    SELECT 컬럼명, 컬럼명,....
    FROM   테이블명
    WHERE 조건식 OR 조건식;
    
    SELECT 컬럼명, 컬럼명,....
    FROM   테이블명
    WHERE 조건식 AND (조건식 OR 조건식);
  ```
- 기타 연산자
  + BETWEEN 하한값 AND 상한값
    * 컬럼의 값이 하한값과 상한값 범위내면 true다.
  ```sql
    SELECT 컬럼명, 컬럼명, ....
    FORM 테이블명
    WHERE 컬럼명 BETWEEN 값 AND 값;
  ```
  + IN (값, 값, 값, ...)
    * 컬럼의 값이 제시된 값들 중 하나와 일치하면 true다.
  ```sql
    SELECT 컬럼명, 컬럼명, ....
    FROM 테이블명
    WHERE 컬럼명 IN (값, 값, ...);
  ```
  + LIKE '패턴'
    * 컬럼의 값이 제시된 패턴과 일치하면 true다.
    * 패턴문자  

    | 패턴문자 | 설명 |
    | --- | --- | 
    | '%' | 0개 이상의 일련의 임의의 문자를 나타낸다 | 
    | '_' | 임의의 문자 하나를 나타낸다 |

    * 이름 LIKE '이_'; 성이 이씨고, 이름이 한 글자인 사람
    * 이름 LIKE '이%'; 성이 이씨인 사람
    * 책제목 LIKE '%자바%'; 제목에 "자바"가 포함되어 있는 모든 책
  ```sql
    SELECT 컬럼명, 컬럼명, ....
    FROM 테이블명
    WHERE 컬럼명 LIKE %패턴%
  ```
  + IS NULL, IS NOT NULL
    * 컬럼의 값이 NULL인 행 혹은 NULL이 아닌 경우 TRUE
  ```sql
    SELECT 컬럼명, 컬럼명, ....
    FROM 테이블명
    WHERE 컬럼명 IS NULL

    SELECT 컬럼명, 컬럼명, ....
    FROM 테이블명
    WHERE 컬럼명 IS NOT NULL;
  ```
### 행의 정렬
- order by 절 사용한다.
- order by 절은 select문의 맨 마지막에 등장해야 한다.
  ```sql
    SELECT 컬럼명, 컬럼명, ....
    FROM 테이블명
    [where 조건식]
    [order by {컬럼명|표현식} [ASC|DESC]]
    
    -- ASC : 오름차순 정렬
    -- DESC : 내림차순 정렬
  ```
  
## 데이터 추가	
- INSERT INTO 명령어 사용
- 구문형식
  ```sql
    -- 값이 저장될 컬럼명을 직접 나열하는 방식
    -- 생략된 컬럼에는 NULL값이 저장된다.
    INSERT INTO 테이블명 (컬럼명, 컬럼명, 컬럼명)
    VALUES (값, 값, 값);
    
    -- 컬럼명을 생략하는 방식
    -- 모든 컬럼의 값을 전부 적어야 한다.
    -- 테이블의 컬럼 순서와 동일한 순서로 값을 적어야 한다.
    INSERT INTO 테이블명
    VALUES (값, 값, 값);
  ```
  ```sql
    insert into contacts(name, tel, fax)
    values('홍길동', '010-1111-111', '02-1111-1111')
  ```
  ```sql
    insert into contacts
    values('홍길동', '010-1111-111', '서울', 'hong@gmail.com', NULL, sysdate)
  ```
  
## 데이터 변경
- 테이블에 저장된 데이터를 변경한다.
- UPDATE 명령어 사용
- 구문형식
  ```sql
    UPDATE 테이블
    SET
      컬럼명 = 값,
      컬럼명 = 값,
      컬럼명 = 값
      [WHERE 조건식]
      
      -- WHERE 조건식이 없으면 모든 행에서 해당 컬럼의 값을 변경한다.
      -- WHERE 조건식이 있으면 조건식을 만족하는 행에서만 해당 컬럼의 값을 변경한다.
  ```
## 데이터 삭제
- 테이블에 저장된 데이터를 삭제한다.
- DELETE FROM 명령어 사용
- 구문형식
  ```sql
    DELETE FROM 테이블명
    [WHERE 조건식]
    -- WHERE 조건식이 없으면 테이블의 모든 행이 삭제된다.
    -- WHERE 조건식이 있으면 조건식을 만족하는 행만 삭제한다.
  ```
 - 테이블의 모든 데이터 삭제하기
   ```sql
     DELETE FRM 테이블명
   ```
 - 제시된 조건과 일치하는 행을 삭제하기
   ```sql
     DELETE FROM 테이블명
     WHERE 조건식
   ```
  



