package link.rezimaulana.iso8583;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class IsoTests {
    @Test
    public void testGenerateMessage(){
        DateFormat formatterBit7 = new SimpleDateFormat("MMddHHmmss");
        Map<Integer, String> logonRequest = new LinkedHashMap<Integer, String>();
        logonRequest.put(7, formatterBit7.format(new Date()));
        logonRequest.put(11, "834624");
        logonRequest.put(70, "001");

        String msg = IsoUtil.createMessage("0800", logonRequest);
        System.out.println("Message : "+msg);
        System.out.println("Length : "+msg.length());
    }
}
