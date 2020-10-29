# File 클래스
- 디렉토리나 파일의 정보를 표현하는 클래스
- 파일의 내용을 포함하지 않는다.
- 실제 파일이나 디렉토리가 존재하지 않아도 File객체는 생성할 수 있다.
- 주요 생성자
  + File(String pathname)
  + File(String path, String name)
  + File(File path, String name)
- 주요 메소드
  + String getName()
    * 파일명을 반환한다.
  + long length()
    * 파일의 크기를 byte단위로 반환한다.
  + boolean exists()
    * 파일의 존재 여부를 반환한다.
  + String getAbsolutePath()
    * 파일의 전체경로를 반환한다.
  + String[] list()		
    * 디렉토리인 경우 내부의 모든 디렉토리명과 파일명을 반환한다.
  + File[] listFiles()
    * 디렉토리인 경우 내부의 모든 디렉토리와 파일에 대한 File객체들을 반환한다.
  + String getParent()
    * 부모 디렉토리명을 반환한다.
  + boolean isDirectory()
    * 디렉토리인지 여부를 반환한다.
  + boolean 	isFile()
    * 파일인지 여부를 반환한다.
  + boolean createNewFile()
    * 새로운 파일을 생성한다.
  + boolean mkdir(), mkdirs()
    * 새로운 디렉토리를 생성한다.
  + boolean delete()
    * 디렉토리나 파일을 삭제한다.
    * 디렉토리는 내부에 파일이나 디렉토리가 하나도 없어야 한다.
- File 클래스 사용하기
  + File 객체 생성하기
  ```java
    // 파일 전체경로를 지정해서 File객체 생성하기
    File file = new File("c:/documents/score.txt");
    
    // 디렉토리와 파일명을 지정해서 File객체 생성하기
    File file = new File("c:/documents", "score.txt"); 
    
    // 디렉토리를 지정해서 File객체 생성하기
    File directory = new File("c:/documents");
  ```
  + File객체의 메소드를 이용해서 파일정보 다루기
  ```java
    File file = new File("c:/documents/students.txt");
    
    // 파일명 조회하기
    String filename = file.getName();
    // 파일사이즈 조회하기
    long size = file.length();
    // 파일 절대경로 조회하기
    String fullname = file.getAbsolutePath();
    // 파일이 존재하는지 조회하기
    boolean exist = file.exists();
    // 파일 삭제하기
    file.delete();    
  ```
  + File객체를 활용해서 디렉토리 다루기
  ```java
    File directory = new File("c:/documents");
    
    // 디렉토리내 디렉토리명과 파일명 조회하기
    String[] names = directory.list();
    for (String fileOrSubDirectoryName : names) {
      System.out.println("파일명 혹은 하위디렉토리명");
    }
  ```
