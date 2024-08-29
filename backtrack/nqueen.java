package backtrack;

public class nqueen {
    public static void main(String[] args) {
        boolean[][] board1=new boolean[4][4];
        printBoard(board1);
    }

    //this code is not complete
    static int Nqueen(boolean[][] board,int row){
        if(row == board.length){   

            printBoard(board);
            return 1;
        }
        int count = 0;


        return count;
    }
    private static void printBoard(boolean[][] board) {
        for(boolean[] row:board){
            for(boolean col: row){
                if(col){
                    System.out.print("Q"+" ");
                }
                else{
                    System.out.print("-"+" ");
                }
            }
            System.out.println();
        }
    }
}
