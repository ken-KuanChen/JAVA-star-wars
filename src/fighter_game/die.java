package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class die {
	private ImageIcon RIP;
	private ImageIcon menuButton;
	private object menu;

	public die() {
		// TODO Auto-generated constructor stub
		RIP = new ImageIcon(fighterPanel1.class.getResource("RIP.png"));
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

	public void draw(Graphics myBuffer, int mode, int CS, int HS) {
			myBuffer.drawImage(RIP.getImage(),100, 100, 400, 500, null);

			myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
					menu.getHieght(), null);
			
			if(mode == 1) {
				CS--;
				myBuffer.setColor(Color.yellow);
				myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
				myBuffer.drawString("Current Stage :  " + CS, 300, 630);
				myBuffer.drawString("History Stage :  " + HS, 300, 670);
			}
				
	}
}
