package zg;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.companion.map.i;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.sport.view.HeartRateView;
import com.mobvoi.health.companion.sport.view.PercentView;
import com.mobvoi.health.companion.sport.view.TrainingView;
import com.mobvoi.wear.util.UnitsUtility;
import eh.d;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.List;
import lf.c;
import nf.e;
import nf.f;
import nf.g;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
/* compiled from: McuHealthSportDetailFragment.java */
/* loaded from: classes2.dex */
public class a0 extends e implements f<d>, View.OnClickListener {
    private TextView A;
    private RelativeLayout B;
    private HeartRateView C;
    private TextView D;
    private TextView E;
    private ImageView F;
    private PercentView G;
    private TrainingView H;
    private RelativeLayout I;
    private TextView J;
    private Dialog L;
    private Dialog M;
    private d O;
    private View P;
    private View Q;
    private ViewGroup R;
    private i S;
    private dh.a T;
    private RelativeLayout U;
    private TextView V;
    private View W;

    /* renamed from: d  reason: collision with root package name */
    private TextView f37409d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f37410e;

    /* renamed from: f  reason: collision with root package name */
    private String f37411f;

    /* renamed from: g  reason: collision with root package name */
    private SportType f37412g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f37413h;

    /* renamed from: i  reason: collision with root package name */
    private int f37414i;

    /* renamed from: j  reason: collision with root package name */
    private SwipeRefreshLayout f37415j;

    /* renamed from: j0  reason: collision with root package name */
    private TextView f37416j0;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f37417k;

    /* renamed from: k0  reason: collision with root package name */
    private int f37418k0;

    /* renamed from: l  reason: collision with root package name */
    private TextView f37419l;

    /* renamed from: l0  reason: collision with root package name */
    private int f37420l0;

    /* renamed from: m  reason: collision with root package name */
    private TextView f37421m;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f37422m0;

    /* renamed from: n  reason: collision with root package name */
    private TextView f37423n;

    /* renamed from: n0  reason: collision with root package name */
    private int f37424n0;

    /* renamed from: o  reason: collision with root package name */
    private TextView f37425o;

    /* renamed from: o0  reason: collision with root package name */
    private TextView f37426o0;

    /* renamed from: p  reason: collision with root package name */
    private TextView f37427p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f37428q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f37429r;

    /* renamed from: s  reason: collision with root package name */
    private ImageView f37430s;

    /* renamed from: t  reason: collision with root package name */
    private RelativeLayout f37431t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f37432u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f37433v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f37434w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f37435x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f37436y;

    /* renamed from: z  reason: collision with root package name */
    private TextView f37437z;
    private m K = new m();
    private ef.f N = new ef.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: McuHealthSportDetailFragment.java */
    /* loaded from: classes2.dex */
    public class a extends dg.a {
        a() {
        }

