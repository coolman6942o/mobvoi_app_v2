package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.a;
import b6.i;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d0 extends i5 {

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f9212f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f9213g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f9214h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f9215i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f9216j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f9217k = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: e  reason: collision with root package name */
    private final e5 f9219e = new e5(b());

    /* renamed from: d  reason: collision with root package name */
    private final g0 f9218d = new g0(this, getContext(), "google_app_measurement.db");

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(j5 j5Var) {
        super(j5Var);
    }

    private final long E(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = B().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j10 = rawQuery.getLong(0);
                    rawQuery.close();
                    return j10;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e10) {
                c().K().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final long F(String str, String[] strArr, long j10) {
        Cursor cursor = null;
        try {
            try {
                cursor = B().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j11 = cursor.getLong(0);
                    cursor.close();
                    return j11;
                }
                cursor.close();
                return j10;
            } catch (SQLiteException e10) {
                c().K().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    private final Object J(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            c().K().a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i10));
            }
            if (type == 3) {
                return cursor.getString(i10);
            }
            if (type != 4) {
                c().K().d("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            c().K().a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    private static void K(ContentValues contentValues, String str, Object obj) {
        i.g(str);
        i.k(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void N(z0 z0Var, SQLiteDatabase sQLiteDatabase) {
        if (z0Var != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                z0Var.N().a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                z0Var.N().a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                z0Var.N().a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                z0Var.N().a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void O(z0 z0Var, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        String[] split;
        if (z0Var != null) {
            if (!S(z0Var, sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set<String> d02 = d0(sQLiteDatabase, str);
                for (String str4 : str3.split(",")) {
                    if (!d02.remove(str4)) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                        sb2.append("Table ");
                        sb2.append(str);
                        sb2.append(" is missing required column: ");
                        sb2.append(str4);
                        throw new SQLiteException(sb2.toString());
                    }
                }
                if (strArr != null) {
                    for (int i10 = 0; i10 < strArr.length; i10 += 2) {
                        if (!d02.remove(strArr[i10])) {
                            sQLiteDatabase.execSQL(strArr[i10 + 1]);
                        }
                    }
                }
                if (!d02.isEmpty()) {
                    z0Var.N().c("Table has extra columns. table, columns", str, TextUtils.join(", ", d02));
                }
            } catch (SQLiteException e10) {
                z0Var.K().d("Failed to verify columns on table that was just created", str);
                throw e10;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    private static boolean S(z0 z0Var, SQLiteDatabase sQLiteDatabase, String str) {
        if (z0Var != null) {
            Cursor cursor = null;
            try {
                try {
                    cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{ContactConstant.CallsRecordKeys.NAME}, "name=?", new String[]{str}, null, null, null);
                    boolean moveToFirst = cursor.moveToFirst();
                    cursor.close();
                    return moveToFirst;
                } catch (SQLiteException e10) {
                    z0Var.N().c("Error querying for table", str, e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return false;
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    private final boolean V(String str, int i10, v5 v5Var) {
        w();
        e();
        i.g(str);
        i.k(v5Var);
        if (TextUtils.isEmpty(v5Var.f9751d)) {
            c().N().b("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", z0.I(str), Integer.valueOf(i10), String.valueOf(v5Var.f9750c));
            return false;
        }
        try {
            int f10 = v5Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            v5Var.b(p10);
            p10.B();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i10));
            contentValues.put("filter_id", v5Var.f9750c);
            contentValues.put("event_name", v5Var.f9751d);
            contentValues.put("data", bArr);
            try {
                if (B().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                c().K().d("Failed to insert event filter (got -1). appId", z0.I(str));
                return true;
            } catch (SQLiteException e10) {
                c().K().c("Error storing event filter. appId", z0.I(str), e10);
                return false;
            }
        } catch (IOException e11) {
            c().K().c("Configuration loss. Failed to serialize event filter. appId", z0.I(str), e11);
            return false;
        }
    }

    private final boolean W(String str, int i10, y5 y5Var) {
        w();
        e();
        i.g(str);
        i.k(y5Var);
        if (TextUtils.isEmpty(y5Var.f9822d)) {
            c().N().b("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", z0.I(str), Integer.valueOf(i10), String.valueOf(y5Var.f9821c));
            return false;
        }
        try {
            int f10 = y5Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            y5Var.b(p10);
            p10.B();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i10));
            contentValues.put("filter_id", y5Var.f9821c);
            contentValues.put("property_name", y5Var.f9822d);
            contentValues.put("data", bArr);
            try {
                if (B().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                    return true;
                }
                c().K().d("Failed to insert property filter (got -1). appId", z0.I(str));
                return false;
            } catch (SQLiteException e10) {
                c().K().c("Error storing property filter. appId", z0.I(str), e10);
                return false;
            }
        } catch (IOException e11) {
            c().K().c("Configuration loss. Failed to serialize property filter. appId", z0.I(str), e11);
            return false;
        }
    }

    private final boolean Y(String str, List<Integer> list) {
        i.g(str);
        w();
        e();
        SQLiteDatabase B = B();
        try {
            long E = E("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, s().E(str, p0.H)));
            if (E <= max) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Integer num = list.get(i10);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb2 = new StringBuilder(String.valueOf(join).length() + 2);
            sb2.append("(");
            sb2.append(join);
            sb2.append(")");
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 140);
            sb4.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb4.append(sb3);
            sb4.append(" order by rowid desc limit -1 offset ?)");
            return B.delete("audience_filter_values", sb4.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e10) {
            c().K().c("Database error querying filters. appId", z0.I(str), e10);
            return false;
        }
    }

    private static Set<String> d0(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22);
        sb2.append("SELECT * FROM ");
        sb2.append(str);
        sb2.append(" LIMIT 0");
        Cursor rawQuery = sQLiteDatabase.rawQuery(sb2.toString(), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean x0() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    public final void A() {
        w();
        B().endTransaction();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SQLiteDatabase B() {
        e();
        try {
            return this.f9218d.getWritableDatabase();
        } catch (SQLiteException e10) {
            c().N().d("Error opening database", e10);
            throw e10;
        }
    }

    public final void C() {
        w();
        B().setTransactionSuccessful();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzed C0(String str, String str2) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        i.g(str);
        i.g(str2);
        e();
        w();
        Cursor cursor2 = null;
        try {
            cursor = B().query("conditional_properties", new String[]{"origin", HealthDataProviderContracts.NAME_VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
        } catch (SQLiteException e11) {
            e10 = e11;
            cursor = null;
        } catch (Throwable th3) {
            th2 = th3;
            if (cursor2 != null) {
            }
            throw th2;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            String string = cursor.getString(0);
            try {
                try {
                    Object J = J(cursor, 1);
                    boolean z10 = cursor.getInt(2) != 0;
                    String string2 = cursor.getString(3);
                    long j10 = cursor.getLong(4);
                    r5 p10 = p();
                    byte[] blob = cursor.getBlob(5);
                    Parcelable.Creator<zzeu> creator = zzeu.CREATOR;
                    zzed zzedVar = new zzed(str, string, new zzjx(str2, cursor.getLong(8), J, string), cursor.getLong(6), z10, string2, (zzeu) p10.C(blob, creator), j10, (zzeu) p().C(cursor.getBlob(7), creator), cursor.getLong(9), (zzeu) p().C(cursor.getBlob(10), creator));
                    if (cursor.moveToNext()) {
                        c().K().c("Got multiple records for conditional property, expected one", z0.I(str), o().O(str2));
                    }
                    cursor.close();
                    return zzedVar;
                } catch (SQLiteException e12) {
                    e10 = e12;
                    c().K().b("Error querying conditional property", z0.I(str), o().O(str2), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th2 = th4;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
        } catch (Throwable th5) {
            th2 = th5;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    public final long D(h6 h6Var) throws IOException {
        long j10;
        e();
        w();
        i.k(h6Var);
        i.g(h6Var.f9340q);
        try {
            int f10 = h6Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            h6Var.b(p10);
            p10.B();
            r5 p11 = p();
            i.k(bArr);
            p11.e();
            MessageDigest z10 = r5.z("MD5");
            if (z10 == null) {
                p11.c().K().a("Failed to get MD5");
                j10 = 0;
            } else {
                j10 = r5.b0(z10.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", h6Var.f9340q);
            contentValues.put("metadata_fingerprint", Long.valueOf(j10));
            contentValues.put("metadata", bArr);
            try {
                B().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
                return j10;
            } catch (SQLiteException e10) {
                c().K().c("Error storing raw event metadata. appId", z0.I(h6Var.f9340q), e10);
                throw e10;
            }
        } catch (IOException e11) {
            c().K().c("Data loss. Failed to serialize event metadata. appId", z0.I(h6Var.f9340q), e11);
            throw e11;
        }
    }

    public final int F0(String str, String str2) {
        i.g(str);
        i.g(str2);
        e();
        w();
        try {
            return B().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            c().K().b("Error deleting conditional property", z0.I(str), o().O(str2), e10);
            return 0;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0086: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:27:0x0086 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<e6, Long> G(String str, Long l10) {
        Throwable th2;
        SQLiteException e10;
        Cursor cursor;
        e();
        w();
        Cursor cursor2 = null;
        try {
            try {
                cursor = B().rawQuery("select main_event, children_to_process from main_event_params where app_id=? and event_id=?", new String[]{str, String.valueOf(l10)});
                try {
                    if (!cursor.moveToFirst()) {
                        c().R().a("Main event not found");
                        cursor.close();
                        return null;
                    }
                    byte[] blob = cursor.getBlob(0);
                    Long valueOf = Long.valueOf(cursor.getLong(1));
                    g c10 = g.c(blob, 0, blob.length);
                    e6 e6Var = new e6();
                    try {
                        e6Var.c(c10);
                        Pair<e6, Long> create = Pair.create(e6Var, valueOf);
                        cursor.close();
                        return create;
                    } catch (IOException e11) {
                        c().K().b("Failed to merge main event. appId, eventId", z0.I(str), l10, e11);
                        cursor.close();
                        return null;
                    }
                } catch (SQLiteException e12) {
                    e10 = e12;
                    c().K().d("Error selecting main event", e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<v5>> G0(String str, String str2) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        w();
        e();
        i.g(str);
        i.g(str2);
        a aVar = new a();
        ?? r92 = 0;
        try {
            try {
                cursor = B().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        Map<Integer, List<v5>> emptyMap = Collections.emptyMap();
                        cursor.close();
                        return emptyMap;
                    }
                    do {
                        byte[] blob = cursor.getBlob(1);
                        g c10 = g.c(blob, 0, blob.length);
                        v5 v5Var = new v5();
                        try {
                            v5Var.c(c10);
                            int i10 = cursor.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i10));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i10), list);
                            }
                            list.add(v5Var);
                        } catch (IOException e11) {
                            c().K().c("Failed to merge filter. appId", z0.I(str), e11);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e12) {
                    e10 = e12;
                    c().K().c("Database error querying filters. appId", z0.I(str), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                r92 = str2;
                if (r92 != 0) {
                    r92.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (r92 != 0) {
            }
            throw th2;
        }
    }

    public final e0 H(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        i.g(str);
        e();
        w();
        String[] strArr = {str};
        e0 e0Var = new e0();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase B = B();
                Cursor query = B.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!query.moveToFirst()) {
                    c().N().d("Not updating daily counts, app is not known. appId", z0.I(str));
                    query.close();
                    return e0Var;
                }
                if (query.getLong(0) == j10) {
                    e0Var.f9241b = query.getLong(1);
                    e0Var.f9240a = query.getLong(2);
                    e0Var.f9242c = query.getLong(3);
                    e0Var.f9243d = query.getLong(4);
                    e0Var.f9244e = query.getLong(5);
                }
                if (z10) {
                    e0Var.f9241b++;
                }
                if (z11) {
                    e0Var.f9240a++;
                }
                if (z12) {
                    e0Var.f9242c++;
                }
                if (z13) {
                    e0Var.f9243d++;
                }
                if (z14) {
                    e0Var.f9244e++;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(e0Var.f9240a));
                contentValues.put("daily_events_count", Long.valueOf(e0Var.f9241b));
                contentValues.put("daily_conversions_count", Long.valueOf(e0Var.f9242c));
                contentValues.put("daily_error_events_count", Long.valueOf(e0Var.f9243d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(e0Var.f9244e));
                B.update("apps", contentValues, "app_id=?", strArr);
                query.close();
                return e0Var;
            } catch (SQLiteException e10) {
                c().K().c("Error updating daily counts. appId", z0.I(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return e0Var;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ae  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, List<y5>> H0(String str, String str2) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        w();
        e();
        i.g(str);
        i.g(str2);
        a aVar = new a();
        ?? r92 = 0;
        try {
            try {
                cursor = B().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        Map<Integer, List<y5>> emptyMap = Collections.emptyMap();
                        cursor.close();
                        return emptyMap;
                    }
                    do {
                        byte[] blob = cursor.getBlob(1);
                        g c10 = g.c(blob, 0, blob.length);
                        y5 y5Var = new y5();
                        try {
                            y5Var.c(c10);
                            int i10 = cursor.getInt(0);
                            List list = (List) aVar.get(Integer.valueOf(i10));
                            if (list == null) {
                                list = new ArrayList();
                                aVar.put(Integer.valueOf(i10), list);
                            }
                            list.add(y5Var);
                        } catch (IOException e11) {
                            c().K().c("Failed to merge filter", z0.I(str), e11);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e12) {
                    e10 = e12;
                    c().K().c("Database error querying filters. appId", z0.I(str), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                r92 = str2;
                if (r92 != 0) {
                    r92.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (r92 != 0) {
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long I0(String str, String str2) {
        SQLiteException e10;
        long F;
        i.g(str);
        i.g(str2);
        e();
        w();
        SQLiteDatabase B = B();
        B.beginTransaction();
        long j10 = 0;
        try {
            try {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 32);
                sb2.append("select ");
                sb2.append(str2);
                sb2.append(" from app2 where app_id=?");
                F = F(sb2.toString(), new String[]{str}, -1L);
                if (F == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (B.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        c().K().c("Failed to insert column (got -1). appId", z0.I(str), str2);
                        return -1L;
                    }
                    F = 0;
                }
            } finally {
                B.endTransaction();
            }
        } catch (SQLiteException e11) {
            e10 = e11;
        }
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("app_id", str);
            contentValues2.put(str2, Long.valueOf(1 + F));
            if (B.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                c().K().c("Failed to update column (got 0). appId", z0.I(str), str2);
                return -1L;
            }
            B.setTransactionSuccessful();
            return F;
        } catch (SQLiteException e12) {
            e10 = e12;
            j10 = F;
            c().K().b("Error inserting column. appId", z0.I(str), str2, e10);
            B.endTransaction();
            return j10;
        }
    }

    public final void L(v vVar) {
        i.k(vVar);
        e();
        w();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", vVar.h());
        contentValues.put("app_instance_id", vVar.a());
        contentValues.put("gmp_app_id", vVar.b());
        contentValues.put("resettable_device_id_hash", vVar.r());
        contentValues.put("last_bundle_index", Long.valueOf(vVar.z()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(vVar.t()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(vVar.u()));
        contentValues.put("app_version", vVar.g());
        contentValues.put("app_store", vVar.w());
        contentValues.put("gmp_version", Long.valueOf(vVar.x()));
        contentValues.put("dev_cert_hash", Long.valueOf(vVar.y()));
        contentValues.put("measurement_enabled", Boolean.valueOf(vVar.c()));
        contentValues.put("day", Long.valueOf(vVar.D()));
        contentValues.put("daily_public_events_count", Long.valueOf(vVar.E()));
        contentValues.put("daily_events_count", Long.valueOf(vVar.F()));
        contentValues.put("daily_conversions_count", Long.valueOf(vVar.G()));
        contentValues.put("config_fetched_time", Long.valueOf(vVar.A()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(vVar.B()));
        contentValues.put("app_version_int", Long.valueOf(vVar.v()));
        contentValues.put("firebase_instance_id", vVar.s());
        contentValues.put("daily_error_events_count", Long.valueOf(vVar.I()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(vVar.H()));
        contentValues.put("health_monitor_sample", vVar.J());
        contentValues.put("android_id", Long.valueOf(vVar.L()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(vVar.M()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(vVar.N()));
        try {
            SQLiteDatabase B = B();
            if (B.update("apps", contentValues, "app_id = ?", new String[]{vVar.h()}) == 0 && B.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                c().K().d("Failed to insert/update app (got -1). appId", z0.I(vVar.h()));
            }
        } catch (SQLiteException e10) {
            c().K().c("Error storing app. appId", z0.I(vVar.h()), e10);
        }
    }

    public final void M(l0 l0Var) {
        i.k(l0Var);
        e();
        w();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", l0Var.f9470a);
        contentValues.put(ContactConstant.CallsRecordKeys.NAME, l0Var.f9471b);
        contentValues.put("lifetime_count", Long.valueOf(l0Var.f9472c));
        contentValues.put("current_bundle_count", Long.valueOf(l0Var.f9473d));
        contentValues.put("last_fire_timestamp", Long.valueOf(l0Var.f9474e));
        contentValues.put("last_bundled_timestamp", Long.valueOf(l0Var.f9475f));
        contentValues.put("last_sampled_complex_event_id", l0Var.f9476g);
        contentValues.put("last_sampling_rate", l0Var.f9477h);
        Boolean bool = l0Var.f9478i;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (B().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                c().K().d("Failed to insert/update event aggregates (got -1). appId", z0.I(l0Var.f9470a));
            }
        } catch (SQLiteException e10) {
            c().K().c("Error storing event aggregates. appId", z0.I(l0Var.f9470a), e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0092, code lost:
        r9.c(r12, r13, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0111, code lost:
        r13 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(String str, u5[] u5VarArr) {
        boolean z10;
        boolean z11;
        b1 N;
        String str2;
        Object I;
        Integer num;
        w();
        e();
        i.g(str);
        i.k(u5VarArr);
        SQLiteDatabase B = B();
        B.beginTransaction();
        try {
            w();
            e();
            i.g(str);
            SQLiteDatabase B2 = B();
            boolean z12 = true;
            B2.delete("property_filters", "app_id=?", new String[]{str});
            B2.delete("event_filters", "app_id=?", new String[]{str});
            int length = u5VarArr.length;
            int i10 = 0;
            while (i10 < length) {
                u5 u5Var = u5VarArr[i10];
                w();
                e();
                i.g(str);
                i.k(u5Var);
                i.k(u5Var.f9711e);
                i.k(u5Var.f9710d);
                Integer num2 = u5Var.f9709c;
                if (num2 == null) {
                    c().N().d("Audience with no ID. appId", z0.I(str));
                    z10 = z12;
                } else {
                    int intValue = num2.intValue();
                    v5[] v5VarArr = u5Var.f9711e;
                    int length2 = v5VarArr.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            for (y5 y5Var : u5Var.f9710d) {
                                if (y5Var.f9821c == null) {
                                    N = c().N();
                                    str2 = "Property filter with no ID. Audience definition ignored. appId, audienceId";
                                    I = z0.I(str);
                                    num = u5Var.f9709c;
                                }
                            }
                            v5[] v5VarArr2 = u5Var.f9711e;
                            int length3 = v5VarArr2.length;
                            int i12 = 0;
                            while (true) {
                                if (i12 >= length3) {
                                    z11 = true;
                                    break;
                                } else if (!V(str, intValue, v5VarArr2[i12])) {
                                    z11 = false;
                                    break;
                                } else {
                                    i12++;
                                }
                            }
                            if (z11) {
                                y5[] y5VarArr = u5Var.f9710d;
                                int length4 = y5VarArr.length;
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= length4) {
                                        break;
                                    } else if (!W(str, intValue, y5VarArr[i13])) {
                                        z11 = false;
                                        break;
                                    } else {
                                        i13++;
                                    }
                                }
                            }
                            if (!z11) {
                                w();
                                e();
                                i.g(str);
                                SQLiteDatabase B3 = B();
                                B3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                                z10 = true;
                                B3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(intValue)});
                            }
                        } else if (v5VarArr[i11].f9750c == null) {
                            N = c().N();
                            str2 = "Event filter with no ID. Audience definition ignored. appId, audienceId";
                            I = z0.I(str);
                            num = u5Var.f9709c;
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                i10++;
                z12 = z10;
            }
            ArrayList arrayList = new ArrayList();
            for (u5 u5Var2 : u5VarArr) {
                arrayList.add(u5Var2.f9709c);
            }
            Y(str, arrayList);
            B.setTransactionSuccessful();
        } finally {
            B.endTransaction();
        }
    }

    public final boolean Q(zzed zzedVar) {
        i.k(zzedVar);
        e();
        w();
        if (o0(zzedVar.f9876a, zzedVar.f9878c.f9893b) == null && E("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzedVar.f9876a}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzedVar.f9876a);
        contentValues.put("origin", zzedVar.f9877b);
        contentValues.put(ContactConstant.CallsRecordKeys.NAME, zzedVar.f9878c.f9893b);
        K(contentValues, HealthDataProviderContracts.NAME_VALUE, zzedVar.f9878c.G0());
        contentValues.put("active", Boolean.valueOf(zzedVar.f9880e));
        contentValues.put("trigger_event_name", zzedVar.f9881f);
        contentValues.put("trigger_timeout", Long.valueOf(zzedVar.f9883h));
        p();
        contentValues.put("timed_out_event", r5.U(zzedVar.f9882g));
        contentValues.put("creation_timestamp", Long.valueOf(zzedVar.f9879d));
        p();
        contentValues.put("triggered_event", r5.U(zzedVar.f9884i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzedVar.f9878c.f9894c));
        contentValues.put("time_to_live", Long.valueOf(zzedVar.f9885j));
        p();
        contentValues.put("expired_event", r5.U(zzedVar.f9886k));
        try {
            if (B().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                c().K().d("Failed to insert/update conditional user property (got -1)", z0.I(zzedVar.f9876a));
            }
        } catch (SQLiteException e10) {
            c().K().c("Error storing conditional user property", z0.I(zzedVar.f9876a), e10);
        }
        return true;
    }

    public final boolean R(k0 k0Var, long j10, boolean z10) {
        b1 K;
        Object I;
        String str;
        ContentValues contentValues;
        e();
        w();
        i.k(k0Var);
        i.g(k0Var.f9423a);
        e6 e6Var = new e6();
        e6Var.f9260f = Long.valueOf(k0Var.f9427e);
        e6Var.f9257c = new f6[k0Var.f9428f.size()];
        Iterator<String> it = k0Var.f9428f.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            String next = it.next();
            f6 f6Var = new f6();
            i10++;
            e6Var.f9257c[i10] = f6Var;
            f6Var.f9274c = next;
            p().L(f6Var, k0Var.f9428f.G0(next));
        }
        try {
            int f10 = e6Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            e6Var.b(p10);
            p10.B();
            c().R().c("Saving event, name, data size", o().M(k0Var.f9424b), Integer.valueOf(f10));
            contentValues = new ContentValues();
            contentValues.put("app_id", k0Var.f9423a);
            contentValues.put(ContactConstant.CallsRecordKeys.NAME, k0Var.f9424b);
            contentValues.put("timestamp", Long.valueOf(k0Var.f9426d));
            contentValues.put("metadata_fingerprint", Long.valueOf(j10));
            contentValues.put("data", bArr);
            contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        } catch (IOException e10) {
            e = e10;
            K = c().K();
            I = z0.I(k0Var.f9423a);
            str = "Data loss. Failed to serialize event params/data. appId";
        }
        try {
            if (B().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            c().K().d("Failed to insert raw event (got -1). appId", z0.I(k0Var.f9423a));
            return false;
        } catch (SQLiteException e11) {
            e = e11;
            K = c().K();
            I = z0.I(k0Var.f9423a);
            str = "Error storing raw event. appId";
            K.c(str, I, e);
            return false;
        }
    }

    public final boolean T(q5 q5Var) {
        i.k(q5Var);
        e();
        w();
        if (o0(q5Var.f9613a, q5Var.f9615c) == null) {
            if (r5.d0(q5Var.f9615c)) {
                if (E("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{q5Var.f9613a}) >= 25) {
                    return false;
                }
            } else if (E("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{q5Var.f9613a, q5Var.f9614b}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", q5Var.f9613a);
        contentValues.put("origin", q5Var.f9614b);
        contentValues.put(ContactConstant.CallsRecordKeys.NAME, q5Var.f9615c);
        contentValues.put("set_timestamp", Long.valueOf(q5Var.f9616d));
        K(contentValues, HealthDataProviderContracts.NAME_VALUE, q5Var.f9617e);
        try {
            if (B().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                c().K().d("Failed to insert/update user property (got -1). appId", z0.I(q5Var.f9613a));
            }
        } catch (SQLiteException e10) {
            c().K().c("Error storing user property. appId", z0.I(q5Var.f9613a), e10);
        }
        return true;
    }

    public final boolean U(h6 h6Var, boolean z10) {
        b1 K;
        Object I;
        String str;
        ContentValues contentValues;
        e();
        w();
        i.k(h6Var);
        i.g(h6Var.f9340q);
        i.k(h6Var.f9331h);
        r0();
        long b10 = b().b();
        if (h6Var.f9331h.longValue() < b10 - a0.K() || h6Var.f9331h.longValue() > a0.K() + b10) {
            c().N().b("Storing bundle outside of the max uploading time span. appId, now, timestamp", z0.I(h6Var.f9340q), Long.valueOf(b10), h6Var.f9331h);
        }
        try {
            int f10 = h6Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            h6Var.b(p10);
            p10.B();
            byte[] V = p().V(bArr);
            c().R().d("Saving bundle, size", Integer.valueOf(V.length));
            contentValues = new ContentValues();
            contentValues.put("app_id", h6Var.f9340q);
            contentValues.put("bundle_end_timestamp", h6Var.f9331h);
            contentValues.put("data", V);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            Integer num = h6Var.M;
            if (num != null) {
                contentValues.put("retry_count", num);
            }
        } catch (IOException e10) {
            e = e10;
            K = c().K();
            I = z0.I(h6Var.f9340q);
            str = "Data loss. Failed to serialize bundle. appId";
        }
        try {
            if (B().insert("queue", null, contentValues) != -1) {
                return true;
            }
            c().K().d("Failed to insert bundle (got -1). appId", z0.I(h6Var.f9340q));
            return false;
        } catch (SQLiteException e11) {
            e = e11;
            K = c().K();
            I = z0.I(h6Var.f9340q);
            str = "Error storing bundle. appId";
            K.c(str, I, e);
            return false;
        }
    }

    public final boolean X(String str, Long l10, long j10, e6 e6Var) {
        e();
        w();
        i.k(e6Var);
        i.g(str);
        i.k(l10);
        try {
            int f10 = e6Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            e6Var.b(p10);
            p10.B();
            c().R().c("Saving complex main event, appId, data size", o().M(str), Integer.valueOf(f10));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l10);
            contentValues.put("children_to_process", Long.valueOf(j10));
            contentValues.put("main_event", bArr);
            try {
                if (B().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                    return true;
                }
                c().K().d("Failed to insert complex main event (got -1). appId", z0.I(str));
                return false;
            } catch (SQLiteException e10) {
                c().K().c("Error storing complex main event. appId", z0.I(str), e10);
                return false;
            }
        } catch (IOException e11) {
            c().K().b("Data loss. Failed to serialize event params/data. appId, eventId", z0.I(str), l10, e11);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String Z(long j10) {
        Throwable th2;
        SQLiteException e10;
        Cursor cursor;
        e();
        w();
        Cursor cursor2 = null;
        try {
            try {
                cursor = B().rawQuery("select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;", new String[]{String.valueOf(j10)});
                try {
                    if (!cursor.moveToFirst()) {
                        c().R().a("No expired configs for apps with pending events");
                        cursor.close();
                        return null;
                    }
                    String string = cursor.getString(0);
                    cursor.close();
                    return string;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    c().K().d("Error selecting expired configs", e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                cursor2 = j10;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00c3 A[EDGE_INSN: B:57:0x00c3->B:38:0x00c3 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<Pair<h6, Long>> a0(String str, int i10, int i11) {
        b1 K;
        String str2;
        Object I;
        byte[] a02;
        e();
        w();
        i.a(i10 > 0);
        i.a(i11 > 0);
        i.g(str);
        Cursor cursor = null;
        try {
            try {
                Cursor query = B().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, null, null, "rowid", String.valueOf(i10));
                if (!query.moveToFirst()) {
                    List<Pair<h6, Long>> emptyList = Collections.emptyList();
                    query.close();
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                int i12 = 0;
                do {
                    long j10 = query.getLong(0);
                    try {
                        a02 = p().a0(query.getBlob(1));
                    } catch (IOException e10) {
                        e = e10;
                        K = c().K();
                        str2 = "Failed to unzip queued bundle. appId";
                        I = z0.I(str);
                    }
                    if (!arrayList.isEmpty() && a02.length + i12 > i11) {
                        break;
                    }
                    g c10 = g.c(a02, 0, a02.length);
                    h6 h6Var = new h6();
                    try {
                        h6Var.c(c10);
                        if (!query.isNull(2)) {
                            h6Var.M = Integer.valueOf(query.getInt(2));
                        }
                        i12 += a02.length;
                        arrayList.add(Pair.create(h6Var, Long.valueOf(j10)));
                    } catch (IOException e11) {
                        e = e11;
                        K = c().K();
                        str2 = "Failed to merge queued bundle. appId";
                        I = z0.I(str);
                        K.c(str2, I, e);
                        if (!query.moveToNext()) {
                            if (i12 > i11) {
                            }
                        }
                        query.close();
                        return arrayList;
                    }
                    if (!query.moveToNext()) {
                        break;
                    }
                } while (i12 > i11);
                query.close();
                return arrayList;
            } catch (SQLiteException e12) {
                c().K().c("Error querying bundles. appId", z0.I(str), e12);
                List<Pair<h6, Long>> emptyList2 = Collections.emptyList();
                if (0 != 0) {
                    cursor.close();
                }
                return emptyList2;
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x008e, code lost:
        c().K().d("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<q5> b0(String str, String str2, String str3) {
        Throwable th2;
        Cursor cursor;
        String str4;
        SQLiteException e10;
        i.g(str);
        e();
        w();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                try {
                    arrayList2.add(str);
                    StringBuilder sb2 = new StringBuilder("app_id=?");
                    if (!TextUtils.isEmpty(str2)) {
                        str4 = str2;
                        try {
                            arrayList2.add(str4);
                            sb2.append(" and origin=?");
                        } catch (SQLiteException e11) {
                            e10 = e11;
                            cursor = null;
                            c().K().b("(2)Error querying user properties", z0.I(str), str4, e10);
                            if (cursor != null) {
                            }
                            return null;
                        }
                    } else {
                        str4 = str2;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        arrayList2.add(String.valueOf(str3).concat(MessageProxyConstants.NODE_ID_ANY));
                        sb2.append(" and name glob ?");
                    }
                    cursor = B().query("user_attributes", new String[]{ContactConstant.CallsRecordKeys.NAME, "set_timestamp", HealthDataProviderContracts.NAME_VALUE, "origin"}, sb2.toString(), (String[]) arrayList2.toArray(new String[arrayList2.size()]), null, null, "rowid", "1001");
                } catch (SQLiteException e12) {
                    e10 = e12;
                    str4 = str2;
                    cursor = null;
                    c().K().b("(2)Error querying user properties", z0.I(str), str4, e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e13) {
                e10 = e13;
            }
        } catch (Throwable th3) {
            th2 = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return arrayList;
            }
            while (true) {
                if (arrayList.size() >= 1000) {
                    break;
                }
                String string = cursor.getString(0);
                long j10 = cursor.getLong(1);
                try {
                    try {
                        Object J = J(cursor, 2);
                        String string2 = cursor.getString(3);
                        if (J == null) {
                            try {
                                c().K().b("(2)Read invalid user property value, ignoring it", z0.I(str), string2, str3);
                            } catch (SQLiteException e14) {
                                e10 = e14;
                                str4 = string2;
                                c().K().b("(2)Error querying user properties", z0.I(str), str4, e10);
                                if (cursor != null) {
                                }
                                return null;
                            }
                        } else {
                            arrayList.add(new q5(str, string2, string, j10, J));
                        }
                        if (!cursor.moveToNext()) {
                            break;
                        }
                        str4 = string2;
                    } catch (SQLiteException e15) {
                        e10 = e15;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                    }
                    throw th2;
                }
            }
            cursor.close();
            return arrayList;
        } catch (SQLiteException e16) {
            e10 = e16;
        } catch (Throwable th5) {
            th2 = th5;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
        c().K().d("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<zzed> c0(String str, String[] strArr) {
        e();
        w();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = B().query("conditional_properties", new String[]{"app_id", "origin", ContactConstant.CallsRecordKeys.NAME, HealthDataProviderContracts.NAME_VALUE, "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return arrayList;
                }
                while (true) {
                    if (arrayList.size() < 1000) {
                        boolean z10 = false;
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        String string3 = cursor.getString(2);
                        Object J = J(cursor, 3);
                        if (cursor.getInt(4) != 0) {
                            z10 = true;
                        }
                        String string4 = cursor.getString(5);
                        long j10 = cursor.getLong(6);
                        r5 p10 = p();
                        byte[] blob = cursor.getBlob(7);
                        Parcelable.Creator<zzeu> creator = zzeu.CREATOR;
                        arrayList.add(new zzed(string, string2, new zzjx(string3, cursor.getLong(10), J, string2), cursor.getLong(8), z10, string4, (zzeu) p10.C(blob, creator), j10, (zzeu) p().C(cursor.getBlob(9), creator), cursor.getLong(11), (zzeu) p().C(cursor.getBlob(12), creator)));
                        if (!cursor.moveToNext()) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                cursor.close();
                return arrayList;
            } catch (SQLiteException e10) {
                c().K().d("Error querying conditional user property value", e10);
                List<zzed> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x009a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x009a */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<q5> e0(String str) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        i.g(str);
        e();
        w();
        ArrayList arrayList = new ArrayList();
        Cursor cursor2 = null;
        try {
            try {
                cursor = B().query("user_attributes", new String[]{ContactConstant.CallsRecordKeys.NAME, "origin", "set_timestamp", HealthDataProviderContracts.NAME_VALUE}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return arrayList;
                    }
                    do {
                        String string = cursor.getString(0);
                        String string2 = cursor.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str2 = string2;
                        long j10 = cursor.getLong(2);
                        Object J = J(cursor, 3);
                        if (J == null) {
                            c().K().d("Read invalid user property value, ignoring it. appId", z0.I(str));
                        } else {
                            arrayList.add(new q5(str, str2, string, j10, J));
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return arrayList;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    c().K().c("Error querying user properties. appId", z0.I(str), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0115 A[Catch: SQLiteException -> 0x0199, all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:10:0x0065, B:12:0x00c6, B:17:0x00d0, B:20:0x0115, B:21:0x011a, B:24:0x014c, B:25:0x0150, B:27:0x015b, B:32:0x0165, B:34:0x0170, B:38:0x0178, B:40:0x0184, B:52:0x01ab), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x014c A[Catch: SQLiteException -> 0x0199, all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:10:0x0065, B:12:0x00c6, B:17:0x00d0, B:20:0x0115, B:21:0x011a, B:24:0x014c, B:25:0x0150, B:27:0x015b, B:32:0x0165, B:34:0x0170, B:38:0x0178, B:40:0x0184, B:52:0x01ab), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0170 A[Catch: SQLiteException -> 0x0199, all -> 0x01c2, TryCatch #1 {all -> 0x01c2, blocks: (B:10:0x0065, B:12:0x00c6, B:17:0x00d0, B:20:0x0115, B:21:0x011a, B:24:0x014c, B:25:0x0150, B:27:0x015b, B:32:0x0165, B:34:0x0170, B:38:0x0178, B:40:0x0184, B:52:0x01ab), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0184 A[Catch: SQLiteException -> 0x0199, all -> 0x01c2, TRY_LEAVE, TryCatch #1 {all -> 0x01c2, blocks: (B:10:0x0065, B:12:0x00c6, B:17:0x00d0, B:20:0x0115, B:21:0x011a, B:24:0x014c, B:25:0x0150, B:27:0x015b, B:32:0x0165, B:34:0x0170, B:38:0x0178, B:40:0x0184, B:52:0x01ab), top: B:61:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v f0(String str) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        boolean z10;
        boolean z11;
        boolean z12;
        i.g(str);
        e();
        w();
        Cursor cursor2 = null;
        try {
            try {
                z10 = true;
                cursor = B().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "ssaid_reporting_enabled"}, "app_id=?", new String[]{str}, null, null, null);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (SQLiteException e11) {
            e10 = e11;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th2;
        }
        try {
            if (!cursor.moveToFirst()) {
                cursor.close();
                return null;
            }
            try {
                v vVar = new v(this.f9325b.e0(), str);
                vVar.i(cursor.getString(0));
                vVar.j(cursor.getString(1));
                vVar.k(cursor.getString(2));
                vVar.T(cursor.getLong(3));
                vVar.O(cursor.getLong(4));
                vVar.P(cursor.getLong(5));
                vVar.d(cursor.getString(6));
                vVar.m(cursor.getString(7));
                vVar.R(cursor.getLong(8));
                vVar.S(cursor.getLong(9));
                if (!cursor.isNull(10) && cursor.getInt(10) == 0) {
                    z11 = false;
                    vVar.e(z11);
                    vVar.W(cursor.getLong(11));
                    vVar.X(cursor.getLong(12));
                    vVar.Y(cursor.getLong(13));
                    vVar.Z(cursor.getLong(14));
                    vVar.U(cursor.getLong(15));
                    vVar.V(cursor.getLong(16));
                    vVar.Q(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                    vVar.l(cursor.getString(18));
                    vVar.b0(cursor.getLong(19));
                    vVar.a0(cursor.getLong(20));
                    vVar.n(cursor.getString(21));
                    vVar.f(!cursor.isNull(22) ? 0L : cursor.getLong(22));
                    if (!cursor.isNull(23) && cursor.getInt(23) == 0) {
                        z12 = false;
                        vVar.o(z12);
                        if (!cursor.isNull(24) && cursor.getInt(24) == 0) {
                            z10 = false;
                        }
                        vVar.p(z10);
                        vVar.q();
                        if (cursor.moveToNext()) {
                            c().K().d("Got multiple records for app, expected one. appId", z0.I(str));
                        }
                        cursor.close();
                        return vVar;
                    }
                    z12 = true;
                    vVar.o(z12);
                    if (!cursor.isNull(24)) {
                        z10 = false;
                    }
                    vVar.p(z10);
                    vVar.q();
                    if (cursor.moveToNext()) {
                    }
                    cursor.close();
                    return vVar;
                }
                z11 = true;
                vVar.e(z11);
                vVar.W(cursor.getLong(11));
                vVar.X(cursor.getLong(12));
                vVar.Y(cursor.getLong(13));
                vVar.Z(cursor.getLong(14));
                vVar.U(cursor.getLong(15));
                vVar.V(cursor.getLong(16));
                vVar.Q(!cursor.isNull(17) ? -2147483648L : cursor.getInt(17));
                vVar.l(cursor.getString(18));
                vVar.b0(cursor.getLong(19));
                vVar.a0(cursor.getLong(20));
                vVar.n(cursor.getString(21));
                vVar.f(!cursor.isNull(22) ? 0L : cursor.getLong(22));
                if (!cursor.isNull(23)) {
                    z12 = false;
                    vVar.o(z12);
                    if (!cursor.isNull(24)) {
                    }
                    vVar.p(z10);
                    vVar.q();
                    if (cursor.moveToNext()) {
                    }
                    cursor.close();
                    return vVar;
                }
                z12 = true;
                vVar.o(z12);
                if (!cursor.isNull(24)) {
                }
                vVar.p(z10);
                vVar.q();
                if (cursor.moveToNext()) {
                }
                cursor.close();
                return vVar;
            } catch (SQLiteException e12) {
                e10 = e12;
                c().K().c("Error querying app. appId", z0.I(str), e10);
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
        } catch (Throwable th5) {
            th2 = th5;
            cursor2 = cursor;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    public final long g0(String str) {
        i.g(str);
        e();
        w();
        try {
            return B().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, s().E(str, p0.f9576r))))});
        } catch (SQLiteException e10) {
            c().K().c("Error deleting over the limit events. appId", z0.I(str), e10);
            return 0L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x006c: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:22:0x006c */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] h0(String str) {
        Throwable th2;
        SQLiteException e10;
        Cursor cursor;
        i.g(str);
        e();
        w();
        Cursor cursor2 = null;
        try {
            try {
                cursor = B().query("apps", new String[]{"remote_config"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    byte[] blob = cursor.getBlob(0);
                    if (cursor.moveToNext()) {
                        c().K().d("Got multiple records for app config, expected one. appId", z0.I(str));
                    }
                    cursor.close();
                    return blob;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    c().K().c("Error querying remote config. appId", z0.I(str), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<Integer, i6> i0(String str) {
        Throwable th2;
        SQLiteException e10;
        Cursor cursor;
        w();
        e();
        i.g(str);
        SQLiteDatabase B = B();
        ?? r82 = 0;
        try {
            try {
                cursor = B.query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    a aVar = new a();
                    do {
                        int i10 = cursor.getInt(0);
                        byte[] blob = cursor.getBlob(1);
                        g c10 = g.c(blob, 0, blob.length);
                        i6 i6Var = new i6();
                        try {
                            i6Var.c(c10);
                            aVar.put(Integer.valueOf(i10), i6Var);
                        } catch (IOException e11) {
                            c().K().b("Failed to merge filter results. appId, audienceId, error", z0.I(str), Integer.valueOf(i10), e11);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return aVar;
                } catch (SQLiteException e12) {
                    e10 = e12;
                    c().K().c("Database error querying filter results. appId", z0.I(str), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                r82 = B;
                if (r82 != 0) {
                    r82.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (r82 != 0) {
            }
            throw th2;
        }
    }

    public final long j0(String str) {
        i.g(str);
        return F("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final List<zzed> k0(String str, String str2, String str3) {
        i.g(str);
        e();
        w();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(MessageProxyConstants.NODE_ID_ANY));
            sb2.append(" and name glob ?");
        }
        return c0(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l0(List<Long> list) {
        e();
        w();
        i.k(list);
        i.m(list.size());
        if (x0()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb2 = new StringBuilder(String.valueOf(join).length() + 2);
            sb2.append("(");
            sb2.append(join);
            sb2.append(")");
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder(String.valueOf(sb3).length() + 80);
            sb4.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb4.append(sb3);
            sb4.append(" AND retry_count =  2147483647 LIMIT 1");
            if (E(sb4.toString(), null) > 0) {
                c().N().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase B = B();
                StringBuilder sb5 = new StringBuilder(String.valueOf(sb3).length() + 127);
                sb5.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb5.append(sb3);
                sb5.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                B.execSQL(sb5.toString());
            } catch (SQLiteException e10) {
                c().K().d("Error incrementing retry count. error", e10);
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0105: MOVE  (r16 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:52:0x0105 */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l0 m0(String str, String str2) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        Cursor cursor2;
        Boolean valueOf;
        i.g(str);
        i.g(str2);
        e();
        w();
        Cursor cursor3 = null;
        try {
            try {
                boolean z10 = false;
                cursor = B().query("events", new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        return null;
                    }
                    long j10 = cursor.getLong(0);
                    long j11 = cursor.getLong(1);
                    long j12 = cursor.getLong(2);
                    long j13 = cursor.isNull(3) ? 0L : cursor.getLong(3);
                    Long valueOf2 = cursor.isNull(4) ? null : Long.valueOf(cursor.getLong(4));
                    Long valueOf3 = cursor.isNull(5) ? null : Long.valueOf(cursor.getLong(5));
                    if (!cursor.isNull(6)) {
                        try {
                            if (cursor.getLong(6) == 1) {
                                z10 = true;
                            }
                            valueOf = Boolean.valueOf(z10);
                        } catch (SQLiteException e11) {
                            e10 = e11;
                            c().K().b("Error querying events. appId", z0.I(str), o().M(str2), e10);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return null;
                        }
                    } else {
                        valueOf = null;
                    }
                    cursor2 = cursor;
                    try {
                        l0 l0Var = new l0(str, str2, j10, j11, j12, j13, valueOf2, valueOf3, valueOf);
                        if (cursor2.moveToNext()) {
                            c().K().d("Got multiple records for event aggregates, expected one. appId", z0.I(str));
                        }
                        cursor2.close();
                        return l0Var;
                    } catch (SQLiteException e12) {
                        e10 = e12;
                        cursor = cursor2;
                        c().K().b("Error querying events. appId", z0.I(str), o().M(str2), e10);
                        if (cursor != null) {
                        }
                        return null;
                    } catch (Throwable th3) {
                        th2 = th3;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th2;
                    }
                } catch (SQLiteException e13) {
                    e10 = e13;
                } catch (Throwable th4) {
                    th2 = th4;
                    cursor2 = cursor;
                }
            } catch (Throwable th5) {
                th2 = th5;
            }
        } catch (SQLiteException e14) {
            e10 = e14;
            cursor = null;
        } catch (Throwable th6) {
            th2 = th6;
        }
    }

    public final void n0(String str, String str2) {
        i.g(str);
        i.g(str2);
        e();
        w();
        try {
            c().R().d("Deleted user attribute rows", Integer.valueOf(B().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e10) {
            c().K().b("Error deleting user attribute. appId", z0.I(str), o().O(str2), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final q5 o0(String str, String str2) {
        Throwable th2;
        Cursor cursor;
        SQLiteException e10;
        i.g(str);
        i.g(str2);
        e();
        w();
        Cursor cursor2 = null;
        try {
            try {
                cursor = B().query("user_attributes", new String[]{"set_timestamp", HealthDataProviderContracts.NAME_VALUE, "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return null;
                }
                try {
                    q5 q5Var = new q5(str, cursor.getString(2), str2, cursor.getLong(0), J(cursor, 1));
                    if (cursor.moveToNext()) {
                        c().K().d("Got multiple records for user property, expected one. appId", z0.I(str));
                    }
                    cursor.close();
                    return q5Var;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    c().K().b("Error querying user property. appId", z0.I(str), o().O(str2), e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (SQLiteException e12) {
                e10 = e12;
            } catch (Throwable th4) {
                th2 = th4;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th2;
            }
        } catch (SQLiteException e13) {
            e10 = e13;
            cursor = null;
        } catch (Throwable th5) {
            th2 = th5;
            if (cursor2 != null) {
            }
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String p0() {
        Throwable th2;
        SQLiteException e10;
        Cursor cursor;
        ?? B = B();
        try {
            try {
                cursor = B.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(0);
                        cursor.close();
                        return string;
                    }
                    cursor.close();
                    return null;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    c().K().d("Database error getting next bundle app id", e10);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (B != 0) {
                    B.close();
                }
                throw th2;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th2 = th4;
            B = 0;
            if (B != 0) {
            }
            throw th2;
        }
    }

    public final boolean q0() {
        return E("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r0() {
        int delete;
        e();
        w();
        if (x0()) {
            long a10 = r().f9435h.a();
            long c10 = b().c();
            if (Math.abs(c10 - a10) > p0.A.a().longValue()) {
                r().f9435h.b(c10);
                e();
                w();
                if (x0() && (delete = B().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(b().b()), String.valueOf(a0.K())})) > 0) {
                    c().R().d("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final long s0() {
        return F("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long t0() {
        return F("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean u0() {
        return E("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean v0() {
        return E("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final long w0() {
        Cursor cursor = null;
        try {
            try {
                cursor = B().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursor.moveToFirst()) {
                    cursor.close();
                    return -1L;
                }
                long j10 = cursor.getLong(0);
                cursor.close();
                return j10;
            } catch (SQLiteException e10) {
                c().K().d("Error querying raw events", e10);
                if (cursor != null) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.measurement.i5
    protected final boolean x() {
        return false;
    }

    public final void z() {
        w();
        B().beginTransaction();
    }
}
