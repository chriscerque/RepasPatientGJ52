package ent.etrs.pdi.hllf.dao;

import java.util.List;

public interface Dao<T, K>
{
    public void create(T type);

    public T read(K cle);

    public void delete(T type);

    public void update(T type);

    public List<T> readAll();

    public boolean exist(T type);

    public void init();
}
