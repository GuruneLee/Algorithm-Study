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

