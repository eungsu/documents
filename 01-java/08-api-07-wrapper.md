Wrapper 클래스
	- 기본자료형 타입에 대응되는 클래스다.
	- 기본자료형 값을 가지고 있는 객체를 만들 수 있다.
	- java.lang 패키지에 정의되어 있다.

	- 사용해야 할 때
		- 기본자료값이 아닌 객체로 저장해야할 때
		- 호출할 메소드의 매개변수가 객체를 요구할 때
		- 사용자의 입력값을 저장하는 변수를 만들 때
		  * 사용자의 입력여부에 따라서 실제입력값 혹은 null을 저장할 수 있기 때문에
		- 해당 기본자료형값에 대한 다양한 기능을 실행해야 할 때
	- 지원하는 Wrapper 클래스
		Byte, Short, Integer, Long
		Float, Double
		Character
		Boolean

오토박싱/오토언박싱
	- JAVA 1.5버전부터 도입된 기능
	- 기본자료형 타입과 Wrapper객체 타입간의 변환을 자동으로 지원한다.
	예) 오토박싱
		Integer a = new Integer(10);	// 박싱

		Integer b = 10;			// 오토박싱
		* Integer b = new Integer(10);	// 변수의 타입이 Wrapper 클래스 타입이면
						// 컴파일러가 자동으로 Wrapper객체를 생성해서
						// 값을 담는다.
	예) 오토언박싱
		Integer a = new Integer(10);	// 박싱
		int x = a.intValue();		// 언박싱

		int y = a;			// 오토언박싱
		* int y = a.intValue()		// 변수의 타입이 기본자료형 타입이면
						// 컴파일러가 자동으로 Wrapper객체의
						// xxxValue()를 실행해서 그 값을 대입한다.
	

	작성예)
		void x(int a) { ... }
		void y(Integer b) { ... }
 
		1.5버전 이전
			x(10);
			y(new Integer(10));

		1.5버전 이후
			x(10);	    변환
			y(10); -------------> y(new Integer(10));
				   오토박싱
				   
				   
				   
	오토박싱(Auto-Boxing)
	// 기본자료형값을 변수에 대입하거나, 매개변수로 전달할 때
	// 변수의 타입이 int이면 정수값이 전달된다.
	// 변수의 타입이 Integer 혹은 Object라면 그 정수값을 담은 Integer객체가 자동으로 생성된다.
	void m1(int no) { ... }		m1(10);
	void m2(Integer no) { ... }	m2(10);		// m2(new Integer(10));

	double d1 = 3.14;
	Double d2 = 3.14;				// Double d2 = new Double(3.14);

	ArrayList<Long> currency = new ArrayList<Long>();
	currency.add(10000000L);			// currency.add(new Long(10000000L));

	오토 언박싱(Auto-Unboxing)
	Wrapper객체를 변수에 대입하거나, 매개변수로 전달할 때
	변수의 타입이 기본자료형타입이면 자동으로 Wrapper객체에 저장된 기본자료형값만 대입된다.

	Double x = new Double(3.14);	// 오토-언박싱 지원으로 실제 실행되는 코드
	double y = x;			// double y = x.doubleValue();

	Integer x = new Integer(100);
	int y = x;			// int y = x.intValue();

	Long x = new Long(10000000000L);
	long y = x;			// int y = x.longValue(); 

	ArrayList<Integer> scores = new ArrayList<Integer>();
	scores.add(new Integer(100));
	scores.add(98);
	scores.add(68);

	for (Integer s : scores) {		for (int s : scores) {

	}					}










	
