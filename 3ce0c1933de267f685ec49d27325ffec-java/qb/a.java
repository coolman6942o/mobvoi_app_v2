package qb;

import android.util.Base64;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: DigitSign.java */
/* loaded from: classes2.dex */
public class a {
    public String a(String str, String str2) {
        byte[] bArr;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str, 2), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            bArr = mac.doFinal(str2.getBytes("UTF-8"));
        } catch (Exception e10) {
            Log.e("DigitSign", e10.toString());
            bArr = null;
        }
        if (bArr != null) {
            return Base64.encodeToString(bArr, 2);
        }
        return null;
    }

    public String b(b bVar, String str) {
        return a(str, c(bVar));
    }

    public String c(b bVar) {
        String str = bVar.f32938a;
        TreeMap treeMap = new TreeMap(bVar.f32939b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        for (String str2 : treeMap.keySet()) {
            try {
                stringBuffer.append(URLEncoder.encode(str2, "UTF-8"));
                stringBuffer.append("%3D");
                if (treeMap.get(str2) != null) {
                    stringBuffer.append(URLEncoder.encode((String) treeMap.get(str2), "UTF-8"));
                }
                stringBuffer.append("%26");
            } catch (UnsupportedEncodingException e10) {
                Log.e("DigitSign", "addImageBackground:", e10);
            }
        }
        return stringBuffer.toString().replaceFirst("%26$", "");
    }
}
