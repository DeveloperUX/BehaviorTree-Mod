package behavior.tree.library;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;

import behavior.tree.behaviors.Car;
import behavior.tree.library.Blackboard.Event;

/**
 * Data class for the player AI in the game.
 * Has static members for shared data for all players,
 * and normal members for player-specific data.
 *  
 * @author Ying
 *
 */
public class Blackboard {
	/** Reference to the vector of players in the game */
	public static Vector<Car> players;
	
	/** Reference to the owner player */
	public Car player;
	
	public static enum Event {
		WALL_AHEAD,
		ENEMY_AHEAD,
		ENEMY_BEHIND,
		FLAG_CAPTURED,
		CAPTURED_FLAG_NEARBY,
		HEALTH_LOW
	}
	
	public final Stack<Event> chainOfEvents = new Stack<Event>();
	public Event curEvent;
			
	/**
	 * Creates a new instance of the Blackboard class
	 */
	public Blackboard()	{
		players = new Vector<Car>();
		player = new Car();
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.WALL_AHEAD );
		chainOfEvents.add( Event.WALL_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.WALL_AHEAD );
		chainOfEvents.add( Event.FLAG_CAPTURED );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.ENEMY_AHEAD );
		chainOfEvents.add( Event.WALL_AHEAD );
		chainOfEvents.add( Event.ENEMY_BEHIND );
		chainOfEvents.add( Event.ENEMY_BEHIND );
		chainOfEvents.add( Event.ENEMY_BEHIND );
		chainOfEvents.add( Event.CAPTURED_FLAG_NEARBY );		
	}
	
	public void update() {
		curEvent = chainOfEvents.pop();
	}
}
