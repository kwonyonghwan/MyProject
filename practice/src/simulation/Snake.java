package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.Position;

/*class Position {
	int positionI;
	int positionJ;

	public Position(int i, int j) {
		this.positionI = i;
		this.positionJ = j;
	}
}*/

class changeDirect {
	int day;
	char direct;

	public changeDirect(int day, char direct) {
		this.day = day;
		this.direct = direct;
	}
}

public class Snake {
	static int[][] directionList = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/Snake.txt"));

		// Scanner sc = new Scanner(System.in);

		int N = sc.nextInt() + 2;
		int[][] graph = new int[N][N];
		int countOfApple = sc.nextInt();

		for (int i = 0; i < countOfApple; i++) {
			graph[sc.nextInt()][sc.nextInt()] = 1;
		}
		for (int i = 0; i < N; i++) {
			graph[i][0] = graph[0][i] = graph[N - 1][i] = graph[i][N - 1] = -1;
		}
		Queue<changeDirect> directQueue = new LinkedList<changeDirect>();

		int sizeOfdirectQueue = sc.nextInt();

		for (int i = 0; i < sizeOfdirectQueue; i++) {
			changeDirect direct = new changeDirect(sc.nextInt(), sc.next().charAt(0));

			directQueue.offer(direct);
		} // forSetting

		int seconds = 0;
		int snakeDirect = 2;

		changeDirect Direct = directQueue.poll();

		Deque<Position> snake = new LinkedList<Position>();
		graph[1][1] = -1;
		snake.offer(new Position(1, 1));
		Position snakeHead = new Position(1, 1);

		do {

			seconds++;

			snakeHead = snake.peekFirst();
			Position snakeTail = null;
			Position nextPosirion = new Position(snakeHead.positionI + directionList[snakeDirect][0],
					snakeHead.positionJ + directionList[snakeDirect][1]);

			if (graph[nextPosirion.positionI][nextPosirion.positionJ] == 0) {
				snake.offerFirst(nextPosirion);
				snakeTail = snake.pollLast();
				graph[snakeTail.positionI][snakeTail.positionJ] = 0;
			} else if (graph[nextPosirion.positionI][nextPosirion.positionJ] == 1) {
				snake.offerFirst(nextPosirion);
			} else if (graph[nextPosirion.positionI][nextPosirion.positionJ] == -1) {
				System.out.println(seconds);
				return;
			}

			graph[nextPosirion.positionI][nextPosirion.positionJ] = -1;

			if (seconds > Direct.day - 1) {
				if (Direct.direct == 'D') {
					snakeDirect = (snakeDirect + 1) % 4;
				} else if (Direct.direct == 'L') {
					snakeDirect = (snakeDirect + 3) % 4;
				}
				if (directQueue.isEmpty()) {
					Direct.day = 1000000;
				} else {
					Direct = directQueue.poll();
				}
			}

		} while (true);

	}// main

}// class
