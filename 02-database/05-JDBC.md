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
    
 ## JDBC API를 사용해서 자바와 데이터베이스 연동하기
 - 자바와 데이터베이스 연동 절차
   1. JDBC 드라이브 JVM 메모리에 로딩하기
   ```java
     Class.forName("oracle.jdbc.OracleDriver");
   ```
   2. DBMS와 연결을 담당하는 Connection객체 획득하기
   ```java
     String url = "jdbc:oracle:thin:@localhost:1521:xe";
     String username = "hta";
     String password = "zxcv1234";
     Connection connection = DriverClassName.getConnection(url, username, password);
   ```
   3. DDBMS에 SQL 전송과 실행을 담당하는 PreparedStatement객체 획득하기
   ```java
     String sql = "insert into department(deptno, dname, part, build) values (?, ?, ?, ?)";
     PreparedStatement pstmt = connection.prepareStatement(slq);
   ```
   4. SQL의 ?에 값을 대응시키기
   ```java
     pstmt.setInt(1, 204);
     pstmt.setString(2, '정밀기계공학과');
     pstmt.setInt(3, 200);
     pstmt.setString(4, '정밀기계실험관');
   ```
   5. SQL을 DBMS에 보내서 실행시키기
   ```java
     pstmt.executeUpdate();
   ```
   6. DBMS와 연결된 모든 자원을 해제하기
   ```java
     pstmt.close();
     connection.close();
   ```
### 데이터 조회하기
- 레코드 한 개 조회하기
```java
  public Department getDepartmentByNo(int deptNo) throws SQLException {
    Department department = null;
    String sql = "String * from department where deptno = ?";
  
    String driverClassName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hta";
    String password = "zxcv1234";
  
    Class.forName(driverClassName);
    Connection connection = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setInt(1, deptNo);
    
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
      department = new Department();
      department.setNo(rs.getInt("deptno"));
      department.setName(rs.getString("dname"));
      department.setPart(rs.getInt("part"));
      department.setBuild(rs.getString("build"));
    }
    rs.close();
    pstmt.close();
    connection.close();
    
    return department;
  }
```
- 레코드 여러 개 조회하기
```java
  public List<Department> getAllDepartments(int deptNo) throws SQLException {
    List<Department> departmentList = new ArrayList<>();
    String sql = "String * from department";
  
    String driverClassName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hta";
    String password = "zxcv1234";
  
    Class.forName(driverClassName);
    Connection connection = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = connection.prepareStatement(sql);
    
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      Department department = new Department();
      department.setNo(rs.getInt("deptno"));
      department.setName(rs.getString("dname"));
      department.setPart(rs.getInt("part"));
      department.setBuild(rs.getString("build"));
      
      departmentList.add(department);
    }
    rs.close();
    pstmt.close();
    connection.close();
    
    return departmentList;
  }
```
- 레코드를 추가하기
```java
  public void insertDepartment(Department department) throws SQLException {
    String sql = "insert into department(deptno, dname, part, build) values (?,?,?,?)";
  
    String driverClassName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hta";
    String password = "zxcv1234";
  
    Class.forName(driverClassName);
    Connection connection = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setInt(1, department.getNo());
    pstmt.setString(2, department.getName());
    pstmt.setInt(3, department.getPart());
    pstmt.setString(4, department.getBuild());
    pstmt.executeUpdate();
    
    pstmt.close();
    connection.close();
  }
```
- 레코드 삭제하기
```java
  public void deleteDepartmentByNo(int deptNo) throws SQLException {
    String sql = "delete from department where deptno = ?";
  
    String driverClassName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hta";
    String password = "zxcv1234";
  
    Class.forName(driverClassName);
    Connection connection = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setInt(1, deptNo);
    pstmt.executeUpdate();
    
    pstmt.close();
    connection.close();
  }
```
- 레코드 변경하기
```java
  public void updateDepartment(Department department) throws SQLException {
    String sql = "update department ";
    sql += "      set ";
    sql += "      dname = ?, ";
    sql += "      part = ?, ";
    sql += "      build = ? ";
    sql += "      where deptno = ? "
    
    String driverClassName = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String username = "hta";
    String password = "zxcv1234";
  
    Class.forName(driverClassName);
    Connection connection = DriverManager.getConnection(url, username, password);
    PreparedStatement pstmt = connection.prepareStatement(sql);
   
    pstmt.setString(1, department.getName());
    pstmt.setInt(2, department.getPart());
    pstmt.setString(3, department.getBuild());
    pstmt.setInt(4, department.getNo());
    pstmt.executeUpdate();
    
    pstmt.close();
    connection.close();
  }
```

