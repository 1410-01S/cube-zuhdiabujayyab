package com.example.project;

public class Cube {
	
	private final int[][][] cube;

    public Cube() {
        cube = new int[6][3][3];
        initializeCube();
    }

    private void initializeCube() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = i;
                }
            }
        }
    }

    public void printCube() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[0][i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[1][i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[2][i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[3][i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[4][i][j] + " ");
            }
            System.out.print("  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[5][i][j] + " ");
            }
            System.out.println();
        }
    }

    private void rotateFaceClockwise(int face) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[face][2 - j][i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[face][i][j] = temp[i][j];
            }
        }
    }

    private void rotateFaceCounterClockwise(int face) {
        int[][] temp = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[face][j][2 - i];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[face][i][j] = temp[i][j];
            }
        }
    }

    public void rotateUp() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[2][0][i];
            cube[2][0][i] = cube[4][0][i];
            cube[4][0][i] = cube[3][0][i];
            cube[3][0][i] = cube[1][0][i];
            cube[1][0][i] = temp[i];
        }
        rotateFaceClockwise(0);
    }

    public void rotateDown() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[2][2][i];
            cube[2][2][i] = cube[1][2][i];
            cube[1][2][i] = cube[3][2][i];
            cube[3][2][i] = cube[4][2][i];
            cube[4][2][i] = temp[i];
        }
        rotateFaceClockwise(5);
    }

    public void rotateLeft() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][i][0];
            cube[0][i][0] = cube[2][i][0];
            cube[2][i][0] = cube[5][2 - i][2];
            cube[5][2 - i][2] = cube[4][i][0];
            cube[4][i][0] = temp[i];
        }
        rotateFaceCounterClockwise(3);
    }

    public void rotateRight() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][i][2];
            cube[0][i][2] = cube[4][i][2];
            cube[4][i][2] = cube[5][2 - i][0];
            cube[5][2 - i][0] = cube[2][i][2];
            cube[2][i][2] = temp[i];
        }
        rotateFaceClockwise(1);
    }

    public void rotateFront() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][2][i];
            cube[0][2][i] = cube[3][2 - i][0];
            cube[3][2 - i][0] = cube[5][0][2 - i];
            cube[5][0][2 - i] = cube[1][i][2];
            cube[1][i][2] = temp[i];
        }
        rotateFaceClockwise(2);
    }

    public void rotateBack() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][0][i];
            cube[0][0][i] = cube[1][2 - i][0];
            cube[1][2 - i][0] = cube[5][2][2 - i];
            cube[5][2][2 - i] = cube[3][i][2];
            cube[3][i][2] = temp[i];
        }
        rotateFaceCounterClockwise(4);
    }

    public void rotateMiddle() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][i][1];
            cube[0][i][1] = cube[2][i][1];
            cube[2][i][1] = cube[5][2 - i][1];
            cube[5][2 - i][1] = cube[3][i][1];
            cube[3][i][1] = temp[i];
        }
    }

    public void rotateEquator() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[1][1][i];
            cube[1][1][i] = cube[2][1][i];
            cube[2][1][i] = cube[3][1][i];
            cube[3][1][i] = cube[4][1][i];
            cube[4][1][i] = temp[i];
        }
    }

    public void rotateStanding() {
        int[] temp = new int[3];
        for (int i = 0; i < 3; i++) {
            temp[i] = cube[0][1][i];
            cube[0][1][i] = cube[4][1][i];
            cube[4][1][i] = cube[5][1][i];
            cube[5][1][i] = cube[2][1][i];
            cube[2][1][i] = temp[i];
        }
    }

    public static void main(final String[] args) {
		Cube cube = new Cude();
	    	Cube.printCube();
	
	}

}

