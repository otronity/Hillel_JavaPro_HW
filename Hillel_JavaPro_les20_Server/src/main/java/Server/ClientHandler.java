package Server;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientHandler implements Runnable{

    private final Socket socket;
    private String name;
    private LocalDateTime dateconnect;

    private static DataInputStream dis = null;

    public ClientHandler(Socket socket, LocalDateTime dt, String name) throws IOException {
        this.socket = socket;
        this.dateconnect = dt;
        this.name = name;
        dis = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run(){
        try {
//            this.name = Thread.currentThread().getName();
            System.out.println(name + ": Получен запрос от клиента");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            String input,output;

            // цикл ожидания сообщений от клиента
            System.out.println("Ожидаем сообщений");
            while (!socket.isClosed()) {
                input = dis.readUTF();
                System.out.println(name + ": " + input);
                if (input.equals("send file")) {
                    reciveFile("src/main/java/Server/test.txt");
                    out.println(" File recieved");
                }
                if (input.equals("exit")) {socket.close();}
                else {out.println(" " + input);}
            }

            System.out.println("Client disconnected");

            out.close();
            dis.close();
            dos.close();


            System.out.println("Close stream");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception ex) {}
        }
    }

    private static void reciveFile(String filename) throws Exception{
        int bytes = 0;
        FileOutputStream fos = new FileOutputStream(filename);

        long size = dis.readLong();
        byte[] buffer = new byte[4*1024];
        while (size > 0 && (bytes = dis.read(buffer, 0 , (int)Math.min(buffer.length, size))) != -1){
            fos.write(buffer,0,bytes);
            size -= bytes;
        }
        fos.close();
    }
}
