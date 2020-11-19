/**
 * Interface for object that can load and unload
 *
 * @param <T> Type to be loaded
 */
public interface Loadable<T> {
    /**
     * Loads an item
     * @param item item to be loaded
     * @return true if item was loaded, false if ot
     */
    boolean load(T item);

    /**
     * Unloads an item
     * @param item item to be unloaded
     * @return returns unloaded item
     */
    T unload(T item);
}
