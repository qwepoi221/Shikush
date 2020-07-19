package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity{

	public Player(double x, double y) {
		super(x, y);
		this.id = ID.Player;
		this.width = 100;
		this.height = 100;
	}


	public void tick() {
		
		
	}


	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect((int)x, (int)y, width, height);
		
	}

}
