package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;
import behavior.tree.library.Blackboard.Event;

public class Chase extends Behavior {
	
	int numTurns = 0;
	int numTurnsDesired = 4;

	public Chase(Blackboard blackboard) {
		super(blackboard);
	}
	
	public Chase(Blackboard blackboard, String name) {
		super(blackboard, name);	
	}

	@Override
	public boolean CheckConditions() {
		if(bb.curEvent == Event.ENEMY_AHEAD) {
			LogTask("Enemy Ahead");
			return true;
		}
		else
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
		LogTask("Chasing");
		// evade takes 1 turn
		if( numTurns >= numTurnsDesired )
			GetControl().Succeeded();		
		else
			numTurns++;
	}
	

}
