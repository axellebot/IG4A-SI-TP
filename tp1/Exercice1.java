package tp1;

import java.util.Scanner;

/**
 *
 * @author Basile DUTERTE & Axel LE BOT
 */
public class Exercice1 {
    // TODO : [x]

    private final static int OCCUPIED = -1;
    private final static int QUEEN = 1;
    private final static int FREE =0;
    private static int[][] tab;
    private static int size = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrix size ?\n");
        String  st = sc.nextLine();
        int size = Integer.valueOf(st);

        Exercice1 ex = new Exercice1(size);
        ex.display();
        ex.fillQueens(0,0);
        ex.display();
    }

    public Exercice1(int size) {
        tab = new int[size][size];

        for (int line = 0; line < size; line++) {
            for (int col = 0; col < size; col++) {
                tab[line][col] = FREE;
            }
        }
    }

    private void display() {
        System.out.println("Display :");
        String tileLabel ="";
        int sumOccupied=0;
        int sumQueen=0;
        int sumFree=0;
        for (int line = 0; line < size; line++) {
            System.out.print("|\t");
            for (int col = 0; col < size; col++) {
                switch (tab[line][col] ){
                    case OCCUPIED :
                        tileLabel = "X";
                        sumOccupied++;
                        break;
                    case QUEEN:
                        tileLabel="Q";
                        sumQueen++;
                        break;
                    case FREE:
                        tileLabel = "O";
                        sumFree++;
                        break;
                }
                System.out.print(tileLabel+ "\t|\t");
            }
            System.out.println();
        }
        System.out.println("Queen count : "+sumQueen);
        System.out.println("Occupied count : "+sumOccupied);
        System.out.println("Free count : "+sumFree);

    }

    private void markLine(int lineLocation) {
        for (int col = 0; col < size; col++) {
            markTile(lineLocation, col);
        }
    }

    private void markCol(int colLocation) {
        for (int line = 0; line < size; line++) {
            markTile(line, colLocation);
        }
    }

    private void markDiagonal(int lineLocation, int colLocation) {
        //En bas à droite
        for (int line = lineLocation, col = colLocation; (line < size && col < size); line++, col++) {
            markTile(line, col);
        }

        //En bas à gauche
        for (int line = lineLocation, col = colLocation; (line < size && col >= 0); line++, col--) {
            markTile(line, col);
        }

        //En haut à gauche
        for (int line = lineLocation, col = colLocation; (line >= 0 && col >= 0); line--, col--) {
            markTile(line, col);
        }

        //En haut à droite
        for (int line = lineLocation, col = colLocation; (line >= 0 && col < size); line--, col++) {
            markTile(line, col);
        }
    }

    private void markTile(int lineLocation, int colLocation) {
        if (tab[lineLocation][colLocation] != QUEEN) {
            tab[lineLocation][colLocation] = OCCUPIED;
        }
    }

    private void placeQueen(int lineLocation, int colLocation) {
        System.out.println("Placing Queen at "+String.valueOf(lineLocation)+","+String.valueOf(colLocation));
        tab[lineLocation][colLocation] = QUEEN;
        markCol(colLocation);
        markLine(lineLocation);
        markDiagonal(lineLocation, colLocation);
    }

    /**
     * Fill Queens
     */
    private boolean fillQueens(int line,int col) {
        if(line >= size){
            line=0;
            col++;
        }
        if (col >= size) {
            return true;
        }
        for (; line < size;line++) {
            if(tab[line][col]==FREE) {
                placeQueen(line, col);
                if (fillQueens(line+2,col + 1)) {
                    return true;
                }
            }
        }
        fillQueens(0,col+1);
        return false;
    }
}
