/**
 * Represents a point in polar system in the
 * first quadrant.
 * 
 * @author Vitaly Nudelman 320734346
 * @version 25/11/2020
*/
public class Point
{    
    private final int DEFAULT_VAL = 0;   
    
    private double _radius; //radius of vecr
    private double _alpha; //angle of vector   
    
    /**
     * Initialize point object in polar system.
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point(double x, double y)
    {
        /*The constructor uses set x and set y method that are written down
        below. These methods are checking legality of entered values. */
        _radius = 0;
        _alpha = 0;
        setX(x);
        setY(y);
    }
    
    /**
     * Initialize point object based on existing point.
     * @param other Existing point object.
     */
    public Point(Point other)
    {
        if (other != null) //check if the object is not empty
        {            
            _radius = other._radius;
            _alpha = other._alpha;
        }
    }

    /**
     * Returns point's x value.
     * @return  point's x
     */
    public double getX()
    {
        //convert alpha to radians and calculate x and round to 4 digits
        return Math.round(_radius * Math.cos(Math.PI / 180 * _alpha)*1000)/(double)1000;
    }

    /**
     * Returns point's y value.
     * @return point's y
     */
    public double getY()
    {
        //convert alpha to radians and calculate y and round to 4 digits
        return Math.round(_radius * Math.sin(Math.PI / 180 * _alpha)*1000)/(double)1000;
    }

    /**
     * Returns point's coordinate rounded for 4 digits.
     * @return String representation of the point
     */
    public String toString()
    {
        return "(" + getX() + "," + getY() + ")";
    }

    /**
     * Checks if this point is above the other point.
     * @param other Other point
     * @return True if this point is above the other point
     */
    public boolean isAbove(Point other)
    {
        return this.getY() > other.getY(); 
    }
    
    /**
     * Checks if this point is under the other point.
     * @param other Other point 
     * @return True if this point is under the other
     */
    public boolean isUnder(Point other)
    {
        //this point is under other if other point is above this
        return other.isAbove(this);
    }

    /**
     * Checks if this point is left of the other point.
     * @param other Other point 
     * @return True if this point is left of the other point
     */
    public boolean isLeft(Point other)
    {
        return this.getX() < other.getX();
    }

    /**
     * Checks if this point is right of the other point.
     * @param other Other point 
     * @return True if this point is right of the other point
     */
    public boolean isRight(Point other)
    {
        //This point is left of the other if other is right of this point
        return other.isLeft(this);
    }

    /**
     * Checks equality of two points coordinates.
     * @param other Other point
     * @return True if the points are equal
     */
    public boolean equals(Point other)
    {
        //the points equal if there x and y values are same
        return this.getX() == other.getX() && this.getY() == other.getY();
    }

    /**
     * Calculate distance between two points.
     * @param other Other point
     * @return Distance between two points
     */
    public double distance(Point other)
    {
        double a = this.getY() - other.getY(); //y1 - y2
        double b = this.getX()- other.getX(); // x1 - x2
        
        //sqrt((y1 - y2)^2 + (x1 - x2)^2)
        return Math.sqrt(Math.pow(a,2) + Math.pow(b,2)); 
    }

    /**
     * Set points x coordinate.
     * @param x New x coordinate
     */
    public void setX(double x)
    {
        //check that the value isn't negative
        if (x > DEFAULT_VAL)
        {
            /*NOTE: after the change of radius the getY method will
            * no longer be valid because the radius changed, thus we need
            * to create temporary variable to contain the value of y 
            * untill the convertion is complete.  */

            double tempY = this.getY(); //set temporary y
            //using pithagoras theoreme to get the radius with the new x
            _radius = Math.sqrt(Math.pow(x, 2) + Math.pow(tempY,2));
            //calculate alpha with the new x and convert to degrees
            _alpha =  (Math.atan(tempY / x) * 180 / Math.PI); 
        }
        else if(x == 0)
        {
            //if x = 0 the point is on y axis
            _radius = this.getY();
            _alpha = 90;
        }
    }

    /**
     * Set point y coordinate.
     * @param y New y coordinate
     */
    public void setY(double y)
    {
        if (y >= DEFAULT_VAL) //check the value isn't negative
        {
            
            /*NOTE: after the change of radius the getX method will
            not be valid because the radius changed, thus we need
            to create temporary variable to contain the value of x 
            untill the convertion is complete. */

            double tempX = this.getX(); //set a temporary x
            //use pithagoras theoreme to calculate radius with new x
            _radius = Math.sqrt(Math.pow(tempX, 2) + Math.pow(y, 2));
            //calculate new alpha and convert to degrees
            _alpha = (Math.atan(y / tempX)) * (180 / Math.PI);
        }
    }
    /**
     * Moves the point by entered units.
     * @param dx Distance to move x
     * @param dy Distance to move y
     */
    public void move(double dx, double dy)
    {
        //Check that the point will not exit the first quadrant
        if (this.getX() + dx >= DEFAULT_VAL && this.getY() + dy >= DEFAULT_VAL)
        {
            this.setX(this.getX() + dx); //add value to point's x
            this.setY(this.getY() + dy); //add value to point's y
        }
    }

}
