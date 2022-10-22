package j4;

import android.content.Context;
import h4.a;
import h4.d;
import i4.c;
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static a f29439a;

    /* renamed from: b  reason: collision with root package name */
    public static a f29440b;

    public static a b(Context context, String str) {
        if (context == null) {
            return null;
        }
        if (f29439a == null) {
            f29440b = d.a(context, str);
            f29439a = new b();
        }
        return f29439a;
    }

    @Override // j4.a
    public c a(i4.d dVar) {
        return i4.b.b(f29440b.a(i4.b.a(dVar)));
    }

    @Override // j4.a
    public boolean logCollect(String str) {
        return f29440b.logCollect(str);
    }
}
