package dh;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import cd.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.map.h;
import com.mobvoi.health.common.data.pojo.SportType;
import dh.d;
import ef.z;
import fg.o;
import fg.p;
import fg.q;
import java.util.List;
/* compiled from: RouteBuildHelper.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: n  reason: collision with root package name */
    private static b f25615n;

    /* renamed from: a  reason: collision with root package name */
    private final Context f25616a = com.mobvoi.android.common.utils.b.e();

    /* renamed from: b  reason: collision with root package name */
    private c f25617b;

    /* renamed from: c  reason: collision with root package name */
    private int f25618c;

    /* renamed from: d  reason: collision with root package name */
    private int f25619d;

    /* renamed from: e  reason: collision with root package name */
    private int f25620e;

    /* renamed from: f  reason: collision with root package name */
    private int f25621f;

    /* renamed from: g  reason: collision with root package name */
    private int f25622g;

    /* renamed from: h  reason: collision with root package name */
    private int f25623h;

    /* renamed from: i  reason: collision with root package name */
    private int f25624i;

    /* renamed from: j  reason: collision with root package name */
    private int f25625j;

    /* renamed from: k  reason: collision with root package name */
    private int f25626k;

    /* renamed from: l  reason: collision with root package name */
    private int f25627l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f25628m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RouteBuildHelper.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25629a;

        static {
            int[] iArr = new int[SportType.values().length];
            f25629a = iArr;
            try {
                iArr[SportType.IndoorRunning.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25629a[SportType.OutdoorRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25629a[SportType.BandRunning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25629a[SportType.AutoRunning.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25629a[SportType.OutdoorWalk.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25629a[SportType.BandAutoWalking.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25629a[SportType.AutoWalking.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25629a[SportType.AutoCycling.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25629a[SportType.OutdoorBike.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private b() {
    }

    private f a(d.c cVar) {
        return new f.a().b(this.f25621f).c(this.f25618c).d(this.f25620e).e(this.f25619d).f(cVar.f25649a).g(cVar.f25650b).h(this.f25622g).j(String.valueOf(cVar.f25651c)).i(this.f25626k).a();
    }

    private void b(h hVar) {
        hVar.clear();
        if (this.f25628m) {
            hVar.l(this.f25623h);
        }
        d d10 = this.f25617b.d();
        List<d.C0274d> list = d10.f25639b;
        if (list != null) {
            k.c("TAG", "route segments count: %d", Integer.valueOf(list.size()));
            for (d.C0274d dVar : d10.f25639b) {
                hVar.i(dVar.f25652a, dVar.f25653b, this.f25627l, 10, dVar.f25654c);
            }
        }
        List<d.c> list2 = d10.f25640c;
        if (list2 != null) {
            k.c("TAG", "route milestone count: %d", Integer.valueOf(list2.size()));
            for (d.c cVar : d10.f25640c) {
                hVar.k(a(cVar));
            }
        }
        d.e eVar = d10.f25641d;
        if (eVar != null) {
            hVar.f(k(eVar), BitmapFactory.decodeResource(this.f25616a.getResources(), q.f26599n2));
        }
        d.a aVar = d10.f25642e;
        if (aVar != null) {
            hVar.h(c(aVar), BitmapFactory.decodeResource(this.f25616a.getResources(), q.f26595m2));
        }
        d.b bVar = d10.f25638a;
        if (bVar != null) {
            double d11 = bVar.f25645a;
            if (d11 != 0.0d) {
                double[] dArr = {0.0d, 0.0d, 0.0d, 0.0d};
                dArr[0] = d11;
                dArr[1] = bVar.f25646b;
                dArr[2] = bVar.f25647c;
                dArr[3] = bVar.f25648d;
                hVar.g(dArr);
            }
        }
    }

    private f c(d.a aVar) {
        return new f.a().f(aVar.f25643a).g(aVar.f25644b).b(this.f25621f).c(this.f25618c).d(this.f25625j).e(this.f25619d).h(this.f25620e).a();
    }

    public static b d() {
        if (f25615n == null) {
            synchronized (b.class) {
                if (f25615n == null) {
                    f25615n = new b();
                }
            }
        }
        return f25615n;
    }

    private void e() {
        Resources resources = this.f25616a.getResources();
        this.f25619d = resources.getColor(17170443);
        this.f25620e = resources.getColor(17170444);
        this.f25623h = resources.getColor(o.M);
        this.f25624i = resources.getColor(o.L);
        this.f25625j = resources.getColor(o.K);
        this.f25622g = resources.getColor(17170443);
        int i10 = p.f26523o;
        this.f25618c = resources.getDimensionPixelSize(i10);
        this.f25621f = resources.getDimensionPixelSize(p.f26525p);
        this.f25626k = resources.getDimensionPixelSize(i10);
        this.f25627l = resources.getDimensionPixelOffset(p.M);
    }

    private int[] g(Resources resources) {
        return new int[]{resources.getColor(o.f26447a0), resources.getColor(o.f26453d0), resources.getColor(o.f26449b0), resources.getColor(o.Z)};
    }

    private int[] h(SportType sportType) {
        switch (a.f25629a[sportType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f25617b.f25630a;
            case 5:
            case 6:
            case 7:
                return this.f25617b.f25631b;
            case 8:
            case 9:
                return this.f25617b.f25632c;
            default:
                return this.f25617b.f25631b;
        }
    }

    private f k(d.e eVar) {
        return new f.a().b(this.f25621f).c(this.f25618c).d(this.f25624i).e(this.f25619d).f(eVar.f25655a).g(eVar.f25656b).a();
    }

    public void f(SportType sportType) {
        c cVar = new c();
        this.f25617b = cVar;
        cVar.g(g(this.f25616a.getResources())).h(h(sportType));
        e();
    }

    public void i(h hVar) {
        if (this.f25617b.e()) {
            b(hVar);
        }
    }

    public void j(List<z> list, h hVar) {
        this.f25617b.f(list);
        if (hVar != null && this.f25617b.e()) {
            b(hVar);
        }
    }
}
