package com.mobvoi.fitness.core.data.db.gen;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g0;
import com.amap.api.services.core.AMapException;
import com.mobvoi.android.common.utils.k;
/* loaded from: classes2.dex */
public abstract class FitnessDatabase extends RoomDatabase {

    /* renamed from: n  reason: collision with root package name */
    private static FitnessDatabase f17905n;

    /* renamed from: o  reason: collision with root package name */
    private static final g1.a f17906o = new b(1, 1018);

    /* renamed from: p  reason: collision with root package name */
    private static final g1.a f17907p = new c(AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, 1018);

    /* renamed from: q  reason: collision with root package name */
    private static final g1.a f17908q = new d(AMapException.CODE_AMAP_INSUFFICIENT_PRIVILEGES, 1018);

    /* renamed from: r  reason: collision with root package name */
    private static final g1.a f17909r = new e(AMapException.CODE_AMAP_USER_KEY_RECYCLED, 1018);

    /* renamed from: s  reason: collision with root package name */
    private static final g1.a f17910s = new f(1014, 1018);

    /* renamed from: t  reason: collision with root package name */
    private static final g1.a f17911t = new g(1015, 1018);

    /* renamed from: u  reason: collision with root package name */
    private static final g1.a f17912u = new h(1016, 1018);

    /* renamed from: v  reason: collision with root package name */
    private static final g1.a f17913v = new i(1017, 1018);

    /* renamed from: w  reason: collision with root package name */
    private static final g1.a f17914w = new j(1018, 1019);

    /* renamed from: x  reason: collision with root package name */
    private static final g1.a f17915x = new a(1019, 1020);

