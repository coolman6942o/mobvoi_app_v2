package k9;

import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.List;
/* compiled from: FileDownloadDatabase.java */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: FileDownloadDatabase.java */
    /* renamed from: k9.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0365a extends Iterable<FileDownloadModel> {
        void E(FileDownloadModel fileDownloadModel);

        void I(int i10, FileDownloadModel fileDownloadModel);

        void t0();

        void x(FileDownloadModel fileDownloadModel);
    }

    void a(int i10);

    void b(o9.a aVar);

    AbstractC0365a c();

    void clear();

    void d(int i10, Throwable th2);

    void e(int i10, long j10);

    void f(int i10, String str, long j10, long j11, int i11);

    void g(int i10, int i11, long j10);

    void h(int i10);

    void i(int i10);

    void j(FileDownloadModel fileDownloadModel);

    void k(int i10, Throwable th2, long j10);

    void l(int i10, long j10);

    void m(int i10, long j10, String str, String str2);

    List<o9.a> n(int i10);

    FileDownloadModel o(int i10);

    void p(int i10, int i11);

    void q(int i10, long j10);

    boolean remove(int i10);
}
