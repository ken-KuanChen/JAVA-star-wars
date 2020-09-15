package fighter_game;

import java.awt.Graphics;

public class Lv_infinite extends Lv {
	public double monster_attackspeed_start;
	public double monster_changeDir_speed_max=50;
	public double monster_attackspeed_start_max =10;
	public monster[] initial(monster[] monster) {
		monster = new monster[10];
		for (int i = 0; i < monster_num; i++) {
			monster_attackspeed = (Math.random() * 300 + monster_attackspeed_start);
			monster[i] = new monster();
			monster[i].setHp(monster_Hp);
			monster[i].setPower(monster_power);
			monster[i].setAttack_speed(monster_attackspeed);
			monster[i].setGive_Exp(monster_Exp);
			monster[i].setDir(monster_Dir);
			monster[i].setGive_money(monster_Money);
			if (i == 0) {
				monster[i].setXcenter(monster_xcenter);
				monster[i].setYcenter(monster_ycenter);
				monster[i].setCirclel_r(monster_circlel_r);
			} else if (i == 1) {
				monster[i].setXcenter(monster_xcenter + Xdistance * 2);
				monster[i].setYcenter(monster_ycenter);
				monster[i].setCirclel_r(monster_circlel_r);
			} else if (i == 2) {
				monster[i].setXcenter(monster_xcenter);
				monster[i].setYcenter(monster_ycenter + Ydistance * 2);
				monster[i].setCirclel_r(monster_circlel_r * 1.5);
			} else if (i == 3) {
				monster[i].setXcenter(monster_xcenter + Xdistance * 2);
				monster[i].setYcenter(monster_ycenter + Ydistance * 2);
				monster[i].setCirclel_r(monster_circlel_r * 1.5);
			} else if (i >= 4 && i <= 6) {
				monster[i].setSpeed(monster_speed);
				monster[i].setDir(monster[i - 1].getDir() - 45);
				monster[i].setAttackable(false);
			} else if (i >= 7 && i <= 9) {
				monster[i].setChangeDir_speed(monster_changeDir_speed);
				monster[i].setSpeed(monster_speed);
				monster[i].setDir(monster[i - 1].getDir() - 45);
			}
			monster[i].setVisible(true);
		}
		return monster;
	}

	public void initial_stage() {
		monster_xcenter = 200;
		monster_ycenter = 100;
		monster_num = 10;
		monster_circlel_r = 100;
		Xdistance = monster_circlel_r;
		Ydistance = monster_circlel_r;
		monster_Dir = 0;
		monster_Exp = 0;
		// can change
		monster_speed = 0.5;
		monster_changeDir_speed=300;
		monster_Hp = 10;
		monster_power = 1;
		monster_Money = 20;
		monster_attackspeed_start = 1000;
	}

	public void Next_stage() {
		monster_xcenter = 200;
		monster_ycenter = 100;
		monster_num = 10;
		monster_circlel_r = 100;
		Xdistance = monster_circlel_r;
		Ydistance = monster_circlel_r;
		monster_Dir = 0;
		// new &&can change
		monster_speed = monster_speed+0.1;
		monster_changeDir_speed=monster_changeDir_speed-10;
		if(monster_changeDir_speed_max<=monster_changeDir_speed_max)
			monster_changeDir_speed=monster_changeDir_speed_max;
		monster_Hp = monster_Hp+10;
		monster_power = monster_power+1;
		monster_Money = monster_Money+20;
		monster_attackspeed_start =monster_attackspeed_start-10;
		if(monster_attackspeed_start<=monster_attackspeed_start_max)
			monster_attackspeed_start=monster_attackspeed_start_max;
	}

	public void draw(monster[] monster, Graphics myBuffer) {
		for (int i = 0; i < monster_num; i++) {
			if (i >= 7)
				monster[i].randommove();
			else if (i >= 4)
				monster[i].Bumpove();
			else
				monster[i].Circlelmove();
			monster[i].draw(myBuffer);
			monster[i].fire(myBuffer);
		}
	}
}
