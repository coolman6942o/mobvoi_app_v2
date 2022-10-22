package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;
/* compiled from: LogWriter.java */
/* loaded from: classes.dex */
final class c0 extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f3110a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f3111b = new StringBuilder(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(String str) {
        this.f3110a = str;
    }

    private void c() {
        if (this.f3111b.length() > 0) {
            Log.d(this.f3110a, this.f3111b.toString());
            StringBuilder sb2 = this.f3111b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        c();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == '\n') {
                c();
            } else {
                this.f3111b.append(c10);
            }
        }
    }
}
