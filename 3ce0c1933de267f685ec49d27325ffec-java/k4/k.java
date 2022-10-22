package k4;

import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.mlkit.common.ha.d;
/* compiled from: LogDBCreator.java */
/* loaded from: classes.dex */
public class k implements e {
    @Override // k4.e
    public String a() {
        return "logdb.db";
    }

    @Override // k4.e
    public void a(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // k4.e
    public int b() {
        return 1;
    }

    @Override // k4.e
    public void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS a (_id integer primary key autoincrement, a1  varchar(20), a2 varchar(10),a3 varchar(50),a4 varchar(100),a5 varchar(20),a6 integer);");
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "b"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", "c"));
            sQLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (_id integer primary key autoincrement,b1 varchar(40), b2 integer,b3  integer,a1  varchar(20));", d.f14069a));
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS e (_id integer primary key autoincrement,c1 integer,c2 integer,c3 integer);");
        } catch (Throwable th2) {
            d.b(th2, "DB", "onCreate");
        }
    }
}
