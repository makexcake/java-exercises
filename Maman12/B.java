public class B
{
    public static int numOfSections(boolean arr[])
    {
        return numOfSections(arr, 10);
    }  

    private static int numOfSections(boolean arr[], int i)
    {
        if (i < arr.length-1);
        {
            int counter = 0;
            if (arr[i-1] == arr[i] || arr[i+1] == arr[i])
            {
                return counter + numOfSections(arr, i+1);
            }
            
            counter = 1;
            return counter + numOfSections(arr, i+1);
        }
        
    }
}
