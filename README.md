# java-lotto-precourse

# 💬 우테코 프리코스 3주차 - 로또

**`간단한 로또 발매기를 구현한다.`**

---

## 📝 기능 요구 사항 정리

### 기능 요구 사항
- 로또 번호의 숫자 범위는 `1` 부터 `45`까지 이다.
- 로또 번호를 발행할 때, **중복되지 않는** `6`개의 숫자를 뽑는다.
- 당첨 번호 추첨시, **중복되지 않는** `6`개의 숫자와 보너스 번호 `1`개를 뽑는다.
- 당첨은 1등부터 5등까지 있으며, 당첨 기준과 금액은 아래와 같다.
  - 1등 : `6`개 번호 일치 /  `2,000,000,000원`
  - 2등 : `5`개 번호 일치 + 보너스 번호 일치 / `30,000,000원`
  - 3등 : `5`개 번호 일치 / `1,500,000원`
  - 4등 : `4`개 번호 일치 / `50,000원`
  - 5등 : `3`개 번호 일치 / `5,000원`
- 로또 1장의 가격은 `1,000원`이며, 구입 금액 만큼의 로또가 발행되어야 한다.

### 입출력 진행 시나리오 및 관련 요구 사항

- [x] 애플리케이션이 시작되면, **로또 구입 금액**을 **입력**받는다.
  - 입력은 `Console.readLine()`을 통해 입력받는다.
  - 구입 금액은 **`1000`원 단위**로 입력받으며, 올바른 입력이 아닐 경우 **예외 처리**한다.

- [ ] 발행한 **로또 수량** 및 각 로또의 **번호**를 **출력**한다. 
  - 로또 번호는 **오름차순으로 정렬**하여 보여준다.

- [ ] **당첨 번호**를 **입력**받는다.
  - 입력은 `Console.readLine()`을 통해 입력받는다.
  - 번호는 **쉼표`(,)`를 기준으로 구분**한다.

- [ ] **보너스 번호**를 **입력**받는다.
  - 입력은 `Console.readLine()`을 통해 입력받는다.

- [ ] **당첨 내역**을 **출력**한다.
  - 당첨 내역은 **5등부터 1등까지 순서대로 출력**하며, **당첨된 로또가 없더라도 출력**한다.
  - 당첨 기준에 따른 **일치해야 하는 번호 갯수, 당첨 금액**, 그리고 **당첨된 로또의 갯수**를 출력한다.

- [ ] **수익률**을 **출력**한다.
  - 수익률은 **소수점 둘째 자리에서 반올림**한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

