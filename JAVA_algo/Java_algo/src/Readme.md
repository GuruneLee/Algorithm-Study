# JAVA
## IO에 관한 지식
Java의 IO는 크게 Scanner와 BufferedReader가 있다
### Scanner
`import java.util.Scanner`    
ex)  
~~~  
Scanner sc = new Scanner(System.in);  
int integerNum = sc.nextInt();  
long longNum = sc.nextLong();  
double doubleNum = sc.nextDouble();  
String str = sc.next();  
String strWithSpace = sc.nextLine();  
// 등등...
sc.close();  
~~~  
  
**next()와 nextLine()의 차이**
ex) Scanner s = new Scanner("\n\n\n가나다\n\n라\n\n");  
~~~
//1. next(): 첫 단어 앞쪽 공백이나 개행문자는 무시. 하나의 단어를 입력받고, **단어 뒤의 개행문자는 그대로 놔둠**  
while(s.hasNext()) {
	str = s.next();
	System.out.println(str);
}
~~~
출력:  
가나다
라    
~~~
//2. nextLine(): **\n까지를 한 줄로 인식하고 입력**을 받고, \n은 버려진다. 
while(s.hasNext()) {
	str = s.nextLine();
	System.out.println(str);
}
~~~
출력:  
\n  
\n  
\n  
가나다  
\n  
라      


### BufferedReader
`import java.io.BufferedReader;`  
`import java.io.BufferedWriter;`  
`import java.io.IOException;`  
`import java.io.InputStreamReader;`  
`import java.io.OutputStreamWriter;`      
ex)  
~~~  
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);

OutputStreamWriter osw = new OutputStreamWriter(System.out);
BufferedWriter bw = new BufferedWriter(osw);

try {

    // 입력
    String line = br.readLine();

    // 출력
    bw.write(line);
    bw.flush();
    bw.close();
} catch (IOException e) {
    e.printStackTrace();
}  
~~~   
  
`InputStreamReader`는 입력을 character로 읽어들임.  
`BufferedReader`는 InputStreasmReader에 버퍼링 기능 추가한 것. 버퍼에 보관했다가, 사용자가 원할때, 읽어오게 한다.  
BufferedReader는 throws Exception을 선언해 줘야 에러 없이 사용가능하기 때문에, Scanner보다 손이 훨씬 많이 가지만, **속도가 훨씬 빠르다**  
  
### BufferedReader를 이용한 입력 받기 실전
예를 들어  
|6  
|4 2 6 3 1 5  
이런식의 입력을 BufferedReader로 받기 위해선
~~~
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
StringTokenizer st = new StringTokenizer(br.readLine()," ");
	for (int i = 0; i < N; i++) {
		p[i] = Integer.parseInt(st.nextToken());
}
~~~   
이렇게 `StringTokenizer`를 이용하면 됨 + `nextToken()`  
(아, br.readLine은 무조건 string리턴임 ㅋ)  

### BufferedWriter를 이용한 출력 실전
기본적인 순서는  
| bw에 담기 -> 출력  순서다.  
bw에는 아스키코드가 들어가기 때문에, 정수가 아니라 char[]와 string으로 넣어줘야 제대로 나온다  
~~~
bw.write(String.valueof(n)); //valueof 사용
bw.write(Integer.toString(c)); //toString 사용
  
bw.flush(); //출력
~~~


## 자료구조
https://joooootopia.tistory.com/13  .

## 백준 컴파일/런타임 에러 지점
1. 클래스는 무조건 'Main'  
2. 입출력 선언은 한 번에 -> BufferedReader와 BufferedWriter는 맨 위에 넣자  
3. 패키지 이름 제거하기  

## next permutation(다음 순열) 직접 구현하기
step1. Find largest index i s.t. list[i-1]<list[j]  
step2. Find largest index j s.t. j>=i and list[j] > list[i-1]  
step3. Swap list[j] and list[i-1]  
step4. Reverse the suffix starting at list[i]  
~~~
boolean nextPermutation(int[] arr) {
	total++;
	// step1
	int i=N-1;
	while( i>0 && arr[i-1] >= arr[i] ) --i; 
	if(i==0) return false;
	
	//step2
	int j = N-1;
	while(arr[i-1]>=arr[j]) --j;
	
	//step3
	int temp = input[i-1];
	input[i-1] = input[j];
	input[j] = temp;
	
	//step4
	int k = N-1;
	while(i<k) {
	    temp=input[i];
		input[i]=input[k];
		input[k]=temp;
		++i; --k;
	}
	return true;		
}
~~~

## java의 변수는 primitive / reference 두가지
- primitive: boolean , byte , char , short , int , long , float double  
- reference: 그 외 전부 (class 포함)  
매개변수로 넘길때 call-by-value인지 ref인지도 변수의 종류로 결정.   