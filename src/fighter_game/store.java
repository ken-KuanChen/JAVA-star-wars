package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class store {
	private ImageIcon menuButton;
	private ImageIcon board1, board2, buyButton, infoBoard;
	private object menu;
	private object[] buy = new object[2];
	public int WeaponLV, Bomb, money, BombExp;
	private int[] upExp = new int[4];

	public store() {
		// TODO Auto-generated constructor stub

board1 = new ImageIcon(fighterPanel1.class.getResource("store_upgradeWeapons.png"));
		board2 = new ImageIcon(fighterPanel1.class.getResource("store_bomb.png"));
		infoBoard = new ImageIcon(fighterPanel1.class.getResource("info_board1.png"));
		buyButton = new ImageIcon(fighterPanel1.class.getResource("store_buy.png"));
		menuButton = new ImageIcon(fighterPanel1.class.getResource("menu.png"));


		buy[0] = new object(20, 250, 230, 69);
		buy[1] = new object(350, 250, 230, 69);
		menu = new object(400, 700, 140, 70);

		WeaponLV = 1;
		Bomb = 0;
		money = 1111110;
		upExp[0] = 10000;
		upExp[1] = 20000;
		upExp[2] = 40000;
		upExp[3] = 80000;
		BombExp = 200000;
	}

	public void pressButton(int x, int y, int[] page, int[] money) {
		y = y * 600 / 572;

		for (int i = 0; i < 2; i++) {
			if (x > buy[i].getX() - 10 && x < buy[i].getX() + buy[i].getWidth() - 20 && y > buy[i].getY()
					&& y < buy[i].getY() + buy[i].getHieght()) {
				if (i==0 && WeaponLV < 5) {
					if(money[0] >= upExp[WeaponLV-1]) {
						money[0] -= upExp[WeaponLV-1];
						WeaponLV++;
					}
				}
				else if (i==1 && Bomb == 0) {
					if(money[0] >= BombExp) {
						money[0] -= BombExp;
						Bomb = 1;
					}
				}
			}
		}
		if (x > menu.getX() - 10 && x < menu.getX() + menu.getWidth() - 20 && y > menu.getY()
				&& y < menu.getY() + menu.getHieght()) {
			page[0] = 0;
		}
	}

	public void draw(Graphics myBuffer, int money) {
		myBuffer.drawImage(board1.getImage(), 20, 0, 230, 237, null);
		if (WeaponLV < 5) {
			myBuffer.setColor(Color.red.darker());
			myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			myBuffer.drawString("price:" + upExp[WeaponLV-1] + "$", 70, 220);
		}

		myBuffer.drawImage(board2.getImage(), 350, 0, 230, 237, null);
		if (Bomb == 0) {
			myBuffer.setColor(Color.red.darker());
			myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
			myBuffer.drawString("price:" + BombExp + "$", 400, 220);
		}
		myBuffer.drawImage(infoBoard.getImage(), 50, 350, 500, 340, null);

		myBuffer.setColor(Color.BLACK);
		myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		myBuffer.drawString("Weapons Level:  " + WeaponLV, 100, 420);
		myBuffer.drawString("Have Bomb:   " + Bomb, 100, 470);
		myBuffer.drawString("Your money:   " + money + "$", 100, 600);

		myBuffer.drawImage(buyButton.getImage(), (int) buy[0].getX(), (int) buy[0].getY(), buy[0].getWidth(),
				buy[0].getHieght(), null);
		myBuffer.drawImage(buyButton.getImage(), (int) buy[1].getX(), (int) buy[1].getY(), buy[1].getWidth(),
				buy[1].getHieght(), null);

		myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
				menu.getHieght(), null);
	}
}
