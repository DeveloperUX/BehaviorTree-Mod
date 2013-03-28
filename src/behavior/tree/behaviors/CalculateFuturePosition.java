package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;

public class CalculateFuturePosition extends Behavior {

	public CalculateFuturePosition(Blackboard blackboard) {
		super(blackboard);
	}
	
	public CalculateFuturePosition(Blackboard blackboard, String name) {
		super(blackboard, name);	
	}

	@Override
	public boolean CheckConditions() {
		return false;
	}

	@Override
	public void Start() {
		
	}

	@Override
	public void End() {
			
	}

	@Override
	public void DoAction() {
			
	}
	

}
