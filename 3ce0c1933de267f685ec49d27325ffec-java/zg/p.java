package zg;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import bh.g;
import com.mobvoi.companion.map.i;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.sport.view.HealthSportSwimmingView;
import com.mobvoi.health.companion.sport.view.HeartRateView;
import com.mobvoi.health.companion.sport.view.PaceView;
import com.mobvoi.health.companion.sport.view.PercentView;
import com.mobvoi.health.companion.sport.view.SpeedView;
import com.mobvoi.health.companion.sport.view.StrideView;
import com.mobvoi.health.companion.sport.view.TrainingView;
import com.mobvoi.wear.util.UnitsUtility;
import ef.x;
import ef.y;
import eh.d;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jc.a;
import nf.e;
import nf.f;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
/* compiled from: HealthSportDetailFragment.java */
/* loaded from: classes2.dex */
public class p extends e implements f<d>, View.OnClickListener {
    private TextView A;
    private TextView A0;
    private TextView B;
    private TrainingView B0;
    private RelativeLayout C;
    private RelativeLayout C0;
    private TextView D;
    private RelativeLayout D0;
    private TextView E;
    private RelativeLayout E0;
    private RatingBar F;
    private RelativeLayout F0;
    private RelativeLayout G;
    private HealthSportSwimmingView G0;
    private TextView H;
    private TextView H0;
    private TextView I;
    private TextView J;
    private View J0;
    private TextView K;
    private Dialog K0;
    private int L;
    private jc.a L0;
    private RelativeLayout M;
    private RelativeLayout N;
    private d N0;
    private RelativeLayout O;
    private View O0;
    private PercentView P;
    private View P0;
    private HeartRateView Q;
    private ViewGroup Q0;
    private RelativeLayout R;
    private TextView R0;
    private TextView S;
    private int S0;
    private TextView T;
    private int T0;
    private TextView U;
    private boolean U0;
    private SpeedView V;
    private int V0;
    private TextView W;
    private Dialog W0;

    /* renamed from: d  reason: collision with root package name */
    private TextView f37454d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f37455e;

    /* renamed from: f  reason: collision with root package name */
    private String f37456f;

    /* renamed from: g  reason: collision with root package name */
    private SportType f37457g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f37458h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f37459i;

    /* renamed from: j  reason: collision with root package name */
    private int f37460j;

    /* renamed from: j0  reason: collision with root package name */
    private TextView f37461j0;

    /* renamed from: k  reason: collision with root package name */
    private SwipeRefreshLayout f37462k;

    /* renamed from: k0  reason: collision with root package name */
    private PaceView f37463k0;

    /* renamed from: l  reason: collision with root package name */
    private TextView f37464l;

    /* renamed from: l0  reason: collision with root package name */
    private TextView f37465l0;

    /* renamed from: m  reason: collision with root package name */
    private TextView f37466m;

    /* renamed from: m0  reason: collision with root package name */
    private TextView f37467m0;

    /* renamed from: n  reason: collision with root package name */
    private ImageView f37468n;

    /* renamed from: n0  reason: collision with root package name */
    private LinearLayout f37469n0;

    /* renamed from: o  reason: collision with root package name */
    private TextView f37470o;

    /* renamed from: o0  reason: collision with root package name */
    private LinearLayout f37471o0;

    /* renamed from: p  reason: collision with root package name */
    private TextView f37472p;

    /* renamed from: p0  reason: collision with root package name */
    private StrideView f37473p0;

    /* renamed from: q  reason: collision with root package name */
    private TextView f37474q;

    /* renamed from: q0  reason: collision with root package name */
    private TextView f37475q0;

    /* renamed from: r  reason: collision with root package name */
    private TextView f37476r;

    /* renamed from: r0  reason: collision with root package name */
    private StrideView f37477r0;

    /* renamed from: s  reason: collision with root package name */
    private TextView f37478s;

    /* renamed from: s0  reason: collision with root package name */
    private TextView f37479s0;

    /* renamed from: t  reason: collision with root package name */
    private TextView f37480t;

    /* renamed from: t0  reason: collision with root package name */
    private ViewGroup f37481t0;

    /* renamed from: u  reason: collision with root package name */
    private ImageView f37482u;

    /* renamed from: u0  reason: collision with root package name */
    private i f37483u0;

    /* renamed from: v  reason: collision with root package name */
    private RelativeLayout f37484v;

    /* renamed from: v0  reason: collision with root package name */
    private dh.a f37485v0;

    /* renamed from: w  reason: collision with root package name */
    private TextView f37486w;

    /* renamed from: w0  reason: collision with root package name */
    private ImageView f37487w0;

    /* renamed from: x  reason: collision with root package name */
    private TextView f37488x;

    /* renamed from: x0  reason: collision with root package name */
    private TextView f37489x0;

    /* renamed from: y  reason: collision with root package name */
    private TextView f37490y;

    /* renamed from: y0  reason: collision with root package name */
    private TextView f37491y0;

    /* renamed from: z  reason: collision with root package name */
    private TextView f37492z;

    /* renamed from: z0  reason: collision with root package name */
    private View f37493z0;
    private m I0 = new m();
    private ef.f M0 = new ef.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HealthSportDetailFragment.java */
    /* loaded from: classes2.dex */
    public class a extends dg.a {
        a() {
        }

