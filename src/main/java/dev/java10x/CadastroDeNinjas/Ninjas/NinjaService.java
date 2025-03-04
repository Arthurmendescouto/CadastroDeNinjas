package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    public List<NinjaModel> listarNinjas(){
        return ninjaRepository.findAll();
    }

    public NinjaModel listarNinjaPorId(Long id){
        Optional<NinjaModel> ninjaModel=ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja= ninjaMapper.map(ninjaDTO);
        ninja=ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    public void deletarNinjaPorId( Long id){
         ninjaRepository.deleteById(id);
    }

    public NinjaModel atualizarNinja(Long id,NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }
}
