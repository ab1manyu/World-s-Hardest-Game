import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class VEnemy extends Enemy{
	public VEnemy(int x, int y, int w, int h, boolean d, Polygon p){
		super(x,y,w,h,d,p);
	}
	public void move(){
		if(getD()){
			if(getPoly().contains(new Rectangle(getX(),getY()+2,getW(),getH())))
				setY(2);
			else
				setD(false);
		}
		else{
			if(getPoly().contains(new Rectangle(getX(),getY()-2,getW(),getH())))
				setY(-2);
			else
				setD(true);
		}
	}

}