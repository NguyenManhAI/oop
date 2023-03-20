import java.util.Scanner;
import java.util.Vector;

public class Bugs {
    public static void main(String[] args) {
        int N=0,W=0,H=0;
        Scanner src =  new Scanner(System.in);
        N=src.nextInt();
        W= src.nextInt();
        H=src.nextInt();
        TextGraphics bug ;
        bug = TextGraphics.getInstance();
        Vector<Vector<Character>> sc = new Vector<>();
        sc= bug.getscreen();
        for(int i=0;i<N;i++)
        {
            while(true)
            {
                int a= (int) (Math.random()%W);
                int b= (int) (Math.random()%H);
                if(sc.get(a).get(b) == ' ')
                {
                    bug.drawPoint('b',a,b);
                    break;
                }
            }
        }
        for(int i=0;i<W;i++)
        {
            for(int j=0;j<H;j++)
            {
                if(bug.getscreen().get(i).get(j) == 'b')
                {
                    while(true)
                    {
                        int a= (int) (Math.random()%2);
                        int b= (int) (Math.random()%2);
                        if((a!=0 || b!=0) && bug.getscreen().get(i+a).get(j+b) != 'b')
                        {
                            bug.drawPoint('b',i+a,j+b);
                            bug.drawPoint(' ',i,j);
                        }
                    }
                }
            }
        }
    }
}