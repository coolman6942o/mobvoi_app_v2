package gk;

import com.mobvoi.assistant.account.data.d;
import okhttp3.v;
/* compiled from: PhoneTicCareApiHelper.java */
/* loaded from: classes2.dex */
public class a extends bk.a {

    /* renamed from: b  reason: collision with root package name */
    private static a f27486b;

    private a() {
    }

    public static a k() {
        if (f27486b == null) {
            synchronized (a.class) {
                if (f27486b == null) {
                    f27486b = new a();
                }
            }
        }
        return f27486b;
    }

    @Override // bk.a
    public v d() {
        return new d();
    }
}
