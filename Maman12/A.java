public class A 
{  

    public static int factorial(int num)
    {
        if (num > 0)
        {
            return num * factorial(num - 1);
        }
        return 1;
    }  
    
    public static void printNum(int num)
    {
        if (num > 0)
        {
            printNum(num-1);
            System.out.println(num);
        }
    }

    public static int digits(int num)
    {
        if (num > 0)
            return 1 + digits(num/10);
        return 0;
    }

    public static int pow(int a, int n)
    {
        if (n > 0)
        {
            int temp = pow(a, n/2);
            
            if (n%2 == 0)
                return (temp * temp);
            else
                return (a* temp * temp);
        }
        return 1;    
    }   

    public static int fibonachi(int n)
    {
        if (n == 1 || n == 2)
            return 1;
        return fibonachi(n - 1) + fibonachi(n - 2);
    }


    public static void binNum(int num)
    {
        binNum(num, "");
    }

    private static void binNum(int num, String str)
    {
        if (num == 0)
        {
            System.out.println(str);
        }
        else
        {
            binNum(num-1, str + "0");
            binNum(num-1, str + "1");
        }
    }


    public static int arrSum(int [] arr)
    {
        return arrSum(arr, arr.length-1);
    }

    private static int arrSum(int[] arr, int i)
    {
        if (i > 0)
        {
            return arr[i] + arrSum(arr, i-1);  
        }
        
        return arr[i];
    }


    public static void printArr(int[] arr)
    {
        printArr(arr, 0);
    }

    private static void printArr(int[] arr, int i)
    {
        if (i < arr.length)
        {
            System.out.print(arr[i] + "\t");
            printArr(arr, i + 1);
        }
        return;
    }


    public static int binSearch(int [] arr, int x)
    {
        return binSearch(arr, x, 0, arr.length);
    }

    private static int binSearch(int[] arr, int x, int lo, int hi)
    {
        if (hi < lo)
            return -1;

        int middle = (hi + lo)/2;
        if (arr[middle] == x)
        {
            return middle;
        }
        else if (arr[middle] < x)
        {
            return binSearch(arr, x, middle+1, hi);
        }
        else
        {
            return binSearch(arr, x, lo, middle-1);
        }
    }


    public static int findMax(int[] arr)
    {
        return findMax(arr, 0, arr[0]);
    }
    
    private static int findMax(int[] arr, int i, int max)
    {
        if (i < arr.length)
        {
            if (max < arr[i])
            {
                max = arr[i];
            }
            return findMax(arr, i+1, max);
        }
        return max;
    }


    public static int findMinIdx(int[] arr, int i)
    {   
        if (i < arr.length-1)
        {
            int currentMin = findMinIdx(arr, i + 1);
            
            if (arr[i] > arr[currentMin])
            {
                return currentMin;
            }            
        }
        return i;
    }



    public static void selectionSort(int[] arr)
    {
        selectionSort(arr, 0);
    }
    private static void selectionSort(int[] arr, int i)
    {
        if (i < arr.length)
        {
            int min = findMinIdx(arr, i);
            if (arr[i] < arr[min]);
            {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }            
            selectionSort(arr, i + 1);
        }
        return;
    }


    public static void quickSort(int[] arr)
    {

    }

    public static int pathFinder(int x, int y)
    {
        if (x == 0 && y == 0)
        {
            return 0;
        }
        if (x == 0 || y == 0)
        {
            return 1;
        }
        return pathFinder(x - 1, y) + pathFinder(x, y - 1);        
    }

    public static boolean numSum(int[] arr, int num)
    {
        return numSum(arr, num, 0);
    }
    private static boolean numSum(int[] arr, int num, int idx)
    {
        if (idx == arr.length)
        {
            return false;
        }
        if (arr[idx] == num)
        {
            return true;
        }
        return numSum(arr, num, idx + 1) || numSum(arr, num - arr[idx], idx + 1);
    }
    
    static int smallestSubSum(int arr[], int x)  
    { 
        // Initialize current sum and minimum length 
        int arrLength = arr.length, curr_sum = 0, min_len = arrLength + 1; 
  
        // Initialize starting and ending indexes 
        int start = 0, end = 0; 
        while (end < arrLength)  
        { 
            // Keep adding array elements while current sum 
            // is smaller than x 
            while (curr_sum <= x && end < arrLength) 
                curr_sum += arr[end++]; 
  
            // If current sum becomes greater than x. 
            while (curr_sum > x && start < arrLength)  
            { 
                // Update minimum length if needed 
                if (end - start < min_len) 
                    min_len = end - start; 
  
                // remove starting elements 
                curr_sum -= arr[start++]; 
            } 
        } 
        return min_len;  
    }

    static int smallestSubWithSum(int arr[], int n, int x)  
    { 
        // Initialize current sum and minimum length 
        int curr_sum = 0, min_len = n + 1; 
  
        // Initialize starting and ending indexes 
        int start = 0, end = 0; 
        while (end < n)  
        { 
            // Keep adding array elements while current sum 
            // is smaller than x 
            while (curr_sum <= x && end < n) 
                curr_sum += arr[end++]; 
  
            // If current sum becomes greater than x. 
            while (curr_sum > x && start < n)  
            { 
                // Update minimum length if needed 
                if (end - start < min_len) 
                    min_len = end - start; 
  
                // remove starting elements 
                curr_sum -= arr[start++]; 
            } 
        } 
        return min_len;


}
