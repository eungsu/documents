# git과 github로 프로젝트 협업하기

## 원격 저장소 생성하기
1. github에 접속해서 새 원격저장소를 생성한다.
2. github에서 생성된 원격저장소 연결방법을 파악한다.
```
# 윈도우 커맨드 창에서 수행할 작업이다.
git branch -M main
git remote add origin https://github.com/eungsu/smart-office.git
git push -u origin main
```
## spring 프로젝트 생성하기
- Spring Starter project 메뉴를 이용해서 spring-boot 프로젝트를 생성한다.

## git 로컬 저장소 생성하기 브렌치명 변경하기
- CMD 창에서 메인 브랜치이름을 변경하고, 원격저장소와 연결하고, 원격저장소에 프로젝트를 push한다.
```cmd
# 프로젝트 폴더로 이동하기
C:\Users\lee> cd \
C:\> cd app\eGovFrameDev-4.0.0-64bit\workspace\smart-office

# git 로컬 저장소를 생성하기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git init

# 메인 브렌치의 이름을 master에서 main으로 변경하기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git branch -M main
```

## 커밋하기
```cmd
# 커밋대상 파일을 전부 스테이징 영역에 추가하기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git add *

# 스테이징 영역에 추가된 파일을 원격저장소에 저장시키기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git commit -m "create project"
```

## 원격저장소 추가하고 push 하기
```cmd
# 원격저장소(https://github.com/eungsu/smart-office.git)와 추가하고, 원격저장소의 이름을 origin 으로 지정하기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git remote add origin https://github.com/eungsu/smart-office.git

# 로컬저장소의 내용을 원격저장소로 보내기
C:\app\eGovFrameDev-4.0.0-64bit\workspace\smart-office> git push -u origin main
```
