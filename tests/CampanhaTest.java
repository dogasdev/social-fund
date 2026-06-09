import domain.entities.Campanha;
import domain.entities.Doador;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class CampanhaTest {

    private Date prazoFuturo() {
        Date d = new Date();
        d.setTime(d.getTime() + 86400000L * 30);
        return d;
    }

    private Campanha novaCampanha(double meta) {
        return new Campanha("Campanha Teste", meta, prazoFuturo(), "ATIVA", 100.0);
    }

    @Test
    void deveAdicionarDoacaoEAumentarTotalArrecado() {
        Campanha campanha = novaCampanha(1000);
        Doador doador = new Doador("Micróbio", 500);
        campanha.adicionarDoacao(doador, 300);
        assertEquals(300, campanha.getTotalArrecadado());
    }

    @Test
    void deveLancarExcecaoAoDoarEmCampanhaQueAtingiuMeta() {
        Campanha campanha = novaCampanha(100);
        Doador doador = new Doador("Australopitecus", 500);
        campanha.adicionarDoacao(doador, 100);
        assertThrows(IllegalStateException.class, () -> {
            campanha.adicionarDoacao(doador, 50);
        });
    }

    @Test
    void deveMudarStatusParaEncerradaAoAtingirMeta() {
        Campanha campanha = novaCampanha(100);
        Doador doador = new Doador("PedroEstranho", 500);
        campanha.adicionarDoacao(doador, 100);
        assertEquals("ENCERRADA", campanha.getStatus());
    }

    @Test
    void deveSortearGanhadorAoAtingirMeta() {
        Campanha campanha = novaCampanha(100);
        Doador doador = new Doador("Mauricio", 500);
        campanha.adicionarDoacao(doador, 100);
        assertNotNull(campanha.getRecompensa());
        assertEquals("Mauricio", campanha.getRecompensa().getNomeGanhador());
    }

    @Test
    void deveCalcularTotalDoadoporDoador() {
        Campanha campanha = novaCampanha(1000);
        Doador doador = new Doador("Agrat", 500);
        campanha.adicionarDoacao(doador, 100);
        campanha.adicionarDoacao(doador, 200);
        assertEquals(300, campanha.calcularTotalDoadoPor(doador));
    }

    @Test
    void deveCalcularProgressoCorretamente() {
        Campanha campanha = novaCampanha(200);
        Doador doador = new Doador("Eiseth", 500);
        campanha.adicionarDoacao(doador,100);
        assertEquals(50, campanha.getProgresso());
    }
}
