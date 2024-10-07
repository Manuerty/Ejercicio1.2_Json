package edu.badpals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class readJsonFile {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            List<game> juegos = mapper.readValue(new File("src/main/resources/juegos.json"), new TypeReference<List<game>>(){});
            for (edu.badpals.game game : juegos){
                System.out.println(game.getName() + "\n" + game.getLanguages());
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Error al leer el archivo");
        }

    }
}
