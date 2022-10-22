package j1;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import i1.c;
import java.io.File;
/* compiled from: FrameworkSQLiteOpenHelper.java */
/* loaded from: classes.dex */
class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29375a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29376b;

    /* renamed from: c  reason: collision with root package name */
    private final c.a f29377c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f29378d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f29379e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private a f29380f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29381g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FrameworkSQLiteOpenHelper.java */
    /* loaded from: classes.dex */
    public static class a extends SQLiteOpenHelper {

        /* renamed from: a  reason: collision with root package name */
        final j1.a[] f29382a;

        /* renamed from: b  reason: collision with root package name */
        final c.a f29383b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f29384c;

        /* compiled from: FrameworkSQLiteOpenHelper.java */
        /* renamed from: j1.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0353a implements DatabaseErrorHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c.a f29385a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ j1.a[] f29386b;

            C0353a(c.a aVar, j1.a[] aVarArr) {
                this.f29385a = aVar;
                this.f29386b = aVarArr;
            }

            @Override // android.database.DatabaseErrorHandler
            public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                this.f29385a.c(a.d(this.f29386b, sQLiteDatabase));
            }
        }

        a(Context context, String str, j1.a[] aVarArr, c.a aVar) {
            super(context, str, null, aVar.f28013a, new C0353a(aVar, aVarArr));
            this.f29383b = aVar;
            this.f29382a = aVarArr;
        }

        static j1.a d(j1.a[] aVarArr, SQLiteDatabase sQLiteDatabase) {
            j1.a aVar = aVarArr[0];
            if (aVar == null || !aVar.c(sQLiteDatabase)) {
                aVarArr[0] = new j1.a(sQLiteDatabase);
            }
            return aVarArr[0];
        }

        j1.a c(SQLiteDatabase sQLiteDatabase) {
            return d(this.f29382a, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.f29382a[0] = null;
        }

        synchronized i1.b h() {
            this.f29384c = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (this.f29384c) {
                close();
                return h();
            }
            return c(writableDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.f29383b.b(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f29383b.d(c(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f29384c = true;
            this.f29383b.e(c(sQLiteDatabase), i10, i11);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (!this.f29384c) {
                this.f29383b.f(c(sQLiteDatabase));
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f29384c = true;
            this.f29383b.g(c(sQLiteDatabase), i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, String str, c.a aVar, boolean z10) {
        this.f29375a = context;
        this.f29376b = str;
        this.f29377c = aVar;
        this.f29378d = z10;
    }

    private a c() {
        a aVar;
        synchronized (this.f29379e) {
            if (this.f29380f == null) {
                j1.a[] aVarArr = new j1.a[1];
                int i10 = Build.VERSION.SDK_INT;
                if (i10 < 23 || this.f29376b == null || !this.f29378d) {
                    this.f29380f = new a(this.f29375a, this.f29376b, aVarArr, this.f29377c);
                } else {
                    this.f29380f = new a(this.f29375a, new File(this.f29375a.getNoBackupFilesDir(), this.f29376b).getAbsolutePath(), aVarArr, this.f29377c);
                }
                if (i10 >= 16) {
                    this.f29380f.setWriteAheadLoggingEnabled(this.f29381g);
                }
            }
            aVar = this.f29380f;
        }
        return aVar;
    }

    @Override // i1.c
    public i1.b S() {
        return c().h();
    }

    @Override // i1.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c().close();
    }

    @Override // i1.c
    public String getDatabaseName() {
        return this.f29376b;
    }

    @Override // i1.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        synchronized (this.f29379e) {
            a aVar = this.f29380f;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z10);
            }
            this.f29381g = z10;
        }
    }
}
