package dev.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.hibernate.annotations.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas=ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninjaBuscado=ninjaService.listarNinjaPorId(id);
        if (ninjaBuscado!=null){

            return ResponseEntity.ok(ninjaBuscado);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).
                body("Ninja com o id: "+id+" não foi encontrado nos nossos registros");
    }

    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro na criação do ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja= ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: "+novoNinja.getNome()+" (ID): "+novoNinja.getId());

    }

    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar ninja por id", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado, nao foi possivel alterar")
    })
public ResponseEntity<?> alterarNinjaPorId(
        @Parameter(description = "Usuário manda id no caminho da requisição")
        @PathVariable Long id,
        @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisicao ")
        @RequestBody NinjaDTO ninjaAtualizado){

        NinjaDTO ninja=ninjaService.atualizarNinja(id,ninjaAtualizado);
        if (ninja!=null) {
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja com o id "+id+" não foi atualizado");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if (ninjaService.listarNinjaPorId(id) !=null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("O ninja com o ID "+id+ "foi deletado  com sucesso");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(" O ninja com o id "+id+" nao foi encontrado");

    }
}
