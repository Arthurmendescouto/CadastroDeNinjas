package dev.java10x.CadastroDeNinjas.Missoes;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {
    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }
    public List<MissaoModel> listarMissoes(){
        return missaoRepository.findAll();
    }
    public MissaoModel listarMissaoPorId(Long id){
        Optional<MissaoModel> missaoModel= missaoRepository.findById(id);
        return missaoModel.orElse(null);
    }
    public MissaoModel criarMissao(MissaoModel missao){
        return missaoRepository.save(missao);
    }
    public void deletarMissaoPorId(Long id){
        missaoRepository.deleteById(id);
    }
    public MissaoModel atualizarMissao(Long id, MissaoModel missaoAtualizada){
        if(missaoRepository.existsById(id)){
            missaoAtualizada.setId(id);
            return missaoRepository.save(missaoAtualizada);
        }
        return null;
    }
}
