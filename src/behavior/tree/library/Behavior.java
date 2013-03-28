package behavior.tree.library;

/**
 * Leaf task (or node) in the behavior tree.
 *  
 * Specifies a TaskControler, by composition, 
 * to take care of all the control logic, 
 * without burdening the Task class with 
 * complications.
 * 
 * @author Ying
 *
 */
public abstract class Behavior extends Task 
{
	/**
	 * Task controler to keep track of the Task state.
	 */
	protected TaskController control;

	/**
	 * Creates a new instance of the LeafTask class
	 * @param blackboard Reference to the AI Blackboard data
	 */
	public Behavior(Blackboard blackboard) 
	{
		super(blackboard);
		CreateController();
	}
	
	/**
	 * Creates a new instance of the LeafTask class
	 * @param blackboard Reference to the AI Blackboard data
	 * @param name Name of the class for debugging
	 */
	public Behavior(Blackboard blackboard, String name) 
	{
		super(blackboard, name);
		CreateController();
	}
	
	/**
	 * Creates the controller for the class
	 */
	private void CreateController()
	{
		this.control = new TaskController(this);
	}
	
	/**
	 * Gets the controller reference.
	 */
	@Override
	public TaskController GetControl()
	{
		return this.control;
	}
}
