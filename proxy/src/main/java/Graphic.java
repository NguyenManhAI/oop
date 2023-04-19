import java.awt.*;

interface Graphic {
    default void draw(Point position) {}
    default Dimension getExtent(){
        return null;
    }
    default Point getPosition(){
        return null;
    }
    default void handleMouse(Event mouseEvent){}
    default void store(){}
    default void load(String filename){}
}
