package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

public class Tomato3 {

	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/Tomato.txt"));

		// Scanner sc = new Scanner(System.in);

		 int N = sc.nextInt();
         int M = sc.nextInt();
         int arr[][] = new int[N][M];
         boolean isVisit[][] = new boolean[N][M];
         int step[][] = new int[N][M];
   
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               arr[i][j] = sc.nextInt();
            }
         }
   
         Queue<Pos> q = new LinkedList<Pos>();
   
         for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (arr[i][j] == 1) {
                  q.offer(new Pos(i, j));
                  isVisit[i][j] = true;
               }
            }
         }
   
         int day = 0;
         while (!q.isEmpty()) {
            Pos pos = q.poll();
            day = step[pos.x][pos.y];
   
            // 위쪽
            if (pos.x - 1 >= 0 && arr[pos.x - 1][pos.y] != -1 && !isVisit[pos.x - 1][pos.y]) {
               q.offer(new Pos(pos.x - 1, pos.y));
               isVisit[pos.x - 1][pos.y] = true;
               step[pos.x - 1][pos.y] = step[pos.x][pos.y] + 1;
            }
            // 아래쪽
            if (pos.x + 1 < N && arr[pos.x + 1][pos.y] != -1 && !isVisit[pos.x + 1][pos.y]) {
               q.offer(new Pos(pos.x + 1, pos.y));
               isVisit[pos.x + 1][pos.y] = true;
               step[pos.x + 1][pos.y] = step[pos.x][pos.y] + 1;
            }
            // 오른쪽
            if (pos.y + 1 < M && arr[pos.x][pos.y + 1] != -1 && !isVisit[pos.x][pos.y + 1]) {
               q.offer(new Pos(pos.x, pos.y + 1));
               isVisit[pos.x][pos.y + 1] = true;
               step[pos.x][pos.y + 1] = step[pos.x][pos.y] + 1;
            }
            // 왼쪽
            if (pos.y - 1 >= 0 && arr[pos.x][pos.y - 1] != -1 && !isVisit[pos.x][pos.y - 1]) {
               q.offer(new Pos(pos.x, pos.y - 1));
               isVisit[pos.x][pos.y - 1] = true;
               step[pos.x][pos.y - 1] = step[pos.x][pos.y] + 1;
            }
   
         }
   
         
         for(int i=0;i<isVisit.length;i++){
            for(int j=0;j<isVisit[i].length;j++){
               if(arr[i][j]==0 && isVisit[i][j]==false ){
                  day=-1;
               }
            }
         }
         System.out.println(day);
   
      }
   }
   
   class Pos {
      int x;
      int y;
   
      public Pos() {
      }
   
      public Pos(int x, int y) {
         super();
         this.x = x;
         this.y = y;
      }
   
   }