package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class fighter extends object {
	private ImageIcon[] fighter;
	int bullete_num;
	private double attack_speed;
	private double Hp;
	private double Max_Hp;
	private double Exp;
	private double Lvup_Exp;
	public double Agility = 0;
	private int Lv;
	private double power;
	private int Ability_point;
	private int money;

	private boolean invincible;

	public fighter(double x, double y, int width, int hieght) {
		super(x, y, width, hieght);
		// TODO Auto-generated constructor stub
		fighter = new ImageIcon[2];
		fighter[0] = new ImageIcon(fighterPanel1.class.getResource("corki.png"));
		fighter[1] = new ImageIcon(fighterPanel1.class.getResource("corki_rocket.png"));
		setDx(3);
		setDy(3);
		bullete_num = 20;
		this.Hp = 3;
		invincible = false;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isInvincible() {
		return invincible;
	}

	public void setInvincible(boolean invincible) {
		this.invincible = invincible;
	}

	public int getAbility_point() {
		return Ability_point;
	}

	public void setAbility_point(int ability_point) {
		Ability_point = ability_point;
	}

	public double getLvup_Exp() {
		return Lvup_Exp;
	}

	public void setLvup_Exp(double lvup_Exp) {
		Lvup_Exp = lvup_Exp;
	}

	public double getMax_Hp() {
		return Max_Hp;
	}

	public void setMax_Hp(double max_Hp) {
		Max_Hp = max_Hp;
	}

	public double getExp() {
		return Exp;
	}

	public void setExp(double exp) {
		Exp = exp;
	}

	public int getLv() {
		return Lv;
	}

	public void setLv(int lv) {
		Lv = lv;
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

	public double getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(double attack_speed) {
		this.attack_speed = attack_speed;
	}

	public int getBullete_num() {
		return bullete_num;
	}

	public void setBullete_num(int bullete_num) {
		this.bullete_num = bullete_num;
	}

	public void mvRight() {
		if (isVisible()) {
			setX(getX() + getDx());
		}
	}

	public void mvLeft() {
		if (isVisible()) {
			setX(getX() - getDx());
		}
	}

	public void mvUp() {
		if (isVisible()) {
			setY(getY() - getDy());
		}
	}

	public void mvDown() {
		if (isVisible()) {
			setY(getY() + getDy());
		}
	}

	public void move(boolean[] keypressed) {

		if (keypressed[0] == true && getX() < getFrame_width() - getWidth())
			mvRight();
		if (keypressed[1] == true && getX() > 0)
			mvLeft();
		if (keypressed[2] == true && getY() > 0)
			mvUp();
		if (keypressed[3] == true && getY() < getFrame_hieght() - getHieght())
			mvDown();
	}

	public boolean IN_borader() {
		return (getX() > -1 && getY() > -1 && getX() < getFrame_width() - getWidth()
				&& getY() < getFrame_hieght() - getHieght());
	}

	public void injured(double enemy_power) {
		if (!invincible) {
			if (Math.random() > Agility)
				this.Hp = this.Hp - enemy_power;
		}
	}

	public boolean isdie() {
		if (this.Hp <= 0)
			return true;
		else
			return false;
	}

	public void draw(Graphics myBuffer) {
		if (isVisible())
			myBuffer.drawImage(fighter[getSkin()].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
					(int) getHieght(), null);

	}
}
