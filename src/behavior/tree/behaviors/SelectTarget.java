package behavior.tree.behaviors;

import behavior.tree.library.Blackboard;
import behavior.tree.library.LeafTask;

public class SelectTarget extends LeafTask {

	public SelectTarget(Blackboard blackboard) {
		super(blackboard);
	}
	
	public SelectTarget(Blackboard blackboard, String name) {
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
