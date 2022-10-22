package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okio.e;
/* compiled from: PushObserver.kt */
/* loaded from: classes3.dex */
public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f32180a = new a.C0436a();

    /* compiled from: PushObserver.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: PushObserver.kt */
        /* renamed from: okhttp3.internal.http2.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0436a implements g {
            @Override // okhttp3.internal.http2.g
            public boolean a(int i10, List<lp.a> requestHeaders) {
                i.f(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.g
            public boolean b(int i10, List<lp.a> responseHeaders, boolean z10) {
                i.f(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.g
            public void c(int i10, ErrorCode errorCode) {
                i.f(errorCode, "errorCode");
            }

            @Override // okhttp3.internal.http2.g
            public boolean d(int i10, e source, int i11, boolean z10) throws IOException {
                i.f(source, "source");
                source.f(i11);
                return true;
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

    boolean a(int i10, List<lp.a> list);

    boolean b(int i10, List<lp.a> list, boolean z10);

    void c(int i10, ErrorCode errorCode);

    boolean d(int i10, e eVar, int i11, boolean z10) throws IOException;
}
