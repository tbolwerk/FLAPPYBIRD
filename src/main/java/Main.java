import processing.core.PApplet;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main extends PApplet {
    private int width = 800;
        private static int height = 800;
        private Pipe pipe;
        private Pipe pipe2;

        private Bird bird;

        private float movement=width;

        private boolean up =false;


        private int pipeHeight;

        private float speed = 5;
        private float gravity = 5;

        private List<Pipe> pipes = new CopyOnWriteArrayList<>();


public static void main(String args[]){
    PApplet.main("Main");
}
    public void setup(){
    pipeHeight=height/3;
        pipe= new Pipe(this,width/5,pipeHeight);
        pipe2=new Pipe(this,width/5,pipeHeight);
        bird=new Bird(this,50);
    }
    public void draw(){


        background(0,100,255);
        long millis = millis() % 1000;
        long second = (millis() / 1000) % 60;
        long minute = (millis() / (1000 * 60)) % 60;
        long hour = (millis() / (1000 * 60 * 60)) % 24;
        fill(255);
        textSize(50);

        if(!bird.up){
            if(bird.y<height){
                bird.y=bird.y+gravity;
            }
        }else{
            bird.y=bird.y-90;
            bird.up=false;
        }


        if(movement>-width/5){
            movement=movement-speed;

        }else {
//            Random random = new Random();
//           int n= random.nextInt(4);
//            pipe.setHeight(pipeHeight-n*50);
//            pipe2.setHeight(pipeHeight+n*50);

            movement=width;

        }



        pipe.show(movement,0);
        pipe2.show(movement,height-(height/3));
        bird.show();
        text("Time elapsed:" + hour + ":"  +  minute +":"+ second,0,50);
        colisionDetection();
    }

    public void colisionDetection(){
            if(70>=movement && bird.getRadius()+70<=movement+pipe.getWidth()){
            if(bird.y>=height-pipe2.getHeight() || bird.y<=pipe.getHeight())
           stop();
            }
    }

    @Override
    public void keyReleased() {

            System.out.println("spacebar");
            bird.flap();

    }

    public void settings(){
        size(width,height);
    }



    public static int getHeight() {
        return height;
    }
}
