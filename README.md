
---
## 목차
- 프로젝트 개요
- 팀원 소개
- 기술 스택
- 프로젝트 소개
- 트러블 슈팅
- 개발 일정
- 예시 화면
- 업데이트 예정

## 프로젝트 개요

## 팀원 소개
|팀원|담당|깃허브|
|:---:|---|---|
|김은지(팀장)|BACK|https://github.com/eeungji|
|박진우|BACK|https://github.com/JinWooP98|
|김한솔|BACK|https://github.com/hansolkim9|
|임제훈|BACK|https://github.com/jehoonje|
|신윤종|BACK|https://github.com/Maybaba|

## 기술 스택
JAVA - INTELLI J
## 프로젝트 소개

## 트러블 슈팅
### * 적금, 예금, 입출금 계좌개설 및 입금 - 임제훈
  1. input값 공백받을 시 뜨는 오류  
    ➟  trim().replace()를 활용해 입력된 공백을 삭제 
  2. Thread 딜레이 시간에 과도한 입력시 오류  
    ➟  try/catch 문을 활용하여 메세지 출력 
  3. 입출금 계좌를 생성하였으나 적금계좌 생성이 안됨 
    ➟  부모요소 필드에 static으로 되있는 속성과 생성자를 수정 
  4. 입금 금액을 int로 받아서 뜨는 오류  ➟  long으로 바꾸어 입력범위를 넓혀줌

### * 회원가입,로그인,마이페이지,아이디&비밀번호 찾기 - 박진우
  1. 로그인이나 회원가입시 조건에 맞지 않는 값을 입력했을 때 잘못 입력한 부분이 아닌 처음으로 돌아가는 현상
   
     ➟ 입력받고 검증하는 부분에 while문을 만들어 조건이 맞을 경우만 빠져나가게 함
  
  2. 1번 문제를 해결하기 위해 각 입력 검증마다 while문을 만들어 중간에 그만두고 싶을 때 break를 하여도 로그인, 회원가입 메서드가 종료되지 않는 현상
   
     ➟ 가장 바깥 while문에 라벨을 붙여 그 while문을 종료시킴
   
## 개발 일정
- 2024.04.24 ~ 2024.05.07
  
## 예시 화면

## 업데이트 예정
1. 주식 시스템
   - 입출금 통장을 통해 주식 구매, 판매
   - 하루가 지날때 마다 주식 종목의 가격 랜덤 변동

2. 환전 시스템
   - 입출금 통장을 통해 환전
   - 매일 각 나라의 환률을 가져와 환류에 맞게 환전
  
3. 예적금 상품
   - 보다 다양한 상품을 만들어 사용자 선택의 폭을 넓히기
   - 계좌가 해지되었을 때 다시 개설이 가능하도록 구현
  
4. 로그인 시스템
  - 회원가입시 입력받을 정보들의 조건을 강화
  - 비밀번호 변경 시 이전에 사용하던 비밀번호 사용 막기
