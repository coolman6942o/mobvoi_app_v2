package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class k {

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f2297a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f2298b;

        /* renamed from: c  reason: collision with root package name */
        private final p[] f2299c;

        /* renamed from: d  reason: collision with root package name */
        private final p[] f2300d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f2301e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2302f;

        /* renamed from: g  reason: collision with root package name */
        private final int f2303g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f2304h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f2305i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f2306j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f2307k;

        /* compiled from: NotificationCompat.java */
        /* renamed from: androidx.core.app.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0017a {

            /* renamed from: a  reason: collision with root package name */
            private final IconCompat f2308a;

            /* renamed from: b  reason: collision with root package name */
            private final CharSequence f2309b;

            /* renamed from: c  reason: collision with root package name */
            private final PendingIntent f2310c;

            /* renamed from: d  reason: collision with root package name */
            private boolean f2311d;

            /* renamed from: e  reason: collision with root package name */
            private final Bundle f2312e;

            /* renamed from: f  reason: collision with root package name */
            private ArrayList<p> f2313f;

            /* renamed from: g  reason: collision with root package name */
            private int f2314g;

            /* renamed from: h  reason: collision with root package name */
            private boolean f2315h;

            /* renamed from: i  reason: collision with root package name */
            private boolean f2316i;

            public C0017a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.h(null, "", i10) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false);
            }

            private void d() {
                if (this.f2316i) {
                    Objects.requireNonNull(this.f2310c, "Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0017a a(Bundle bundle) {
                if (bundle != null) {
                    this.f2312e.putAll(bundle);
                }
                return this;
            }

            public C0017a b(p pVar) {
                if (this.f2313f == null) {
                    this.f2313f = new ArrayList<>();
                }
                if (pVar != null) {
                    this.f2313f.add(pVar);
                }
                return this;
            }

            public a c() {
                d();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<p> arrayList3 = this.f2313f;
                if (arrayList3 != null) {
                    Iterator<p> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        p next = it.next();
                        if (next.j()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                p[] pVarArr = null;
                p[] pVarArr2 = arrayList.isEmpty() ? null : (p[]) arrayList.toArray(new p[arrayList.size()]);
                if (!arrayList2.isEmpty()) {
                    pVarArr = (p[]) arrayList2.toArray(new p[arrayList2.size()]);
                }
                return new a(this.f2308a, this.f2309b, this.f2310c, this.f2312e, pVarArr, pVarArr2, this.f2311d, this.f2314g, this.f2315h, this.f2316i);
            }

            private C0017a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, p[] pVarArr, boolean z10, int i10, boolean z11, boolean z12) {
                this.f2311d = true;
                this.f2315h = true;
                this.f2308a = iconCompat;
                this.f2309b = d.d(charSequence);
                this.f2310c = pendingIntent;
                this.f2312e = bundle;
                this.f2313f = pVarArr == null ? null : new ArrayList<>(Arrays.asList(pVarArr));
                this.f2311d = z10;
                this.f2314g = i10;
                this.f2315h = z11;
                this.f2316i = z12;
            }
        }

        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.h(null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f2307k;
        }

        public boolean b() {
            return this.f2301e;
        }

        public p[] c() {
            return this.f2300d;
        }

        public Bundle d() {
            return this.f2297a;
        }

        public IconCompat e() {
            int i10;
            if (this.f2298b == null && (i10 = this.f2305i) != 0) {
                this.f2298b = IconCompat.h(null, "", i10);
            }
            return this.f2298b;
        }

        public p[] f() {
            return this.f2299c;
        }

        public int g() {
            return this.f2303g;
        }

        public boolean h() {
            return this.f2302f;
        }

        public CharSequence i() {
            return this.f2306j;
        }

        public boolean j() {
            return this.f2304h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (p[]) null, (p[]) null, true, 0, true, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, p[] pVarArr, p[] pVarArr2, boolean z10, int i11, boolean z11, boolean z12) {
            this(i10 != 0 ? IconCompat.h(null, "", i10) : null, charSequence, pendingIntent, bundle, pVarArr, pVarArr2, z10, i11, z11, z12);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, p[] pVarArr, p[] pVarArr2, boolean z10, int i10, boolean z11, boolean z12) {
            this.f2302f = true;
            this.f2298b = iconCompat;
            if (iconCompat != null && iconCompat.m() == 2) {
                this.f2305i = iconCompat.i();
            }
            this.f2306j = d.d(charSequence);
            this.f2307k = pendingIntent;
            this.f2297a = bundle == null ? new Bundle() : bundle;
            this.f2299c = pVarArr;
            this.f2300d = pVarArr2;
            this.f2301e = z10;
            this.f2303g = i10;
            this.f2302f = z11;
            this.f2304h = z12;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class b extends e {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f2317e;

        @Override // androidx.core.app.k.e
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f2317e);
            }
        }

        @Override // androidx.core.app.k.e
        public void b(i iVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(iVar.a()).setBigContentTitle(this.f2345b).bigText(this.f2317e);
                if (this.f2347d) {
                    bigText.setSummaryText(this.f2346c);
                }
            }
        }

        @Override // androidx.core.app.k.e
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public b h(CharSequence charSequence) {
            this.f2317e = d.d(charSequence);
            return this;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static final class c {
        public static Notification.BubbleMetadata a(c cVar) {
            return null;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        protected d f2344a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f2345b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f2346c;

        /* renamed from: d  reason: collision with root package name */
        boolean f2347d = false;

        public void a(Bundle bundle) {
            if (this.f2347d) {
                bundle.putCharSequence("android.summaryText", this.f2346c);
            }
            CharSequence charSequence = this.f2345b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c10 = c();
            if (c10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c10);
            }
        }

        public abstract void b(i iVar);

        protected abstract String c();

        public RemoteViews d(i iVar) {
            return null;
        }

        public RemoteViews e(i iVar) {
            return null;
        }

        public RemoteViews f(i iVar) {
            return null;
        }

        public void g(d dVar) {
            if (this.f2344a != dVar) {
                this.f2344a = dVar;
                if (dVar != null) {
                    dVar.w(this);
                }
            }
        }
    }

    static a a(Notification.Action action) {
        p[] pVarArr;
        boolean z10;
        int i10;
        int i11;
        RemoteInput[] remoteInputs = action.getRemoteInputs();
        IconCompat iconCompat = null;
        boolean z11 = false;
        if (remoteInputs == null) {
            pVarArr = null;
        } else {
            p[] pVarArr2 = new p[remoteInputs.length];
            for (int i12 = 0; i12 < remoteInputs.length; i12++) {
                RemoteInput remoteInput = remoteInputs[i12];
                pVarArr2[i12] = new p(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), Build.VERSION.SDK_INT >= 29 ? remoteInput.getEditChoicesBeforeSending() : 0, remoteInput.getExtras(), null);
            }
            pVarArr = pVarArr2;
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 24) {
            z10 = action.getExtras().getBoolean("android.support.allowGeneratedReplies") || action.getAllowGeneratedReplies();
        } else {
            z10 = action.getExtras().getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z12 = z10;
        boolean z13 = action.getExtras().getBoolean("android.support.action.showsUserInterface", true);
        if (i13 >= 28) {
            i10 = action.getSemanticAction();
        } else {
            i10 = action.getExtras().getInt("android.support.action.semanticAction", 0);
        }
        int i14 = i10;
        if (i13 >= 29) {
            z11 = action.isContextual();
        }
        boolean z14 = z11;
        if (i13 < 23) {
            return new a(action.icon, action.title, action.actionIntent, action.getExtras(), pVarArr, (p[]) null, z12, i14, z13, z14);
        }
        if (action.getIcon() == null && (i11 = action.icon) != 0) {
            return new a(i11, action.title, action.actionIntent, action.getExtras(), pVarArr, (p[]) null, z12, i14, z13, z14);
        }
        if (action.getIcon() != null) {
            iconCompat = IconCompat.b(action.getIcon());
        }
        return new a(iconCompat, action.title, action.actionIntent, action.getExtras(), pVarArr, (p[]) null, z12, i14, z13, z14);
    }

    public static Bundle b(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 19) {
            return notification.extras;
        }
        if (i10 >= 16) {
            return m.g(notification);
        }
        return null;
    }

    public static String c(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            return notification.getGroup();
        }
        if (i10 >= 19) {
            return notification.extras.getString("android.support.groupKey");
        }
        if (i10 >= 16) {
            return m.g(notification).getString("android.support.groupKey");
        }
        return null;
    }

    public static boolean d(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            return (notification.flags & 256) != 0;
        }
        if (i10 >= 19) {
            return notification.extras.getBoolean("android.support.localOnly");
        }
        if (i10 >= 16) {
            return m.g(notification).getBoolean("android.support.localOnly");
        }
        return false;
    }

    static Notification[] e(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i10 = 0; i10 < parcelableArray.length; i10++) {
            notificationArr[i10] = (Notification) parcelableArray[i10];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static String f(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            return notification.getSortKey();
        }
        if (i10 >= 19) {
            return notification.extras.getString("android.support.sortKey");
        }
        if (i10 >= 16) {
            return m.g(notification).getString("android.support.sortKey");
        }
        return null;
    }

    public static boolean g(Notification notification) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 20) {
            return (notification.flags & 512) != 0;
        }
        if (i10 >= 19) {
            return notification.extras.getBoolean("android.support.isGroupSummary");
        }
        if (i10 >= 16) {
            return m.g(notification).getBoolean("android.support.isGroupSummary");
        }
        return false;
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f2348a;

        /* renamed from: b  reason: collision with root package name */
        private int f2349b;

        /* renamed from: c  reason: collision with root package name */
        private PendingIntent f2350c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Notification> f2351d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f2352e;

        /* renamed from: f  reason: collision with root package name */
        private int f2353f;

        /* renamed from: g  reason: collision with root package name */
        private int f2354g;

        /* renamed from: h  reason: collision with root package name */
        private int f2355h;

        /* renamed from: i  reason: collision with root package name */
        private int f2356i;

        /* renamed from: j  reason: collision with root package name */
        private int f2357j;

        /* renamed from: k  reason: collision with root package name */
        private int f2358k;

        /* renamed from: l  reason: collision with root package name */
        private int f2359l;

        /* renamed from: m  reason: collision with root package name */
        private String f2360m;

        /* renamed from: n  reason: collision with root package name */
        private String f2361n;

        public f() {
            this.f2348a = new ArrayList<>();
            this.f2349b = 1;
            this.f2351d = new ArrayList<>();
            this.f2354g = 8388613;
            this.f2355h = -1;
            this.f2356i = 0;
            this.f2358k = 80;
        }

        public f a(a aVar) {
            this.f2348a.add(aVar);
            return this;
        }

        public f b() {
            this.f2348a.clear();
            return this;
        }

        /* renamed from: c */
        public f clone() {
            f fVar = new f();
            fVar.f2348a = new ArrayList<>(this.f2348a);
            fVar.f2349b = this.f2349b;
            fVar.f2350c = this.f2350c;
            fVar.f2351d = new ArrayList<>(this.f2351d);
            fVar.f2352e = this.f2352e;
            fVar.f2353f = this.f2353f;
            fVar.f2354g = this.f2354g;
            fVar.f2355h = this.f2355h;
            fVar.f2356i = this.f2356i;
            fVar.f2357j = this.f2357j;
            fVar.f2358k = this.f2358k;
            fVar.f2359l = this.f2359l;
            fVar.f2360m = this.f2360m;
            fVar.f2361n = this.f2361n;
            return fVar;
        }

        public f(Notification notification) {
            this.f2348a = new ArrayList<>();
            this.f2349b = 1;
            this.f2351d = new ArrayList<>();
            this.f2354g = 8388613;
            this.f2355h = -1;
            this.f2356i = 0;
            this.f2358k = 80;
            Bundle b10 = k.b(notification);
            Bundle bundle = b10 != null ? b10.getBundle("android.wearable.EXTENSIONS") : null;
            if (bundle != null) {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("actions");
                if (Build.VERSION.SDK_INT >= 16 && parcelableArrayList != null) {
                    int size = parcelableArrayList.size();
                    a[] aVarArr = new a[size];
                    for (int i10 = 0; i10 < size; i10++) {
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 20) {
                            aVarArr[i10] = k.a((Notification.Action) parcelableArrayList.get(i10));
                        } else if (i11 >= 16) {
                            aVarArr[i10] = m.d((Bundle) parcelableArrayList.get(i10));
                        }
                    }
                    Collections.addAll(this.f2348a, aVarArr);
                }
                this.f2349b = bundle.getInt("flags", 1);
                this.f2350c = (PendingIntent) bundle.getParcelable("displayIntent");
                Notification[] e10 = k.e(bundle, "pages");
                if (e10 != null) {
                    Collections.addAll(this.f2351d, e10);
                }
                this.f2352e = (Bitmap) bundle.getParcelable("background");
                this.f2353f = bundle.getInt("contentIcon");
                this.f2354g = bundle.getInt("contentIconGravity", 8388613);
                this.f2355h = bundle.getInt("contentActionIndex", -1);
                this.f2356i = bundle.getInt("customSizePreset", 0);
                this.f2357j = bundle.getInt("customContentHeight");
                this.f2358k = bundle.getInt("gravity", 80);
                this.f2359l = bundle.getInt("hintScreenTimeout");
                this.f2360m = bundle.getString("dismissalId");
                this.f2361n = bundle.getString("bridgeTag");
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        c R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;

        /* renamed from: a  reason: collision with root package name */
        public Context f2318a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f2319b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<o> f2320c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f2321d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f2322e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f2323f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f2324g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f2325h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f2326i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f2327j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f2328k;

        /* renamed from: l  reason: collision with root package name */
        int f2329l;

        /* renamed from: m  reason: collision with root package name */
        int f2330m;

        /* renamed from: n  reason: collision with root package name */
        boolean f2331n;

        /* renamed from: o  reason: collision with root package name */
        boolean f2332o;

        /* renamed from: p  reason: collision with root package name */
        e f2333p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f2334q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f2335r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f2336s;

        /* renamed from: t  reason: collision with root package name */
        int f2337t;

        /* renamed from: u  reason: collision with root package name */
        int f2338u;

        /* renamed from: v  reason: collision with root package name */
        boolean f2339v;

        /* renamed from: w  reason: collision with root package name */
        String f2340w;

        /* renamed from: x  reason: collision with root package name */
        boolean f2341x;

        /* renamed from: y  reason: collision with root package name */
        String f2342y;

        /* renamed from: z  reason: collision with root package name */
        boolean f2343z;

        public d(Context context, String str) {
            this.f2319b = new ArrayList<>();
            this.f2320c = new ArrayList<>();
            this.f2321d = new ArrayList<>();
            this.f2331n = true;
            this.f2343z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.f2318a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.f2330m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void n(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.S;
                notification.flags = i10 | notification.flags;
                return;
            }
            Notification notification2 = this.S;
            notification2.flags = (~i10) & notification2.flags;
        }

        public d a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f2319b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public Notification b() {
            return new l(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public d e(boolean z10) {
            n(16, z10);
            return this;
        }

        public d f(String str) {
            this.C = str;
            return this;
        }

        public d g(String str) {
            this.K = str;
            return this;
        }

        public d h(int i10) {
            this.E = i10;
            return this;
        }

        public d i(PendingIntent pendingIntent) {
            this.f2324g = pendingIntent;
            return this;
        }

        public d j(CharSequence charSequence) {
            this.f2323f = d(charSequence);
            return this;
        }

        public d k(CharSequence charSequence) {
            this.f2322e = d(charSequence);
            return this;
        }

        public d l(int i10) {
            Notification notification = this.S;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public d m(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public d o(PendingIntent pendingIntent, boolean z10) {
            this.f2325h = pendingIntent;
            n(128, z10);
            return this;
        }

        public d p(boolean z10) {
            this.f2343z = z10;
            return this;
        }

        public d q(boolean z10) {
            n(2, z10);
            return this;
        }

        public d r(boolean z10) {
            n(8, z10);
            return this;
        }

        public d s(int i10) {
            this.f2330m = i10;
            return this;
        }

        public d t(int i10, int i11, boolean z10) {
            this.f2337t = i10;
            this.f2338u = i11;
            this.f2339v = z10;
            return this;
        }

        public d u(int i10) {
            this.S.icon = i10;
            return this;
        }

        public d v(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public d w(e eVar) {
            if (this.f2333p != eVar) {
                this.f2333p = eVar;
                if (eVar != null) {
                    eVar.g(this);
                }
            }
            return this;
        }

        public d x(CharSequence charSequence) {
            this.S.tickerText = d(charSequence);
            return this;
        }

        public d y(long j10) {
            this.N = j10;
            return this;
        }

        public d z(long j10) {
            this.S.when = j10;
            return this;
        }

        @Deprecated
        public d(Context context) {
            this(context, null);
        }
    }
}
