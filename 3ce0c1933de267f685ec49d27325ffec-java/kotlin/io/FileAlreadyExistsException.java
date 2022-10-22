package kotlin.io;

import java.io.File;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Exceptions.kt */
/* loaded from: classes3.dex */
public final class FileAlreadyExistsException extends FileSystemException {
    public /* synthetic */ FileAlreadyExistsException(File file, File file2, String str, int i10, f fVar) {
        this(file, (i10 & 2) != 0 ? null : file2, (i10 & 4) != 0 ? null : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileAlreadyExistsException(File file, File file2, String str) {
        super(file, file2, str);
        i.f(file, "file");
    }
}
