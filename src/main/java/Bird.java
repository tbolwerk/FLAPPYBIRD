import processing.core.PApplet;

public class Bird {
    private PApplet app;
    public float y;
    private int radius;
    public boolean up;


    public Bird(PApplet app,int radius){
        this.app=app;
        this.radius=radius;
        this.y=0;
    }

    public void show(){

        app.fill(255,0,0);
        app.ellipse(70,y,radius,radius);

    }


    public void flap() {
        up=true;
    }

    public int getRadius() {
        return radius;
    }
}
