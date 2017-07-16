package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cubing {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/Cubing.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			String[][] cube = {
					{ "  ", "  ", "  ", "o", "o", "o", " ", " ", " " },
					{ "  ", "  ", "  ", "o", "o", "o", " ", " ", " " }, 
					{ "  ", "  ", "  ", "o", "o", "o", " ", " ", " " },
					{ "g", "g", "g", "y", "y", "y", "b1", "b2", "b3" },
					{ "g", "g", "g", "y", "y", "y", "b4", "b5", "b6" },
					{ "g", "g", "g", "y", "y", "y", "b7", "b8", "b9" }, 
					{ "  ", "  ", "  ", "r", "r", "r", " ", " ", " " },
					{ "  ", "  ", "  ", "r", "r", "r", " ", " ", " " }, 
					{ "  ", "  ", "  ", "r", "r", "r", " ", " ", " " },
					{ "  ", "  ", "  ", "w", "w", "w", " ", " ", " " }, 
					{ "  ", "  ", "  ", "w", "w", "w", " ", " ", " " },
					{ "  ", "  ", "  ", "w", "w", "w", " ", " ", " " } };

			int countOfStep = sc.nextInt();
			sc.nextLine();

			for (int gameStep = 0; gameStep < countOfStep; gameStep++) {

				String stepOrder = sc.next();

				// 해당면 돌아가는거
				selfSpaceRotate(cube, stepOrder);

				// 근접면 돌어가는거
				surroundSpaceRotate(cube, stepOrder);
				System.out.println("stepOrder : " + stepOrder);

			} // forgameStep
			// 출력
			printGraph(cube);
		/*for (int i = 11; i > 8; i--) {
				for (int j = 3; j < 6; j++) {
					System.out.print(cube[i][j]);
				}
				System.out.println();
			}*/

		}

	}// main

	private static void selfSpaceRotate(String[][] cube, String stepOrder) {
		int startPositionI = 0;
		int startPositionJ = 0;

		switch (stepOrder.charAt(0)) {
		case 'D':
			startPositionI = 3;
			startPositionJ = 3;
			break;
		case 'U':
			startPositionI = 9;
			startPositionJ = 3;
			break;
		case 'B':
			startPositionI = 0;
			startPositionJ = 3;
			break;
		case 'F':
			startPositionI = 6;
			startPositionJ = 3;
			break;
		case 'L':
			startPositionI = 3;
			startPositionJ = 0;
			break;
		case 'R':
			startPositionI = 3;
			startPositionJ = 6;
			break;
		default:
			System.out.println("selfSpaceRotate_firstCase_Default");
			break;
		}

		if (stepOrder.charAt(1) == '+') {
			String temp1 = cube[startPositionI][startPositionJ];
			String temp2 = cube[startPositionI][startPositionJ+1];
			
			cube[startPositionI][startPositionJ] = cube[startPositionI][startPositionJ+2];
			cube[startPositionI][startPositionJ+1] = cube[startPositionI+1][startPositionJ+2];
			
			cube[startPositionI][startPositionJ+2] = cube[startPositionI+2][startPositionJ+2];
			cube[startPositionI+1][startPositionJ+2] = cube[startPositionI+2][startPositionJ+1];
			
			cube[startPositionI+2][startPositionJ+2] = cube[startPositionI+2][startPositionJ];
			cube[startPositionI+2][startPositionJ+1] = cube[startPositionI+1][startPositionJ];
			
			cube[startPositionI+2][startPositionJ] = temp1;
			cube[startPositionI+1][startPositionJ] = temp2;
		} else {
			String temp1 = cube[startPositionI][startPositionJ+2];
			String temp2 = cube[startPositionI][startPositionJ+1];
			
			cube[startPositionI][startPositionJ+2] = cube[startPositionI][startPositionJ];
			cube[startPositionI][startPositionJ+1] = cube[startPositionI+1][startPositionJ];
			
			cube[startPositionI][startPositionJ] = cube[startPositionI+2][startPositionJ];
			cube[startPositionI+1][startPositionJ] = cube[startPositionI+2][startPositionJ+1];
			
			cube[startPositionI+2][startPositionJ] = cube[startPositionI+2][startPositionJ+2];
			cube[startPositionI+2][startPositionJ+1] = cube[startPositionI+1][startPositionJ+2];
			
			cube[startPositionI+2][startPositionJ+2] = temp1;
			cube[startPositionI+1][startPositionJ+2] = temp2;
		}

	}// selfSpaceRotate

	private static void surroundSpaceRotate(String[][] cube, String stepOrder) {

		String temp1,temp2,temp3;
		switch (stepOrder) {
		case "D+":
			temp1 = cube[2][3];
			temp2 = cube[2][4];
			temp3 = cube[2][5];
			
			cube[2][3] = cube[3][6];
			cube[2][4] = cube[4][6];
			cube[2][5] = cube[5][6];
			
			cube[3][6] = cube[6][5];
			cube[4][6] = cube[6][4];
			cube[5][6] = cube[6][3];
			
			cube[6][5] = cube[5][2];
			cube[6][4] = cube[4][2];
			cube[6][3] = cube[3][2];
			
			cube[5][2] = temp1;
			cube[4][2] = temp2;
			cube[3][2] = temp3;
			
			break;

		case "D-":
			temp1 = cube[2][5];
			temp2 = cube[2][4];
			temp3 = cube[2][3];
		
			cube[2][5] = cube[3][2];
			cube[2][4] = cube[4][2];
			cube[2][3] = cube[5][2];
			
			cube[3][2] = cube[6][3];
			cube[4][2] = cube[6][4];
			cube[5][2] = cube[6][5];
			
			cube[6][3] = cube[5][6];
			cube[6][4] = cube[4][6];
			cube[6][5] = cube[3][6];
			
			cube[5][6] = temp1;
			cube[4][6] = temp2;
			cube[3][6] = temp3;
			
			break;
			
		case "U+":
			temp1 = cube[0][5];
			temp2 = cube[0][4];
			temp3 = cube[0][3];
			
			cube[0][5] = cube[3][0];
			cube[0][4] = cube[4][0];
			cube[0][3] = cube[5][0];
			
			cube[3][0] = cube[8][3];
			cube[4][0] = cube[8][4];
			cube[5][0] = cube[8][5];
			
			cube[8][3] = cube[5][8];
			cube[8][4] = cube[4][8];
			cube[8][5] = cube[3][8];
			
			cube[5][8] = temp1;
			cube[4][8] = temp2;
			cube[3][8] = temp3;
			break;
		case "U-":
			temp1 = cube[0][3];
			temp2 = cube[0][4];
			temp3 = cube[0][5];
			
			cube[0][3] = cube[3][8];
			cube[0][4] = cube[4][8];
			cube[0][5] = cube[5][8];
			
			cube[3][8] = cube[8][5];
			cube[4][8] = cube[8][4];
			cube[5][8] = cube[8][3];
			
			cube[8][5] = cube[5][0];
			cube[8][4] = cube[4][0];
			cube[8][3] = cube[3][0];
			
			cube[5][0] = temp1;
			cube[4][0] = temp2;
			cube[3][0] = temp3;
			break;
		case "B+":
			temp1 = cube[3][8];
			temp2 = cube[3][7];
			temp3 = cube[3][6];
			
			cube[3][8] = cube[3][5];
			cube[3][7] = cube[3][4];
			cube[3][6] = cube[3][3];
			
			cube[3][5] = cube[3][2];
			cube[3][4] = cube[3][1];
			cube[3][3] = cube[3][0];
			
			cube[3][2] = cube[11][3];
			cube[3][1] = cube[11][4];
			cube[3][0] = cube[11][5];
			
			cube[11][3] = temp1;
			cube[11][4] = temp2;
			cube[11][5] = temp3;
			break;
		case "B-":
			temp1 = cube[3][0];
			temp2 = cube[3][1];
			temp3 = cube[3][2];
			
			cube[3][0] = cube[3][3];
			cube[3][1] = cube[3][4];
			cube[3][2] = cube[3][5];
			
			cube[3][3] = cube[3][6];
			cube[3][4] = cube[3][7];
			cube[3][5] = cube[3][8];
			
			cube[3][6] = cube[11][5];
			cube[3][7] = cube[11][4];
			cube[3][8] = cube[11][3];
			
			cube[11][5] = temp1;
			cube[11][4] = temp2;
			cube[11][3] = temp3;
			break;
		case "F+":
			temp1 = cube[5][0];
			temp2 = cube[5][1];
			temp3 = cube[5][2];
			
			cube[5][0] = cube[5][3];
			cube[5][1] = cube[5][4];
			cube[5][2] = cube[5][5];
			
			cube[5][3] = cube[5][6];
			cube[5][4] = cube[5][7];
			cube[5][5] = cube[5][8];
			
			cube[5][6] = cube[9][5];
			cube[5][7] = cube[9][4];
			cube[5][8] = cube[9][3];
			
			cube[9][5] = temp1;
			cube[9][4] = temp2;
			cube[9][3] = temp3;
			break;
		case "F-":
			temp1 = cube[5][8];
			temp2 = cube[5][7];
			temp3 = cube[5][6];
			
			cube[5][8] = cube[5][5];
			cube[5][7] = cube[5][4];
			cube[5][6] = cube[5][3];
			
			cube[5][5] = cube[5][2];
			cube[5][4] = cube[5][1];
			cube[5][3] = cube[5][0];
			
			cube[5][2] = cube[9][3];
			cube[5][1] = cube[9][4];
			cube[5][0] = cube[9][5];
			
			cube[9][3] = temp1;
			cube[9][4] = temp2;
			cube[9][5] = temp3;
			break;
		case "L+":
			temp1 = cube[0][3];
			temp2 = cube[1][3];
			temp3 = cube[2][3];
			
			cube[0][3] = cube[3][3];
			cube[1][3] = cube[4][3];
			cube[2][3] = cube[5][3];
			
			cube[3][3] = cube[6][3];
			cube[4][3] = cube[7][3];
			cube[5][3] = cube[8][3];
			
			cube[6][3] = cube[9][3];
			cube[7][3] = cube[10][3];
			cube[8][3] = cube[11][3];
			
			cube[9][3] = temp1;
			cube[10][3] = temp2;
			cube[11][3] = temp3;
			break;
		case "L-":
			temp1 = cube[11][3];
			temp2 = cube[10][3];
			temp3 = cube[9][3];
			
			cube[11][3] = cube[8][3];
			cube[10][3] = cube[7][3];
			cube[9][3] = cube[6][3];
			
			cube[8][3] = cube[5][3];
			cube[7][3] = cube[4][3];
			cube[6][3] = cube[3][3];
			
			cube[5][3] = cube[2][3];
			cube[4][3] = cube[1][3];
			cube[3][3] = cube[0][3];
			
			cube[2][3] = temp1;
			cube[1][3] = temp2;
			cube[0][3] = temp3;
			break;

		case "R+":
			temp1 = cube[11][5];
			temp2 = cube[10][5];
			temp3 = cube[9][5];
			
			cube[11][5] = cube[8][5];
			cube[10][5] = cube[7][5];
			cube[9][5] = cube[6][5];
			
			cube[8][5] = cube[5][5];
			cube[7][5] = cube[4][5];
			cube[6][5] = cube[3][5];
			
			cube[5][5] = cube[2][5];
			cube[4][5] = cube[1][5];
			cube[3][5] = cube[0][5];
			
			cube[2][5] = temp1;
			cube[1][5] = temp2;
			cube[0][5] = temp3;
			break;
			
		case "R-":
			temp1 = cube[0][5];
			temp2 = cube[1][5];
			temp3 = cube[2][5];
			
			cube[0][5] = cube[3][5];
			cube[1][5] = cube[4][5];
			cube[2][5] = cube[5][5];
			
			cube[3][5] = cube[6][5];
			cube[4][5] = cube[7][5];
			cube[5][5] = cube[8][5];
			
			cube[6][5] = cube[9][5];
			cube[7][5] = cube[10][5];
			cube[8][5] = cube[11][5];
			
			cube[9][5] = temp1;
			cube[10][5] = temp2;
			cube[11][5] = temp3;
			break;
		default:
			System.out.println("surroundSpaceRotate_default");
			break;
		}

	}// surroundSpaceRotate

	public static void printGraph(String[][] cube) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(cube[i][j] + "    ");
			}
			System.out.println();
		}
		System.out.println();
	}// printGraph()

}// class
