import java.sql.*;
import java.util.List;
import java.util.Optional;

public interface Login <T>{
    void save(T entity);
    List<T> findAll();
    Optional<T> findByLogin(T login);
}