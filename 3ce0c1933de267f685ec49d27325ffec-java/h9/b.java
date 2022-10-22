package h9;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: LogUtil.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27752a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f27753b = true;

    /* renamed from: c  reason: collision with root package name */
    private static ExecutorService f27754c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f27755d = System.getProperty("line.separator");

    /* renamed from: e  reason: collision with root package name */
    private static final Format f27756e = new SimpleDateFormat("MM-dd HH:mm:ss.SSS ");

    /* renamed from: f  reason: collision with root package name */
    private static final String f27757f = System.getProperty("file.separator");

    /* renamed from: g  reason: collision with root package name */
    private static final C0300b f27758g = new C0300b(null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LogUtil.java */
    /* loaded from: classes2.dex */
    public static class a implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27759a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f27760b;

        a(String str, String str2) {
            this.f27759a = str;
            this.f27760b = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean call() throws Exception {
            Throwable th2;
            BufferedWriter bufferedWriter;
            IOException e10;
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(this.f27759a, true));
                    try {
                        bufferedWriter.write(this.f27760b);
                        Boolean bool = Boolean.TRUE;
                        try {
                            bufferedWriter.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        return bool;
                    } catch (IOException e12) {
                        e10 = e12;
                        e10.printStackTrace();
                        Boolean bool2 = Boolean.FALSE;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e13) {
                                e13.printStackTrace();
                            }
                        }
                        return bool2;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (0 != 0) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                    throw th2;
                }
            } catch (IOException e15) {
                e10 = e15;
                bufferedWriter = null;
            } catch (Throwable th4) {
                th2 = th4;
                if (0 != 0) {
                }
                throw th2;
            }
        }
    }

    /* compiled from: LogUtil.java */
    /* renamed from: h9.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0300b {

        /* renamed from: a  reason: collision with root package name */
        private String f27761a;

        /* renamed from: b  reason: collision with root package name */
        private String f27762b;

        /* renamed from: c  reason: collision with root package name */
        private String f27763c;

        /* synthetic */ C0300b(a aVar) {
            this();
        }

        private C0300b() {
            this.f27763c = "log";
            if (this.f27761a == null) {
                if (!"mounted".equals(Environment.getExternalStorageState()) || f9.a.a().getExternalCacheDir() == null) {
                    this.f27761a = f9.a.a().getCacheDir() + b.f27757f + "log" + b.f27757f;
                    return;
                }
                this.f27761a = f9.a.a().getExternalCacheDir() + b.f27757f + "log" + b.f27757f;
            }
        }
    }

    private static boolean b(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    private static boolean c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        if (!b(file.getParentFile())) {
            return false;
        }
        try {
            boolean createNewFile = file.createNewFile();
            if (createNewFile) {
                m(str);
            }
            return createNewFile;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static void d(String str) {
        e("LASER", str);
    }

    public static void e(String str, String str2) {
        if (f27752a && !TextUtils.isEmpty(str2)) {
            Log.d(str, str2);
            if (f27753b) {
                h(str2);
            }
        }
    }

    public static void f(String str) {
        g("LASER", str);
    }

    public static void g(String str, String str2) {
        if (f27752a && !TextUtils.isEmpty(str2)) {
            Log.e(str, str2);
            if (f27753b) {
                h(str2);
            }
        }
    }

    public static void h(String str) {
        l("LASER", str);
    }

    public static void i(String str) {
        j("LASER", str);
    }

    public static void j(String str, String str2) {
        if (f27752a && !TextUtils.isEmpty(str2)) {
            Log.i(str, str2);
            if (f27753b) {
                h(str2);
            }
        }
    }

    private static void k(String str, String str2) {
        if (f27754c == null) {
            f27754c = Executors.newSingleThreadExecutor();
        }
        try {
            if (((Boolean) f27754c.submit(new a(str2, str)).get()).booleanValue()) {
                return;
            }
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        } catch (ExecutionException e11) {
            e11.printStackTrace();
        }
        f("log to " + str2 + " failed!");
    }

    private static void l(String str, String str2) {
        String format = f27756e.format(new Date(System.currentTimeMillis()));
        String substring = format.substring(0, 5);
        String substring2 = format.substring(6);
        StringBuilder sb2 = new StringBuilder();
        C0300b bVar = f27758g;
        sb2.append(bVar.f27762b == null ? bVar.f27761a : bVar.f27762b);
        sb2.append(bVar.f27763c);
        sb2.append("-");
        sb2.append(substring);
        sb2.append(".txt");
        String sb3 = sb2.toString();
        if (!c(sb3)) {
            f("create " + sb3 + " failed!");
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(substring2);
        sb4.append("\t");
        sb4.append(str + "\t");
        sb4.append(str2);
        sb4.append(f27755d);
        k(sb4.toString(), sb3);
    }

    private static void m(String str) {
        String str2 = "";
        int i10 = 0;
        try {
            PackageInfo packageInfo = f9.a.a().getPackageManager().getPackageInfo(f9.a.a().getPackageName(), 0);
            if (packageInfo != null) {
                str2 = packageInfo.versionName;
                i10 = packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        String substring = str.substring(str.length() - 9, str.length() - 4);
        k("************* Log Head ****************\nDate of Log        : " + substring + "\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + str2 + "\nApp VersionCode    : " + i10 + "\n************* Log Head ****************\n\n", str);
    }

    public static void n(String str, String str2) {
        if (f27752a && !TextUtils.isEmpty(str2)) {
            Log.w(str, str2);
            if (f27753b) {
                h(str2);
            }
        }
    }
}
