package fn;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import en.p;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private p f27145a;

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f27146b;

    public d(Context context) {
        p c10 = p.c(context);
        this.f27145a = c10;
        this.f27146b = c10.getWritableDatabase();
    }

    public void a(String str) {
        this.f27146b.execSQL("delete from filedownlog where downpath=?", new Object[]{str});
    }

    public void b(String str, Map<Integer, Integer> map) {
        this.f27146b.beginTransaction();
        try {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                this.f27146b.execSQL("insert into filedownlog(downpath, threadid, downlength) values(?,?,?)", new Object[]{str, entry.getKey(), entry.getValue()});
            }
            this.f27146b.setTransactionSuccessful();
        } finally {
            this.f27146b.endTransaction();
        }
    }

    public Map<Integer, Integer> c(String str) {
        Cursor rawQuery = this.f27146b.rawQuery("select threadid, downlength from filedownlog where downpath=?", new String[]{str});
        HashMap hashMap = new HashMap();
        while (rawQuery.moveToNext()) {
            hashMap.put(Integer.valueOf(rawQuery.getInt(0)), Integer.valueOf(rawQuery.getInt(1)));
        }
        rawQuery.close();
        return hashMap;
    }

    public void d(String str, Map<Integer, Integer> map) {
        this.f27146b.beginTransaction();
        try {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                this.f27146b.execSQL("update filedownlog set downlength=? where downpath=? and threadid=?", new Object[]{entry.getValue(), str, entry.getKey()});
            }
            this.f27146b.setTransactionSuccessful();
        } finally {
            this.f27146b.endTransaction();
        }
    }
}
