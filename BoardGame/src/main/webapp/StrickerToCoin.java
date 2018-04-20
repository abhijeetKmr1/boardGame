package Service;

public class StrickerToCoin {
  // line equation ax+by=c and circle equattion would be x^2+y^2=radius center 
  static void checkforcollision (int a,int b,int c,int x ,int y, int radius  )
  {
    // Finding the distance of line from center.
        double dist = (Math.abs(a * x + b * y + c)) / 
                        Math.sqrt(a * a + b * b);
     
        // Checking if the distance is less than, 
        // greater than or equal to radius.
        if (radius == dist)
            System.out.println ( "StrickerCollideWithCoin" );
        else if (radius > dist)
            System.out.println( "StrickerCollideWithCoin") ;
        else
            System.out.println( "NoCollisionHappen") ;
    }
     
    // Driven Program
    public static void main (String[] args) 
    {
        int radius = 5;
        int x = 0, y = 0;
        int a = 3, b = 4, c = 25;
        checkforCollision(a, b, c, x, y, radius);
     
    }
  
}
