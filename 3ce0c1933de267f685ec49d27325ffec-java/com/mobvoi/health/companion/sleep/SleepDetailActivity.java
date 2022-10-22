package com.mobvoi.health.companion.sleep;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.companion.HealthSleepDetailsActivity;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.sleep.SleepDetailActivity;
import com.mobvoi.health.companion.sleep.c;
import com.mobvoi.health.companion.sleep.view.SleepDetailBloodOxygenView;
import com.mobvoi.health.companion.sleep.view.SleepHeartRateView;
import com.mobvoi.health.companion.sleep.view.SleepTypePercentBar;
import com.mobvoi.health.companion.sleep.view.SleepTypeView;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.wear.util.LogCleaner;
import fg.l;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import jh.h;
import nf.k;
import sg.e;
/* loaded from: classes2.dex */
public class SleepDetailActivity extends h implements k<com.mobvoi.health.companion.sleep.c> {
    private static final long G = TimeUnit.DAYS.toMillis(1);
    private long B = 82800000;
    private long C = 28800000;
    private String D;
    private String E;
    private boolean F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends jh.a<com.mobvoi.health.companion.sleep.c> {
        private TextView A;
        private RecyclerView B;
        private TextView C;
        private View D;

        /* renamed from: c  reason: collision with root package name */
        private SleepTypeView f18502c;

        /* renamed from: d  reason: collision with root package name */
        private SleepTypePercentBar f18503d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18504e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18505f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18506g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18507h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18508i;

        /* renamed from: j  reason: collision with root package name */
        private TextView f18509j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f18510k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f18511l;

        /* renamed from: m  reason: collision with root package name */
        private TextView f18512m;

        /* renamed from: n  reason: collision with root package name */
        private TextView f18513n;

        /* renamed from: o  reason: collision with root package name */
        private TextView f18514o;

        /* renamed from: p  reason: collision with root package name */
        private TextView f18515p;

        /* renamed from: q  reason: collision with root package name */
        private TextView f18516q;

        /* renamed from: r  reason: collision with root package name */
        private View f18517r;

        /* renamed from: s  reason: collision with root package name */
        private SleepHeartRateView f18518s;

        /* renamed from: t  reason: collision with root package name */
        private SleepDetailBloodOxygenView f18519t;

        /* renamed from: u  reason: collision with root package name */
        private TextView f18520u;

        /* renamed from: v  reason: collision with root package name */
        private TextView f18521v;

        /* renamed from: w  reason: collision with root package name */
        private TextView f18522w;

        /* renamed from: x  reason: collision with root package name */
        private TextView f18523x;

        /* renamed from: y  reason: collision with root package name */
        private TextView f18524y;

        /* renamed from: z  reason: collision with root package name */
        private TextView f18525z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mobvoi.health.companion.sleep.SleepDetailActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class View$OnClickListenerC0217a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ SleepRecord f18526a;

            View$OnClickListenerC0217a(SleepRecord sleepRecord) {
                this.f18526a = sleepRecord;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(SleepDetailActivity.this, HealthSleepDetailsActivity.class);
                intent.putExtra("sportId", this.f18526a.f20737a);
                SleepDetailActivity.this.startActivityForResult(intent, 16);
            }
        }

