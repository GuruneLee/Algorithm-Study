# JAVA
## IO�� ���� ����
Java�� IO�� ũ�� Scanner�� BufferedReader�� �ִ�
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
// ���...
sc.close();  
~~~  
  
**next()�� nextLine()�� ����**
ex) Scanner s = new Scanner("\n\n\n������\n\n��\n\n");  
~~~
//1. next(): ù �ܾ� ���� �����̳� ���๮�ڴ� ����. �ϳ��� �ܾ �Է¹ް�, **�ܾ� ���� ���๮�ڴ� �״�� ����**  
while(s.hasNext()) {
	str = s.next();
	System.out.println(str);
}
~~~
���:  
������
��    
~~~
//2. nextLine(): **\n������ �� �ٷ� �ν��ϰ� �Է�**�� �ް�, \n�� ��������. 
while(s.hasNext()) {
	str = s.nextLine();
	System.out.println(str);
}
~~~
���:  
\n  
\n  
\n  
������  
\n  
��      


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

    // �Է�
    String line = br.readLine();

    // ���
    bw.write(line);
    bw.flush();
    bw.close();
} catch (IOException e) {
    e.printStackTrace();
}  
~~~   
  
`InputStreamReader`�� �Է��� character�� �о����.  
`BufferedReader`�� InputStreasmReader�� ���۸� ��� �߰��� ��. ���ۿ� �����ߴٰ�, ����ڰ� ���Ҷ�, �о���� �Ѵ�.  
BufferedReader�� throws Exception�� ������ ��� ���� ���� ��밡���ϱ� ������, Scanner���� ���� �ξ� ���� ������, **�ӵ��� �ξ� ������**  
  
### BufferedReader�� �̿��� �Է� �ޱ� ����
���� ���  
|6  
|4 2 6 3 1 5  
�̷����� �Է��� BufferedReader�� �ޱ� ���ؼ�
~~~
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int N = Integer.parseInt(br.readLine());
StringTokenizer st = new StringTokenizer(br.readLine()," ");
	for (int i = 0; i < N; i++) {
		p[i] = Integer.parseInt(st.nextToken());
}
~~~   
�̷��� `StringTokenizer`�� �̿��ϸ� �� + `nextToken()`  
(��, br.readLine�� ������ string������ ��)  

### BufferedWriter�� �̿��� ��� ����
�⺻���� ������  
| bw�� ��� -> ���  ������.  
bw���� �ƽ�Ű�ڵ尡 ���� ������, ������ �ƴ϶� char[]�� string���� �־���� ����� ���´�  
~~~
bw.write(String.valueof(n)); //valueof ���
bw.write(Integer.toString(c)); //toString ���
  
bw.flush(); //���
~~~


## �ڷᱸ��
https://joooootopia.tistory.com/13  .

## ���� ������/��Ÿ�� ���� ����
1. Ŭ������ ������ 'Main'  
2. ����� ������ �� ���� -> BufferedReader�� BufferedWriter�� �� ���� ����  
3. ��Ű�� �̸� �����ϱ�  

## next permutation(���� ����) ���� �����ϱ�
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

## java�� ������ primitive / reference �ΰ���
- primitive: boolean , byte , char , short , int , long , float double  
- reference: �� �� ���� (class ����)  
�Ű������� �ѱ涧 call-by-value���� ref������ ������ ������ ����.   