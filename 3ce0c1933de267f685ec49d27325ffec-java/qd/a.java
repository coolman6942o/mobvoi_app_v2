package qd;

import android.annotation.SuppressLint;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.permission.PermissionConstant;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import mk.b;
import org.json.JSONObject;
/* compiled from: ActCodeUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final HostnameVerifier f32942a = new C0453a();

    /* compiled from: ActCodeUtil.java */
    /* renamed from: qd.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0453a implements HostnameVerifier {
        C0453a() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        @SuppressLint({"BadHostnameVerifier"})
        public boolean verify(String str, SSLSession sSLSession) {
            if (str.startsWith("com.mobvoi")) {
                return true;
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public static byte[] a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("seid", str);
            jSONObject.put("orderId", str2);
            jSONObject.put("orderType", "1");
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(b()).openConnection();
            httpsURLConnection.setHostnameVerifier(f32942a);
            httpsURLConnection.setRequestMethod("POST");
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setFixedLengthStreamingMode(bytes.length);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            k.c("ActCode", "get act code response code %s", Integer.valueOf(httpsURLConnection.getResponseCode()));
            InputStream inputStream = httpsURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("UTF-8");
            k.c("ActCode", "act code %s", byteArrayOutputStream2);
            JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream2);
            if ("0".equals(jSONObject2.optString(PermissionConstant.Columns.STATUS))) {
                return b.b(jSONObject2.getString("actCode"));
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static String b() {
        return sd.b.h().o() ? "https://1.119.150.194:19999/opentsmagent/actCodeServer/actCode.action" : "https://www.opentsm.cn:7037/opentsmagent/actCodeServer/actCode.action";
    }

    public static boolean c(ud.a aVar) {
        return aVar.isShanghai;
    }
}
