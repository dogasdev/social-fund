import domain.entities.Doador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DoadorTest {

    @Test
    void deveDepositarCorretamente() {
        Doador doador = new Doador("Micróbio", 500);
        doador.depositar(100);
        assertEquals(600, doador.getDinheiro());
    }

    @Test
    void depositar_deveRetornarFalsoParaValorNegativo() {
        Doador doador = new Doador("SemIdeia", 500);
        assertFalse(doador.depositar(-100));
    }

    @Test
    void depositar_deveRetornarFalsoParaValorZero() {
        Doador doador = new Doador("Socorro", 500);
        assertFalse(doador.depositar(0));
    }

    @Test
    void doar_deveDescontarSaldoCorretamente() {
        Doador doador = new Doador("Atila", 500);
        doador.doar(300);
        assertEquals(200, doador.getDinheiro());
    }

    @Test
    void doar_deveRetornarFalsoCasoSaldoInsuficiente() {
        Doador doador = new Doador("Layla", 50);
        assertFalse(doador.doar(100));
    }

    @Test
    void doar_deveRetornarFalsoCasoValorZeroOuNegativo() {
        Doador doador = new Doador("Hector", 500);
        assertFalse(doador.doar(0));
        assertFalse(doador.doar(-10));
    }
}
