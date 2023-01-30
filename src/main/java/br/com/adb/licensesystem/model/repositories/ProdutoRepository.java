package br.com.adb.licensesystem.model.repositories;

import br.com.adb.licensesystem.model.entities.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query("select p from produtos p")
    public Iterable<Produto> getProdutos2();
}
