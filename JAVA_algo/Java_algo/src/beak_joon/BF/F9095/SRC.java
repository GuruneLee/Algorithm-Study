package beak_joon.BF.F9095;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
//import java.util.*;

public class SRC {

	//List<Integer> l = new Vector<Integer>();
	//�����׸����� ������ �� �ִ� Ÿ���� ��ü Ÿ���Դϴ�. int�� �⺻�ڷ����̱� ������ �� �� �����Ƿ� int�� ��üȭ��Ų wrapperŬ������ ����ؾ� �մϴ�.
		
	public static void main(String[] args) throws IOException {
		//InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		int T;
		int[] d = new int[11]; //�ڷ���[] ���� = new �ڷ���[�迭ũ��];
		//T = sr.read();
		T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			//n = sr.read();
			n = Integer.parseInt(br.readLine());
			d[0] = 1;
			d[1] = 1;
			d[2] = 2;
			for (int i=3; i<=n; i++) {
				//d[i]�� ä��ſ���
				d[i] = d[i-1] + d[i-2] + d[i-3];
			}
			//System.out.println(d[n]);
			bw.write(String.valueOf(d[n]));
			bw.write('\n');
			bw.flush();
		}
	}
}
