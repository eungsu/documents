# 반복문
- 반복문은 특정한 수행문을 반복해서 실행하는 구문이다.
- 반복문은 제시된 조건이 true인 경우 블록내의 수행문을 반복 실행한다.
- for, while, do ~ while 구문을 사용한다.
- 반복횟수를 알고 있을 때는 for문, 그렇지 않은 경우는 while문을 사용한다.

## for문
- for문은 **초기화**, **조건식**, **증감식**, **코드블록** 으로 구성되어 있다.
```java
  for (초기화; 조건식; 증감식) {
    조건식이 true인 동안 수행할 수행문;
    조건식이 true인 동안 수행할 수행문;
    조건식이 true인 동안 수행할 수행문;
  }
```
- for문의 실행 순서

![Alt for문의 실행흐름](/01-java/for.PNG)

- for문 사용예제
  + 수행문을 3번 실행하기
  ```java
    for (int i=1; i<=3; i++) {
      System.out.println("Hello");
    }
   ```
   ```
   출력결과
   Hello
   Hello
   Hello
  ```
  + 반복문 블록안에서 i값 사용하기
  ```java
    for (int i=1; i<=5; i++) {
      System.out.println("i의 값: " + i);
    }
  ```
   ```
   출력결과
   i의 값: 1
   i의 값: 2
   i의 값: 3
   i의 값: 4
   i의 값: 5
  ```
  + 반복문을 사용하지 않고, 1 ~ 5까지의 합계 구하기
  ```java
    int total = 0;
    total += 1;
    total += 2;
    total += 3;
    total += 4;
    total += 5;
    total += 6;
    total += 7;
    total += 8;
    total += 9;
    total += 10;
    System.out.println("합계: " + total);
  ```

  + 반복문을 사용해서 1 ~ 10까지의 합계 구하기
  ```java
    int total = 0;
    for (int i=1; i<=10; i++) {
      total += i;
    }
    System.out.println("합계: " + total);
  ```

- for문 안에서 조건문 사용하기
  + 1부터 10까지 짝수의 합계를 구하기
  ```java
    int total = 0;
    for (int num=0; num<=10; num++) {
      if (num%2 == 0) {
        total += num;
      }
    }
    System.out.println("짝수의 합계: " + total);
  ```
  + 1부터 10까지 숫자들에 대한 짝수와 홀수의 합계를 구하기
   ```java
    int evenTotal = 0;
    int oddTotal = 0;
    for (int num=0; num<=10; num++) {
      if (num%2 == 0) {
        evenTotal += num;
      } else {
        oddTotal += num;
      }
    }
    System.out.println("짝수의 합계: " + evenTotal);
    System.out.println("홀수의 합계: " + oddTotal);
  ```
