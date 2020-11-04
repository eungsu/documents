# JDBC
- Java DataBase Connectivity
- 자바가 데이터베이스에 접속해서 SQL을 실행할 수 있도록 하는 표준이다.
- java.sql 패키지와 javax.sql 패키지에 관련 인터페이스와 클래스가 존재한다.

## 주요 API
- Connection 인터페이스
  + 자바프로그램과 데이터베이스간의 연결을 담당하는 객체다.
	+ Statement createStatement()
    - SQL전송을 담당하는 Statement객체를 반환한다.
  + PreparedStatement prepareStatement(String sql)
    - SQL전송을 담당하는 Statement객체를 반환한다.
  + void commit()
    * SQL실행결과를 DB에 반영시킨다.
  + void rollback()
    * SQL실행결과의 DB 반영을 취소시킨다.
  + void close()
    * DB와의 접속을 해제한다.
- Statement 인터페이스
  + SQL의 전송을 담당하는 객체다.
  + int executeUpdate(String sql)
    * INSERT, UPDATE, DELETE 쿼리를 DB로 전송하고, 실행결과를 반환한다.
  + ResultSet executeQuery(String sql)
    * SELECT 쿼리를 DB로 전송하고, 조회결과를 반환한다.
  + void close()
    * DB 연결 자원을 해제한다.
- PreparedStatement 인터페이스
  + SQL의 전송을 담당하는 객체다.
  + int executeUpdate()
    * INSERT, UPDATE, DELETE 쿼리를 DB로 전송하고, 실행결과를 반환한다.
  + ResultSet executeQuery()
    * SELECT 쿼리를 DB로 전송하고, 조회결과를 반환한다.
  + void setXXX(int index, XXX value)
    * ?위치에 실제값(파라미터값)을 설정한다.
    * void setString(int index, String value)
    * void setInt(int index, int value)
    * void setLong(int index, long value)
    * void setDouble(int index, double value)
    * void setDate(int index, Date value)
  + void close()
    * DB 연결 자원을 해제한다.
- ResultSet 인터페이스
  + SELECT 쿼리문의 조회결과를 담당하는 객체다.
  + boolean next()
    * 커서를 다음행으로 이동시킨다. 데이터행이 존재하면 true를 반환한다.
  + XXX getXXX(String columnName)
    * 컬럼명에 해당하는 값을 반환한다.
  + void close()
    * DB 연결 자원을 해제한다.
- DriverManager 클래스
  + JDCB 표준을 구현한 JDBC드라이버를 관리하는 클래스다.
  + JDBC드라이버는 각 DBMS제작사가 자사의 DBMS에 엑세스할 수 있도록 위에 언급한 인터페이스를 구현한 클래스들의 모음이다.
  + Connection getConnection(String url, String username, String password)
    * url이 가르키는 데이터베이스에 지정된 계정정보로 연결을 시도한 후 연결을 담당하는 Connection객체를 반환한다.


