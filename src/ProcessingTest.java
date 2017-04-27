/**
 * Created by block7 on 4/7/17.
 */

//file:///Users/block7/Downloads/allis1994.pdf
import java.awt.*;
import java.util.*;
import processing.core.*;
import java.awt.color.*;
public class ProcessingTest extends PApplet{

    public static void main(String... args){

        PApplet.main("ProcessingTest");
    }
    class point {
        boolean filled = false;
        int x;
        int y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
////////////////////
    point [][] grid = new point[11][11];
    int turnNumber = 0;
    HashMap<point,Integer> values = new HashMap<>();

///////////////////
    public void setup() {
       size(500,500);
        for(int i=0; i<width; i+=width/10){
            for(int w=0; w<height; w+=height/10) {
                point p = new point(i,w);
                grid[i/50][w/50] = p;
            }
        }

   }


    public void draw() {
       // background(255);
      //  ellipse(10,10,10,10);
        int widthSpace = width/10;
        int heightSpace = height/10;
        for(int i=0; i<width; i+=widthSpace){
            for(int w=0; w<height; w+=heightSpace){
                fill(0,0);
                rect(i,w,width/10,height/10);
            }
        }



    }
    public void mousePressed() {
        int x = mouseX/50;
        int y = (mouseY/50);
        System.out.println(grid[1][1].x);
        int cirx = grid[x][y].x + 25;
        int ciry = grid[x][y].y + 25;


        if(grid[x][y].filled == false) {
            turnNumber++;
            grid[x][y].filled = true;
            if(turnNumber%2 == 1) {
                fill(0);
            }else {
                fill(255,0,0);
            }
            ellipse(cirx, ciry, 45, 45);
            values.put(grid[x][y], turnNumber%2);
            System.out.println(turnNumber%2);
        }

    }

}
