package okhttp3.internal.cache;

import io.m;
import java.io.IOException;
import kotlin.jvm.internal.i;
import okio.c;
import okio.g;
import okio.r;
import qo.l;
/* compiled from: FaultHidingSink.kt */
/* loaded from: classes3.dex */
public class e extends g {

    /* renamed from: b  reason: collision with root package name */
    private boolean f31942b;

    /* renamed from: c  reason: collision with root package name */
    private final l<IOException, m> f31943c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(r delegate, l<? super IOException, m> onException) {
        super(delegate);
        i.f(delegate, "delegate");
        i.f(onException, "onException");
        this.f31943c = onException;
    }

    @Override // okio.g, okio.r
    public void Z(c source, long j10) {
        i.f(source, "source");
        if (this.f31942b) {
            source.f(j10);
            return;
        }
        try {
            super.Z(source, j10);
        } catch (IOException e10) {
            this.f31942b = true;
            this.f31943c.invoke(e10);
        }
    }

    @Override // okio.g, okio.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f31942b) {
            try {
                super.close();
            } catch (IOException e10) {
                this.f31942b = true;
                this.f31943c.invoke(e10);
            }
        }
    }

    @Override // okio.g, okio.r, java.io.Flushable
    public void flush() {
        if (!this.f31942b) {
            try {
                super.flush();
            } catch (IOException e10) {
                this.f31942b = true;
                this.f31943c.invoke(e10);
            }
        }
    }
}
