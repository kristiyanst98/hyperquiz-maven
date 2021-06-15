package hyperquiz.dao;


import hyperquiz.exceptions.EntityAlreadyExistsException;
import hyperquiz.exceptions.EntityCreationException;
import hyperquiz.exceptions.EntityDataInvalidException;
import hyperquiz.model.Identifiable;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository<K, V extends Identifiable<K>> {
    List<V> findAll();
    Optional<V> findById(K id);
    V create(V entity) throws EntityAlreadyExistsException, IOException;
    V update(V entity) throws Exception;
    V deleteById(K id) throws EntityDataInvalidException;
    long count();
    List<V> createBatch(Collection<V> collection) throws EntityCreationException;
}
