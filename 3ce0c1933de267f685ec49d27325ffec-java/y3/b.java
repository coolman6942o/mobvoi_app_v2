package y3;

import a4.d;
import android.content.Context;
import com.ta.utdid2.device.UTDevice;
import java.io.File;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f36746b;

    /* renamed from: a  reason: collision with root package name */
    public Context f36747a;

    public static b e() {
        if (f36746b == null) {
            f36746b = new b();
        }
        return f36746b;
    }

    public static boolean f() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i10 = 0; i10 < 10; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    public r3.b a() {
        return r3.b.g();
    }

    public void b(Context context) {
        r3.b.g();
        this.f36747a = context.getApplicationContext();
    }

    public Context c() {
        return this.f36747a;
    }

    public String d() {
        try {
            return UTDevice.getUtdid(this.f36747a);
        } catch (Throwable th2) {
            d.d(th2);
            return "getUtdidEx";
        }
    }
}
