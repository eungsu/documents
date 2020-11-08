# 조인
- 조인은 두 개 이상의 테이블을 연결지어서 데이터를 조회하는 것이다.
  + 오라클과 같은 관계형데이터베이스는 모든 정보를 하나의 테이블에 저장하는 것이 아니라, 데이터가 정규화되어 여러 테이블에 분산되어 있다.
  + 데이터가 여러 테이블에 흩어져 있기 때문에 사용자가 원하는 데이터를 찾기위해서는 여러 테이블을 다 조회해야 한다.
- 조인은 여러 테이블에 흩어져 있는 정보중에서 사용자가 원하는 정보만 가져와서 가상의 테이블처럼 만들어서 데이터를 조회하는 것이다.
  + 조인의 예
    * 사원테이블에는 사번, 이름, 소속부서번호가 있다.
    * 부서테이블에는 부서번호, 부서명, 위치가 있다.
    * 아래와 같이 사원테이블에서 사원의 이름을 가져오고, 부서테이블에서 그 사원이 소속된 부서명을 조회해야 한다.
    <kbd>![alt 조인](/images/db/join1.PNG)</kbd>
    + 조인은 사원테이블과 부서테이블의 각각의 행을 서로 연관있는 행끼리 연결지어서 새로운 가상의 테이블을 만들고, 그 테이블로부터 필요한 정보를 가져오는 것이다.

## 조인의 방법
- 조인문법은 오라클에서만 사용되는 Oracle Join과 모든 RDBMS에서 공통적으로 사용하는 ANSI(표준) Join이 있다.
  + Oracle Join
  ```sql
    SELECT a.col1, b.col2
    FROM table1 a, table2 b
    WHERE a.col2 = b.col2; -- Join 조건
  ```
  + ANSI Join
  ```sql
    SELECT a.col1, b.col2
    FROM table1 a [INNER] JOIN table2 b
    ON a.col2 = b.col2
  ```
- 조인이 수행될 때는 두개 이상의 테이블이 사용되는데, 둘 중에 먼저 읽는 테이블을 선행 테이블이라 하고, 뒤에 오는 테이블을 후행 테이블이라고한다.
- 선행 테이블은 조회할 데이터가 적은 테이블로 선택하는 것이 속도면에서 유리하다

## 조인의 종류
### 카티션곱(Cartesian product)
- 조인에서 가장 중요한 부분은 조인조건을 지정해주는 부분이다.
- emp테이블과 dept테이블에서 서로 관련있는 데이터를 가져올 때, 조인조건을 보고 가져오게 되는데, 조인조건이 적절하지 않으면 틀린 데이터를 가져오거나 데이터를 가지고 오지 못할 수 있다.
- 카티션곱은 조인조건을 지정하지 않고, 두 개이상의 테이블을 조인하는 것이다.
- 조인조건을 지정하지 않으면 조인된 테이블의 모든 데이터를 전부 가져오게된다.
- ANSI SQL에서는 CROSS JOIN이라고 한다.
- 이런 경우 조인 작업에 참조되는 테이블의 행수를 모두 곱한 값만큼의 행이 조회결과가 된다.

### 등가조인(Equi Join)
- 조인에서 가장 많이 사용되는 조인이다.
- 등가조인은 선행 테이블에서 데이터를 가져온 후 조인 조건절을 검사해서 동일한 값을 가진 데이터를 후행 테이블에서 꺼내오는 방법이다.
- 조인조건에서 Equal(=) 연산자를 사용해서 EQUI Join이라고 한다.
- 등가조인 사용하기
  + emp테이블과 dept 테이블 조인해서 사원이름, 소속부서명 조회하기
  ```sql
    -- Oracle Join
    SELECT e.empno, e.ename, d.dname
    FROM emp e, dept d
    WHERE e.deptno = d.deptno;
    
    -- ANSI Join
    SELECT e.empno, e.ename, d.dname
    FROM emp e JOIN dept d
    ON e.deptno = d.deptn;
  ```
  + student테이블과 professor 테이블 조인해서 학생의 이름과 지도교수 이름 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name, p.name
    FROM student s, professor p
    WHERE s.profno = p.profno;
    
    -- ANSI Join
    SELECT s.name, p.name
    FROM student s JOIN professor p
    ON s.profno = p.profno;
  ```
  + student테이블과 department테이블, professor테이블을 조인해서 학생명, 전공학과명, 지도교수이름 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name 학생이름, d.dname 학과명, p.name 지도교수명
    FROM student s, department d, professor p
    WHERE s.deptno1 = d.deptno AND s.profno = p.profno;
    
    -- ANSI Join
    SELECT s.name 학생이름, d.dname 학과명, p.name 지도교수명
    FROM student s JOIN department d
    ON s.deptno1 = d.deptno
    JOIN professor p
    ON s.profno = p.profno;
  ```
  + deptno1이 101인 학생들의 학생이름, 지도교수를 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name, s.deptno1, p.name
    FROM student s, professor p
    where s.deptno1 = 101 AND s.profno = p.profno
 
    -- ANSI Join
    SELECT s.name, s.deptno1, p.name
    FROM student s JOIN professor p
    ON s.profno = p.profno
    AND s.deptno1 = 101;
  ```
    * 조인조건과 검색조건이 동시에 있을 경우, 검색조건을 먼저 검색해서 데이터의 검색범위를 줄여놓고 조인을 수행하게 한다.

### 비등가조인(Non-Equi Join)
- 조인조건을 지정할 때 조인 대상테이블에서 같은 값을 가진 데이터를 가져오는 대신, 크거나 작은 경우의 조건으로 데이터를 조회하는 조인 방식이 비등가 조인이다.
- 비등가조인 사용하기
  + customer테이블과 gift테이블을 조인하여 고객별 마일리지 포인트를 조회한 후, 해당 마일리지 점수로 받을 수 있는 상품을 조회하여, 고객이름, 포인트, 받을 수 있는 선물 조회하기
  ```sql
    -- Oracle Join
    SELECT c.gname, c.point, g.gname
    FROM customer c, gift g
    WHERE c.point >= g.g_start AND c.point <= g.g_end;
    
    -- ANSI Join
    SELECT c.gname, c.point, g.gname
    FROM customer c JOIN gift g
    ON c.point >= g.g_start AND c.point <= g.g_end; 
  ```
  + student테이블과 score테이블 hakjum테이블을 조인하여 학생이름, 점수, 학점 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name, o.total, h.grade
    FROM student s, score o, hakjum h
    WHERE s.studno = o.studno
    AND o.total >= h.min_point
    AND o.total <= h.max_point;
    
    -- ANSI Join
    SELECT s.name, o.total, h.grade
    FROM student s JOIN score o
    ON s.studno = o.studno
    JOIN hakjum h
    ON o.total >= h.min_point
    AND o.total <= h.max_point;
  ```
