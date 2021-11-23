자바스크립트의 객체, 배열, 함수
	- 객체
		* 자바스크립에서는 기본자료형과 객체가 있다.
		* 기본자료형
			- string, number, boolean, null, undefined
			- 프로퍼티와 메소드를 갖지 못한다.
		* 객체
			- 기본자료형의 제외한 거의 모든 것들이 객체다.
			- 프로퍼티와 메소드를 가질 수 있다.
			  * 함수와 메소드의 차이는?
			  	메소드는 함수의 한 종류다.
				함수가 특정 객체에 소속되어 있을 때 메소드라고 부른다.
			- 배열, 함수, 정규표현식, 날짜 등이 전부 객체다.
			- string, number, boolean은 객체가 될 수 있다.
                          * new 키워드를 사용하면 객체 생성이 가능하다.
			- 객체는 맵과 유사하다.
			  * key:value의 쌍으로 프로퍼티나 메소드를 담고 있다.
			  * key는 문자열, value는 기본자료형, 배열, 객체, 함수 모두 가능
			  * 언제든지 객체의 프로퍼티, 메소드를 추가/삭제/변경이 가능하다.
			- 객체 생성하기
			  * 객체 리터럴 사용
				var obj = {}	// 빈 객체가 생성된다.
				var obj = {name:"홍길동", age:48, display:function() { ... } }
			  * Object 생성자 사용
				var obj = new Object();
				obj.name = "홍길동";
				obj.age = 48;
				obj.display = function() { .... }
			  * 생성자 함수 사용
				// 1. 생성자 함수 정의하기, 생성자함수이름은 대문자로 시작하는 것이 관례다.
				function Person(name, kor, eng, math) {
					this.name = name;
					this.kor = kor;
					this.eng = eng;
					this.math = math;
					this.getTotal = function() {
						return this.kor + this.eng + this.math;
					}
				}
				// 2. new 키워드와 함께 생성자 함수 호출
				//    - 빈 객체가 생성됨
				//    - 빈 객체가 생성자함수의 this에 전달됨
				//    - 생성자 함수의 수행문이 실행되면서 전달받은 객체(this)에 프로퍼티와 메소드가 추가됨
				//    - 생성자 함수의 실행이 완료되면 전달받은 객체가 반환된다.
				var obj = new Person("홍길동", 100, 100, 80);
				 
			* Prototope 객체	
				* 자바스크립트는 함수가 정의될 때 Function객체와 Prototype객체가 같이 생성된다.
				* Function객체에는 Prototype 객체를 참조하는 prototype 프로퍼티가 있다.
				* 생성자함수를 new와 함께 실행하면 객체가 생성되고, 
                                  그 객체는 __proto__ 프로퍼티를 사용해서 Prototype객체를 참조한다.
				* Prototype객체에 프로퍼티나 메소드를 추가하면 __proto__를 해당 Prototype객체를
				  참조하고 있던 모든 객체들은 해당 프로퍼티나 기능을 즉시 사용할 수 있다.
				* 따라서, 자바스크립트 객체는 프로토타입 객체로부터 프로퍼티나 메소드를 상속받을 수 있다.
				
				// 1. 생성자 함수 정의하기
				function Person(name, kor, eng, math) {
					this.name = name;
					this.kor = kor;
					this.eng = eng;
					this.math = math;
				}
				// 2. Prototye타입객체에 프로퍼티나 메소드 추가하기
				Person.prototype.getTotal = function() {
					return this.kor + this.eng + this.math;
				}
				Person.prototype.getAverage = function {
					return Math.trunc(this.getTotal)/3);
				}
				// 3. 생성자 함수를 사용해서 객체 생성하고, 메소드 사용하기
				var person1 = new Person("홍길동", 100, 100, 100);	
				var 총점 = person1.getTotal();
	
	- 함수
		* 자바스크립트의 함수는 1급 시민이다.
		  (변수에 저장할 수 있다. 매개변수로 전달할 수 있다. 반환값으로 사용할 수 있다)
		* 변수에 저장하기
			function fn() { ... }
			var x = fn;		// fn함수를 변수 x에 저장
			x();			// x에 저장된 함수를 실행
			
			var y = function() { ... }	// 이름이 없는 익명함수를 y에 저장
			y();			
		* 매개변수로 전달하기
			function attack(f) {	// f는 함수를 전달받는다.
				f();		// f로 전달받은 함수를 실행한다. 
			}

			function 찌르기() { ... }
			function 총쏘기() { ... }
			var 미사일쏘기 = function() { ... }			

			attack(찌르기);		// 찌르기함수를 전달한다.
			attack(총쏘기);		// 총쏘기함수를 전달한다.
			attack(미사일쏘기);
			attack(function() { ... })	// 익명함수를 직접 전달한다.
		* 반환값으로 제공할 수 있다.
			function getFn(condition) {
				var x = function() { +++ };
				var y = function() { *** };

				if (condition == 1) {
					return x;
				} else {
					return y;
				}
			}
			
			var f1 = getFn(1);	// f1에는 function() { +++ }가 제공된다.
			var f2 = getFn(2);	// f2에는 function() { *** }가 제공된다.
			f1();	// +++ 처리 실행
			f2();	// *** 처리 실행
		
		* 콜백함수
			- 다른 함수의 인자로 이용되는 함수
			- 특정 이벤트에 의해 호출되어지는 함수
			* 특정 상황이 발생할 때 브라우저, 가상머신, 시스템 혹은 운영체제가
                          실행시키는 함수
	- 배열
		* 자바스크립트의 배열의 Java의 ArrayList와 같은 가변길이 배열이다.	
			- 크기를 변경할 수 있다.	
			- 추가하거나 삭제하면 배열의 길이가 자동으로 조정된다.
		* 배열 생성하기
			- 배열 리터럴로 생성하기
				var x = [];	// 빈 배열이 생성된다.
				var x = ["김유신", "홍길동", "강감찬"];
			- 생성자함수로 생성하기
				var x = new Array();
				var x = new Array("김유신", "홍길동", "강감찬");
		* 주요 API
			- Property
				* length
					- 배열의 길이를 반환한다.
			- Method
				* push(item)
					- 배열의 끝에 새로운 요소를 추가한다.
				* pop()
					- 배열의 맨 마지막 요소를 삭제하고, 반환한다.
				* unshift(item)
					- 배열의 맨 앞에 새로운 요소를 추가한다.
				* shift()
					- 배열의 첫번째 요소를 삭제하고, 반환한다.
				* splice(index, howmany, item1, item2, item3, ..., itemN)
					- 배열의 요소를 삭제하고, 새로운 요소를 추가할 수 있다.
					* index - 추가하거나 삭제할 위치를 지정한다.
					* howmany - 삭제할 갯수, 0이면 삭제하지 않음
					* item1, ..., itemN - 새로 추가할 값들
					* 사용예)
						x.splice(1, 1) <--- 1번째부터 1개 삭제
						x.splice(1, 2) <--- 1번째부터 2개 삭제
						x.splice(1, 0, value) <--- 1번째에 값 추가, 원래 1번째에 있던 값을 뒤로 밀린다.
						x.splice(1, 1, value) <--- 1번째부터 값을 하나 삭제하고, 1번째에 값을 추가
				* join(separator)
					- 배열의 각 요소를 지정된 문자로 연결된 문자열을 반환한다.
					* separator를 지정하지 않으면 ,가 구분문자가 된다.
				* indexOf(item)
					- 배열에서 item과 같은 값이 있으면 해당 index를 반환한다.
					* 값이 발견되지 않으면 -1를 반환한다.
				* forEach(callback)
					- 배열의 각 요소마다 callback함수를 실행한다.
					- function(item, index)
						* item - 현재값
						* index - 현재값의 인덱스
				* filter(callback)
					- 배열의 각 요소마다 callback함수가 실행되고, 
                                          callback함수의 테스트를 통과한 아이템들로 구성된 새로운 배열이 반환된다.
					- 배열에서 원하는 요소들로만 구성된 새로운 배열을 만들 수 있다.
					- function(item, index)
						* item - 현재값
						* index - 현재값의 인덱스
						* 반환값 - 참 혹은 거짓
				* map(callback)
					- 배열의 각 요소마다 callback함수가 실행되고,
					  callback함수의 실행결과 변형된 아이템들로 구성된 새로운 배열이 반환된다.
					- 배열의 각 요소를 다른 형태로 변환해서 새로운 배열을 만들 수 있다.
					- function(item, index)
						* item - 현재값
						* index - 현재값의 인덱스
						* 반환값 - 변형된 값
				* reduce(callback, initValue)
					- 배열의 각 요소마다 callback함수가 실행되고
					  최종결과로 단 하나의 값이 반환된다.
					- 배열의 각 요소에 대한 집계결과를 하나 반환한다.
					- function(total, item, index)
						* total - initValue를 지정하지 않으면 이전에 실행한 함수의 반환값이 들어간다..
							  initValue를 지정하면 해당값이 total의 초기값이 된다.	
						* item - 현재값
						* index - 현재값의 인덱스
						* return - 집계단계의 중간값
				* sort(callback)
					- 배열의 각 요소마다 callback함수가 실행되고
					  callback함수는 각각의 값들을 비교하는 코드가 포함되어야 한다.
					  callback함수는 양수, 음수, 0를 반환해야 한다.
					- 배열의 각 요소를 정렬한다.
					- 원본 배열이 정렬된다.
					- function(a, b)
						* a - 배열의 값
						* b - 배열의 값
						* return - a와b를 비교연산한 결과
							   정수값(양수, 음수, 0)
					





















				
				
				













