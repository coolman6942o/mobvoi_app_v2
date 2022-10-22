package r9;

import android.annotation.SuppressLint;
import android.content.Context;
import com.liulishuo.filedownloader.exception.PathConflictException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import i9.f;
import java.io.File;
import java.io.IOException;
/* compiled from: FileDownloadHelper.java */
/* loaded from: classes2.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f33468a;

    /* compiled from: FileDownloadHelper.java */
    /* loaded from: classes2.dex */
    public interface a {
        int a(int i10, String str, String str2, long j10);
    }

    /* compiled from: FileDownloadHelper.java */
    /* renamed from: r9.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0460b {
        j9.b a(String str) throws IOException;
    }

    /* compiled from: FileDownloadHelper.java */
    /* loaded from: classes2.dex */
    public interface c {
        int a(String str, String str2, boolean z10);

        int b(int i10, String str, String str2, boolean z10);
    }

    /* compiled from: FileDownloadHelper.java */
    /* loaded from: classes2.dex */
    public interface d {
        q9.a a(File file) throws IOException;

        boolean b();
    }

    public static Context a() {
        return f33468a;
    }

    public static void b(Context context) {
        f33468a = context;
    }

    public static boolean c(int i10, long j10, String str, String str2, f fVar) {
        int b10;
        if (str2 == null || str == null || (b10 = fVar.b(str, i10)) == 0) {
            return false;
        }
        n9.b.a().b(com.liulishuo.filedownloader.message.b.b(i10, j10, new PathConflictException(b10, str, str2)));
        return true;
    }

    public static boolean d(int i10, String str, boolean z10, boolean z11) {
        if (!z10 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                n9.b.a().b(com.liulishuo.filedownloader.message.b.a(i10, file, z11));
                return true;
            }
        }
        return false;
    }

    public static boolean e(int i10, FileDownloadModel fileDownloadModel, f fVar, boolean z10) {
        if (!fVar.a(fileDownloadModel)) {
            return false;
        }
        n9.b.a().b(com.liulishuo.filedownloader.message.b.c(i10, fileDownloadModel.g(), fileDownloadModel.k(), z10));
        return true;
    }
}
