package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static DataInputStream inStream = null;
    private static DataOutputStream outStream = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int port = 9234;

        try{
            Socket clientSocket = new Socket("localhost", port);
            System.out.println("Client connected to socket");

            inStream = new DataInputStream(clientSocket.getInputStream());
            outStream = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String clientMessage = "start", serverMessage = "";

            while(!clientMessage.equals("exit")){
                    clientMessage = scanner.nextLine();
                    if (clientMessage.equals("file")) {
                        outStream.writeUTF("send file");
                        outStream.flush();
                        sendFile("src/main/java/Client/test.txt");
                    } else {
                        outStream.writeUTF(clientMessage);
                        outStream.flush();
                    }

                if (in.read() > -1) {
                    System.out.println("reading...");
                    serverMessage = in.readLine();
                    System.out.println("Server send message: " + serverMessage);
                }
            }
            outStream.close();
            clientSocket.close();

        } catch (IOException e){
            System.out.println("Exception: trying connect to server on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void sendFile(String path) throws Exception{
        int bytes = 0;
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);

        outStream.writeLong(file.length());
        byte[] buffer = new byte[4*1024];
        while((bytes = fis.read(buffer)) != -1){
            outStream.write(buffer, 0 , bytes);
            outStream.flush();
        }
        fis.close();
    }
}
