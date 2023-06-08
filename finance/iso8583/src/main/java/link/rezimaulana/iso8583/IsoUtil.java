package link.rezimaulana.iso8583;

import java.math.BigInteger;
import java.util.Map;

public class IsoUtil {
    
	public static BigInteger createBitmap(Map<Integer, String> message){
        BigInteger bitmap = BigInteger.ZERO;
        for (Integer de : message.keySet()) {
            if(de > 64){
                bitmap = bitmap.setBit(128 - 1);
            }
            bitmap = bitmap.setBit(128 - de);
        }
        return bitmap;
    }

    public static String createMessage(String mti, Map<Integer, String> message){
        StringBuilder hasil = new StringBuilder();
        hasil.append(mti);
        hasil.append(createBitmap(message).toString(16));
        for (Integer de : message.keySet()) {
            hasil.append(message.get(de));
        }
        return hasil.toString();
    }
    
}
