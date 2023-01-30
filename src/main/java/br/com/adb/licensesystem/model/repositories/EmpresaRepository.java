package br.com.adb.licensesystem.model.repositories;

import br.com.adb.licensesystem.model.entities.Empresa;
import br.com.adb.licensesystem.model.entities.Modulo;
import br.com.adb.licensesystem.model.entities.Produto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmpresaRepository extends CrudRepository<Empresa, Integer> {

    @Modifying
    @Query("update empresas e set e.ativo = 1 where e.id = 2")
    public int ativaEmpresa();

    @Query(value = "select sum(m.valor) from modulos m inner join empresas_modulos e on m.id = e.modulos_id",
        nativeQuery = true)
    public float receita();

    @Query(value = "select count(*) from empresas e",
            nativeQuery = true)
    public int totalEmpresas();

    @Query(value = "select count(m.nome) as 'QtdCadastrada', count(em.modulos_id) as 'QtdUtilizada' from modulos m left join empresas_modulos em on m.id = em.modulos_id",
            nativeQuery = true)
    public Object modulosUtilizados();


//    SELECT
//    count(m.nome) as "Qtd módulos",
//    count(em.modulos_id) as "Módulos utilizados"
//    FROM modulos m left join empresas_modulos em on m.id = em.modulos_id;
}
