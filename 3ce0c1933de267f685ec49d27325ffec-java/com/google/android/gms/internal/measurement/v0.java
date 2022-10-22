package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class v0 extends z2 {

    /* renamed from: c  reason: collision with root package name */
    private final w0 f9738c = new w0(this, getContext(), "google_app_measurement_local.db");

    /* renamed from: d  reason: collision with root package name */
    private boolean f9739d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(d2 d2Var) {
        super(d2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0127 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean B(int i10, byte[] bArr) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        SQLiteFullException e10;
        Cursor cursor;
        SQLiteException e11;
        e();
        boolean z10 = false;
        if (this.f9739d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i10));
        contentValues.put("entry", bArr);
        int i11 = 0;
        int i12 = 5;
        for (int i13 = 5; i11 < i13; i13 = 5) {
            Cursor cursor2 = null;
            r8 = null;
            cursor2 = null;
            r8 = null;
            cursor2 = null;
            r8 = null;
            SQLiteDatabase sQLiteDatabase2 = null;
            Cursor cursor3 = null;
            try {
                sQLiteDatabase = z();
                try {
                    if (sQLiteDatabase == null) {
                        try {
                            this.f9739d = true;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                            }
                            return z10;
                        } catch (SQLiteFullException e12) {
                            e10 = e12;
                            c().K().d("Error writing entry to local database", e10);
                            this.f9739d = true;
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                            if (sQLiteDatabase == null) {
                                i11++;
                                z10 = false;
                            }
                            sQLiteDatabase.close();
                            i11++;
                            z10 = false;
                        } catch (SQLiteException e13) {
                            e11 = e13;
                            cursor = null;
                            sQLiteDatabase2 = sQLiteDatabase;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    cursor3 = cursor;
                                    if (cursor3 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th2;
                                }
                            }
                            c().K().d("Error writing entry to local database", e11);
                            this.f9739d = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 == null) {
                                sQLiteDatabase2.close();
                            }
                            i11++;
                            z10 = false;
                        }
                    } else {
                        try {
                            sQLiteDatabase.beginTransaction();
                            long j10 = 0;
                            cursor = sQLiteDatabase.rawQuery("select count(1) from messages", null);
                            if (cursor != null) {
                                try {
                                    if (cursor.moveToFirst()) {
                                        int i14 = z10 ? 1 : 0;
                                        int i15 = z10 ? 1 : 0;
                                        j10 = cursor.getLong(i14);
                                    }
                                } catch (SQLiteDatabaseLockedException unused) {
                                    cursor3 = cursor;
                                    try {
                                        SystemClock.sleep(i12);
                                        i12 += 20;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        if (sQLiteDatabase == null) {
                                            i11++;
                                            z10 = false;
                                        }
                                        sQLiteDatabase.close();
                                        i11++;
                                        z10 = false;
                                    } catch (Throwable th4) {
                                        th2 = th4;
                                        if (cursor3 != null) {
                                            cursor3.close();
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        throw th2;
                                    }
                                } catch (SQLiteFullException e14) {
                                    e10 = e14;
                                    cursor2 = cursor;
                                    c().K().d("Error writing entry to local database", e10);
                                    this.f9739d = true;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase == null) {
                                    }
                                    sQLiteDatabase.close();
                                    i11++;
                                    z10 = false;
                                } catch (SQLiteException e15) {
                                    e11 = e15;
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    if (sQLiteDatabase2 != null) {
                                    }
                                    c().K().d("Error writing entry to local database", e11);
                                    this.f9739d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase2 == null) {
                                    }
                                    i11++;
                                    z10 = false;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    cursor3 = cursor;
                                    if (cursor3 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th2;
                                }
                            }
                            if (j10 >= 100000) {
                                c().K().a("Data loss, local db full");
                                long j11 = (100000 - j10) + 1;
                                String[] strArr = new String[1];
                                String l10 = Long.toString(j11);
                                char c10 = z10 ? 1 : 0;
                                char c11 = z10 ? 1 : 0;
                                strArr[c10] = l10;
                                long delete = sQLiteDatabase.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", strArr);
                                if (delete != j11) {
                                    c().K().b("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j11), Long.valueOf(delete), Long.valueOf(j11 - delete));
                                }
                            }
                            sQLiteDatabase.insertOrThrow("messages", null, contentValues);
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            if (cursor != null) {
                                cursor.close();
                            }
                            sQLiteDatabase.close();
                            return true;
                        } catch (SQLiteFullException e16) {
                            e10 = e16;
                        } catch (SQLiteException e17) {
                            e11 = e17;
                            cursor = null;
                        } catch (Throwable th6) {
                            th2 = th6;
                            if (cursor3 != null) {
                            }
                            if (sQLiteDatabase != null) {
                            }
                            throw th2;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused2) {
                    cursor3 = null;
                }
            } catch (SQLiteDatabaseLockedException unused3) {
                sQLiteDatabase = null;
            } catch (SQLiteFullException e18) {
                e10 = e18;
                sQLiteDatabase = null;
            } catch (SQLiteException e19) {
                e11 = e19;
                cursor = null;
            } catch (Throwable th7) {
                th2 = th7;
                sQLiteDatabase = null;
            }
        }
        c().N().a("Failed to write entry to local database");
        return false;
    }

    private final SQLiteDatabase z() throws SQLiteException {
        if (this.f9739d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f9738c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f9739d = true;
        return null;
    }

    public final void A() {
        e();
        try {
            int delete = z().delete("messages", null, null) + 0;
            if (delete > 0) {
                c().R().d("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e10) {
            c().K().d("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean C(zzeu zzeuVar) {
        Parcel obtain = Parcel.obtain();
        zzeuVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return B(0, marshall);
        }
        c().N().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean D(zzjx zzjxVar) {
        Parcel obtain = Parcel.obtain();
        zzjxVar.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return B(1, marshall);
        }
        c().N().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean E(zzed zzedVar) {
        p();
        byte[] U = r5.U(zzedVar);
        if (U.length <= 131072) {
            return B(2, U);
        }
        c().N().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<AbstractSafeParcelable> F(int i10) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        SQLiteDatabase sQLiteDatabase2;
        Cursor cursor;
        SQLiteFullException e10;
        SQLiteException e11;
        SafeParcelable safeParcelable;
        e();
        Cursor cursor2 = null;
        if (this.f9739d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!getContext().getDatabasePath("google_app_measurement_local.db").exists()) {
            return arrayList;
        }
        int i11 = 5;
        int i12 = 0;
        for (int i13 = 5; i12 < i13; i13 = 5) {
            try {
                sQLiteDatabase2 = z();
                try {
                    if (sQLiteDatabase2 == null) {
                        try {
                            this.f9739d = true;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                            }
                            return null;
                        } catch (SQLiteFullException e12) {
                            e10 = e12;
                            cursor = null;
                            c().K().d("Error reading entries from local database", e10);
                            this.f9739d = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 == null) {
                            }
                            sQLiteDatabase2.close();
                            i12++;
                        } catch (SQLiteException e13) {
                            e11 = e13;
                            cursor = null;
                            if (sQLiteDatabase2 != null) {
                            }
                            c().K().d("Error reading entries from local database", e11);
                            this.f9739d = true;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 == null) {
                            }
                            sQLiteDatabase2.close();
                            i12++;
                        }
                    } else {
                        try {
                            sQLiteDatabase2.beginTransaction();
                            sQLiteDatabase = sQLiteDatabase2;
                        } catch (SQLiteFullException e14) {
                            e10 = e14;
                            cursor = null;
                            c().K().d("Error reading entries from local database", e10);
                            this.f9739d = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 == null) {
                                i12++;
                            }
                            sQLiteDatabase2.close();
                            i12++;
                        } catch (SQLiteException e15) {
                            e11 = e15;
                            cursor = null;
                            if (sQLiteDatabase2 != null) {
                                try {
                                    if (sQLiteDatabase2.inTransaction()) {
                                        sQLiteDatabase2.endTransaction();
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    cursor2 = cursor;
                                    sQLiteDatabase = sQLiteDatabase2;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    throw th2;
                                }
                            }
                            c().K().d("Error reading entries from local database", e11);
                            this.f9739d = true;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (sQLiteDatabase2 == null) {
                                i12++;
                            }
                            sQLiteDatabase2.close();
                            i12++;
                        }
                        try {
                            cursor = sQLiteDatabase2.query("messages", new String[]{"rowid", "type", "entry"}, null, null, null, null, "rowid asc", Integer.toString(100));
                            long j10 = -1;
                            while (cursor.moveToNext()) {
                                try {
                                    j10 = cursor.getLong(0);
                                    int i14 = cursor.getInt(1);
                                    byte[] blob = cursor.getBlob(2);
                                    if (i14 == 0) {
                                        Parcel obtain = Parcel.obtain();
                                        try {
                                            try {
                                                obtain.unmarshall(blob, 0, blob.length);
                                                obtain.setDataPosition(0);
                                                safeParcelable = (zzeu) zzeu.CREATOR.createFromParcel(obtain);
                                                obtain.recycle();
                                            } catch (SafeParcelReader.ParseException unused) {
                                                c().K().a("Failed to load event from local database");
                                                obtain.recycle();
                                            }
                                            if (safeParcelable != null) {
                                            }
                                        } catch (Throwable th4) {
                                            obtain.recycle();
                                            throw th4;
                                        }
                                    } else if (i14 == 1) {
                                        Parcel obtain2 = Parcel.obtain();
                                        try {
                                            try {
                                                obtain2.unmarshall(blob, 0, blob.length);
                                                obtain2.setDataPosition(0);
                                                safeParcelable = (zzjx) zzjx.CREATOR.createFromParcel(obtain2);
                                                obtain2.recycle();
                                            } catch (SafeParcelReader.ParseException unused2) {
                                                c().K().a("Failed to load user property from local database");
                                                obtain2.recycle();
                                                safeParcelable = null;
                                            }
                                            if (safeParcelable != null) {
                                            }
                                        } catch (Throwable th5) {
                                            obtain2.recycle();
                                            throw th5;
                                        }
                                    } else if (i14 == 2) {
                                        Parcel obtain3 = Parcel.obtain();
                                        try {
                                            try {
                                                obtain3.unmarshall(blob, 0, blob.length);
                                                obtain3.setDataPosition(0);
                                                safeParcelable = (zzed) zzed.CREATOR.createFromParcel(obtain3);
                                                obtain3.recycle();
                                            } catch (Throwable th6) {
                                                obtain3.recycle();
                                                throw th6;
                                            }
                                        } catch (SafeParcelReader.ParseException unused3) {
                                            c().K().a("Failed to load user property from local database");
                                            obtain3.recycle();
                                            safeParcelable = null;
                                        }
                                        if (safeParcelable != null) {
                                        }
                                    } else {
                                        c().K().a("Unknown record type in local database");
                                    }
                                    arrayList.add(safeParcelable);
                                } catch (SQLiteDatabaseLockedException unused4) {
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    SystemClock.sleep(i11);
                                    i11 += 20;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase2 == null) {
                                        i12++;
                                    }
                                    sQLiteDatabase2.close();
                                    i12++;
                                } catch (SQLiteFullException e16) {
                                    e10 = e16;
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    c().K().d("Error reading entries from local database", e10);
                                    this.f9739d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase2 == null) {
                                    }
                                    sQLiteDatabase2.close();
                                    i12++;
                                } catch (SQLiteException e17) {
                                    e11 = e17;
                                    sQLiteDatabase2 = sQLiteDatabase;
                                    if (sQLiteDatabase2 != null) {
                                    }
                                    c().K().d("Error reading entries from local database", e11);
                                    this.f9739d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase2 == null) {
                                    }
                                    sQLiteDatabase2.close();
                                    i12++;
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    throw th2;
                                }
                            }
                            if (sQLiteDatabase.delete("messages", "rowid <= ?", new String[]{Long.toString(j10)}) < arrayList.size()) {
                                c().K().a("Fewer entries removed from local database than expected");
                            }
                            sQLiteDatabase.setTransactionSuccessful();
                            sQLiteDatabase.endTransaction();
                            cursor.close();
                            sQLiteDatabase.close();
                            return arrayList;
                        } catch (SQLiteDatabaseLockedException unused5) {
                            cursor = null;
                            sQLiteDatabase2 = sQLiteDatabase;
                            SystemClock.sleep(i11);
                            i11 += 20;
                            if (cursor != null) {
                            }
                            if (sQLiteDatabase2 == null) {
                            }
                            sQLiteDatabase2.close();
                            i12++;
                        } catch (SQLiteFullException e18) {
                            e10 = e18;
                            cursor = null;
                        } catch (SQLiteException e19) {
                            e11 = e19;
                            cursor = null;
                        } catch (Throwable th8) {
                            th2 = th8;
                        }
                    }
                } catch (SQLiteDatabaseLockedException unused6) {
                    sQLiteDatabase = sQLiteDatabase2;
                } catch (Throwable th9) {
                    th2 = th9;
                    sQLiteDatabase = sQLiteDatabase2;
                    if (cursor2 != null) {
                    }
                    if (sQLiteDatabase != null) {
                    }
                    throw th2;
                }
            } catch (SQLiteDatabaseLockedException unused7) {
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (SQLiteFullException e20) {
                e10 = e20;
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (SQLiteException e21) {
                e11 = e21;
                cursor = null;
                sQLiteDatabase2 = null;
            } catch (Throwable th10) {
                th2 = th10;
                sQLiteDatabase = null;
            }
        }
        c().N().a("Failed to read events from database in reasonable time");
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }
}
