class Segment1TestRun
{
    public static void main(String[]args)
    {
        System.out.println("***********************************************");
        Point p1 = new Point(1,1);
        Point p2 = new Point(5,2);

        Segment1 s1 = new Segment1(p1, p2);
        Segment1 s2 = new Segment1(1, 1, 5, 2);
        Segment1 s3 = new Segment1(s1);
        
        System.out.println("(1.0,1.0)---(5.0,1.0) Test constructor1: " + s1.toString());
        System.out.println("(1.0,1.0)---(5.0,1.0) Test constructor2: " + s2.toString());
        System.out.println("(1.0,1.0)---(5.0,1.0) Test copy constructor2: " + s3.toString());
        s1.moveHorizontal(1); 
        s1.moveVertical(1); //s1 = (2.0,2.0)---(6.0,2.0)
        System.out.println("(1.0,1.0)---(5.0,1.0) Test ALIASING: " + s3.toString());
        System.out.println("(2.0,2.0)---(6.0,2.0) Test move: " + s1.toString());
        s1.changeSize(1); //s1 = (2.0,2.0)---(7.0,2.0)
        System.out.println("(2.0,2.0)---(7.0,2.0) Test changeSize: " + s1.toString());
        System.out.println("(~5) Test getLength: " + s1.getLength());
        System.out.println("(2.0,2.0) Test getPoLeft: " + s1.getPoLeft());
        System.out.println("(7.0,2.0) Test getPoRight: " + s1.getPoRight());

        //================COMPARE===================//
        System.out.println("***********************************************");

        Segment1 s5 = new Segment1(p1, p2);
        Segment1 s6 = new Segment1(s5);
        System.out.println("(1.0,1.0)---(5.0,1.0) Test : " + s5.toString());
        System.out.println("(1.0,1.0)---(5.0,1.0) Test : " + s6.toString());

        System.out.println("(true) Test equal: " + s5.equals(s6));
        s6.changeSize(1);
        System.out.println("(false) Test equal: " + s5.equals(s6));
        s6.changeSize(-1);
        System.out.println("(true) Test equal: " + s5.equals(s6));

        s6.moveVertical(1); //s6 = (1.0,2.0)---(5.0,2.0)
        System.out.println("(true) Test isAbove: " + s6.isAbove(s5));
        System.out.println("(false) Test isUnder: " + s6.isUnder(s5));
        System.out.println("(false) Test isAbove: " + s5.isAbove(s6));
        System.out.println("(true) Test isUnder: " + s5.isUnder(s6));

        s6.moveHorizontal(10); // s6 = (11.0,2.0)---(15.0,2.0)
        System.out.println("(true) Test isRight: " + s6.isRight(s5));
        System.out.println("(false) Test isLeft: " + s6.isLeft(s5));

        s6.changeSize(1);
        System.out.println("(true) Test isBigger: " + s6.isBigger(s5));
        System.out.println("(false) Test isBigger: " + s5.isBigger(s6));
        
        Point p5 = new Point(12, 2);
        System.out.println("(true) Test pointOnSegment: " + s6.pointOnSegment(p5));
        p5.move(0, -1);
        System.out.println("(false) Test pointOnSegment: " + s6.pointOnSegment(p5));
        p5.move(0, 1);
        System.out.println("(true) Test pointOnSegment: " + s6.pointOnSegment(p5));

        
        //================CALCULATE===================//
        System.out.println("***********************************************");

        //trapeze test
        Segment1 s10 = new Segment1(2, 2, 12, 2);
        Segment1 s11 = new Segment1(2, 0, 12, 0);
        Segment1 s12 = new Segment1(13, 2, 15, 2);
        System.out.println("(~24) Test trapezePerimeter: " + s11.trapezePerimeter(s10));

        //test overlap
        System.out.println("(~10) Test overlap: " + s10.overlap(s11));
        s10.moveHorizontal(2);
        System.out.println("(~8) Test overlap: " + s10.overlap(s11));
        System.out.println("(0.0) Test overlap: " + s11.overlap(s12));
    }
}