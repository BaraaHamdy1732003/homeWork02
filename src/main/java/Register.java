import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Register <T>{
    void save(T entity);
    List<T> findAll();
    Optional<T> findByLogin(T login);
}
