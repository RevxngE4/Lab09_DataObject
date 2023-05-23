package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Actor persona = new Actor("Доцент", "Moscow, Red Square, 02", LocalDate.parse("1952-02-29"), true, 15);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            mapper.writeValue(new File("persona.json"), persona);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            ActorAndFriends[] actors = mapper.readValue(new File("actors.json"), ActorAndFriends[].class);
            System.out.println(Arrays.toString(actors));
        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}