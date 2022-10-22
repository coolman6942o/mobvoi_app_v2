package k9;

import android.util.SparseArray;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k9.a;
import r9.c;
/* compiled from: NoDatabaseImpl.java */
/* loaded from: classes2.dex */
public class b implements k9.a {

    /* renamed from: a  reason: collision with root package name */
    final SparseArray<FileDownloadModel> f29807a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    final SparseArray<List<o9.a>> f29808b = new SparseArray<>();

    /* compiled from: NoDatabaseImpl.java */
    /* loaded from: classes2.dex */
    class a implements a.AbstractC0365a {
        a() {
        }

        @Override // k9.a.AbstractC0365a
        public void E(FileDownloadModel fileDownloadModel) {
        }

        @Override // k9.a.AbstractC0365a
        public void I(int i10, FileDownloadModel fileDownloadModel) {
        }

        @Override // java.lang.Iterable
        public Iterator<FileDownloadModel> iterator() {
            return new C0366b(b.this);
        }

        @Override // k9.a.AbstractC0365a
        public void t0() {
        }

        @Override // k9.a.AbstractC0365a
        public void x(FileDownloadModel fileDownloadModel) {
        }
    }

    /* compiled from: NoDatabaseImpl.java */
    /* renamed from: k9.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0366b implements Iterator<FileDownloadModel> {
        C0366b(b bVar) {
        }

        /* renamed from: a */
        public FileDownloadModel next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    @Override // k9.a
    public void a(int i10) {
    }

    @Override // k9.a
    public void b(o9.a aVar) {
        int c10 = aVar.c();
        List<o9.a> list = this.f29808b.get(c10);
        if (list == null) {
            list = new ArrayList<>();
            this.f29808b.put(c10, list);
        }
        list.add(aVar);
    }

    @Override // k9.a
    public a.AbstractC0365a c() {
        return new a();
    }

    @Override // k9.a
    public void clear() {
        this.f29807a.clear();
    }

    @Override // k9.a
    public void d(int i10, Throwable th2) {
    }

    @Override // k9.a
    public void e(int i10, long j10) {
        remove(i10);
    }

    @Override // k9.a
    public void f(int i10, String str, long j10, long j11, int i11) {
    }

    @Override // k9.a
    public void g(int i10, int i11, long j10) {
        List<o9.a> list = this.f29808b.get(i10);
        if (list != null) {
            for (o9.a aVar : list) {
                if (aVar.d() == i11) {
                    aVar.g(j10);
                    return;
                }
            }
        }
    }

    @Override // k9.a
    public void h(int i10) {
        this.f29808b.remove(i10);
    }

    @Override // k9.a
    public void i(int i10) {
    }

    @Override // k9.a
    public void j(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            c.i(this, "update but model == null!", new Object[0]);
        } else if (o(fileDownloadModel.e()) != null) {
            this.f29807a.remove(fileDownloadModel.e());
            this.f29807a.put(fileDownloadModel.e(), fileDownloadModel);
        } else {
            r(fileDownloadModel);
        }
    }

    @Override // k9.a
    public void k(int i10, Throwable th2, long j10) {
    }

    @Override // k9.a
    public void l(int i10, long j10) {
    }

    @Override // k9.a
    public void m(int i10, long j10, String str, String str2) {
    }

    @Override // k9.a
    public List<o9.a> n(int i10) {
        ArrayList arrayList = new ArrayList();
        List<o9.a> list = this.f29808b.get(i10);
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // k9.a
    public FileDownloadModel o(int i10) {
        return this.f29807a.get(i10);
    }

    @Override // k9.a
    public void p(int i10, int i11) {
    }

    @Override // k9.a
    public void q(int i10, long j10) {
    }

    public void r(FileDownloadModel fileDownloadModel) {
        this.f29807a.put(fileDownloadModel.e(), fileDownloadModel);
    }

    @Override // k9.a
    public boolean remove(int i10) {
        this.f29807a.remove(i10);
        return true;
    }
}
