/**
 * @author makexcake
 * @version 15/01/2021
 */
public class Ex14 
{

    //                 ############# Task 1 ###############

    /**
     * The program finds the single integer in array of coupled integers.
     * @param a Array of integers
     * @return the integer in the array that isn't coupled
     */
    public static int findSignle(int [] a)
    {
        /*
        *General idea: Compare every 2 indexes except the last, if they aren't equal 
        the first is the one without a couple.
        
        *Time complexity: O(n) 
        *Space complexity: O(1)
        */
        
        //Continue if the arry is greater than 1. If it's length is 1 return a[1]
        if (a.length > 2)
        {
            for (int i = 0; i < a.length-2; i += 2) 
            {
                //if the following numbers are not equal, a[i] is the single number.
                if (a[i] != a[i+1]) 
                {
                    return a[i];
                }
            }
            //if the single number is the last in array
            return a[a.length-1];

        }
        return a[0];
    }







    //                 ############# Task 2 ############### 
    /**
     * Given an array of non negative integers and non negative integer, 
     * calculates the minimal length of an array wiche's content's sum is bigger 
     * than the given integer.
     * @param arr Array of non negative integers
     * @param x Non negative integer
     * @return Length of the array 
     */
    public static int smallestSubSum(int arr[], int x)
    {
        /*
        *General idea: Use selection sort for sorting the array values from
        big to small. Every cycle add the new sorted number to the sum and 
        check if the sum is greater then the given 'x'.

        *Time complexity: n(n-1)/2 => O(n^2)
        *Space complexity: O(1)

        1. For every number in 'j' index in the array, check if it's greater than 
        the number in 'i' index.
        
        2. If the number is greather exchange it with the number in the index 'i'.

        3. When reaching the end of the array add the final number in 'i' index
        to 'sum' variable and add 1 to 'counter'.

        4. If the sum of the sorted part is greater than the given number 'x'
        return the value of the counter and if not, repeat the prosidure 
        from index i+1.

        5. If reached the end of the array and the sum is less than 'x'
        -1 is returned.
        */

        int sum = 0, counter = 0, temp;
        
        //Continue only if the array is not empty
        if (arr.length > 0)
        {
            for (int i = 0; i < arr.length; i++)
            {   
                for (int j = i; j < arr.length; j++)
                {
                    //If the number is greather than a[i] swap between a[i] and a[j]
                    if (arr[i] < arr[j])
                    {
                        temp = arr[i]; //hold value of a[i]
                        arr[i] = arr[j]; //place a[j] value in a[i]
                        arr[j] = temp; //place the previous a[i] value in a[j] slot
                    }
                }
                //Add the new number to the sorted value to sum                     
                sum +=arr[i];   
                counter++;  
            
                //if sum is greater than 'x' return counter
                if (sum > x)
                {
                    return counter;
                }          
            }
        }
        return -1;
    }






    //                 ############# Task 3 ###############
    
    /**
     * Given number between 3 to 30, returns the number of combinations 
     * of sum for x1 + x2 + x3 and prints them on console. 
     * @param num   Wanted sum      
     * @return  Number of possible sum combinations
     */
    public static int solutions(int num)
    {
        //return 0 if the number is out of bounds
        if (num >= 3 && num <= 30)
        {
            return solutions(num, 1,1,1);
        }       
        return 0;
    }

    
    private static int solutions(int num, int x1, int x2, int x3)
    {
        /*
        
        *General idea: The program starts from 1 + 1 + 1, and increases x3 until
        it gets bigger then the given num or 10 (which is the max x value).
        After that the program increases x2 by 1 and repeats the increment of x3.
        The last "x" that increases is x1. 
        Stop condition is when x1 reaches 10 or exceeds the number.



        As we see in the ilustration, the program tries every combination with 
        x1 == 1, then with  x == 2 until x1 == 10 or exceeds the "num".
                                                x1
                                                |
                                _________________________________________... 
                                |       |       |       |       |       |
                                1       2       3       4       5       6
                                :       |       :       :       :       :
                                :       x2      :       :       :       :
                                        |
                _________________________________________...
                |       |       |       |       |       |
               2+1     2+2     2+3     2+4     2+5     2+6
                :       :       |       :       :       :
                :       :       x3      :       :       :
                                |
                _________________________________________...
                |       |       |       |       |       |
              2+3+1   2+3+2   2+3+3   2+3+4   2+3+5   2+3+6
        

        */

        //Stop condition: When x1 exceeds "num".
        if (x1 > 10 || x1 > num)
        {
            return 0;
        }
        /*In case x1 + x2 exceed "num", encrease x1 and zero x2 and x3  */
        if (x1 + x2 > num || x2 > 10)
        {
            return solutions(num, x1 + 1, 1, 1);
        }
        /*In case x1+x2+x3 exceed "num" zero x3 and increase x2 */
        if (x1 + x2 + x3 > num || x3 > 10)
        {
            return solutions(num, x1, x2 + 1, 1);
        }

        int noOfSolutions =  0;
        
        //In case the sum equals num print the answer and turn
        //the number of solutions to 1.
        if (x1 + x2 + x3 == num)
        {
            System.out.println(x1 + "+" + x2 + "+" + x3);
            noOfSolutions = 1;
        }

        //Return noOfSolutions and call the function with increment of x3
        return noOfSolutions + solutions(num, x1, x2, x3 + 1);
    }






    

    //                 ############# Task 4 ###############

    /**
     * Recives matrix of true and false values returnes the number of 
     * connected partitions with "true" value.
     * @param mat Boolean two dimentional array
     * @return  Number of connected "true" cells
     */
    public static int cntTrueReg(boolean mat[][])
    {
        return cntTrueReg(mat, 0, 0);
    }
    private static int cntTrueReg(boolean arr[][], int i, int j)
    {
        /*
        General idea: Scan through the array and check if the current cell is true.
        If the cell is true turn "isTrue" indicator to true and 
        call the "falser" private method wich turnes all the adjecent cell to false.
        After all the connected cells are false we can be sure that we will not
        count the same partition more than once and will continue scanning the array
        until the next true appears or until the end of the array.
        */
        
        //STOP CONDITION (when there are no coulmns left)
        if(i == arr.length)
        {
            return 0;            
        }
            
        //Check array bound row
        //If bound run the next row
        if(j == arr[i].length)
        {
            return cntTrueReg(arr, i+1, 0);   
        }

        //Create indicator
        int isTrue = 0;
        
        //If this cell is true change the indicator to true and 
        //run the "falser" private method to disable the partition.
        if (arr[i][j] == true)
        {
            isTrue = 1; 
            falser(arr, i, j);
        }
        //return the indicator + scan next cell
        return isTrue + cntTrueReg(arr, i, j+1);

    }

    /*
    Private method that changes current value of the cell to false 
    and checks the adjecent cells is four directions.
    If their value is true, the method changes them to false.
    */ 
    private static void falser(boolean[][] arr, int i, int j)
    {
        //if the cell is false stop   
        if (arr[i][j] == false)
        {
            return;
        }
        //change cell's value to false
        arr[i][j] = false;

        //Check the sorrounding cells in 4 directions
        //And make sure that the program not checking out of bound cells

        //Forward cell
        if(j < arr[i].length-1)
            falser(arr, i, j+1);
        //Back cell 
        if(j > 0)            
            falser(arr, i, j-1);
        //Upper cell
        if(i > 0)
            falser(arr, i-1, j);
        //Down cell
        if(i < arr.length-1)
            falser(arr, i+1, j);

    }
}
