package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Point;

import game.Background;
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
	
	@Test
	public void launcherTests(){
		tank.changeAngle(15);
		assertEquals(tank.getAngle(), 15);
		tank.changeAngle(9);
		assertEquals(tank.getAngle(), 9);
		Point p = new Point(2,2);
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
		projectile.update();
		assertEquals(projectile.getPositionX(),1.0,0.001);
		assertEquals(projectile.getPositionY(),1.0,0.001);
		assertEquals(projectile.getvX(),1.0, 0.001);
		assertEquals(projectile.getvY(), -31.0, 0.001);
	}
	@Test
	public void TargetTest(){
		Target target = new Target();
		Point p1 = target.getPosition();
		target.hit(100,100);
		Point p2 = target.getPosition();
		assertFalse(p1.x == p2.x);
		assertFalse(p1.y == p2.y);
		
	}
	@Test
	public void GameTest(){
		Target target2 = new Target();
		Point pProjTrue = new Point(20,20);
		Launcher tank = new Launcher(0,0);
		Projectile projectile = new Projectile(pProjTrue,0,0,0);
		assertTrue(tank.collisionDetection(pProjTrue));
		Point pProjFalse = new Point(50,0);
		Projectile projectile2 = new Projectile(pProjFalse,0,0,0);
		assertFalse(tank.collisionDetection(pProjFalse));
		Point pProjTrue2 = new Point(17,22);
		Projectile projectile3 = new Projectile(pProjTrue2,0,0,0);
		assertTrue(tank.collisionDetection(pProjTrue2));	
	}
}
