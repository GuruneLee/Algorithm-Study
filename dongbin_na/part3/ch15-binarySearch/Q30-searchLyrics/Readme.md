# 가사검색
https://programmers.co.kr/learn/courses/30/lessons/60060

- 특정 키워드가 가사에 몇개 있는지 검색
- '?'포함된 문자열 -> 어떤 문자에도 매칭되는 와일드 카드
- 가사에 사용된 단어배열 `words`, 찾고싶은 키워드가 담긴 `queries`배열
- 각 키워드별로 매치된 단어의 개수를 배열에 담아 출력

- 제한사항
    - words.size() < 100,000
    - words[i] < 10,000
    - sum(words[i]) < 1,000,000
    - 오직 소문자 알파벳으로 구성
    - `?`개수는 상관 없으나, 각 키워드의 접두사/접미사로 주어짐
    
## Solution
1. words를 사전순으로 정렬, words.reverse의 사전순으로 정렬
2. upper, lower bound 찾기
    - ?가 접두사라면 words에서 탐색
    - ?가 접미사라면 words.revers에서 탐색
3. 각 키워드마다 upper-lower가 답임
