# java-client-server

A Java project demonstrating TCP client-server communication and Swing desktop applications.

## Functionalities

### Number Exchange Client-Server

- Accepts a number between 5 and 30 through a Swing interface
- Sends the value to a TCP server on port `9000`
- Receives and displays nine calculated values in a 3 × 3 grid

### File Transfer Client-Server

- Lets the user select a file through a Swing file dialog
- Sends the file to the server over a TCP connection
- Saves the received file as `DATA_SERVER/primljen_fajl.bin`

### Button Shuffle UI

- Displays 16 buttons in a 4 × 4 grid
- Randomly rearranges the buttons when the user clicks **START**

## Technologies

- Java
- Java Swing and AWT
- TCP sockets (`Socket`, `ServerSocket`)
- Java I/O streams
- Multithreading with `Thread`

No external libraries or build tools are required.

## How to Run

Compile the source files from the project root:

```powershell
javac -d out src\A1\*.java src\B0\*.java src\C1\*.java src\Main.java
```

Run one of the following applications:

```powershell
# Number exchange exercise — start the server first
java -cp out A1.Server
java -cp out A1.Klijent

# File transfer exercise — start the server first
java -cp out B0.Server
java -cp out B0.KlijentB0

# Button shuffle UI
java -cp out C1.Program
```

For the client-server exercises, run the server and client in separate terminals. Both server applications use port `9000`, so they cannot run at the same time.
