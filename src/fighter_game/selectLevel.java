package fighter_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class selectLevel {
	private ImageIcon menuButton, GOButton, leftB, rightB, LVBoard;
	private ImageIcon title;
	private ImageIcon[] SL_mode;
	private object menu, GO, SLMode, left, right;
	private int MaxLV;
	public int mode, level;

	public selectLevel() {
		// TODO Auto-generated constructor stub
		menuButton =  new ImageIcon(fighterPanel1.class.getResource("menu.png"));
		title =  new ImageIcon(fighterPanel1.class.getResource("SL_title.png"));
		GOButton =  new ImageIcon(fighterPanel1.class.getResource("SL_GO.png"));
		leftB =  new ImageIcon(fighterPanel1.class.getResource("leftButton.png"));
		rightB =  new ImageIcon(fighterPanel1.class.getResource("rightButton.png"));
		LVBoard =  new ImageIcon(fighterPanel1.class.getResource("LV_board.png"));

		SL_mode = new ImageIcon[2];
		SL_mode[0] =  new ImageIcon(fighterPanel1.class.getResource("SL_Normal.png"));
		SL_mode[1] =  new ImageIcon(fighterPanel1.class.getResource("SL_Infinite.png"));

		menu = new object(400, 700, 140, 70);
		GO = new object(200, 600, 200, 60);
		SLMode = new object(150, 200, 300, 90);
		left = new object(150, 400, 50, 50);
		right = new object(400, 400, 50, 50);
		mode = 0;
		level = 1;
		MaxLV = 10;
	}

	public void pressButton(int x, int y, int[] page) {
		y = y * 600 / 572;
		if (mode == 0) {
			if (level > 1 && x > left.getX() - 10 && x < left.getX() + left.getWidth() -5 && y > left.getY()
					&& y < left.getY() + left.getHieght())
				level--;
				
			else if (level < MaxLV && x > right.getX() - 10 && x < right.getX() + right.getWidth() - 20 && y > right.getY()
					&& y < right.getY() + right.getHieght())
				level++;
		}

		if (x > SLMode.getX() - 10 && x < SLMode.getX() + SLMode.getWidth() - 20 && y > SLMode.getY()
				&& y < SLMode.getY() + SLMode.getHieght())
			mode = 1 - mode;

		if (x > GO.getX() - 10 && x < GO.getX() + GO.getWidth() - 20 && y > GO.getY()
				&& y < GO.getY() + GO.getHieght()) {	//GO
			if(mode == 1)
				page[0] = 100;
			else 
				page[0] = 100+level;
		}

		if (x > menu.getX() - 10 && x < menu.getX() + menu.getWidth() - 20 && y > menu.getY()
				&& y < menu.getY() + menu.getHieght()) {
			page[0] = 0;
		}
	}

	public void draw(Graphics myBuffer) {

		if (mode == 0) {
			myBuffer.drawImage(leftB.getImage(), (int) left.getX(), (int) left.getY(), left.getWidth(), GO.getHieght(),
					null);
			myBuffer.drawImage(rightB.getImage(), (int) right.getX(), (int) right.getY(), right.getWidth(),
					right.getHieght(), null);
			myBuffer.drawImage(LVBoard.getImage(), 200, 350, 200, 150, null);

			myBuffer.setColor(Color.BLACK);
			myBuffer.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
			myBuffer.drawString("LEVEL", 250, 410);
			myBuffer.drawString("     " + level, 250, 460);
		}
		myBuffer.drawImage(SL_mode[mode].getImage(), (int) SLMode.getX(), (int) SLMode.getY(), SLMode.getWidth(),
				SLMode.getHieght(), null);

		myBuffer.drawImage(GOButton.getImage(), (int) GO.getX(), (int) GO.getY(), GO.getWidth(), GO.getHieght(), null);

		myBuffer.drawImage(title.getImage(), 50, 30, 500, 148, null);

		myBuffer.drawImage(menuButton.getImage(), (int) menu.getX(), (int) menu.getY(), menu.getWidth(),
				menu.getHieght(), null);
	}
}
