package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class fighter_boom extends object {
	private ImageIcon[] fighter_boom;
	private ImageIcon[] burst;
	double speed;
	public boolean bursting;
	public int burstX, burstY, burstW, burstH;

	public fighter_boom() {
		// TODO Auto-generated constructor stub
		fighter_boom = new ImageIcon[1];
		burst = new ImageIcon[9];
		speed = 1;
		fighter_boom[0] = new ImageIcon(fighterPanel1.class.getResource("croki_bullet2.png"));
		burst[8] = new ImageIcon(fighterPanel1.class.getResource("burst01.png"));
		burst[7] = new ImageIcon(fighterPanel1.class.getResource("burst02.png"));
		burst[6] = new ImageIcon(fighterPanel1.class.getResource("burst03.png"));
		burst[5] = new ImageIcon(fighterPanel1.class.getResource("burst04.png"));
		burst[4] = new ImageIcon(fighterPanel1.class.getResource("burst05.png"));
		burst[3] = new ImageIcon(fighterPanel1.class.getResource("burst06.png"));
		burst[2] = new ImageIcon(fighterPanel1.class.getResource("burst07.png"));
		burst[1] = new ImageIcon(fighterPanel1.class.getResource("burst08.png"));
		burst[0] = new ImageIcon(fighterPanel1.class.getResource("burst09.png"));
		setHieght(30);
		setWidth(30);
		setDx(0);
		setDy(0);
		setVisible(false);
		bursting = false;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void move() {
		if (isVisible()) {
			setDy(-speed);
			setX(getX() + getDx());
			setY(getY() + getDy());
		}
	}

	public void Setstart_location(fighter fighter) {
		setY(fighter.getY());
		setX(fighter.getX() + fighter.getWidth() / 3 + 10);

	}

	public boolean IN_borader() {
		return (getX() > 0 + getWidth() && getY() > 0 + getHieght() && getX() < getFrame_width() + getWidth()
				&& getY() < getFrame_hieght() + getHieght());
	}

	public void draw(Graphics myBuffer) {
		burstX = (int) getX() - 100 + getWidth() / 2;
		burstY = (int) getY() - 100 + getHieght() / 2;
		burstW = 200;
		burstH = 200;
		
		if (isVisible()) {
			if (IN_borader()) {
				myBuffer.drawImage(fighter_boom[getSkin()].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
						(int) getHieght(), null);
			} else {
				setVisible(false);
			}
		}
	}

	public void drawBurst(Graphics myBuffer, int time) {
		if(time < 0 || time > 8) bursting = false;
		else if (bursting) {
			myBuffer.drawImage(burst[time].getImage(), burstX, burstY, burstW, burstH, null);
		}
	}
}