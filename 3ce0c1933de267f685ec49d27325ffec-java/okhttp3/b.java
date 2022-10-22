package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Authenticator.kt */
/* loaded from: classes3.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31751a = new a.C0425a();

    /* compiled from: Authenticator.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Authenticator.kt */
        /* renamed from: okhttp3.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0425a implements b {
            @Override // okhttp3.b
            public z a(d0 d0Var, b0 response) {
                i.f(response, "response");
                return null;
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
        new hp.b(null, 1, null);
    }

    z a(d0 d0Var, b0 b0Var) throws IOException;
}
