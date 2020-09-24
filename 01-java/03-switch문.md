# switch 문
- switch문은 단 하나의 조건식으로 많은 경우의 수를 처리할 수 있다.
- 처리할 경우의 수가 많은 경우 if문 보다 switch문을 사용하는 것이 유리하다.
- switch문의 형식
  ```java
  switch (조건식) {
    case 값1 :
      조건식의 연산결과가 값1과 일치하는 경우 실행될 수행문;
      break;
    case 값2 :
      조건식의 연산결과가 값2과 일치하는 경우 실행될 수행문;
      break;
    case 값3 :
      조건식의 연산결과가 값2과 일치하는 경우 실행될 수행문;
      break;
    default :
      조건식의 연산결과와 일치하는 case문이 없을 때 실행될 수행문
  }
  ```
- switch문의 제약조건
  + 조건식의 결과는 반드시 정수 또는 문자열이어야 한다.
  + case문의 값은 정수, 문자, 문자열만 가능하며, 중복되지 않아야 한다.
  + case문에 break가 없으면 일치하는 case문과 그 다음에 정의된 모든 case문 및 default문이 실행된다.
  + default문은 생략가능하다.
 
 - 실행예제
 ```java
  // 고객의 등급에 따른 적립포인트 계산하기
  // 고객의 등급이 1등급이면 구매금액의 10%를 포인트로 적립한다.
  // 고객의 등급이 2등급이면 구매금액의 5%를 포인트로 적립한다.
  // 고객의 등급이 3등급이면 구매금액의 3%를 포인트로 적립한다.
  // 그 외 등급이면 구매금액의 1%를 포인트로 적립한다.
  int userGrade = 1;
  int totalPrice = 100000;
  
  switch(userGrade) {
    case 1:
      int point = (int) (totalPrice*0.1);
      System.out.println("포인트: " + point);
      break;
    case 2:
      int point = (int) (totalPrice*0.05);
      System.out.println("포인트: " + point);
      break;
    case 3:
      int point = (int) (totalPrice*0.03);
      System.out.println("포인트: " + point);
      break;
    default:
      int point = (int) (totalPrice*0.01);
      System.out.println("포인트: " + point);
  }
 ```
