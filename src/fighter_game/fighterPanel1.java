package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class fighterPanel1 extends JPanel {

	private ImageIcon background;
	// frame
	private static int WIDTH = 600;
	private static final int HIEGHT = 800;
	private BufferedImage myImage;
	private Graphics myBuffer;

	// fighter
	private fighter fighter;
	private fighter_bullete[] fighter_bullete;
	private fighter_boom[] fighter_boom;
	private int fighter_bullete_num;
	private int bullete_num_counter;
	private int fighter_boom_num;
	private int boom_num_counter;
	private int[] burstTime = { 0, 0, 0, 0, 0 }; // ---------------------------------------------new
	private int attackTime;
	private double attack_speed;
	private int BoomTime;
	private int BoomSpeed;
	// excel_more
	private int fighter_power = 10;
	private int fighter_start_Hp = 50;

	private Hp_and_Exp Hp_and_Exp;
	public int[] fighter_money = new int[1];;

	// monster
	private monster[] monster;
	private int monster_num;
	private int monster_alive;

	// level
	private Lv1 Lv1;
	private Lv2 Lv2;
	private Lv_infinite Lv_infinite;
	private int Tofinish_stage;
	private int Tofinish_level;
	private int Infinite_stage;
	public int[] Infinite_history_stage = new int[1];

	// timer && key boolean
	private Timer t0, t1, t2, t5, t6; // to:menu t1:Lv1 t2:Lv2 t5: infinite
	private boolean[] key_pressed; // D A W S
	private Excel excel;
	// private Excel Excel;

	// UI
	private int page[] = { 0 };
	private menu menu;
	// ====================
	public ability_UI Ability;
	// ==================
	private store store;
	private selectLevel selLV;
	private about about;
	private die dieUI;
	private win win;

	public fighterPanel1() {
		myImage = new BufferedImage(WIDTH, HIEGHT, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		background = new ImageIcon(fighterPanel1.class.getResource("background.png"));

		// UI
		menu = new menu();
		Ability = new ability_UI();
		store = new store();
		selLV = new selectLevel();
		about = new about();
		dieUI = new die();
		win = new win();

		fighter = new fighter(100, 500, 100, 100);
		excel = new Excel();

		
		fighter.setMax_Hp(50);
		fighter.setExp(0);
		fighter.setLvup_Exp(100);
		fighter_money[0] = 0;
		fighter.setLv(0);
		Ability.AP = 0;
		Ability.ability[0] = 0;
		Ability.ability[1] = 0;
		Ability.ability[2] = 0;
		Ability.ability[3] = 0;
		store.WeaponLV = 1;
		store.Bomb = 0;
		Infinite_history_stage[0] = 0;
		try {
			excel.read(fighter, Infinite_history_stage, fighter_money, Ability, store, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Hp_Exp_draw
		Hp_and_Exp = new Hp_and_Exp();
		Hp_and_Exp.Max_Hp = fighter.getMax_Hp();
		Hp_and_Exp.Max_Exp = fighter.getLvup_Exp();

		// set monster
		Lv1 = new Lv1();
		Lv2 = new Lv2();
		Lv_infinite = new Lv_infinite();
		monster_alive = 0;
		Infinite_stage = 0;
		Tofinish_stage = 1;
		Tofinish_level = 1;

		// set bullete
		attackTime = 0;
		BoomSpeed = 400;
		BoomTime = 0;
		fighter_bullete_num = 100;
		bullete_num_counter = 0;
		fighter_boom_num = 5;
		boom_num_counter = 0;
		fighter_bullete = new fighter_bullete[100];
		for (int i = 0; i < fighter_bullete_num; i++) {
			fighter_bullete[i] = new fighter_bullete();
		}
		fighter_boom = new fighter_boom[10];
		for (int i = 0; i < fighter_boom_num; i++) {
			fighter_boom[i] = new fighter_boom();
		}
		// set timer
		t0 = new Timer(4, new Listener0());
		t0.start();
		t1 = new Timer(4, new Listener1());
		t1.stop();
		t2 = new Timer(4, new Listener2());
		t2.stop();
		t5 = new Timer(4, new Listener5());
		t5.stop();
		t6 = new Timer(500, new Listener6());
		t6.stop();
//		choose_monster_lv(Tofinish_level);

		// key & mouse
		key_pressed = new boolean[4];
		for (int i = 0; i < 4; i++) {
			key_pressed[i] = false;
		}

		addMouseListener(new Mouse()); // mouse
		addKeyListener(new Key());
		setFocusable(true);
	}

	/*
	 * public void Excel_int() {
	 * 
	 * fighter_Max_Hp = 50; fighter_power = 10; attack_speed = 50; // agility
	 * fighter_Now_Hp = 50; fighter_Now_Exp = 0; fighter_Lvup_Exp = 100; // money
	 * fighter_Lv = 0; fighter_ap = 0; // ap1~4 fighter_money[0] = 0; // bullete //
	 * boom // history // ===========================
	 * fighter.setMoney(fighter_money[0]); fighter.setMax_Hp(fighter_Max_Hp);
	 * fighter.setHp(fighter_Now_Hp); // attack fighter.setPower(fighter_power);
	 * fighter.setAttack_speed(attack_speed); // Exp && Lv
	 * fighter.setLvup_Exp(fighter_Lvup_Exp); fighter.setExp(fighter_Now_Exp);
	 * fighter.setLv(fighter_Lv); fighter.setAbility_point(fighter_ap); //
	 * ====================
	 * 
	 * }
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}

	private class Listener0 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.drawImage(background.getImage(), 0, 0, WIDTH, HIEGHT, null);

			// AP scale
			fighter.setPower(fighter_power + 5 * Ability.ability[0]);
			attack_speed = 130 - 5 * Ability.ability[1];
			if (attack_speed < 31) {
				attack_speed = 30;
				BoomSpeed = 200;
			}
			fighter.setMax_Hp(fighter_start_Hp + 50 * Ability.ability[2]);
			fighter.setHp(fighter.getMax_Hp());
			fighter.Agility = 0.03 * Ability.ability[3];

			fighter.setAbility_point(Ability.AP);

			if (page[0] == 0)
				menu.draw(myBuffer);
			else if (page[0] == 1)
				selLV.draw(myBuffer);
			else if (page[0] == 2)
				Ability.draw(myBuffer);
			else if (page[0] == 3)
				store.draw(myBuffer, fighter_money[0]);
			else if (page[0] == 4)
				about.draw(myBuffer);
			else if (page[0] == 5)
				dieUI.draw(myBuffer, selLV.mode, Infinite_stage, Infinite_history_stage[0]);
			else if (page[0] == 6)
				win.draw(myBuffer, selLV.level);// , fighter_money[0]);
			else if (page[0] == 8) {
				t0.stop();
				t6.start();
			} // , fighter_money[0]);
			else if (page[0] > 99) {
				choose_monster_lv(page[0] - 100);
				page[0] = 0;
			}

			repaint();
		}
	}

	private class Listener1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.drawImage(background.getImage(), 0, 0, WIDTH, HIEGHT, null);
			attackTime = attackTime + 1;
			BoomTime = BoomTime + 1;
			// set monster
			choose_monster_stage(Lv1);
			Lv1.draw(monster, myBuffer);
			Original_draw();
			repaint();
		}
	}

	private class Listener2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.drawImage(background.getImage(), 0, 0, WIDTH, HIEGHT, null);
			attackTime = attackTime + 1;
			BoomTime = BoomTime + 1;
			// set monster
			choose_monster_stage(Lv2);
			Lv2.draw(monster, myBuffer);
			Original_draw();
			// fighter

			repaint();
		}
	}

	private class Listener5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.drawImage(background.getImage(), 0, 0, WIDTH, HIEGHT, null);
			attackTime = attackTime + 1;
			BoomTime = BoomTime + 1;
			// set monster
			choose_monster_stage(Lv_infinite);
			Lv_infinite.draw(monster, myBuffer);
			Original_draw();
			// fighter

			repaint();
		}
	}

	private class Listener6 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				excel.set(fighter, Infinite_history_stage, fighter_money, Ability, store);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			t6.stop();
			page[0] = 0;
			t0.restart();
		}
	}

	private void initial() {
		fighter.setHp(fighter.getMax_Hp());
		fighter.setX(100);
		fighter.setY(500);
		monster_alive = 0;
		Infinite_stage = 0;
		Tofinish_stage = 1;
		attackTime = 0;
		BoomTime = 0;
		bullete_num_counter = 0;
		boom_num_counter = 0;

		for (int i = 0; i < fighter_bullete_num; i++) {
			fighter_bullete[i].setVisible(false);
		}
		for (int i = 0; i < fighter_boom_num; i++) {
			fighter_boom[i].setVisible(false);
			burstTime[i] = 0;
		}
	}

	// no change draw
	private void Original_draw() {

		fighter.setVisible(true);
		fighter.move(key_pressed);
		fighter.draw(myBuffer);
		Hp_and_Exp.Max_Hp = fighter.getMax_Hp();
		Hp_and_Exp.Max_Exp = fighter.getLvup_Exp();
		Hp_and_Exp.setHp_Width(fighter.getHp());
		Hp_and_Exp.setExp_Width(fighter.getExp());
		Hp_and_Exp.setVisible(true);

		// fighter attack
		if (store.Bomb == 1)
			fighter.setSkin(1);
		fire();
		for (int i = 0; i < fighter_bullete_num; i++) {
			fighter_bullete[i].move();
			fighter_bullete[i].draw(myBuffer);
		}
		for (int i = 0; i < fighter_boom_num; i++) {
			fighter_boom[i].move();
			fighter_boom[i].draw(myBuffer);

			if (fighter_boom[i].bursting) {
				burstTime[i]--;
				fighter_boom[i].drawBurst(myBuffer, (burstTime[i] + 6) / 7);
				if (burstTime[i] == 0)
					fighter_boom[i].bursting = false;
			}
		}

		// all collide
		monster_vs_fighter_bullete();
		monster_vs_fighter_boom();

		monster_bullete_vs_fighter();

		monster_vs_fighter();
		Hp_and_Exp.draw(myBuffer);

		myBuffer.setColor(Color.white);
		myBuffer.setFont(new Font("細明體", Font.BOLD, 15));
		// Judge fighter die
		if (fighter.isdie())

		{
			page[0] = 5;
			Ability.AP = fighter.getAbility_point();
			t0.start();
			t1.stop();
			t2.stop();
			t5.stop();
			fighter.setHp(fighter.getMax_Hp());
			fighter.setExp(fighter.getExp() / 2);
		}
		// Judge monster die
		for (int i = 0; i < monster_num; i++) {
			if (monster[i].isdie() && monster[i].isVisible()) {
				monster[i].setVisible(false);
				monster_alive = monster_alive - 1;
				fighter.setExp(monster[i].getGive_Exp() + fighter.getExp());
				fighter_money[0] += monster[i].getGive_money();
			}
//			myBuffer.drawString("monster Hp : " + monster[i].getHp(), 100, (i + 1) * 50);
		}

		// fighter is lvup
		if (fighter.getExp() >= fighter.getLvup_Exp())

			fighter_Lvup();
//		myBuffer.drawString("Hp : " + fighter.getHp(), 300, 400);
//		myBuffer.drawString("Lv : " + fighter.getLv(), 300, 450);
//		myBuffer.drawString("Money : " + fighter_money[0], 200, 500);
//		myBuffer.drawString("ap : " + fighter.getAbility_point(), 200, 600);

	}

	// to next monster lv
	private void choose_monster_lv(int Tofinish_level) {
		// TODO Auto-generated method stub
		initial();

		if (Tofinish_level == 0) {
			t0.stop();
			t1.stop();
			t2.stop();
			t5.start();
		} else if (Tofinish_level % 2 == 1) {
			t0.stop();
			t2.stop();
			t5.stop();
			t1.start();
			Lv1.Now_LV = Tofinish_level;
		} else if (Tofinish_level % 2 == 0) {
			t0.stop();
			t1.stop();
			t2.start();
			t5.stop();
			Lv2.Now_LV = Tofinish_level;
		}

	}

	// to next monster stage
	private void choose_monster_stage(Lv Lv) {
		// TODO Auto-generated method stub
		if (Lv == Lv_infinite) {
			if (monster_alive == 0) {
				if (Infinite_stage == 0)
					Lv.initial_stage();
				else
					Lv.Next_stage();
				monster = Lv.initial(monster);
				monster_num = Lv.getMonster_num();
				monster_alive = monster_num;
				if (Infinite_stage >= Infinite_history_stage[0]) {
					Infinite_history_stage[0] = Infinite_stage;
				}
				Infinite_stage = Infinite_stage + 1;
			}
		} else if (monster_alive == 0 && Tofinish_stage < 5) {
			Lv.chose_stage(Tofinish_stage);
			monster = Lv.initial(monster);
			monster_num = Lv.getMonster_num();
			monster_alive = monster_num;
			Tofinish_stage = Tofinish_stage + 1;
		} else if (monster_alive == 0 && Tofinish_stage == 5) {
			page[0] = 6;
			t0.start();
			t1.stop();
			t2.stop();
			t5.stop();
		}
	}

	// fighter fire
	private void fire() {
		if ((attackTime >= attack_speed || BoomTime >= BoomSpeed) && fighter.isVisible()) {
			if (attackTime >= attack_speed) {
				attackTime = 0;
				for (int i = 0; i < store.WeaponLV; i++) {
					bullete_num_counter = bullete_num_counter + 1;
					if (bullete_num_counter >= fighter_bullete_num)
						bullete_num_counter = 0;
					fighter_bullete[bullete_num_counter].Setstart_location(fighter, i);
					fighter_bullete[bullete_num_counter].setVisible(true);
				}
			} else if (BoomTime >= BoomSpeed && store.Bomb == 1) {
				BoomTime = 0;
				boom_num_counter = boom_num_counter + 1;
				if (boom_num_counter >= fighter_boom_num)
					boom_num_counter = 0;
				fighter_boom[boom_num_counter].Setstart_location(fighter);
				fighter_boom[boom_num_counter].setVisible(true);
			}
		}
	}

	// fighter level up
	private void fighter_Lvup() {
		fighter.setExp(fighter.getExp() - fighter.getLvup_Exp());
		fighter.setLvup_Exp(fighter.getLvup_Exp() * 2);
		Hp_and_Exp.Max_Exp = fighter.getLvup_Exp();
		fighter.setLv(fighter.getLv() + 1);
		fighter.setAbility_point(fighter.getAbility_point() + 1);

	}

	// --------------------------------------------------------------------------------------------new
	private void monster_vs_fighter_boom() {
		for (int m = 0; m < monster_num; m++) {
			for (int i = 0; i < fighter_boom_num; i++) {
				if (collide(monster[m], fighter_boom[i]) && fighter_boom[i].isVisible() && monster[m].isVisible()) {
					// burst
					fighter_boom[i].bursting = true;
					burstTime[i] = 56;

					// explode
					for (int e = 0; e < monster_num; e++) {
						if (monster[e].getX() < fighter_boom[i].burstX + fighter_boom[i].burstW
								&& monster[e].getX() > fighter_boom[i].burstX - monster[e].getWidth()
								&& monster[e].getY() < fighter_boom[i].burstY + fighter_boom[i].burstH
								&& monster[e].getY() > fighter_boom[i].burstY - monster[e].getHieght()
								&& monster[e].isVisible())
							monster[e].injured(10 * fighter.getPower());
					}

					fighter_boom[i].setVisible(false);
				}
			}
		}
	}

	private void monster_vs_fighter_bullete() {
		for (int m = 0; m < monster_num; m++) {
			for (int i = 0; i < fighter_bullete_num; i++) {
				if (collide(monster[m], fighter_bullete[i]) && fighter_bullete[i].isVisible()
						&& monster[m].isVisible()) {
					fighter_bullete[i].setVisible(false);
					monster[m].injured(fighter.getPower());
				}
			}
		}
	}

	private void monster_vs_fighter() {
		for (int m = 0; m < monster_num; m++) {
			if (collide(monster[m], fighter) && fighter.isVisible() && monster[m].isVisible()) {
				if (monster[m].getCollideTime() >= monster[m].getCollide_speed()) {
					monster[m].setCollideTime(0);
					fighter.injured(monster[m].getPower() * 2);
				}
			}
		}
	}

	private void monster_bullete_vs_fighter() {
		for (int m = 0; m < monster_num; m++) {
			for (int i = 0; i < monster[m].getBullete_num(); i++) {
				if (collide(monster[m].bullete[i], fighter) && fighter.isVisible()
						&& monster[m].bullete[i].isVisible()) {
					monster[m].bullete[i].setVisible(false);
					fighter.injured(monster[m].getPower());
				}
			}
		}
	}

	private boolean collide(object no1, object no2) {
		if (no1.getX() < no2.getX() + no2.getWidth() && no1.getX() > no2.getX() - no1.getWidth()
				&& no1.getY() < no2.getY() + no2.getHieght() && no1.getY() > no2.getY() - no1.getHieght())
			return true;
		else
			return false;
	}

	public class Mouse extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			if (page[0] == 0) { // menu
				menu.pressButton(e.getX(), e.getY(), page);
			} else if (page[0] == 1) { // select level
				selLV.pressButton(e.getX(), e.getY(), page);
			} else if (page[0] == 2) { // ability
				Ability.pressButton(e.getX(), e.getY(), page);
			} else if (page[0] == 3) { // store
				store.pressButton(e.getX(), e.getY(), page, fighter_money);
			} else if (page[0] == 4) { // about
				about.pressButton(e.getX(), e.getY(), page);
			} else if (page[0] == 5) { // die
				dieUI.pressButton(e.getX(), e.getY(), page);
			} else if (page[0] == 6) { // win
				win.pressButton(e.getX(), e.getY(), page);
			}
//			System.out.println("x:" + e.getX() + "    y:" + e.getY());
		}
	}

	private class Key extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_D) {
				key_pressed[0] = true;
				key_pressed[1] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				key_pressed[1] = true;
				key_pressed[0] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				key_pressed[2] = true;
				key_pressed[3] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				key_pressed[3] = true;
				key_pressed[2] = false;
			}

			if (e.getKeyCode() == KeyEvent.VK_G) {
				fighter_money[0] += 10000;
			}
			if (e.getKeyCode() == KeyEvent.VK_P) {
				Ability.AP += 10;
			}
			if (e.getKeyCode() == KeyEvent.VK_I) {
				if (fighter.isInvincible())
					fighter.setInvincible(false);
				else
					fighter.setInvincible(true);
			}
			if (e.getKeyCode() == KeyEvent.VK_K) {
				for (int m = 0; m < monster_num; m++) {
					if (monster[m].isVisible())
						monster[m].setHp(0);
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_L) {
				fighter.setHp(0);
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE && page[0] == 0) {
				fighter.setMax_Hp(50);
				fighter.setExp(0);
				fighter.setLvup_Exp(100);
				fighter_money[0] = 0;
				fighter.setLv(0);
				Ability.AP = 0;
				Ability.ability[0] = 0;
				Ability.ability[1] = 0;
				Ability.ability[2] = 0;
				Ability.ability[3] = 0;
				store.WeaponLV = 1;
				store.Bomb = 0;
				Infinite_history_stage[0] = 0;
			}

		}

		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_D) {
				key_pressed[0] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_A) {
				key_pressed[1] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_W) {
				key_pressed[2] = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				key_pressed[3] = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Fighter game");
		frame.setSize(600, 800); // makes the mouse location correct
		frame.setLocation(25, 25);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fighterPanel1 p = new fighterPanel1();
		frame.setContentPane(p);
		p.requestFocus(); // 讓鍵盤專注在這個panel
		frame.setVisible(true);
	}
}
