package app;


import app.utils.Elm327Client;
import app.utils.SerialPortManager;
import com.fazecast.jSerialComm.SerialPort;

import java.io.IOException;


public class Main {
    static void main() throws IOException {


        SerialPort[] serialPorts = SerialPortManager.getCommPorts();


        for (SerialPort serialPort : serialPorts) {
            System.out.println(serialPort);
        }

        SerialPort port = SerialPortManager.getCommPort("COM1"); //Mudar futuro
        SerialPortManager.openAndSetCommPort(port, 38400, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        Elm327Client elm327Client = new Elm327Client(port);
        elm327Client.startCommunicationConsole();



//38400 simbolos por segundo, usando 8 bits de dados, sem paridade e um bit de parada. 8N1

    }
}
