package j6;

import android.content.Context;
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f29444b = new c();

    /* renamed from: a  reason: collision with root package name */
    private b f29445a = null;

    public static b a(Context context) {
        return f29444b.b(context);
    }

    private final synchronized b b(Context context) {
        if (this.f29445a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f29445a = new b(context);
        }
        return this.f29445a;
    }
}
