/**
 * @author Vitaly Nudelman 320734346
 * @version 20/01/2021
 * 
 * The program can represent number with more digits
 * than "long" type variable can store.
 */
public class BigNumber 
{
    IntNode _head = null;

    /**
     * Initialize BigNumber object that will represent 0.
     */
    public BigNumber()
    {
        _head = new IntNode(0);
    }

    /**
     * Initialize big number object from "long" type value
     * @param num Desired number to represent
     */
    public BigNumber(long num)
    {
        while (num > 0)
        {
            this.addToEnd(new IntNode((int)(num%10)));

            num = num/10;
        }
    }

    /*private method that adds link to the end of the list.
    with time complexity O(n)*/
    public void addToEnd(IntNode node) //##################CHANGE TO PRIVATRE############
    {
        
        //If there are no digits in the list make the _head as first digit
        if (_head == null)
        {
            _head = node;
            return;
        }

        //create pointer
        IntNode ptr = _head;

        //reach the last node  
        while(node.getNext() != null)
        {
            ptr = ptr.getNext();
        }
        //add the node 
        ptr.setNext(node);
    }

    public void printList()
    {
        _head.printFrom();        
    }
}


