import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class EndOfYearProjectStarterCode extends JPanel implements KeyListener,Runnable
{
	private float angle;
	private int x;
	private int y;
	private int something=215;
	private int deaths=0;
	private int lvlnumber=1;
	private boolean up;
	private boolean down;
	private boolean left;
	private boolean right;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private Font f;
	private Polygon menu;
	private Polygon background;
	private Polygon poly;
	private Polygon poly2;
	private Polygon in1;
	private Polygon in2;
	private Polygon in3;
	private Polygon safezone;
	private GradientPaint gp;
	private Color color;
	ArrayList<Enemy> ballList;
	ArrayList<VEnemy>vballList;
	public EndOfYearProjectStarterCode()
	{
		frame=new JFrame();

		gameOn=true;

		background = new Polygon();
		background.addPoint(0,0);
		background.addPoint(800,0);
		background.addPoint(800,500);
		background.addPoint(0,500);

		menu = new Polygon();
		menu.addPoint(0,0);
		menu.addPoint(800,0);
		menu.addPoint(800,35);
		menu.addPoint(0,35);
		level1();

		gp = new GradientPaint((float)0.0, (float)0.0, Color.green, (float)0.0, (float)30.0, Color.green, true);
		f=new Font("Times New Roman",Font.BOLD,16);
		frame.addKeyListener(this);
		frame.add(this);
		frame.setSize(800,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		setVisible(true);
		t=new Thread(this);
		t.start();

	}
	public void level1()
	{
		x=190;
		y=245;
		poly=new Polygon();
		poly.addPoint(160,160);
		poly.addPoint(232,160);
		poly.addPoint(232,275);
		poly.addPoint(254,275);
		poly.addPoint(254,184);
		poly.addPoint(454,184);
		poly.addPoint(454,160);
		poly.addPoint(580,160);
		poly.addPoint(580,300);
		poly.addPoint(512,300);
		poly.addPoint(512,184);
		poly.addPoint(488,184);
		poly.addPoint(488,275);
		poly.addPoint(280,275);
		poly.addPoint(280,300);
		poly.addPoint(160,300);

		in1 = new Polygon();
		in1.addPoint(232,275);
		in1.addPoint(280,275);
		in1.addPoint(280,300);
		in1.addPoint(232,299);

		in2 = new Polygon();
		in2.addPoint(254,184);
		in2.addPoint(488,184);
		in2.addPoint(488,275);
		in2.addPoint(254,275);

		in3 = new Polygon();
		in3.addPoint(454,160);
		in3.addPoint(512,160);
		in3.addPoint(512,184);
		in3.addPoint(454,184);

		safezone = new Polygon();
		safezone.addPoint(504,161);
		safezone.addPoint(578,161);
		safezone.addPoint(578,298);
		safezone.addPoint(504,298);

		ballList=new ArrayList<Enemy>();
		ballList.add(new Enemy(478,190,12,12,false,poly));
		ballList.add(new Enemy(254,215,12,12,true,poly));
		ballList.add(new Enemy(478,235,12,12,false,poly));
		ballList.add(new Enemy(254,260,12,12,true,poly));

	}
	public void level2()
	{
		x=135;
		y=220;

		poly = new Polygon();
		poly.addPoint(96,194);
		poly.addPoint(196,194);
		poly.addPoint(196,94);
		poly.addPoint(592,94);
		poly.addPoint(592,194);
		poly.addPoint(692,194);
		poly.addPoint(692,256);
		poly.addPoint(592,256);
		poly.addPoint(592,356);
		poly.addPoint(196,356);
		poly.addPoint(196,256);
		poly.addPoint(96,256);

		in1 = new Polygon();
		in1.addPoint(96,194);
		in1.addPoint(197,194);
		in1.addPoint(197,256);
		in1.addPoint(96,256);

		safezone = new Polygon();
		safezone.addPoint(591,194);
		safezone.addPoint(692,194);
		safezone.addPoint(692,256);
		safezone.addPoint(591,256);

		vballList=new ArrayList<VEnemy>();
		vballList.add(new VEnemy(207,something,12,12,false,poly));
		vballList.add(new VEnemy(238,something,12,12,true,poly));
		vballList.add(new VEnemy(271,something,12,12,false,poly));
		vballList.add(new VEnemy(305,something,12,12,true,poly));
		vballList.add(new VEnemy(337,something,12,12,false,poly));
		vballList.add(new VEnemy(371,something,12,12,true,poly));
		vballList.add(new VEnemy(404,something,12,12,false,poly));
		vballList.add(new VEnemy(437,something,12,12,true,poly));
		vballList.add(new VEnemy(468,something,12,12,false,poly));
		vballList.add(new VEnemy(501,something,12,12,true,poly));
		vballList.add(new VEnemy(534,something,12,12,false,poly));
		vballList.add(new VEnemy(567,something,12,12,true,poly));
	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g);

		//all painting (AND ONLY PAINTING) happens here!
		//Don't use this method to deal with mathematics
		//The painting chimps aren't fond of math.

		color = new Color(180,181,254);
		g2d.setColor(color);
		g2d.fill(background);

		g2d.setColor(Color.BLACK);
		g2d.fill(menu);

		f=new Font("Arial",Font.BOLD,16);
		g2d.setFont(f);
		g2d.setColor(Color.WHITE);
		g2d.drawString("MENU",35,25);
		g2d.drawString("LEVEL "+lvlnumber+"/2",360,25);
		g2d.drawString("DEATHS: "+deaths,680,25);
		g2d.drawString("POSITIONS: "+x+", "+y+"",500,25);
		if(lvlnumber==1){
			color = new Color(173,242,175);
			g2d.setColor(color);
			g2d.fill(poly);

			color = new Color(226,230,255);
			g2d.setColor(color);
			g2d.fill(in1);
			g2d.fill(in2);
			g2d.fill(in3);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly);

			//THE CHECKERBOARD
			g2d.setColor(Color.WHITE);
			g2d.fillRect(231,276,24,23);
			g2d.fillRect(255,209,24,23);
			g2d.fillRect(255,252,24,23);
			g2d.fillRect(279,185,24,23);
			g2d.fillRect(279,230,24,23);
			g2d.fillRect(303,209,24,23);
			g2d.fillRect(303,252,24,22);
			g2d.fillRect(327,185,24,23);
			g2d.fillRect(327,230,24,23);
			g2d.fillRect(351,209,24,23);
			g2d.fillRect(351,252,24,22);
			g2d.fillRect(375,185,24,23);
			g2d.fillRect(375,230,24,23);
			g2d.fillRect(399,209,24,23);
			g2d.fillRect(399,252,24,22);
			g2d.fillRect(423,185,24,23);
			g2d.fillRect(423,230,24,23);
			g2d.fillRect(456,161,15,23);
			g2d.fillRect(447,209,24,23);
			g2d.fillRect(447,252,24,22);
			g2d.fillRect(471,184,16,24);
			g2d.fillRect(471,230,16,23);
			g2d.fillRect(487,161,26,22);

			for(Enemy b:ballList)
			{
				g2d.setColor(Color.BLUE);
				g2d.fillOval(b.getX(),b.getY(),b.getW(),b.getH());
				g2d.setColor(Color.BLACK);
				g2d.drawOval(b.getX(),b.getY(),b.getW(),b.getH());
			}
		}
		else if(lvlnumber==2)
		{
			color = new Color(226,230,255);
			g2d.setColor(color);
			g2d.fill(poly);

			color = new Color(173,242,175);
			g2d.setColor(color);
			g2d.fill(in1);
			g2d.fill(safezone);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly);

			//THE CHECKERBOARD
			g2d.setColor(Color.WHITE);
			g2d.fillRect(197,95,24,24);
			g2d.fillRect(197,143,24,24);
			g2d.fillRect(197,191,24,24);
			g2d.fillRect(197,239,24,24);
			g2d.fillRect(197,287,24,24);
			g2d.fillRect(197,335,24,20);
			g2d.fillRect(221,119,24,24);
			g2d.fillRect(221,167,24,24);
			g2d.fillRect(221,215,24,24);
			g2d.fillRect(221,263,24,24);
			g2d.fillRect(221,311,24,24);
			g2d.fillRect(245,95,24,24);
			g2d.fillRect(245,143,24,24);
			g2d.fillRect(245,191,24,24);
			g2d.fillRect(245,239,24,24);
			g2d.fillRect(245,287,24,24);
			g2d.fillRect(245,335,24,20);
			g2d.fillRect(269,119,24,24);
			g2d.fillRect(269,167,24,24);
			g2d.fillRect(269,215,24,24);
			g2d.fillRect(269,263,24,24);
			g2d.fillRect(269,311,24,24);
			g2d.fillRect(293,95,24,24);
			g2d.fillRect(293,143,24,24);
			g2d.fillRect(293,191,24,24);
			g2d.fillRect(293,239,24,24);
			g2d.fillRect(293,287,24,24);
			g2d.fillRect(293,335,24,20);
			g2d.fillRect(317,119,24,24);
			g2d.fillRect(317,167,24,24);
			g2d.fillRect(317,215,24,24);
			g2d.fillRect(317,263,24,24);
			g2d.fillRect(317,311,24,24);
			g2d.fillRect(341,95,24,24);
			g2d.fillRect(341,143,24,24);
			g2d.fillRect(341,191,24,24);
			g2d.fillRect(341,239,24,24);
			g2d.fillRect(341,287,24,24);
			g2d.fillRect(341,335,24,20);
			g2d.fillRect(365,119,24,24);
			g2d.fillRect(365,167,24,24);
			g2d.fillRect(365,215,24,24);
			g2d.fillRect(365,263,24,24);
			g2d.fillRect(365,311,24,24);
			g2d.fillRect(389,95,24,24);
			g2d.fillRect(389,143,24,24);
			g2d.fillRect(389,191,24,24);
			g2d.fillRect(389,239,24,24);
			g2d.fillRect(389,287,24,24);
			g2d.fillRect(389,335,24,20);
			g2d.fillRect(413,119,24,24);
			g2d.fillRect(413,167,24,24);
			g2d.fillRect(413,215,24,24);
			g2d.fillRect(413,263,24,24);
			g2d.fillRect(413,311,24,24);
			g2d.fillRect(437,95,24,24);
			g2d.fillRect(437,143,24,24);
			g2d.fillRect(437,191,24,24);
			g2d.fillRect(437,239,24,24);
			g2d.fillRect(437,287,24,24);
			g2d.fillRect(437,335,24,20);
			g2d.fillRect(461,119,24,24);
			g2d.fillRect(461,167,24,24);
			g2d.fillRect(461,215,24,24);
			g2d.fillRect(461,263,24,24);
			g2d.fillRect(461,311,24,24);
			g2d.fillRect(485,95,24,24);
			g2d.fillRect(485,143,24,24);
			g2d.fillRect(485,191,24,24);
			g2d.fillRect(485,239,24,24);
			g2d.fillRect(485,287,24,24);
			g2d.fillRect(485,335,24,20);
			g2d.fillRect(509,119,24,24);
			g2d.fillRect(509,167,24,24);
			g2d.fillRect(509,215,24,24);
			g2d.fillRect(509,263,24,24);
			g2d.fillRect(509,311,24,24);
			g2d.fillRect(533,95,24,24);
			g2d.fillRect(533,143,24,24);
			g2d.fillRect(533,191,24,24);
			g2d.fillRect(533,239,24,24);
			g2d.fillRect(533,287,24,24);
			g2d.fillRect(533,335,24,20);
			g2d.fillRect(557,119,24,24);
			g2d.fillRect(557,167,24,24);
			g2d.fillRect(557,215,24,24);
			g2d.fillRect(557,263,24,24);
			g2d.fillRect(557,311,24,24);
			g2d.fillRect(581,95,10,24);
			g2d.fillRect(581,143,10,24);
			g2d.fillRect(581,191,10,24);
			g2d.fillRect(581,239,10,24);
			g2d.fillRect(581,287,10,24);
			g2d.fillRect(581,335,10,20);


			for(VEnemy b:vballList)
			{
				g2d.setColor(Color.BLUE);
				g2d.fillOval(b.getX(),b.getY(),b.getW(),b.getH());
				g2d.setColor(Color.BLACK);
				g2d.drawOval(b.getX(),b.getY(),b.getW(),b.getH());
			}
		}
		//g2d.drawString("A",x,y);
		g2d.setColor(Color.RED);
		g2d.fillRect(x,y,10,10);
		g2d.setStroke(new BasicStroke(2));
		g2d.setColor(Color.BLACK);
		g2d.drawRect(x,y,10,10);
	}
	public void run()
	{
		while(true)
		{
			if(gameOn)
			{

				if(poly.contains(new Rectangle(x-2,y,10,10))){
					if(left)
						x--;
				}
				if(poly.contains(new Rectangle(x+2,y,10,10))){
					if(right)
						x++;
				}
				if(poly.contains(new Rectangle(x,y-2,10,10))){
					if(up)
						y--;
				}
				if(poly.contains(new Rectangle(x,y+2,10,10))){
					if(down)
						y++;
				}
				if(lvlnumber==1){
					for(Enemy b:ballList)
					{
						b.move();
						Ellipse2D.Double circle=new Ellipse2D.Double(b.getX(),b.getY(),b.getW(),b.getH());
						if(circle.intersects(new Rectangle(x,y,10,10)))
							{
								deaths++;
								x=190;
								y=245;
						}
					}


					if(safezone.contains(new Rectangle(x,y,10,10))){
						lvlnumber++;
						level2();

					}
				}
				else if(lvlnumber==2){
					for(VEnemy v:vballList)
					{
						v.move();
						Ellipse2D.Double circle=new Ellipse2D.Double(v.getX(),v.getY(),v.getW(),v.getH());
						if(circle.intersects(new Rectangle(x,y,10,10)))
						{
							deaths++;
							x=135;
							y=220;
						}
					}
				}

				try
				{
					t.sleep(6);
				}
				catch(InterruptedException e)
				{

				}
				repaint();
			}
		}
	}

	public void keyPressed(KeyEvent ke){
		//System.out.println(ke.getKeyCode());
		if(ke.getKeyCode()==37)
			 left=true;

		if(ke.getKeyCode()==38)
			 up=true;


		if(ke.getKeyCode()==39)
			 right=true;

		if(ke.getKeyCode()==40)
			 down=true;
	}
	public void keyReleased(KeyEvent ke){
		if(ke.getKeyCode()==37)
		 left=false;
		if(ke.getKeyCode()==38)
			 up=false;
		if(ke.getKeyCode()==39)
			 right=false;
		if(ke.getKeyCode()==40)
			 down=false;
	}
	public void keyTyped(KeyEvent ke)
	{
	}
	public static void main(String args[])
	{
		EndOfYearProjectStarterCode app=new EndOfYearProjectStarterCode();
	}
}