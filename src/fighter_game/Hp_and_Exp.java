package fighter_game;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Hp_and_Exp extends object {
	private ImageIcon[] Hp_and_Exp;
	private double initial_Hp_Width;
	public double Max_Hp;
	private double Hp_Width;
	
	private double initial_Exp_Width;
	public double Max_Exp;
	private double Exp_Width;
	public Hp_and_Exp() {
		// TODO Auto-generated constructor stub
		Hp_and_Exp = new ImageIcon[4];
Hp_and_Exp[0] = new ImageIcon(fighterPanel1.class.getResource("Hp_frame.png"));
		Hp_and_Exp[1] = new ImageIcon(fighterPanel1.class.getResource("Hp.png"));
		Hp_and_Exp[2] = new ImageIcon(fighterPanel1.class.getResource("Exp_frame.png"));
		Hp_and_Exp[3] = new ImageIcon(fighterPanel1.class.getResource("Exp.png"));
		setX(0);
		setY(640);
		setWidth(145 * 2);
		setHieght(42 * 2);
		initial_Hp_Width=205;
		initial_Exp_Width=200;
	}
	
	public double getHp_Width() {
		return Hp_Width;
	}

	public void setHp_Width(double now_hp) {
		Hp_Width = initial_Hp_Width*(now_hp/Max_Hp);
		if(Hp_Width<0)
			Hp_Width=0;
	}

	public double getExp_Width() {
		return Exp_Width;
	}

	public void setExp_Width(double now_exp) {
		Exp_Width = initial_Exp_Width*(now_exp/Max_Exp);
		if(Hp_Width>initial_Exp_Width)
			Hp_Width=initial_Exp_Width;
	}

	public void draw(Graphics myBuffer) {
		if (isVisible()) {
			setX(0);
			setY(740);
			setWidth(145 * 2);
			setHieght(42 * 2);
			myBuffer.drawImage(Hp_and_Exp[1].getImage(), (int) getX() + 85, (int) getY() + 18, (int) Hp_Width,
					(int) getHieght() / 2 - 5, null);

			myBuffer.drawImage(Hp_and_Exp[0].getImage(), (int) getX(), (int) getY(), (int) getWidth(),
					(int) getHieght(), null);
			setX(300);
			setY(740);
			myBuffer.drawImage(Hp_and_Exp[3].getImage(), (int) getX() + 88, (int) getY() + 18, (int) Exp_Width,
					(int) getHieght() / 2 - 5, null);
			myBuffer.drawImage(Hp_and_Exp[2].getImage(), (int) getX(), (int) getY() , (int) getWidth(),
					(int) getHieght() , null);
			
		}
	}
}
