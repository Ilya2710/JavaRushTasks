package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        try {
            this.socket = socket;
            this.out = new ObjectOutputStream (socket.getOutputStream());
            this.in =  new ObjectInputStream (socket.getInputStream());
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public void send(Message message) throws IOException {
        synchronized (out) {
            try {
                out.writeObject(message);
            } catch (IOException e) {
                throw new IOException(e);
            }
        }
    }

    public Message receive() throws IOException, ClassNotFoundException {
        Message message;

        synchronized (in) {
            try {
                message = (Message) in.readObject();
            } catch (IOException e) {
                throw new IOException(e);
            } catch (ClassNotFoundException e) {
                throw new ClassNotFoundException(e.getMessage(), e);
            }
        }

        return message;
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
