package biblioteca;
import static org.junit.jupiter.api.Assertions.*;

import biblioteca.gestionelibri.ArchivioLibri;
import biblioteca.gestionelibri.Libro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ArchivioLibriTest {

    private ArchivioLibri archivio;

    @BeforeEach
    void setup() {
        archivio = new ArchivioLibri();
        archivio.aggiungiLibro(new Libro("A", "Autore1", 2000, "111", 2));
        archivio.aggiungiLibro(new Libro("B", "Autore2", 2010, "222", 3));
        archivio.aggiungiLibro(new Libro("A", "Autore3", 2015, "333", 4));
    }

    // TEST 1: Aggiunta diretta di un libro
    @Test
    public void testAggiungiLibro() {
        Libro l = new Libro("Titolo", "Autore", 2020, "1234567890", 3);

        archivio.aggiungiLibro(l);

        assertEquals(4, archivio.getLibri().size());
       assertTrue(archivio.getLibri().contains(l));
    }

    // TEST 2: Rimozione diretta (ritorna il libro)
    @Test
    public void testRimuoviLibro() {
        Libro l = new Libro("Titolo", "Autore", 2020, "1234567890", 3);
        archivio.aggiungiLibro(l);

        Libro rimosso = archivio.rimuoviLibro(l);

        assertNotNull(rimosso, "La rimozione deve restituire il libro rimosso");
        assertEquals(l, rimosso, "Il libro restituito deve essere quello rimosso");
        assertEquals(3, archivio.getLibri().size(), "Dopo la rimozione l’archivio deve avere tre elementi");
    }
    // TEST 3: Ricerca dei libri per i vari campi
    @Test
    void testRicercaISBN() {
        Libro l = archivio.ricercaISBN("111");
        assertNotNull(l);
        assertEquals("A", l.getTitolo());
    }

    @Test
    void testRicercaISBNNonEsistente() {
        assertNull(archivio.ricercaISBN("999"));
    }

    @Test
    void testRicercaTitolo() {
        Set<Libro> trovati = archivio.ricercaTitolo("A");
        assertEquals(2, trovati.size());
    }

    @Test
    void testRicercaAutore() {
        Set<Libro> trovati = archivio.ricercaAutore("Autore2");
        assertEquals(1, trovati.size());
    }
}
