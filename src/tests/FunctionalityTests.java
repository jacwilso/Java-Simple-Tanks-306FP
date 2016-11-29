package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Point;

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
	@Test
	public void projectileTests(){
		Point pos = new Point(0,0);

		Projectile projectile= new Projectile(pos, Math.sqrt(2), 45);
		assertEquals(projectile.getVelocity().getX(),1.0, 0.001);
		assertEquals(projectile.getVelocity().getY(), 1.0, 0.001);
		projectile.update();
		assertEquals(projectile.getPosition().x,1);
		assertEquals(projectile.getPosition().y,1);
		assertEquals(projectile.getVelocity().getX(),1.0, 0.001);
		assertEquals(projectile.getVelocity().getY(), -31.0, 0.001);
	}
	@Test
	public void TargetTest(){
		Target target = new Target();
		Point p1 = target.getLocation();
		target.update();
		Point p2 = target.getLocation();
		assertFalse(p1.x == p2.x);
		assertFalse(p1.y == p2.y);
		
	}
	@Test
	public void GameTest(){
		Target target2 = new Target();
		game.setTarget(target2);
		Point pProjTrue = new Point(20,20);
		Projectile projectile = new Projectile(pProjTrue, 0,0);
		assertTrue(game.collisionDetection(projectile));
		Point pProjFalse = new Point(50,0);
		Projectile projectile2 = new Projectile(pProjFalse, 0,0);
		assertFalse(game.collisionDetection(projectile2));
		Point pProjTrue2 = new Point(17,22);
		Projectile projectile3 = new Projectile(pProjTrue2, 0,0);
		assertTrue(game.collisionDetection(projectile3));	
	}
}
