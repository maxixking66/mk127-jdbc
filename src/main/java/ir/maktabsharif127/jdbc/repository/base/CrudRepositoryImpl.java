package ir.maktabsharif127.jdbc.repository.base;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepositoryImpl<T extends BaseEntity<ID>, ID> implements CrudRepository<T, ID> {

    protected final Connection connection;

    public CrudRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T create(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.empty();
    }

    @Override
    public int deleteById(ID id) {
        return 0;
    }

    @Override
    public int deleteAll() {
        return 0;
    }

    @Override
    public boolean existsById(ID id) {
        return false;
    }

    @Override
    public long countAll() {
        return 0;
    }

}
