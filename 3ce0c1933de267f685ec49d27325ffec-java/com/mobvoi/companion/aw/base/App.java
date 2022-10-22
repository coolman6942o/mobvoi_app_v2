package com.mobvoi.companion.aw.base;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.appcompat.app.f;
import bd.a;
import com.mobvoi.android.common.utils.e;
import com.mobvoi.android.common.utils.g;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.WearableModule;
import com.mobvoi.companion.receiver.AlarmReceiver;
import com.mobvoi.mcuwatch.notify.NotificationService;
import com.realsil.sdk.dfu.DfuException;
import ic.c;
import java.io.File;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import ne.s;
import yd.i;
/* loaded from: classes2.dex */
public class App extends n {

    /* renamed from: d  reason: collision with root package name */
    private static App f16161d;

    /* renamed from: b  reason: collision with root package name */
    kn.a<Set<qk.a>> f16162b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences.OnSharedPreferenceChangeListener f16163c = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mobvoi.companion.aw.base.a
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            App.this.i(sharedPreferences, str);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements a.b {
        a(App app) {
        }

        @Override // bd.a.b
        public void a(Activity activity) {
            k.a("MobvoiApp", "onEnterForeground");
        }

        @Override // bd.a.b
        public void b() {
            k.a("MobvoiApp", "onEnterBackground");
        }
    }

    /* loaded from: classes2.dex */
    private static final class b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends Thread {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ int d(File file, File file2) {
                return Long.compare(file2.lastModified(), file.lastModified());
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                File[] listFiles = new File(d.b(com.mobvoi.android.common.utils.b.e())).listFiles(com.mobvoi.companion.aw.base.b.f16165a);
                if (listFiles != null) {
                    if (listFiles.length > 20) {
                        Arrays.sort(listFiles, c.f16166a);
                        int length = listFiles.length;
                        for (int i10 = 20; i10 < length; i10++) {
                            listFiles[i10].delete();
                        }
                    }
                }
            }
        }

        static void a(String str) {
            k.n(new g(d.b(com.mobvoi.android.common.utils.b.e()), "ticwatch", str));
            new a().start();
        }
    }

    private void c() {
        boolean booleanValue = ((Boolean) i.a().c("need_show", Boolean.TRUE)).booleanValue();
        k.a("MobvoiApp", "checkShowAppShare needShow = " + booleanValue);
        if (booleanValue) {
            int intValue = ((Integer) i.a().c("launcher_times", 1)).intValue();
            k.c("MobvoiApp", "checkShowAppShare launchTimes = %s", Integer.valueOf(intValue));
            if (intValue > 3) {
                long millis = TimeUnit.MINUTES.toMillis(1L);
                long currentTimeMillis = System.currentTimeMillis();
                PendingIntent broadcast = PendingIntent.getBroadcast(getApplicationContext(), DfuException.ERROR_DFU_SPP_OTA_NOT_SUPPORTED, new Intent(com.mobvoi.android.common.utils.b.e(), AlarmReceiver.class), 335544320);
                AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    try {
                        if (i10 >= 31) {
                            alarmManager.setAndAllowWhileIdle(0, currentTimeMillis + millis, broadcast);
                        } else {
                            alarmManager.setExactAndAllowWhileIdle(0, currentTimeMillis + millis, broadcast);
                        }
                    } catch (Exception e10) {
                        k.r("MobvoiApp", "setExactAndAllowWhileIdle error!", e10, new Object[0]);
                    }
                } else if (i10 >= 19) {
                    alarmManager.setExact(0, currentTimeMillis + millis, broadcast);
                } else {
                    alarmManager.setRepeating(0, currentTimeMillis, millis, broadcast);
                }
            } else {
                i.a().d("launcher_times", Integer.valueOf(intValue + 1));
            }
        }
    }

    public static App d() {
        return f16161d;
    }

    private void e() {
        for (qk.a aVar : this.f16162b.get()) {
            k.f("MobvoiApp", "initAllDevice() called %s", aVar.getDeviceType());
            qk.b.g().a(aVar.getDeviceType(), aVar);
        }
    }

    private void f() {
        bd.a.i(this);
        bd.a.g().e(new a(this));
    }

    private void g() {
        WearableModule.getInstance().initApp(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(SharedPreferences sharedPreferences, String str) {
        if (com.mobvoi.companion.base.settings.a.DEVELOP_MODE.equals(str)) {
            k.m(com.mobvoi.companion.base.settings.a.isDevelopMode(this));
        }
    }

    @Override // com.mobvoi.companion.aw.base.n, android.app.Application
    public void onCreate() {
        super.onCreate();
        com.mobvoi.android.common.utils.b.k(this);
        f16161d = this;
        sb.a.b(this, "AB875F960D34420DA5F0030FCA50560C", "play.google.com");
        sb.a.k(false);
        sb.a.l(false);
        k.m(com.mobvoi.companion.base.settings.a.isDevelopMode(this));
        e.g(2);
        k.i("MobvoiApp", "app start, version: %s", com.mobvoi.android.common.utils.b.c());
        String f10 = com.mobvoi.android.common.utils.b.f(this);
        String g10 = com.mobvoi.android.common.utils.b.g(f10);
        b.a(g10);
        k.i("MobvoiApp", "process: %s", f10);
        if (Build.VERSION.SDK_INT >= 28 && !TextUtils.isEmpty(g10)) {
            WebView.setDataDirectorySuffix(g10);
        }
        com.mobvoi.companion.base.settings.a.setBuildIsDebug(false);
        com.mobvoi.companion.base.settings.a.setOversea(true);
        com.mobvoi.companion.base.settings.a.setVersionName("6.0.1-2250.806");
        com.mobvoi.companion.base.settings.a.registerOnSharedPreferenceChangeListener(this, this.f16163c);
        ic.b.a((c) kc.b.b().a(c.class));
        if (!com.mobvoi.android.common.utils.b.l(f10)) {
            k.a("MobvoiApp", "Not main process, skip modules init.");
            return;
        }
        f();
        c();
        g();
        NotificationService.j(this);
        AccountConstant.f(d.a(this));
        AccountManager.h().q(true);
        o.b(this);
        s.a().g(true);
        e();
        va.a.c(this);
        f.G(ta.a.o());
    }

    @Override // android.app.Application
    public void onTerminate() {
        super.onTerminate();
        vb.c.i().g();
    }
}
