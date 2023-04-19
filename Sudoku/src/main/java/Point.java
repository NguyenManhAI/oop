public class Point {
    public int x;
    public int y;
    public Point(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public Point getPoint(int x,int y)
    {
        return new Point(x,y);
    }
}
