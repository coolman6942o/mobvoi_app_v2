package gn;

import android.content.Context;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f27518b;

    /* renamed from: a  reason: collision with root package name */
    private Context f27519a;

    private b(Context context) {
        this.f27519a = null;
        this.f27519a = context;
    }

    public static b b(Context context) {
        if (f27518b == null) {
            f27518b = new b(context);
        }
        return f27518b;
    }

    public String a() {
        String u10 = z.v(this.f27519a).u();
        return (!u10.contains("V") || u10.length() <= 2) ? "" : u10.substring(0, u10.indexOf("V"));
    }
}
