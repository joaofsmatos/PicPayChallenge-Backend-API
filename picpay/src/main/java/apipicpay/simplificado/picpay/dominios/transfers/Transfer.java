package apipicpay.simplificado.picpay.dominios.transfers;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "transfers")
@Table(name = "transfers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String payer;
    String payee;
    BigDecimal valor;

    public Transfer(TransferRecord transferRecord) {
        this.id = transferRecord.id();
        this.payer = transferRecord.payer();
        this.payee = transferRecord.payee();
        this.valor = transferRecord.valor();
    }

}