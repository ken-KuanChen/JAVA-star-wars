package fighter_game;

import java.awt.Graphics;

public class object {
	private double x, y, dx, dy;
	private int width;
	private int hieght;
	private static int frame_width = 600;
	private static int frame_hieght = 760;
	private boolean visible;
	private int skin;

	public object(double x, double y, int width, int hieght) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.hieght = hieght;
		visible = false;
		skin = 0;
	}

	public object() {

	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHieght(int hieght) {
		this.hieght = hieght;
	}

	public int getHieght() {
		return hieght;
	}
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public int getSkin() {
		return skin;
	}

	public void setSkin(int skin) {
		this.skin = skin;
	}

	public static int getFrame_width() {
		return frame_width;
	}

	public static int getFrame_hieght() {
		return frame_hieght;
	}

}
