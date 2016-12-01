package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Point;

import game.Background;
import game.Bird;
import game.ControlPanel;
import game.Game;
import game.Launcher;
import game.Projectile;
import game.Target;

public class FunctionalityTests {
	private static Game game;
	private static Launcher tank;
	private static ControlPanel control;
	private static Background back;

	@BeforeClass
	public static void setUp(){
		game = new Game();
		tank = new Launcher(30, 30);
	}
	
	//DD- Launcher updates: test the launcher angle barrel changes with a change of angle
	//DD- Launcher trajectory: test the trajectory is displayed accurately
	//DD- Projectile trajectory: projectile follows trajectory given angle and velocity
	
	//DONE CS- Control gui score: test with a collision, the score is increased
	
	//DM- Control gui increase power: test the power value increases
	//DM- Control gui power display: test the display is updated with a change of value
	//DM- Control gui increase angle: test the angle value is increased
	//DM- Control gui decrease angle: test the angle value is decreased
	
	//JW- Control gui edit text angle: test the angle value is changed appropriately
	//JW- Control gui text angle: test the angle display is updated accordingly
	//JW- Target position: test the target is drawn properly, in the proper location
	//JW- Target collision: test given an angle, power and target location, does the projectile collide
	
	//Craig Notes
	//Didn't Rader say that the tests like the ones below can just be tested by running the program? As in no JUnit.
	//CS- Control gui fire: test the projectile is launched
	//CS- Control gui score text field: test the score field updates the display
	//CS- Control gui decrease power: test the power value decreases
	
	@Test
	public void launcherTests(){
		tank.changeAngle(15);
		assertEquals(tank.getAngle(), 15);
		tank.changeAngle(9);
		assertEquals(tank.getAngle(), 9);
		Point p = new Point(2,2);
		//DD-Launcher move: test the position of the launcher moves
		tank.move(p);
		assertEquals(tank.getLocation().x, p.x);
		assertEquals(tank.getLocation().y, p.y);
		tank.changeVelocity(15.0);
		assertEquals(tank.getInitialVelocity(), 15.0, 0.01); 
		tank.changeVelocity(9.0);
		assertEquals(tank.getInitialVelocity(), 9.0, 0.01);
	}
	@Test
	public void projectileTests(){
		Point pos = new Point(0,0);
		Projectile projectile= new Projectile(pos, 0.0, Math.sqrt(2), 45);
		assertEquals(projectile.getvX(),1.0, 0.001);
		assertEquals(projectile.getvY(), 1.0, 0.001);
		projectile.update(); //WHY DOESNT THIS UPDATE THE POSITION AND VELOCITY OF THE F**** PROJECTILE
		//Testing that the projectile hits the tank
		Launcher tank = new Launcher(0,0);
		System.out.println(tank.getLocation().x + " " + tank.getLocation().y);
		System.out.println(projectile.getPositionX() + " " + projectile.getPositionY());
		assertTrue(projectile.tankCollisionDetection(tank.getLocation()));
	}
	@Test
	public void TargetTest(){
		Target target = new Target();
		Point p1 = target.getPosition();
		target.hit(100,100);
		//WHY DOESNT THIS PUT THE TARGET AT A NEW LOCATION
		Point p2 = target.getPosition();
		assertFalse(p1.x == p2.x);
		assertFalse(p1.y == p2.y);
		
	}
	
	@Test
	public void CollisionTests(){
		//test target hit
		Target target = new Target(new Point(200,200));
		Projectile projectile = new Projectile(new Point(200,200), 0, 0, 0);
		Launcher tank = new Launcher(100,100);
		tank.addProjectile(projectile);
		if(tank.collisionDetection(target.getPosition(),11))
			tank.addScore(100);
		assertTrue(tank.getScoreValue() == 100);
		//test collision with self
		Projectile projectile2 = new Projectile(new Point(101,101), 0, 0, 0);
		tank.addProjectile(projectile2);
		tank.tankCollisionDetection();
		assertTrue(tank.getScoreValue() == 0);
		//test collision with bird
		Bird bird = new Bird();
		bird.setLocation(300, 300);
		Projectile projectile3 = new Projectile(new Point(300,300), 0, 0, 0);
		tank.addProjectile(projectile3);
		if(tank.collisionDetection(bird.getLocation(),11))
			tank.addScore(-50);
		assertTrue(tank.getScoreValue() == -50);
	}
}
