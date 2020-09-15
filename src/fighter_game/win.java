package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class win {
	private ImageIcon menuButton;
	private ImageIcon win;
	private object menu;


	public win() {
		// TODO Auto-generated constructor stub
		win = new ImageIcon(fighterPanel1.class.getResource("win.png"));
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

	public void draw(Graphics myBuffer, int lv) {
		myBuffer.drawImage(win.getImage(), 100, 100, 400, 200, null);
		
		myBuffer.setColor(Color.yellow);
		myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		myBuffer.drawString("LEVEL :  " + lv, 400, 400);

		myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
				menu.getHieght(), null);
	}
}
