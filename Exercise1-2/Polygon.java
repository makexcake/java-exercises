/**
 * Represents a polygon with up to 10 vertices 
 * on two diemtional plane.
 * 
 * @author makexcake
 * @version 05/12/2020
 */

public class Polygon 
{
    private final int MAX_VERTICES = 10;

    private Point[] _vertices;
    private int _noOfVertices;

    /**
     * Create a polygon object.
     */
    public Polygon()
    {   
        _vertices = new Point[10];
        _noOfVertices = 0;
    }

    /**
     * Add vertex to existing polygon.  
     * @param x X value of vertex
     * @param y Y value of vertex
     * @return True if vertex added succsessfuly
     */
    public boolean addVertex(double x, double y)
    {
        //check that maximum number of points is not exceeded
        if (_noOfVertices + 1 <= MAX_VERTICES)
        {
            _noOfVertices++;
            _vertices[_noOfVertices-1] = new Point(x,y);           
            return true;
        }
        return false;
    }
    
    /**
     * String representation of the polygon.
     * @return String representation of polygon's vertexes
     */
    public String toString()
    {   
        if (_noOfVertices > 0)
        {
            //to not print a comma in the start of the string
            String toString = new String ("(" + _vertices[0]);

            for(int i = 1; i < _noOfVertices; i++)
            {
                toString = toString +  "," + _vertices[i].toString();
            }
            toString += ")";
            
            return "The polygon has " + _noOfVertices + " vertices:\n" + toString;
        }
        return "The polygon has 0 vertices.";
    }

    /**
     * Calculate polygon's perimeter.
     * @return Polygon's perimeter
     */
    public double calcPerimeter()
    {
        //in case there is only one point or less the perimiter is 0
        if (_noOfVertices > 1)
        {
            //distance from LAST point to FIRST point
            double perimeter = _vertices[_noOfVertices-1].distance(_vertices[0]);
            
            //in case there are more than 2 points
            if (_noOfVertices > 2)
            {
                //distances between all points EXCEPT BETWEEN FIRST AND LAST
                for(int i = 0; i < _noOfVertices - 1;i++)
                {                      
                    perimeter = perimeter + _vertices[i].distance(_vertices[i+1]);
                }
            }
            return perimeter;
        }   
        return 0;
    }

    /**
     * Calculate polygon's area.
     * @return polygons area
     */
    public double calcArea()
    {
        //if polygon contains less then 3 points it isn't a poligon and has no area.
        if (_noOfVertices > 2)
        { 
            /*To calculate the area we will devide the polygon to triangles.
            The triangles consist will always consist of the vertex indexed 0
            and from points indexed i, i+1 (when starting i == 1 and last 
            i == number of vertexes - 2) */ 

            double area = 0;

            for (int i = 1; i < _noOfVertices -1; i++)
            {
                area = area + triangleArea(_vertices[0], _vertices[i], _vertices[i+1]);
            }

            return area;
        }
        return 0;
    }


    /*Private method that calculates area of triangle using 3 point objects
    and Heron's formula */ 
    private double triangleArea(Point p1, Point p2, Point p3)
    {
        //triangle perimiter
        double halfPer = (p1.distance(p2) + p2.distance(p3) + p3.distance(p1))/2;

        //calculate triangle area using Heron's formula
        double area = Math.sqrt(halfPer * (halfPer - p1.distance(p2))*
                   (halfPer - p2.distance(p3)) * (halfPer - p3.distance(p1)));                                                                             
        
        return area;
    }
    //End of private method.


    /**
     * Finds the polygon's highest vertex relative to 
     * other vertecies of this polygon.
     * @return Highest vertex
     */
    public Point highestVertex()
    {
        //if there are no vertices in polygon return null
        if (_noOfVertices > 0)
        {
            //set the first vertex as hightest
            Point highest = _vertices[0];

            //compare all the points with the current point in "highest"
            for (int i = 1; i < _noOfVertices; i++)
            {
                //if vertex is above the vertex in "highest" assight it as "highest"
                if (_vertices[i].isAbove(highest))
                {
                    highest = _vertices[i];
                }
            }
            return new Point (highest);
        }
        return null;
    }

    /**
     * Gets next vertex on the polygon that placed next
     * to entered point.    
     * @param p Polygon's existing vertex
     * @return Next vertex in the array, returns -1 if the vertex does not exist
     */
    public Point getNextVertex(Point p)
    {
        //if point does not exist return null
        if (findVertex(p) != -1)
        {            
            //NOTE: in case there is only one point, it is the first and the last point
            //if the point is the last point in array return the first point
            if (findVertex(p) == _noOfVertices - 1)
            {
                return new Point(_vertices[0]);
            }
            //if the point isn't last return the next point in array
            return new Point(_vertices[findVertex(p) + 1]);
        }
        return null;
    }

    /**
     * Find's the location of entered point in polygon's points array.
     * @param p Point
     * @return Point's location in array or -1 if the point isn't in array
     */
    public int findVertex(Point p)
    {
        //compare the point with points in the polygon
        for (int i = 0; i < _noOfVertices; i++)
        {
            //when point found return it's index
            if (p.equals(_vertices[i]))
            {
                return i;
            }
        }
        //if point not found return -1
        return -1;
    }

    /**
     * Compare areas of two polygons.
     * @param other Other polygon
     * @return True if the area on this poligon is bigger
     */
    public boolean isBigger(Polygon other)
    {
        return this.calcArea() > other.calcArea();
    }

    /**
     * Get bounding box of the polygon.
     * @return Boynding pox polygon
     */
    public Polygon getBoundingBox()
    {
        if (_noOfVertices > 2)
        {
            /*To find the bounding box of the polygon we need to know the
            values of leftest x, rightest x, highest x and the lowest X.
            Afterwards make polygon with the 4 vertices with the values 
            that we found. */

            double leftX , rightX, upY, downY;
            Polygon box = new Polygon();

            //find highest y value
            upY = this.highestVertex().getY();

            //find lowest y value
            downY = _vertices[0].getY();

            for (int i = 1; i < _noOfVertices; i++)
            {
                downY = Math.min(downY, _vertices[i].getY());
            }

            //find left X value
            leftX = _vertices[0].getX();

            for (int i = 1; i < _noOfVertices; i++)
            {
                leftX = Math.min(leftX, _vertices[i].getX());
            }

            //find right X value
            rightX = _vertices[0].getX();

            for (int i = 1; i < _noOfVertices; i++)
            {
                rightX = Math.max(rightX, _vertices[i].getX());
            }

            //add the vertecies to the polygon
            box.addVertex(leftX, downY);
            box.addVertex(rightX, downY);
            box.addVertex(rightX, upY);
            box.addVertex(leftX, upY);
            
            return box;
        }
        return null;
    }

}
