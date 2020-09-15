package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class menu {
	private ImageIcon[] menuButton;
	private object[] button;
	private ImageIcon LOGO;

	public menu() {
		// TODO Auto-generated constructor stub
		menuButton = new ImageIcon[5];
		menuButton[0] = new ImageIcon(fighterPanel1.class.getResource("menu_start_button.png"));
		menuButton[1] = new ImageIcon(fighterPanel1.class.getResource("menu_ability_button.png"));
		menuButton[2] = new ImageIcon(fighterPanel1.class.getResource("menu_store_button.png"));
		menuButton[3] = new ImageIcon(fighterPanel1.class.getResource("menu_about_button.png"));
		menuButton[4] = new ImageIcon(fighterPanel1.class.getResource("menu_save_button.png"));
		LOGO = new ImageIcon(fighterPanel1.class.getResource("LOGO.png"));

		button = new object[5];
		for (int i = 0; i < 5; i++) {
			button[i] = new object();
			button[i].setWidth(200);
			button[i].setHieght(44);
			button[i].setX(button[i].getFrame_width() / 2 - button[i].getWidth() / 2);
		}

		for (int i = 0; i < 5; i++) {
			button[i].setY(button[i].getFrame_hieght() / 2 + 50 + 70 * i - button[i].getHieght() / 2);
		}
	}

	public void pressButton(int x, int y, int[] page) {
		y = y * 600 / 572;
		for (int i = 0; i < 5; i++) {
			if (x > button[i].getX() && x < button[i].getX() + button[i].getWidth() && y > button[i].getY()
					&& y < button[i].getY() + button[i].getHieght()) {
				if (i < 4)
					page[0] = i + 1;
				else {
					page[0] = i*2;
				}
			}
		}
	}

	public void draw(Graphics myBuffer) {
		myBuffer.drawImage(LOGO.getImage(),100, 100, 400, 200, null);
		for (int i = 0; i < 5; i++) {
			myBuffer.drawImage(menuButton[i].getImage(), (int) button[i].getX(), (int) button[i].getY(),
					button[i].getWidth(), button[i].getHieght(), null);
		}
	}
}
