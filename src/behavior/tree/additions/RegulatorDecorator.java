package behavior.tree.additions;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Task;
import behavior.tree.library.TaskDecorator;


/**
 * Decorator that adds a update speed limit to the task it is applied to
 * @author Ying
 *
 */
public class RegulatorDecorator extends TaskDecorator 
{
	/**
	 * Regulator to keep track of time
	 */
	private Regulator regulator;
	
	/**
	 * Update time in seconds per frame
	 */
	private float updateTime;
	
	/**
	 * Creates a new instance of the RegulatorDecorator class
	 * @param blackboard Reference to the AI Blackboard data
	 * @param task Task to decorate
	 * @param name Name of the class, used for debugging
	 * @param updateTime Time between each frame update
	 */
	public RegulatorDecorator(Blackboard blackboard, Task task, String name, float updateTime) 
	{
		super(blackboard, task, name);
		this.updateTime = updateTime;
	}
	
	/**
	 * Creates a new instance of the RegulatorDecorator class
	 * @param blackboard Reference to the AI Blackboard data
	 * @param task Task to decorate
	 * @param updateTime Time between each frame update
	 */
	public RegulatorDecorator(Blackboard blackboard, Task task, float updateTime) 
	{
		super(blackboard, task);
		this.updateTime = updateTime;
	}

	/**
	 * Starts the task and the regulator
	 */
	@Override 
	public void Start()
	{
		task.Start();
		this.regulator = new Regulator(1.0f/updateTime);
	}
	
	/**
	 * Updates the decorated task only if the required time since the last
	 * update has elapsed.
	 */
	@Override
	public void DoAction() 
	{
		if(this.regulator.IsReady())
		{
			task.DoAction();
		}
	}
}
