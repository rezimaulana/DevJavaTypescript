package link.rezimaulana.iso8583;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Server {
    public static void main(String[] args) throws Exception {
        final Integer port = 12345;
        final ServerSocket server = new ServerSocket(port);
        System.out.println("Server is ready on port "+port);

        final Socket connection = server.accept();
        System.out.println("---------Message is received!---------");

        final DataInputStream in = new DataInputStream(connection.getInputStream());
        final short length = in.readShort();
        System.out.println("Message length : "+length);

        final byte[] data = new byte[length - 2];
        in.readFully(data);
        String message = new String(data);
        System.out.println("Request : ["+message+"]");

        final String mti = message.substring(0, 4);
        final String strBitmap = message.substring(4, 32 + 4);

        System.out.println("MTI : [" + mti+ "]");
        System.out.println("Bitmap Hex: [" +strBitmap+ "]");

        final BigInteger bitmap = new BigInteger(strBitmap, 16);
        final String strBitmapBin = bitmap.toString(2);
        System.out.println("Bitmap Bin : [" +strBitmapBin+ "]");

        for(int i=0; i<128; i++){
            if (bitmap.testBit(128 - i)) {
                System.out.println("Bit "+i+" active");
            }
        }

        final DateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");
        final Map<Integer, String> logonResponse = new LinkedHashMap<Integer, String>();
        logonResponse.put(7, formatterBit7.format(new Date()));
        logonResponse.put(11, "834624");
        logonResponse.put(39, "00");
        logonResponse.put(70, "001");

        final String strLogonResponse = IsoUtil.createMessage("0810", logonResponse);
        System.out.println("Response Data : [" +strLogonResponse+ "]");
        final DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.writeShort((strLogonResponse.length() + 2));
        out.writeBytes(strLogonResponse);
        out.flush();
        System.out.println("---------Message is sent!---------");
        Thread.sleep(3 * 1000);
        connection.close();
        server.close();
    }
}
