# StringBuilder와 StringBuffer
- 임시저장소(버퍼)를 가지고 있어서, append(다양한 타입의 데이터)로 새로운 객체 생성없이 임시저장소에 데이터를 저장할 수 있다.
- 임시저장소에 저장된 데이터는 toString() 메소드를 실행해서 문자열(String)로 제공받을 수 있다.
- StringBuilder와 StringBuffer의 사용법은 완전히 동일하다.
  + StringBuffer는 멀티스레드환경에서 안전하게 사용할 수 있지만 속도가 느리다.
  + StringBuilder는 멀티스레드환경에서 안전하지 않지만, 속도는 빠르다.
- 사용 예제
  ```java
    String text = "국어" + 70 + "수학" + 80 + "영어" + 100;
	// ["국어"]		     	
	// ["국어70"]				
	// ["국어70수학"]				
	// ["국어70수학80"]			
	// ["국어70수학80영어"]  
	// ["국어70수학80영어100"]
	// text에 최종적으로 대입되는 값은 "국어70수학80영어100" 다.
	// String객체의 불변특성 때문에 불필요한 객체 5개가 추가로 생성된다.

    StringBuilder sb = new StringBuilder();
    sb.append("국어");	// 버퍼에 저장
    sb.append(70);		// 버퍼에 저장
    sb.append("수학");	// 버퍼에 저장
    sb.append(80);		// 버퍼에 저장
    sb.append("영어");	// 버퍼에 저장
    sb.append(100);		// 버퍼에 저장
    String finalText = sb.toString(); // 버퍼에 저장된 데이터가 전부 연결된 문자열이 반환된다.
  ```
- StringBuilder를 사용하면 "+" 연산을 사용해서 이어붙이기 할 때 보다 불필요한 객체의 생성이 억제되어서 메모리 효율 및 실행 성능이 개선된다.




			
