import java.util.Scanner;

public class XO implements IBoardGame {

    String[][] board;
    String winner;
    public XO() {
        board = new String[3][3];

        winner = null;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j] = "E";
            }
        }
    }

    @Override
    public String getWinner() {

        return winner;
    }

    @Override
    public boolean takeShot(boolean isX, int row, int col) {
        row--;
        col--;
        if(board[row][col]=="E")
        {
            if(isX)
            {
                board[row][col] = "X";
                return true;
            }
            else
            {
                board[row][col] = "O";
                return true;
            }
        }
        else
            return false;
    }
    public void  getUI()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j].equals("E"))
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(board[i][j]);
                }
                if(j!=2)
                    System.out.print("   |   ");
            }
            if(i!=2) {
                System.out.println();
                System.out.println("------------------");
            }
        }
        System.out.println();
    }
    public void playGame(Scanner scan)
    {
        int checkTriple=0;
        boolean isX = true;
        while(true) {
            getUI();
            boolean check = false;
            while(check == false) {
                int X;
                int Y;
                while(true) {
                    System.out.print("Input your positon X (1-3)  : ");
                     X = scan.nextInt();
                    System.out.print("Input your positon Y (1-3)  : ");
                    Y = scan.nextInt();
                    if((X>3 || X<1) || (Y>3 || Y<1))
                    {
                        System.out.println("Pleaes Enter number in range 1..3");
                    }
                    else
                    {
                        break;
                    }
                }
                check = takeShot(isX, X, Y);
                if(!check)
                {
                    System.out.println("This position has used already, Please use other position");
                }
            }
            isX = !isX;
            if (checkTriple == 0) {
                for (int i = 0; i < 3; i++) {
                    if (board[i][0].equals(board[i][1]) && board[i][2].equals(board[i][1]) && !board[i][0].equals("E")) {
                        checkTriple = 1;
                        winner = board[i][0];
                    }
                }
            }
            if (checkTriple == 0) {
                for (int i = 0; i < 3; i++) {
                    if (board[0][i].equals(board[1][i]) && board[2][i].equals(board[0][i]) && !board[0][i].equals("E")) {
                        checkTriple = 1;
                        winner = board[0][i];
                    }
                }
            }
            if (checkTriple == 0) {
                if (board[0][0].equals(board[1][1]) && board[2][2].equals(board[0][0]) && !board[0][0].equals("E")) {
                    checkTriple = 1;
                    winner = board[0][0];
                }
            }
            if (checkTriple == 0) {
                if (board[0][2].equals(board[1][1]) && board[2][0].equals(board[0][2]) && !board[1][1].equals("E")) {
                    checkTriple = 1;
                    winner = board[0][0];
                }
            }
            if(!draw())
            {
                getUI();
                System.out.println("This Game is draw.");

                break;
            }
            System.out.println("The winner = "+getWinner());
            if(getWinner()!= null)
            {
                break;
            }
        }


    }
    public boolean draw()
    {
        boolean check = false;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j].equals("E"))
                {
                    check = true;
                }
            }
        }
        return check;
    }


}
