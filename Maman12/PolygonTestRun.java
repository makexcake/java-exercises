public class PolygonTestRun 
{
    public static void main(String[]args)
    {
        Polygon poly2 = new Polygon();

        Polygon poly1 = new Polygon();
        
        poly1.addVertex(1, 1);//p1
        Point p1 = new Point(1,1);

        poly1.addVertex(1, 4);//p2
        Point p2 = new Point(1,4);

        poly1.addVertex(5, 4);//p3
        Point p3 = new Point(5,4);

        poly1.addVertex(5, 1);//p4
        Point p4 = new Point(5,1);

        Point pNone = new Point(100,100);

//////////////////////////////////////////////////////
        Polygon poly3 = new Polygon();
        poly3.addVertex(1, 1);
        Point p5 = new Point(1,1);        
//////////////////////////////////////////////////////

        System.out.println("Test toString: \n\n" + poly1.toString() + "\n");
        System.out.println("(~14) Test calcPerimiter: " + poly1.calcPerimeter()); 
        System.out.println("(~12) Test calcArea: " + poly1.calcArea()); 
        System.out.println("(0) Test findVertex: " + poly1.findVertex(new Point(1,1)));
        System.out.println("(3) Test findVertex: " + poly1.findVertex(new Point(5,1)));
        System.out.println("(-1) Test findVertex: " + poly1.findVertex(new Point(8,4)));
        System.out.println("(-1) Test findVertex: " + poly2.findVertex(new Point(8,4)));

        System.out.println("(1,1) Test nextVertex: " + poly3.getNextVertex(p5).toString());

        //p1 -> p2
        System.out.println("(1,4) Test nextVertex: " + poly1.getNextVertex(p1).toString());
        //p2 -> p3
        System.out.println("(5,4) Test nextVertex: " + poly1.getNextVertex(p2).toString());
        //p3 -> p4
        System.out.println("(5,1) Test nextVertex: " + poly1.getNextVertex(p3).toString());
        //p4 -> p1
        System.out.println("(1,1) Test nextVertex: " + poly1.getNextVertex(p4).toString());
        //NULL ERROR IF TEST PASS
        //System.out.println("(null) Test nextVertex: " + poly1.getNextVertex(pNone).toString());

        
        /**********************************************/    
        
        Polygon poly10 = new Polygon();
        poly10.addVertex(5, 3);        
        poly10.addVertex(5, 1);
        poly10.addVertex(1, 1);
        poly10.addVertex(1, 3);
        poly10.addVertex(3, 5);


        System.out.println("(1,1) Test highestVertex: " + poly3.highestVertex().toString());
        System.out.println("(1,4) Test highestVertex: " + poly1.highestVertex().toString());
        System.out.println("(3,5) Test highestVertex: " + poly10.highestVertex().toString());

        System.out.println("(12) Test CalcArea: " + poly1.calcArea());
        System.out.println("(<12) Test CalcArea: " + poly10.calcArea());

        System.out.println("(true) Test isBigger: " + poly1.isBigger(poly10));
        System.out.println("(false) Test isBigger: " + poly10.isBigger(poly1));

        Polygon poly11 = new Polygon();
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(true) Test addVertex: " + poly11.addVertex(10, 10));
        System.out.println("(false) Test addVertex: " + poly11.addVertex(10, 10));

        //BOUNDING BOX  
        System.out.println("Test Bounding box: " + poly10.getBoundingBox().toString());

        Polygon poly20 = new Polygon();
        poly20.addVertex(2.0, 1.0);
        poly20.addVertex(5.0, 0.0);
        poly20.addVertex(7.0, 5.0);
        poly20.addVertex(4.0, 6.0);
        poly20.addVertex(1.0, 4.0);
        System.out.println("Test Bounding box: \n" + poly20.getBoundingBox().toString());
        System.out.println(1 + "" + 1);

        Object a = new Point(1,1);
        Object a2 = a;
        Point a3 = (Point)a;

        System.out.println(a.toString());


    }
}
