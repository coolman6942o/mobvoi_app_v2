package okhttp3;

import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: CookieJar.kt */
/* loaded from: classes3.dex */
public interface n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f32253a = new a.C0441a();

    /* compiled from: CookieJar.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: CookieJar.kt */
        /* renamed from: okhttp3.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0441a implements n {
            @Override // okhttp3.n
            public void a(u url, List<m> cookies) {
                i.f(url, "url");
                i.f(cookies, "cookies");
            }

            @Override // okhttp3.n
            public List<m> b(u url) {
                List<m> g10;
                i.f(url, "url");
                g10 = m.g();
                return g10;
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    void a(u uVar, List<m> list);

    List<m> b(u uVar);
}
