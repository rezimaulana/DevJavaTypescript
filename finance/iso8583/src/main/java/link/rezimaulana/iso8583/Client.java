package link.rezimaulana.iso8583;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Client {
    
	public static void main(String[] args) {
		final Client client = new Client();
		final String message = client.build();
		client.send(message);
    }
	
	private String build() {
		final DateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");

        final Map<Integer, String> logonRequest = new LinkedHashMap<Integer, String>();
        logonRequest.put(7, formatterBit7.format(new Date()));
        logonRequest.put(11, "834624");
        logonRequest.put(70, "001");

        final BigInteger bitmapRequest = IsoUtil.createBitmap(logonRequest);
        
        final String strBitmap = bitmapRequest.toString(2);
        System.out.println("Bitmap Binary : ["+strBitmap+"]");

        final String strBitmapHex = bitmapRequest.toString(16);
        System.out.println("Bitmap Hexa : ["+strBitmapHex+"]");

        final String strLogonRequest = IsoUtil.createMessage("0800", logonRequest);
        System.out.println("Logon Request : ["+strLogonRequest+"]");
        
        return strLogonRequest;
	}


    private void send(String message){
        final short messageLength = (short) (message.length() + 2);
        System.out.println("Message Length: "+ messageLength);

        try {
            // send data
            final Socket connection = new Socket("localhost", 12345);
            final DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            out.writeShort(messageLength);
            out.writeBytes(message);
            out.flush();
            System.out.println("---------Message is sent!---------");

            // receive response
            final DataInputStream in = new DataInputStream(connection.getInputStream());
            final short respLength = in.readShort();
            System.out.println("---------Message is received!---------");
            System.out.println("Response Length : "+respLength);
            final byte[] responseData = new byte[respLength - 2];
            in.readFully(responseData);
            System.out.println("Response : ["+new String(responseData)+"]");

            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
