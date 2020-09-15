package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class fighter_bullete extends object {
	private ImageIcon[] fighter_bullete;
	double speed;

	public fighter_bullete() {
		// TODO Auto-generated constructor stub
		fighter_bullete = new ImageIcon[1];
		speed = 1;

fighter_bullete[0] = new ImageIcon(fighterPanel1.class.getResource("croki_bullet.png"));
		setHieght(38);
		setWidth(11);
		setDx(0);
		setDy(0);
		setVisible(false);
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

	public void Setstart_location(fighter fighter, int i) {
		setY(fighter.getY());

		if(i==0)
			setX(fighter.getX() + fighter.getWidth() / 3+10);
		if(i==1)
			setX(fighter.getX() + fighter.getWidth() / 3+10+20);
		if(i==2)
			setX(fighter.getX() + fighter.getWidth() / 3+10-20);
		if(i==3)
			setX(fighter.getX() + fighter.getWidth() / 3+10+40);
		if(i==4)
			setX(fighter.getX() + fighter.getWidth() / 3+10-40);

	}

	public boolean IN_borader() {
		return (getX() > 0 + getWidth() && getY() > 0 + getHieght() && getX() < getFrame_width() + getWidth()
				&& getY() < getFrame_hieght() + getHieght());
	}

	public void draw(Graphics myBuffer) {
		if (isVisible()) {
			if (IN_borader()) {
				myBuffer.drawImage(fighter_bullete[getSkin()].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
						(int) getHieght(), null);
			} else {
				setVisible(false);
			}
		}
	}

}
