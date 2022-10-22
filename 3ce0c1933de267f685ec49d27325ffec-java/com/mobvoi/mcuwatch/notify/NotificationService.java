package com.mobvoi.mcuwatch.notify;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.parser.JSONLexer;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.engine.n;
import ii.a;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class NotificationService extends NotificationListenerService {

    /* renamed from: e  reason: collision with root package name */
    public static boolean f19230e;

    /* renamed from: f  reason: collision with root package name */
    private static NotificationService f19231f;

    /* renamed from: a  reason: collision with root package name */
    protected final HashMap<String, Integer> f19232a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private volatile long f19233b;

    /* renamed from: c  reason: collision with root package name */
    private String f19234c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19235d;

    public NotificationService() {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    }

    private static boolean a(int i10, String str) {
        return i10 == 26 && TextUtils.equals(str, "Start a conversation");
    }

    private static boolean b() {
        k.h("NotificationService", " UiUtils.SYNC_WATCHFACE_ING = " + nj.k.f31276a);
        return n.f19178a.G() && nj.k.f31276a;
    }

    private boolean c(String str, String str2, String str3) {
        if ("com.whatsapp".equals(str)) {
            if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) || TextUtils.equals(str2, "Backup in progress")) {
                return true;
            }
        } else if ("com.facebook.orca".equals(str) && TextUtils.equals(str2, "Chat heads active") && TextUtils.equals(str3, "Start a conversation")) {
            return true;
        }
        return false;
    }

    public static NotificationService d() {
        return f19231f;
    }

    private String[] e() {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        intent.setAction("android.provider.Telephony.SMS_DELIVER");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        String[] strArr = new String[queryBroadcastReceivers.size()];
        for (int i10 = 0; i10 < queryBroadcastReceivers.size(); i10++) {
            strArr[i10] = queryBroadcastReceivers.get(i10).activityInfo.packageName;
        }
        return strArr;
    }

    private void f() {
        this.f19232a.put("com.tencent.mobileqq", 5);
        this.f19232a.put("com.tencent.mm", 6);
        this.f19232a.put("com.sina.weibo", 7);
        this.f19232a.put("com.ss.android.ugc.aweme", 8);
        this.f19232a.put("com.smile.gifmake", 9);
        this.f19232a.put("com.ss.android.article.news", 10);
        this.f19232a.put("com.ss.android.article.lite", 10);
        this.f19232a.put("com.eg.android.AlipayGphone", 11);
        this.f19232a.put("com.taobao.taobao", 12);
        this.f19232a.put("com.jingdong.app.mall", 13);
        this.f19232a.put("com.alibaba.android.rimet", 14);
        this.f19232a.put("com.ss.android.lark", 15);
        this.f19232a.put("com.sdu.didi.psnger", 16);
        this.f19232a.put("com.dianping.v1", 17);
        this.f19232a.put("tv.danmaku.bili", 18);
        this.f19232a.put("com.xingin.xhs", 19);
        this.f19232a.put("com.xunmeng.pinduoduo", 20);
        this.f19232a.put("com.qiyi.video", 21);
        this.f19232a.put("com.tencent.weishi", 22);
        this.f19232a.put("com.sankuai.meituan", 23);
        this.f19232a.put("com.sankuai.meituan.takeoutnew", 23);
        this.f19232a.put("me.ele", 24);
        this.f19232a.put("com.whatsapp", 25);
        this.f19232a.put("com.facebook.katana", 26);
        this.f19232a.put("com.facebook.orca", 27);
        this.f19232a.put("com.twitter.android", 33);
        this.f19232a.put("com.instagram.android", 28);
        this.f19232a.put("org.telegram.messenger", 29);
        this.f19232a.put("com.viber.voip", 30);
        this.f19232a.put("jp.naver.line.android", 31);
        this.f19232a.put("com.google.android.gm", 32);
        this.f19232a.put("com.google.android.talk", 34);
        this.f19232a.put("com.ss.android.ugc.trill", 37);
        this.f19232a.put("com.google.android.youtube", 35);
        this.f19232a.put("com.snapchat.android", 36);
        this.f19232a.put("com.Slack", 38);
        this.f19232a.put("com.microsoft.office.lync15", 39);
        this.f19232a.put("com.pinterest", 40);
        this.f19232a.put("com.tumblr", 41);
        this.f19232a.put("com.linkedin.android", 42);
        this.f19232a.put("com.ubercab", 43);
        this.f19232a.put("com.google.android.apps.podcasts", 44);
        this.f19232a.put("com.spotify.music", 45);
        this.f19232a.put("com.deezer.analytics", 46);
        this.f19232a.put("com.waze", 47);
        this.f19232a.put("com.spark71.stravatogpx", 48);
        this.f19232a.put("com.nike.plusgps", 49);
        this.f19232a.put("br.uol.noticias", 50);
        this.f19232a.put("com.ebay.mobile", 51);
        this.f19232a.put("com.google.android.calendar", 52);
    }

    public static void g(int i10, String str) {
        k.a("NotificationService", "NotificationCollectorService发送来电话广播");
        if (!b()) {
            Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_IN_COMING_CALL");
            intent.putExtra("IN_COMING_CALL_TYPE", i10);
            intent.putExtra("TITLE", str);
            b.e().sendBroadcast(intent);
        }
    }

    public static void h(int i10, String str, String str2) {
        k.a("NotificationService", "NotificationCollectorService发送来讯息广播");
        if (!a(i10, str2) && !b()) {
            Intent intent = new Intent("com.mobvoi.ticpod.service.ACTION_IN_COMING_CALL");
            intent.putExtra("IN_COMING_CALL_TYPE", i10);
            intent.putExtra("TITLE", str);
            intent.putExtra("CONTENT", str2);
            b.e().sendBroadcast(intent);
        }
    }

    private void i(int i10, String str, String str2, String str3) {
        String str4 = str3;
        if (!c(str, str2, str4)) {
            if (!"tv.danmaku.bili".equals(str) || !TextUtils.isEmpty(str3)) {
                long currentTimeMillis = System.currentTimeMillis();
                if (!TextUtils.equals(this.f19234c, str)) {
                    this.f19233b = currentTimeMillis;
                    this.f19234c = str;
                    if (TextUtils.isEmpty(str3)) {
                        str4 = getString(sh.k.f34877u4);
                    }
                    h(this.f19232a.get(str).intValue(), str2, str4);
                    if (Log.isLoggable("NotificationService", 2)) {
                        k.c("NotificationService", "APP推送消息，package:%s,title:%s,content:%s,packageName:%s", str, str2, str4, str);
                    }
                } else if (currentTimeMillis - this.f19233b >= 300) {
                    this.f19233b = currentTimeMillis;
                    this.f19234c = str;
                    if (TextUtils.isEmpty(str3)) {
                        str4 = getString(sh.k.f34877u4);
                    }
                    h(this.f19232a.get(str).intValue(), str2, str4);
                    if (Log.isLoggable("NotificationService", 2)) {
                        k.c("NotificationService", "APP推送消息，package:%s,title:%s,content:%s,packageName:%s", str, str2, str4, str);
                    }
                }
            }
        }
    }

    public static boolean j(Context context) {
        if (f19230e) {
            k.a("NotificationService", "triggerNotificationService already binded.");
            return false;
        }
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, NotificationService.class), 2, 1);
        context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, NotificationService.class), 1, 1);
        k.a("NotificationService", "triggerNotificationService success.");
        return true;
    }

    private void k(StatusBarNotification statusBarNotification) {
        Bundle b10;
        if (a.d() && statusBarNotification != null && (b10 = androidx.core.app.k.b(statusBarNotification.getNotification())) != null) {
            b10.isEmpty();
        }
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public IBinder onBind(Intent intent) {
        f19230e = true;
        k.a("NotificationService", "onBind");
        List<rk.a> c10 = qk.b.g().c();
        if (!c10.isEmpty()) {
            for (int i10 = 0; i10 < c10.size(); i10++) {
                c10.get(i10).a(intent);
            }
        }
        return super.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        k.a("NotificationService", "onCreate");
        e();
        this.f19235d = yd.b.c(this);
        f();
        List<rk.a> c10 = qk.b.g().c();
        if (!c10.isEmpty()) {
            for (int i10 = 0; i10 < c10.size(); i10++) {
                c10.get(i10).b(this);
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerConnected() {
        super.onListenerConnected();
        f19231f = this;
        k.a("NotificationService", "onListenerConnected");
        List<rk.a> c10 = qk.b.g().c();
        if (!c10.isEmpty()) {
            for (int i10 = 0; i10 < c10.size(); i10++) {
                c10.get(i10).c();
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onListenerDisconnected() {
        super.onListenerDisconnected();
        f19231f = null;
        k.a("NotificationService", "onListenerDisconnected");
        List<rk.a> c10 = qk.b.g().c();
        if (!c10.isEmpty()) {
            for (int i10 = 0; i10 < c10.size(); i10++) {
                c10.get(i10).d();
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        String str;
        String str2;
        super.onNotificationPosted(statusBarNotification);
        if (Log.isLoggable("NotificationService", 2)) {
            k.a("NotificationService", "onNotificationPosted");
        }
        k(statusBarNotification);
        List<rk.a> d10 = qk.b.g().d(true);
        if (!d10.isEmpty()) {
            for (int i10 = 0; i10 < d10.size(); i10++) {
                d10.get(i10).e(statusBarNotification);
            }
        }
        Notification notification = statusBarNotification.getNotification();
        if (notification != null) {
            Bundle bundle = notification.extras;
            String str3 = "";
            if (bundle != null) {
                String string = bundle.getString("android.title", str3);
                String string2 = bundle.getString("android.text", str3);
                str = statusBarNotification.getPackageName();
                str2 = string2;
                str3 = string;
            } else {
                str2 = str3;
                str = str2;
            }
            n nVar = n.f19178a;
            if (nVar.v()) {
                String packageName = statusBarNotification.getPackageName();
                packageName.hashCode();
                char c10 = 65535;
                switch (packageName.hashCode()) {
                    case -2075712516:
                        if (packageName.equals("com.google.android.youtube")) {
                            c10 = 0;
                            break;
                        }
                        break;
                    case -2034449749:
                        if (packageName.equals("com.microsoft.office.lync15")) {
                            c10 = 1;
                            break;
                        }
                        break;
                    case -1955283627:
                        if (packageName.equals("com.spark71.stravatogpx")) {
                            c10 = 2;
                            break;
                        }
                        break;
                    case -1897170512:
                        if (packageName.equals("org.telegram.messenger")) {
                            c10 = 3;
                            break;
                        }
                        break;
                    case -1886137057:
                        if (packageName.equals("com.smile.gifmake")) {
                            c10 = 4;
                            break;
                        }
                        break;
                    case -1864872766:
                        if (packageName.equals("com.qiyi.video")) {
                            c10 = 5;
                            break;
                        }
                        break;
                    case -1709882794:
                        if (packageName.equals("com.sankuai.meituan")) {
                            c10 = 6;
                            break;
                        }
                        break;
                    case -1651733025:
                        if (packageName.equals("com.viber.voip")) {
                            c10 = 7;
                            break;
                        }
                        break;
                    case -1627072508:
                        if (packageName.equals("com.google.android.apps.podcasts")) {
                            c10 = '\b';
                            break;
                        }
                        break;
                    case -1547699361:
                        if (packageName.equals("com.whatsapp")) {
                            c10 = '\t';
                            break;
                        }
                        break;
                    case -1521143749:
                        if (packageName.equals("jp.naver.line.android")) {
                            c10 = '\n';
                            break;
                        }
                        break;
                    case -1459422248:
                        if (packageName.equals("com.dianping.v1")) {
                            c10 = 11;
                            break;
                        }
                        break;
                    case -1079643320:
                        if (packageName.equals("me.ele")) {
                            c10 = '\f';
                            break;
                        }
                        break;
                    case -1065596028:
                        if (packageName.equals("com.nike.plusgps")) {
                            c10 = '\r';
                            break;
                        }
                        break;
                    case -1031558479:
                        if (packageName.equals("com.xingin.xhs")) {
                            c10 = 14;
                            break;
                        }
                        break;
                    case -973170826:
                        if (packageName.equals("com.tencent.mm")) {
                            c10 = 15;
                            break;
                        }
                        break;
                    case -949179023:
                        if (packageName.equals("com.sankuai.meituan.takeoutnew")) {
                            c10 = 16;
                            break;
                        }
                        break;
                    case -918490570:
                        if (packageName.equals("com.sdu.didi.psnger")) {
                            c10 = 17;
                            break;
                        }
                        break;
                    case -662003450:
                        if (packageName.equals("com.instagram.android")) {
                            c10 = 18;
                            break;
                        }
                        break;
                    case -660073534:
                        if (packageName.equals("com.waze")) {
                            c10 = 19;
                            break;
                        }
                        break;
                    case -583737491:
                        if (packageName.equals("com.pinterest")) {
                            c10 = 20;
                            break;
                        }
                        break;
                    case -543674259:
                        if (packageName.equals("com.google.android.gm")) {
                            c10 = 21;
                            break;
                        }
                        break;
                    case -76759480:
                        if (packageName.equals("br.uol.noticias")) {
                            c10 = 22;
                            break;
                        }
                        break;
                    case -69877540:
                        if (packageName.equals("com.xunmeng.pinduoduo")) {
                            c10 = 23;
                            break;
                        }
                        break;
                    case -30728625:
                        if (packageName.equals("com.tencent.weishi")) {
                            c10 = 24;
                            break;
                        }
                        break;
                    case 10619783:
                        if (packageName.equals("com.twitter.android")) {
                            c10 = 25;
                            break;
                        }
                        break;
                    case 195210534:
                        if (packageName.equals("com.ss.android.article.lite")) {
                            c10 = JSONLexer.EOI;
                            break;
                        }
                        break;
                    case 195266379:
                        if (packageName.equals("com.ss.android.article.news")) {
                            c10 = 27;
                            break;
                        }
                        break;
                    case 313184810:
                        if (packageName.equals("com.ss.android.ugc.aweme")) {
                            c10 = 28;
                            break;
                        }
                        break;
                    case 330586574:
                        if (packageName.equals("com.ss.android.ugc.trill")) {
                            c10 = 29;
                            break;
                        }
                        break;
                    case 361910168:
                        if (packageName.equals("com.tencent.mobileqq")) {
                            c10 = 30;
                            break;
                        }
                        break;
                    case 379189486:
                        if (packageName.equals("com.ss.android.lark")) {
                            c10 = 31;
                            break;
                        }
                        break;
                    case 533559368:
                        if (packageName.equals("com.deezer.analytics")) {
                            c10 = ' ';
                            break;
                        }
                        break;
                    case 578428293:
                        if (packageName.equals("com.google.android.calendar")) {
                            c10 = '!';
                            break;
                        }
                        break;
                    case 613209156:
                        if (packageName.equals("com.spotify.music")) {
                            c10 = '\"';
                            break;
                        }
                        break;
                    case 639310365:
                        if (packageName.equals("com.ubercab")) {
                            c10 = '#';
                            break;
                        }
                        break;
                    case 714499313:
                        if (packageName.equals("com.facebook.katana")) {
                            c10 = '$';
                            break;
                        }
                        break;
                    case 908140028:
                        if (packageName.equals("com.facebook.orca")) {
                            c10 = '%';
                            break;
                        }
                        break;
                    case 979613891:
                        if (packageName.equals("com.Slack")) {
                            c10 = '&';
                            break;
                        }
                        break;
                    case 1153658444:
                        if (packageName.equals("com.linkedin.android")) {
                            c10 = '\'';
                            break;
                        }
                        break;
                    case 1174097286:
                        if (packageName.equals("com.jingdong.app.mall")) {
                            c10 = '(';
                            break;
                        }
                        break;
                    case 1256689897:
                        if (packageName.equals("com.tumblr")) {
                            c10 = ')';
                            break;
                        }
                        break;
                    case 1335515207:
                        if (packageName.equals("com.alibaba.android.rimet")) {
                            c10 = '*';
                            break;
                        }
                        break;
                    case 1515426419:
                        if (packageName.equals("com.google.android.talk")) {
                            c10 = '+';
                            break;
                        }
                        break;
                    case 1536737232:
                        if (packageName.equals("com.sina.weibo")) {
                            c10 = ',';
                            break;
                        }
                        break;
                    case 1779912238:
                        if (packageName.equals("com.ebay.mobile")) {
                            c10 = '-';
                            break;
                        }
                        break;
                    case 1855462465:
                        if (packageName.equals("com.taobao.taobao")) {
                            c10 = '.';
                            break;
                        }
                        break;
                    case 1994036591:
                        if (packageName.equals("tv.danmaku.bili")) {
                            c10 = '/';
                            break;
                        }
                        break;
                    case 2049668591:
                        if (packageName.equals("com.eg.android.AlipayGphone")) {
                            c10 = '0';
                            break;
                        }
                        break;
                    case 2094270320:
                        if (packageName.equals("com.snapchat.android")) {
                            c10 = '1';
                            break;
                        }
                        break;
                }
                switch (c10) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 7:
                    case '\b':
                    case '\t':
                    case '\n':
                    case '\r':
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 25:
                    case 29:
                    case ' ':
                    case '!':
                    case '\"':
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                    case ')':
                    case '+':
                    case '-':
                    case '1':
                        if (nVar.d(statusBarNotification.getPackageName()) && this.f19235d) {
                            i(this.f19232a.get(statusBarNotification.getPackageName()).intValue(), statusBarNotification.getPackageName(), str3, str2);
                            break;
                        }
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 11:
                    case '\f':
                    case 14:
                    case 16:
                    case 17:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 31:
                    case '(':
                    case '*':
                    case ',':
                    case '.':
                    case '/':
                    case '0':
                        if (nVar.d(statusBarNotification.getPackageName()) && !this.f19235d) {
                            i(4, statusBarNotification.getPackageName(), str3, str2);
                            break;
                        }
                        break;
                    case 15:
                    case 30:
                        if (nVar.d(statusBarNotification.getPackageName())) {
                            i(this.f19232a.get(statusBarNotification.getPackageName()).intValue(), statusBarNotification.getPackageName(), str3, str2);
                            break;
                        }
                        break;
                }
                if (Log.isLoggable("NotificationService", 2)) {
                    k.c("NotificationService", "APP推送消息，package:%s,title:%s,content:%s,packageName:%s", statusBarNotification.getPackageName(), str3, str2, str);
                }
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        Notification notification;
        k.c("NotificationService", "onNotificationRemoved sbn = %s", statusBarNotification);
        super.onNotificationRemoved(statusBarNotification);
        if (statusBarNotification != null) {
            List<rk.a> d10 = qk.b.g().d(true);
            if (!d10.isEmpty()) {
                for (int i10 = 0; i10 < d10.size(); i10++) {
                    d10.get(i10).f(statusBarNotification);
                }
            }
            k.a("NotificationService", "onNotificationRemoved");
            String packageName = statusBarNotification.getPackageName();
            packageName.hashCode();
            if (packageName.equals("com.android.dialer") && (notification = statusBarNotification.getNotification()) != null) {
                Bundle bundle = notification.extras;
                String str = "";
                if (bundle != null) {
                    str = bundle.getString("android.title", str);
                }
                g(2, str);
            }
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        f19230e = false;
        k.a("NotificationService", "onUnbind");
        List<rk.a> c10 = qk.b.g().c();
        if (!c10.isEmpty()) {
            for (int i10 = 0; i10 < c10.size(); i10++) {
                c10.get(i10).g(intent);
            }
        }
        return super.onUnbind(intent);
    }
}
