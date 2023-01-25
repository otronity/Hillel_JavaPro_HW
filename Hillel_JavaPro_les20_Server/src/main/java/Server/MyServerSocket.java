package Server;

import javafx.scene.effect.SepiaTone;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class MyServerSocket {

    private static DataInputStream inStream = null;
    private static DataOutputStream outStream = null;

    public static void main(String[] args) {
        try {

                int port = 9234;
                ServerSocket serverSocket = new ServerSocket(port);
                System.out.println("Server started on port " + port);
                ExecutorService executorService = Executors.newFixedThreadPool(10);

                ArrayList<Socket> clientSocketList = new ArrayList<>();
                int cnt = 0;
                String clientName;
            try {
                while (!serverSocket.isClosed()) {
                    cnt++;
                    Socket clientSocket = serverSocket.accept();
                    clientName = "Client" + cnt;
                    System.out.println(clientName + " connected!");//пишем на сервер что пришел новый клиент
                    //отправляем сообщение остальным клиентам, что пришел новый клиет
                    if (clientSocketList != null) {
                        for (Socket socket : clientSocketList) {
                            if (!socket.isClosed()) {
                                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                                dos.writeUTF("Connected new client: " + clientName);
                                dos.flush();
                                dos.close();
                            }
                        }
                    }
                    clientSocketList.add(cnt - 1, clientSocket);
                    executorService.submit(new ClientHandler(clientSocket, LocalDateTime.now(), clientName));
                }
                executorService.shutdown();
            } finally {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
