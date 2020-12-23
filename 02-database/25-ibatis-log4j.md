# ibatis log4j 설정
- 프로그램 실행 과정에서 만들어지는 로그내용을 여러 대상으로 출력할 수 있도록 도와주는 라이브러리
- log4j는 로그내용을 화면, 파일, 스트림, 원격서버, 이메일로 보낼 수 있다.
- log4j는 출력대상과 출력방법을 Appender로 변경할 수 있다.
- log4j는 출력형식을 Layout으로 변경할 수 있다.
- log4j는 properties나 xml 파일을 설정파일로 사용할 수 있다.

## log4j의 주요 클래스
- ConsoleAppender : 화면에 로그내용을 출력한다.
- FileAppender : 파일에 로그내용을 기록한다.
- DailyRollingFileAppender : 날짜별로 로그파일을 생성해서 기록한다.
- log4j의 로그 레벨
  + FATAL	: 심각한 에러가 발생
  + ERROR : 요청 처리 중 장애 발생
  + WARN : 프로그램 실행에 문제가 되지 않는 경고성 메세지 발생
  + INFO : 로그인, 상태변경과 같은 정보성 메세지 출력
  + DEBUG : 개발시 디버그 용도로 사용한 메세지 출력
  + TRACE : DEBUG 레벨보다 더 상세한 상태를 나타냄

## log4j.properties 파일 설정하기
```	
	# 기본 로그레벨과 출력대상을 결정함
	# 기본 로그레벨: ERROR
	# 출력대상 : stdout
	log4j.rootLogger=ERROR, stdout
	
	# 특정 클래스나 패키지를 대상으로 로그레벨을 결정함
	# java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet은 DEBUG 로그레벨로 결정함
	log4j.logger.java.sql.Connection=DEBUG
	log4j.logger.java.sql.Statement=DEBUG
	log4j.logger.java.sql.PreparedStatement=DEBUG
	log4j.logger.java.sql.ResultSet=DEBUG

	# 로그출력대상을 결정함 -> ConsoleAppender(화면에 로그내용 출력)
	log4j.appender.stdout=org.apache.log4j.ConsoleAppender
	# 로그출력형식을 결정함 -> PatternLayout(지정된 패턴문자를 사용해서 출력형식을 결정)
	log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
	# 로그출력형식을 패턴 문자를 활용해서 결정함
	log4j.appender.stdout.layout.ConversionPattern=%5p [%d] - %m%n
```