        public a(View view) {
            super(view);
            this.D = view.findViewById(s.V2);
            view.findViewById(s.T2).setVisibility(SleepDetailActivity.this.F ? 0 : 8);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(s.B2);
            this.B = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(SleepDetailActivity.this));
            this.B.setNestedScrollingEnabled(false);
            this.f18502c = (SleepTypeView) view.findViewById(s.C3);
            this.f18503d = (SleepTypePercentBar) view.findViewById(s.f26824z3);
            this.f18516q = (TextView) view.findViewById(s.f26664c3);
            this.f18517r = view.findViewById(s.f26671d3);
            this.f18504e = (TextView) view.findViewById(s.f26775s3);
            this.f18508i = (TextView) view.findViewById(s.f26782t3);
            this.f18505f = (TextView) view.findViewById(s.A3);
            this.f18509j = (TextView) view.findViewById(s.B3);
            this.f18506g = (TextView) view.findViewById(s.f26803w3);
            this.f18510k = (TextView) view.findViewById(s.f26810x3);
            this.f18507h = (TextView) view.findViewById(s.f26789u3);
            this.f18511l = (TextView) view.findViewById(s.f26796v3);
            this.f18512m = (TextView) view.findViewById(s.f26758q);
            this.f18513n = (TextView) view.findViewById(s.W0);
            this.f18514o = (TextView) view.findViewById(s.Y0);
            this.f18515p = (TextView) view.findViewById(s.f26751p);
            this.C = (TextView) view.findViewById(s.Q2);
            this.f18521v = (TextView) view.findViewById(s.f26713j3);
            this.f18522w = (TextView) view.findViewById(s.f26755p3);
            this.f18523x = (TextView) view.findViewById(s.f26692g3);
            this.f18524y = (TextView) view.findViewById(s.f26706i3);
            TextView textView = (TextView) view.findViewById(s.f26685f3);
            TextView textView2 = (TextView) view.findViewById(s.f26699h3);
            this.f18520u = (TextView) view.findViewById(s.R2);
            this.f18525z = (TextView) view.findViewById(s.C);
            this.A = (TextView) view.findViewById(s.E);
            this.f18518s = (SleepHeartRateView) view.findViewById(s.f26678e3);
            this.f18519t = (SleepDetailBloodOxygenView) view.findViewById(s.S2);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(com.mobvoi.health.companion.sleep.c cVar) {
            c.b bVar;
            String str;
            String str2;
            String str3;
            String string = SleepDetailActivity.this.getString(u.f26877d4);
            if (cVar == null || (bVar = cVar.f18624d) == null) {
                this.f18525z.setText("-");
                this.A.setText("-");
                TextView textView = this.f18520u;
                SleepDetailActivity sleepDetailActivity = SleepDetailActivity.this;
                int i10 = u.N2;
                textView.setText(sleepDetailActivity.getString(i10));
                this.C.setVisibility(8);
                this.f18518s.setSleepRecord(null);
                this.f18512m.setText(SleepDetailActivity.this.getString(i10));
                this.f18513n.setText("-");
                this.f18514o.setText("-");
                this.f18503d.setPercents(null);
                this.f18522w.setText(SleepDetailActivity.this.getString(u.P1));
                this.f18523x.setText("0");
                this.f18524y.setText("0");
                this.f18502c.setSleepRecord(null);
                this.B.setAdapter(null);
                this.f18517r.setVisibility(8);
                this.f18521v.setVisibility(8);
                this.f18504e.setText(SleepDetailActivity.this.getString(u.T4) + " 0" + string);
                this.f18505f.setText(SleepDetailActivity.this.getString(u.W4) + " 0" + string);
                this.f18506g.setText(SleepDetailActivity.this.getString(u.V4) + " 0" + string);
                this.f18507h.setText(SleepDetailActivity.this.getString(u.U4) + " 0" + string);
                SleepDetailActivity.this.l1(this.f18508i, 0L);
                SleepDetailActivity.this.l1(this.f18509j, 0L);
                SleepDetailActivity.this.l1(this.f18510k, 0L);
                SleepDetailActivity.this.l1(this.f18511l, 0L);
                return;
            }
            this.f18502c.setSleepRecord(bVar.f18637b);
            ArrayList arrayList = new ArrayList();
            c.b bVar2 = cVar.f18624d;
            arrayList.add(new e(bVar2.f18638c, bVar2.f18643h, SleepRecord.TimeType.Awake));
            c.b bVar3 = cVar.f18624d;
            arrayList.add(new e(bVar3.f18639d, bVar3.f18644i, SleepRecord.TimeType.Rem));
            c.b bVar4 = cVar.f18624d;
            arrayList.add(new e(bVar4.f18640e, bVar4.f18645j, SleepRecord.TimeType.LightSleep));
            c.b bVar5 = cVar.f18624d;
            arrayList.add(new e(bVar5.f18641f, bVar5.f18646k, SleepRecord.TimeType.DeepSleep));
            this.f18503d.setPercents(arrayList);
            this.f18504e.setText(SleepDetailActivity.this.getString(u.T4) + " " + cVar.f18624d.f18638c + string);
            this.f18505f.setText(SleepDetailActivity.this.getString(u.W4) + " " + cVar.f18624d.f18639d + string);
            this.f18506g.setText(SleepDetailActivity.this.getString(u.V4) + " " + cVar.f18624d.f18640e + string);
            this.f18507h.setText(SleepDetailActivity.this.getString(u.U4) + " " + cVar.f18624d.f18641f + string);
            SleepDetailActivity.this.l1(this.f18508i, cVar.f18624d.f18643h);
            SleepDetailActivity.this.l1(this.f18509j, cVar.f18624d.f18644i);
            SleepDetailActivity.this.l1(this.f18510k, cVar.f18624d.f18645j);
            SleepDetailActivity.this.l1(this.f18511l, cVar.f18624d.f18646k);
            SleepRecord sleepRecord = cVar.f18624d.f18637b;
            this.f18518s.setSleepRecord(sleepRecord);
            if (sleepRecord != null) {
                this.f18515p.setVisibility(0);
                TextView textView2 = this.f18512m;
                float f10 = sleepRecord.f20744h;
                textView2.setText(f10 > 0.0f ? String.valueOf(Math.round(f10)) : SleepDetailActivity.this.getString(u.N2));
                TextView textView3 = this.f18513n;
                float f11 = sleepRecord.f20746j;
                textView3.setText(f11 > 0.0f ? String.valueOf(Math.round(f11)) : "-");
                TextView textView4 = this.f18514o;
                float f12 = sleepRecord.f20745i;
                textView4.setText(f12 > 0.0f ? String.valueOf(Math.round(f12)) : "-");
                this.f18519t.c(sleepRecord.f(), sleepRecord.f20740d, sleepRecord.f20741e);
                if (sleepRecord.f() != null) {
                    yj.d f13 = sleepRecord.f();
                    String string2 = SleepDetailActivity.this.getString(u.X2);
                    TextView textView5 = this.f18525z;
                    if (f13.max > 0) {
                        str = f13.max + string2;
                    } else {
                        str = "-";
                    }
                    textView5.setText(str);
                    TextView textView6 = this.A;
                    if (f13.min > 0) {
                        str2 = f13.min + string2;
                    } else {
                        str2 = "-";
                    }
                    textView6.setText(str2);
                    TextView textView7 = this.f18520u;
                    if (f13.avg > 0) {
                        str3 = f13.avg + string2;
                    } else {
                        str3 = SleepDetailActivity.this.getString(u.N2);
                    }
                    textView7.setText(str3);
                    this.C.setVisibility(0);
                    if (sleepRecord.f().a()) {
                        this.C.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26448b));
                        this.C.setText(u.f26896h);
                    } else {
                        this.C.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26446a));
                        this.C.setText(u.f26890g);
                    }
                } else {
                    this.f18525z.setText("-");
                    this.A.setText("-");
                }
                if (TextUtils.isEmpty(sleepRecord.f20747k)) {
                    this.f18517r.setVisibility(8);
                } else {
                    this.f18517r.setVisibility(0);
                    this.f18516q.setText(sleepRecord.f20747k);
                }
                int d10 = zj.d.d(sleepRecord.g(SleepRecord.TimeType.InBed));
                this.f18523x.setText(String.valueOf(d10 / 60));
                this.f18524y.setText(String.valueOf(d10 % 60));
                String charSequence = zj.d.a(SleepDetailActivity.this, sleepRecord.f20740d).toString();
                String charSequence2 = zj.d.a(SleepDetailActivity.this, sleepRecord.f20741e).toString();
                this.f18522w.setText(charSequence + "-" + charSequence2);
                this.f18521v.setVisibility(0);
                this.f18521v.setText(SleepDetailActivity.this.getString(u.f26941o2) + " " + sleepRecord.f20743g + string);
                this.D.setOnClickListener(new View$OnClickListenerC0217a(sleepRecord));
            } else {
                this.f18517r.setVisibility(8);
                this.f18521v.setVisibility(8);
            }
            List<SleepRecord> list = cVar.f18624d.f18636a;
            if (list == null || list.size() <= 0) {
                this.B.setAdapter(null);
            } else {
                this.B.setAdapter(new b(cVar.f18624d.f18636a));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends BaseQuickAdapter<SleepRecord, BaseViewHolder> {
        public b(List<SleepRecord> list) {
            super(t.f26841o, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(SleepRecord sleepRecord, View view) {
            Intent intent = new Intent(SleepDetailActivity.this, HealthSleepDetailsActivity.class);
            intent.putExtra("sportId", sleepRecord.f20737a);
            SleepDetailActivity.this.startActivityForResult(intent, 16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public void convert(BaseViewHolder baseViewHolder, final SleepRecord sleepRecord) {
            SleepTypePercentBar sleepTypePercentBar;
            long j10;
            ((TextView) baseViewHolder.getView(s.f26748o3)).setText(zj.d.a(SleepDetailActivity.this, sleepRecord.f20740d).toString() + "-" + zj.d.a(SleepDetailActivity.this, sleepRecord.f20741e).toString());
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.health.companion.sleep.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SleepDetailActivity.b.this.e(sleepRecord, view);
                }
            });
            ((TextView) baseViewHolder.getView(s.f26713j3)).setText(SleepDetailActivity.this.getString(u.f26941o2) + " " + sleepRecord.f20743g + SleepDetailActivity.this.getString(u.f26877d4));
            long g10 = sleepRecord.g(SleepRecord.TimeType.InBed);
            int d10 = zj.d.d(g10);
            TextView textView = (TextView) baseViewHolder.getView(s.f26685f3);
            TextView textView2 = (TextView) baseViewHolder.getView(s.f26699h3);
            ((TextView) baseViewHolder.getView(s.f26692g3)).setText(String.valueOf(d10 / 60));
            ((TextView) baseViewHolder.getView(s.f26706i3)).setText(String.valueOf(d10 % 60));
            SleepTypePercentBar sleepTypePercentBar2 = (SleepTypePercentBar) baseViewHolder.getView(s.f26824z3);
            SleepRecord.TimeType timeType = SleepRecord.TimeType.Awake;
            long longValue = sleepRecord.e(timeType) == null ? 0L : sleepRecord.e(timeType).longValue();
            SleepRecord.TimeType timeType2 = SleepRecord.TimeType.Rem;
            long longValue2 = sleepRecord.e(timeType2) == null ? 0L : sleepRecord.e(timeType2).longValue();
            SleepRecord.TimeType timeType3 = SleepRecord.TimeType.LightSleep;
            long longValue3 = sleepRecord.e(timeType3) == null ? 0L : sleepRecord.e(timeType3).longValue();
            SleepRecord.TimeType timeType4 = SleepRecord.TimeType.DeepSleep;
            if (sleepRecord.e(timeType4) == null) {
                sleepTypePercentBar = sleepTypePercentBar2;
                j10 = 0;
            } else {
                j10 = sleepRecord.e(timeType4).longValue();
                sleepTypePercentBar = sleepTypePercentBar2;
            }
            SleepRecord.TimeType timeType5 = SleepRecord.TimeType.FallAsleep;
            long[] jArr = {longValue, longValue2, longValue3, j10, sleepRecord.e(timeType5) == null ? 0L : sleepRecord.e(timeType5).longValue()};
            double d11 = g10;
            int b10 = (int) l.b(jArr, d11, 1, 0);
            l.b(jArr, d11, 4, 0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new e((int) l.b(jArr, d11, 0, 0), longValue, timeType));
            arrayList.add(new e(b10, longValue2, timeType2));
            arrayList.add(new e((int) l.b(jArr, d11, 2, 0), longValue3, timeType3));
            arrayList.add(new e((int) l.b(jArr, d11, 3, 0), j10, timeType4));
            sleepTypePercentBar.setPercents(arrayList);
        }
    }

    /* loaded from: classes2.dex */
    class c extends androidx.viewpager.widget.a {
        c() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((jh.a) obj).a());
            ((h) SleepDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) SleepDetailActivity.this).f29607n == 2) {
                return ((h) SleepDetailActivity.this).f29598e.size();
            }
            if (((h) SleepDetailActivity.this).f29607n == 3) {
                return ((h) SleepDetailActivity.this).f29599f.size();
            }
            if (((h) SleepDetailActivity.this).f29607n == 1) {
                return ((h) SleepDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            Context context = viewGroup.getContext();
            if (((h) SleepDetailActivity.this).f29607n == 1) {
                a aVar = new a(LayoutInflater.from(context).inflate(t.f26840n, viewGroup, false));
                aVar.b(i10);
                viewGroup.addView(aVar.a());
                ((h) SleepDetailActivity.this).f29600g.put(i10, aVar);
                return aVar;
            }
            d dVar = new d(LayoutInflater.from(context).inflate(t.f26842p, viewGroup, false));
            dVar.b(i10);
            viewGroup.addView(dVar.a());
            ((h) SleepDetailActivity.this).f29600g.put(i10, dVar);
            return dVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return view == ((jh.a) obj).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends jh.a<com.mobvoi.health.companion.sleep.c> {
        private TextView A;
        private TextView B;
        private ImageView C;
        private TextView D;
        private TextView E;
        private ImageView F;
        private TextView G;
        private TextView H;
        private ImageView I;
        private TextView J;
        private TextView K;

        /* renamed from: c  reason: collision with root package name */
        private View f18530c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18531d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18532e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18533f;

        /* renamed from: g  reason: collision with root package name */
        private SleepDetailView f18534g;

        /* renamed from: h  reason: collision with root package name */
        private SleepTypePercentBar f18535h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18536i;

        /* renamed from: j  reason: collision with root package name */
        private TextView f18537j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f18538k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f18539l;

        /* renamed from: m  reason: collision with root package name */
        private TextView f18540m;

        /* renamed from: n  reason: collision with root package name */
        private TextView f18541n;

        /* renamed from: o  reason: collision with root package name */
        private TextView f18542o;

        /* renamed from: p  reason: collision with root package name */
        private TextView f18543p;

        /* renamed from: q  reason: collision with root package name */
        private TextView f18544q;

        /* renamed from: r  reason: collision with root package name */
        private TextView f18545r;

        /* renamed from: s  reason: collision with root package name */
        private TextView f18546s;

        /* renamed from: t  reason: collision with root package name */
        private ImageView f18547t;

        /* renamed from: u  reason: collision with root package name */
        private TextView f18548u;

        /* renamed from: v  reason: collision with root package name */
        private TextView f18549v;

        /* renamed from: w  reason: collision with root package name */
        private TextView f18550w;

        /* renamed from: x  reason: collision with root package name */
        private TextView f18551x;

        /* renamed from: y  reason: collision with root package name */
        private TextView f18552y;

        /* renamed from: z  reason: collision with root package name */
        private TextView f18553z;

        public d(View view) {
            super(view);
            this.f18530c = view.findViewById(s.f26746o1);
            this.f18531d = (TextView) view.findViewById(s.f26732m1);
            this.f18532e = (TextView) view.findViewById(s.f26739n1);
            this.f18533f = (TextView) view.findViewById(s.f26725l1);
            this.f18534g = (SleepDetailView) view.findViewById(s.X2);
            this.f18535h = (SleepTypePercentBar) view.findViewById(s.f26817y3);
            this.K = (TextView) view.findViewById(s.O2);
            this.f18536i = (TextView) view.findViewById(s.f26775s3);
            this.f18540m = (TextView) view.findViewById(s.f26782t3);
            this.f18537j = (TextView) view.findViewById(s.A3);
            this.f18541n = (TextView) view.findViewById(s.B3);
            this.f18538k = (TextView) view.findViewById(s.f26803w3);
            this.f18542o = (TextView) view.findViewById(s.f26810x3);
            this.f18539l = (TextView) view.findViewById(s.f26789u3);
            this.f18543p = (TextView) view.findViewById(s.f26796v3);
            this.f18544q = (TextView) view.findViewById(s.f26692g3);
            this.f18545r = (TextView) view.findViewById(s.f26706i3);
            TextView textView = (TextView) view.findViewById(s.f26685f3);
            TextView textView2 = (TextView) view.findViewById(s.f26699h3);
            this.f18546s = (TextView) view.findViewById(s.Y);
            this.f18547t = (ImageView) view.findViewById(s.X);
            this.f18548u = (TextView) view.findViewById(s.B1);
            TextView textView3 = (TextView) view.findViewById(s.A1);
            this.f18549v = (TextView) view.findViewById(s.D1);
            TextView textView4 = (TextView) view.findViewById(s.C1);
            this.f18550w = (TextView) view.findViewById(s.f26822z1);
            this.f18551x = (TextView) view.findViewById(s.L2);
            TextView textView5 = (TextView) view.findViewById(s.K2);
            this.f18552y = (TextView) view.findViewById(s.N2);
            TextView textView6 = (TextView) view.findViewById(s.M2);
            this.f18553z = (TextView) view.findViewById(s.J2);
            this.A = (TextView) view.findViewById(s.f26723l);
            this.B = (TextView) view.findViewById(s.f26709j);
            this.C = (ImageView) view.findViewById(s.f26716k);
            this.D = (TextView) view.findViewById(s.f26744o);
            this.E = (TextView) view.findViewById(s.f26730m);
            this.F = (ImageView) view.findViewById(s.f26737n);
            this.G = (TextView) view.findViewById(s.f26778t);
            this.H = (TextView) view.findViewById(s.f26764r);
            this.I = (ImageView) view.findViewById(s.f26771s);
            this.J = (TextView) view.findViewById(s.f26758q);
            if (((h) SleepDetailActivity.this).f29607n == 2) {
                this.f18530c.setVisibility(0);
                this.K.setText(u.f26859a5);
            } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                this.f18530c.setVisibility(8);
                this.K.setText(u.Z3);
            }
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(com.mobvoi.health.companion.sleep.c cVar) {
            this.f18534g.d(cVar, ((h) SleepDetailActivity.this).f29607n);
            String string = SleepDetailActivity.this.getString(u.f26877d4);
            if (((h) SleepDetailActivity.this).f29607n == 2) {
                SleepDetailActivity.this.m1(this.f18531d, SleepDetailActivity.this.B > SleepDetailActivity.this.C ? SleepDetailActivity.this.C + (SleepDetailActivity.G - SleepDetailActivity.this.B) : SleepDetailActivity.this.C - SleepDetailActivity.this.B, false);
                SleepDetailActivity sleepDetailActivity = SleepDetailActivity.this;
                sleepDetailActivity.o1(this.f18532e, sleepDetailActivity.B);
                SleepDetailActivity sleepDetailActivity2 = SleepDetailActivity.this;
                sleepDetailActivity2.o1(this.f18533f, sleepDetailActivity2.C);
            }
            if (cVar == null || cVar.f18623c == null) {
                TextView textView = this.f18536i;
                textView.setText(SleepDetailActivity.this.getString(u.T4) + " 0" + string);
                TextView textView2 = this.f18537j;
                textView2.setText(SleepDetailActivity.this.getString(u.W4) + " 0" + string);
                TextView textView3 = this.f18538k;
                textView3.setText(SleepDetailActivity.this.getString(u.V4) + " 0" + string);
                TextView textView4 = this.f18539l;
                textView4.setText(SleepDetailActivity.this.getString(u.U4) + " 0" + string);
                SleepDetailActivity.this.l1(this.f18540m, 0L);
                SleepDetailActivity.this.l1(this.f18541n, 0L);
                SleepDetailActivity.this.l1(this.f18542o, 0L);
                SleepDetailActivity.this.l1(this.f18543p, 0L);
                return;
            }
            ArrayList arrayList = new ArrayList();
            c.d dVar = cVar.f18623c;
            arrayList.add(new e(dVar.f18661k, dVar.f18666p, SleepRecord.TimeType.Awake));
            c.d dVar2 = cVar.f18623c;
            arrayList.add(new e(dVar2.f18662l, dVar2.f18667q, SleepRecord.TimeType.Rem));
            c.d dVar3 = cVar.f18623c;
            arrayList.add(new e(dVar3.f18663m, dVar3.f18668r, SleepRecord.TimeType.LightSleep));
            c.d dVar4 = cVar.f18623c;
            arrayList.add(new e(dVar4.f18664n, dVar4.f18669s, SleepRecord.TimeType.DeepSleep));
            this.f18535h.setPercents(arrayList);
            TextView textView5 = this.f18536i;
            textView5.setText(SleepDetailActivity.this.getString(u.T4) + " " + cVar.f18623c.f18661k + string);
            TextView textView6 = this.f18537j;
            textView6.setText(SleepDetailActivity.this.getString(u.W4) + " " + cVar.f18623c.f18662l + string);
            TextView textView7 = this.f18538k;
            textView7.setText(SleepDetailActivity.this.getString(u.V4) + " " + cVar.f18623c.f18663m + string);
            TextView textView8 = this.f18539l;
            textView8.setText(SleepDetailActivity.this.getString(u.U4) + " " + cVar.f18623c.f18664n + string);
            SleepDetailActivity.this.l1(this.f18540m, cVar.f18623c.f18666p);
            SleepDetailActivity.this.l1(this.f18541n, cVar.f18623c.f18667q);
            SleepDetailActivity.this.l1(this.f18542o, cVar.f18623c.f18668r);
            SleepDetailActivity.this.l1(this.f18543p, cVar.f18623c.f18669s);
            int i10 = (int) (cVar.f18623c.f18655e / LogCleaner.ONE_MINUTE);
            this.f18544q.setText(String.valueOf(i10 / 60));
            this.f18545r.setText(String.valueOf(i10 % 60));
            String j12 = SleepDetailActivity.this.j1(cVar.f18623c.f18673w, false);
            long j10 = cVar.f18623c.f18673w;
            if (j10 == 0) {
                this.f18546s.setVisibility(8);
                this.f18547t.setVisibility(8);
            } else if (j10 > 0) {
                this.f18546s.setVisibility(0);
                this.f18547t.setVisibility(0);
                this.f18546s.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26482s));
                this.f18547t.setImageResource(q.f26603o2);
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.f18546s.setText(String.format(SleepDetailActivity.this.getString(u.f26865b4), j12));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.f18546s.setText(String.format(SleepDetailActivity.this.getString(u.f26858a4), j12));
                }
            } else {
                this.f18546s.setVisibility(0);
                this.f18547t.setVisibility(0);
                this.f18547t.setImageResource(q.Q);
                this.f18546s.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26480r));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.f18546s.setText(String.format(SleepDetailActivity.this.getString(u.W3), j12));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.f18546s.setText(String.format(SleepDetailActivity.this.getString(u.V3), j12));
                }
            }
            SleepDetailActivity.this.n1(this.f18548u, this.f18549v, cVar.f18623c.f18657g);
            this.f18550w.setText(new SimpleDateFormat("MM-dd", Locale.getDefault()).format(new Date(cVar.f18623c.f18658h)));
            SleepDetailActivity.this.n1(this.f18551x, this.f18552y, cVar.f18623c.f18659i);
            this.f18553z.setText(new SimpleDateFormat("MM-dd", Locale.getDefault()).format(new Date(cVar.f18623c.f18660j)));
            SleepDetailActivity.this.o1(this.A, cVar.f18623c.f18653c > SleepDetailActivity.G ? cVar.f18623c.f18653c - SleepDetailActivity.G : cVar.f18623c.f18653c);
            String j13 = SleepDetailActivity.this.j1(cVar.f18623c.f18672v, false);
            long j11 = cVar.f18623c.f18672v;
            if (j11 == 0) {
                this.C.setImageResource(q.R);
                this.B.setVisibility(8);
            } else if (j11 > 0) {
                this.B.setVisibility(0);
                this.C.setImageResource(q.Q);
                this.B.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26480r));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.B.setText(String.format(SleepDetailActivity.this.getString(u.U3), j13));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.B.setText(String.format(SleepDetailActivity.this.getString(u.T3), j13));
                }
            } else {
                this.B.setVisibility(0);
                this.C.setImageResource(q.S);
                this.B.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26472n));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.B.setText(String.format(SleepDetailActivity.this.getString(u.f26980v), j13));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.B.setText(String.format(SleepDetailActivity.this.getString(u.f26974u), j13));
                }
            }
            SleepDetailActivity.this.o1(this.D, cVar.f18623c.f18652b > SleepDetailActivity.G ? cVar.f18623c.f18652b - SleepDetailActivity.G : cVar.f18623c.f18652b);
            String j14 = SleepDetailActivity.this.j1(cVar.f18623c.f18671u, false);
            long j15 = cVar.f18623c.f18671u;
            if (j15 == 0) {
                this.F.setImageResource(q.R);
                this.E.setVisibility(8);
            } else if (j15 > 0) {
                this.E.setVisibility(0);
                this.F.setImageResource(q.Q);
                this.E.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26480r));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.E.setText(String.format(SleepDetailActivity.this.getString(u.U3), j14));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.E.setText(String.format(SleepDetailActivity.this.getString(u.T3), j14));
                }
            } else {
                this.E.setVisibility(0);
                this.F.setImageResource(q.S);
                this.E.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26472n));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.E.setText(String.format(SleepDetailActivity.this.getString(u.f26980v), j14));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.E.setText(String.format(SleepDetailActivity.this.getString(u.f26974u), j14));
                }
            }
            TextView textView9 = this.G;
            textView9.setText(cVar.f18623c.f18654d + string);
            int i11 = cVar.f18623c.f18670t;
            if (i11 == 0) {
                this.I.setImageResource(q.R);
                this.H.setVisibility(8);
            } else if (i11 > 0) {
                this.H.setVisibility(0);
                this.I.setImageResource(q.S);
                this.H.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26472n));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.H.setText(String.format(SleepDetailActivity.this.getString(u.N3), Integer.valueOf(i11)));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.H.setText(String.format(SleepDetailActivity.this.getString(u.M3), Integer.valueOf(i11)));
                }
            } else {
                this.H.setVisibility(0);
                this.I.setImageResource(q.Q);
                this.H.setTextColor(SleepDetailActivity.this.getResources().getColor(o.f26480r));
                if (((h) SleepDetailActivity.this).f29607n == 2) {
                    this.H.setText(String.format(SleepDetailActivity.this.getString(u.Y3), Integer.valueOf(Math.abs(i11))));
                } else if (((h) SleepDetailActivity.this).f29607n == 3) {
                    this.H.setText(String.format(SleepDetailActivity.this.getString(u.X3), Integer.valueOf(Math.abs(i11))));
                }
            }
            this.J.setText(String.valueOf(cVar.f18623c.f18656f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j1(long j10, boolean z10) {
        int d10 = zj.d.d(Math.abs(j10));
        int i10 = d10 / 60;
        int i11 = d10 % 60;
        StringBuffer stringBuffer = new StringBuffer();
        String string = getString(u.f26947p2);
        String string2 = getString(u.f26953q2);
        if (i10 > 0) {
            if (z10) {
                stringBuffer.append(i10);
                stringBuffer.append(" ");
                stringBuffer.append(string);
                stringBuffer.append(" ");
                stringBuffer.append(i11);
                stringBuffer.append(" ");
                stringBuffer.append(string2);
            } else {
                stringBuffer.append(i10);
                stringBuffer.append(string);
                stringBuffer.append(i11);
                stringBuffer.append(string2);
            }
        } else if (z10) {
            stringBuffer.append(i11);
            stringBuffer.append(" ");
            stringBuffer.append(string2);
        } else {
            stringBuffer.append(i11);
            stringBuffer.append(string2);
        }
        return stringBuffer.toString();
    }

    private void k1() {
        long currentTimeMillis = System.currentTimeMillis();
        qf.a aVar = (qf.a) ig.b.J().K().j().j(null, DataType.ExpectedGetUpTime, 0L, currentTimeMillis);
        qf.a aVar2 = (qf.a) ig.b.J().K().j().j(null, DataType.ExpectedSleepTime, 0L, currentTimeMillis);
        this.B = aVar2 == null ? 82800000L : aVar2.e();
        this.C = aVar == null ? 28800000L : aVar.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(TextView textView, long j10) {
        m1(textView, j10, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(TextView textView, long j10, boolean z10) {
        int d10 = zj.d.d(j10);
        int i10 = d10 / 60;
        int i11 = d10 % 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (i10 > 0) {
            if (z10) {
                stringBuffer.append(i10);
                stringBuffer.append(" ");
                stringBuffer.append(this.D);
                stringBuffer.append(" ");
                stringBuffer.append(i11);
                stringBuffer.append(" ");
                stringBuffer.append(this.E);
            } else {
                stringBuffer.append(i10);
                stringBuffer.append(this.D);
                stringBuffer.append(i11);
                stringBuffer.append(this.E);
            }
        } else if (z10) {
            stringBuffer.append(i11);
            stringBuffer.append(" ");
            stringBuffer.append(this.E);
        } else {
            stringBuffer.append(i11);
            stringBuffer.append(this.E);
        }
        textView.setText(stringBuffer.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(TextView textView, TextView textView2, long j10) {
        int d10 = zj.d.d(j10);
        textView.setText(String.valueOf(d10 / 60));
        textView2.setText(String.valueOf(d10 % 60));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(TextView textView, long j10) {
        int d10 = zj.d.d(j10);
        int i10 = d10 / 60;
        int i11 = d10 % 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (i10 < 10) {
            stringBuffer.append(0);
            stringBuffer.append(i10);
        } else {
            stringBuffer.append(i10);
        }
        stringBuffer.append(":");
        if (i11 < 10) {
            stringBuffer.append(0);
            stringBuffer.append(i11);
        } else {
            stringBuffer.append(i11);
        }
        textView.setText(stringBuffer.toString());
    }

    public static void p1(Context context, boolean z10) {
        Intent intent = new Intent(context, SleepDetailActivity.class);
        intent.putExtra("extra.health_data_type", 4);
        intent.putExtra("extra.START_TIME", eg.c.a(System.currentTimeMillis()).getTimeInMillis());
        intent.putExtra("data_type", 1);
        intent.putExtra("data_has_blood_oxygen", z10);
        context.startActivity(intent);
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new c();
    }

    @Override // jh.h
    protected String W() {
        return "sleepCenter";
    }

    @Override // jh.h
    public void Z() {
        Intent intent = new Intent(this, HealthDetailCalendarActivity.class);
        intent.putExtra("date_mills", X());
        intent.putExtra("data_type", this.f29616w);
        startActivityForResult(intent, 10001);
    }

    @Override // jh.h
    protected void i0() {
        t0(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k1();
        this.D = getString(u.f26947p2);
        this.E = getString(u.f26953q2);
        this.F = getIntent().getBooleanExtra("data_has_blood_oxygen", false);
        this.f29606m.o0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.k0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "sleepCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "sleepCenter");
    }

    /* renamed from: q1 */
    public void i(nf.h<com.mobvoi.health.companion.sleep.c> hVar, com.mobvoi.health.companion.sleep.c cVar) {
        jh.a aVar = this.f29600g.get(U());
        if (aVar == null) {
            return;
        }
        if (aVar instanceof a) {
            ((a) aVar).c(cVar);
        } else if (aVar instanceof d) {
            ((d) aVar).c(cVar);
        }
    }
}
