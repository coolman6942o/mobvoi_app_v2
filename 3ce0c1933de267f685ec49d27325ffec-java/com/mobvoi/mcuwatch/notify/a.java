package com.mobvoi.mcuwatch.notify;

import android.app.Application;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.LruCache;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.model.NotificationData;
import io.j;
import java.util.Map;
import kc.c;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.jvm.internal.i;
/* compiled from: ApolloNotificationChannel.kt */
/* loaded from: classes2.dex */
public final class a extends rk.a {

    /* renamed from: a  reason: collision with root package name */
    private final C0224a f19236a = new C0224a();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Integer> f19237b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f19238c;

    /* renamed from: d  reason: collision with root package name */
    private r f19239d;

    /* compiled from: ApolloNotificationChannel.kt */
    /* renamed from: com.mobvoi.mcuwatch.notify.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0224a extends LruCache<String, Pair<? extends String, ? extends String>> {
        C0224a() {
            super(20);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public Pair<String, String> create(String packageName) {
            String str;
            i.f(packageName, "packageName");
            PackageManager packageManager = b.e().getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
                i.e(applicationInfo, "packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)");
                str = applicationInfo.loadLabel(packageManager).toString();
            } catch (Exception e10) {
                k.a("ApolloNotification", "获取" + packageName + "包信息异常，无法获取应用名称; " + ((Object) e10.getMessage()));
                str = (String) a.this.f19238c.get(packageName);
                if (str == null) {
                    str = "";
                }
            }
            return j.a(str, null);
        }
    }

    public a() {
        Map<String, String> h10;
        h10 = d0.h(new Pair("com.tencent.mobileqq", "QQ"), new Pair("com.tencent.mm", "微信"), new Pair("com.sina.weibo", "微博"), new Pair("com.ss.android.ugc.aweme", "抖音"), new Pair("com.smile.gifmake", "快手"), new Pair("com.ss.android.article.news", "今日头条"), new Pair("com.eg.android.AlipayGphone", "支付宝"), new Pair("com.taobao.taobao", "淘宝"), new Pair("com.jingdong.app.mall", "京东"), new Pair("com.alibaba.android.rimet", "钉钉"), new Pair("com.ss.android.lark", "飞书"), new Pair("com.sdu.didi.psnger", "滴滴出行"), new Pair("com.dianping.v1", "大众点评"), new Pair("tv.danmaku.bili", "哔哩哔哩"), new Pair("com.xingin.xhs", "小红书"), new Pair("com.xunmeng.pinduoduo", "拼多多"), new Pair("com.qiyi.video", "爱奇艺"), new Pair("com.tencent.weishi", "微视"), new Pair("com.sankuai.meituan", "美团"), new Pair("me.ele", "饿了么"));
        this.f19238c = h10;
    }

    @Override // rk.a
    public void a(Intent intent) {
    }

    @Override // rk.a
    public void b(NotificationListenerService notificationListenerService) {
        Map<String, Integer> map = null;
        NotificationService notificationService = notificationListenerService instanceof NotificationService ? (NotificationService) notificationListenerService : null;
        if (notificationService != null) {
            map = notificationService.f19232a;
        }
        if (map == null) {
            map = d0.e();
        }
        this.f19237b = map;
        Application e10 = b.e();
        i.e(e10, "getApplication()");
        this.f19239d = new r(e10);
    }

    @Override // rk.a
    public void c() {
    }

    @Override // rk.a
    public void d() {
    }

    @Override // rk.a
    public void e(StatusBarNotification statusBarNotification) {
        Notification notification = statusBarNotification == null ? null : statusBarNotification.getNotification();
        if (notification != null && notification.extras != null) {
            int i10 = 0;
            if (!(r.f15521b.a().length() == 0)) {
                r rVar = this.f19239d;
                if (rVar == null) {
                    i.u("apolloPrefs");
                    throw null;
                } else if (rVar.h()) {
                    String packageName = statusBarNotification.getPackageName();
                    if (this.f19238c.keySet().contains(packageName)) {
                        r rVar2 = this.f19239d;
                        if (rVar2 != null) {
                            i.e(packageName, "packageName");
                            if (rVar2.i(packageName)) {
                                String title = notification.extras.getString("android.title", "");
                                String content = notification.extras.getString("android.text", "");
                                Pair<? extends String, ? extends String> pair = this.f19236a.get(packageName);
                                String first = pair.getFirst();
                                String second = pair.getSecond();
                                Map<String, Integer> map = this.f19237b;
                                if (map != null) {
                                    Integer num = map.get(packageName);
                                    if (num != null) {
                                        i10 = num.intValue();
                                    }
                                    i.e(title, "title");
                                    i.e(content, "content");
                                    NotificationData notificationData = new NotificationData(title, content, first, System.currentTimeMillis(), second, i10);
                                    q qVar = q.f15504a;
                                    qVar.O(notificationData);
                                    if (!qVar.B()) {
                                        r rVar3 = this.f19239d;
                                        if (rVar3 == null) {
                                            i.u("apolloPrefs");
                                            throw null;
                                        } else if (rVar3.m()) {
                                            r rVar4 = this.f19239d;
                                            if (rVar4 == null) {
                                                i.u("apolloPrefs");
                                                throw null;
                                            } else if (rVar4.k(packageName)) {
                                                String c10 = c.c(notificationData);
                                                i.e(c10, "toJSONString(data)");
                                                com.mobvoi.apollo.mqtt.b.d(c10);
                                            }
                                        }
                                    }
                                } else {
                                    i.u("appTypeMap");
                                    throw null;
                                }
                            }
                        } else {
                            i.u("apolloPrefs");
                            throw null;
                        }
                    }
                }
            }
        }
    }

    @Override // rk.a
    public void f(StatusBarNotification statusBarNotification) {
    }

    @Override // rk.a
    public void g(Intent intent) {
    }
}
