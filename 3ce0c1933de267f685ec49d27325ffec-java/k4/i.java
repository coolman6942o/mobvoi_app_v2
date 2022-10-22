package k4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* compiled from: DB.java */
/* loaded from: classes.dex */
public class i extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private e f29748a;

    public i(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, e eVar) {
        super(context, str, cursorFactory, i10);
        this.f29748a = eVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.f29748a.b(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        this.f29748a.a(sQLiteDatabase, i10, i11);
    }
}
