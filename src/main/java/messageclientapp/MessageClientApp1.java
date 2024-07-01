package messageclientapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.ac.tut.entity.Message;


public class MessageClientApp1 {
	public static void main(String[] args) {
		InetAddress add;
        Socket socket = null;
        BufferedReader in;
        PrintWriter out;
        Scanner sc = new Scanner(System.in);
        String name, text, serverResponse;
        int option;

        option = getOption();
        sc.nextLine(); // Consume the newline character

        try {
            add = InetAddress.getByName("127.0.0.1");
            socket = new Socket(add, 9090);

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            while (option != 2) {
                if (option == 1) {
                    System.out.println("Enter your name:");
                    name = sc.nextLine();
                    System.out.println("Enter your message:");
                    text = sc.nextLine();

                    Message message = new Message(name, text);
                    out.println(message.getName() + "#" + message.getText());

                    serverResponse = in.readLine();
                    System.out.println("Server response: " + serverResponse);
                } else {
                    System.out.println(option + " is invalid");
                }
                option = getOption();
                sc.nextLine(); // Consume the newline character
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MessageClientApp1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MessageClientApp1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(MessageClientApp1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static int getOption() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose one of the following options:\n1 - Send a message\n2 - Exit");
        return sc.nextInt();
    }
}