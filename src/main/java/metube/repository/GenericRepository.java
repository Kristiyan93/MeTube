package metube.repository;

import java.util.List;

public interface GenericRepository<E, I> {

    E save(E entity);

    List<E> findAll();

    E findById(I id);

    long size();

}
