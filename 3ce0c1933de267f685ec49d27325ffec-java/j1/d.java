package j1;

import android.database.sqlite.SQLiteProgram;
/* compiled from: FrameworkSQLiteProgram.java */
/* loaded from: classes.dex */
class d implements i1.d {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteProgram f29387a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SQLiteProgram sQLiteProgram) {
        this.f29387a = sQLiteProgram;
    }

    @Override // i1.d
    public void K(int i10, long j10) {
        this.f29387a.bindLong(i10, j10);
    }

    @Override // i1.d
    public void P(int i10, byte[] bArr) {
        this.f29387a.bindBlob(i10, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f29387a.close();
    }

    @Override // i1.d
    public void l0(int i10) {
        this.f29387a.bindNull(i10);
    }

    @Override // i1.d
    public void m(int i10, String str) {
        this.f29387a.bindString(i10, str);
    }

    @Override // i1.d
    public void y(int i10, double d10) {
        this.f29387a.bindDouble(i10, d10);
    }
}
