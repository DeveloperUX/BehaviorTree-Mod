package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;

public class Combat extends Behavior {

	public Combat(Blackboard blackboard) {
		super(blackboard);
	}
	
	public Combat(Blackboard blackboard, String name) {
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
