package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;

public class TestAction extends Behavior {

	public TestAction(Blackboard blackboard) {
		super(blackboard);
	}
	
	public TestAction(Blackboard blackboard, String name) {
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
