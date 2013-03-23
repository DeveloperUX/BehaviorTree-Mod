package behavior.tree.additions;

import java.util.Random;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Task;
import behavior.tree.library.TaskDecorator;

/**
 * Task decorator that adds a random chance
 * of being selected when checking the conditions
 * @author Ying
 *
 */
public class ChanceDecorator extends TaskDecorator 
{
	/**
	 * Chance of this Task being chosen. 
	 * Range: ]0,100[
	 */
	private float chance;
	
	/**
	 * Random number generator.
	 */
	Random rand;

	public ChanceDecorator(Blackboard blackboard, Task task, float chance) {
		super(blackboard, task);
		Init(chance);
	}

	/**
	 * Creates a new instance of the ChanceDecorator class
	 * @param blackboard Reference to the AI Blackboard data
	 * @param task Task to decorate
	 * @param name Name of the class, for debug purposes
	 * @param chance Chance to choose this task, range ]0,100[
	 */
	public ChanceDecorator(Blackboard blackboard, Task task, String name, float chance) {
		super(blackboard, task, name);
		Init(chance);
		
	}
	
	/**
	 * Private initialization logic
	 * @param chance Chance to choose this task, range ]0,100[
	 */
	private void Init(float chance)
	{
		this.chance = chance;
		if(chance > 100 || chance < 0)
		{
			LogTask("WARNING!! Chance outside range!");
		}
		rand = new Random();
	}

	/**
	 * Calls the decorated DoAction
	 */
	@Override
	public void DoAction() 
	{
		task.DoAction();
	}
	
	/**
	 * Does the tasks normal confirmations plus giving it a random
	 * chance to be chosen.
	 */
	@Override
	public boolean CheckConditions()
	{
		float value = rand.nextFloat() % 100;
		return task.CheckConditions() && value < this.chance;
	}

}
