package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.collection.b;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import g0.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatBuilder.java */
/* loaded from: classes.dex */
public class l implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Notification.Builder f2362a;

    /* renamed from: b  reason: collision with root package name */
    private final k.d f2363b;

    /* renamed from: c  reason: collision with root package name */
    private RemoteViews f2364c;

    /* renamed from: d  reason: collision with root package name */
    private RemoteViews f2365d;

    /* renamed from: e  reason: collision with root package name */
    private final List<Bundle> f2366e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f2367f = new Bundle();

    /* renamed from: g  reason: collision with root package name */
    private int f2368g;

    /* renamed from: h  reason: collision with root package name */
    private RemoteViews f2369h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k.d dVar) {
        int i10;
        Icon icon;
        List<String> list;
        List<String> e10;
        this.f2363b = dVar;
        Context context = dVar.f2318a;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f2362a = new Notification.Builder(dVar.f2318a, dVar.K);
        } else {
            this.f2362a = new Notification.Builder(dVar.f2318a);
        }
        Notification notification = dVar.S;
        this.f2362a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, dVar.f2326i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(dVar.f2322e).setContentText(dVar.f2323f).setContentInfo(dVar.f2328k).setContentIntent(dVar.f2324g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(dVar.f2325h, (notification.flags & 128) != 0).setLargeIcon(dVar.f2327j).setNumber(dVar.f2329l).setProgress(dVar.f2337t, dVar.f2338u, dVar.f2339v);
        if (i11 < 21) {
            this.f2362a.setSound(notification.sound, notification.audioStreamType);
        }
        if (i11 >= 16) {
            this.f2362a.setSubText(dVar.f2334q).setUsesChronometer(dVar.f2332o).setPriority(dVar.f2330m);
            Iterator<k.a> it = dVar.f2319b.iterator();
            while (it.hasNext()) {
                b(it.next());
            }
            Bundle bundle = dVar.D;
            if (bundle != null) {
                this.f2367f.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (dVar.f2343z) {
                    this.f2367f.putBoolean("android.support.localOnly", true);
                }
                String str = dVar.f2340w;
                if (str != null) {
                    this.f2367f.putString("android.support.groupKey", str);
                    if (dVar.f2341x) {
                        this.f2367f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f2367f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = dVar.f2342y;
                if (str2 != null) {
                    this.f2367f.putString("android.support.sortKey", str2);
                }
            }
            this.f2364c = dVar.H;
            this.f2365d = dVar.I;
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 17) {
            this.f2362a.setShowWhen(dVar.f2331n);
        }
        if (i12 >= 19 && i12 < 21 && (e10 = e(f(dVar.f2320c), dVar.V)) != null && !e10.isEmpty()) {
            this.f2367f.putStringArray("android.people", (String[]) e10.toArray(new String[e10.size()]));
        }
        if (i12 >= 20) {
            this.f2362a.setLocalOnly(dVar.f2343z).setGroup(dVar.f2340w).setGroupSummary(dVar.f2341x).setSortKey(dVar.f2342y);
            this.f2368g = dVar.O;
        }
        if (i12 >= 21) {
            this.f2362a.setCategory(dVar.C).setColor(dVar.E).setVisibility(dVar.F).setPublicVersion(dVar.G).setSound(notification.sound, notification.audioAttributes);
            if (i12 < 28) {
                list = e(f(dVar.f2320c), dVar.V);
            } else {
                list = dVar.V;
            }
            if (list != null && !list.isEmpty()) {
                for (String str3 : list) {
                    this.f2362a.addPerson(str3);
                }
            }
            this.f2369h = dVar.J;
            if (dVar.f2321d.size() > 0) {
                Bundle bundle2 = dVar.c().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i13 = 0; i13 < dVar.f2321d.size(); i13++) {
                    bundle4.putBundle(Integer.toString(i13), m.f(dVar.f2321d.get(i13)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                dVar.c().putBundle("android.car.EXTENSIONS", bundle2);
                this.f2367f.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 23 && (icon = dVar.U) != null) {
            this.f2362a.setSmallIcon(icon);
        }
        if (i14 >= 24) {
            this.f2362a.setExtras(dVar.D).setRemoteInputHistory(dVar.f2336s);
            RemoteViews remoteViews = dVar.H;
            if (remoteViews != null) {
                this.f2362a.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = dVar.I;
            if (remoteViews2 != null) {
                this.f2362a.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = dVar.J;
            if (remoteViews3 != null) {
                this.f2362a.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i14 >= 26) {
            this.f2362a.setBadgeIconType(dVar.L).setSettingsText(dVar.f2335r).setShortcutId(dVar.M).setTimeoutAfter(dVar.N).setGroupAlertBehavior(dVar.O);
            if (dVar.B) {
                this.f2362a.setColorized(dVar.A);
            }
            if (!TextUtils.isEmpty(dVar.K)) {
                this.f2362a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator<o> it2 = dVar.f2320c.iterator();
            while (it2.hasNext()) {
                this.f2362a.addPerson(it2.next().h());
            }
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 29) {
            this.f2362a.setAllowSystemGeneratedContextualActions(dVar.Q);
            this.f2362a.setBubbleMetadata(k.c.a(dVar.R));
        }
        if (a.c() && (i10 = dVar.P) != 0) {
            this.f2362a.setForegroundServiceBehavior(i10);
        }
        if (dVar.T) {
            if (this.f2363b.f2341x) {
                this.f2368g = 2;
            } else {
                this.f2368g = 1;
            }
            this.f2362a.setVibrate(null);
            this.f2362a.setSound(null);
            int i16 = notification.defaults & (-2);
            notification.defaults = i16;
            int i17 = i16 & (-3);
            notification.defaults = i17;
            this.f2362a.setDefaults(i17);
            if (i15 >= 26) {
                if (TextUtils.isEmpty(this.f2363b.f2340w)) {
                    this.f2362a.setGroup("silent");
                }
                this.f2362a.setGroupAlertBehavior(this.f2368g);
            }
        }
    }

    private void b(k.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            IconCompat e10 = aVar.e();
            if (i10 >= 23) {
                builder = new Notification.Action.Builder(e10 != null ? e10.t() : null, aVar.i(), aVar.a());
            } else {
                builder = new Notification.Action.Builder(e10 != null ? e10.i() : 0, aVar.i(), aVar.a());
            }
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : p.b(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (i11 >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (i11 >= 29) {
                builder.setContextual(aVar.j());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.h());
            builder.addExtras(bundle);
            this.f2362a.addAction(builder.build());
        } else if (i10 >= 16) {
            this.f2366e.add(m.j(this.f2362a, aVar));
        }
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<o> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (o oVar : list) {
            arrayList.add(oVar.g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i10 = notification.defaults & (-2);
        notification.defaults = i10;
        notification.defaults = i10 & (-3);
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.f2362a;
    }

    public Notification c() {
        Bundle b10;
        RemoteViews f10;
        RemoteViews d10;
        k.e eVar = this.f2363b.f2333p;
        if (eVar != null) {
            eVar.b(this);
        }
        RemoteViews e10 = eVar != null ? eVar.e(this) : null;
        Notification d11 = d();
        if (e10 != null) {
            d11.contentView = e10;
        } else {
            RemoteViews remoteViews = this.f2363b.H;
            if (remoteViews != null) {
                d11.contentView = remoteViews;
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (!(i10 < 16 || eVar == null || (d10 = eVar.d(this)) == null)) {
            d11.bigContentView = d10;
        }
        if (!(i10 < 21 || eVar == null || (f10 = this.f2363b.f2333p.f(this)) == null)) {
            d11.headsUpContentView = f10;
        }
        if (!(i10 < 16 || eVar == null || (b10 = k.b(d11)) == null)) {
            eVar.a(b10);
        }
        return d11;
    }

    protected Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f2362a.build();
        }
        if (i10 >= 24) {
            Notification build = this.f2362a.build();
            if (this.f2368g != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f2368g != 2)) {
                    g(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f2368g == 1) {
                    g(build);
                }
            }
            return build;
        } else if (i10 >= 21) {
            this.f2362a.setExtras(this.f2367f);
            Notification build2 = this.f2362a.build();
            RemoteViews remoteViews = this.f2364c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f2365d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f2369h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f2368g != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f2368g != 2)) {
                    g(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f2368g == 1) {
                    g(build2);
                }
            }
            return build2;
        } else if (i10 >= 20) {
            this.f2362a.setExtras(this.f2367f);
            Notification build3 = this.f2362a.build();
            RemoteViews remoteViews4 = this.f2364c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f2365d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f2368g != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f2368g != 2)) {
                    g(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f2368g == 1) {
                    g(build3);
                }
            }
            return build3;
        } else if (i10 >= 19) {
            SparseArray<Bundle> a10 = m.a(this.f2366e);
            if (a10 != null) {
                this.f2367f.putSparseParcelableArray("android.support.actionExtras", a10);
            }
            this.f2362a.setExtras(this.f2367f);
            Notification build4 = this.f2362a.build();
            RemoteViews remoteViews6 = this.f2364c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f2365d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        } else if (i10 < 16) {
            return this.f2362a.getNotification();
        } else {
            Notification build5 = this.f2362a.build();
            Bundle b10 = k.b(build5);
            Bundle bundle = new Bundle(this.f2367f);
            for (String str : this.f2367f.keySet()) {
                if (b10.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            b10.putAll(bundle);
            SparseArray<Bundle> a11 = m.a(this.f2366e);
            if (a11 != null) {
                k.b(build5).putSparseParcelableArray("android.support.actionExtras", a11);
            }
            RemoteViews remoteViews8 = this.f2364c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.f2365d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
    }
}
