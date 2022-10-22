package software.tingle.api.authentication;

import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.z;
/* compiled from: AuthenticationHeaderProvider.kt */
/* loaded from: classes3.dex */
public abstract class a implements c {
    public static final C0498a Companion = new C0498a(null);
    public static final String DEFAULT_SCHEME = "Bearer";
    private final String scheme;

    /* compiled from: AuthenticationHeaderProvider.kt */
    /* renamed from: software.tingle.api.authentication.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0498a {
        private C0498a() {
        }

        public /* synthetic */ C0498a(f fVar) {
            this();
        }
    }

    public a() {
        this(null, 1, null);
    }

    public a(String scheme) {
        i.f(scheme, "scheme");
        this.scheme = scheme;
    }

    protected abstract String getParameter(z.a aVar);

    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        i.f(chain, "chain");
        z.a i10 = chain.request().i();
        String parameter = getParameter(i10);
        return chain.a(i10.h("Authorization", this.scheme + ' ' + parameter).b());
    }

    public /* synthetic */ a(String str, int i10, f fVar) {
        this((i10 & 1) != 0 ? DEFAULT_SCHEME : str);
    }
}
