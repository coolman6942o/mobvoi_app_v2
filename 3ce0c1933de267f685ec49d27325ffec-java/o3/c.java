package o3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.util.b;
import java.util.Collections;
import org.json.JSONObject;
import r3.a;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static a f31410a;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z10, JSONObject jSONObject, String str);
    }

    public static boolean a(y3.a aVar, int i10, int i11, Intent intent) {
        if (i10 != 1010 || intent == null) {
            return false;
        }
        a aVar2 = f31410a;
        if (aVar2 == null) {
            return true;
        }
        f31410a = null;
        if (i11 == -1) {
            p3.a.c(aVar, "biz", "TbOk", intent.toUri(1));
            aVar2.a(true, b.p(intent), "OK");
        } else if (i11 != 0) {
            p3.a.h(aVar, "biz", "TbUnknown", "" + i11);
        } else {
            p3.a.c(aVar, "biz", "TbCancel", intent.toUri(1));
            aVar2.a(false, null, "CANCELED");
        }
        return true;
    }

    public static boolean b(y3.a aVar, Activity activity, int i10, String str, String str2, a aVar2) {
        try {
            p3.a.b(aVar, "biz", "TbStart");
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i10);
            f31410a = aVar2;
            return true;
        } catch (Throwable th2) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            p3.a.d(aVar, "biz", "TbActFail", th2);
            return false;
        }
    }

    public static boolean c(y3.a aVar, Context context) {
        return b.A(aVar, context, Collections.singletonList(new a.b("com.taobao.taobao", 0, "")));
    }
}
