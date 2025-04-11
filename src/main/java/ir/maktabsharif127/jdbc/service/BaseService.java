package ir.maktabsharif127.jdbc.service;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID> {

    T create(T t);

    T update(T t);

    List<T> findAll();

    Optional<T> findById(ID id);

    int deleteById(ID id);

    int deleteAll();

    boolean existsById(ID id);

    long countAll();

}
