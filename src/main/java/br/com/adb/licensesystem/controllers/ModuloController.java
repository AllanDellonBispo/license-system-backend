package br.com.adb.licensesystem.controllers;

import br.com.adb.licensesystem.model.entities.Modulo;
import br.com.adb.licensesystem.model.repositories.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/modulo")
public class ModuloController {

    @Autowired
    private ModuloRepository moduloRepository;

    @PostMapping(path = "cadastra")
    public Modulo cadastra(@RequestBody Modulo modulo){
        return moduloRepository.save(modulo);
    }

    @GetMapping(path = "todos")
    public Iterable<Modulo> exibirTodos(){
        return moduloRepository.findAll();
    }

    @PutMapping(path = "atualiza")
    public Modulo atualiza(@ RequestBody @Validated Modulo modulo){
        return  moduloRepository.save(modulo);
    }
}
