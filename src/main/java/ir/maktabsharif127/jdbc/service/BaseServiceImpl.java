package ir.maktabsharif127.jdbc.service;

import ir.maktabsharif127.jdbc.domains.base.BaseEntity;
import ir.maktabsharif127.jdbc.repository.base.CrudRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseServiceImpl<
        T extends BaseEntity<ID>, ID, R extends CrudRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;

    @Override
    public T create(T t) {
        return repository.create(t);
    }

    @Override
    public T update(T t) {
        return repository.update(t);
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public int deleteById(ID id) {
        return repository.deleteById(id);
    }

    @Override
    public int deleteAll() {
        return repository.deleteAll();
    }

    @Override
    public boolean existsById(ID id) {
        return repository.existsById(id);
    }

    @Override
    public long countAll() {
        return repository.countAll();
    }
}
