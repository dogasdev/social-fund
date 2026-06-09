import application.CampanhaService;
import domain.entities.Campanha;
import domain.entities.Doador;
import infrastructure.CampanhaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class CampanhaServiceTest {

    private CampanhaService service;

    @BeforeEach
    void setUp() {
        service = new CampanhaService(new CampanhaRepository());
    }

    private Date prazoFuturo() {
        Date d = new Date();
        d.setTime(d.getTime() + 86400000L * 30);
        return d;
    }

    @Test
    void cadastrarCampanha_deveLancarExcecaoParaCampanhaNula() {
        assertThrows(IllegalStateException.class, () -> {
            service.cadastrarCampanha(null);
        });
    }

    @Test
    void buscarCampanhaPorNome_deveLancarExcecaoParaNomeVazio() {
        assertThrows(IllegalStateException.class, () -> {
            service.buscarCampanhaPorNome("");
        });
    }

    @Test
    void buscarCampanhaPorNome_deveLancarExcecaoParaNomeNulo() {
        assertThrows(IllegalStateException.class, () -> {
            service.buscarCampanhaPorNome(null);
        });
    }

    @Test
    void cancelarCampanha_deveEstornarDoacoes() {
        Campanha campanha = new Campanha("Teste", 1000.0, prazoFuturo(), "ATIVA", 100.0);
        service.cadastrarCampanha(campanha);

        Doador doador = new Doador("Salmonela", 500.0);
        service.realizarDoacao("Teste", doador, 200.0);

        double saldoAntes = doador.getDinheiro();
        service.cancelarCampanha("Teste");

        assertEquals(saldoAntes + 200.0, doador.getDinheiro());
        assertEquals("CANCELADA", campanha.getStatus());
    }

}
