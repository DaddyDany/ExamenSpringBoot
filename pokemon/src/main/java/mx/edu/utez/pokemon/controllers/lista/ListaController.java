package mx.edu.utez.pokemon.controllers.lista;

import mx.edu.utez.pokemon.controllers.lista.dtos.ListaDto;
import mx.edu.utez.pokemon.models.lista.Lista;
import mx.edu.utez.pokemon.services.lista.ListaService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api-pokemon/lista")
@CrossOrigin(origins = {"*"})
public class ListaController {
    @Autowired
    private ListaService service;

    //GETALL
    @GetMapping("/")
    public ResponseEntity<Response<List<Lista>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //GETONE
    @GetMapping("/{id}")
    public ResponseEntity<Response<Lista>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping("/")
    public ResponseEntity<Response<Lista>> insert(@Valid @RequestBody ListaDto lista){
        return new ResponseEntity<> (
                this.service.insert(lista.getLista()),
                HttpStatus.CREATED
        );
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Response<Lista>> update(@PathVariable Long id, @Valid @RequestBody ListaDto lista){
        return new ResponseEntity<>(
                this.service.update(id, lista.getLista()),
                HttpStatus.OK
        );
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Lista>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
