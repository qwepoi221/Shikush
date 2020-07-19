package mainPack;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Window window;
	public boolean running;
	Thread thread;
	
	public Game() {
		window = new Window(this);
		
	}
	
	public synchronized void start() {
		//starting a thread for the "run" loop
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public void run() {
		//Everything here is a loop that calls the "tick" method 60 times in a second, and calls the "render" method for the rest of the time
		double lastTime = System.nanoTime();
		double ns = 1000000000/60;
		double delta =0;
		while(running) {
			double now = System.nanoTime();
			delta +=(now-lastTime)/ns;
			lastTime = now;
			if(delta>1) {
				delta-=1;
				tick();
			}
			render();
		}
	}
	
	public void tick() {
		
	}
	
	public void render() {
		//creating the graphics tool
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//----------------------------------------------------
		//filling the screen in black, temporary background...
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		//put all of the staff you want to draw here:
		
		//-------------------------------------------
		//showing the staff you drew and disposing the graphics tool
		bs.show();
		g.dispose();
	}
	
	public static void main(String[] args) {
		new Game();

	}
}