- [ ] 사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러메세지를 출력 후,
**그 부분부터 입력을 다시 받는다**.
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException`등과 같은 명확한 유형을 처리한다.

---

## ✏️ 구현할 기능 목록

### 1. 손님이 로또 구매를 위해 금액을 지불한다.
- [x] 구매 금액 입력
  - [x] `구입 금액을 입력해 주세요.`라는 문구를 출력
  - [x] 구입 금액을 `Console.readLine()`메서드를 활용하여 입력받음
- [x] 구매 금액 입력 유효성 검사
  - [x] 입력된 구입 금액이 `1,000원` 단위의 정상 입력인지 검사
  - [x] 입력이 올바르지 않다면, 구매 금액 입력부터 다시 과정을 시작

### 2. 상점은 받은 구매 금액 만큼의 로또를 발급한다.
- [x] 로또 번호 발급
  - [x] 발급하기로 한 하나의 로또 당 **중복되지 않는** 6개의 숫자 발급
  - [x] 로또의 랜덤 번호는 `Randoms.pickUniqueNumbersInRange()`를 활용하여 발급
  - [x] 6개의 숫자를 가지고 로또 객체의 생성을 요청
- [x] 로또 객체 생성 및 저장
  - [x] 발급된 6개의 숫자를 기반으로, `Lotto` 객체를 생성
  - [x] 생성된 객체들을 `Repository`에 저장

### 3. 손님은 본인이 수령한 로또의 번호를 확인한다.
- [ ] 구입 로또 번호 출력
  - [ ] 구입한 로또의 갯수를 기반으로 `N개를 구매했습니다.`라는 문구를 출력
  - [ ] 각 로또의 번호들을 오름차순으로 출력

### 4. 상점에서 이번 주 당첨 번호를 설정한다.
- [ ] 당첨 번호 입력
    - [ ] `당첨 번호를 입력해 주세요`라는 문구를 출력
    - [ ] 당첨 번호를 `Console.readLine()`메서드를 활용하여 입력받음
- [ ] 당첨 번호 입력 유효성 검사
    - [ ] 입력된 당첨 번호가 쉼표`(",")`로 구분된 `6`개의 숫자인지 검사
    - [ ] 각 숫자가 `1`부터 `45` 사이의 숫자인지 검사
    - [ ] 각 숫자가 중복되지 않는지 검사
    - [ ] 입력이 올바르지 않다면, 당첨 번호 입력부터 다시 과정을 시작

### 5. 상점에서 이번 주 보너스 번호를 설정한다.
- [ ] 보너스 번호 입력
    - [ ] `보너스 번호를 입력해 주세요`라는 문구를출력
    - [ ] 보너스 번호를 `Console.readLine()`메서드를 활용하여 입력받음
- [ ] 보너스 번호 입력 유효성 검사
    - [ ] 입력된 보너스 번호가 `1`부터 `45`사이의 숫자인지 검사
    - [ ] 입력된 보너스 번호가 사전에 입력된 당첨 번호와 중복되지 않는지 검사
    - [ ] 입력이 올바르지 않다면, 보너스 번호 입력부터 다시 과정을 시작

### 6. 손님은 로또의 당첨 여부의 조회를 상점에게 요청한다.
- [ ] 당첨 통계 출력
  - `당첨 통계` 와 `---` 라는 문구를 시작으로 통계 출력을 시작한다
  - 5등부터 1등까지 일치해야 하는 갯수, 상금, 당첨된 갯수를 출력한다.

### 7. 손님은 본인의 수익률을 계산한다.
- [ ] 수익률 계산
  - [ ] 손님은 당첨된 로또들을 기반으로 수익률의 계산을 한다.
    - [ ] 수익률을 계산하는 방식은 (당첨 금액 - 구매 금액) / 100 으로 계산한다.
    - [ ] 수익률은 소수점 둘째자리에서 반올림한다.
    - [ ] `총 수익률은 N%입니다`와 같이 출력한다.

---

## 😈 예외 사항
사용자가 잘못된 값을 입력할 경우, `IllegalArgumentException`을 발생시키고, `[ERROR]`로 시작하는 에러메세지를 출력 후,
**그 부분부터 입력을 다시 받으며**, `Exception`이 아닌 **명확한 예외 유형**을 처리한다.

- `NumberFormatException`인 경우 (문자열을 숫자로 변환할 때 잘못된 입력일 경우)
  - [x] 구매 금액을 입력할 때, 숫자가 아닌 내용이 입력될 수 없다.
  - [ ] 당첨번호를 입력할 때, 숫자가 아닌 내용이 입력될 수 없다.
  - [ ] 보너스 번호를 입력할 때, 숫자가 아닌 내용이 입력될 수 없다.


- `IllegalArgumentException`인 경우 (메서드가 매개변수로 잘못된 값이 전달되었을 때 발생)
  - [x] 구매 금액의 단위는 `1,000`원 단위로 입력되어야 한다.(0도 허용하지 않는다)
  - [ ] 당첨 번호는 `1`과 `45`사이의 숫자가 입력되어야 한다.
  - [ ] 당첨 번호는 **중복을 허용하지 않는다**.
  - [ ] 당첨 번호를 구분하는 문자는 쉼표`(,)`여야 한다.
  - [ ] 당첨 번호는 총 `6`개의 번호가 입력되어야 한다.
  - [ ] 보너스 번호는 `1`과 `45`사이의 숫자가 입력되어야 한다.
  - [ ] 보너스 번호는 **당첨 번호와의 중복을 허용하지 않는다**.
  - [ ] 구매 금액, 당첨 번호, 보너스 번호는 공통적으로 아래의 사항을 허용하지 않는다.
    - [ ] 공백(whitespace) 혹은 무입력 `("")`은 입력될 수 없다.
    - [ ] 소수가 입력될 수 없다.
    - [ ] 0보다 작은 수(0 혹은 음수)가 입력될 수 없다.
    - [ ] `+`기호가 포함될 수 없다.
    - [ ] 앞 뒤 공백이 포함될 수 없다.

---

### ⁉️ 고려해야할 사항
- [ ] 1, 2주차 공통 피드백과 프로그래밍 요구사항을 준수한다.
- [ ] indent의 depth가 `3`을 넘지 않도록 구현한다.
- [ ] 메서드가 한 가지 일만 하도록 최대한 작게 구현한다.
- [ ] 클래스는 `상수, 멤버 변수, 생성자, 메서드` 순으로 작성한다.
- [ ] 메서드의 길이가 `15`라인을 넘지 않도록 구현한다.
- [ ] `else`예약어와 `switch/case`문을 사용하지 않는다.
- [ ] Java Enum을 적용하여 프로그램을 구현한다.
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다. (단, UI로직은 제외한다.)
- [ ] 제공된 `Lotto` 클래스를 사용하여 구현한다.
  - 인스턴스 변수의 추가는 허용하지 않는다.
  - `numbers`의 접근제어자인 `private`는 변경할 수 없다.
  - `Lotto`의 패키지 변경은 허용한다.

---

## 🖥️ 예시

```console
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
... (총 8개의 로또 출력)
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

## 🤔 구현 과정

### 생각 해보기(Before)

#1 이전에 사용했던 `BigInteger`를 활용하면 좋을지, 아니면 `Long`을 최대 범위로 지정하는 것이 좋을지
`ex) 입력에 대한 내용이 Long 범위를 넘어간다면 예외 처리`

#2 요구사항 중, `numbers`의 접근제어자가 `private`인 것의 의미에 대하여

#3 `IllegalStateException`이 발생하는 상황들에 대해

#4 예외를 발생시키는 역할의 enum 클래스를 별도로 작성하는 것에 대해

### 생각 해본 뒤(After)


### 마무리하며