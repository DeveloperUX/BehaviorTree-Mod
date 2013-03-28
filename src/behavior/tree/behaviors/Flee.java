package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.Behavior;

public class Flee extends Behavior {

	public Flee(Blackboard blackboard) {
		super(blackboard);
	}
	
	public Flee(Blackboard blackboard, String name) {
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
