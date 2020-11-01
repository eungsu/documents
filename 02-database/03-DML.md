# DML
- 데이터 조회
  + SELECT 명령어 
    * 테이블의 데이터를 조회한다.
		SELECT문의 형식
			테이블의 모든 행, 모든 컬럼을 조회
				SELECT *
				FROM   테이블명;
			테이블의 모든 행, 특정 컬럼을 조회
				SELECT 컬럼명, 컬럼명, ...
				FROM   테이블명;
			테이블의 특정 행, 모든 컬럼을 조회
				SELECT *
				FROM   테이블명
				WHERE  조회조건식
			테이블의 특정 행, 특정 컬럼을 조회
				SELECT 컬럼명, 컬럼명, ...
				FROM   테이블명
				WHERE  조회조건식
		산술식 사용하기 			
			select절, where절, group by절, having절 등에서 산술연산자를 사용할 수 있다.
			+, -, *, /
			숫자와 날짜 데이터를 대상으로 만 사용할 수 있다.
		중복 제거하기
			distinct
			select distinct 컬럼명, ...
			from 테이블;
			* 동일한 컬럼값을 가진 행이 한 번만 조회된다.
		별칭 사용하기
			select절과 from 절에서는 별칭을 정의할 수 있다.

			select 컬럼명 as 별칭, 컬럼명 as "별칭", 연산식 as 별칭, ...
			from   테이블명

			select 컬럼명 별칭, 컬럼명 "별칭", 연산식 별칭, ...
			from   테이블명
			* 별칭이 특수문자, 공백을 포함하고 있을 때는 ""안에 적는다.
		행의 제한(데이터 필터링)
			select 컬럼명, 컬럼명,....
			from   테이블명
			where  조건식;
			* 제시된 조건식을 만족하는 행만 조회된다.
			* 조건 연산자
				>, 	>=, 		<, 	<=, 
				크다 	크거나 같다	작다	작거나 같다.
				=, 	<>, 		!=
				같다	같지않다	같지않다.
			* 논리 연산자
				* 두 개이상의 조건식으로 데이터를 제한할 수 있다.
				and 
				or <---- 사용하지 맙시다.
				not
			* 기타 연산자
				between 하한값 and 상한값
					컬럼의 값이 하한값과 상한값 범위내면 true다.
				in (값, 값, 값, ...)
					컬럼의 값이 제시된 값들 중 하나와 일치하면 true다.
				like '패턴'
					컬럼의 값이 제시된 패턴과 일치하면 true다.
					* 패턴문자
						'%' : 0개 이상의 일련의 임의의 문자를 나타낸다.
 						'_' : 임의의 문자 하나를 나타낸다.
						작성예)
							where name like '이_';
								성이 이씨이고 이름이 한글자인 사람
								'이이', '이황', '이상', '이도'
							where name like '이%';
								성이 이씨인 사람
								'이', '이이', '이순신', '이김선영'
							where title like '%' || '자바' || '%';						
								이것이 자바다, 자바의 정석, 일주일만에 끝내는 자바
				is null
					컬럼의 값이 null이면 true다.
				is not null
					컬럼의 값이 null이 아니면 true다.
		행을 정렬하기
			order by 절 사용한다.
			order by 절은 select문의 맨 마지막에 등장해야 한다.
			작성예
				select ~
				from   ~
				[where ~]
				[order by {컬럼명|표현식} [ASC|DESC]]
				* ASC : 오름차순 정렬
				* DESC : 내림차순 정렬

				
	- 데이터 추가	
		INSERT INTO 명령어 사용
		형식
			* 값이 저장될 컬럼명을 직접 나열하는 방식
			* 특정 컬럼명을 생략하는 것도 가능하다.
		          (생략된 컬럼에는 묵시적으로 NULL 자동으로 들어간다.)
			  (생략된 컬럼중에서 DEFAULT 값이 설정되어 있는 컬럼은 기본값이 저장된다.)
			INSERT INTO 테이블명 (컬럼명, 컬럼명, 컬럼명)
			VALUES               (값,     값,     값)
			예)
			insert into contacts(name, tel, fax)
			values('홍길동', '010-1111-111', '02-1111-1111')

			* 컬럼명을 생략하는 방식
			* 무조건 VALUES에서 모든 컬럼에 들어갈 값을 명시해야 한다.
			* 값의 순서와 컬럼의 순서가 동일해야 된다.
			INSERT INTO 테이블명
			VALUES(값, 값, 값)
			예)
			insert into contacts
			values('홍길동', '010-1111-111', '서울', 'hong@gmail.com', NULL, sysdate)
			
	- 데이터 변경
		UPDATE 명령어 사용
		형식
			UPDATE 테이블
			SET
				컬럼명 = 값,
				컬럼명 = 값,
				컬럼명 = 값
			[WHERE 조건식]
			* WHERE 조건식이 없으면 모든 행에서 해당 컬럼의 값을 변경한다.
			* WHERE 조건식이 있으면 조건식을 만족하는 행에서만 해당 컬럼의 값을 변경한다.
			예)
				UPDATE contacts
				SET
					tel = '010-1236-5485',
					address = '서울특별시 서대문구'
				where name = '홍길동';
	- 데이터 삭제
		DELETE FROM 명령어 사용
		형식
			DELETE FROM 테이블명
			[WHERE 조건식]
			* WHERE 조건식이 없으면 테이블의 모든 행이 삭제된다.
			* WHERE 조건식이 있으면 조건식을 만족하는 행만 삭제한다.

트랜잭션 처리 명령어
	commit
		INSERT, UPDATE, DELETE 쿼리의 실행 결과를 데이터베이스에 영구적으로 반영시킨다.
	rollback
		INSERT, UPDATE, DELETE 쿼리의 실행 결과에 대한 데이터베이스 반영을 취소시킨다.
		









