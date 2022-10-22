package w3;

import android.content.Context;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import u3.a;
import v3.b;
import v3.e;
import y3.a;
/* loaded from: classes.dex */
public class d extends e {
    @Override // v3.e
    public String c(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // v3.e
    public Map<String, String> d(boolean z10, String str) {
        return new HashMap();
    }

    @Override // v3.e
    public JSONObject e() {
        return null;
    }

    @Override // v3.e
    public b h(a aVar, Context context, String str) throws Throwable {
        a4.d.h("mspl", "mdap post");
        byte[] a10 = s3.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", y3.b.e().d());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", "alipaysdk");
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put("Content-Encoding", "Gzip");
        hashMap.put("productVersion", "15.8.02");
        a.b b10 = u3.a.b(context, new a.C0511a("https://loggw-exsdk.alipay.com/loggw/logUpload.do", hashMap, a10));
        a4.d.h("mspl", "mdap got " + b10);
        if (b10 != null) {
            boolean l10 = e.l(b10);
            try {
                byte[] bArr = b10.f35288b;
                if (l10) {
                    bArr = s3.b.b(bArr);
                }
                return new b("", new String(bArr, Charset.forName("UTF-8")));
            } catch (Exception e10) {
                a4.d.d(e10);
                return null;
            }
        } else {
            throw new RuntimeException("Response is null");
        }
    }
}
