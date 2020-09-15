package fighter_game;

import java.awt.Graphics;

public class Lv1 extends Lv {
	public monster[] initial(monster[] monster) {
		monster = new monster[10];
		for (int i = 0; i < monster_num; i++) {
			monster[i] = new monster();
			monster[i].setHp(monster_Hp);
			monster[i].setPower(monster_power);
			monster[i].setDx(monster_Dx);
			monster[i].setDy(monster_Dy);
			monster[i].setY(monster_Y);
			monster[i].setAttack_speed(monster_attackspeed);
			monster[i].setGive_Exp(monster_Exp);
			monster[i].setGive_money(monster_Money);
			;
			if (i == 0)
				monster[i].setX(monster_X);
			else if (i == 5)
				monster[i].setX(monster_X + 50);
			else
				monster[i].setX(monster[i - 1].getX() + monster[i - 1].getWidth() + Xdistance);

			if (i == 4) {
				monster_Y = monster_Y + Ydistance;
				monster_attackspeed = 250; 
			}
			monster[i].setVisible(true);
		}
		return monster;
	}

	public void stage_1_0initial() {
		monster_Y = 50;
		monster_X = 50;
		Xdistance = 30;
		monster_Dx = 0.5;
		monster_Hp = 20*Now_LV;
		monster_num = 5;
		monster_power = Now_LV*3;
		Ydistance = 0;
		monster_Dy=0;
		monster_attackspeed = 700;
		monster_Exp = 10*Now_LV;
		monster_Money=10;
	}

	public void stage_2_0initial() { // attack speed up
		monster_Y = 50;
		monster_X = 50;
		Xdistance = 30;
		monster_Dx = 0.5;
		monster_Hp = 30*Now_LV;
		monster_num = 5;
		monster_power =  Now_LV*3;
		Ydistance = 0;
		monster_Dy=0;
		//new
		monster_attackspeed = 500;
		monster_Exp = 10*Now_LV;
		monster_Money=20;
	}

	public void stage_3_0initial() { //2row Hp up
		monster_Y = 50;
		monster_X = 50;
		Xdistance = 30;
		monster_Dx = 0.5;
		monster_Dy=0;
		monster_num = 5;
		monster_power = Now_LV*3;
		//new
		monster_Hp = 40*Now_LV;
		monster_num = 10;
		Ydistance = 50;
		monster_attackspeed = 500;
		monster_Exp = 20*Now_LV;
		monster_Money=30;
	}

	public void stage_4_0initial() { // attack speed up
		monster_X = 50;
		monster_Y = 50;
		Xdistance = 30;
		Ydistance = 50;
		monster_Dx = 0.5;
		monster_Dy=0;
		monster_power = Now_LV*3;
		monster_Hp =  50*Now_LV;
		monster_num = 10;
		
		//new
		monster_attackspeed = 300;
		monster_Exp = 20*Now_LV;
		monster_Money=40;
	}
	public void stage_5_0initial() { //dy start
		monster_Y = 50;
		monster_X = 50;
		Xdistance = 30;
		monster_Dx = 0.5;
		monster_Dy = 0;
		monster_Dy=0;
		monster_num = 5;
		monster_power = Now_LV*3;
		monster_Hp = 50*Now_LV;
		monster_num = 10;
		Ydistance = 50;
		//new
		monster_attackspeed = 300;
		monster_Exp = 40*Now_LV;
		monster_Money=50;
	}

	public void chose_stage(int now_little_level) {
		if (now_little_level == 1)
			stage_1_0initial();
		if (now_little_level == 2)
			stage_2_0initial();
		if (now_little_level == 3)
			stage_3_0initial();
		if (now_little_level == 4)
			stage_4_0initial();
		if (now_little_level == 5)
			stage_5_0initial();
	}

	public void Touch_border(monster[] monster) {
		for (int i = 0; i < 5; i++) {
			if (monster[i].getX() > monster[i].getFrame_width() - monster[i].getWidth() || monster[i].getX() < 0) {
				for (int j = 0; j < 5; j++)
					monster[j].setDx(monster[j].getDx() * -1);
			}
		}
		for (int i = 5; i < monster_num; i++) {
			if (monster[i].getX() > monster[i].getFrame_width() - monster[i].getWidth() || monster[i].getX() < 0) {
				for (int j = 5; j < monster_num; j++)
					monster[j].setDx(monster[j].getDx() * -1);
			}
		}
	}

	public void draw(monster[] monster, Graphics myBuffer) {
		Touch_border(monster);
		for (int i = 0; i < monster_num; i++) {
			monster[i].move();
			monster[i].draw(myBuffer);
			monster[i].fire(myBuffer);
		}
	}

}
