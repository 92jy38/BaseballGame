README
# BaseballGame Project


## 소개
프로젝트 기간 : 24.09.12 ~ 24.09.23<br>

- **목표** : 컴퓨터가 생성한 3~5자리 숫자를 플레이어가 맞추는 게임 제작
- **숫자에 대한 요구사항**
    - 각 자리는 1-9 사이의 숫자
    - 동일한 숫자는 사용될 수 없다. 즉, 숫자는 중복되지 않아야 한다.
    - ex) 333, 112, 119 불가능
- **게임 결과**
    - 각 시도에 대해 '스트라이크'와 '볼'의 개수를 출력하여 플레이어가 숫자를 맞출 수 있도록 유도한다.
      
예시<br>
![기능 시연 이미지](https://github.com/user-attachments/assets/e678f25b-9abc-45c7-8a02-187f5d261ab8)


<br>

## Tools
<img src="https://img.shields.io/badge/intellijidea-207BEA?style=for-the-badge&logo=intellij%20idea&logoColor=white"> SDK : Eclipse Temurin 17.0.12 <br> 
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><br>
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><br>
<img src="https://img.shields.io/badge/notion-000000?style=or-the-badge&logo=notion&logoColor=white"/><img src="https://img.shields.io/badge/Slack-FE5196?style=or-the-badge&logo=slack&logoColor=white"/>
<br>

<hr/>

## 패키지와 클래스별 기능
### `Application` : 모든 클래스 통합 호출<br>
>#### baseball.game : 게임 로직과 UI를 처리하는 패키지<br>
##### `GameManager` : 게임 전반의 흐름을 관리<br>
##### `GameConsole` : 콘솔 출력을 담당<br>
##### `GameRecords` : 게임 기록 관리<br><br>
>#### baseball.util : 유틸리티 관련 패키지<br>
##### `NumberUtil` : 숫자 처리<br>
##### `InputValidator` : 입력 검증<br><br>
>#### baseball.answer : 정답 관련 패키지<br>
##### `AnswerGenerator` : 답을 생성<br>
##### `AnswerChecker` : 입력값과 답을 비교<br><br>

### 예외처리 시연 이미지

![예외처리 시연 이미지](https://github.com/user-attachments/assets/e1f5ecd4-d38a-449e-8bbc-4b6ae7a74655)

