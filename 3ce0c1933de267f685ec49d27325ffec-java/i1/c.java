package i1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.List;
/* compiled from: SupportSQLiteOpenHelper.java */
/* loaded from: classes.dex */
public interface c extends Closeable {

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28013a;

        public a(int i10) {
            this.f28013a = i10;
        }

        private void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w("SupportSQLite", "deleting the database file: " + str);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } else {
                        try {
                            if (!new File(str).delete()) {
                                Log.e("SupportSQLite", "Could not delete the database file " + str);
                            }
                        } catch (Exception e10) {
                            Log.e("SupportSQLite", "error while deleting corrupted database file", e10);
                        }
                    }
                } catch (Exception e11) {
                    Log.w("SupportSQLite", "delete failed: ", e11);
                }
            }
        }

        public void b(i1.b bVar) {
        }

        public void c(i1.b bVar) {
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + bVar.a());
            if (!bVar.isOpen()) {
                a(bVar.a());
                return;
            }
            List<Pair<String, String>> list = null;
            try {
                try {
                    list = bVar.j();
                } catch (SQLiteException unused) {
                }
                try {
                    bVar.close();
                } catch (IOException unused2) {
                }
            } finally {
                if (list != null) {
                    for (Pair<String, String> next : list) {
                        a((String) next.second);
                    }
                } else {
                    a(bVar.a());
                }
            }
        }

        public abstract void d(i1.b bVar);

        public abstract void e(i1.b bVar, int i10, int i11);

        public void f(i1.b bVar) {
        }

        public abstract void g(i1.b bVar, int i10, int i11);
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f28014a;

        /* renamed from: b  reason: collision with root package name */
        public final String f28015b;

        /* renamed from: c  reason: collision with root package name */
        public final a f28016c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f28017d;

        /* compiled from: SupportSQLiteOpenHelper.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            Context f28018a;

            /* renamed from: b  reason: collision with root package name */
            String f28019b;

            /* renamed from: c  reason: collision with root package name */
            a f28020c;

            /* renamed from: d  reason: collision with root package name */
            boolean f28021d;

            a(Context context) {
                this.f28018a = context;
            }

            public b a() {
                if (this.f28020c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.f28018a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.f28021d || !TextUtils.isEmpty(this.f28019b)) {
                    return new b(this.f28018a, this.f28019b, this.f28020c, this.f28021d);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            public a b(a aVar) {
                this.f28020c = aVar;
                return this;
            }

            public a c(String str) {
                this.f28019b = str;
                return this;
            }

            public a d(boolean z10) {
                this.f28021d = z10;
                return this;
            }
        }

        b(Context context, String str, a aVar, boolean z10) {
            this.f28014a = context;
            this.f28015b = str;
            this.f28016c = aVar;
            this.f28017d = z10;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* compiled from: SupportSQLiteOpenHelper.java */
    /* renamed from: i1.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface AbstractC0307c {
        c a(b bVar);
    }

    i1.b S();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z10);
}
