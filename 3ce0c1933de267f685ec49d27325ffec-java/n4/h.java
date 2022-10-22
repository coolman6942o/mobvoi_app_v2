package n4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* compiled from: DB.java */
/* loaded from: classes.dex */
public class h extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private d f31015a;

    public h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, d dVar) {
        super(context, str, cursorFactory, i10);
        this.f31015a = dVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f31015a.b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.f31015a.a(sQLiteDatabase, i10, i11);
    }
}
