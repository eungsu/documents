# 수강신청 프로그램 구현

## 주요 기능
- 학생전용 기능
  + 개설강의 조회
    * 학생이 소속된 학과에서 개설한 강의목록을 조회한다..
    * 입력값 
      - 학번
    * 처리내용
      - 학생테이블(SCHOOL_STUDENTS)에서 학번으로 학생정보를 조회한다.
      - 학생정보가 존재하지 않으면 StudentNotFoundException을 발생시킨다.
      - 학생정보에서 학과코드를 획득한다.
      - 개설강의정보테이블(SCHOOL_LECTURES)에서 학과코드로 개설강의를 조회한다.
      - 조회된 개설강의 목록을 출력한다.
  + 수강신청 기능
    * 학번과 개설과정번호를 입력받아서 수강신청등록 테이블에 저장한다.
    * 입력값
      - 개설강의번호, 학번
    * 처리내용
      - 학생테이블(SCHOOL_STUDENTS)에서 학번으로 학생정보를 조회한다.
      - 학생정보가 존재하지 않으면 StudentNotFoundException을 발생시킨다.
      - 수강신청등록 테이블(SCHOOL_LECTURES_REGISTRATIONS)에서 학번과 학과코드로 수강신청정보를 조회한다.
      - 수강신청정보가 존재하면 AlreadyRegistrationLectureException을 발생시킨다.
      - 개설강의정보테이블(SCHOOL_LECTURES)에서 개설강의번호로 개설강의정보를 조회한다.
      - 개설강의정보가 존재하지 않으면 LectureNotFoundException을 발생시킨다.
      - 개설강의정보에서 모집마감여부를 조회한다.
      - 모집마감여부가 'Y'인 경우 LectureFailureException을 발생시킨다. 
      - 수강신청등록 테이블(SCHOOL_LECTURES_REGISTRATIONS)에 수강신청등록번호, 학생번호, 강의번호를 저장한다.
      - 개설강의정보테이블(SCHOOL_LECTURES)의 신청자수를 1증가시킨다.
  + 수강신청내역 조회 기능
    * 학번을 입력받아서 수강신청등록 테이블에서 수강신청한 강의목록을 조회한다.
    * 입력값
      - 학번
    * 처리내용
      - 학생테이블(SCHOOL_STUDENTS)에서 학번으로 학생정보를 조회한다.
      - 학생정보가 존재하지 않으면 StudentNotFoundException을 발생시킨다.
      - 수강신청등록테이블(SCHOOL_LECTURES_REGISTRATIONS), 개설강의정보테이블(SCHOOL_LECTURES), 교수정보테이블(SCHOOL_PROFESSORS)을 조인하고 학번으로 학생이 수강신청등록한 개설강의정보를 조회한다.
      - 조회된 개설강의목록정보를 출력한다.
  + 성적정보 조회
    * 학번을 입력받아서 시험성적정보 테이블에서 성적을 조회한다.
    * 입력값
      - 학번
    * 처리내용
      - 학생테이블(SCHOOL_STUDENTS)에서 학번으로 학생정보를 조회한다.
      - 학생정보가 존재하지 않으면 StudentNotFoundException을 발생시킨다.
      - 시험정보테이블(SCHOOL_EXAMS)와 개설강의정보테이블(SCHOOL_LECTURES)을 조인하고 학번으로 성적정보를 조회한다.
      - 조회된 시험성적정보를 출력한다.
- 교수전용 기능
