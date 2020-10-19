# String
- 문자열을 표현하는 객체다.
- 문자열(String)은 불변객체다.
  + 한번 생성된 문자열은 절대로 변하지 않는다.
- String객체를 생성하는 방법
  ```java
    String s = "abc";
    String s = new String("abc");
    
    char[] data = {'a', 'b', 'c'};
    String s = new String(data);
  ```
- String객체는 문자열과 관련된 다양한 기능들을 제공한다.

## String의 주요 메소드
| 반환값 타입 | 메소드이름 | 설명 |
| --- | --- | --- |

	- int		length()
			문자열의 길이를 반환한다.
	- boolean	equals(Object str)
			문자열의 내용을 비교해서 동등성 여부를 반환한다.
	- boolean	isEmpty()
			문자열의 길이가 0인 경우 true를 반환한다.
	- boolean 	contains(CharSequence s)
			지정된 문자열이 포함되어 있으면 true를 반환한다.
	- int		indexOf(String str)
			지정된 문자열이 처음으로 등장하는 위치를 반환한다.
	- int 		lastIndexOf(String str)
			지정된 문자열이 마지막으로 등장하는 위치를 반환한다.
	- String	substring(int beginIndex)
			지정된 위치부터 끝까지의 문자열을 새로 만들어서 반환한다.
	- String 	substring(int beginIndex, int lastIndex)
			지정된 시작위치부터 끝위치 앞까지의 문자열을 새로 만들어서 반환한다.
	- String	replace(CharSequenct target, CharSequence replacement)
			대상 문자열을 지정된 문자열로 대체한 새로운 문자열을 반환한다.
	- String 	replaceAll(String regex, String replacement)
			정규표현식에 해당하는 대상문자열을 지정된 문자열로 대체한 새로운 문자열을 반환한다.
	- String 	toLowerCase()
			문자열을 소문자로 새로 만들어서 반환한다.
	- String 	toUpperCase()
			문자열을 대문자로 새로 만들어서 반환한다.
	- String	trim()
			문자열의 좌우 불필요한 공백이 제거된 새로운 문자열을 만들어서 반환한다.
	- boolean 	startsWith(String prefix)
			문자열이 지정된 문자열로 시작하면 true를 반환한다.
	- boolean 	endsWith(String suffix)
			문자열이 지정된 문자열로 끝나면 true를 반환한다.
	- String[] 	split(String regex)
			문자열을 지정된 구분문자열로 잘라서 각각의 요소를 배열에 담아서 반환한다.
	- int 		compareTo(String other)
			지정된 다른 문자와 사전 순서대로 비교한다
			abc	abc 	---> 0
			abc	xyz	---> 음수
			xyz	abc	---> 양수
	- char		charAt(int index)
			문자열에서 지정된 위치의 글자를 문자로 반환한다.
	- String 	valueOf(다양한 값)
			- 전달받은 다양한 타입의 값을 문자열로 바꿔서 반환한다.
			- 정적메소드다.





	
	

	








	
			
