package bn;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.yc.pedometer.dial.OnlineDialUtil;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class n {

    /* renamed from: b  reason: collision with root package name */
    private static n f5333b;

    /* renamed from: a  reason: collision with root package name */
    private Context f5334a;

    public n(Context context) {
        this.f5334a = context;
    }

    public static n b(Context context) {
        if (f5333b == null) {
            f5333b = new n(context);
        }
        return f5333b;
    }

    public String a() {
        Context context = this.f5334a;
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(this.f5334a.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("YCAPPKEY");
                if (string != null) {
                    return string;
                }
                OnlineDialUtil.b("CommonUtil.getAppKey->Could not read APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e10) {
            OnlineDialUtil.b("CommonUtil.getAppKey->Could not read APPKEY meta-data from AndroidManifest.xml.");
            e10.printStackTrace();
        }
        return "";
    }

    public Map<String, String> c(String str, String str2, int i10) {
        return d(str, str2, i10, true);
    }

    public Map<String, String> d(String str, String str2, int i10, boolean z10) {
        HashMap hashMap = new HashMap();
        hashMap.put("appkey", b(this.f5334a).a());
        hashMap.put("btname", str);
        hashMap.put("type", i10 + "");
        hashMap.put("dpi", str2);
        hashMap.put("os", "android");
        hashMap.put("debug", z10 ? "1" : "-1");
        return hashMap;
    }
}
