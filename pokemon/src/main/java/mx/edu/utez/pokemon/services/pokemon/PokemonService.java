package mx.edu.utez.pokemon.services.pokemon;

import mx.edu.utez.pokemon.models.pokemon.Pokemon;
import mx.edu.utez.pokemon.models.pokemon.PokemonRepository;
import mx.edu.utez.pokemon.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PokemonService {
    @Autowired
    private PokemonRepository Repository;

    //GETALL
    @Transactional(readOnly = true)
    public Response<List<Pokemon>> getAll(){
        return new Response<>(
                this.Repository.findAll(),false,200,"OK"
        );
    }
    //GETONE
    @Transactional(readOnly = true)
    public Response<Pokemon> getOne(Long id){
        return new Response<>(
                this.Repository.findById(id).get(),false,200,"OK"
        );
    }

    //INSERT
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> insert(Pokemon pokemon){
        if(this.Repository.existsPokemonByNombre(pokemon.getNombre())){
            return new Response<>(null,true,400,"El pokemon ya se encuentra registrado");
        }
        return new Response<>(
                this.Repository.saveAndFlush(pokemon),false,200,"ok"
        );
    }

    //UPDATE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> update(Long id,Pokemon pokemon){
        if((!this.Repository.existsById(id))){
            return new Response<>(null,true,400,"Pokemon inexistente");
        }
        return new Response<>(
                this.Repository.saveAndFlush(pokemon),false,200,"OK"
        );
    }

    //DELETE
    @Transactional(rollbackFor = {SQLException.class})
    public Response<Pokemon> delete(Long id){
        Optional<Pokemon> exists = this.Repository.findById(id);

        if((exists.isEmpty())){
            return new Response<>(null,true,400,"Pokemon inexistente");
        }
        this.Repository.deleteById(id);
        return new Response<>(
                null,false,200,"OK"
        );
    }
}
