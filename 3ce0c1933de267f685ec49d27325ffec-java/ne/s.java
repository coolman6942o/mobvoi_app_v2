package ne;

import android.content.Context;
import java.io.File;
import oe.b;
/* compiled from: FeedbackManager.java */
/* loaded from: classes2.dex */
public class s {

    /* renamed from: c  reason: collision with root package name */
    private static s f31175c;

    /* renamed from: a  reason: collision with root package name */
    private b f31176a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31177b;

    private s() {
    }

    public static s a() {
        if (f31175c == null) {
            synchronized (s.class) {
                if (f31175c == null) {
                    f31175c = new s();
                }
            }
        }
        return f31175c;
    }

    public b.a b() {
        b bVar = this.f31176a;
        if (bVar != null) {
            return bVar.a();
        }
        return null;
    }

    public File c(Context context) {
        return context.getExternalFilesDir("log");
    }

    public String d() {
        b bVar = this.f31176a;
        if (bVar != null) {
            return bVar.c();
        }
        throw new IllegalArgumentException("please init param first");
    }

    public void e(b bVar) {
        this.f31176a = bVar;
    }

    public boolean f() {
        return this.f31177b;
    }

    public void g(boolean z10) {
        this.f31177b = z10;
    }
}
