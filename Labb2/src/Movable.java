/**
 * Interface for objects which can move forward and turn left and right
 */
public interface Movable {
    /**
     * Move forward
     */
    public void move();

    /**
     * Turn left
     */
    public void turnLeft();

    /**
     * Turn right
     */
    public void turnRight();
}
