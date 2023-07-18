import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

public class PhysicsEngine {
    
    ArrayList<PhysicalItem> items;

    private double gravity = 0.3;
    private double speedLimit = 0.01;

    int maxX = 1280;
    int maxY = 720;
    int minX = 0;
    int minY = 0;

    double energyConstant = 0.2;

    public PhysicsEngine() {
        items = new ArrayList<PhysicalItem>();
    }

    public void addItem(PhysicalItem comingItem){
        items.add(comingItem);
    }

    public void drawScreen(Graphics g){
        Iterator<PhysicalItem> it = items.iterator();
            while(it.hasNext()){
                PhysicalItem i = it.next();
                i.drawScreen(g);
            }
    }

    public void refresh(double constant){
        Iterator<PhysicalItem> it = items.iterator();
            while(it.hasNext()){
                PhysicalItem i = it.next();

                i.x = i.x + i.vx * constant;
                i.y = i.y + i.vy * constant;
        
                i.vx = i.vx * 0.999;        //Friction forces
                i.vy = i.vy * 0.999;
        
                if(i.x >= maxX - i.w){
                    i.vx = i.vx - (i.m * constant) * energyConstant;;
                    if(i.vx < speedLimit){
                    i.vx = 0;
                }
                    i.x = maxX - i.w;       //When ball reaches end turn back with negaive vectorel velocity
                    i.vx = -i.vx;
                }
                else if(i.x <= minX){
                    i.vx = i.vx + (i.m * constant) * energyConstant;
                    if(i.vx >= -speedLimit){
                    i.vx = 0;
                    }
                    i.x = minX;
                    i.vx = -i.vx;
                }
                if(i.y > maxY - i.h){
                    i.vy = i.vy - (i.m * constant) * energyConstant;
                    i.y = maxY - i.h; 
                    if(i.vy <= speedLimit){
                        i.vy = 0;
                        i.vx = i.vx * 0.09; //if ball is on the ground, will have more friction for x axis
                    }
                    else if(i.y <= minY){
                        i.vy = i.vy + gravity * constant;       //V = V0 + a x t
                        i.vy = -i.vy;
                        i.y = minY;
                    }         
                    else{
                        i.vy = i.vy - gravity * constant;
                        i.vy  = -i.vy;
                    }
                }
                else{
                    i.vy = i.vy + gravity * constant;
                }
            }
    }
}