### 포괄조인(Outer Join)
- 등가조인, 비등가조인은 조회하려는 데이터들이 조인에 참여하는 모든 테이블에 데이터가 존쟇는 경우에만 조회된다.
- 포괄조인은 한쪽 테이블에는 데이터가 있고, 다른쪽 테이블에는 데이터가 없는 경우에 데이터가 있는 쪽 테이블의 내용을 전부 조회하는 조인방법이다.
- 포괄조인 사용하기
  + student테이블과 professor테이블을 조인하여 학생이름, 지도교수이름 조회하기. 단 지도교수가 정해지지 않는 학생도 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name 학생명, p.name 교수명
    FROM student s, professor p
    WHERE s.profno = p.profno(+); -- 데이터가 없는 쪽 테이블에 (+)기호를 붙이면 된다.
    
    -- ANSI Join
    SELECT s.name 학생명, p.name 교수명
    FROM students LEFT OUTER JOIN professor p -- 선행테이블의 모든 행이 조회된다.
    ON s.profno = p.profno;
  ```
  + student테이블과 professor테이블을 조인하여 학생이름, 지도교수이름을 출력하기. 단, 지도학생이 결정되지 않은 교수도 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name 학생명, p.name 교수명
    FROM student s, professor p
    WHERE s.profno(+) = p.profno;
    
    -- ANSI Join
    SELECT s.name 학생명, p.name 교수명
    FROM student s RIGHT OUTER JOIN professor p -- 후행테이블의 모든 행이 조회된다.
    ON s.profno = p.profno;
  ```
  + student테이블과 professor테이블을 조인하여 학생명, 지도교수이름 조회하기. 단, 지도 학생이 결정안된 교수이름과 지도교수가 결졍안된 학생도 조회하기
  ```sql
    -- Oracle Join
    SELECT s.name 학생명, p.name 교수명
    FROM students, professor p
    WHERE s.profno(+) = p.profno -- 지도학생이 결정되지 않은 교수도 조회
    UNION
    SELECT s.name 학생명, p.name 교수명
    FROM student s, professor p
    WHERE s.profno = p.profno(+); -- 지도교수가 결정되지 않은 학생도 조회
    
    -- ANSI Join
    SELECT s.name, p.name
    FROM student s FULL OUTER JOIN professor p
    ON s.profno = p.profno;
  ```
### 셀프조인(Self Join)
- 하나의 테이블을 이용해서 조인을 구성하는 것이다.
- 하나의 테이블에 안에 상위데이터, 하위데이터가 있는 경우 상위데이터와 하위데이터를 서로 연관지어서 조회할 때 셀프조인이 필요하다.
- 하나의 테이블을 역할을 각각 나누어서 조인에 참여시켜야 한다 
- 셀프조인 사용하기
  + emp테이블에서 사원이름과 그 사원의 상사이름을 조회하기
  ```sql
    -- Oracle Join
    SELECT 사원.ename, 상사.ename
    FROM emp 사원, emp 상사
    WHERE 사원.mgr = 상사.empno;
    
    -- ANSI Join
    SELECT 사원.enme, 상사.ename
    FROM emp 사원 JOIN emp 상사
    ON 사원.mgr = 상사.empno
  ```

