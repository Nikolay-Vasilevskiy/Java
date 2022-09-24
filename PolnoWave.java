//Задача: Полноценное оформление волнового алгоритма

class Wave
{
    private static final int SIZE = 5;
    private static int[][] wave = {
        {0,1,0,1,1},
        {0,0,0,0,0},
        {1,0,1,0,1},
        {0,0,1,0,0},
        {1,0,0,1,0}
    };

    private static int[][] solution = new int[SIZE][SIZE];

    private static void printSolution()
    {
        for(int i=0;i<SIZE;i++)
        {
            for(int j=0;j<SIZE;j++)
            {
                System.out.print(solution[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
    }

    private static boolean solveWave(int r, int c)
    {
        if((r==SIZE-1) && (c==SIZE-1))
        {
            solution[r][c] = 1;
            return true;
        }
        if(r>=0 && c>=0 && r<SIZE && c<SIZE && solution[r][c] == 0 && wave[r][c] == 0)
        {
            solution[r][c] = 1;
            if(solveWave(r+1, c))
                return true;
            if(solveWave(r, c+1))
                return true;
            if(solveWave(r-1, c))
                return true;
            if(solveWave(r, c-1))
                return true;
            solution[r][c] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args)
    {
        if (solveWave(0,0))
            printSolution();
        else
            System.out.println("Нет решения\n");
    }
}