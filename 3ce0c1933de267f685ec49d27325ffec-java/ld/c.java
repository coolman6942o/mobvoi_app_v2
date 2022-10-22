package ld;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.android.common.utils.f;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.b0;
import okhttp3.u;
import okhttp3.v;
import okhttp3.z;
/* compiled from: ReqAppkeyInterceptor.java */
/* loaded from: classes2.dex */
public class c implements v {
    private z a(z zVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return zVar.i().a("appkey", "vpa-android").a("timestamp", String.valueOf(currentTimeMillis)).a("sign", f.g("vpa-androidhEawSDVirkQFl4VI0IvdyKwJCaMaTEC8" + currentTimeMillis, "SHA-256")).b();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return zVar;
        }
    }

    private z b(z zVar) {
        long currentTimeMillis = System.currentTimeMillis();
        TreeMap treeMap = new TreeMap(b.f30450a);
        u l10 = zVar.l();
        for (String str : l10.q()) {
            treeMap.put(str, l10.p(str));
        }
        StringBuilder sb2 = new StringBuilder("vpa-androidhEawSDVirkQFl4VI0IvdyKwJCaMaTEC8" + currentTimeMillis);
        for (Map.Entry entry : treeMap.entrySet()) {
            sb2.append((String) entry.getKey());
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append((String) entry.getValue());
            sb2.append(ContainerUtils.FIELD_DELIMITER);
        }
        try {
            return zVar.i().a("appkey", "vpa-android").a("timestamp", String.valueOf(currentTimeMillis)).a("sign", f.g(sb2.substring(0, sb2.length() - 1), "SHA-256")).b();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return zVar;
        }
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        if (!TextUtils.isEmpty(request.d("sign_appkey"))) {
            return aVar.a(a(request));
        }
        if (!TextUtils.isEmpty(request.d("sign_params"))) {
            return aVar.a(b(request));
        }
        return aVar.a(request);
    }
}
