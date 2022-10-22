package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import oo.c;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i10, f fVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileSystemException(File file, File file2, String str) {
        super(r0);
        String b10;
        i.f(file, "file");
        b10 = c.b(file, file2, str);
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
