/**
 * Represents a segment parallel to the x axis
 * in the first quadrant.
 * 
 * @author makexcake 
 * @version 26/11/2020
 */
public class Segment1
{
    private Point _poLeft;
    private Point _poRight;

    /**
     * Initialize Segment1 object using two existing points.
     * @param poLeft Left point of segment
     * @param poRight Right point of segment 
     */
    public Segment1(Point poLeft, Point poRight)
    {
        _poLeft = new Point(poLeft); 

        //Right point's y set by the left point's y
        _poRight = new Point(poRight);
        _poRight.setY(_poLeft.getY());
    }

    /**
     * Constructs Segment2 objects using coordinates of 2 points
     * @param leftX Segment's left x 
     * @param leftY Segment's left y
     * @param rightX Segment's right x
     * @param rightY Segment's right y
     */

    public Segment1(double leftX, double leftY, double rightX, double rightY)
    {
        _poLeft = new Point(leftX, leftY);
        _poRight = new Point(rightX, leftY); //use left's Y value as reference.
    }

    /**
     * Copy constructor. Creating segment object based on existing Segment1 object.
     * @param other Other segment
     */
    public Segment1(Segment1 other)
    {
        if(other != null) //check if other object is not empty
            _poLeft = new Point (other._poLeft);
            _poRight = new Point (other._poRight);
    }

    /**
     * String representation of the segment.
     * @return (left point) --- (right point)
     */
    public String toString()
    {
        return _poLeft.toString() + "---" + _poRight.toString();
    }
    
    /**
     * Gets segment's left point.
     * @return Segment's left point
     */
    public Point getPoLeft()
    {
        return _poLeft;
    }
    
    /**
     * Gets segment's left point.
     * @return Segment's left point
     */
    public Point getPoRight()
    {
        return _poRight;
    }

    /**
     * Check if the point is on segment.
     * @return True if the point is on this segment
     */
    public boolean pointOnSegment(Point p)
    {       
        //true if the point's x between leftx and right x and y is equal to left y
        return _poLeft.getX() <= p.getX() && p.getX() <= _poRight.getX() && p.getY() == _poLeft.getY();
    }

    /**
     * Gets segment's length.
     * @return Length of the segment
     */
    public double getLength()
    {
        return _poLeft.distance(_poRight);
    }

    /**
     * Check if two segments are equal.
     * @param other Other segment
     * @return True if both segments got same points
     */
    public boolean equals (Segment1 other)
    {
        return (_poLeft.equals(other.getPoLeft()) && _poRight.equals(other.getPoRight()));
    }

    /**
     * Compare length between two segments.
     * @param other Other segment
     * @return True if this segment is longer than other.
     */
    public boolean isBigger(Segment1 other)
    {
        return this.getLength() > other.getLength();
    }
    
    /**
     * Check if this segment is above the reference segment.
     * @param other Reference segment
     * @return True if this segment is above the reference segment
     */
    public boolean isAbove(Segment1 other)
    {
        /**
         * check if left point of other segment is under
         * the left point of this segment.
         */
        return other._poLeft.isUnder(_poLeft);
    }

    /**
     * Check if this segment is under the reference segment.
     * @param other Reference segment
     * @return True if this segment is under the reference segment
     */
    public boolean isUnder(Segment1 other)
    {
        //check if other segment is above this
        return other.isAbove(this);
    }

    /**
     * Check if this segment is left of the refrence segment.
     * @param other Other segment
     * @return True if this segment is left of reference segment
     */
    public boolean isLeft(Segment1 other)
    {
        /*check if this segment's right point is left of the other
        segment's left point */ 
        return _poRight.isLeft(other._poLeft);
    }
    /**
     * Check if this segment is right of the reference segment.
     * @param other Other segment
     * @return True if this segment is right of the reference segment
     */
    public boolean isRight(Segment1 other)
    {
        //check if the other segment is left of this segment
        return other.isLeft(this);
    }

    /**
     * Calculates overlap of two segments on x axis.
     * @param other Reference segment
     * @return The overlaping length
     */
    public double overlap(Segment1 other)
    {
        //segments are not overlapping
        if (this.isLeft(other) || this.isRight(other))
        {
            return 0;
        }
        //segmens are equal
        else if (this.equals(other))
        {
            return this.getLength();                                
        }
        //this segment inside other
        else if (_poLeft.getX() >= other._poLeft.getX() && _poRight.getX() <= other._poRight.getX())
        {
            return this.getLength();
        }
        //other segment inside this segment
        else if (_poLeft.getX() <= other._poLeft.getX() && _poRight.getX() >= other._poRight.getX())
        {
            return other.getLength();
        }
        //partially overlaping on right side of this segment
        else if (_poLeft.getX() < other._poLeft.getX() && _poRight.getX() <= other._poRight.getX())
        {
            return _poRight.getX() - other._poLeft.getX();
        }
        //partially overlaping on left side of this segment (last possible option)
        else
        {
            return other._poRight.getX() - _poLeft.getX();
        }
    }

    /**
     * Calculate the perimiter of trapeze made of two segments.
     * @param other Other segment
     * @return Perimiter of trapeze
     */
    public double trapezePerimeter(Segment1 other) 
    {
        return _poLeft.distance(other._poLeft) + _poRight.distance(other._poRight) + this.getLength() + other.getLength();
    }

    /**
     * Move the segment horrizontaly.
     * @param delta Distance to move horrizontaly
     */
    public void moveHorizontal(double delta)
    {
        if (_poLeft.getX() + delta >= 0)
        {
            _poLeft.move(delta, 0);
            _poRight.move(delta, 0);
        }
    }

    /**
     * Move the segment verticaly.
     * @param delta Distance to move verticaly
     */
    public void moveVertical(double delta)
    {
        if (_poLeft.getY() + delta >= 0)
        {
            _poRight.move(0, delta);
            _poLeft.move(0, delta);
        }
    }

    /**
     * Changes the size of the segment.
     * @param delta Size to be added or subtracted
     */
    public void changeSize(double delta)
    {
        //check that the right point will not get left of the left point
        if (delta + _poRight.getX() >= _poLeft.getX())
        {
            _poRight.move(delta, 0);
        }
    }
}
