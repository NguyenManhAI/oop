import java.util.*;

/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/

public class Shape {
    private List<Point> shape = new ArrayList<>();
    private double central;
    List<Point> getshape()
    {
        return this.shape;
    }
    public Shape(List<Double> lst)
    {
        int n=lst.size();
        for(int i=0;i<n-1;i+=2)
        {
            Point p=new Point(lst.get(i),lst.get(i+1));
            this.shape.add(p);
            p=null;
        }
    }
    private Point Central(List<Point> a)
    {
        double x=0,y=0;
        for(Point i : a)
        {
            x+=i.getX();
            y+=i.getY();
        }
        x/=a.size();
        y/=a.size();
        Point s= new Point(x,y);
        return s;
    }
    private double Radian(List<Point> a,Point c)
    {
        double min= a.get(0).distance(c);
        for(Point i : a)
        {
            if(i.distance(c)<min)
            {
                min=i.distance(c);
            }
        }
        return min;
    }
    boolean cross(Shape b)
    {
        Point c=Central(b.getshape());
        double r=Radian(b.getshape(),c);
        boolean in=false;
        boolean out=false;
        for(Point i : this.shape)
        {
            if(c.distance(i)<=r)
            {
                in=true;
            }
            else
            {
                out=true;
            }
        }
        if(in && out) return true;
        else return false;
    }
    int encircle(Shape b)
    {
        Point cb=Central(b.getshape());
        double rb=Radian(b.getshape(),cb);
        Point ca=Central(this.getshape());
        double ra=Radian(this.getshape(),ca);
        //tam dg tron cua b nam ben trong dg tron a
        if(ca.distance(cb)<=ra)
        {
            return 2;
        }
        else if (ra+rb>=ca.distance(cb) )
        {
            return 1;
        }
        else return 0;
    }
}

