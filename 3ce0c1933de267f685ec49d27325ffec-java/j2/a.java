package j2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import r2.f;
/* compiled from: DBHelper.java */
/* loaded from: classes.dex */
public class a extends SQLiteOpenHelper implements f {

    /* renamed from: a  reason: collision with root package name */
    private static String f29389a = "fmsh_sptc";

    public a(Context context, int i10) {
        super(context, f29389a, (SQLiteDatabase.CursorFactory) null, i10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
