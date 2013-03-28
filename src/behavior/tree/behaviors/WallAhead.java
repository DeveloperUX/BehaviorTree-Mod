package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;
import behavior.tree.library.Blackboard.Event;

public class WallAhead extends Behavior {
	
	int numTurns = 0;
	int numTurnsDesired = 1;

	public WallAhead(Blackboard blackboard) {
		super(blackboard);
	}
	
	public WallAhead(Blackboard blackboard, String name) {
		super(blackboard, name);	
	}

	@Override
	public boolean CheckConditions() {
		if(bb.curEvent == Event.WALL_AHEAD) {
			LogTask("Yes");
			return true;
		}
		return false;
	}

	@Override
	public void Start() {
		numTurns = 0;
	}

	@Override
	public void End() {
		numTurns = 0;
	}

	@Override
	public void DoAction() {
		
		// evade takes 1 turn
		if( numTurns >= numTurnsDesired )
			GetControl().Succeeded();		
		else
			numTurns++;
	}
	

}
