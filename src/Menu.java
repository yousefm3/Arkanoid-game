/**
 * @param <T> the type
 */
public interface Menu<T> extends Animation {
    /**
     * @param key the key
     * @param message the message
     * @param returnVal the return
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * @return status
     */
    T getStatus();
}