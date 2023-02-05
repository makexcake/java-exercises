/**
 * Represents a segment parallel to the x axis 
 * in the first quadrant.
 * 
 * @author makexcake
 * @version 26/11/2020
 */
public class Segment2
{
    private Point _poCenter;
    private double _length;

    private int DEFAULT_VAL;

    /**
     * Constructs Segment2 object using the center point and length.
     * @param poCenter Point wich is the center of the segment
     * @param length Length of the segment
     */
    public Segment2(Point poCenter, double length)
    {
        //Check that the intire segment will be initiated in the first quadrant
        if(poCenter.getX() - length/2 >= 0)
        {
            _poCenter = new Point(poCenter);
            _length = length; 
        }
        else
        {
            _poCenter = new Point(0,0);
            _length = 0;
        }
        
    }

    /**
     * Constructs Segment2 objects using coordinates of 2 points.
     * @param leftX Left point's x
     * @param leftY Left point's y
     * @param rightX Right point's x 
     * @param rightY Right point's y
     */
    public Segment2(double leftX, double leftY, double rightX, double rightY)
    {
        /*if the given values set the segment outside of the first
        quadrant the segment is set to length 0 and the center point in origin*/
        _poCenter = new Point (0,0);
        _length = DEFAULT_VAL;

        if(leftX >= 0 && leftY >= 0)
        {
            //the X of center point is the average of the left X and right X
            _poCenter.setX((leftX + rightX)/2);
            _poCenter.setY(leftY);

            _length = rightX - leftX;
        }
    }
    
    /**
     * Construnts Segment2 object using two existing points.
     * @param poLeft Left point
     * @param poRight Right point
     */
    public Segment2(Point poLeft, Point poRight)
    {
        /*The segment is horrizintal so its length equals
        * to the difference of left poin's x and right point's x */
        _poCenter = new Point(0,0);
        
        _length = poRight.getX() - poLeft.getX();
        _poCenter.setX(poLeft.getX() + _length/2);
        _poCenter.setY(poLeft.getY());
    }

    /**
     * Copy constructor. Constructs Segment2 object using existing Segment.
     * @param other Existing segment
     */
    public Segment2(Segment2 other)
    {
        //check that object is not null
        if (other != null)
        {
            _poCenter = new Point(other._poCenter);
            _length = other.getLength(); 
        }
    }

    /**
     * Returns segment length.
     * @return Segment's length
     */
    public double getLength()
    {
        return _length;
    }

    /**
     * Returns the left point of the segment.
     * @return Left point
     */
    public Point getPoLeft()
    {
        Point poLeft = new Point(0, 0);
        /*Left point's X value is (segment center - half length) and
        Y value is same as the center point's */       

        poLeft.setX(_poCenter.getX() - _length/2);
        poLeft.setY(_poCenter.getY());
        
        return poLeft;
        
    }

    /**
     * Returns the right point of the segment.
     * @return Right point
     */
    public Point getPoRight()
    {
        /*Right point's X value is (segment center + half length) and
        Y value is same as the center point's */
        Point poRight = new Point(0, 0);

        poRight.setX(_poCenter.getX() + _length/2);
        poRight.setY(_poCenter.getY());

        return poRight;
    }

    /**
     * Returns a string representation og the segment.
     * @return String (leftX, leftY)---(rightY, rightY)
     */
    public String toString()
    {
        return this.getPoLeft().toString() + "---" + this.getPoRight().toString();
    }

    /**
     * Check if the reference segment is equal to this segment.
     * @param other Reference segment
     * @return True if segments are equal
     */
    public boolean equals(Segment2 other)
    {
        //the segments are equal if their instance variables are equal
        return _poCenter.equals(other._poCenter) && _length == other._length;
    }

    /**
     * Check if the reference segment is longer.
     * @param other Reference segment
     * @return True if this segment is longer
     */
    public boolean isBigger(Segment2 other)
    {
        return _length > other._length;
    }

    /**
     * Check if this segment is above the reference segment.
     * @param other Reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment2 other)
    {
        return _poCenter.isAbove(other._poCenter);
    }

    /**
     * Check if this segment is under the reference segment.
     * @param other Reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment2 other)
    {
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of the reference segment.
     * @return True if this segment is left of the reference segment
     */
    public boolean isLeft(Segment2 other)
    {
        return this.getPoRight().getX() < other.getPoLeft().getX();
    }

    /**
     * Check if this segment is right of the reference segment.
     * @return True if this segment is right of the reference segment
     */
    public boolean isRight(Segment2 other)
    {
        return other.isLeft(this);
    }
    /**
     * Check if the point is located on segment.
     * @param p Point object
     * @return True fi the point is on the segment
     */
    public boolean pointOnSegment(Point p)
    {        
        //true if the point's x between leftx and right x and y is equal to left y
        return this.getPoLeft().getX() <= p.getX() && p.getX() <= this.getPoRight().getX() && p.getY() == this.getPoLeft().getY();
    }

    /**
     * Move the segment horizontally by delta.
     * @param delta Delta
     */
    public void moveHorizontal(double delta)
    {
        //check that the segment will stay in the first quadrant
        if (this.getPoLeft().getX() + delta >= 0)
        {
            _poCenter.move(delta, 0);
        }
    }

    /**
     * Move the segment vertically by delta.
     * @param delta Delta
     */
    public void moveVertical(double delta)
    {
        //check that the segment will remain in first quadrant
        if (_poCenter.getY() + delta >= 0)
        {
            _poCenter.move(0, delta);
        }
    }

    /**
     * Change the size of segment by delta.
     * @param delta Delta
     */
    public void changeSize(double delta)
    {
        /*check that length change will not drive the left side of the segment
        out of the first quadrant*/
        if (this.getPoRight().getX() + delta >= this.getPoLeft().getX())
        {
            _poCenter.move(delta/2,0);
            _length += delta;
        }
    }

    /**
     * Calculate the trapeze perimiter wich consists of two segments.
     * @param other Reference segment
     * @return Trapeze perimiter
     */
    public double trapezePerimeter(Segment2 other)
    {
        //get the length of left rib and the right rib
        double leftRib = this.getPoLeft().distance(other.getPoLeft());
        double rightRib = this.getPoRight().distance(other.getPoRight());

        //return the sum of the ribs (perimiter)
        return _length + other._length + leftRib + rightRib;
    }

    /**
     * Calculates the ovrlap between two segments (on x axis)
     * @return Overlap size
     */
    public double overlap(Segment2 other)
    {
        //segments are not overlapping
        if (this.isLeft(other) || this.isRight(other))
        {
            return 0;
        }
        //segments are equal
        else if(this.equals(other))
        {
            return _length;
        }
        //this segment inside other
        else if(this.getPoLeft().getX() >= other.getPoLeft().getX() && this.getPoRight().getX() <= other.getPoRight().getX())
        {
            return _length;
        }
        //other segment inside this segment
        else if(this.getPoLeft().getX() <= other.getPoLeft().getX() && this.getPoRight().getX() >= other.getPoRight().getX())
        {
            return other._length;
        }
        //partially overlaping on right side of this segment
        else if(this.getPoLeft().getX() < other.getPoLeft().getX() && this.getPoRight().getX() <= other.getPoRight().getX())
        {
            return this.getPoRight().getX() - other.getPoLeft().getX();
        }
        //partially overlaping on left side of this segment (last possible option)
        else 
        {
            return other.getPoRight().getX() - this.getPoLeft().getX();
        }
        
    }
}
