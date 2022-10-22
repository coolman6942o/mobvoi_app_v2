package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.util.DynamiteApi;
import h6.g;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import k6.d;
/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f9042b = null;

    /* renamed from: c  reason: collision with root package name */
    private static i f9043c = null;

    /* renamed from: d  reason: collision with root package name */
    private static k f9044d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f9045e = null;

    /* renamed from: f  reason: collision with root package name */
    private static int f9046f = -1;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal<b> f9047g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private static final a.AbstractC0110a f9048h = new com.google.android.gms.dynamite.a();

    /* renamed from: i  reason: collision with root package name */
    public static final a f9049i = new com.google.android.gms.dynamite.b();

    /* renamed from: j  reason: collision with root package name */
    public static final a f9050j = new d();

    /* renamed from: k  reason: collision with root package name */
    public static final a f9051k = new e();

    /* renamed from: a  reason: collision with root package name */
    private final Context f9052a;

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        private LoadingException(String str, Throwable th2) {
            super(str, th2);
        }

        /* synthetic */ LoadingException(String str, com.google.android.gms.dynamite.a aVar) {
            this(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th2, com.google.android.gms.dynamite.a aVar) {
            this(str, th2);
        }
    }

    /* loaded from: classes.dex */
    public interface a {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface AbstractC0110a {
            int a(Context context, String str);

            int b(Context context, String str, boolean z10) throws LoadingException;
        }

        /* loaded from: classes.dex */
        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f9053a = 0;

            /* renamed from: b  reason: collision with root package name */
            public int f9054b = 0;

            /* renamed from: c  reason: collision with root package name */
            public int f9055c = 0;
        }

        b a(Context context, String str, AbstractC0110a aVar) throws LoadingException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Cursor f9056a;

        private b() {
        }

        /* synthetic */ b(com.google.android.gms.dynamite.a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements a.AbstractC0110a {

        /* renamed from: a  reason: collision with root package name */
        private final int f9057a;

        public c(int i10, int i11) {
            this.f9057a = i10;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.AbstractC0110a
        public final int a(Context context, String str) {
            return this.f9057a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.a.AbstractC0110a
        public final int b(Context context, String str, boolean z10) {
            return 0;
        }
    }

    static {
        new com.google.android.gms.dynamite.c();
        new f();
        new g();
    }

    private DynamiteModule(Context context) {
        this.f9052a = (Context) i.k(context);
    }

    public static int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 61);
            sb2.append("com.google.android.gms.dynamite.descriptors.");
            sb2.append(str);
            sb2.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb2.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb3.append("Module descriptor id '");
            sb3.append(valueOf);
            sb3.append("' didn't match expected id '");
            sb3.append(str);
            sb3.append("'");
            Log.e("DynamiteModule", sb3.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 45);
            sb4.append("Local module descriptor class for ");
            sb4.append(str);
            sb4.append(" not found.");
            Log.w("DynamiteModule", sb4.toString());
            return 0;
        } catch (Exception e10) {
            String valueOf2 = String.valueOf(e10.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static DynamiteModule d(Context context, a aVar, String str) throws LoadingException {
        ThreadLocal<b> threadLocal = f9047g;
        b bVar = threadLocal.get();
        b bVar2 = new b(null);
        threadLocal.set(bVar2);
        try {
            a.b a10 = aVar.a(context, str, f9048h);
            int i10 = a10.f9053a;
            int i11 = a10.f9054b;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb2.append("Considering local module ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i10);
            sb2.append(" and remote module ");
            sb2.append(str);
            sb2.append(":");
            sb2.append(i11);
            Log.i("DynamiteModule", sb2.toString());
            int i12 = a10.f9055c;
            if (i12 == 0 || ((i12 == -1 && a10.f9053a == 0) || (i12 == 1 && a10.f9054b == 0))) {
                int i13 = a10.f9053a;
                int i14 = a10.f9054b;
                StringBuilder sb3 = new StringBuilder(91);
                sb3.append("No acceptable module found. Local version is ");
                sb3.append(i13);
                sb3.append(" and remote version is ");
                sb3.append(i14);
                sb3.append(".");
                throw new LoadingException(sb3.toString(), (com.google.android.gms.dynamite.a) null);
            } else if (i12 == -1) {
                DynamiteModule l10 = l(context, str);
                Cursor cursor = bVar2.f9056a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(bVar);
                return l10;
            } else if (i12 == 1) {
                try {
                    DynamiteModule f10 = f(context, str, a10.f9054b);
                    Cursor cursor2 = bVar2.f9056a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(bVar);
                    return f10;
                } catch (LoadingException e10) {
                    String valueOf = String.valueOf(e10.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i15 = a10.f9053a;
                    if (i15 == 0 || aVar.a(context, str, new c(i15, 0)).f9055c != -1) {
                        throw new LoadingException("Remote load failed. No local fallback found.", e10, null);
                    }
                    DynamiteModule l11 = l(context, str);
                    Cursor cursor3 = bVar2.f9056a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    f9047g.set(bVar);
                    return l11;
                }
            } else {
                int i16 = a10.f9055c;
                StringBuilder sb4 = new StringBuilder(47);
                sb4.append("VersionPolicy returned invalid code:");
                sb4.append(i16);
                throw new LoadingException(sb4.toString(), (com.google.android.gms.dynamite.a) null);
            }
        } catch (Throwable th2) {
            Cursor cursor4 = bVar2.f9056a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f9047g.set(bVar);
            throw th2;
        }
    }

    public static int e(Context context, String str, boolean z10) {
        Class<?> loadClass;
        Field declaredField;
        Boolean bool;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool2 = f9042b;
                if (bool2 == null) {
                    try {
                        loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        declaredField = loadClass.getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e10) {
                        String valueOf = String.valueOf(e10);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 30);
                        sb2.append("Failed to load module via V2: ");
                        sb2.append(valueOf);
                        Log.w("DynamiteModule", sb2.toString());
                        bool2 = Boolean.FALSE;
                    }
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader == ClassLoader.getSystemClassLoader()) {
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    g(classLoader);
                                } catch (LoadingException unused) {
                                }
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        } else {
                            try {
                                int k10 = k(context, str, z10);
                                String str2 = f9045e;
                                if (str2 != null && !str2.isEmpty()) {
                                    h hVar = new h(f9045e, ClassLoader.getSystemClassLoader());
                                    g(hVar);
                                    declaredField.set(null, hVar);
                                    f9042b = Boolean.TRUE;
                                    return k10;
                                }
                                return k10;
                            } catch (LoadingException unused2) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            }
                        }
                        bool2 = bool;
                        f9042b = bool2;
                    }
                }
                if (!bool2.booleanValue()) {
                    return i(context, str, z10);
                }
                try {
                    return k(context, str, z10);
                } catch (LoadingException e11) {
                    String valueOf2 = String.valueOf(e11.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                    return 0;
                }
            }
        } catch (Throwable th2) {
            g.a(context, th2);
            throw th2;
        }
    }

    private static DynamiteModule f(Context context, String str, int i10) throws LoadingException {
        Boolean bool;
        k6.b bVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = f9042b;
            }
            if (bool == null) {
                throw new LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.a) null);
            } else if (bool.booleanValue()) {
                return j(context, str, i10);
            } else {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
                sb2.append("Selected remote version of ");
                sb2.append(str);
                sb2.append(", version >= ");
                sb2.append(i10);
                Log.i("DynamiteModule", sb2.toString());
                i m10 = m(context);
                if (m10 != null) {
                    if (m10.d2() >= 2) {
                        bVar = m10.K1(d.A2(context), str, i10);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        bVar = m10.i2(d.A2(context), str, i10);
                    }
                    if (d.U1(bVar) != null) {
                        return new DynamiteModule((Context) d.U1(bVar));
                    }
                    throw new LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.a) null);
                }
                throw new LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.a) null);
            }
        } catch (RemoteException e10) {
            throw new LoadingException("Failed to load remote module.", e10, null);
        } catch (LoadingException e11) {
            throw e11;
        } catch (Throwable th2) {
            g.a(context, th2);
            throw new LoadingException("Failed to load remote module.", th2, null);
        }
    }

    private static void g(ClassLoader classLoader) throws LoadingException {
        k kVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                kVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof k) {
                    kVar = (k) queryLocalInterface;
                } else {
                    kVar = new l(iBinder);
                }
            }
            f9044d = kVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to instantiate dynamite loader", e10, null);
        }
    }

    private static Boolean h() {
        Boolean valueOf;
        synchronized (DynamiteModule.class) {
            valueOf = Boolean.valueOf(f9046f >= 2);
        }
        return valueOf;
    }

    private static int i(Context context, String str, boolean z10) {
        i m10 = m(context);
        if (m10 == null) {
            return 0;
        }
        try {
            if (m10.d2() >= 2) {
                return m10.V1(d.A2(context), str, z10);
            }
            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
            return m10.w2(d.A2(context), str, z10);
        } catch (RemoteException e10) {
            String valueOf = String.valueOf(e10.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule j(Context context, String str, int i10) throws LoadingException, RemoteException {
        k kVar;
        k6.b bVar;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
        sb2.append("Selected remote version of ");
        sb2.append(str);
        sb2.append(", version >= ");
        sb2.append(i10);
        Log.i("DynamiteModule", sb2.toString());
        synchronized (DynamiteModule.class) {
            kVar = f9044d;
        }
        if (kVar != null) {
            b bVar2 = f9047g.get();
            if (bVar2 == null || bVar2.f9056a == null) {
                throw new LoadingException("No result cursor", (com.google.android.gms.dynamite.a) null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = bVar2.f9056a;
            d.A2(null);
            if (h().booleanValue()) {
                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                bVar = kVar.E1(d.A2(applicationContext), str, i10, d.A2(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                bVar = kVar.d1(d.A2(applicationContext), str, i10, d.A2(cursor));
            }
            Context context2 = (Context) d.U1(bVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new LoadingException("Failed to get module context", (com.google.android.gms.dynamite.a) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.a) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int k(Context context, String str, boolean z10) throws LoadingException {
        Cursor cursor;
        Exception e10;
        Cursor cursor2 = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = z10 ? "api_force_staging" : "api";
            StringBuilder sb2 = new StringBuilder(str2.length() + 42 + String.valueOf(str).length());
            sb2.append("content://com.google.android.gms.chimera/");
            sb2.append(str2);
            sb2.append("/");
            sb2.append(str);
            Cursor query = contentResolver.query(Uri.parse(sb2.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i10 = query.getInt(0);
                        if (i10 > 0) {
                            synchronized (DynamiteModule.class) {
                                f9045e = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f9046f = query.getInt(columnIndex);
                                }
                            }
                            b bVar = f9047g.get();
                            if (bVar != null && bVar.f9056a == null) {
                                bVar.f9056a = query;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                return i10;
                            }
                        }
                        cursor2 = query;
                        if (cursor2 != null) {
                        }
                        return i10;
                    }
                } catch (Exception e11) {
                    e10 = e11;
                    cursor = query;
                    try {
                        if (e10 instanceof LoadingException) {
                            throw e10;
                        }
                        throw new LoadingException("V2 version check failed", e10, null);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = query;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", (com.google.android.gms.dynamite.a) null);
        } catch (Exception e12) {
            e10 = e12;
            cursor = null;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private static DynamiteModule l(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static i m(Context context) {
        i iVar;
        synchronized (DynamiteModule.class) {
            i iVar2 = f9043c;
            if (iVar2 != null) {
                return iVar2;
            }
            if (com.google.android.gms.common.c.h().i(context) != 0) {
                return null;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    iVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof i) {
                        iVar = (i) queryLocalInterface;
                    } else {
                        iVar = new j(iBinder);
                    }
                }
                if (iVar != null) {
                    f9043c = iVar;
                    return iVar;
                }
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
            }
            return null;
        }
    }

    public final Context b() {
        return this.f9052a;
    }

    public final IBinder c(String str) throws LoadingException {
        try {
            return (IBinder) this.f9052a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e10, null);
        }
    }
}
