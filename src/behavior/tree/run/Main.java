package behavior.tree.run;

import behavior.tree.library.Blackboard;


public class Main {
	
	public static void main(String[] args) {
		System.out.println("System Starting...");
		
		Blackboard bb = new Blackboard();
		BehaviorTree tree = new BehaviorTree(bb);
		
		tree.createBehaviorTree();
		tree.Start();
		
		long lastUpdateTime = System.currentTimeMillis();
		long updateSpeed = (long) 1000; // milliseconds 
		
		while( !bb.chainOfEvents.isEmpty() ) {

			if(System.currentTimeMillis() - lastUpdateTime > updateSpeed) {
				lastUpdateTime = System.currentTimeMillis();
				bb.update();
				System.out.println("STATE :: " + bb.curEvent);
			}

			tree.update();
		}
		
	}

}
