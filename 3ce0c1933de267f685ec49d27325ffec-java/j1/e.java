package j1;

import android.database.sqlite.SQLiteStatement;
import i1.f;
/* compiled from: FrameworkSQLiteStatement.java */
/* loaded from: classes.dex */
class e extends d implements f {

    /* renamed from: b  reason: collision with root package name */
    private final SQLiteStatement f29388b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f29388b = sQLiteStatement;
    }

    @Override // i1.f
    public long D0() {
        return this.f29388b.executeInsert();
    }

    @Override // i1.f
    public int r() {
        return this.f29388b.executeUpdateDelete();
    }
}
