package apipicpay.simplificado.picpay.dominios.transfers;

import java.math.BigDecimal;

public record TransferRecord(
        Long id,
        String payer,
        String payee,
        BigDecimal valor
) {
}
