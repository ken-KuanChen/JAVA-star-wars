package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class monster extends object {
	private ImageIcon[] monster;
	private int bullete_num;
	private int bullete_num_counter;
	public monster_bullete[] bullete;
	private int attackTime;
	private double attack_speed;
	private boolean Attackable;

	private int changeDir_Time;
	private double changeDir_speed;
	private double dir;
	private double speed;
	double Hp;
	double power;
	double give_Exp;
	int give_money;

	private int collideTime;
	private double collide_speed;

	// Circlelmove
	private double xcenter;
	private double ycenter;
	private double circlel_r;

	monster() {
		monster = new ImageIcon[1];
		monster[0] = new ImageIcon(fighterPanel1.class.getResource("monster0.png"));
		setX(300);
		setY(300);
		setDy(0);
		setDx(0);
		setSkin(0);
		setHieght(32);
		setWidth(33);
		setVisible(false);
		Attackable = true;
		// randommove
		changeDir_Time = 0;
		changeDir_speed = 300;
		this.speed = 0.5;
		this.dir = 2;

		// set bullete
		attackTime = 0;
		attack_speed = 100;
		bullete_num = 20;
		bullete_num_counter = 0;
		bullete = new monster_bullete[20];
		for (int i = 0; i < bullete_num; i++) {
			bullete[i] = new monster_bullete();
		}
		collideTime = 0;
		collide_speed = 500;
	}

	public int getCollideTime() {
		return collideTime;
	}

	public void setCollideTime(int collideTime) {
		this.collideTime = collideTime;
	}

	public double getCollide_speed() {
		return collide_speed;
	}

	public double getChangeDir_speed() {
		return changeDir_speed;
	}

	public void setChangeDir_speed(double changeDir_speed) {
		this.changeDir_speed = changeDir_speed;
	}

	public int getGive_money() {
		return give_money;
	}

	public void setGive_money(int give_money) {
		this.give_money = give_money;
	}

	public boolean isAttackable() {
		return Attackable;
	}

	public void setAttackable(boolean attackable) {
		Attackable = attackable;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getDir() {
		return dir;
	}

	public void setDir(double dir) {
		this.dir = dir;
	}

	public double getXcenter() {
		return xcenter;
	}

	public void setXcenter(double xcenter) {
		this.xcenter = xcenter;
	}

	public double getYcenter() {
		return ycenter;
	}

	public void setYcenter(double ycenter) {
		this.ycenter = ycenter;
	}

	public double getCirclel_r() {
		return circlel_r;
	}

	public void setCirclel_r(double circlel_r) {
		this.circlel_r = circlel_r;
	}

	public double getGive_Exp() {
		return give_Exp;
	}

	public void setGive_Exp(double give_Exp) {
		this.give_Exp = give_Exp;
	}

	public void injured(double enemy_power) {
		this.Hp = this.Hp - enemy_power;
	}

	public boolean isdie() {
		if (this.Hp <= 0)
			return true;
		else
			return false;
	}

	public double getHp() {
		return Hp;
	}

	public void setHp(double hp) {
		Hp = hp;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public int getBullete_num() {
		return bullete_num;
	}

	public void setBullete_num(int bullete_num) {
		this.bullete_num = bullete_num;
	}

	public double getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(double attack_speed) {
		this.attack_speed = attack_speed;
	}

	public int getChangeDir_Time() {
		return changeDir_Time;
	}

	public void setChangeDir_Time(int changeDir_Time) {
		this.changeDir_Time = changeDir_Time;
	}

	public void move() {
		if (isVisible()) {
			setX(getX() + getDx());
			setY(getY() + getDy());

		}
	}

	public void fire(Graphics myBuffer) {
		if (isVisible() && Attackable) {
			attackTime = attackTime + 1;
			if (attackTime >= attack_speed) {
				attackTime = 0;
				bullete_num_counter = bullete_num_counter + 1;
				if (bullete_num_counter >= bullete_num)
					bullete_num_counter = 0;
				bullete[bullete_num_counter].Setstart_location(this);
				bullete[bullete_num_counter].setVisible(true);
			}
		}
		for (int i = 0; i < bullete_num; i++) {
			bullete[i].move();
			bullete[i].draw(myBuffer);
		}
	}

	public void Circlelmove() {
		if (dir > 360)
			dir = 0;
		else
			dir = dir + 0.5;
		this.xcenter = xcenter;
		this.ycenter = ycenter;
		double stepx = circlel_r * Math.cos(dir * Math.PI / 180);
		double stepy = circlel_r * -1 * Math.sin(dir * Math.PI / 180);
		setX(xcenter + stepx);
		setY(ycenter + stepy);
	}

	public void randommove() {
		if (isVisible()) {
			if (IN_borader()) {
				changeDir_Time++;
				if (changeDir_Time > changeDir_speed) {
					changeDir();
					changeDir_Time = 0;
				}
				setDx(speed * Math.cos(dir * Math.PI / 180));
				setDy(speed * -1 * Math.sin(dir * Math.PI / 180));
				setX(getX() + getDx());
				setY(getY() + getDy());
			} else {
				while (!IN_borader()) {
					changeDir();
					double stepx = speed * Math.cos(dir * Math.PI / 180);
					double stepy = speed * -1 * Math.sin(dir * Math.PI / 180);
					setX(getX() + stepx);
					setY(getY() + stepy);
				}
			}
		}
	}

	public void Bumpove() {
		if (isVisible()) {
			if (IN_borader()) {
				double stepx = speed * Math.cos(dir * Math.PI / 180);
				double stepy = speed * -1 * Math.sin(dir * Math.PI / 180);
				setX(getX() + stepx);
				setY(getY() + stepy);
			} else {
				while (!IN_borader()) {
					changeDir();
					double stepx = speed * Math.cos(dir * Math.PI / 180);
					double stepy = speed * -1 * Math.sin(dir * Math.PI / 180);
					setX(getX() + stepx);
					setY(getY() + stepy);
				}
			}
		}
	}

	public void changeDir() {
		this.dir = (Math.random() * 360);
	}

	public boolean IN_borader() {
		return (getX() > -1 && getY() > -1 && getX() < getFrame_width() - getWidth() + 1
				&& getY() < getFrame_hieght() - getHieght() + 1);
	}

	public void draw(Graphics myBuffer) {
		if (isVisible()) {
			collideTime = collideTime + 1;
			if (IN_borader()) {
				myBuffer.drawImage(monster[getSkin()].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
						(int) getHieght(), null);
			}
		}
	}
}
