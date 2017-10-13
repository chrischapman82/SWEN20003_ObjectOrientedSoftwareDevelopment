package project1;

public class Skeleton extends Movable {

	private int dir;
	private Timer timer;
	
	
	public Skeleton(float x, float y) {
		super("res/skull.png", x, y);
		this.dir = DIR_UP;
		this.addTag(Tag.SKELETON);
		this.addTag(Tag.ENEMY);
		timer = new Timer(0,Timer.DELTA_IN_SECOND);		// TODO timer target
	}
	
	public void update(int delta) {
		timer.update(delta);
		if (timer.expired()) {
			if (World.isBlocked(this.getDest(dir, App.TILE_SIZE, 1))) {
				
				// switch direction between up/down
				if (dir == DIR_UP) {
					dir = DIR_DOWN;
				} else {
					dir = DIR_UP;
				}
			}
			this.moveDir(dir);
		}
	}
	
	public void onMove(int dir, float testX, float testY) {
		
	}
}