    /* loaded from: classes2.dex */
    class a extends g1.a {
        a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1019_1020");
            bVar.l("ALTER TABLE RECORD ADD COLUMN EXTRA TEXT");
        }
    }

    /* loaded from: classes2.dex */
    class b extends g1.a {
        b(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1_1018");
            bVar.l("DROP TABLE IF EXISTS 'ITEM'");
            bVar.l("DROP TABLE IF EXISTS 'HEART_RATE'");
            bVar.l("DROP TABLE IF EXISTS 'CONTROL_TIME'");
            bVar.l("DROP TABLE IF EXISTS 'STEPS'");
            bVar.l("DROP TABLE IF EXISTS 'LOCATIONS'");
            bVar.l("DROP TABLE IF EXISTS 'RECORD'");
            bVar.l("DROP TABLE IF EXISTS 'POINT'");
            FitnessDatabase.E(bVar);
        }
    }

    /* loaded from: classes2.dex */
    class c extends g1.a {
        c(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1011_1018");
            bVar.l("DROP TABLE IF EXISTS 'ITEM'");
            bVar.l("DROP TABLE IF EXISTS 'HEART_RATE'");
            bVar.l("DROP TABLE IF EXISTS 'CONTROL_TIME'");
            bVar.l("DROP TABLE IF EXISTS 'STEPS'");
            bVar.l("DROP TABLE IF EXISTS 'LOCATIONS'");
            bVar.l("DROP TABLE IF EXISTS 'RECORD'");
            bVar.l("DROP TABLE IF EXISTS 'POINT'");
            FitnessDatabase.E(bVar);
        }
    }

    /* loaded from: classes2.dex */
    class d extends g1.a {
        d(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1012_1018");
            bVar.l("DROP TABLE IF EXISTS 'ITEM'");
            bVar.l("DROP TABLE IF EXISTS 'HEART_RATE'");
            bVar.l("DROP TABLE IF EXISTS 'CONTROL_TIME'");
            bVar.l("DROP TABLE IF EXISTS 'STEPS'");
            bVar.l("DROP TABLE IF EXISTS 'LOCATIONS'");
            bVar.l("DROP TABLE IF EXISTS 'RECORD'");
            bVar.l("DROP TABLE IF EXISTS 'POINT'");
            FitnessDatabase.E(bVar);
        }
    }

    /* loaded from: classes2.dex */
    class e extends g1.a {
        e(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1013_1018");
            bVar.l("ALTER TABLE POINT ADD COLUMN SWIM_TRIPS REAL ");
            bVar.l("ALTER TABLE POINT ADD COLUMN SWIM_DISTANCE INTEGER ");
            bVar.l("ALTER TABLE POINT ADD COLUMN SWIM_STROKE INTEGER ");
            bVar.l("ALTER TABLE POINT ADD COLUMN SWIM_TYPE INTEGER ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SWIM_TRIPS REAL ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SWIM_DISTANCE INTEGER ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SWIM_POOL_LENGTH INTEGER ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SWIM_STROKE INTEGER ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN DEVICE_ID TEXT");
            bVar.l("ALTER TABLE POINT ADD COLUMN TIMESTAMP INTEGER NOT NULL DEFAULT -1");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SESSION_MODE INTEGER");
            bVar.l("ALTER TABLE POINT ADD COLUMN ELEVATION REAL ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MAX_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MIN_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_UP REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_DOWN REAL");
        }
    }

    /* loaded from: classes2.dex */
    class f extends g1.a {
        f(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1014_1018");
            bVar.l("ALTER TABLE RECORD ADD COLUMN DEVICE_ID TEXT");
            bVar.l("ALTER TABLE POINT ADD COLUMN TIMESTAMP INTEGER NOT NULL DEFAULT -1");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SESSION_MODE INTEGER");
            bVar.l("ALTER TABLE POINT ADD COLUMN ELEVATION REAL ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MAX_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MIN_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_UP REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_DOWN REAL");
        }
    }

    /* loaded from: classes2.dex */
    class g extends g1.a {
        g(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1015_1018");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SESSION_MODE INTEGER ");
            bVar.l("ALTER TABLE POINT ADD COLUMN ELEVATION REAL ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MAX_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MIN_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_UP REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_DOWN REAL");
        }
    }

    /* loaded from: classes2.dex */
    class h extends g1.a {
        h(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1016_1018");
            bVar.l("ALTER TABLE POINT ADD COLUMN ELEVATION REAL ");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MAX_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN MIN_ELEVATION REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_UP REAL");
            bVar.l("ALTER TABLE RECORD ADD COLUMN CUMULATIVE_DOWN REAL");
        }
    }

    /* loaded from: classes2.dex */
    class i extends g1.a {
        i(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1017_1018");
        }
    }

    /* loaded from: classes2.dex */
    class j extends g1.a {
        j(int i10, int i11) {
            super(i10, i11);
        }

        @Override // g1.a
        public void a(i1.b bVar) {
            k.a("FitnessDatabase", "migrate: MIGRATION_1018_1019");
            bVar.l("ALTER TABLE RECORD ADD COLUMN SCORE REAL");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(i1.b bVar) {
        bVar.l("CREATE TABLE  IF NOT EXISTS  'RECORD' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'HASH' TEXT UNIQUE ,'TYPE' INTEGER NOT NULL ,'TARGET_TYPE' INTEGER,'TARGET_VALUE' REAL,'ACCOUNT_ID' TEXT,'SYNCED' INTEGER NOT NULL ,'DELETED' INTEGER NOT NULL ,'START_TIME' INTEGER,'END_TIME' INTEGER,'TIMESTAMP' INTEGER,'DURATION' INTEGER NOT NULL ,'DISTANCE' INTEGER,'CALORIE' REAL,'STEP' INTEGER,'HEART' INTEGER,'GROUPS' TEXT,'SWIM_TRIPS' REAL,'SWIM_DISTANCE' INTEGER,'SWIM_POOL_LENGTH' INTEGER,'SWIM_STROKE' INTEGER,'DEVICE_ID' TEXT,'SESSION_MODE' INTEGER,'MAX_ELEVATION' REAL,'MIN_ELEVATION' REAL,'CUMULATIVE_UP' REAL,'CUMULATIVE_DOWN' REAL);");
        bVar.l("CREATE INDEX IF NOT EXISTS  IDX_RECORD_HASH ON RECORD (HASH);");
        bVar.l("CREATE TABLE IF NOT EXISTS 'POINT' ('_id' INTEGER PRIMARY KEY AUTOINCREMENT ,'TIME' INTEGER NOT NULL ,'HEART' INTEGER,'STEP' INTEGER,'LAT' REAL NOT NULL ,'LON' REAL NOT NULL ,'ACC' REAL NOT NULL ,'DISTANCE' INTEGER,'SPEED' REAL,'CALORIE' REAL,'RECORD_ID' INTEGER,'RESUME' INTEGER,'SWIM_TRIPS' REAL,'SWIM_DISTANCE' INTEGER,'SWIM_STROKE' INTEGER,'SWIM_TYPE' INTEGER,'TIMESTAMP' INTEGER NOT NULL ,'ELEVATION' REAL);");
    }

    public static FitnessDatabase G(Context context) {
        FitnessDatabase fitnessDatabase = f17905n;
        if (fitnessDatabase == null) {
            synchronized (FitnessDatabase.class) {
                fitnessDatabase = f17905n;
                if (fitnessDatabase == null) {
                    FitnessDatabase fitnessDatabase2 = (FitnessDatabase) g0.a(context.getApplicationContext(), FitnessDatabase.class, "fitness.db").c().b(H()).d();
                    f17905n = fitnessDatabase2;
                    fitnessDatabase = fitnessDatabase2;
                }
            }
        }
        return fitnessDatabase;
    }

    private static g1.a[] H() {
        return new g1.a[]{f17906o, f17907p, f17908q, f17909r, f17910s, f17911t, f17912u, f17913v, f17914w, f17915x};
    }

    public abstract ye.c F();
}
