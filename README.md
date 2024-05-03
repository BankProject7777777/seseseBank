<h1></h1>
<div align ="center"><br>
  
# ### SeSeSe Bank ### ###
<br></div>

<div align ="right"><b>7조 김은지 임제훈 김한솔 박진우 신윤종</b></div>


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
기존의 은행 서비스에는 많은 기능들이 있지만 보다 많은 기능으로 복잡해진 시스템에 불편이 있는 사용자를 위해 간소화 되었으며 사용자의 가입을 받고
은행의 주된 기능인 예적금, 입출금 계좌개설 기능을 보다 효율적이고 정확한 전달을 할 수있는 시스템을 만드는 것을 목표로 진행되었습니다.<br>


## 팀원 소개
|팀원|담당|깃허브|
|:---:|---|---|
|김은지(팀장)|BACK|https://github.com/eeungji|
|박진우|BACK|https://github.com/JinWooP98|
|김한솔|BACK|https://github.com/hansolkim9|
|임제훈|BACK|https://github.com/jehoonje|
|신윤종|BACK|https://github.com/Maybaba|

## 기술 스택
<div align ="center">
<img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/b584e417-3f78-45b6-8efb-417bd0d5fdb5" alt="java">
<img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/56a071ae-bc25-4adb-a204-d3df63184904" alt="git">
<img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fei6Ehe%2FbtrbQbiTB7X%2FPxE6GEx9XudbZ8A3kTRpj1%2Fimg.png" alt="git">

</div>

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
  1. 로그인이나 회원가입시 조건에 맞지 않는 값을 입력했을 때 잘못 입력한 부분이 아닌 처음으로 돌아가는 현상<br>
      ➟ 입력받고 검증하는 부분에 while문을 만들어 조건이 맞을 경우만 빠져나가게 함
  
  2. 1번 문제를 해결하기 위해 각 입력 검증마다 while문을 만들어 중간에 그만두고 싶을 때 break를 하여도 로그인, 회원가입 메서드가 종료되지 않는 현상<br>
      ➟ 가장 바깥 while문에 라벨을 붙여 그 while문을 종료시킴
     
### * 예적금 이자 및 추가납입 시스템, 다음날로 넘어감에 따른 이자 업데이트, 콘솔창 디자인 - 신윤종
  1. 반복문을 돌려서 계좌 타입을 얻는 로직을 반복해서 사용하지 않고 해당 로직의 클래스를 만들어 메서드로 계좌별 잔액 누적 및 불러오는데 누적이 안되는 문제<br>
     → 새로운 클래스에서 변수를 선언하고 그 값에 저장이 되기 때문에 반복문을 메서드 안에서 직접 실행하는 것과 클래스 메서드를 통해 얻는 값이 다름<br>
     → 해당 값을 불러오고, 저장하는 메서드를 따로 만들어서 이자가 쌓일 때마다 메서드를 실행해서 해결
     
  2. 다른 user로 로그인하면 이전에 로그인했던 user account balance 가 불러와지는 문제<br>
     → 이율을 계산하는 메서드 별 최신 금액 업데이트 메서드를 불러오지 않아서 잔액최신업데이트가 되지 않았음<br>
     → 업데이트하는 메서드를 이율 메서드에 추가함으로서 해결함

### * 입출금 기능, ppt 작성 - 김한솔
  → 없음




   
## 개발 일정
- 2024.04.25 ~ 2024.05.07


  
## 프로젝트 소개

<div align="center">
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/bd7948b2-1424-4a0e-a5fb-b7ba2fb29823" alt="예시 화면">
      <h2>사용자의 아이디를 생성할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/2e5cafda-0665-4b90-a041-020eb6114718" alt="로고인">
      <h2>로그인을 통해 메인메뉴로 접속합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/223fabe3-d228-41fb-919b-a5f63723675c" alt="아이디:비밀번호 창기">
      <h2>사용자가 아이디를 찾고 비밀번호를 찾아 변경할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/b4127ca6-2634-496d-8b7c-a1c08f4ee778" alt="계좌개설">
      <h2>입출금 계좌가 없을 시 입출금, 예적금계좌 생성이 제한됩니다.<br>사용자는 입출금계좌를 생성할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/8f117428-bde2-49b5-af16-2d55f8bd74df" alt="계좌개설2">
      <h2>사용자는 예금, 적금 상품에 가입할 수 있습니다..</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/f621eeed-eb7f-4dae-9df6-76098eff3aef" alt="예측금시스템1">
      <h2>사용자의 예금및 적금 현황을 확인할 수있습니다. 적금에는 추가입금이 가능합니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/14baa760-df25-4142-8c58-8de8ea473e20" alt="예측금시스템2">
      <h2>예적금의 유동사항을 구현하기 위해 날짜기능을 추가했습니다.<br>다음날로 넘어가면 이율이 붙는 것을 확인 할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/222de2fc-a728-443a-ae17-19b50497c996" alt="입출금시스템">
      <h2>사용자가 입출금 계좌에 돈을 입금하거나 출금 할 수 있습니다.</h2><br>
    <img src="https://github.com/BankProject7777777/seseseBank/assets/70048630/4fa1fe82-a845-4585-a3d8-d47993873f35" alt="마이페이지">
      <h2>해당 사용자가 소유한 모든 계좌의 상태를 확인합니다.</h2><br>
</div>



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

5. 예적금 시스템
   - 다양한 예적금 상품 개발
   - 계좌 (중도)해지 기능 개발
  
6. 입출금 시스템
   - 계좌 간 이체 기능 추가
   - 매월 특정 일자에 자동 이체 기능 추가

