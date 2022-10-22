package jp;

import kotlin.jvm.internal.i;
import okhttp3.c0;
import okhttp3.w;
import okio.e;
/* compiled from: RealResponseBody.kt */
/* loaded from: classes3.dex */
public final class h extends c0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f29671a;

    /* renamed from: b  reason: collision with root package name */
    private final long f29672b;

    /* renamed from: c  reason: collision with root package name */
    private final e f29673c;

    public h(String str, long j10, e source) {
        i.f(source, "source");
        this.f29671a = str;
        this.f29672b = j10;
        this.f29673c = source;
    }

    @Override // okhttp3.c0
    public long contentLength() {
        return this.f29672b;
    }

    @Override // okhttp3.c0
    public w contentType() {
        String str = this.f29671a;
        if (str != null) {
            return w.f32297g.b(str);
        }
        return null;
    }

    @Override // okhttp3.c0
    public e source() {
        return this.f29673c;
    }
}
