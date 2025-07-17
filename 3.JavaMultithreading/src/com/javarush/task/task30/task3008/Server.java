package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {
        int port;
        ServerSocket serverSocket = null;

        ConsoleHelper.writeMessage("Input server port:");
        port = ConsoleHelper.readInt();

        try {
            serverSocket = new ServerSocket(port);
            ConsoleHelper.writeMessage("Server started successfully.");

            while(true) {
                Socket client = serverSocket.accept();
                Handler handler = new Handler(client);
                handler.start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("An error occurred while starting or running the server.");
        } finally {
            if(serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String clientName: connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Cannot send message to client " + clientName);
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        private Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String clientName = null;
            boolean isClientNameRecieved = false;

            try {
                while (!isClientNameRecieved) {
                    Message nameRequestMessage = new Message(MessageType.NAME_REQUEST);
                    connection.send(nameRequestMessage);

                    Message userNameMessage = connection.receive();

                    if(userNameMessage == null || userNameMessage.getType() != MessageType.USER_NAME) {
                        ConsoleHelper.writeMessage("Message from " + socket.getRemoteSocketAddress() + " has incorrect type");
                        continue;
                    }

                    clientName = userNameMessage.getData();

                    if (clientName == null || clientName.isEmpty()) {
                        ConsoleHelper.writeMessage(socket.getRemoteSocketAddress()
                                + " is trying to connect to the server with an empty name.");
                        continue;
                    }

                    if(connectionMap.containsKey(clientName)) {
                        ConsoleHelper.writeMessage(socket.getRemoteSocketAddress()
                                + " is trying to connect to the server with a name that is already in use.");
                        continue;
                    }

                    connectionMap.put(clientName, connection);
                    Message userNameAcceptedMessage = new Message(MessageType.NAME_ACCEPTED);
                    connection.send(userNameAcceptedMessage);
                    isClientNameRecieved = true;
                }
            } catch (IOException e) {
                throw new IOException(e);
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException(e.getMessage());
            }

            return clientName;
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String existingUserName : connectionMap.keySet()) {
                if(existingUserName.equals(userName)) {
                    continue;
                }
                connection.send(new Message(MessageType.USER_ADDED, existingUserName));
            }
        }

        private  void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message textMessage = connection.receive();
                if (textMessage.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + textMessage.getData()));
                } else {
                    ConsoleHelper.writeMessage("Incorrect message type.");
                }
            }
        }
    }
}
