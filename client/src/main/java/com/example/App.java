package com.example;
import java.io.*;
import java.util.*;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class App {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 3001);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            ObjectMapper objectMapper = new ObjectMapper();

            String message = in.readLine();
            System.out.println(message);

            Alunno c = objectMapper.readValue(message, Alunno.class);

            socket.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
