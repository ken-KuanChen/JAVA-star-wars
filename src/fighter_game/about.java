package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class about {
	private ImageIcon menuButton;
	private ImageIcon about;
	private object menu;


	public about() {
		// TODO Auto-generated constructor stub
		about = new ImageIcon(fighterPanel1.class.getResource("about.png"));
		menuButton = new ImageIcon(fighterPanel1.class.getResource("menu.png"));
		menu = new object(400, 700, 140, 70);

	}

	public void pressButton(int x, int y, int[] page) {
		y = y * 600 / 572;

		if (x > menu.getX() - 10 && x < menu.getX() + menu.getWidth() - 20 && y > menu.getY()
				&& y < menu.getY() + menu.getHieght()) {
			page[0] = 0;
		}
	}

	public void draw(Graphics myBuffer) {
		myBuffer.drawImage(about.getImage(), 0, 0, 600, 800, null);
		

		myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
				menu.getHieght(), null);
	}
}
