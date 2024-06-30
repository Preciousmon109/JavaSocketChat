package za.ac.tut.entity;


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
	
	/**
	 *
	 * @author Precious
	 */
	public class MessageClient {

	    
	    public static void main(String[] args) {
	        InetAddress add;
	        Socket socket = null;
	        BufferedReader in;
	        PrintWriter out;
	        Scanner sc = new Scanner(System.in);
	        String name, text, serverResponse;
	        int option;
	        Message msg;

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

	                    msg = new Message(name, text);
	                    out.println(msg.getName() + "#" + msg.getText();

	                    serverResponse = in.readLine();
	                    System.out.println("Server response: " + serverResponse);
	                } else {
	                    System.out.println(option + " is invalid");
	                }
	                option = getOption();
	                sc.nextLine(); // Consume the newline character
	            }
	        } catch (UnknownHostException ex) {
	            Logger.getLogger(MessageClient.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(MessageClient.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            try {
	                if (socket != null) {
	                    socket.close();
	                }
	            } catch (IOException ex) {
	                Logger.getLogger(MessageClient.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }

	    private static int getOption() {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Please choose one of the following options:\n1 - Send a message\n2 - Exit");
	        return sc.nextInt();
	    }
	    
	}

}
