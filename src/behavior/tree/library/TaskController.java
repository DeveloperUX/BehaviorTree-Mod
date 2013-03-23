package behavior.tree.library;

/**
 * Class added by composition to any task, to keep track of the Task state
 * and logic flow. 
 * 
 * This state-control class is separated from the Task class so the Decorators
 * have a chance at compile-time security.
 * @author Ying
 *
 */
public class TaskController 
{
	/**
	 * Indicates whether the task is finished or not
	 */
	private boolean done;
	
	/**
	 * If finished, it indicates if it has finished with success or not
	 */
	private boolean sucess;
	
	/**
	 * Indicates if the task has started or not
	 */
	private boolean started;
	
	/**
	 * Reference to the task we monitor
	 */
	private Task task;
	
	/**
	 * Creates a new instance of the TaskController class
	 * @param task Task to controll.
	 */
	public TaskController(Task task)
	{
		SetTask(task);
		Initialize();
	}
	
	/**
	 * Initializes the class data
	 */
	private void Initialize()
	{
		this.done = false;
		this.sucess = true;
		this.started = false;
	}
	
	/**
	 * Sets the task reference
	 * @param task Task to monitor
	 */
	public void SetTask(Task task)
	{
		this.task = task;
	}
	
	/**
	 * Starts the monitored class
	 */
	public void SafeStart()
	{
		this.started = true;
		task.Start();
	}
	
	/**
	 * Ends the monitored task
	 */
	public void SafeEnd()
	{
		this.done = false;
		this.started = false;
		task.End();
	}
	
	/**
	 * Ends the monitored class, with success
	 */
	protected void FinishWithSuccess()
	{
		this.sucess = true;
		this.done = true;
//		task.LogTask("Finished with success");
	}

	/**
	 * Ends the monitored class, with failure
	 */
	protected void FinishWithFailure()
	{
		this.sucess = false;
		this.done = true;
//		task.LogTask("Finished with failure");
	}
	
	/**
	 * Indicates whether the task finished successfully
	 * @return True if it did, false if it didn't
	 */
	public boolean Succeeded() 
	{
		return this.sucess;
	}
	
	/**
	 * Indicates whether the task finished with failure
	 * @return True if it did, false if it didn't
	 */
	public boolean Failed()
	{
		return !this.sucess;
	}
	
	/**
	 * Indicates whether the task finished
	 * @return True if it did, false if it didn't
	 */
	public boolean Finished() 
	{
		return this.done;
	}
	
	/**
	 * Indicates whether the class has started or not
	 * @return True if it has, false if it hasn't
	 */
	public boolean Started()
	{
		return this.started;
	}
	
	/**
	 * Marks the class as just started.
	 */
	public void Reset()
	{
		this.done = false;
	}
}
