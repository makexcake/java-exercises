public class A 
{

    
    public static int cntTrueReg(boolean mat[][])
    {
        return cntTrueReg(mat, 0, 0);
    }
    public static int cntTrueReg(boolean arr[][], int i, int j)
    {
        //Check array bound (column)
        if(i == arr.length)
        {
            return 0;            
        }
            
        //check array bound row
        //if bound run the next row
        if(j == arr[i].length)
        {
            return cntTrueReg(arr, i+1, 0);   
        }


        int isTrue = 0;
        //########CHAGE NAME TO MAT###########
        //if the cell is true run falser and make isTrue 1
        if (arr[i][j] == true)
        {
            isTrue = 1; 
            falser(arr, i, j);
        }
        return isTrue + cntTrueReg(arr, i, j+1);

    }



    //private function which Falses entire section 
    public static void falser(boolean[][] arr, int i, int j)
    {
        //if the cell is false return   
        if (arr[i][j] == false)
        {
            return;
        }
        //make the cell false
        arr[i][j] = false;

        //checks the up, down, forward, backward

        //Farward
        if(j < arr[i].length-1)
            falser(arr, i, j+1);
        //Back   
        if(j > 0)            
            falser(arr, i, j-1);
        //Up
        if(i > 0)
            falser(arr, i-1, j);
        //Down
        if(i < arr.length-1)
            falser(arr, i+1, j);

    }



















    public static void printArr(boolean[][] arr)
    {
        for (int i  = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
