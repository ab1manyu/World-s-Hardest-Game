import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;

public class Enemy{
	private int x;
	private int y;
	private int w;
	private int h;
	private boolean d;
	private Polygon p;

	public Enemy(int x, int y, int w, int h, boolean d, Polygon p){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.d=d;
		this.p=p;
	}
	public void move(){
		if(d){
			if(p.contains(new Rectangle(x+2,y,w,h)))
				x+=1;
			else
				d=false;
		}
		else{
			if(p.contains(new Rectangle(x-2,y,w,h)))
				x-=1;
			else
				d=true;
			}
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setY(int a)
	{
		y+=a;
	}
	public int getW(){
		return w;
	}
	public int getH(){
		return h;
	}
	public boolean getD(){
		return d;
	}
	public void setD(boolean a){
		d=a;
	}
	public Polygon getPoly(){
		return p;
	}
}