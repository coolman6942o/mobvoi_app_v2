package oo;

import java.io.ByteArrayOutputStream;
import kotlin.jvm.internal.i;
/* compiled from: FileReadWrite.kt */
/* loaded from: classes3.dex */
final class d extends ByteArrayOutputStream {
    public d(int i10) {
        super(i10);
    }

    public final byte[] c() {
        byte[] buf = ((ByteArrayOutputStream) this).buf;
        i.e(buf, "buf");
        return buf;
    }
}
