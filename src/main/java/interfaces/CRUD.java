package interfaces;

public interface CRUD<T, R> {
    void create(T entity);
    T read(R id);
    Iterable<T> readAll();
    T update(T entity);
    boolean delete(T entity) throws NoSuchMethodException;
    boolean deleteById(R id);
}
