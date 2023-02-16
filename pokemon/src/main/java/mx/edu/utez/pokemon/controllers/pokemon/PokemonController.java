package mx.edu.utez.pokemon.controllers.pokemon;

import mx.edu.utez.pokemon.controllers.pokemon.dtos.PokemonDto;
import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.services.pokemon.PokemonService;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api-pokemon/pokemon")
@CrossOrigin(origins = {"*"})
public class PokemonController {
    @Autowired
    private PokemonService service;

    //GETALL
    @GetMapping("/")
    public ResponseEntity<Response<List<Pokemon>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    //GETONE
    @GetMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    //INSERT
    @PostMapping("/")
    public ResponseEntity<Response<Pokemon>> insert(@Valid @RequestBody PokemonDto pokemon){
        return new ResponseEntity<> (
                this.service.insert(pokemon.getPokemon()),
                HttpStatus.CREATED
        );
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> update(@PathVariable Long id, @Valid @RequestBody PokemonDto pokemon){
        return new ResponseEntity<>(
                this.service.update(id, pokemon.getPokemon()),
                HttpStatus.OK
        );
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Response<Pokemon>> delete(@PathVariable Long id){
        return new ResponseEntity<>(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
