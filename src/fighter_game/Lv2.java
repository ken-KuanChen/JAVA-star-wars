package fighter_game;

import java.awt.Graphics;

public class Lv2 extends Lv {
	public monster[] initial(monster[] monster) {
		monster = new monster[10];
		for (int i = 0; i < monster_num; i++) {
			monster_attackspeed = (Math.random() * 300 + 50);
			monster[i] = new monster();
			monster[i].setHp(monster_Hp);
			monster[i].setPower(monster_power);
			monster[i].setAttack_speed(monster_attackspeed);
			monster[i].setGive_Exp(monster_Exp);
			monster[i].setDir(monster_Dir);
			monster[i].setGive_money(monster_Money);
			if (i == 1) {
				monster_xcenter = Xdistance;
				monster_ycenter = 100;
			} else if (i == 2) {
				monster_xcenter = 100 + Xdistance / 4;
				monster_ycenter = Ydistance;
			} else if (i == 3) {
				monster_xcenter = monster_xcenter+ Xdistance / 4;
			}else if (i >= 4) {
				monster[i].setSpeed(monster_speed);
				monster[i].setDir(monster[i-1].getDir()-45);
				monster[i].setAttackable(false);
			}
			monster[i].setXcenter(monster_xcenter);
			monster[i].setYcenter(monster_ycenter);
			monster[i].setCirclel_r(monster_circlel_r);
			monster[i].setVisible(true);
		}
		return monster;
	}

	public void stage_1_0initial() {
		monster_xcenter = 100;
		monster_ycenter = 100;
		monster_num = 3;
		monster_circlel_r = 60;
		Xdistance = 8 * monster_circlel_r;
		Ydistance = 5 * monster_circlel_r;
		monster_Dir = 0;
		
		//can change
		monster_Hp = 50 *Now_LV;
		monster_power = Now_LV*3;
		monster_Exp = 40*Now_LV;
		monster_Money=60;
	}

	public void stage_2_0initial() {
		monster_xcenter = 100;
		monster_ycenter = 100;
		monster_circlel_r = 60;
		Xdistance = 8 * monster_circlel_r;
		Ydistance = 5 * monster_circlel_r;
		monster_Dir = 0;
		monster_speed =1;
		//new &&can change
		monster_num = 5 ;
		monster_Hp = 20*Now_LV;
		monster_power =  Now_LV*3;
		monster_Exp = 50*Now_LV;
		monster_Money=70;
	}
	public void stage_3_0initial() {
		monster_xcenter = 100;
		monster_ycenter = 100;
		monster_circlel_r = 60;
		Xdistance = 8 * monster_circlel_r;
		Ydistance = 5 * monster_circlel_r;
		monster_Dir = 0;
		monster_speed =0.5;
		//new &&can change
		monster_num = 6 ;
		monster_Hp = 30*Now_LV;
		monster_power =Now_LV*3;
		monster_Exp = 50*Now_LV;
		monster_Money=80;
	}
	public void stage_4_0initial() {
		monster_xcenter = 100;
		monster_ycenter = 100;
		monster_circlel_r = 60;
		Xdistance = 8 * monster_circlel_r;
		Ydistance = 5 * monster_circlel_r;
		monster_Dir = 0;
		monster_speed =0.3;
		//new &&can change
		monster_num = 7 ;
		monster_Hp = 40*Now_LV;
		monster_power =Now_LV*3;
		monster_Exp = 60*Now_LV;
		monster_Money=90;
	}
	public void stage_5_0initial() {
		monster_xcenter = 100;
		monster_ycenter = 100;
		monster_circlel_r = 60;
		Xdistance = 8 * monster_circlel_r;
		Ydistance = 5 * monster_circlel_r;
		monster_Dir = 0;
		monster_speed =0.3   ;
		//new &&can change
		monster_num = 8 ;
		monster_Hp = 50*Now_LV;
		monster_power = Now_LV*3;
		monster_Exp = 60*Now_LV;
		monster_Money=100;
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

	public void draw(monster[] monster, Graphics myBuffer) {
		for (int i = 0; i < monster_num; i++) {
			if(i >= 4)
				monster[i].Bumpove();
			else
				monster[i].Circlelmove();
			monster[i].draw(myBuffer);
			monster[i].fire(myBuffer);
		}
	}

}
