# Java_Multi_Criteria_Array

2016 / second semester / java class project


자바 다기준 정렬

-----------------------------------------------------------------------------------

먼저 주어진 사전에서 정렬 규칙을 찾으십시오.
 
그리고, 그 정렬 규칙을 이용하여 파일을 정렬하세요.
 
정렬 기준은 이름과 type (cat, book)입니다.
 
이름은 영어 알파벳처럼 보이지만 정렬할 때에는 alphabet순서를 따르지 않습니다.
 
예를 들어 입력 받을 파일 형태는 다음과 같습니다.
 
첫 줄에는 다음과 같이 사용할 알파벳의 목록이 있습니다.

abc

그리고 다음과 같이 정렬된 목록이 나오죠

cat ab 3

cat ac 2

book cc Tom Chong

book ac Jerry Pong

목록이 끝났다는 건 End라는 문자열을 만나서입니다.
 
그럼 우리는 정렬 기준이 cat 다음에 book이고 alphabet사이에는 bca 순임을 알 수 있습니다.
 
그러므로

cat bb5

book ab Marry Chong

cat aa 2

는 

Cat bb5

Cat aa 2

Book ab Marry Chong

으로 정렬되야 함을 알 수 있죠.

-----------------------------------------------------------------------------------
