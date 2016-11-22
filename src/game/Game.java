package game;

public class Game {
	private Launcher player;
	private Target target;
	private Background background;
	private Obstacle obstacle;
	private ControlPanel control;
	private boolean challenge;
	private Challenge challengeGui;
	public void draw(){
		
	}
	public boolean collisionDetection(Projectile p){
		return false;
	}
	
	public void setTarget(Target t){
		target = t;
	}
}
