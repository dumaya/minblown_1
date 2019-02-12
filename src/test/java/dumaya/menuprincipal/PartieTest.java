package dumaya.menuprincipal;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PartieTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    Partie partie = new Partie();

    /**
     * Test methode choix du jeu
     */
    @Test
    public void Given_SaisieRC_When_choixduJeu_Then_cestparti() {
        System.setIn(new ByteArrayInputStream("R\nC\n".getBytes()));
        System.setOut(new PrintStream(outContent));
        partie.choixduJeu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("C'est parti pour : Jeu : R Mode : C\n"),true);
    }
    @Test
    public void Given_SaisieCR_When_choixduJeu_Then_recommencepuispassequestion2() {
        System.setIn(new ByteArrayInputStream("R\nC\n".getBytes()));
        System.setOut(new PrintStream(outContent));
        partie.choixduJeu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("Choisissez le mode de jeu auquel vous voulez jouer : C pour Challenger, U pour Duel ou D pour Defense\n"),true);
    }
    @Test
    public void Given_Saisie1_When_choixduJeu_Then_recommence1() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        System.setOut(new PrintStream(outContent));
        partie.choixduJeu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("Mauvaise saisie, choix valides : R pour recherche +- ou M pour Mastermind\n"),true);
    }
    @Test
    public void Given_Saisie1D_When_choixduJeu_Then_recommence2() {
        System.setIn(new ByteArrayInputStream("M\n1\n".getBytes()));
        System.setOut(new PrintStream(outContent));
        partie.choixduJeu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("Mauvaise saisie, choix valides : C pour Challenger, U pour Duel ou D pour Defense\n"),true);
    }
    @Test
    public void Given_SaisieLOPMU_When_choixduJeu_Then_cestparti() {
        System.setIn(new ByteArrayInputStream("L\nO\nP\nM\nU".getBytes()));
        System.setOut(new PrintStream(outContent));
        partie.choixduJeu();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals(output.endsWith("C'est parti pour : Jeu : M Mode : U\n"),true);
    }
    /**
     * Test methode initlog
     */
    @Test
    public void initLog() {
    }
    /**
     * Test methode chercherConfig
     */
    @Test
    public void chercherConfig() {
    }

    }
