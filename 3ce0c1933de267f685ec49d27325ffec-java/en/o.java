package en;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import bn.d;
import cn.a;
import cn.a0;
import cn.i;
import cn.k;
import cn.l;
import cn.m;
import cn.p;
import cn.r;
import cn.u;
import cn.w;
import cn.x;
import cn.y;
import cn.z;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.contacts.ContactConstant;
import gn.f;
import gn.q;
import gn.s;
import gn.v;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class o {

    /* renamed from: d  reason: collision with root package name */
    private static o f26195d;

    /* renamed from: a  reason: collision with root package name */
    private Context f26196a;

    /* renamed from: b  reason: collision with root package name */
    private p f26197b;

    /* renamed from: c  reason: collision with root package name */
    private SQLiteDatabase f26198c;

    private o(Context context) {
        this.f26196a = context;
        p c10 = p.c(context);
        this.f26197b = c10;
        this.f26198c = c10.getWritableDatabase();
        this.f26196a.getSharedPreferences(q.f27582a, 0);
    }

    private String a(String str) {
        return (!TextUtils.isEmpty(str) && (str.equals(" ASC") || str.equals(" DESC") || str.toUpperCase().equals(" ASC") || str.toUpperCase().equals(" DESC"))) ? str : " ASC";
    }

    public static o b(Context context) {
        if (f26195d == null) {
            f26195d = new o(context);
        }
        return f26195d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(String str, int i10, String str2) {
        boolean z10;
        if (i10 >= 120) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ContactConstant.CallsRecordKeys.DATE, str);
            contentValues.put("time", Integer.valueOf(i10));
            contentValues.put("sleep_time_status_array", str2);
            Cursor cursor = null;
            try {
                cursor = this.f26198c.query("sleep_total_table", null, "date=?", new String[]{String.valueOf(str)}, null, null, null);
            } catch (Exception unused) {
            }
            if (cursor.getCount() > 0) {
                z10 = true;
                if (z10) {
                    this.f26198c.insert("sleep_total_table", "id", contentValues);
                } else {
                    this.f26198c.update("sleep_total_table", contentValues, "date=?", new String[]{String.valueOf(str)});
                }
                if (cursor == null) {
                    cursor.close();
                    return;
                }
                return;
            }
            z10 = false;
            if (z10) {
            }
            if (cursor == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(u uVar) {
        boolean z10;
        String str;
        StringBuilder sb2;
        if (uVar != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_sports_modes", Integer.valueOf(uVar.n()));
            contentValues.put("sports_modes_rate_count", Integer.valueOf(uVar.v()));
            contentValues.put("calendar", uVar.m());
            contentValues.put("start_date_time", uVar.w());
            contentValues.put("end_date_time", uVar.u());
            contentValues.put("duration", Integer.valueOf(uVar.q()));
            contentValues.put("ble_step_count", Integer.valueOf(uVar.k()));
            contentValues.put("ble_sports_count", Integer.valueOf(uVar.i()));
            contentValues.put("ble_sports_calories", Integer.valueOf(uVar.h()));
            contentValues.put("ble_sports_distance", Float.valueOf(uVar.j()));
            contentValues.put("ble_average_rate", Integer.valueOf(uVar.d()));
            contentValues.put("ble_max_rate", Integer.valueOf(uVar.e()));
            contentValues.put("ble_min_rate", Integer.valueOf(uVar.f()));
            contentValues.put("ble_average_pace", Integer.valueOf(uVar.c()));
            contentValues.put("ble_time_interval", Integer.valueOf(uVar.l()));
            contentValues.put("ble_all_rate", uVar.b());
            Cursor cursor = null;
            try {
                cursor = this.f26198c.query("sports_modes_table", null, "start_date_time LIKE ?", new String[]{String.valueOf(uVar.w().substring(0, uVar.w().length() - 2)) + "%"}, null, null, null);
            } catch (Exception e10) {
                v.a("saveSportsModesData Exception =" + e10);
            }
            if (cursor.getCount() > 0) {
                z10 = true;
                v.a("saveSportsModesData result =" + z10);
                if (z10) {
                    this.f26198c.insert("sports_modes_table", "id", contentValues);
                    sb2 = new StringBuilder();
                    str = "saveSportsModesData 保存 ";
                } else {
                    this.f26198c.update("sports_modes_table", contentValues, "start_date_time LIKE ?", new String[]{String.valueOf(uVar.w().substring(0, uVar.w().length() - 2)) + "%"});
                    sb2 = new StringBuilder();
                    str = "saveSportsModesData 更新 ";
                }
                sb2.append(str);
                sb2.append(uVar.w());
                sb2.append(",sportsModes =");
                sb2.append(uVar.n());
                v.a(sb2.toString());
                if (cursor == null) {
                    cursor.close();
                    return;
                }
                return;
            }
            z10 = false;
            v.a("saveSportsModesData result =" + z10);
            if (z10) {
            }
            sb2.append(str);
            sb2.append(uVar.w());
            sb2.append(",sportsModes =");
            sb2.append(uVar.n());
            v.a(sb2.toString());
            if (cursor == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x0058, B:16:0x006e, B:18:0x0079), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006e A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x0058, B:16:0x006e, B:18:0x0079), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079 A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x0058, B:16:0x006e, B:18:0x0079), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void C(cn.v vVar) {
        boolean z10;
        Cursor cursor;
        try {
            cursor = this.f26198c.query("standing_time_table", null, "standing_time_start_date=?", new String[]{String.valueOf(vVar.e())}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", vVar.b());
            contentValues.put("standing_time_start_date", vVar.e());
            contentValues.put("standing_time_end_date", vVar.d());
            contentValues.put("standing_time_duration", Integer.valueOf(vVar.c()));
            if (!z10) {
                this.f26198c.update("standing_time_table", contentValues, "standing_time_start_date=?", new String[]{String.valueOf(vVar.e())});
            } else {
                this.f26198c.insert("standing_time_table", "id", contentValues);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        z10 = false;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("calendar", vVar.b());
        contentValues2.put("standing_time_start_date", vVar.e());
        contentValues2.put("standing_time_end_date", vVar.d());
        contentValues2.put("standing_time_duration", Integer.valueOf(vVar.c()));
        if (!z10) {
        }
        if (cursor != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D(String str, int i10, float f10, float f11, String str2, int i11, float f12, float f13, int i12, String str3, int i13, float f14, float f15, int i14, String str4) {
        boolean z10;
        Cursor cursor;
        Cursor cursor2;
        this.f26198c.execSQL("create table if not exists step_total_table(id integer primary key,date TEXT,step integer,distance integer,sport_time integer,calories integer,hour_details_array TEXT,run_steps integer,run_calories integer,run_distance integer,run_duration integer,run_hour_details_array TEXT,walk_steps integer,walk_calories integer,walk_distance integer,walk_duration integer,walk_hour_details_array TEXT )");
        ContentValues contentValues = new ContentValues();
        contentValues.put(ContactConstant.CallsRecordKeys.DATE, str);
        contentValues.put("step", Integer.valueOf(i10));
        contentValues.put("distance", Float.valueOf(f11));
        contentValues.put("calories", Float.valueOf(f10));
        contentValues.put("hour_details_array", str2);
        contentValues.put("run_steps", Integer.valueOf(i11));
        contentValues.put("run_calories", Float.valueOf(f12));
        contentValues.put("run_distance", Float.valueOf(f13));
        contentValues.put("run_duration", Integer.valueOf(i12));
        contentValues.put("run_hour_details_array", str3);
        contentValues.put("walk_steps", Integer.valueOf(i13));
        contentValues.put("walk_calories", Float.valueOf(f14));
        contentValues.put("walk_distance", Float.valueOf(f15));
        contentValues.put("walk_duration", Integer.valueOf(i14));
        contentValues.put("walk_hour_details_array", str4);
        try {
            cursor = this.f26198c.query("step_total_table", null, "date=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            StringBuilder sb2 = new StringBuilder();
            cursor2 = cursor;
            sb2.append("插入数据库  mCalendar =");
            sb2.append(str);
            sb2.append(",result =");
            sb2.append(z10);
            gn.u.a("step_data", sb2.toString());
            if (z10) {
                this.f26198c.insert("step_total_table", "id", contentValues);
                gn.u.d("step_data", "插入数据库  mCalendar =" + str + ",totalSteps=" + i10 + ",totalCalories=" + f10 + ",totalDistance=" + f11 + ",runSteps=" + i11 + ",runCalories=" + f12 + ",runDistance=" + f13 + ",runDuration=" + i12 + ",walkSteps=" + i13 + ",walkCalories=" + f14 + ",walkDistance=" + f15 + ",walkDuration=" + i14 + ",hourDetails=" + str2 + ",runHourDetails=" + str3 + ",walkHourDetails=" + str4);
            } else {
                this.f26198c.update("step_total_table", contentValues, "date=?", new String[]{String.valueOf(str)});
                gn.u.a("step_data", "更新数据库  mCalendar =" + str + ",totalSteps=" + i10 + ",totalCalories=" + f10 + ",totalDistance=" + f11 + ",runSteps=" + i11 + ",runCalories=" + f12 + ",runDistance=" + f13 + ",runDuration=" + i12 + ",walkSteps=" + i13 + ",walkCalories=" + f14 + ",walkDistance=" + f15 + ",walkDuration=" + i14 + ",hourDetails=" + str2 + ",runHourDetails=" + str3 + ",walkHourDetails=" + str4);
            }
            if (cursor2 == null) {
                cursor2.close();
                return;
            }
            return;
        }
        z10 = false;
        StringBuilder sb22 = new StringBuilder();
        cursor2 = cursor;
        sb22.append("插入数据库  mCalendar =");
        sb22.append(str);
        sb22.append(",result =");
        sb22.append(z10);
        gn.u.a("step_data", sb22.toString());
        if (z10) {
        }
        if (cursor2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(String str, int i10, int i11, int i12, int i13, float f10) {
        boolean z10;
        Cursor cursor;
        Cursor cursor2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("end_time", Integer.valueOf(i11));
        contentValues.put("use_time", Integer.valueOf(i12));
        contentValues.put(ContactConstant.CallsRecordKeys.COUNT, Integer.valueOf(i13));
        contentValues.put("calories", Float.valueOf(f10));
        try {
            cursor = this.f26198c.query("swim_table_name", null, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            cursor2 = cursor;
            if (z10) {
                this.f26198c.insert("swim_table_name", "id", contentValues);
                gn.u.a("UTESQLOperate", "保存游泳数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",count =" + i13 + ",calories =" + f10);
            } else {
                this.f26198c.update("swim_table_name", contentValues, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
                gn.u.a("UTESQLOperate", "更新游泳数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",count =" + i13 + ",calories =" + f10);
            }
            if (cursor2 == null) {
                cursor2.close();
                return;
            }
            return;
        }
        z10 = false;
        cursor2 = cursor;
        if (z10) {
        }
        if (cursor2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0084 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x0084, B:16:0x009a, B:18:0x00a5), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009a A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x0084, B:16:0x009a, B:18:0x00a5), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a5 A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x0084, B:16:0x009a, B:18:0x00a5), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void F(a0 a0Var) {
        boolean z10;
        Cursor cursor;
        try {
            cursor = this.f26198c.query("temperature_table", null, "StartDate=?", new String[]{String.valueOf(a0Var.g())}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", a0Var.e());
            contentValues.put("StartDate", a0Var.g());
            contentValues.put("time", Integer.valueOf(a0Var.f()));
            contentValues.put("type", Integer.valueOf(a0Var.h()));
            contentValues.put("body_surface_temperature", Float.valueOf(a0Var.c()));
            contentValues.put("body_temperature", Float.valueOf(a0Var.d()));
            contentValues.put("ambient_temperature", Float.valueOf(a0Var.b()));
            if (!z10) {
                this.f26198c.update("temperature_table", contentValues, "StartDate=?", new String[]{String.valueOf(a0Var.g())});
            } else {
                this.f26198c.insert("temperature_table", "id", contentValues);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        z10 = false;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("calendar", a0Var.e());
        contentValues2.put("StartDate", a0Var.g());
        contentValues2.put("time", Integer.valueOf(a0Var.f()));
        contentValues2.put("type", Integer.valueOf(a0Var.h()));
        contentValues2.put("body_surface_temperature", Float.valueOf(a0Var.c()));
        contentValues2.put("body_temperature", Float.valueOf(a0Var.d()));
        contentValues2.put("ambient_temperature", Float.valueOf(a0Var.b()));
        if (!z10) {
        }
        if (cursor != null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (r11.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c(String str) {
        Cursor cursor;
        boolean z10 = true;
        try {
            cursor = this.f26198c.query("custom_dial_table", null, "custom_dial_id=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        z10 = false;
        if (cursor != null) {
            cursor.close();
        }
        return z10;
    }

    public void d() {
        Cursor cursor;
        try {
            cursor = this.f26198c.rawQuery("select name from sqlite_master where type='table' order by name", null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String string = cursor.getString(0);
                if ((string != null && string.contains("step_total_table")) || ((string != null && string.contains("sleep_total_table")) || ((string != null && string.contains("rate_all_data_table")) || ((string != null && string.contains("blood_pressure_all_data_table")) || ((string != null && string.contains("swim_table_name")) || ((string != null && string.contains("skip_table_name")) || ((string != null && string.contains("air_pressure_temperature_table_name")) || ((string != null && string.contains("ride_table_name")) || ((string != null && string.contains("ball_sports_table_name")) || ((string != null && string.contains("rate_24_hour_table_name")) || (string != null && string.contains("sports_modes_table")))))))))))) {
                    try {
                        this.f26198c.delete(string, null, null);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        this.f26198c.execSQL("create table if not exists step_total_table(id integer primary key,date TEXT,step integer,distance integer,sport_time integer,calories integer )");
        this.f26198c.execSQL("create table if not exists sleep_total_table(id integer primary key,date TEXT,time integer,sleep_time_status_array TEXT )");
        this.f26198c.execSQL("create table if not exists rate_all_data_table(id integer primary key,calendar TEXT,time integer,rate integer )");
        this.f26198c.execSQL("create table if not exists blood_pressure_all_data_table(id integer primary key,calendar TEXT,time integer,blood_pressure_value_high integer ,blood_pressure_value_low integer )");
        this.f26198c.execSQL("create table if not exists swim_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        this.f26198c.execSQL("create table if not exists skip_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,count integer,calories integer )");
        this.f26198c.execSQL("create table if not exists air_pressure_temperature_table_name(id integer primary key,calendar TEXT,time integer,air_pressure integer,temperature integer )");
        this.f26198c.execSQL("create table if not exists ride_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,ver_speed integer,calories integer,distance integer )");
        this.f26198c.execSQL("create table if not exists ball_sports_table_name(id integer primary key,calendar TEXT,start_time integer,end_time integer,use_time integer,calories integer,sports_type integer )");
        this.f26198c.execSQL("create table if not exists rate_24_hour_table_name(id integer primary key,calendar TEXT,time integer,rate integer )");
        this.f26198c.execSQL("create table if not exists sports_modes_table(id integer primary key,current_sports_modes integer,sports_modes_rate_count integer,calendar TEXT,start_date_time TEXT,end_date_time TEXT,duration integer,ble_step_count integer,ble_sports_count integer,ble_sports_calories integer,ble_sports_distance REAL,ble_average_rate integer,ble_max_rate integer,ble_min_rate integer,ble_average_pace integer,ble_time_interval integer,ble_all_rate TEXT )");
        if (cursor != null) {
            cursor.close();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r3.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<l> e(String str) {
        Cursor cursor;
        ArrayList arrayList = null;
        boolean z10 = true;
        try {
            cursor = this.f26198c.query("rate_24_hour_table_name", null, "calendar=?", new String[]{String.valueOf(str)}, "time", null, "time asc");
        } catch (Exception unused) {
            cursor = null;
        }
        z10 = false;
        if (z10) {
            arrayList = new ArrayList();
            if (cursor.moveToFirst()) {
                for (int i10 = 0; i10 < cursor.getCount(); i10++) {
                    arrayList.add(new l(str, cursor.getInt(cursor.getColumnIndex("time")), cursor.getInt(cursor.getColumnIndex("rate"))));
                    cursor.moveToNext();
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
        if (r1.getCount() > 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<d> f(String str, String str2) {
        ArrayList arrayList;
        Cursor cursor;
        boolean z10;
        int i10;
        arrayList = new ArrayList();
        cursor = null;
        z10 = true;
        try {
            cursor = this.f26198c.query("custom_dial_table", null, "custom_dial_type=? and custom_dial_dpi=?", new String[]{String.valueOf(str), String.valueOf(str2)}, "custom_dial_id", null, "custom_dial_id ASC");
        } catch (Exception unused) {
        }
        return arrayList;
        z10 = false;
        if (z10 && cursor.moveToFirst()) {
            for (i10 = 0; i10 < cursor.getCount(); i10++) {
                arrayList.add(new d(cursor.getString(cursor.getColumnIndex("custom_dial_id")), cursor.getString(cursor.getColumnIndex("custom_dial_type")), cursor.getString(cursor.getColumnIndex("custom_dial_dpi")), cursor.getString(cursor.getColumnIndex("custom_dial_file")), cursor.getString(cursor.getColumnIndex("custom_dial_note")), cursor.getString(cursor.getColumnIndex("custom_dial_createtime")), cursor.getString(cursor.getColumnIndex("custom_dial_folderdial")), cursor.getInt(cursor.getColumnIndex("custom_dial_pathstatus"))));
                cursor.moveToNext();
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<i> g(String str) {
        boolean z10;
        Cursor cursor;
        Cursor cursor2;
        String str2 = "time";
        String a10 = a(str);
        ArrayList arrayList = null;
        int i10 = 0;
        try {
            cursor = this.f26198c.query("ecg_table", null, null, null, "time", null, str2 + a10);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            if (!z10) {
                ArrayList arrayList2 = new ArrayList();
                if (cursor.moveToFirst()) {
                    while (i10 < cursor.getCount()) {
                        String string = cursor.getString(cursor.getColumnIndex("calendar"));
                        String string2 = cursor.getString(cursor.getColumnIndex(str2));
                        int i11 = cursor.getInt(cursor.getColumnIndex("start_time"));
                        int i12 = cursor.getInt(cursor.getColumnIndex("average_rate"));
                        int i13 = cursor.getInt(cursor.getColumnIndex("ecg_HRV"));
                        int i14 = cursor.getInt(cursor.getColumnIndex("ecg_strength"));
                        int i15 = cursor.getInt(cursor.getColumnIndex("ecg_risk_level"));
                        int i16 = cursor.getInt(cursor.getColumnIndex("ecg_fatigue_index"));
                        String string3 = cursor.getString(cursor.getColumnIndex("ecg_sampling_data"));
                        int i17 = cursor.getInt(cursor.getColumnIndex("ecg_total_count"));
                        int i18 = cursor.getInt(cursor.getColumnIndex("ecg_person"));
                        str2 = str2;
                        String string4 = cursor.getString(cursor.getColumnIndex("ecg_label"));
                        String string5 = cursor.getString(cursor.getColumnIndex("ecg_real_value_array"));
                        int i19 = i10;
                        Cursor cursor3 = cursor;
                        ArrayList arrayList3 = arrayList2;
                        i iVar = new i(string, string2, i11, i12, i13, i14, i15, i16, string3, i17, i18, string4, string5);
                        gn.l.c("queryEcgAll ,calendar =" + string + ",calendarTime =" + string2 + ",startTime =" + i11 + ",totalCount =" + i17 + ",ecgAverageRate =" + i12 + ",ecgHRV =" + i13 + ",ecgStrength =" + i14 + ",ecgRiskLevel =" + i15 + ",ecgFatigueIndex =" + i16 + ",whichPerson =" + i18 + ",ecgLabel =" + string4 + ",ecgSamplingData =" + string3);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("queryEcgInfo ,realEcgValueArray =");
                        sb2.append(string5);
                        gn.l.c(sb2.toString());
                        arrayList3.add(iVar);
                        cursor3.moveToNext();
                        i10 = i19 + 1;
                        arrayList2 = arrayList3;
                        cursor = cursor3;
                    }
                }
                cursor2 = cursor;
                arrayList = arrayList2;
            } else {
                cursor2 = cursor;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return arrayList;
        }
        z10 = false;
        if (!z10) {
        }
        if (cursor2 != null) {
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r1.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<k> h(String str) {
        ArrayList arrayList;
        Cursor cursor;
        boolean z10;
        int i10;
        arrayList = new ArrayList();
        cursor = null;
        z10 = true;
        try {
            cursor = this.f26198c.query("oxygen_table", null, "calendar=?", new String[]{String.valueOf(str)}, "StartDate", null, "StartDate ASC");
        } catch (Exception unused) {
        }
        return arrayList;
        z10 = false;
        if (z10) {
            int count = cursor.getCount();
            if (cursor.moveToFirst()) {
                for (i10 = 0; i10 < count; i10++) {
                    arrayList.add(new k(str, cursor.getString(cursor.getColumnIndex("StartDate")), cursor.getInt(cursor.getColumnIndex("time")), cursor.getInt(cursor.getColumnIndex("oxygen_value"))));
                    cursor.moveToNext();
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r4.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m i(String str) {
        Cursor cursor;
        int i10;
        int i11;
        int i12;
        int i13;
        m mVar = null;
        boolean z10 = true;
        int i14 = 0;
        try {
            cursor = this.f26198c.query("rate_all_data_table", null, "calendar=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        z10 = false;
        if (z10) {
            int i15 = 1000;
            int count = cursor.getCount();
            if (cursor.moveToFirst()) {
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                while (i14 < count) {
                    int i20 = cursor.getInt(cursor.getColumnIndex("rate"));
                    if (i14 == count - 1) {
                        i16 = cursor.getInt(cursor.getColumnIndex("time"));
                        i18 = i20;
                    }
                    if (i20 > i17) {
                        i17 = i20;
                    }
                    if (i20 <= i15) {
                        i15 = i20;
                    }
                    i19 += i20;
                    cursor.moveToNext();
                    i14++;
                }
                i13 = i15;
                i10 = i16;
                i12 = i17;
                i11 = i18;
                i14 = i19;
            } else {
                i13 = 1000;
                i12 = 0;
                i11 = 0;
                i10 = 0;
            }
            mVar = new m(str, i13, i14 / count, i12, i11, i10);
        }
        if (cursor != null) {
            cursor.close();
        }
        return mVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r3.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public w j(String str) {
        Cursor cursor;
        String str2 = str;
        w wVar = null;
        boolean z10 = true;
        try {
            cursor = this.f26198c.query("step_total_table", null, "date=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        z10 = false;
        Cursor cursor2 = cursor;
        if (z10) {
            new ArrayList();
            new ArrayList();
            new ArrayList();
            if (cursor2.moveToFirst()) {
                int i10 = 0;
                while (i10 < cursor2.getCount()) {
                    int i11 = cursor2.getInt(cursor2.getColumnIndex("step"));
                    float f10 = cursor2.getFloat(cursor2.getColumnIndex("calories"));
                    float f11 = cursor2.getFloat(cursor2.getColumnIndex("distance"));
                    ArrayList<x> c10 = s.c(cursor2.getString(cursor2.getColumnIndex("hour_details_array")));
                    int i12 = cursor2.getInt(cursor2.getColumnIndex("run_steps"));
                    float f12 = cursor2.getFloat(cursor2.getColumnIndex("run_calories"));
                    float f13 = cursor2.getFloat(cursor2.getColumnIndex("run_distance"));
                    int i13 = cursor2.getInt(cursor2.getColumnIndex("run_duration"));
                    String string = cursor2.getString(cursor2.getColumnIndex("run_hour_details_array"));
                    ArrayList<y> a10 = s.a(string);
                    int i14 = cursor2.getInt(cursor2.getColumnIndex("walk_steps"));
                    float f14 = cursor2.getFloat(cursor2.getColumnIndex("walk_calories"));
                    float f15 = cursor2.getFloat(cursor2.getColumnIndex("walk_distance"));
                    int i15 = cursor2.getInt(cursor2.getColumnIndex("walk_duration"));
                    String string2 = cursor2.getString(cursor2.getColumnIndex("walk_hour_details_array"));
                    ArrayList<z> d10 = s.d(string2);
                    int i16 = i10;
                    StringBuilder sb2 = new StringBuilder();
                    Cursor cursor3 = cursor2;
                    sb2.append("queryRunWalkInfo stepCalendar =");
                    sb2.append(str2);
                    sb2.append(",walkSteps =");
                    sb2.append(i14);
                    sb2.append(",walkHourDetails =");
                    sb2.append(string2);
                    gn.u.a("UTESQLOperate", sb2.toString());
                    gn.u.a("UTESQLOperate", "queryRunWalkInfo stepCalendar =" + str2 + ",runSteps =" + i12 + ",runHourDetails =" + string);
                    wVar = new w(str, i11, f10, f11, i12, f12, f13, i13, i14, f14, f15, i15, c10, a10, d10);
                    cursor3.moveToNext();
                    i10 = i16 + 1;
                    str2 = str;
                    cursor2 = cursor3;
                }
            }
        }
        Cursor cursor4 = cursor2;
        if (cursor4 != null) {
            cursor4.close();
        }
        return wVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0328  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0187 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public cn.q k(String str) {
        boolean z10;
        Cursor cursor;
        int i10;
        Cursor cursor2;
        int i11;
        int[] iArr;
        int i12;
        int[] iArr2;
        Exception e10;
        gn.u.d("querySleepInfoTest", "查询的日期  =" + str);
        cn.q qVar = null;
        boolean z11 = true;
        try {
            cursor = this.f26198c.query("sleep_total_table", null, "date=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception e11) {
            e10 = e11;
            cursor = null;
        }
        try {
            i10 = cursor.getCount();
            z10 = i10 > 0;
        } catch (Exception e12) {
            e10 = e12;
            gn.u.d("querySleepInfoTest", "Exception =" + e10);
            i10 = 0;
            z10 = false;
            gn.u.d("querySleepInfoTest", "exist =" + z10 + ",count =" + i10);
            if (z10) {
            }
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            gn.u.d("querySleepInfoTest", "最终返回 sleepTimeInfo" + qVar);
            return qVar;
        }
        gn.u.d("querySleepInfoTest", "exist =" + z10 + ",count =" + i10);
        if (z10) {
            String str2 = "";
            int i13 = 0;
            while (cursor.moveToNext()) {
                i13 = cursor.getInt(cursor.getColumnIndex("time"));
                str2 = cursor.getString(cursor.getColumnIndex("sleep_time_status_array"));
            }
            gn.u.d("querySleepInfoTest", "sleep_time_status_array =" + str2);
            if (str2 != null && !str2.equals("")) {
                int i14 = -1;
                ArrayList arrayList = new ArrayList();
                cn.q qVar2 = new cn.q();
                List<r> b10 = s.b(str2);
                gn.u.d("querySleepInfoTest", "list =" + b10);
                if (b10 == null) {
                    cursor.close();
                    return null;
                }
                gn.u.d("querySleepInfoTest", "list.size() =" + b10.size());
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i15 < b10.size()) {
                    int c10 = b10.get(i15).c();
                    int a10 = b10.get(i15).a();
                    int b11 = b10.get(i15).b();
                    if (c10 == i16 || b11 == i14) {
                        z11 = false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    cursor = cursor;
                    sb2.append("startTime =");
                    sb2.append(c10);
                    sb2.append(",endTime =");
                    sb2.append(a10);
                    sb2.append(",status =");
                    sb2.append(b11);
                    sb2.append(",interrupted =");
                    sb2.append(z11);
                    sb2.append(",duration =");
                    sb2.append(a10 - c10);
                    gn.u.d("querySleepInfoTest", sb2.toString());
                    if (i15 != 0) {
                        if (z11 || b11 != i14) {
                            arrayList.add(new p(i17, i16, i17 > i16 ? (i16 + 1440) - i17 : i16 - i17, i14));
                        }
                        if (i15 == b10.size() - 1) {
                            arrayList.add(new p(i17, a10, i17 > a10 ? (a10 + 1440) - i17 : a10 - i17, b11));
                            i17 = c10;
                        }
                        i15++;
                        i14 = b11;
                        i16 = a10;
                        z11 = true;
                    }
                    i17 = c10;
                    if (i15 == b10.size() - 1) {
                    }
                    i15++;
                    i14 = b11;
                    i16 = a10;
                    z11 = true;
                }
                cursor2 = cursor;
                int size = arrayList.size();
                if (size != 0) {
                    int[] iArr3 = new int[size];
                    int[] iArr4 = new int[size];
                    int[] iArr5 = new int[size];
                    int i18 = 0;
                    int i19 = 0;
                    int i20 = 0;
                    int i21 = 0;
                    int i22 = 0;
                    int i23 = 0;
                    int i24 = 0;
                    while (i18 < size) {
                        iArr3[i18] = arrayList.get(i18).b();
                        i23 = i23;
                        int a11 = arrayList.get(i18).a();
                        iArr4[i18] = a11;
                        iArr5[i18] = arrayList.get(i18).c();
                        if (a11 == 0) {
                            i22 += arrayList.get(i18).b();
                            iArr2 = iArr4;
                        } else {
                            iArr2 = iArr4;
                            if (a11 == 1) {
                                i21 += arrayList.get(i18).b();
                            } else if (a11 == 2) {
                                i20 += arrayList.get(i18).b();
                                i19++;
                            }
                        }
                        if (i18 == 0) {
                            i23 = arrayList.get(i18).d();
                        }
                        if (i18 == size - 1) {
                            i24 = iArr5[i18];
                        }
                        StringBuilder sb3 = new StringBuilder();
                        i19 = i19;
                        sb3.append("睡眠时间区间duration[");
                        sb3.append(i18);
                        sb3.append("]=");
                        sb3.append(iArr3[i18]);
                        gn.u.d("querySleepInfoTest", sb3.toString());
                        i18++;
                        iArr4 = iArr2;
                    }
                    int[] iArr6 = iArr4;
                    int i25 = i23;
                    gn.u.d("MySQLiteHelper", "睡眠总时间11=" + i13);
                    if (i13 >= 120) {
                        qVar2.n(str);
                        i11 = i25;
                        qVar2.m(i11);
                        i12 = i24;
                        qVar2.q(i12);
                        qVar2.u(i13);
                        qVar2.o(i22);
                        qVar2.r(i21);
                        qVar2.l(i20);
                        qVar2.k(i19);
                        qVar2.p(iArr3);
                        iArr = iArr6;
                        qVar2.t(iArr);
                        qVar2.v(iArr5);
                        qVar2.s(arrayList);
                    } else {
                        i12 = i24;
                        iArr = iArr6;
                        i11 = i25;
                    }
                    gn.u.d("querySleepInfoTest", "startSleepTime =" + i11 + ",endSleepTime=" + i12 + ",sleepTotalTime =" + i13);
                    gn.u.d("querySleepInfoTest", "deepTime =" + i22 + ",lightTime=" + i21 + ",activeTime =" + i20 + ",activeCount =" + i19);
                    for (int i26 = 0; i26 < size; i26++) {
                        gn.u.d("querySleepInfoTest", "duration[" + i26 + "]=" + iArr3[i26] + ",status[" + i26 + "]=" + iArr[i26] + ",point[" + i26 + "]=" + iArr5[i26]);
                    }
                }
                qVar = qVar2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                gn.u.d("querySleepInfoTest", "最终返回 sleepTimeInfo" + qVar);
                return qVar;
            }
        }
        cursor2 = cursor;
        if (cursor2 != null) {
        }
        gn.u.d("querySleepInfoTest", "最终返回 sleepTimeInfo" + qVar);
        return qVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
        if (r4.getCount() <= 0) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<u> l(int i10, String str) {
        Cursor query;
        int i11 = i10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("querySportsModes 查询 sportsModes = ");
        sb2.append(i11);
        sb2.append(",mCalendar =");
        String str2 = str;
        sb2.append(str2);
        v.a(sb2.toString());
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        boolean z10 = true;
        int i12 = 0;
        try {
            if (!TextUtils.isEmpty(str) && str.length() != 8) {
                str2 = null;
            }
            if (i11 < 0 || i11 > 25) {
                i11 = 0;
            }
            if (i11 == 0 && TextUtils.isEmpty(str2)) {
                query = this.f26198c.query("sports_modes_table", null, null, null, "start_date_time", null, "start_date_time DESC");
            } else if (i11 == 0 && !TextUtils.isEmpty(str2)) {
                query = this.f26198c.query("sports_modes_table", null, "calendar=?", new String[]{String.valueOf(str2)}, "start_date_time", null, "start_date_time DESC");
            } else if (i11 != 0 && TextUtils.isEmpty(str2)) {
                query = this.f26198c.query("sports_modes_table", null, "current_sports_modes=?", new String[]{String.valueOf(i11)}, "start_date_time", null, "start_date_time DESC");
            } else if (i11 != 0 && !TextUtils.isEmpty(str2)) {
                query = this.f26198c.query("sports_modes_table", null, "calendar=? and current_sports_modes=?", new String[]{String.valueOf(str2), String.valueOf(i11)}, "start_date_time", null, "start_date_time DESC");
            }
            cursor = query;
        } catch (Exception unused) {
        }
        z10 = false;
        if (z10 && cursor.moveToFirst()) {
            while (i12 < cursor.getCount()) {
                int i13 = cursor.getInt(cursor.getColumnIndex("current_sports_modes"));
                int i14 = cursor.getInt(cursor.getColumnIndex("sports_modes_rate_count"));
                String string = cursor.getString(cursor.getColumnIndex("calendar"));
                String string2 = cursor.getString(cursor.getColumnIndex("start_date_time"));
                String string3 = cursor.getString(cursor.getColumnIndex("end_date_time"));
                int i15 = cursor.getInt(cursor.getColumnIndex("duration"));
                int i16 = cursor.getInt(cursor.getColumnIndex("ble_step_count"));
                int i17 = cursor.getInt(cursor.getColumnIndex("ble_sports_count"));
                int i18 = cursor.getInt(cursor.getColumnIndex("ble_sports_calories"));
                float f10 = cursor.getFloat(cursor.getColumnIndex("ble_sports_distance"));
                int i19 = cursor.getInt(cursor.getColumnIndex("ble_average_rate"));
                int i20 = cursor.getInt(cursor.getColumnIndex("ble_max_rate"));
                int i21 = cursor.getInt(cursor.getColumnIndex("ble_min_rate"));
                int i22 = cursor.getInt(cursor.getColumnIndex("ble_average_pace"));
                Cursor cursor2 = cursor;
                ArrayList arrayList2 = arrayList;
                u uVar = new u(i13, i14, string, string2, string3, i15, i16, i17, i18, f10, i19, i20, i21, i22, cursor.getInt(cursor.getColumnIndex("ble_time_interval")), cursor.getString(cursor.getColumnIndex("ble_all_rate")));
                v.a("querySportsModes currentSportsModes =" + i13 + ",sportsModesRateCount =" + i14 + ",startDateTime =" + string2 + ",endDateTime =" + string3 + ",duration =" + i15 + ",bleSportsCount =" + i17 + ",bleAveragePace =" + i22);
                arrayList2.add(uVar);
                cursor2.moveToNext();
                i12++;
                arrayList = arrayList2;
                cursor = cursor2;
            }
        }
        ArrayList arrayList3 = arrayList;
        Cursor cursor3 = cursor;
        if (cursor3 != null) {
            cursor3.close();
        }
        return arrayList3;
    }

    public List<u> m(String str) {
        return l(0, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
        if (r1.getCount() > 0) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized List<a0> n(String str) {
        ArrayList arrayList;
        Cursor cursor;
        boolean z10;
        int i10;
        arrayList = new ArrayList();
        cursor = null;
        z10 = true;
        try {
            cursor = this.f26198c.query("temperature_table", null, "calendar=?", new String[]{String.valueOf(str)}, "time", null, "time asc");
        } catch (Exception unused) {
        }
        return arrayList;
        z10 = false;
        if (z10) {
            int count = cursor.getCount();
            if (cursor.moveToFirst()) {
                for (i10 = 0; i10 < count; i10++) {
                    arrayList.add(new a0(cursor.getInt(cursor.getColumnIndex("type")), str, cursor.getString(cursor.getColumnIndex("StartDate")), cursor.getInt(cursor.getColumnIndex("time")), cursor.getFloat(cursor.getColumnIndex("body_surface_temperature")), cursor.getFloat(cursor.getColumnIndex("body_temperature")), cursor.getFloat(cursor.getColumnIndex("ambient_temperature"))));
                    cursor.moveToNext();
                }
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(String str, int i10, int i11) {
        boolean z10;
        Cursor cursor;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("time", Integer.valueOf(i10));
        contentValues.put("rate", Integer.valueOf(i11));
        try {
            cursor = this.f26198c.query("rate_24_hour_table_name", null, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            if (z10) {
                this.f26198c.insert("rate_24_hour_table_name", "id", contentValues);
            } else {
                this.f26198c.update("rate_24_hour_table_name", contentValues, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
            }
            if (cursor == null) {
                cursor.close();
                return;
            }
            return;
        }
        z10 = false;
        if (z10) {
        }
        if (cursor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p(a aVar) {
        boolean z10;
        String str;
        StringBuilder sb2;
        gn.a aVar2;
        if (aVar == null) {
            gn.a.g().j("保存的气压数据info 为 null");
            return;
        }
        String b10 = aVar.b();
        int d10 = aVar.d();
        int a10 = aVar.a();
        int c10 = aVar.c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", b10);
        contentValues.put("time", Integer.valueOf(d10));
        contentValues.put("air_pressure", Integer.valueOf(a10));
        contentValues.put(SettingConstants.TEMPERATURE, Integer.valueOf(c10));
        Cursor cursor = null;
        try {
            cursor = this.f26198c.query("air_pressure_temperature_table_name", null, "calendar=? and time=?", new String[]{String.valueOf(b10), String.valueOf(d10)}, null, null, null);
        } catch (Exception unused) {
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            if (z10) {
                this.f26198c.insert("air_pressure_temperature_table_name", "id", contentValues);
                aVar2 = gn.a.g();
                sb2 = new StringBuilder();
                str = "保存气压温度  tempCalendar =";
            } else {
                this.f26198c.update("air_pressure_temperature_table_name", contentValues, "calendar=? and time=?", new String[]{String.valueOf(b10), String.valueOf(d10)});
                aVar2 = gn.a.g();
                sb2 = new StringBuilder();
                str = "更新气压温度  tempCalendar =";
            }
            sb2.append(str);
            sb2.append(b10);
            sb2.append(",time =");
            sb2.append(d10);
            sb2.append(",airPressure =");
            sb2.append(a10);
            sb2.append(",temperature =");
            sb2.append(c10);
            aVar2.j(sb2.toString());
            if (cursor == null) {
                cursor.close();
                return;
            }
            return;
        }
        z10 = false;
        if (z10) {
        }
        sb2.append(str);
        sb2.append(b10);
        sb2.append(",time =");
        sb2.append(d10);
        sb2.append(",airPressure =");
        sb2.append(a10);
        sb2.append(",temperature =");
        sb2.append(c10);
        aVar2.j(sb2.toString());
        if (cursor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(String str, int i10, int i11) {
        boolean z10;
        String str2;
        StringBuilder sb2;
        if (i11 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", str);
            contentValues.put("time", Integer.valueOf(i10));
            contentValues.put("rate", Integer.valueOf(i11));
            Cursor cursor = null;
            try {
                cursor = this.f26198c.query("rate_all_data_table", null, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
            } catch (Exception unused) {
            }
            if (cursor.getCount() > 0) {
                z10 = true;
                if (z10) {
                    this.f26198c.insert("rate_all_data_table", "id", contentValues);
                    sb2 = new StringBuilder();
                    str2 = "插入单次测试心率数据  calendar =";
                } else {
                    this.f26198c.update("rate_all_data_table", contentValues, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
                    sb2 = new StringBuilder();
                    str2 = "更新单次测试心率数据  calendar =";
                }
                sb2.append(str2);
                sb2.append(str);
                sb2.append(",time=");
                sb2.append(i10);
                sb2.append(",rate=");
                sb2.append(i11);
                Log.d("UTESQLOperate", sb2.toString());
                if (cursor == null) {
                    cursor.close();
                    return;
                }
                return;
            }
            z10 = false;
            if (z10) {
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append(",time=");
            sb2.append(i10);
            sb2.append(",rate=");
            sb2.append(i11);
            Log.d("UTESQLOperate", sb2.toString());
            if (cursor == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(String str, int i10, int i11, int i12, int i13, int i14) {
        boolean z10;
        Cursor cursor;
        Cursor cursor2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("end_time", Integer.valueOf(i11));
        contentValues.put("use_time", Integer.valueOf(i12));
        contentValues.put("calories", Integer.valueOf(i13));
        contentValues.put("sports_type", Integer.valueOf(i14));
        try {
            cursor = this.f26198c.query("ball_sports_table_name", null, "sports_type=? and calendar=? and start_time=?", new String[]{String.valueOf(i14), String.valueOf(str), String.valueOf(i10)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            cursor2 = cursor;
            if (z10) {
                this.f26198c.insert("ball_sports_table_name", "id", contentValues);
                gn.u.a("UTESQLOperate", "保存球类数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",calories =" + i13 + ",sportsMode =" + i14);
            } else {
                this.f26198c.update("ball_sports_table_name", contentValues, "sports_type=? and calendar=? and start_time=?", new String[]{String.valueOf(i14), String.valueOf(str), String.valueOf(i10)});
                gn.u.a("UTESQLOperate", "更新球类数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",calories =" + i13 + ",sportsMode =" + i14);
            }
            if (cursor2 == null) {
                cursor2.close();
                return;
            }
            return;
        }
        z10 = false;
        cursor2 = cursor;
        if (z10) {
        }
        if (cursor2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(String str, int i10, int i11, int i12) {
        boolean z10;
        String str2;
        StringBuilder sb2;
        if (i11 != 0 && i12 != 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", str);
            contentValues.put("time", Integer.valueOf(i10));
            contentValues.put("blood_pressure_value_high", Integer.valueOf(i11));
            contentValues.put("blood_pressure_value_low", Integer.valueOf(i12));
            Cursor cursor = null;
            try {
                cursor = this.f26198c.query("blood_pressure_all_data_table", null, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
            } catch (Exception unused) {
            }
            if (cursor.getCount() > 0) {
                z10 = true;
                if (z10) {
                    this.f26198c.insert("blood_pressure_all_data_table", "id", contentValues);
                    sb2 = new StringBuilder();
                    str2 = "插入血压数据  calendar =";
                } else {
                    this.f26198c.update("blood_pressure_all_data_table", contentValues, "calendar=? and time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
                    sb2 = new StringBuilder();
                    str2 = "更新血压数据  calendar =";
                }
                sb2.append(str2);
                sb2.append(str);
                sb2.append(",time=");
                sb2.append(i10);
                sb2.append(",bpv_h=");
                sb2.append(i11);
                sb2.append(",bpv_l=");
                sb2.append(i12);
                Log.d("UTESQLOperate", sb2.toString());
                if (cursor == null) {
                    cursor.close();
                    return;
                }
                return;
            }
            z10 = false;
            if (z10) {
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append(",time=");
            sb2.append(i10);
            sb2.append(",bpv_h=");
            sb2.append(i11);
            sb2.append(",bpv_l=");
            sb2.append(i12);
            Log.d("UTESQLOperate", sb2.toString());
            if (cursor == null) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(String str, String str2, String str3, int i10, float f10, float f11, float f12, int i11, float f13, float f14, boolean z10, int i12, int i13, float f15) {
        boolean z11;
        Cursor cursor;
        f.c("saveBodyFat ,calendar =" + str + ",calendarTime =" + str2 + ",startTime =" + i10 + ",bodyFat =" + f10 + ",bodyWater =" + f11 + ",bodyProtein =" + f12 + ",bodyBMR =" + i11 + ",bodyBoneSalt =" + f13 + ",bodyMuscle =" + f14 + ",bodyGender =" + z10 + ",bodyAge =" + i12 + ",bodyHeight =" + i13 + ",bodyWeight =" + f15);
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("time", str2);
        contentValues.put("month", str3);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("body_fat", Float.valueOf(f10));
        contentValues.put("body_water", Float.valueOf(f11));
        contentValues.put("body_protein", Float.valueOf(f12));
        contentValues.put("body_bmr", Integer.valueOf(i11));
        contentValues.put("body_bone_salt", Float.valueOf(f13));
        contentValues.put("body_muscle", Float.valueOf(f14));
        contentValues.put("body_gender", Integer.valueOf(z10 ? 1 : 0));
        contentValues.put("body_age", Integer.valueOf(i12));
        contentValues.put("body_height", Integer.valueOf(i13));
        contentValues.put("body_weight", Float.valueOf(f15));
        try {
            cursor = this.f26198c.query("body_fat_table", null, "calendar=?", new String[]{String.valueOf(str)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z11 = true;
            f.c("saveBodyFat result =" + z11);
            if (z11) {
                this.f26198c.insert("body_fat_table", "id", contentValues);
            } else {
                this.f26198c.update("body_fat_table", contentValues, "calendar=?", new String[]{String.valueOf(str)});
            }
            if (cursor == null) {
                cursor.close();
                return;
            }
            return;
        }
        z11 = false;
        f.c("saveBodyFat result =" + z11);
        if (z11) {
        }
        if (cursor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void u(cn.d dVar) {
        boolean z10;
        Cursor cursor;
        try {
            cursor = this.f26198c.query("breathe_table", null, "StartDate=?", new String[]{String.valueOf(dVar.d())}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", dVar.c());
            contentValues.put("StartDate", dVar.d());
            contentValues.put("time", Integer.valueOf(dVar.e()));
            contentValues.put("breathe_value", Integer.valueOf(dVar.b()));
            if (!z10) {
                this.f26198c.update("breathe_table", contentValues, "StartDate=?", new String[]{String.valueOf(dVar.d())});
            } else {
                this.f26198c.insert("breathe_table", "id", contentValues);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        z10 = false;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("calendar", dVar.c());
        contentValues2.put("StartDate", dVar.d());
        contentValues2.put("time", Integer.valueOf(dVar.e()));
        contentValues2.put("breathe_value", Integer.valueOf(dVar.b()));
        if (!z10) {
        }
        if (cursor != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x007d, B:16:0x0093, B:18:0x009e), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x007d, B:16:0x0093, B:18:0x009e), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009e A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x002a, B:15:0x007d, B:16:0x0093, B:18:0x009e), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void v(d dVar) {
        boolean z10;
        Cursor cursor;
        try {
            cursor = this.f26198c.query("custom_dial_table", null, "custom_dial_id=?", new String[]{String.valueOf(dVar.f())}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("custom_dial_id", dVar.f());
            contentValues.put("custom_dial_type", dVar.i());
            contentValues.put("custom_dial_dpi", dVar.c());
            contentValues.put("custom_dial_file", dVar.d());
            contentValues.put("custom_dial_note", dVar.g());
            contentValues.put("custom_dial_createtime", dVar.b());
            contentValues.put("custom_dial_folderdial", dVar.e());
            contentValues.put("custom_dial_pathstatus", Integer.valueOf(dVar.h()));
            if (!z10) {
                this.f26198c.update("custom_dial_table", contentValues, "custom_dial_id=?", new String[]{String.valueOf(dVar.f())});
            } else {
                this.f26198c.insert("custom_dial_table", "id", contentValues);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        z10 = false;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("custom_dial_id", dVar.f());
        contentValues2.put("custom_dial_type", dVar.i());
        contentValues2.put("custom_dial_dpi", dVar.c());
        contentValues2.put("custom_dial_file", dVar.d());
        contentValues2.put("custom_dial_note", dVar.g());
        contentValues2.put("custom_dial_createtime", dVar.b());
        contentValues2.put("custom_dial_folderdial", dVar.e());
        contentValues2.put("custom_dial_pathstatus", Integer.valueOf(dVar.h()));
        if (!z10) {
        }
        if (cursor != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w(String str, String str2, int i10, int i11, int i12, int i13, int i14, int i15, String str3, int i16, String str4) {
        boolean z10;
        Cursor cursor;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("time", str2);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("average_rate", Integer.valueOf(i11));
        contentValues.put("ecg_HRV", Integer.valueOf(i12));
        contentValues.put("ecg_strength", Integer.valueOf(i13));
        contentValues.put("ecg_risk_level", Integer.valueOf(i14));
        contentValues.put("ecg_fatigue_index", Integer.valueOf(i15));
        contentValues.put("ecg_sampling_data", str3);
        contentValues.put("ecg_total_count", Integer.valueOf(i16));
        contentValues.put("ecg_real_value_array", str4);
        gn.l.c("saveEcg ,calendar =" + str + ",calendarTime =" + str2 + ",startTime =" + i10 + ",totalCount =" + i16 + ",ecgAverageRate =" + i11 + ",ecgHRV =" + i12 + ",ecgStrength =" + i13 + ",ecgRiskLevel =" + i14 + ",ecgFatigueIndex =" + i15 + ",ecgSamplingData =" + str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("saveEcg ,realEcgValueArray =");
        sb2.append(str4);
        gn.l.c(sb2.toString());
        try {
            cursor = this.f26198c.query("ecg_table", null, "time=?", new String[]{String.valueOf(str2)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            gn.l.c("saveEcg result =" + z10);
            if (z10) {
                this.f26198c.insert("ecg_table", "id", contentValues);
            } else {
                this.f26198c.update("ecg_table", contentValues, "time=?", new String[]{String.valueOf(str2)});
            }
            if (cursor == null) {
                cursor.close();
                return;
            }
            return;
        }
        z10 = false;
        gn.l.c("saveEcg result =" + z10);
        if (z10) {
        }
        if (cursor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[Catch: all -> 0x0025, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007d A[Catch: all -> 0x0025, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000a, B:7:0x001d, B:13:0x0029, B:15:0x005c, B:16:0x0072, B:18:0x007d), top: B:23:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void x(k kVar) {
        boolean z10;
        Cursor cursor;
        try {
            cursor = this.f26198c.query("oxygen_table", null, "StartDate=?", new String[]{String.valueOf(kVar.d())}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            ContentValues contentValues = new ContentValues();
            contentValues.put("calendar", kVar.b());
            contentValues.put("StartDate", kVar.d());
            contentValues.put("time", Integer.valueOf(kVar.e()));
            contentValues.put("oxygen_value", Integer.valueOf(kVar.c()));
            if (!z10) {
                this.f26198c.update("oxygen_table", contentValues, "StartDate=?", new String[]{String.valueOf(kVar.d())});
            } else {
                this.f26198c.insert("oxygen_table", "id", contentValues);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
        z10 = false;
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("calendar", kVar.b());
        contentValues2.put("StartDate", kVar.d());
        contentValues2.put("time", Integer.valueOf(kVar.e()));
        contentValues2.put("oxygen_value", Integer.valueOf(kVar.c()));
        if (!z10) {
        }
        if (cursor != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(String str, int i10, int i11, int i12, float f10, float f11, float f12) {
        boolean z10;
        Cursor cursor;
        String str2;
        StringBuilder sb2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("end_time", Integer.valueOf(i11));
        contentValues.put("use_time", Integer.valueOf(i12));
        contentValues.put("ver_speed", Float.valueOf(f10));
        contentValues.put("calories", Float.valueOf(f11));
        contentValues.put("distance", Float.valueOf(f12));
        try {
            cursor = this.f26198c.query("ride_table_name", null, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            if (z10) {
                this.f26198c.insert("ride_table_name", "id", contentValues);
                sb2 = new StringBuilder();
                str2 = "保存骑行数据  uteCalendar =";
            } else {
                this.f26198c.update("ride_table_name", contentValues, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
                sb2 = new StringBuilder();
                str2 = "更新骑行数据  rideCalendar =";
            }
            sb2.append(str2);
            sb2.append(str);
            sb2.append(",startTime =");
            sb2.append(i10);
            sb2.append(",endTime =");
            sb2.append(i11);
            sb2.append(",useTime =");
            sb2.append(i12);
            sb2.append(",verSpeed =");
            sb2.append(f10);
            sb2.append(",calories =");
            sb2.append(f11);
            sb2.append(",distance =");
            sb2.append(f12);
            gn.u.a("UTESQLOperate", sb2.toString());
            if (cursor == null) {
                cursor.close();
                return;
            }
            return;
        }
        z10 = false;
        if (z10) {
        }
        sb2.append(str2);
        sb2.append(str);
        sb2.append(",startTime =");
        sb2.append(i10);
        sb2.append(",endTime =");
        sb2.append(i11);
        sb2.append(",useTime =");
        sb2.append(i12);
        sb2.append(",verSpeed =");
        sb2.append(f10);
        sb2.append(",calories =");
        sb2.append(f11);
        sb2.append(",distance =");
        sb2.append(f12);
        gn.u.a("UTESQLOperate", sb2.toString());
        if (cursor == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void z(String str, int i10, int i11, int i12, int i13, float f10) {
        boolean z10;
        Cursor cursor;
        Cursor cursor2;
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar", str);
        contentValues.put("start_time", Integer.valueOf(i10));
        contentValues.put("end_time", Integer.valueOf(i11));
        contentValues.put("use_time", Integer.valueOf(i12));
        contentValues.put(ContactConstant.CallsRecordKeys.COUNT, Integer.valueOf(i13));
        contentValues.put("calories", Float.valueOf(f10));
        try {
            cursor = this.f26198c.query("skip_table_name", null, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)}, null, null, null);
        } catch (Exception unused) {
            cursor = null;
        }
        if (cursor.getCount() > 0) {
            z10 = true;
            cursor2 = cursor;
            if (z10) {
                this.f26198c.insert("skip_table_name", "id", contentValues);
                gn.u.a("UTESQLOperate", "保存跳绳数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",count =" + i13 + ",calories =" + f10);
            } else {
                this.f26198c.update("skip_table_name", contentValues, "calendar=? and start_time=?", new String[]{String.valueOf(str), String.valueOf(i10)});
                gn.u.a("UTESQLOperate", "更新跳绳数据  mCalendar =" + str + ",startTime =" + i10 + ",endTime =" + i11 + ",useTime =" + i12 + ",count =" + i13 + ",calories =" + f10);
            }
            if (cursor2 == null) {
                cursor2.close();
                return;
            }
            return;
        }
        z10 = false;
        cursor2 = cursor;
        if (z10) {
        }
        if (cursor2 == null) {
        }
    }
}
