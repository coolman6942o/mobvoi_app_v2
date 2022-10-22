package j1;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.CancellationSignal;
import android.util.Pair;
import i1.e;
import i1.f;
import java.io.IOException;
import java.util.List;
/* compiled from: FrameworkSQLiteDatabase.java */
/* loaded from: classes.dex */
class a implements i1.b {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f29371b = new String[0];

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f29372a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteDatabase.java */
    /* renamed from: j1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0352a implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f29373a;

        C0352a(a aVar, e eVar) {
            this.f29373a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f29373a.c(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* compiled from: FrameworkSQLiteDatabase.java */
    /* loaded from: classes.dex */
    class b implements SQLiteDatabase.CursorFactory {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f29374a;

        b(a aVar, e eVar) {
            this.f29374a = eVar;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.f29374a.c(new d(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SQLiteDatabase sQLiteDatabase) {
        this.f29372a = sQLiteDatabase;
    }

    @Override // i1.b
    public Cursor D(e eVar, CancellationSignal cancellationSignal) {
        return this.f29372a.rawQueryWithFactory(new b(this, eVar), eVar.d(), f29371b, null, cancellationSignal);
    }

    @Override // i1.b
    public void L() {
        this.f29372a.setTransactionSuccessful();
    }

    @Override // i1.b
    public void M(String str, Object[] objArr) throws SQLException {
        this.f29372a.execSQL(str, objArr);
    }

    @Override // i1.b
    public void N() {
        this.f29372a.beginTransactionNonExclusive();
    }

    @Override // i1.b
    public Cursor U(String str) {
        return f0(new i1.a(str));
    }

    @Override // i1.b
    public void Y() {
        this.f29372a.endTransaction();
    }

    @Override // i1.b
    public String a() {
        return this.f29372a.getPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(SQLiteDatabase sQLiteDatabase) {
        return this.f29372a == sQLiteDatabase;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f29372a.close();
    }

    @Override // i1.b
    public Cursor f0(e eVar) {
        return this.f29372a.rawQueryWithFactory(new C0352a(this, eVar), eVar.d(), f29371b, null);
    }

    @Override // i1.b
    public void g() {
        this.f29372a.beginTransaction();
    }

    @Override // i1.b
    public boolean isOpen() {
        return this.f29372a.isOpen();
    }

    @Override // i1.b
    public List<Pair<String, String>> j() {
        return this.f29372a.getAttachedDbs();
    }

    @Override // i1.b
    public void l(String str) throws SQLException {
        this.f29372a.execSQL(str);
    }

    @Override // i1.b
    public boolean q0() {
        return this.f29372a.inTransaction();
    }

    @Override // i1.b
    public f s(String str) {
        return new e(this.f29372a.compileStatement(str));
    }

    @Override // i1.b
    public boolean x0() {
        return this.f29372a.isWriteAheadLoggingEnabled();
    }
}
