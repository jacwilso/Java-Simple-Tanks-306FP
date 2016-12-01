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
	private static Launcher launcher;

	@BeforeClass
	public static void setUp(){
		game = new Game();
		launcher = new Launcher(30, 30);
	}
	

	
	//DONE:
	// CS- Control gui score: test with a collision, the score is increased
	// DD- Target: Test that when the target is hit, it moves
	// DM- addprojectile test
	// DM- finished projectile test
	
	
	//JW- Target position: test the target is drawn properly, in the proper location
	//JW- Target collision: test given an angle, power and target location, does the projectile collide -- Doesn't Craig's collision test essentially test this?
	
	//Craig Notes (Same with the ones for DM and JW)
	//Didn't Rader say that the tests like the ones below can just be tested by running the program? As in no JUnit.
	//CS- Control gui fire: test the projectile is launched
	//CS- Control gui score text field: test the score field updates the display
	//CS- Control gui decrease power: test the power value decreases
	//DM- Control gui increase power: test the power value increases
	//DM- Control gui power display: test the display is updated with a change of value
	//DM- Control gui increase angle: test the angle value is increased
	//DM- Control gui decrease angle: test the angle value is decreased	
	//JW- Control gui edit text angle: test the angle value is changed appropriately
	//JW- Control gui text angle: test the angle display is updated accordingly
	
	@Test
	public void launcherTests(){
		launcher.changeAngle(15);
		assertEquals(launcher.getAngle(), 15);
		launcher.changeAngle(9);
		assertEquals(launcher.getAngle(), 9);
		Point p = new Point(2,2);
		launcher.move(p);
		assertEquals(launcher.getLocation().x, p.x);
		assertEquals(launcher.getLocation().y, p.y);
		launcher.changeVelocity(15.0);
		assertEquals(launcher.getInitialVelocity(), 15.0, 0.01); 
		launcher.changeVelocity(9.0);
		assertEquals(launcher.getInitialVelocity(), 9.0, 0.01);

	}
	
	//Tests that the position of the projectile changes
	@Test
	public void projectileTests(){
		Point pos = new Point(0,0);
		Projectile projectile= new Projectile(pos, 0.0, Math.sqrt(2), 45);
		assertEquals(projectile.getvX(),1.0, 0.001);
		assertEquals(projectile.getvY(), 1.0, 0.001);
		assertEquals(pos.x, projectile.getPositionX(), 0.001);
		assertEquals(pos.y, projectile.getPositionY(), 0.001);
		projectile.setPercent(115);
		projectile.update(); 
		assertNotSame(0.0, projectile.getPositionX());
		assertNotSame(0.0, projectile.getPositionY());
	}
	
	@Test
	public void TargetTest(){
		Target target = new Target();
		Point p1 = new Point(100,260);
		assertTrue(target.getPosition().x==100);
		assertTrue(target.getPosition().y==260);
		target.hit(1000,1000);
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
	
	//Tests the addProjectile function
	@Test 
	public void addProjectileTest(){
		Projectile p = new Projectile(new Point(300, 400), 300, 50.0, 45);
		launcher.addProjectile(p);
		assertEquals(1, launcher.getMissiles().size());
	}
	
}
