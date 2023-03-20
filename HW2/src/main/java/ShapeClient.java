import java.util.*;
import java.util.Scanner;

public class ShapeClient {
    public static void main(String[] args)
    {
        Shape a = new Shape(Arrays.asList(0.0 ,0.0 ,0.0 ,1.0 ,1.0 ,1.0 ,1.0 ,0.0 ));
        Shape b = new Shape(Arrays.asList(10.0 ,10.0 ,10.0 ,11.0 ,11.0 ,11.0 ,11.0 ,10.0));
        Shape c = new Shape(Arrays.asList(0.5 ,0.5 ,0.5 ,-10.0 ,1.5 ,0.0 ));
        Shape d = new Shape(Arrays.asList(0.5 ,0.5 ,0.75 ,0.75 ,0.75 ,0.2 ));
        System.out.println("a " + "crosses " + "b:" + a.cross(b));
        System.out.println("a " + "crosses " + "c:" + a.cross(c));
        System.out.println("a " + "crosses " + "d:" + a.cross(d));
        System.out.println("a " + "encircles " + "b:" + a.encircle(b));
        System.out.println("a " + "encircles " + "c:" + a.encircle(c));
        System.out.println("a " + "encircles " + "d:" + a.encircle(d));
    }
}
