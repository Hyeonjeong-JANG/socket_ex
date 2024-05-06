package com.example.pathordersocket.socket1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
    ServerSocket serverSocket; // 클라이언트가 이쪽으로 와서 노크해서 성공하면
    Socket socket; // 얘랑 바이트 스트림으로 통신한다.
    BufferedReader br;

    public ServerFile() {
        System.out.println("1. 서버소켓 시작");
        try {
            serverSocket = new ServerSocket(10000);
            System.out.println("2. 서버소켓 생성 완료: 클라이언트 접속 대기 중");
            socket = serverSocket.accept(); // 클라이언트 접속 대기 중...
            System.out.println("3. 클라이언트 연결 완료 - buffer연결완료(read)");

            br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // socket.getInputStream()는 클라이언트와 소켓이 연결된 바이트 스트림 선
            String msg = br.readLine();
            System.out.println("클라이언트로부터 받은 메시지: " + msg);
        } catch (Exception e) {
            System.out.println("서버소켓 에러 발생함" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ServerFile();
    }
}
