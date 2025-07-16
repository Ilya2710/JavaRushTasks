package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    public static void main(String[] args) throws IOException {
        int port;
        ServerSocket serverSocket = null;

        port = ConsoleHelper.readInt();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started successfully.");

            while(true) {
                Socket client = serverSocket.accept();
                Handler handler = new Handler(client);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if(serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (String key: connectionMap.keySet()) {
                connectionMap.get(key).send(message);
            }
        } catch (IOException e) {
            System.out.println("Cannot send message");
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
