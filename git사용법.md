# Git
## 설치하기
1. [Git 홈페이지](http://www.git-scm.com) 에서 git 설치파일 다운받기
2. 프로그램 설치하기
2. Git 초기 설정하기
 ```
 git config --global user.name "사용자명"
 git config --global user.email "사용자이메일"
 ```

Git의 역할
	파일의 버전 관리(파일의 변경이력을 관리)
	브랜치를 이용하면 완전히 구분되는 별도의 소스 작업영역을 만든다.
	파일 변경이력정보가 사용자의 컴퓨터에 저장된다.(로컬저장소에 저장된다.)
	github와 같은 원격저장소를 활용하면 다른 개발자와 소스공유가 가능하다.

Git의 주요 명령어
	git init
		로컬 저장소 생성
	git status
		현재 작업 디렉토리의 상태를 확인
	git add *
	git add 파일명
	git add 디렉토리명
		지정된 파일 혹은 디렉토리를 stage영역으로 이전 시킨다.
	git commit -m "메세지"
		stage영역에 있는 모든 파일을 로컬저장소에 저장한다.
	git remote add origin 원격저장소주소
		원격저장소를 origin이라는 이름으로 등록한다.
	git push origin master
		원격저장소 origin에 로컬저장소의 master 브랜치의 커밋된 내용을 전송한다.
	git pull origin master
		원격저장소 origin에 저장된 최종버전의 소스를 로컬저장소의 master 브랜치와 병합한다.
	git log -n 숫자
		소스 변경이력을 지정된 숫자만큼 보여준다.


Git으로 작업하기
	git init
		저장소 생성
	.gitignore 파일 생성
		www.gitignore.io에서 내용을 가져온다.
	github에 저장소 생성
	git remote add origin https://github.com/아이디/저장소명.git	
		github 저장소와 연결
	

	소스를 코딩하거나, 수정한다.
		git add *
			소스를 stage영역으로 상태를 이전
		git commit -m "버전이력에 관련된 메세지를 작성한다."
			소스를 로컬저장소에 저장한다
		git push origin master
			소스를 원격저장소에 저장한다.

집에서 소스 받기
	git clone https://github.com/eungsu/oop2.git
		원격저장소를 복제한 로컬 저장소가 내 컴퓨터에 생성된다.

	git pull origin master
		원격저장소의 최신 버전 소스를 로컬저장소와 병합시킨다.



