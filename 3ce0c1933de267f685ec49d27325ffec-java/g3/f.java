package g3;

import com.airbnb.lottie.d;
import q.a;
/* compiled from: LottieCompositionCache.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final f f27239b = new f();

    /* renamed from: a  reason: collision with root package name */
    private final a<String, d> f27240a = new a<>(20);

    f() {
    }

    public static f b() {
        return f27239b;
    }

    public d a(String str) {
        if (str == null) {
            return null;
        }
        return this.f27240a.c(str);
    }

    public void c(String str, d dVar) {
        if (str != null) {
            this.f27240a.d(str, dVar);
        }
    }
}
