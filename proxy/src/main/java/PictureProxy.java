import java.awt.*;

public class PictureProxy implements Graphic {
    private String filename;
    private picture pic;
    private Dimension extent;
    private Point position;
    private picture Picture;
    public PictureProxy()
    {

    }
    public picture getPicture(){
        load(filename);
        pic = new picture(filename);
        return pic;
    }
}
