
import static org.junit.jupiter.api.Assertions.*;

import java.time.DayOfWeek;

import es.uma.informatica.mps.Calendario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalendarioTest {

    @Test
    @DisplayName("Fecha válida en calendario Juliano: 1 de marzo de 4 d.C.")
    @Tag("1") @Tag("4") @Tag("7") @Tag("11")
    void testFechaValidaJuliano() {
        DayOfWeek dia = Calendario.diaSemana(1, 3, 4);
        assertNotNull(dia);
    }

    @Test
    @DisplayName("Fecha válida en calendario Gregoriano: 16 de octubre de 1582")
    @Tag("1") @Tag("4") @Tag("7") @Tag("11")
    void testFechaValidaGregoriano() {
        DayOfWeek dia = Calendario.diaSemana(16, 10, 1582);
        assertNotNull(dia);
    }

    @Test
    @DisplayName("Fecha válida en año bisiesto: 29 de febrero de 1600")
    @Tag("1") @Tag("4") @Tag("7") @Tag("11")
    void testBisiestoValido() {
        DayOfWeek dia = Calendario.diaSemana(29, 2, 1600);
        assertNotNull(dia);
    }

    @Test
    @DisplayName("Fecha inválida: mes 0")
    @Tag("2")
    void testMesMenorQueUno() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(10, 0, 2024);
        });
    }

    @Test
    @DisplayName("Fecha inválida: mes 13")
    @Tag("3")
    void testMesMayorQueDoce() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(10, 13, 2024);
        });
    }

    @Test
    @DisplayName("Fecha inválida: día 0")
    @Tag("5")
    void testDiaMenorQueUno() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(0, 5, 2024);
        });
    }

    @Test
    @DisplayName("Fecha inválida: 31 de abril")
    @Tag("6")
    void testDiaMayorQueMaximoDelMes() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(31, 4, 2024);
        });
    }

    @Test
    @DisplayName("Fecha inválida: año 3")
    @Tag("8")
    void testAnioMenorQueCuatro() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(10, 3, 3);
        });
    }

    @Test
    @DisplayName("Fecha inválida: 1 de enero de 4 d.C.")
    @Tag("9")
    void testAnioCuatroAntesDeMarzo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(1, 1, 4);
        });
    }

    @Test
    @DisplayName("Fecha inválida: 10 de octubre de 1582 (día inexistente)")
    @Tag("10")
    void testHuecoCalendarioGregoriano() {
        assertThrows(IllegalArgumentException.class, () -> {
            Calendario.diaSemana(10, 10, 1582);
        });
    }
}