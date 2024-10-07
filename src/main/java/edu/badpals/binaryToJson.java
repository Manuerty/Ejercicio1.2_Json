package edu.badpals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class binaryToJson {
    public static void main(String[] args) {
        List<game> games = new ArrayList<game>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("src/main/resources/juegos.bin"))){
            while (true) {
                game game = (edu.badpals.game) reader.readObject();
                games.add(game);
            }
        }catch (
        EOFException e){
            System.out.println("Hemos llegado al final del archivo.");
        }
            catch (
        IOException e) {
            System.out.println("Se ha producido un error de lectura.");
        }catch (ClassNotFoundException e){
            System.out.println("No se ha podido encontrar el archivo.");
        }
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "";

        try {
            mapper.writeValue(new File("src/main/resources/juegos.json"),games);
        }
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }catch (IOException e){
            System.out.println("No se ha podido escribir el archvio correctamente.");
        }
    }

}
