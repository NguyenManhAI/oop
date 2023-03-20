import org.w3c.dom.Text;

import java.util.Collections;
import java.util.Vector;

public  class TextGraphics
{

    private static TextGraphics instance;
    private Vector<Vector<Character>> screen;
    private TextGraphics()
    {
        screen = new Vector<>(new Vector<>());
    }
    public static TextGraphics getInstance()
    {
        if(instance==null)
        {
            instance = new TextGraphics();
        }
        return instance;
    }
    public Vector<Vector<Character>> getscreen()
    {
        return screen;
    }
    public void init(int width,int height)
    {
        screen.setSize(width);
        Vector<Character> cpy = new Vector<>();
        cpy.setSize(height);
        for(int i=0;i<height;i++)
        {
            cpy.set(i,' ');
        }
        for(int i=0;i<width;i++)
        {
            screen.set(i,cpy);
        }
    }
    public void render()
    {
        int m=screen.size();
        int n=screen.get(0).size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(screen.get(i).get(j));
            }
            System.out.print('\n');
        }
    }
    public void drawPoint(char c,int x,int y)
    {
        int n= screen.get(x).size();
        Vector<Character> cpy= new Vector<>(n);
        for(int i=0;i<n;i++)
        {
            cpy.add(screen.get(x).get(i));
        }
        cpy.set(y,c);
        screen.set(x,cpy);
    }
    public void drawLine(char c,int x1,int y1,int x2,int y2)
    {

    }
    public void fillRect(char c,int x,int y,int width,int height)
    {
        for(int i=0;i<width;i++)
        {
            for(int j=0;j<height;j++)
            {
                drawPoint(c,x+i,y+j);
            }
        }
    }
    public static void main(String[] args)
    {
        TextGraphics graphics = new TextGraphics();
        graphics.init(15, 10);
        graphics.drawPoint('*', 1,1);
        graphics.fillRect('o', 5, 5, 3, 2);
        graphics.render();
    }
}