        @Override // dg.a
        public void a(View view) {
            zg.b.s0(p.this.getFragmentManager());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HealthSportDetailFragment.java */
    /* loaded from: classes2.dex */
    public class b implements a.AbstractC0354a {
        b() {
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            p.this.N0.i();
            p.this.L0.dismiss();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            p.this.L0.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HealthSportDetailFragment.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37496a;

        static {
            int[] iArr = new int[SportType.values().length];
            f37496a = iArr;
            try {
                iArr[SportType.OutdoorRunning.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37496a[SportType.AutoRunning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37496a[SportType.BandRunning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37496a[SportType.IndoorRunning.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37496a[SportType.TreadmillRunning.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37496a[SportType.BandAutoWalking.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37496a[SportType.AutoWalking.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f37496a[SportType.OutdoorWalk.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f37496a[SportType.AutoCycling.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f37496a[SportType.OutdoorBike.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f37496a[SportType.FreeWorkout.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f37496a[SportType.AutoSwimming.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f37496a[SportType.Swimming.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f37496a[SportType.Hiit.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f37496a[SportType.Climbing.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f37496a[SportType.OffRoad.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f37496a[SportType.Golf.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private void A0() {
        if (com.mobvoi.health.companion.system.c.a().p()) {
            this.O0.setVisibility(8);
            this.P0.setVisibility(8);
        }
        if (this.U0) {
            this.f37473p0.setVisibility(8);
            this.f37477r0.setVisibility(8);
            this.f37492z.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.R.setVisibility(8);
            this.J0.setVisibility(8);
        }
        this.G0.setVisibility(8);
        switch (c.f37496a[this.f37457g.ordinal()]) {
            case 1:
            case 2:
                this.N.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 3:
                this.f37469n0.setVisibility(8);
                this.N.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 4:
            case 5:
            case 6:
                this.f37469n0.setVisibility(8);
                this.N.setVisibility(8);
                this.E0.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 7:
            case 8:
                this.O.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 9:
            case 10:
                this.O.setVisibility(8);
                this.C0.setVisibility(8);
                this.D0.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 11:
                this.f37469n0.setVisibility(8);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
                this.C0.setVisibility(8);
                this.D0.setVisibility(8);
                this.E0.setVisibility(8);
                this.f37484v.setVisibility(8);
                return;
            case 12:
            case 13:
                this.f37469n0.setVisibility(8);
                this.M.setVisibility(8);
                this.G0.setVisibility(0);
                this.N.setVisibility(8);
                this.O.setVisibility(8);
                this.C0.setVisibility(8);
                this.D0.setVisibility(8);
                this.E0.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 14:
                this.f37466m.setText(u.f26959r2);
                this.f37471o0.setVisibility(0);
                this.f37469n0.setVisibility(8);
                this.f37484v.setVisibility(8);
                this.D0.setVisibility(8);
                this.N.setVisibility(8);
                this.E0.setVisibility(8);
                this.F0.setVisibility(8);
                this.C0.setVisibility(8);
                this.O.setVisibility(8);
                return;
            case 15:
            case 16:
                this.f37469n0.setVisibility(8);
                this.D0.setVisibility(8);
                this.C0.setVisibility(8);
                this.F0.setVisibility(8);
                return;
            case 17:
                this.f37469n0.setVisibility(8);
                this.f37484v.setVisibility(8);
                this.D0.setVisibility(8);
                this.N.setVisibility(8);
                this.F0.setVisibility(8);
                this.C0.setVisibility(8);
                this.O.setVisibility(8);
                return;
            default:
                this.f37469n0.setVisibility(8);
                this.f37484v.setVisibility(8);
                this.D0.setVisibility(8);
                this.N.setVisibility(8);
                this.E0.setVisibility(8);
                this.F0.setVisibility(8);
                this.C0.setVisibility(8);
                this.O.setVisibility(8);
                return;
        }
    }

    private void B0() {
        SportType sportType = this.f37457g;
        if (sportType != null && sportType.supportGps()) {
            this.f37485v0 = new dh.a(requireActivity().getApplicationContext(), this.f37483u0, this.f37457g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(Iterable iterable) {
        this.f37462k.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(h hVar, List list) {
        boolean e10 = bh.f.e(list);
        List<xf.h> arrayList = new ArrayList<>();
        if (!e10) {
            arrayList.addAll(list);
            arrayList = lf.a.b(arrayList, this.T0, this.M0);
        }
        HeartRateView heartRateView = this.Q;
        int i10 = this.T0;
        ef.f fVar = this.M0;
        heartRateView.k(arrayList, i10, fVar.f25926j, fVar.f25927k, fVar.f25923g, fVar.f25922f, this.S0);
        this.U.setText(e10 ? getString(u.K2) : getString(u.J2, Integer.valueOf(this.M0.f25925i)));
        this.T.setText(e10 ? getString(u.M2) : getString(u.L2, Integer.valueOf(this.M0.f25924h)));
        TextView textView = this.S;
        int i11 = this.V0;
        textView.setText(i11 <= 0 ? getString(u.G2) : getString(u.F2, Integer.valueOf(i11)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(h hVar, Boolean bool) {
        if (bool.booleanValue()) {
            requireActivity().setResult(101);
            requireActivity().finish();
            Toast.makeText(getActivity(), u.D2, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(h hVar, List list) {
        this.G0.setSwimmingSegment(list);
        this.f37488x.setText(lf.c.d(SportDataType.SwimPace, bh.f.c(list), !com.mobvoi.companion.base.settings.a.isUnitMetric(requireContext())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(d dVar, h hVar, List list) {
        Log.e("health.ui.detail", "setViewModel() called with: viewModel = [" + dVar + "]");
        this.G0.setDetailed(true);
        this.G0.d(list, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H0(h hVar, List list) {
        boolean e10 = bh.f.e(list);
        ArrayList arrayList = new ArrayList();
        if (!e10) {
            arrayList.addAll(list);
        }
        z0(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I0(h hVar, ef.u uVar) {
        x0(uVar);
        w0(uVar);
        this.S0 = bh.f.a((int) Math.ceil(UnitsUtility.Time.ms2min(uVar.f25991j)));
        bh.f.f(requireContext(), this.f37454d, this.f37455e, this.f37457g, uVar);
        TextView textView = this.f37464l;
        SportDataType sportDataType = SportDataType.Distance;
        textView.setText(lf.c.d(sportDataType, uVar.f25992k, this.f37458h));
        TextView textView2 = this.f37466m;
        StringBuilder sb2 = new StringBuilder();
        int i10 = u.f26977u2;
        sb2.append(getString(i10));
        sb2.append(" (");
        sb2.append(lf.c.a(getResources(), this.f37458h, sportDataType));
        sb2.append(")");
        textView2.setText(sb2.toString());
        this.f37460j = uVar.f25992k;
        SportType sportType = uVar.f25985d;
        SportType sportType2 = SportType.Swimming;
        if (sportType == sportType2) {
            TextView textView3 = this.f37464l;
            SportDataType sportDataType2 = SportDataType.SwimDistance;
            textView3.setText(lf.c.d(sportDataType2, (int) (uVar.A * uVar.B), this.f37458h));
            TextView textView4 = this.f37466m;
            textView4.setText(getString(i10) + " (" + lf.c.a(getResources(), this.f37458h, sportDataType2) + ")");
        } else if (sportType == SportType.Hiit) {
            this.f37466m.setText(u.f26959r2);
            if (TextUtils.isEmpty(uVar.G)) {
                this.f37464l.setText("-");
                this.f37471o0.setVisibility(8);
            } else {
                y0(uVar.G);
            }
        } else if (sportType == SportType.OutdoorRunning || sportType == SportType.OutdoorWalk || sportType == SportType.OffRoad) {
            if (uVar.f()) {
                this.Q0.setVisibility(0);
                String format = String.format(Locale.US, "%.0f ", Float.valueOf(uVar.f26002u));
                TextView textView5 = this.R0;
                textView5.setText(format + getString(u.Z4));
            } else {
                this.Q0.setVisibility(8);
            }
        } else if (sportType.isCountType()) {
            int i11 = uVar.H;
            if (i11 < 0) {
                this.f37464l.setText("-");
            } else {
                this.f37464l.setText(String.valueOf(i11));
            }
            this.f37466m.setText(getString(u.Y4));
            this.f37468n.setVisibility(0);
        }
        this.f37470o.setText(lf.c.e(uVar.f25991j, false));
        this.f37472p.setText(lf.c.d(SportDataType.Calorie, uVar.f25993l, this.f37458h));
        TextView textView6 = this.f37474q;
        textView6.setText(getString(u.f26965s2) + " (" + getString(u.f27001y2) + ")");
        lf.b.b(uVar);
        if (uVar.f25985d == sportType2) {
            this.f37486w.setText(u.B4);
            TextView textView7 = this.f37490y;
            StringBuilder sb3 = new StringBuilder();
            SportDataType sportDataType3 = SportDataType.SwimPoolLength;
            sb3.append(lf.c.d(sportDataType3, 100.0f, this.f37458h));
            sb3.append(lf.c.a(getResources(), this.f37458h, sportDataType3));
            textView7.setText(sb3.toString());
            this.f37476r.setText(u.R4);
            this.f37478s.setText(String.valueOf(Math.max((int) uVar.B, 0)));
            this.f37480t.setText(lf.c.a(getResources(), this.f37458h, SportDataType.SwimTrips));
        } else {
            this.V0 = uVar.f25994m;
            float c10 = lf.b.c(uVar);
            this.M0.f25930n = this.f37458h ? UnitsUtility.Speed.mPs2milePh(c10) : UnitsUtility.Speed.mPs2kmPh(c10);
            this.f37478s.setText(lf.c.d(SportDataType.HeartRate, this.V0, this.f37458h));
            TextView textView8 = this.f37488x;
            SportDataType sportDataType4 = SportDataType.Speed;
            textView8.setText(lf.c.d(sportDataType4, c10, this.f37458h));
            this.f37490y.setText(lf.c.a(getResources(), this.f37458h, sportDataType4));
            if (this.V0 <= 0) {
                this.f37482u.setVisibility(0);
                this.f37482u.setOnClickListener(new a());
            }
        }
        U0(uVar);
        this.P.b(Math.round(uVar.c()), this.f37457g);
        this.f37479s0.setText(getString(u.f26900h3, Integer.valueOf(lf.b.e(uVar))));
        this.f37475q0.setText(getString(u.f26888f3, Float.valueOf(lf.b.d(uVar)), g.a(getContext(), this.f37458h)));
        TextView textView9 = this.f37465l0;
        int i12 = u.O2;
        SportDataType sportDataType5 = SportDataType.Pace;
        textView9.setText(getString(i12, lf.c.d(sportDataType5, lf.b.b(uVar), this.f37458h), lf.c.a(getResources(), this.f37458h, sportDataType5)));
        this.G0.c(uVar.B, uVar.A);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(h hVar, List list) {
        String str;
        boolean e10 = bh.f.e(list);
        lf.a.e(list, this.M0);
        String a10 = g.a(getContext(), this.f37458h);
        if (!this.U0) {
            TextView textView = this.f37475q0;
            if (e10) {
                str = getString(u.f26894g3, a10);
            } else {
                str = getString(u.f26888f3, Float.valueOf(this.M0.f25928l), a10);
            }
            textView.setText(str);
        }
        this.f37473p0.e(list, true, this.S0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(h hVar, List list) {
        boolean e10 = bh.f.e(list);
        lf.a.f(list, this.M0);
        if (!this.U0) {
            this.f37479s0.setText(e10 ? getString(u.f26906i3) : getString(u.f26900h3, Integer.valueOf(this.M0.f25929m)));
        }
        this.f37477r0.e(list, false, this.S0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(h hVar, List list) {
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
        this.H0.setText(e10 ? getString(u.f26930m3) : getString(u.f26924l3, Integer.valueOf(i10), Integer.valueOf(i10)));
        this.B0.d(list, this.S0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(h hVar, List list) {
        String str;
        boolean e10 = bh.f.e(list);
        lf.a.c(list, this.M0);
        if (!this.U0 || !e10) {
            this.f37463k0.c(list, this.M0.f25934r, this.S0);
        } else {
            this.f37463k0.setVisibility(8);
        }
        Resources resources = getResources();
        boolean z10 = this.f37458h;
        SportDataType sportDataType = SportDataType.Pace;
        String a10 = lf.c.a(resources, z10, sportDataType);
        if (!this.U0) {
            float f10 = (this.M0.f25935s * 60.0f) / 1000.0f;
            TextView textView = this.f37467m0;
            if (e10) {
                str = getString(u.R2, a10);
            } else {
                str = getString(u.S2, lf.c.d(sportDataType, f10, this.f37458h), a10);
            }
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(h hVar, List list) {
        String str;
        String str2;
        String str3;
        boolean e10 = bh.f.e(list);
        if (!e10 || !this.f37457g.isAutoSport()) {
            lf.a.d(list, this.M0);
            SpeedView speedView = this.V;
            ef.f fVar = this.M0;
            speedView.g(list, fVar.f25932p, fVar.f25931o, this.S0);
            String a10 = lf.c.a(getResources(), this.f37458h, SportDataType.Speed);
            TextView textView = this.f37461j0;
            if (e10) {
                str = getString(u.f26882e3, a10);
            } else {
                str = getString(u.f26876d3, Integer.valueOf(Math.round(this.M0.f25931o)), a10);
            }
            textView.setText(str);
            TextView textView2 = this.W;
            if (e10) {
                str2 = getString(u.Z2, a10);
            } else {
                str2 = getString(u.Y2, Float.valueOf(this.M0.f25930n), a10);
            }
            textView2.setText(str2);
            TextView textView3 = this.A0;
            if (e10) {
                str3 = getString(u.Z2, a10);
            } else {
                str3 = getString(u.f26948p3, Integer.valueOf(Math.round(this.M0.f25930n)), a10);
            }
            textView3.setText(str3);
            return;
        }
        this.N.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0(h hVar, List list) {
        boolean z10 = list.size() < 2;
        if (z10 && (this.U0 || this.f37457g.isAutoSport())) {
            this.E0.setVisibility(8);
        } else if (z10) {
            TextView textView = this.f37491y0;
            int i10 = u.W2;
            SportDataType sportDataType = SportDataType.Distance;
            textView.setText(getString(i10, lf.c.d(sportDataType, this.f37460j, this.f37458h), lf.c.a(getResources(), this.f37458h, sportDataType)));
            this.f37487w0.setVisibility(0);
            this.f37487w0.setImageDrawable(u0());
            this.f37489x0.setVisibility(0);
            this.f37481t0.setVisibility(8);
            this.f37493z0.setVisibility(8);
        } else {
            this.f37493z0.setVisibility(0);
            TextView textView2 = this.f37491y0;
            int i11 = u.V2;
            SportDataType sportDataType2 = SportDataType.Distance;
            textView2.setText(getString(i11, lf.c.d(sportDataType2, this.f37460j, this.f37458h), lf.c.a(getResources(), this.f37458h, sportDataType2)));
            dh.a aVar = this.f37485v0;
            if (aVar != null) {
                aVar.e(list);
            }
        }
    }

    private static x P0(x xVar, x xVar2) {
        return new x(xVar2.f26013a, xVar2.f26016d, xVar2.f26014b + xVar.f26014b, xVar2.f26015c + xVar.f26015c, xVar2.f26017e + xVar.f26017e);
    }

    private void R0() {
        if (this.L0 == null) {
            this.L0 = new jc.a(getActivity());
            this.L0.i(getString(u.C2));
            this.L0.c(getResources().getString(u.f26938o), getResources().getString(u.f26944p));
            this.L0.setCanceledOnTouchOutside(true);
            this.L0.setCancelable(true);
            this.L0.d(new b());
        }
        if (!this.L0.isShowing()) {
            this.L0.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5 A[LOOP:0: B:14:0x00a3->B:15:0x00a5, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void S0(int i10) {
        String str;
        int i11;
        String str2;
        int indexOf;
        String string;
        String string2;
        String string3;
        Dialog dialog = new Dialog(requireActivity());
        this.K0 = dialog;
        dialog.requestWindowFeature(1);
        this.K0.setContentView(t.f26830d);
        this.K0.getWindow().setBackgroundDrawableResource(q.f26548b);
        int i12 = 0;
        this.K0.setCancelable(false);
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
            ((ImageView) this.K0.findViewById(s.f26715j5)).setImageResource(i11);
            ((TextView) this.K0.findViewById(s.f26687f5)).setText(str);
            ((TextView) this.K0.findViewById(s.f26738n0)).setText(str2);
            ((TextView) this.K0.findViewById(s.Z)).setText(spannableString);
            this.K0.findViewById(s.W).setOnClickListener(this);
            this.K0.show();
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
        ((ImageView) this.K0.findViewById(s.f26715j5)).setImageResource(i11);
        ((TextView) this.K0.findViewById(s.f26687f5)).setText(str);
        ((TextView) this.K0.findViewById(s.f26738n0)).setText(str2);
        ((TextView) this.K0.findViewById(s.Z)).setText(spannableString2);
        this.K0.findViewById(s.W).setOnClickListener(this);
        this.K0.show();
    }

    private void T0(int i10) {
        String str;
        Dialog dialog = new Dialog(requireActivity());
        this.K0 = dialog;
        dialog.requestWindowFeature(1);
        this.K0.setContentView(t.f26831e);
        this.K0.getWindow().setBackgroundDrawableResource(q.f26548b);
        this.K0.setCancelable(false);
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
        ((TextView) this.K0.findViewById(s.f26687f5)).setText(str2);
        ((TextView) this.K0.findViewById(s.Z)).setText(Html.fromHtml(str));
        this.K0.findViewById(s.W).setOnClickListener(this);
        this.K0.show();
    }

    private void U0(ef.u uVar) {
        if (!this.U0) {
            SportDataType sportDataType = uVar.f25987f;
            this.f37492z.setText(lf.c.d(sportDataType, uVar.f25986e, this.f37458h));
            this.B.setText(lf.c.a(getResources(), this.f37458h, sportDataType));
        }
    }

    @SuppressLint({"DefaultLocale"})
    private void q0(LayoutInflater layoutInflater, x xVar, int i10, String str) {
        String str2;
        View inflate = layoutInflater.inflate(t.F, (ViewGroup) this.f37471o0, false);
        TextView textView = (TextView) inflate.findViewById(s.f26718k1);
        ((TextView) inflate.findViewById(s.f26697h1)).setText(String.valueOf(i10));
        ((TextView) inflate.findViewById(s.f26711j1)).setText(eg.i.a(xVar.f26013a));
        long j10 = xVar.f26015c;
        int i11 = ((((int) j10) / 1000) / 60) / 60;
        int i12 = (((int) j10) / 1000) / 60;
        int i13 = (((int) j10) / 1000) % 60;
        if (i11 > 0) {
            str2 = String.format("%s%s", getResources().getString(u.f26895g4, Integer.valueOf(i11)), getResources().getString(u.f26901h4, Integer.valueOf((((int) j10) / 1000) % 60)));
        } else {
            str2 = i12 > 0 ? String.format("%s%s", getResources().getString(u.f26901h4, Integer.valueOf(i12)), getResources().getString(u.f26907i4, Integer.valueOf(i13))) : getResources().getString(u.f26907i4, Integer.valueOf(i13));
        }
        long j11 = xVar.f26017e;
        if (j11 > 0) {
            textView.setText(String.format("%s/%d%s", str2, Long.valueOf(j11), str));
        } else {
            textView.setText(str2);
        }
        this.f37471o0.addView(inflate);
        layoutInflater.inflate(t.G, (ViewGroup) this.f37471o0, true);
    }

    private void r0(LayoutInflater layoutInflater, y yVar) {
        View inflate = layoutInflater.inflate(t.H, (ViewGroup) this.f37469n0, false);
        TextView textView = (TextView) inflate.findViewById(s.f26794v1);
        ((TextView) inflate.findViewById(s.f26766r1)).setText(String.valueOf(yVar.f26018a));
        ((TextView) inflate.findViewById(s.f26773s1)).setText(lf.c.d(SportDataType.Distance, yVar.f26019b, this.f37458h));
        ((TextView) inflate.findViewById(s.f26801w1)).setText(lf.c.e(yVar.f26020c, false));
        ((TextView) inflate.findViewById(s.f26780t1)).setText(lf.c.e(yVar.f26021d, false));
        float f10 = yVar.f26022e;
        if (f10 > 0.0f) {
            int i10 = (int) (f10 * 60.0f);
            textView.setText(String.format(Locale.US, "%d'%d''", Integer.valueOf(i10 / 60), Integer.valueOf(i10 % 60)));
        } else {
            textView.setText("- -");
        }
        this.f37469n0.addView(inflate);
        layoutInflater.inflate(t.G, (ViewGroup) this.f37469n0, true);
    }

    private void s0(View view) {
        View inflate = LayoutInflater.from(getActivity()).inflate(t.Q, (ViewGroup) null);
        PopupWindow popupWindow = new PopupWindow(getActivity());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setContentView(inflate);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.showAsDropDown(view);
    }

    private int t0(float f10) {
        if (f10 <= 1.25f) {
            return u.f26853a;
        }
        if (f10 <= 2.5f) {
            return u.f26860b;
        }
        if (f10 <= 3.75f) {
            return u.f26866c;
        }
        if (f10 <= 5.0f) {
            return u.f26872d;
        }
        return u.f26878e;
    }

    private c0.b u0() {
        Resources resources = getResources();
        c0.b a10 = c0.c.a(resources, BitmapFactory.decodeResource(resources, q.f26591l2));
        a10.f(resources.getDimensionPixelSize(fg.p.f26523o));
        a10.e(true);
        return a10;
    }

    private Spannable v0(int i10, String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(i10));
        spannableStringBuilder.append((CharSequence) " ");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str);
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.L), length, spannableStringBuilder.length(), 34);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(20, true), length, length2, 34);
        return spannableStringBuilder;
    }

    private void w0(ef.u uVar) {
        if (uVar.f25985d != SportType.OutdoorRunning || uVar.f26001t <= -1.0f) {
            this.C.setVisibility(8);
            return;
        }
        this.C.setVisibility(0);
        this.D.setText(lf.c.d(SportDataType.AiScore, uVar.f26001t, false));
        this.F.setRating(uVar.f26001t);
        this.E.setText(t0(uVar.f26001t));
    }

    private void x0(ef.u uVar) {
        if (lf.b.f(uVar)) {
            this.G.setVisibility(0);
            Resources resources = getResources();
            boolean z10 = this.f37458h;
            SportDataType sportDataType = SportDataType.Elevation;
            String a10 = lf.c.a(resources, z10, sportDataType);
            String d10 = lf.c.d(sportDataType, uVar.f25997p, this.f37458h);
            String d11 = lf.c.d(sportDataType, uVar.f25998q, this.f37458h);
            String d12 = lf.c.d(sportDataType, uVar.f25999r, this.f37458h);
            String d13 = lf.c.d(sportDataType, uVar.f26000s, this.f37458h);
            this.H.setText(v0(u.f26998y, d11, a10));
            this.I.setText(v0(u.f26992x, d10, a10));
            this.J.setText(v0(u.f27004z, d12, a10));
            this.K.setText(v0(u.f26986w, d13, a10));
            return;
        }
        this.G.setVisibility(8);
    }

    private void y0(String str) {
        List<x> b10 = x.b(str);
        if (b10 == null || b10.isEmpty()) {
            this.f37471o0.setVisibility(8);
            this.f37464l.setText("-");
            return;
        }
        int childCount = this.f37471o0.getChildCount();
        int i10 = 1;
        if (childCount > 2) {
            for (int i11 = childCount - 1; i11 >= 2; i11--) {
                this.f37471o0.removeViewAt(i11);
            }
        }
        HashMap hashMap = new HashMap();
        int i12 = 1;
        for (x xVar : b10) {
            SportType sportType = xVar.f26013a;
            if (sportType == SportType.GroupRest) {
                i12++;
            } else if (sportType != SportType.Rest) {
                if (!hashMap.containsKey(sportType)) {
                    hashMap.put(xVar.f26013a, xVar);
                } else {
                    hashMap.put(xVar.f26013a, P0((x) hashMap.get(xVar.f26013a), xVar));
                }
            }
        }
        this.f37464l.setText(String.valueOf(i12));
        LayoutInflater from = LayoutInflater.from(getActivity());
        String string = getString(u.X4);
        if (!hashMap.isEmpty()) {
            int size = b10.size();
            for (int i13 = 0; i13 < size; i13++) {
                SportType sportType2 = b10.get(i13).f26013a;
                if (sportType2 != SportType.GroupRest) {
                    if (sportType2 != SportType.Rest) {
                        x xVar2 = (x) hashMap.get(sportType2);
                        if (xVar2 != null) {
                            q0(from, xVar2, i10, string);
                        }
                        i10++;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void z0(List<y> list) {
        if (list.isEmpty()) {
            this.f37469n0.setVisibility(8);
            return;
        }
        int childCount = this.f37469n0.getChildCount();
        if (childCount > 2) {
            for (int i10 = childCount - 1; i10 >= 2; i10--) {
                this.f37469n0.removeViewAt(i10);
            }
        }
        ((TextView) this.f37469n0.findViewById(s.f26773s1)).setText(getString(u.S3, lf.c.a(getResources(), this.f37458h, SportDataType.Distance)));
        LayoutInflater from = LayoutInflater.from(getActivity());
        for (y yVar : list) {
            r0(from, yVar);
        }
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: Q0 */
    public void setViewModel(final d dVar) {
        this.N0 = dVar;
        this.I0.clear();
        if (dVar != null) {
            this.I0.a(j.b(dVar.p(), new j.a() { // from class: zg.c
                @Override // nf.j.a
                public final void call(Object obj) {
                    p.this.C0((Iterable) obj);
                }
            }));
            this.I0.a(j.c(dVar.j(), new k() { // from class: zg.n
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.D0(hVar, (List) obj);
                }
            }));
            if (this.f37457g.supportLap()) {
                this.I0.a(j.c(dVar.k(), new k() { // from class: zg.d
                    @Override // nf.k
                    public final void i(h hVar, Object obj) {
                        p.this.H0(hVar, (List) obj);
                    }
                }));
            }
            this.I0.a(j.c(dVar.q(), new k() { // from class: zg.g
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.I0(hVar, (ef.u) obj);
                }
            }));
            this.I0.a(j.c(dVar.s(), new k() { // from class: zg.l
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.J0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.r(), new k() { // from class: zg.j
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.K0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.v(), new k() { // from class: zg.k
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.L0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.m(), new k() { // from class: zg.i
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.M0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.n(), new k() { // from class: zg.m
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.N0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.l(), new k() { // from class: zg.e
                @Override // nf.k
                public final void i(h hVar, Object obj) {
                    p.this.O0(hVar, (List) obj);
                }
            }));
            this.I0.a(j.c(dVar.o(), new k() { // from class: zg.h
                @Override // nf.k
                public final void i(nf.h hVar, Object obj) {
                    p.this.E0(hVar, (Boolean) obj);
                }
            }));
            if (this.f37457g == SportType.Swimming) {
                this.I0.a(j.c(dVar.t(), new k() { // from class: zg.o
                    @Override // nf.k
                    public final void i(h hVar, Object obj) {
                        p.this.F0(hVar, (List) obj);
                    }
                }));
                this.I0.a(j.c(dVar.u(), new k() { // from class: zg.f
                    @Override // nf.k
                    public final void i(h hVar, Object obj) {
                        p.this.G0(dVar, hVar, (List) obj);
                    }
                }));
            }
        }
    }

    @Override // nf.e
    protected f Z() {
        return this;
    }

    @Override // nf.e
    protected nf.g a0() {
        bh.d.b(getContext());
        this.f37456f = getArguments().getString("sportId");
        this.f37457g = (SportType) getArguments().getSerializable("type");
        this.f37459i = getArguments().getBoolean("devicePage");
        this.U0 = bh.f.d(this.f37457g);
        this.f37458h = !com.mobvoi.companion.base.settings.a.isUnitMetric(requireActivity());
        xf.i a10 = xf.i.a("", "", "", ah.c.a().o(getContext()).f208a);
        this.T0 = a10.f36548d;
        d dVar = new d(this.f37456f);
        dVar.z(this.f37458h);
        dVar.A(a10);
        return dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        int i10 = s.T0;
        if (id2 == i10) {
            S0(i10);
            return;
        }
        int i11 = s.f26705i2;
        if (id2 == i11) {
            S0(i11);
            return;
        }
        int i12 = s.f26740n2;
        if (id2 == i12) {
            S0(i12);
            return;
        }
        int i13 = s.f26797v4;
        if (id2 == i13) {
            T0(i13);
            return;
        }
        int i14 = s.f26811x4;
        if (id2 == i14) {
            T0(i14);
            return;
        }
        int i15 = s.F4;
        if (id2 == i15) {
            T0(i15);
        } else if (id2 == s.W) {
            Dialog dialog = this.K0;
            if (dialog != null && dialog.isShowing()) {
                this.K0.dismiss();
            }
        } else if (id2 == s.K) {
            Intent intent = new Intent("com.mobvoi.companion.action.HEALTH_SHARE");
            intent.putExtra("sportId", this.f37456f);
            intent.putExtra("type", this.f37457g);
            intent.setPackage(requireContext().getPackageName());
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        } else if (id2 == s.f26806x) {
            requireActivity().finish();
        } else if (id2 == s.J) {
            R0();
        } else if (id2 != s.f26787u1 && id2 == s.f26753p1) {
            s0(this.f37468n);
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.f26851y, viewGroup, false);
        this.L = Y(o.S);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(s.J4);
        this.f37462k = swipeRefreshLayout;
        swipeRefreshLayout.setEnabled(false);
        this.f37462k.setRefreshing(true);
        this.f37454d = (TextView) inflate.findViewById(s.f26791u5);
        this.f37455e = (TextView) inflate.findViewById(s.f26800w0);
        View findViewById = inflate.findViewById(s.K);
        this.P0 = findViewById;
        findViewById.setOnClickListener(this);
        inflate.findViewById(s.f26806x).setOnClickListener(this);
        View findViewById2 = inflate.findViewById(s.J);
        this.O0 = findViewById2;
        findViewById2.setOnClickListener(this);
        this.P = (PercentView) inflate.findViewById(s.f26774s2);
        View findViewById3 = inflate.findViewById(s.T0);
        this.J0 = findViewById3;
        findViewById3.setOnClickListener(this);
        this.Q = (HeartRateView) inflate.findViewById(s.R0);
        this.f37482u = (ImageView) inflate.findViewById(s.f26690g1);
        this.R = (RelativeLayout) inflate.findViewById(s.f26808x1);
        this.S = (TextView) inflate.findViewById(s.Q0);
        this.T = (TextView) inflate.findViewById(s.U0);
        this.U = (TextView) inflate.findViewById(s.S0);
        this.V = (SpeedView) inflate.findViewById(s.G3);
        this.W = (TextView) inflate.findViewById(s.F3);
        this.f37461j0 = (TextView) inflate.findViewById(s.H3);
        inflate.findViewById(s.f26705i2).setOnClickListener(this);
        this.f37463k0 = (PaceView) inflate.findViewById(s.f26698h2);
        this.f37465l0 = (TextView) inflate.findViewById(s.f26691g2);
        this.f37467m0 = (TextView) inflate.findViewById(s.f26712j2);
        this.f37469n0 = (LinearLayout) inflate.findViewById(s.f26787u1);
        this.f37471o0 = (LinearLayout) inflate.findViewById(s.f26704i1);
        this.f37473p0 = (StrideView) inflate.findViewById(s.f26763q4);
        this.f37475q0 = (TextView) inflate.findViewById(s.f26756p4);
        this.f37477r0 = (StrideView) inflate.findViewById(s.f26749o4);
        this.f37479s0 = (TextView) inflate.findViewById(s.f26742n4);
        inflate.findViewById(s.f26740n2).setOnClickListener(this);
        this.f37487w0 = (ImageView) inflate.findViewById(s.f26747o2);
        this.f37489x0 = (TextView) inflate.findViewById(s.f26754p2);
        this.f37481t0 = (ViewGroup) inflate.findViewById(s.G1);
        this.f37483u0 = ah.c.a().r(this.f37481t0);
        this.f37491y0 = (TextView) inflate.findViewById(s.f26733m2);
        this.f37493z0 = inflate.findViewById(s.f26761q2);
        this.A0 = (TextView) inflate.findViewById(s.f26726l2);
        B0();
        this.B0 = (TrainingView) inflate.findViewById(s.f26729l5);
        this.f37464l = (TextView) inflate.findViewById(s.f26759q0);
        this.f37466m = (TextView) inflate.findViewById(s.f26779t0);
        this.f37468n = (ImageView) inflate.findViewById(s.f26753p1);
        this.Q0 = (ViewGroup) inflate.findViewById(s.f26819y5);
        this.R0 = (TextView) inflate.findViewById(s.f26826z5);
        this.f37474q = (TextView) inflate.findViewById(s.P);
        this.f37470o = (TextView) inflate.findViewById(s.f26793v0);
        this.f37472p = (TextView) inflate.findViewById(s.O);
        this.f37476r = (TextView) inflate.findViewById(s.f26676e1);
        this.f37480t = (TextView) inflate.findViewById(s.f26683f1);
        this.f37478s = (TextView) inflate.findViewById(s.O0);
        this.f37484v = (RelativeLayout) inflate.findViewById(s.f26815y1);
        this.f37486w = (TextView) inflate.findViewById(s.J3);
        this.f37488x = (TextView) inflate.findViewById(s.E3);
        this.f37490y = (TextView) inflate.findViewById(s.K3);
        this.f37492z = (TextView) inflate.findViewById(s.L4);
        this.A = (TextView) inflate.findViewById(s.M4);
        this.B = (TextView) inflate.findViewById(s.N4);
        this.C = (RelativeLayout) inflate.findViewById(s.f26674e);
        this.D = (TextView) inflate.findViewById(s.f26667d);
        this.E = (TextView) inflate.findViewById(s.f26688g);
        this.F = (RatingBar) inflate.findViewById(s.f26681f);
        this.G = (RelativeLayout) inflate.findViewById(s.f26814y0);
        this.H = (TextView) inflate.findViewById(s.A0);
        this.I = (TextView) inflate.findViewById(s.f26821z0);
        this.J = (TextView) inflate.findViewById(s.B0);
        this.K = (TextView) inflate.findViewById(s.f26807x0);
        this.M = (RelativeLayout) inflate.findViewById(s.f26669d1);
        this.N = (RelativeLayout) inflate.findViewById(s.I3);
        this.O = (RelativeLayout) inflate.findViewById(s.f26719k2);
        this.C0 = (RelativeLayout) inflate.findViewById(s.f26769r4);
        this.D0 = (RelativeLayout) inflate.findViewById(s.f26776s4);
        this.E0 = (RelativeLayout) inflate.findViewById(s.f26767r2);
        this.F0 = (RelativeLayout) inflate.findViewById(s.f26736m5);
        this.H0 = (TextView) inflate.findViewById(s.f26722k5);
        HealthSportSwimmingView healthSportSwimmingView = (HealthSportSwimmingView) inflate.findViewById(s.I4);
        this.G0 = healthSportSwimmingView;
        healthSportSwimmingView.findViewById(s.f26797v4).setOnClickListener(this);
        this.G0.findViewById(s.f26811x4).setOnClickListener(this);
        this.f37469n0.setOnClickListener(this);
        this.f37468n.setOnClickListener(this);
        A0();
        return inflate;
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.f37459i) {
            com.mobvoi.health.companion.system.c.a().j(ta.a.x(), ta.a.d(), false);
        }
        dh.a aVar = this.f37485v0;
        if (aVar != null) {
            aVar.a();
        }
        Dialog dialog = this.K0;
        if (dialog != null && dialog.isShowing()) {
            this.K0.dismiss();
            this.K0 = null;
        }
        Dialog dialog2 = this.W0;
        if (dialog2 != null && dialog2.isShowing()) {
            this.W0.dismiss();
            this.W0 = null;
        }
        jc.a aVar2 = this.L0;
        if (aVar2 != null && aVar2.isShowing()) {
            this.L0.dismiss();
            this.L0 = null;
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dh.a aVar = this.f37485v0;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // nf.e, nf.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        dh.a aVar = this.f37485v0;
        if (aVar != null) {
            aVar.c();
        }
    }
}
