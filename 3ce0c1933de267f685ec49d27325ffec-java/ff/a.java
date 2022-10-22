package ff;

import com.mobvoi.fitness.core.data.pojo.SportDataType;
import ef.c;
import ef.d;
import ef.e;
import ef.g;
import ef.h;
import ef.i;
import ef.j;
import ef.m;
import ef.n;
import ef.u;
import ef.v;
import ef.w;
/* compiled from: SummaryCalculator.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private double f26421a;

    /* renamed from: b  reason: collision with root package name */
    private double f26422b;

    /* renamed from: c  reason: collision with root package name */
    private int f26423c;

    /* renamed from: d  reason: collision with root package name */
    private u f26424d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryCalculator.java */
    /* renamed from: ff.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0287a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26425a;

        static {
            int[] iArr = new int[SportDataType.values().length];
            f26425a = iArr;
            try {
                iArr[SportDataType.Distance.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26425a[SportDataType.Calorie.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26425a[SportDataType.HeartRate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26425a[SportDataType.Steps.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26425a[SportDataType.Group.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26425a[SportDataType.Duration.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26425a[SportDataType.Lap.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26425a[SportDataType.SwimPoints.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26425a[SportDataType.Elevation.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26425a[SportDataType.HiitStages.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26425a[SportDataType.HiitTypeTimes.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f26425a[SportDataType.SportActionTimes.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public a() {
        d();
    }

    private int a(int i10) {
        if (i10 > 0) {
            double d10 = this.f26422b + i10;
            this.f26422b = d10;
            int i11 = this.f26423c + 1;
            this.f26423c = i11;
            this.f26421a = d10 / i11;
        }
        return (int) this.f26421a;
    }

    public u b() {
        return this.f26424d;
    }

    public boolean c(n nVar) {
        boolean z10 = true;
        switch (C0287a.f26425a[nVar.f25944a.ordinal()]) {
            case 1:
                this.f26424d.f25992k = Math.round(((c) nVar).a());
                break;
            case 2:
                this.f26424d.f25993l = ((ef.a) nVar).a();
                break;
            case 3:
                this.f26424d.f25994m = a(((g) nVar).a());
                break;
            case 4:
                this.f26424d.f25995n = ((v) nVar).a();
                break;
            case 5:
                this.f26424d.f26007z.clear();
                this.f26424d.f26007z.addAll(((e) nVar).f25916c);
                break;
            case 6:
                break;
            case 7:
                j jVar = (j) nVar;
                this.f26424d.f26004w = jVar.a();
                this.f26424d.f26003v = jVar.c();
                this.f26424d.f26005x = jVar.b();
                break;
            case 8:
                u uVar = this.f26424d;
                w wVar = (w) nVar;
                uVar.B = wVar.f26009e;
                uVar.C = wVar.f26011g;
                break;
            case 9:
                d dVar = (d) nVar;
                this.f26424d.f25997p = dVar.c();
                this.f26424d.f25998q = dVar.d();
                this.f26424d.f26000s = dVar.a();
                this.f26424d.f25999r = dVar.b();
                break;
            case 10:
                h hVar = (h) nVar;
                u uVar2 = this.f26424d;
                uVar2.E = hVar.f25938c;
                uVar2.l(hVar.f25941f);
                break;
            case 11:
                this.f26424d.m((i) nVar);
                break;
            case 12:
                this.f26424d.H = ((m) nVar).a();
                break;
            default:
                z10 = false;
                break;
        }
        if (z10) {
            long j10 = nVar.f25945b;
            u uVar3 = this.f26424d;
            if (j10 > uVar3.f25991j) {
                uVar3.f25991j = j10;
            }
        }
        return z10;
    }

    public void d() {
        this.f26424d = new u("");
        this.f26421a = 0.0d;
        this.f26423c = 0;
        this.f26422b = 0.0d;
    }
}
