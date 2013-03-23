package behavior.tree.run;

import behavior.tree.additions.ResetDecorator;
import behavior.tree.behaviors.Chase;
import behavior.tree.behaviors.DodgeWall;
import behavior.tree.behaviors.WallAhead;
import behavior.tree.library.Blackboard;
import behavior.tree.library.ParentTaskController;
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
		((ParentTaskController) avoidanceSequence.GetControl()).Add(new WallAhead(blackboard, "Wall Ahead?"));
		((ParentTaskController) avoidanceSequence.GetControl()).Add(new DodgeWall(blackboard, "Dodge Wall"));
		
		// Ram Car actions
		Task meleeSequence = new Sequence(blackboard, "Melee");		
		((ParentTaskController) meleeSequence.GetControl()).Add(new Chase(blackboard, "Car Ahead?"));
		((ParentTaskController) meleeSequence.GetControl()).Add(new Chase(blackboard, "Ram Car"));
		
		// Add Maneuvering sequences to Selector
		((ParentTaskController) maneuver.GetControl()).Add( avoidanceSequence );
		((ParentTaskController) maneuver.GetControl()).Add( meleeSequence );
//		((ParentTaskController) maneuver.GetControl()).Add(new BackAwayFromObstacleTask(blackboard, "Back Up"));
		
		// Chase sequence
		Task combatSequence = new Sequence(blackboard, "Combat");
//		((ParentTaskController) combatSequence.GetControl()).add(new MoveInDirection(blackboard, "Move In Direction"));
		
		// Add to planner
		((ParentTaskController) root.GetControl()).Add(maneuver);
		((ParentTaskController) root.GetControl()).Add(combatSequence);
		
		// Chase enemy vehicle
//		Task chaseEnemy = new Sequence(blackboard, "Circle chase sequence");
//		((ParentTaskController) chaseEnemy.GetControl()).Add(new ChaseEnemyTask(blackboard, "BackAwayFromObstacle"));
				
	}
	

}
