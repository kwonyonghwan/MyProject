package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InputArray3 {

	public static void main(String[] args) throws FileNotFoundException {

		String inputString = "1213002";

		int[][] board = { { 1, 2, 0, 0 }, { 1, 0, 2, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 } };

		int K = 2;
		int Ax = 1;
		int Ay = 1;
		int Bx = 2;
		int By = 2;

		Solution(board, K, Ax, Ay, Bx, By);

	}// main

	private static void Solution(int[][] board, int K, int Ax, int Ay, int Bx, int By) {
		int answer = 0;

		int[][] safeMap = new int[board.length][board[0].length];
		
		int[][] aMoveMap = new int[board.length][board[0].length];
		int[][] bMoveMap = new int[board.length][board[0].length];
		
		int[][] directionMove = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };
		Queue<Position> queue = new LinkedList<Position>();

		for (int i = 0; i < safeMap.length; i++) {
			for (int j = 0; j < safeMap[0].length; j++) {
				safeMap[i][j] = 0;
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == 2) {
					safeMap[i][j] = 1;
				}
				
				if (board[i][j] == 1) {
					safeMap[i][j] = 1;
					Position startPosition = new Position(i, j);
					queue.offer(startPosition);
 
					while (!queue.isEmpty()) {
						Position nowPosition = queue.poll();
						if(safeMap[nowPosition.positionI][nowPosition.positionJ]>K){
							queue.clear();
							break;
						}
						for (int l = 0; l < 4; l++) {
							if (nowPosition.positionI + directionMove[l][0] > -1
									&& nowPosition.positionJ + directionMove[l][1] > -1
									&& nowPosition.positionI + directionMove[l][0] < board.length
									&& nowPosition.positionJ + directionMove[l][1] < board[0].length
									&& board[nowPosition.positionI + directionMove[l][0]][nowPosition.positionJ
											+ directionMove[l][1]] == 0
									&& safeMap[nowPosition.positionI + directionMove[l][0]][nowPosition.positionJ
											+ directionMove[l][1]]==0) {
								Position nextPosition = new Position(nowPosition.positionI + directionMove[l][0],
										nowPosition.positionJ + directionMove[l][1]);
								safeMap[nextPosition.positionI][nextPosition.positionJ] = safeMap[nowPosition.positionI][nowPosition.positionJ]+1;
								queue.offer(nextPosition);
							}

						}
					}//whileBFS

				} // IfBomb

			}
		}//makeSafeMap
		
		Position aPosition = new Position(Ax, Ay);
		int aResult = 0; 
		queue.offer(aPosition);
		Position aResultPosition = null ;
		 
		while (!queue.isEmpty()) {
			Position nowPosition = queue.poll();
		
			for (int l = 0; l < 4; l++) {
				if (nowPosition.positionI + directionMove[l][0] > -1
						&& nowPosition.positionJ + directionMove[l][1] > -1
						&& nowPosition.positionI + directionMove[l][0] < board.length
						&& nowPosition.positionJ + directionMove[l][1] < board[0].length
						&& board[nowPosition.positionI + directionMove[l][0]][nowPosition.positionJ
								+ directionMove[l][1]] == 0) {
					
					
					Position nextPosition = new Position(nowPosition.positionI + directionMove[l][0],nowPosition.positionJ + directionMove[l][1]);
					
					aMoveMap[nextPosition.positionI][nextPosition.positionJ]=aMoveMap[nowPosition.positionI][nowPosition.positionJ]+1;
					
					if(safeMap[nextPosition.positionI][nextPosition.positionJ]==0){
						aResultPosition = new Position(nextPosition.positionI, nextPosition.positionJ);
						queue.clear(); 
						aResult = aMoveMap[nextPosition.positionI][nextPosition.positionJ];
						break;
					}
					
					queue.offer(nextPosition);
				}

			}
		}//whileA

		
		System.out.println("aaa"+aResult);
		
		
		
		Position bPosition = new Position(Bx, By);
		Position bResultPosition = null;
		
		int bResult = 0; 
		queue.offer(bPosition);
		 
		while (!queue.isEmpty()) {
			Position nowPosition = queue.poll();
		
			for (int l = 0; l < 4; l++) {
				if (nowPosition.positionI + directionMove[l][0] > -1
						&& nowPosition.positionJ + directionMove[l][1] > -1
						&& nowPosition.positionI + directionMove[l][0] < board.length
						&& nowPosition.positionJ + directionMove[l][1] < board[0].length
						&& board[nowPosition.positionI + directionMove[l][0]][nowPosition.positionJ
								+ directionMove[l][1]] == 0) {
					
					
					Position nextPosition = new Position(nowPosition.positionI + directionMove[l][0],nowPosition.positionJ + directionMove[l][1]);
					
					bMoveMap[nextPosition.positionI][nextPosition.positionJ]=bMoveMap[nowPosition.positionI][nowPosition.positionJ]+1;
					
					if(safeMap[nextPosition.positionI][nextPosition.positionJ]==0){
						bResultPosition = new Position(nextPosition.positionI, nextPosition.positionJ);
						queue.clear(); 
						bResult = bMoveMap[nextPosition.positionI][nextPosition.positionJ];
						break;
					}
					
					queue.offer(nextPosition);
				}

			}
		}//whileB

		System.out.println(bResult+"sss");
		
		
		
		
		for (

				int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(safeMap[i][j] + "   ");
			}
			System.out.println();
		}
		
		if(aResultPosition.positionI == bResultPosition.positionI && aResultPosition.positionJ== bResultPosition.positionJ){
			int[][] cMoveMap = new int[board.length][board[0].length];
			Position cPosition= null;
			if(aResult > bResult){
				 cPosition = new Position(aResultPosition.positionI, aResultPosition.positionJ);
				 safeMap[aResultPosition.positionI][aResultPosition.positionJ] = 1;
			}else{
				 cPosition = new Position(bResultPosition.positionI, bResultPosition.positionJ);
				 safeMap[bResultPosition.positionI][bResultPosition.positionJ] = 1;
			}
		
			Position cResultPosition = null;
			int cResult = 0; 
			queue.offer(cPosition);
			 
			while (!queue.isEmpty()) {
				Position nowPosition = queue.poll();
			
				for (int l = 0; l < 4; l++) {
					if (nowPosition.positionI + directionMove[l][0] > -1
							&& nowPosition.positionJ + directionMove[l][1] > -1
							&& nowPosition.positionI + directionMove[l][0] < board.length
							&& nowPosition.positionJ + directionMove[l][1] < board[0].length
							&& board[nowPosition.positionI + directionMove[l][0]][nowPosition.positionJ
									+ directionMove[l][1]] == 0) {
						
						
						Position nextPosition = new Position(nowPosition.positionI + directionMove[l][0],nowPosition.positionJ + directionMove[l][1]);
						
						cMoveMap[nextPosition.positionI][nextPosition.positionJ]=cMoveMap[nowPosition.positionI][nowPosition.positionJ]+1;
						
						if(safeMap[nextPosition.positionI][nextPosition.positionJ]==0){
							cResultPosition = new Position(nextPosition.positionI, nextPosition.positionJ);
							queue.clear(); 
							cResult = cMoveMap[nextPosition.positionI][nextPosition.positionJ];
							break;
						}
						
						queue.offer(nextPosition);
					}

				}
			}//whileB
			
			if(aResult > bResult){
				aResult = cResult;
			}else{
				bResult = cResult;
			}
			
		}
		
		System.out.println(aResult+"  dadfsdf "+bResult);
		
		answer = Math.max(aResult, bResult);

		System.out.println(answer+"dd");
	}

}

/*
 * class Position { public int positionI; public int positionJ;
 * 
 * public Position(int i, int j) { this.positionI = i; this.positionJ = j; } }
 */