# 오라클의 데이터 타입
- VARCHAR2(size)
  + 가변길이 문자 데이터, 최대값: 4000
  + size범위내에서 실제 데이터의 크기만큼만 저장공간을 사용한다.
  + 예) 이름, 주소, 과목명, 상품명, 뉴스제목
- CHAR(size)
  + 고정길이 문자 데이터, 최대값: 2000
  + size크기만큼의 저장공간을 무조건 사용한다.
  + 예) 주민번호, 학번, 수강과목코드
- LONG	
  + 가변길이 대용량 문자 데이터, 최대값: 2GB
  + 현재는 잘 사용되지 않음
  + 테이블당 하나밖에 사용할 수 없다.
  + 제약조건을 정의할 수 없다.
  + order by나 group by에 포함시킬 수 없다.
- CLOB
  + 가변길이 대용량 문자 데이터(Character Large OBject), 최대값: 4GB
  + 예) 블로그의 본문, 신문기사, 논문
- NUMBER(p, s)
  + 가변길이 숫자 데이터
  + p:십진수의 총 갯수, s:소숫점이하 자릿수
- DATE
  + 날짜 및 시간 데이터
  + 예) 입사일, 가입일, 주문날짜, 이체날짜, 신청날짜 ...
- TIMESTAMP
  + 날짜 및 시간 데이터, 소수점 이하 초까지 포함한다.
- BLOB
  + 가변길이 대용량 이진 데이터(Binary Large OBject), 최대값: 4GB
  + 예) 그림, 영상, 게임파일
- ROWID
  + 테이블에서 행의 고유주소를 나타내는 64진수 숫자데이터
  ```sql
  select rowid, department_id, department_name
  from departments;
  
  rowid			departmet_id	department_name
  --------------------------------------------------------
  AAAEAWAAEAAAACtAAA	10		Administration	
  AAAEAWAAEAAAACtAAB	20		Marketing	
  AAAEAWAAEAAAACtAAC	30		건희 영업팀	
  ```
+ rowid의 구성

| 오브젝트번호(6자리) | 파일번호(3자리) | 블록번호(6자리) | 데이터번호(3자리) |
| --- | --- | --- | --- | --- |
| AAAEAW | AAE | AAAACt | AAA |
| AAAEAb | AAE | AAAADN | AAA |

+ 오브젝트번호 
  * 해당 데이터가 속해있는 데이터베이스 객체(테이블)의 번호
  * 데이터베이스 객체마다 고유하다.
+ 파일번호
  * 해당 데이터가 위치하고 있는 테이블스페이스 파일번호
+ 블록번호
  * 파일내부의 블록번호 
+ 데이터번호
  * 데이터가 저장되어있는 데이터 디렉토리 슬롯 번호	
		
	 
