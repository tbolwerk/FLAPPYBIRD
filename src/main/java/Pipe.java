import processing.core.PApplet;

public class Pipe {
    private PApplet app;
    private int width;
   private int height;


    public Pipe(PApplet app, int width, int height){
        this.app=app;
        this.width=width;
        this.height=height;
    }

    public void show(float x, float y){
        app.fill(0,255,0);
        app.rect(x,y,width,height);
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }
}
