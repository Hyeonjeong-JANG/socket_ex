package com.example.pathordersocket.socket1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientFile {
    Socket socket;
    BufferedWriter bw;
    BufferedReader br;

    public ClientFile() {


        try {
            System.out.println("1. 클라이언트 소켓 시작");
            socket = new Socket("localhost", 10000); // 서버소켓의 accept()가 호출됨

            System.out.println("2. 버퍼(write)연결 완료");
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 키보드 연결
            System.out.println("3. 키보드 스트림 + 버퍼(write)연결 완료");
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("4. 키보드 입력 대기 중");
            String keyboardMsg = br.readLine();
            // 메시지의 끝에 \n 반드시 붙여라.
            bw.write(keyboardMsg + "\n");
            bw.flush();
        } catch (Exception e) {
            System.out.println("클라이언트소켓 에러 발생함" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ClientFile();
    }
}
