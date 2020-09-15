package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ability_UI {
	private ImageIcon plusButton;
	private ImageIcon abilityFrame;
	private ImageIcon APFrame;
	private ImageIcon menuButton;
	private ImageIcon title;
	private object[] button;
	private object menu;
	public int AP;
	public int[] ability = new int[4];

	public ability_UI() {
		// TODO Auto-generated constructor stub
		plusButton = new ImageIcon(fighterPanel1.class.getResource("plusButton.png"));
		menuButton = new ImageIcon(fighterPanel1.class.getResource("menu.png"));
		abilityFrame = new ImageIcon(fighterPanel1.class.getResource("ability_frame.png"));
		APFrame = new ImageIcon(fighterPanel1.class.getResource("AP_frame.png"));
		title = new ImageIcon(fighterPanel1.class.getResource("ability_title.png"));

		button = new object[4];
		for (int i = 0; i < 4; i++) {
			button[i] = new object();
			button[i].setX(button[i].getFrame_width() - 150);
			button[i].setWidth(80);
			button[i].setHieght(80);
		}

		button[0].setY(300);
		button[1].setY(400);
		button[2].setY(500);
		button[3].setY(600);

		menu = new object(400, 700, 140, 70);

		AP = 0;
	}

	public void pressButton(int x, int y, int[] page) {
		y = y * 600 / 572;
		for (int i = 0; i < 4; i++) {
			if (AP > 0 && ability[i] < 20 && x > button[i].getX() + 2
					&& x < button[i].getX() + button[i].getWidth() - 25 && y > button[i].getY() + 10
					&& y < button[i].getY() + button[i].getHieght() - 20) {
				AP--;
				ability[i]++;
			}
		}

		if (x > menu.getX() - 10 && x < menu.getX() + menu.getWidth() - 20 && y > menu.getY()
				&& y < menu.getY() + menu.getHieght()) {
			page[0] = 0;
		}
	}

	public void draw(Graphics myBuffer) {
		for (int i = 0; i < 4; i++) {
			myBuffer.setColor(Color.white);
			myBuffer.fillRect(110, (int) button[i].getY(), button[i].getFrame_width() - 220, button[i].getHieght());
			myBuffer.fillOval(70, (int) button[i].getY(), button[i].getWidth(), button[i].getHieght());
			myBuffer.fillOval((int) button[i].getX(), (int) button[i].getY(), button[i].getWidth(),
					button[i].getHieght());

			myBuffer.setColor(Color.yellow);
			myBuffer.drawImage(abilityFrame.getImage(), 380, (int) button[i].getY() + 10, 60, 60, null);

			myBuffer.setColor(Color.BLACK);
			myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));

			if (i == 0)
				myBuffer.drawString("Attack Power", 100, (int) button[i].getY() + 50);
			else if (i == 1)
				myBuffer.drawString("Attack Speed", 100, (int) button[i].getY() + 50);
			else if (i == 2)
				myBuffer.drawString("HP", 100, (int) button[i].getY() + 50);
			else
				myBuffer.drawString("Agility", 100, (int) button[i].getY() + 50);

			myBuffer.drawString("" + ability[i], 400, (int) button[i].getY() + 50);

			myBuffer.drawImage(plusButton.getImage(), (int) button[i].getX(), (int) button[i].getY(),
					button[i].getWidth(), button[i].getHieght(), null);
		}

		myBuffer.drawImage(APFrame.getImage(), 110, 220, 200, 60, null);
		myBuffer.setColor(Color.BLACK);
		myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 35));
		myBuffer.drawString("AP:" + AP, 173, 262);

		myBuffer.drawImage(title.getImage(), 50, 30, 500, 148, null);

		myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
				menu.getHieght(), null);
	}
}
