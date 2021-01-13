package beak_joon.CodeTest.IUPC.Q11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class CXY implements Comparable<CXY>{
	public int cost;
	public int feed;
	public int x;
	public int y;
	public CXY(int cost, int feed, int x, int y) {
        this.cost = cost;
        this.feed = feed;//�������̰���
        this.x = x;
        this.y = y;
    }
	@Override
	public int compareTo(CXY o) {
		if(this.cost<o.cost)return -1;
        //cost ���ٸ�
        else if(this.cost==o.cost){
            if(this.feed<o.feed)return -1;//feed ������ �켱���� ����
            else return 1;
        }
        else return 1;
	}
}

public class Main {
	static int N;
	static int[] cost = new int[3];
	static int X,Y;
	static int M;
	static int[][] map;
	
	static int[] knightX = new int[]{-1,-2,-2,-1,1,2,2,1}; //knight
	static int[] knightY = new int[]{-2,-1,1,2,2,1,-1,-2}; //knight

	//static int[] B = new int[]{};
	//static int[] C = new int[]{};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost[0] = Integer.parseInt(st.nextToken());
		cost[1] = Integer.parseInt(st.nextToken());
		cost[2] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		map[X][Y] = -1; //���� ��ġ (������ �湮�� ���� -1�� check)
		
		M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpX = Integer.parseInt(st.nextToken());
			int tmpY = Integer.parseInt(st.nextToken());
			map[tmpX][tmpY] = 1; //���� ��ġ
		}
		
		
		
		//�� ���� - ���ͽ�Ʈ�� �˰���
		// map�� �湮�ߴٰ� check�� �ؾߵ�????????????
		PriorityQueue<CXY> q = new PriorityQueue<>();
		q.add(new CXY(0,M,X,Y));
		while (!q.isEmpty()) {
			int cc = q.peek().cost;
			int cx = q.peek().x;
			int cy = q.peek().y;
			int cf = q.peek().feed;
			q.remove();
			
			if (M == 0) { //���̸� �� �Ծ�����
				System.out.println(cc);
				break;
			}
			
			int nx = cx;
			int ny = cy;
			int nc = cc;
			int nf = cf;
			//����Ʈ ������
			for (int i=0; i<knightX.length; i++) {
				nx = cx + knightX[i];
				ny = cy + knightY[i];
				
				if (nx < 0 || nx >= N) continue;
				if (ny < 0 || ny >= N) continue;
				
				nc = cc + cost[0];
				nf = cf;
				if (map[nx][ny] == 1) {
					nf -= 1;
				}
				q.add(new CXY(nc,nf,nx,ny));
			}
			//�� ������
			while (nx>=1) {
				nx = cx-1;
				
			}
			//��� ������
		}
	}
}
