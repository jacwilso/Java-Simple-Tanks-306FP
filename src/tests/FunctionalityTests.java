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
	

	
	
	//Tests that the launcher functions work
	@Test
	public void launcherTests(){
		//checks that the angle changes
		launcher.changeAngle(15);
		assertEquals(launcher.getAngle(), 15);
		launcher.changeAngle(9);
		assertEquals(launcher.getAngle(), 9);
		//checks that the launcher moves
		Point p = new Point(2,2);
		launcher.move(p);
		assertEquals(launcher.getLocation().x, p.x);
		assertEquals(launcher.getLocation().y, p.y);
		//checks that the velocity changes
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
	
	//Tests that the target moves
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