        @Override // dg.a
        public void a(View view) {
            zg.b.s0(a0.this.getFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: McuHealthSportDetailFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37439a;

        static {
            int[] iArr = new int[SportType.values().length];
            f37439a = iArr;
            try {
                iArr[SportType.OutdoorRunning.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37439a[SportType.BandRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37439a[SportType.AutoRunning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37439a[SportType.IndoorRunning.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37439a[SportType.BandAutoWalking.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37439a[SportType.AutoWalking.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37439a[SportType.OutdoorWalk.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37439a[SportType.AutoCycling.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37439a[SportType.OutdoorBike.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37439a[SportType.AutoSwimming.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f37439a[SportType.Swimming.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f37439a[SportType.FreeWorkout.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f37439a[SportType.IndoorCycling.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f37439a[SportType.RowingMachine.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f37439a[SportType.RopeSkipping.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f37439a[SportType.Yoga.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f37439a[SportType.Badminton.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f37439a[SportType.TableTennis.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f37439a[SportType.Tennis.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f37439a[SportType.Baseball.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f37439a[SportType.Volleyball.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f37439a[SportType.Cricket.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f37439a[SportType.Rugby.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f37439a[SportType.Hockey.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f37439a[SportType.Dance.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f37439a[SportType.AbdominalCurl.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f37439a[SportType.JumpingJack.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    private void A0(int i10) {
        String str;
        Dialog dialog = new Dialog(requireActivity());
        this.L = dialog;
        dialog.requestWindowFeature(1);
        this.L.setContentView(t.f26831e);
        this.L.getWindow().setBackgroundDrawableResource(q.f26548b);
        this.L.setCancelable(false);
        Resources resources = getResources();
        String str2 = null;
        if (i10 == s.f26797v4) {
            str2 = resources.getString(u.f26991w4);
            str = getString(u.f26985v4, getString(u.F4), getString(u.G4), getString(u.R4), getString(u.Q4), getString(u.f26997x4), getString(u.f27003y4), getString(u.H4), getString(u.I4));
        } else if (i10 == s.f26811x4) {
            str2 = resources.getString(u.f27009z4);
            str = getString(u.A4, getString(u.D4), getString(u.E4), getString(u.C4), getString(u.P4));
        } else if (i10 == s.F4) {
            str2 = resources.getString(u.J4);
            str = getString(u.O4, getString(u.K4), getString(u.L4), getString(u.M4), getString(u.N4));
        } else {
            str = null;
        }
        ((TextView) this.L.findViewById(s.f26687f5)).setText(str2);
        ((TextView) this.L.findViewById(s.Z)).setText(Html.fromHtml(str));
        this.L.findViewById(s.W).setOnClickListener(this);
        this.L.show();
    }

    private void B0(ef.u uVar) {
        if (!this.f37422m0) {
            SportDataType sportDataType = uVar.f25987f;
            this.f37435x.setText(c.d(sportDataType, uVar.f25986e, this.f37413h));
            this.f37437z.setText(c.a(getResources(), this.f37413h, sportDataType));
        }
    }

    private void l0() {
        if (com.mobvoi.health.companion.system.c.a().p()) {
            this.P.setVisibility(8);
            this.Q.setVisibility(8);
        }
        if (this.f37422m0) {
            this.f37435x.setVisibility(8);
            this.f37436y.setVisibility(8);
            this.f37437z.setVisibility(8);
            this.B.setVisibility(8);
            this.F.setVisibility(8);
        }
        this.I.setVisibility(8);
        switch (b.f37439a[this.f37412g.ordinal()]) {
            case 10:
            case 11:
                this.f37426o0.setText(u.f26971t2);
                this.f37421m.setText(String.valueOf(this.f37424n0));
                break;
            case 12:
            case 13:
            case 14:
                this.f37431t.setVisibility(8);
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                this.f37421m.setText("");
                this.f37426o0.setText(u.f26971t2);
                break;
        }
        this.f37417k.setImageResource(com.mobvoi.health.companion.sport.view.a.d().e(this.f37412g).f18993b);
    }

    private void m0() {
        SportType sportType = this.f37412g;
        if (sportType != null && sportType.supportGps()) {
            this.T = new dh.a(requireActivity().getApplicationContext(), this.S, this.f37412g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(Iterable iterable) {
        this.f37415j.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(h hVar, List list) {
        boolean e10 = bh.f.e(list);
        List<xf.h> arrayList = new ArrayList<>();
        if (!e10) {
            arrayList.addAll(list);
            arrayList = lf.a.b(arrayList, this.f37420l0, this.N);
        }
        HeartRateView heartRateView = this.C;
        int i10 = this.f37420l0;
        ef.f fVar = this.N;
        heartRateView.k(arrayList, i10, fVar.f25926j, fVar.f25927k, fVar.f25923g, fVar.f25922f, this.f37418k0);
        this.A.setText(e10 ? getString(u.K2) : getString(u.J2, Integer.valueOf(this.N.f25925i)));
        this.D.setText(e10 ? getString(u.M2) : getString(u.L2, Integer.valueOf(this.N.f25924h)));
        if (this.f37412g == SportType.Swimming) {
            int size = arrayList.size();
            float f10 = 0.0f;
            for (xf.h hVar2 : arrayList) {
                f10 += hVar2.f36543b;
            }
            this.f37424n0 = (int) (f10 / size);
        }
        TextView textView = this.E;
        int i11 = this.f37424n0;
        textView.setText(i11 <= 0 ? getString(u.G2) : getString(u.F2, Integer.valueOf(i11)));
        SportType sportType = this.f37412g;
        if (sportType == SportType.RopeSkipping || sportType == SportType.Swimming || sportType == SportType.AutoSwimming || sportType == SportType.Yoga) {
            this.f37419l.setText(String.valueOf(this.f37424n0));
            this.f37421m.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(h hVar, ef.u uVar) {
        this.f37418k0 = bh.f.a((int) Math.ceil(UnitsUtility.Time.ms2min(uVar.f25991j)));
        bh.f.f(requireContext(), this.f37409d, this.f37410e, this.f37412g, uVar);
        TextView textView = this.f37419l;
        SportDataType sportDataType = SportDataType.Distance;
        textView.setText(c.d(sportDataType, uVar.f25992k, this.f37413h));
        this.f37421m.setText(c.a(getResources(), this.f37413h, sportDataType));
        this.f37414i = uVar.f25992k;
        int i10 = uVar.f25985d.typeCode;
        SportType sportType = SportType.Swimming;
        if (i10 == sportType.typeCode) {
            TextView textView2 = this.f37419l;
            SportDataType sportDataType2 = SportDataType.SwimDistance;
            textView2.setText(c.d(sportDataType2, (int) (uVar.A * uVar.B), this.f37413h));
            this.f37421m.setText(c.a(getResources(), this.f37413h, sportDataType2));
        }
        this.f37423n.setText(c.e(uVar.f25991j, false));
        this.f37425o.setText(c.d(SportDataType.Calorie, uVar.f25993l, this.f37413h));
        lf.b.b(uVar);
        if (uVar.f25985d.typeCode == sportType.typeCode) {
            this.f37432u.setText(u.B4);
            TextView textView3 = this.f37434w;
            StringBuilder sb2 = new StringBuilder();
            SportDataType sportDataType3 = SportDataType.SwimPoolLength;
            sb2.append(c.d(sportDataType3, 100.0f, this.f37413h));
            sb2.append(c.a(getResources(), this.f37413h, sportDataType3));
            textView3.setText(sb2.toString());
            SportType sportType2 = this.f37412g;
            if (sportType2 == SportType.RopeSkipping || sportType2 == sportType || sportType2 == SportType.AutoSwimming || sportType2 == SportType.Yoga) {
                this.f37419l.setText(String.valueOf(this.f37424n0));
                this.f37421m.setText("");
            }
            this.f37427p.setText(u.R4);
            this.f37428q.setText(String.valueOf((int) uVar.B));
            this.f37429r.setText(c.a(getResources(), this.f37413h, SportDataType.SwimTrips));
        } else {
            this.f37424n0 = uVar.f25994m;
            float c10 = lf.b.c(uVar);
            this.N.f25930n = this.f37413h ? UnitsUtility.Speed.mPs2milePh(c10) : UnitsUtility.Speed.mPs2kmPh(c10);
            this.f37428q.setText(c.d(SportDataType.HeartRate, this.f37424n0, this.f37413h));
            TextView textView4 = this.f37433v;
            SportDataType sportDataType4 = SportDataType.Speed;
            textView4.setText(c.d(sportDataType4, c10, this.f37413h));
            this.f37434w.setText(c.a(getResources(), this.f37413h, sportDataType4));
            SportType sportType3 = this.f37412g;
            if (sportType3 == SportType.RopeSkipping || sportType3 == sportType || sportType3 == SportType.AutoSwimming || sportType3 == SportType.Yoga || sportType3 == SportType.JumpingJack || sportType3 == SportType.Badminton || sportType3 == SportType.TableTennis || sportType3 == SportType.Tennis || sportType3 == SportType.Baseball || sportType3 == SportType.Volleyball || sportType3 == SportType.Cricket || sportType3 == SportType.Rugby || sportType3 == SportType.Hockey || sportType3 == SportType.Dance || sportType3 == SportType.AbdominalCurl) {
                this.f37419l.setText(String.valueOf(this.f37424n0));
                this.f37421m.setText("");
            }
            if (this.f37424n0 <= 0) {
                this.f37430s.setVisibility(0);
                this.f37430s.setOnClickListener(new a());
            }
        }
        B0(uVar);
        this.G.b(Math.round(uVar.c()), this.f37412g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(h hVar, List list) {
        int i10;
        boolean e10 = bh.f.e(list);
        if (!e10) {
            int size = list.size();
            int i11 = size % 2;
            i10 = size / 2;
            if (i11 != 0) {
                i10++;
            }
        } else {
            i10 = 0;
        }
        this.J.setText(e10 ? getString(u.f26930m3) : getString(u.f26924l3, Integer.valueOf(i10), Integer.valueOf(i10)));
        this.H.d(list, this.f37418k0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r0(h hVar, List list) {
        String str;
        boolean e10 = bh.f.e(list);
        if (!e10 || !this.f37412g.isAutoSport()) {
            lf.a.d(list, this.N);
            String a10 = c.a(getResources(), this.f37413h, SportDataType.Speed);
            TextView textView = this.f37416j0;
            if (e10) {
                str = getString(u.Z2, a10);
            } else {
                str = getString(u.f26948p3, Integer.valueOf(Math.round(this.N.f25930n)), a10);
            }
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(h hVar, List list) {
        if (list.size() < 2) {
            this.U.setVisibility(8);
            return;
        }
        this.W.setVisibility(0);
        TextView textView = this.V;
        int i10 = u.V2;
        SportDataType sportDataType = SportDataType.Distance;
        textView.setText(getString(i10, c.d(sportDataType, this.f37414i, this.f37413h), c.a(getResources(), this.f37413h, sportDataType)));
        dh.a aVar = this.T;
        if (aVar != null) {
            aVar.e(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(h hVar, List list) {
        this.f37433v.setText(c.d(SportDataType.SwimPace, bh.f.c(list), !com.mobvoi.companion.base.settings.a.isUnitMetric(requireContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u0(h hVar, List list) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w0(DialogInterface dialogInterface, int i10) {
        this.O.i();
        dialogInterface.dismiss();
    }

    private void y0() {
        if (this.M == null) {
            this.M = new k7.b(requireActivity()).d(true).D(getString(u.C2)).j(u.f26938o, r.f37498a).m(u.f26944p, new DialogInterface.OnClickListener() { // from class: zg.q
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    a0.this.w0(dialogInterface, i10);
                }
            }).a();
        }
        if (!this.M.isShowing()) {
            this.M.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5 A[LOOP:0: B:14:0x00a3->B:15:0x00a5, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void z0(int i10) {
        String str;
        int i11;
        String str2;
        int indexOf;
        String string;
        String string2;
        String string3;
        Dialog dialog = new Dialog(requireActivity());
        this.L = dialog;
        dialog.requestWindowFeature(1);
        this.L.setContentView(t.f26830d);
        this.L.getWindow().setBackgroundDrawableResource(q.f26548b);
        int i12 = 0;
        this.L.setCancelable(false);
        Resources resources = getResources();
        String str3 = null;
        if (i10 == s.T0) {
            i12 = resources.getColor(o.C);
            string = resources.getString(u.f26983v2);
            string2 = resources.getString(u.I2);
            string3 = resources.getString(u.H2);
            i11 = q.f26564f;
        } else if (i10 == s.f26705i2) {
            i12 = resources.getColor(o.Q);
            string = resources.getString(u.f26989w2);
            string2 = resources.getString(u.Q2);
            string3 = resources.getString(u.P2);
            i11 = q.f26568g;
        } else if (i10 == s.f26740n2) {
            i12 = resources.getColor(o.H);
            string = resources.getString(u.f26995x2);
            string2 = resources.getString(u.U2);
            string3 = resources.getString(u.T2);
            i11 = q.f26572h;
        } else {
            i11 = 0;
            str = null;
            str2 = null;
            SpannableString spannableString = new SpannableString(str3);
            String string4 = resources.getString(u.f26942o3);
            int length = string4.length();
            indexOf = str3.indexOf(string4);
            while (indexOf >= 0) {
                int i13 = indexOf + length;
                spannableString.setSpan(new ForegroundColorSpan(i12), indexOf, i13, 34);
                indexOf = str3.indexOf(string4, i13);
            }
            ((ImageView) this.L.findViewById(s.f26715j5)).setImageResource(i11);
            ((TextView) this.L.findViewById(s.f26687f5)).setText(str);
            ((TextView) this.L.findViewById(s.f26738n0)).setText(str2);
            ((TextView) this.L.findViewById(s.Z)).setText(spannableString);
            this.L.findViewById(s.W).setOnClickListener(this);
            this.L.show();
        }
        str3 = string3;
        str2 = string2;
        str = string;
        SpannableString spannableString2 = new SpannableString(str3);
        String string42 = resources.getString(u.f26942o3);
        int length2 = string42.length();
        indexOf = str3.indexOf(string42);
        while (indexOf >= 0) {
        }
        ((ImageView) this.L.findViewById(s.f26715j5)).setImageResource(i11);
        ((TextView) this.L.findViewById(s.f26687f5)).setText(str);
        ((TextView) this.L.findViewById(s.f26738n0)).setText(str2);
        ((TextView) this.L.findViewById(s.Z)).setText(spannableString2);
        this.L.findViewById(s.W).setOnClickListener(this);
        this.L.show();
    }

    @Override // nf.e
    protected f Z() {
        return this;
    }

    @Override // nf.e
    protected g a0() {
        bh.d.b(getContext());
        this.f37411f = getArguments().getString("sportId");
        SportType sportType = (SportType) getArguments().getSerializable("type");
        this.f37412g = sportType;
        this.f37422m0 = bh.f.d(sportType);
        this.f37413h = !com.mobvoi.companion.base.settings.a.isUnitMetric(requireActivity());
        xf.i a10 = xf.i.a("", "", "", ah.c.a().o(getContext()).f208a);
        this.f37420l0 = a10.f36548d;
        d dVar = new d(this.f37411f);
        dVar.z(this.f37413h);
        dVar.A(a10);
        return dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        int i10 = s.T0;
        if (id2 == i10) {
            z0(i10);
            return;
        }
        int i11 = s.f26705i2;
        if (id2 == i11) {
            z0(i11);
            return;
        }
        int i12 = s.f26740n2;
        if (id2 == i12) {
            z0(i12);
            return;
        }
        int i13 = s.f26797v4;
        if (id2 == i13) {
            A0(i13);
            return;
        }
        int i14 = s.f26811x4;
        if (id2 == i14) {
            A0(i14);
            return;
        }
        int i15 = s.F4;
        if (id2 == i15) {
            A0(i15);
        } else if (id2 == s.W) {
            Dialog dialog = this.L;
            if (dialog != null && dialog.isShowing()) {
                this.L.dismiss();
            }
        } else if (id2 == s.K) {
            Intent intent = new Intent("com.mobvoi.companion.action.HEALTH_SHARE");
            intent.putExtra("sportId", this.f37411f);
            intent.putExtra("type", this.f37412g);
            intent.setPackage(requireContext().getPackageName());
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        } else if (id2 == s.f26806x) {
            requireActivity().finish();
        } else if (id2 == s.J) {
            y0();
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.R, viewGroup, false);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(s.J4);
        this.f37415j = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(false);
        this.f37415j.setRefreshing(true);
        this.f37417k = (ImageView) inflate.findViewById(s.f26799w);
        this.f37409d = (TextView) inflate.findViewById(s.f26791u5);
        this.f37410e = (TextView) inflate.findViewById(s.f26800w0);
        View findViewById = inflate.findViewById(s.K);
        this.Q = findViewById;
        findViewById.setOnClickListener(this);
        inflate.findViewById(s.f26806x).setOnClickListener(this);
        View findViewById2 = inflate.findViewById(s.J);
        this.P = findViewById2;
        findViewById2.setOnClickListener(this);
        this.G = (PercentView) inflate.findViewById(s.f26774s2);
        ImageView imageView = (ImageView) inflate.findViewById(s.T0);
        this.F = imageView;
        imageView.setOnClickListener(this);
        this.B = (RelativeLayout) inflate.findViewById(s.f26808x1);
        this.E = (TextView) inflate.findViewById(s.Q0);
        int i10 = s.R0;
        this.C = (HeartRateView) inflate.findViewById(i10);
        this.D = (TextView) inflate.findViewById(s.U0);
        this.C = (HeartRateView) inflate.findViewById(i10);
        this.A = (TextView) inflate.findViewById(s.S0);
        this.f37430s = (ImageView) inflate.findViewById(s.f26690g1);
        this.H = (TrainingView) inflate.findViewById(s.f26729l5);
        this.f37419l = (TextView) inflate.findViewById(s.f26759q0);
        this.f37421m = (TextView) inflate.findViewById(s.f26779t0);
        this.f37426o0 = (TextView) inflate.findViewById(s.f26765r0);
        this.f37423n = (TextView) inflate.findViewById(s.f26793v0);
        this.f37425o = (TextView) inflate.findViewById(s.O);
        this.f37427p = (TextView) inflate.findViewById(s.f26676e1);
        this.f37429r = (TextView) inflate.findViewById(s.f26683f1);
        this.f37428q = (TextView) inflate.findViewById(s.O0);
        this.f37431t = (RelativeLayout) inflate.findViewById(s.f26815y1);
        this.f37432u = (TextView) inflate.findViewById(s.J3);
        this.f37433v = (TextView) inflate.findViewById(s.E3);
        this.f37434w = (TextView) inflate.findViewById(s.K3);
        this.f37435x = (TextView) inflate.findViewById(s.L4);
        this.f37436y = (TextView) inflate.findViewById(s.M4);
        this.f37437z = (TextView) inflate.findViewById(s.N4);
        this.I = (RelativeLayout) inflate.findViewById(s.f26736m5);
        this.J = (TextView) inflate.findViewById(s.f26722k5);
        this.R = (ViewGroup) inflate.findViewById(s.G1);
        this.S = ah.c.a().r(this.R);
        this.U = (RelativeLayout) inflate.findViewById(s.f26767r2);
        ImageView imageView2 = (ImageView) inflate.findViewById(s.f26747o2);
        TextView textView = (TextView) inflate.findViewById(s.f26754p2);
        this.V = (TextView) inflate.findViewById(s.f26733m2);
        this.W = inflate.findViewById(s.f26761q2);
        this.f37416j0 = (TextView) inflate.findViewById(s.f26726l2);
        m0();
        l0();
        return inflate;
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dh.a aVar = this.T;
        if (aVar != null) {
            aVar.a();
        }
        Dialog dialog = this.L;
        if (dialog != null && dialog.isShowing()) {
            this.L.dismiss();
            this.L = null;
        }
        Dialog dialog2 = this.M;
        if (dialog2 != null && dialog2.isShowing()) {
            this.M.dismiss();
            this.M = null;
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dh.a aVar = this.T;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dh.a aVar = this.T;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* renamed from: x0 */
    public void setViewModel(d dVar) {
        this.O = dVar;
        this.K.clear();
        if (dVar != null) {
            this.K.a(j.b(dVar.p(), new j.a() { // from class: zg.s
                @Override // nf.j.a
                public final void call(Object obj) {
                    a0.this.n0((Iterable) obj);
                }
            }));
            this.K.a(j.c(dVar.j(), new k() { // from class: zg.x
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a0.this.o0(hVar, (List) obj);
                }
            }));
            this.K.a(j.c(dVar.q(), new k() { // from class: zg.t
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a0.this.p0(hVar, (ef.u) obj);
                }
            }));
            this.K.a(j.c(dVar.v(), new k() { // from class: zg.u
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a0.this.q0(hVar, (List) obj);
                }
            }));
            this.K.a(j.c(dVar.n(), new k() { // from class: zg.w
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a0.this.r0(hVar, (List) obj);
                }
            }));
            this.K.a(j.c(dVar.l(), new k() { // from class: zg.v
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    a0.this.s0(hVar, (List) obj);
                }
            }));
            if (this.f37412g == SportType.Swimming) {
                this.K.a(j.c(dVar.t(), new k() { // from class: zg.y
                    @Override // nf.k
                    public final void i(h hVar, Object obj) {
                        a0.this.t0(hVar, (List) obj);
                    }
                }));
                this.K.a(j.c(dVar.u(), z.f37506a));
            }
        }
    }
}
