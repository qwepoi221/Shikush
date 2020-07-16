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
		thread = new Thread(this);
		running = true;
		thread.start();
	}
	
	public void run() {
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
		BufferStrategy bs = this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
		
		
		bs.show();
		g.dispose();
	}
	
	public static void main(String[] args) {
		new Game();

	}
}
