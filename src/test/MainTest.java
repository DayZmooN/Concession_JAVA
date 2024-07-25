package test;

import Main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void choix() {
        //la valeur que je veut tester
        String input  ="5";
        /*
        ByteArrayInputStream est utilisé pour simuler l'entrée
        de l'utilisateur.
        System.setIn(in) redirige System.in vers
        le flux d'entrée que vous avez créé.
         */
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Main.choix();

        Assertions.assertEquals(5, result);
    }
}