# Date 클래스
- 시스템의 현재 날짜와 시간정보를 표현하는 클래스다.
- java.util 패키지에 있다.
- 주요 생성자
	+ new Date()
		* 현재 날짜와 시간정보가 포함된 객체가 생성된다.
	+ new Date(long 유닉스타임)
		* 지정된 유닉스타임에 해당하는 날짜와 시간정보가
			포함된 객체가 생성된다.
- 주요 메소드
	+ boolean after(Date when)
		* 지정된 날짜보다 이후 날짜인지 확인한다.
	+ boolean before(Date when)
		* 지정된 날짜보다 이전 날짜인지 확인한다.
	+ int compareTo(Date other)
		* 지정된 날짜와 순서를 비교한다.
	+ long getTime()
		* 유닉스타임을 반환한다.
