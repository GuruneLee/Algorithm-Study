# 카잉 달력
https://www.acmicpc.net/problem/6064

## Solution
달력일 <x;y>에서 x와 y사이의 관계식 구하기:  
'h번째 x옆에는 어떤 y가 있을까?'  
h번째 x는 `M*(h-1)+x`번째 날짜. 이 옆에는 `(M*(h-1)+x)%N`이 있어야 함  
  
근데 (M*(h-1)+x)%N == 0 이면 0이아니라 N을 반환하도록 하여야 함  
  
## Trouble Shooting
1. 진짜 하란다고 해본 Brute Force:
생각해보니 다 세려면 O(M\*N)인데, 그러면 최악의 경우 40000\*40000 즉, 8\*10^8초가 걸리게 됨. 1초는 가뿐히 넘을듯 ㅋ  
  
2. 맞는 풀인데 왜 틀렸지?:
- M,N달력의 최대 표현가능 날짜는 M\*N이 아니라 LCM(M,N)임. 따라서, x측의 h범위는 **1 ~ LCM(M,N)/M**이다.  
- (M*(h-1)+x)%N == 0 이면 0이아니라 N을 반환하도록 하여야 함. 코드를 확인해보도록 하자. tmp를 이용한 구현  

