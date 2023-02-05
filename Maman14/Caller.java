public class Caller 
{
    public static void main(String[] args)
    {
        boolean[][] arr2 = {
                            {true,true,false,true,true,false,true,true,true,false},
                            {true,false,false,false,false,false,false,false,false,false},
                            {false,false,false,false,false,false,false,false,false,false}};

        boolean[][] arr3 = {
                            {false,true,false,false,true,false,false,false,false,true},
                            {true,true,true,true,false,false,false,true,false,true},
                            {false,true,false,false,false,false,false,false,false,false}};
        //System.out.println(A.findIsland(arr2));

        boolean[][] mat = {
            {false,false,false,false,true},
            {false,true,true,true,false},
            {false,false,true,true,false},
            {true,false,false,false,false},
            {true,true,false,false,false},
        };


        
        //A.printArr(arr3);
        //A.printArr(mat);

        System.out.println(Ex14.cntTrueReg(mat));
        //A.printArr(mat);

        //A.printArr(arr3);
    } 


}
