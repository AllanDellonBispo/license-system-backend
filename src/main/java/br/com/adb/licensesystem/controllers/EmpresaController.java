package br.com.adb.licensesystem.controllers;

import br.com.adb.licensesystem.model.entities.Empresa;
import br.com.adb.licensesystem.model.entities.Modulo;
import br.com.adb.licensesystem.model.entities.Produto;
import br.com.adb.licensesystem.model.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Empresa cadastraEmpresa(@RequestBody Empresa empresa ){
        empresaRepository.save(empresa);
        return empresa;
    }

    @GetMapping(path = "/todas")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Iterable<Empresa> visualizarEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Empresa> buscaEmpresa(@PathVariable int id){
        return empresaRepository.findById(id);
    }

    @PutMapping
    public Empresa atualizaEmpresa(@Validated @RequestBody Empresa empresa){
        empresaRepository.save(empresa);
        return empresa;
    }

    @PutMapping(path = "/status/{id}")
    public Empresa alteraStatus(@PathVariable int id){
        Optional<Empresa> empresa = empresaRepository.findById(id);
        empresa.get().setAtivo(empresa.get().isAtivo() ? false : true);
        empresaRepository.save(empresa.get());
        return empresa.get();
    }


//@PutMapping(path = "/status/ativa")
//public int ativaEmpresa(){
//         empresaRepository.ativaEmpresa();
//         return 1;
//}



    @GetMapping(path = "/receita")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public float receita(){
        return empresaRepository.receita();
    }

    @GetMapping(path = "/total")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public int totalEmpresas(){
        return empresaRepository.totalEmpresas();
    }

    @GetMapping(path = "/modulos/utilizados")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Object utilizacao(){
        return empresaRepository.modulosUtilizados();
    }
}
