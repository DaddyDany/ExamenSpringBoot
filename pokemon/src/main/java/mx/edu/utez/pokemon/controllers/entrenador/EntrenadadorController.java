package mx.edu.utez.pokemon.controllers.entrenador;

import mx.edu.utez.pokemon.controllers.entrenador.dtos.EntrenadorDto;
import mx.edu.utez.pokemon.models.entrenador.Entrenador;
import mx.edu.utez.pokemon.services.entrenador.EntrenadorService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api-pokemon/entrenador")
@CrossOrigin(origins = {"*"})
public class EntrenadadorController {
    @Autowired
    private EntrenadorService service;

    //GETALL
    @GetMapping("/")
    public ResponseEntity<Response<List<Entrenador>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //GETONE
    @GetMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping("/")
    public ResponseEntity<Response<Entrenador>> insert(@Valid @RequestBody EntrenadorDto entrenador){
        return new ResponseEntity<> (
                this.service.insert(entrenador.getEntrenador()),
                HttpStatus.CREATED
        );
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> update(@PathVariable Long id, @Valid @RequestBody EntrenadorDto entrenador){
        return new ResponseEntity<>(
                this.service.update(id, entrenador.getEntrenador()),
                HttpStatus.OK
        );
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Entrenador>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
