package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class monster_bullete extends object {
	private ImageIcon[] monster_bullete;
	double speed;
	public monster_bullete() {
		// TODO Auto-generated constructor stub
		monster_bullete = new ImageIcon[1];
		speed = 0.5;
		monster_bullete[0] = new ImageIcon(fighterPanel1.class.getResource("monster_bullete.gif"));
		setHieght(25);
		setWidth(15);
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
			setDy(speed);
			setX(getX() + getDx());
			setY(getY() + getDy());
		}
	}

	public void Setstart_location(monster monster) {

		setX(monster.getX() + monster.getWidth() / 3);
		setY(monster.getY() + monster.getHieght()/4*3);

	}

	public boolean IN_borader() {
		return (getX() > 0 + getWidth() && getY() > 0 + getHieght() && getX() < getFrame_width() + getWidth()
				&& getY() < getFrame_hieght() + getHieght());
	}

	public void draw(Graphics myBuffer) {
		if (isVisible()) {
			if (IN_borader()) {
				myBuffer.drawImage(monster_bullete[getSkin()].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
						(int) getHieght(), null);
			} else {
				setVisible(false);
			}
		}
	}

}
