package server;

import com.sun.deploy.net.HttpRequest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable{
    int port;
    private ServerSocket serverSocket;
    public HttpServer(){
        this.port = port;
        serverSocket = new ServerSocket(port);
    }
    public void run(){
        System.out.println("Server listening on port: " + port);
        while (true){
            Socket socket = null;
            try{
                socket = serverSocket.accept();
            }catch (IOException e){
                e.printStackTrace();
            }
            HttpRequestHandler handler = new HttpRequestHandler(socket);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();
        }
    }
}
