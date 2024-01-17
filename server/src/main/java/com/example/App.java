package com.example;
import java.io.*;
import java.util.*;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Server started and waiting for connections...");
            ServerSocket server = new ServerSocket(3001);
            Socket client = server.accept();
            System.out.println("client connected successfully!");

            BufferedReader in = new BufferedReader(new java.io.InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            ObjectMapper objectMapper = new ObjectMapper();

            ArrayList<Alunno> students = new ArrayList<>();
            students.add(new Alunno("Vincenzo", "Langone", new Date(2005, 9, 18)));
            students.add(new Alunno("Matteo", "Faginali", new Date(2005, 6, 23)));
            students.add(new Alunno("Lorenzo", "Chelini", new Date(2005, 12, 16)));
            students.add(new Alunno("Davide", "Xie", new Date(2005, 9, 6)));
            students.add(new Alunno("Lorenzo", "Langone", new Date(2008, 12, 4)));

            Classe c = new Classe(5, "CIA", "14-2W", students);
            

            // Serializzazione su stringa
            String json_c = objectMapper.writeValueAsString(c);
            System.out.println(json_c);
            out.writeBytes(json_c + "\n");

            server.close();
            client.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
