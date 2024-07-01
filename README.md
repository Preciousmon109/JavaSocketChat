# JavaSocketChat

JavaSocketChat is a simple chat application implemented in Java using sockets. The project consists of a server application and a client application that communicate over TCP/IP.

## Features

- Multiple client support
- Message broadcasting from server to clients
- Simple command-line interface

## Project Structure

- **ServerProject**
  - `common/Message.java`: Defines the Message class used for communication.
  - `server/ChatServerApp.java`: Entry point for the server application.
  - `server/ChatHandlerThread.java`: Handles communication with each client in a separate thread.
Prerequisites
- Java Development Kit (JDK) installed
- Git installed
