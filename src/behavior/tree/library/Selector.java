package behavior.tree.library;

/**
 * This parent task selects one of it's children to update.
 * 
 * To select a child, it starts from the beginning of it's children vector
 * and goes one by one until it finds one that passes the CheckCondition test.
 * It then updates that child until it finished.
 * If the child finishes with failure, it continues down the list looking another
 * candidate to update, and if it doesn't find it, it finishes with failure. 
 * If the child finishes with success, the Selector considers it's task done and 
 * bails with success. 
 * @author Ying
 *
 */
public class Selector extends Branch 
{
	/**
	 * Creates a new instance of the Selector class
	 * @param blackboard Reference to the AI Blackboard data
	 */
	public Selector(Blackboard blackboard)
	{
		super(blackboard);		
	}	
	
	/**
	 * Creates a new instance of the Selector class
	 * @param blackboard Reference to the AI Blackboard data
	 * @param name Name of the class, used for debugging
	 */
	public Selector(Blackboard blackboard, String name)
	{
		super(blackboard, name);		
	}
	
	/**
	 * Chooses the new task to update.
	 * @return The new task, or null if none was found
	 */
	public Task ChooseNewTask()
	{
		Task task = null;
		boolean found = false;
		int curPos = control.subtasks.indexOf(control.curTask);
		
		while(!found)
		{
			if(curPos == (control.subtasks.size() - 1))
			{
				found = true;
				task = null;
				break;
			}
			
			curPos++;
			
			task = control.subtasks.elementAt(curPos);
			if(task.CheckConditions())
			{
				found = true;
			}
		}
		
		return task;
	}

	/**
	 * In case of child finishing with failure we find a new one to update,
	 * or fail if none is to be found
	 */
	@Override
	public void ChildFailed() 
	{
		control.curTask = ChooseNewTask();
		if(control.curTask == null)
		{
			control.FinishWithFailure();
		}		
	}

	/** In case of child finishing with success, our job here is done, finish with success as well */
	@Override
	public void ChildSucceeded() 
	{
		control.FinishWithSuccess();		
	}
}
