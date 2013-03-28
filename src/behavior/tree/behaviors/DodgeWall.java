package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;
import behavior.tree.library.Blackboard.Event;

public class DodgeWall extends Behavior {

	int numTurns = 0;
	int numTurnsDesired = 1;
	
	public DodgeWall(Blackboard blackboard) {
		super(blackboard);
	}
	
	public DodgeWall(Blackboard blackboard, String name) {
		super(blackboard, name);	
	}

	@Override
	public boolean CheckConditions() {
		return true;
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
		
		// evade takes 2 turn
		if( numTurns >= numTurnsDesired ) {
			LogTask("Dodged Wall");
			GetControl().Succeeded();		
		}
		else {
			LogTask("Dodging Wall");
			numTurns++;
		}
	}
	

}
