package edu.badpals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class gameToBinary {
    public static void main(String[] args) {
        List<game> games = new ArrayList<game>();

        game juego1 = new game("The Witcher 3: Wild Hunt");
        juego1.setDescription("The Witcher 3 es un juego de rol de mundo abierto ambientado en un impresionante mundo de fantasía. Controlas a Geralt de Rivia, un cazador de monstruos conocido como un brujo, mientras navegas por un vasto continente lleno de misterio y peligro.");
        juego1.addLanguage("Español");
        juego1.addLanguage("English");
        juego1.addLanguage("Deutch");

        game juego2 = new game("Red Dead Redemption 2");
        juego2.setDescription("Red Dead Redemption 2 es un épico juego de acción y aventuras ambientado en el salvaje oeste americano. Sigues la historia de Arthur Morgan, un forajido en una banda de forajidos, mientras luchan por sobrevivir en una era de cambios y modernización.");
        juego2.addLanguage("Inglés");

        games.add(juego1);
        games.add(juego2);

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("src/main/resources/juegos.bin"))){
            for (edu.badpals.game game : games) {
                writer.writeObject(game);
            }
        }catch (IOException e){
            System.out.println(e.getMessage() + " No se han guardado los juegos.");

        }
    }
}
