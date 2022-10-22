package xe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/* compiled from: FixBugUtils.java */
/* loaded from: classes2.dex */
public class c extends SQLiteOpenHelper {
    public c(Context context) {
        super(context, "fitness.db", (SQLiteDatabase.CursorFactory) null, 1019);
    }

    public static void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE  IF NOT EXISTS  'RECORD' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'HASH' TEXT UNIQUE ,'TYPE' INTEGER NOT NULL ,'TARGET_TYPE' INTEGER,'TARGET_VALUE' REAL,'ACCOUNT_ID' TEXT,'SYNCED' INTEGER NOT NULL ,'DELETED' INTEGER NOT NULL ,'START_TIME' INTEGER,'END_TIME' INTEGER,'TIMESTAMP' INTEGER,'DURATION' INTEGER NOT NULL ,'DISTANCE' INTEGER,'CALORIE' REAL,'STEP' INTEGER,'HEART' INTEGER,'GROUPS' TEXT,'SWIM_TRIPS' REAL,'SWIM_DISTANCE' INTEGER,'SWIM_POOL_LENGTH' INTEGER,'SWIM_STROKE' INTEGER,'DEVICE_ID' TEXT,'SESSION_MODE' INTEGER,'MAX_ELEVATION' REAL,'MIN_ELEVATION' REAL,'CUMULATIVE_UP' REAL,'CUMULATIVE_DOWN' REAL);");
        sQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS  IDX_RECORD_HASH ON RECORD (HASH);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'POINT' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'TIME' INTEGER NOT NULL ,'HEART' INTEGER,'STEP' INTEGER,'LAT' REAL NOT NULL ,'LON' REAL NOT NULL ,'ACC' REAL NOT NULL ,'DISTANCE' INTEGER,'SPEED' REAL,'CALORIE' REAL,'RECORD_ID' INTEGER,'RESUME' INTEGER,'SWIM_TRIPS' REAL,'SWIM_DISTANCE' INTEGER,'SWIM_STROKE' INTEGER,'SWIM_TYPE' INTEGER,'TIMESTAMP' INTEGER NOT NULL ,'ELEVATION' REAL);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        c(sQLiteDatabase);
        sQLiteDatabase.execSQL("ALTER TABLE RECORD ADD COLUMN SCORE REAL");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        onUpgrade(sQLiteDatabase, i10, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'RECORD'");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'POINT'");
        onCreate(sQLiteDatabase);
    }
}
