package behavior.tree.run;

import behavior.tree.additions.ResetDecorator;
import behavior.tree.behaviors.Chase;
import behavior.tree.behaviors.DodgeWall;
import behavior.tree.behaviors.WallAhead;
import behavior.tree.library.Blackboard;
import behavior.tree.library.BranchController;
import behavior.tree.library.Selector;
import behavior.tree.library.Sequence;
import behavior.tree.library.Task;

public class BehaviorTree {
	
	/** Root task of the behavior tree for the AI */
	public Task root;
	/** Shared information blackboard for all AI objects */
	private Blackboard blackboard;
			
	public BehaviorTree(Blackboard bb) {		
		// Set AI the blackboard data.
		blackboard = bb;	
	}
	
	public void Start() {
		root.GetControl().SafeStart();
	}

	public void update( ) {
		root.DoAction();
	}

	/**
	 * Creates the behavior tree and populates the node hierarchy
	 * ORDER MATTERS!!!
	 */
	public void createBehaviorTree() {
				
		// Planner
		root = new Selector(blackboard, "Planner");
		root = new ResetDecorator(blackboard, root, "Planner");
//		rootPlanner = new RegulatorDecorator(blackboard, rootPlanner, "Planner", 0.1f);

		// Maneuvering between obstacles
		Task maneuver = new Selector(blackboard, "Maneuver");
		
		// Avoid Wall actions
		Task avoidanceSequence = new Sequence(blackboard, "Avoidance");
//		avoidanceSequence = new RepeatDecorator(blackboard, avoidanceSequence, "Avoid Wall Reset");
		((BranchController) avoidanceSequence.GetControl()).Add(new WallAhead(blackboard, "Wall Ahead?"));
		((BranchController) avoidanceSequence.GetControl()).Add(new DodgeWall(blackboard, "Dodge Wall"));
		
		// Ram Car actions
		Task meleeSequence = new Sequence(blackboard, "Melee");		
		((BranchController) meleeSequence.GetControl()).Add(new Chase(blackboard, "Car Ahead?"));
		((BranchController) meleeSequence.GetControl()).Add(new Chase(blackboard, "Ram Car"));
		
		// Add Maneuvering sequences to Selector
		((BranchController) maneuver.GetControl()).Add( avoidanceSequence );
		((BranchController) maneuver.GetControl()).Add( meleeSequence );
//		((ParentTaskController) maneuver.GetControl()).Add(new BackAwayFromObstacleTask(blackboard, "Back Up"));
		
		// Chase sequence
		Task combatSequence = new Sequence(blackboard, "Combat");
//		((ParentTaskController) combatSequence.GetControl()).add(new MoveInDirection(blackboard, "Move In Direction"));
		
		// Add to planner
		((BranchController) root.GetControl()).Add(maneuver);
		((BranchController) root.GetControl()).Add(combatSequence);
		
		// Chase enemy vehicle
//		Task chaseEnemy = new Sequence(blackboard, "Circle chase sequence");
//		((ParentTaskController) chaseEnemy.GetControl()).Add(new ChaseEnemyTask(blackboard, "BackAwayFromObstacle"));
				
	}
	

}
