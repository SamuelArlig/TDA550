public interface Loadable<T> {
    void load(T item);
    void unload(T item);
}
