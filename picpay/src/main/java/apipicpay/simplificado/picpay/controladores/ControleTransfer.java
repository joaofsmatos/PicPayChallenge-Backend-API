package apipicpay.simplificado.picpay.controladores;


import apipicpay.simplificado.picpay.dominios.transfers.Transfer;
import apipicpay.simplificado.picpay.dominios.transfers.TransferRecord;
import apipicpay.simplificado.picpay.servicos.ServicoTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")

public class ControleTransfer {

    @Autowired
    private ServicoTransfer servicoTransfer;

    // EndPoint para o sistema web realizar um CREATED, retorna o usuário criado e um HttpStatus (CREATED).
    @PostMapping
    public ResponseEntity<Transfer> criarUsuario(@RequestBody TransferRecord transferRecord) {
        Transfer novoTransfer = servicoTransfer.novaTransferencia(transferRecord);
        return  new ResponseEntity<>(novoTransfer, HttpStatus.CREATED);
    }

    // EndPoint para o sistema web realizar um READ, retorna uma lista de usuários e um HttpStatus (OK).
    @GetMapping
    public ResponseEntity<List<Transfer>> listarUsuarios() {
        var usuarios = this.servicoTransfer.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
