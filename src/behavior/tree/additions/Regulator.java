package behavior.tree.additions;

/**
 * Time step class, for regulating update speed of updates.
 * @author Ying
 *
 */
public class Regulator 
{
	/**
	 * Last time the regulator was ready
	 */
	private long lastUpdateTime;
	
	/**
	 * Speed at which the regulator updates
	 */
	private long updateSpeed;
	
	/**
	 * Millisecond constant, to avoid magic numbers
	 */
	private static final int MILSECS = 1000;
	
	/**
	 * Creates a new instance of the Regulator class
	 * @param framesPerSecond is the update speed for this regulator.
	 */
	public Regulator(float framesPerSecond)
	{
		this.updateSpeed = (long) (MILSECS / framesPerSecond);
		this.lastUpdateTime = System.currentTimeMillis();
	}
	
	/**
	 * Returns true if the regulator is ready for a update, false otherwise
	 * @return
	 */
	public boolean IsReady()
	{
		if(System.currentTimeMillis() - this.lastUpdateTime > updateSpeed)
		{
			this.lastUpdateTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}	
}
