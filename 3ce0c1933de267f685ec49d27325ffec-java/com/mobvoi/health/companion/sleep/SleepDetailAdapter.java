package com.mobvoi.health.companion.sleep;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.health.companion.sleep.SleepDetailAdapter;
import com.mobvoi.health.companion.sleep.view.SleepDetailDepthView;
import com.mobvoi.health.companion.sleep.view.SleepDetailHeartRateView;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import com.mobvoi.sleep.ui.view.MorningPulseView;
import fg.o;
import fg.s;
import fg.t;
import fg.u;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sg.d;
import zj.c;
/* loaded from: classes2.dex */
public class SleepDetailAdapter extends BaseMultiItemQuickAdapter<d, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f18554a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.Adapter<RecyclerView.b0> {

        /* renamed from: a  reason: collision with root package name */
        private List<SleepRecord.TimeType> f18555a;

        /* renamed from: b  reason: collision with root package name */
        private Map<SleepRecord.TimeType, Integer> f18556b;

        /* renamed from: c  reason: collision with root package name */
        SleepRecord f18557c;

        /* loaded from: classes2.dex */
        private static class a extends RecyclerView.b0 {

            /* renamed from: a  reason: collision with root package name */
            TextView f18558a;

            /* renamed from: b  reason: collision with root package name */
            TextView f18559b;

            /* renamed from: c  reason: collision with root package name */
            TextView f18560c;

            /* renamed from: d  reason: collision with root package name */
            TextView f18561d;

            /* renamed from: e  reason: collision with root package name */
            SleepPercentView f18562e;

            a(View view) {
                super(view);
                this.f18558a = (TextView) view.findViewById(s.R4);
                TextView textView = (TextView) view.findViewById(s.U4);
                this.f18560c = (TextView) view.findViewById(s.S4);
                this.f18559b = (TextView) view.findViewById(s.V4);
                this.f18561d = (TextView) view.findViewById(s.T4);
                this.f18562e = (SleepPercentView) view.findViewById(s.f26781t2);
            }

            public void a(SleepRecord.TimeType timeType, SleepRecord sleepRecord, Map<SleepRecord.TimeType, Integer> map) {
                int c10 = zj.a.c(this.f18558a.getContext(), timeType);
                this.f18558a.setTextColor(c10);
                TextView textView = this.f18558a;
                textView.setText(zj.d.f(textView.getContext(), timeType));
                int d10 = zj.d.d(sleepRecord.g(timeType));
                int i10 = d10 / 60;
                int i11 = d10 % 60;
                if (i10 > 0) {
                    this.f18559b.setText(String.valueOf(i11));
                    this.f18561d.setText(String.valueOf(i10));
                    this.f18560c.setVisibility(0);
                    this.f18561d.setVisibility(0);
                } else {
                    this.f18559b.setText(String.valueOf(i11));
                    this.f18560c.setVisibility(8);
                    this.f18561d.setVisibility(8);
                }
                this.f18562e.b(c10, map.get(timeType).intValue());
            }
        }

        private b() {
            this.f18555a = new ArrayList();
            this.f18556b = new HashMap();
        }

        private void c() {
            SleepRecord.TimeType timeType;
            long g10 = this.f18557c.g(SleepRecord.TimeType.InBed);
            NumberFormat.getInstance().setMaximumFractionDigits(2);
            for (int i10 = 0; i10 < this.f18555a.size(); i10++) {
                this.f18556b.put(this.f18555a.get(i10), Integer.valueOf(g10 == 0 ? 0 : new BigDecimal((((float) this.f18557c.g(timeType)) * 100.0f) / ((float) g10)).setScale(0, 4).intValue()));
            }
        }

        public void d(SleepRecord sleepRecord) {
            this.f18557c = sleepRecord;
            this.f18556b.clear();
            if (sleepRecord == null) {
                this.f18555a = new ArrayList();
            } else {
                this.f18555a.add(SleepRecord.TimeType.Awake);
                this.f18555a.add(SleepRecord.TimeType.Rem);
                this.f18555a.add(SleepRecord.TimeType.LightSleep);
                this.f18555a.add(SleepRecord.TimeType.DeepSleep);
                c();
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<SleepRecord.TimeType> list = this.f18555a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
            if (b0Var instanceof a) {
                ((a) b0Var).a(this.f18555a.get(i10), this.f18557c, this.f18556b);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.b0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(t.V, viewGroup, false));
        }
    }

    public SleepDetailAdapter(Context context, List<d> list) {
        super(list);
        this.f18554a = context;
        addItemType(0, t.S);
        addItemType(1, t.f26846t);
        addItemType(2, t.f26849w);
        addItemType(3, t.f26848v);
        addItemType(4, t.f26845s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(TextView textView, TextView textView2, int i10, int i11) {
        String str = "--";
        textView.setText(i10 > 0 ? String.valueOf(i10) : str);
        if (i11 > 0) {
            str = String.valueOf(i11);
        }
        textView2.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void convert(BaseViewHolder baseViewHolder, d dVar) {
        int itemType = dVar.getItemType();
        SleepRecord sleepRecord = dVar.f34422b;
        if (itemType == 0) {
            TextView textView = (TextView) baseViewHolder.getView(s.X4);
            TextView textView2 = (TextView) baseViewHolder.getView(s.Y4);
            TextView textView3 = (TextView) baseViewHolder.getView(s.Z4);
            SpannableString spannableString = new SpannableString(String.valueOf(sleepRecord.f20743g));
            ((TextView) baseViewHolder.getView(s.f26720k3)).setText(((Object) spannableString) + "%");
            int d10 = zj.d.d(sleepRecord.g(SleepRecord.TimeType.InBed));
            int i10 = d10 / 60;
            int i11 = d10 % 60;
            if (i10 > 0) {
                textView2.setVisibility(0);
                textView.setVisibility(0);
                textView.setText(String.valueOf(i10));
                textView3.setText(String.valueOf(i11));
                return;
            }
            textView2.setVisibility(8);
            textView.setVisibility(8);
            textView3.setText(String.valueOf(i11));
        } else if (itemType == 1) {
            ((SleepDetailDepthView) baseViewHolder.getView(s.D3)).setSleepRecord(sleepRecord);
            RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(s.f26762q3);
            b bVar = new b();
            recyclerView.setLayoutManager(new LinearLayoutManager(this.f18554a));
            recyclerView.setAdapter(bVar);
            recyclerView.setNestedScrollingEnabled(false);
            bVar.d(sleepRecord);
        } else if (itemType == 2) {
            SleepDetailHeartRateView sleepDetailHeartRateView = (SleepDetailHeartRateView) baseViewHolder.getView(s.O0);
            ((SleepDetailDepthView) baseViewHolder.getView(s.f26678e3)).h(sleepRecord, false, true);
            sleepDetailHeartRateView.f(zj.b.a(sleepRecord), sleepRecord.f20740d, sleepRecord.f20741e);
            final TextView textView4 = (TextView) baseViewHolder.getView(s.X0);
            final TextView textView5 = (TextView) baseViewHolder.getView(s.V0);
            TextView textView6 = (TextView) baseViewHolder.getView(s.Q0);
            sleepDetailHeartRateView.setSleepHeartRateCallback(new SleepDetailHeartRateView.a() { // from class: sg.c
                @Override // com.mobvoi.health.companion.sleep.view.SleepDetailHeartRateView.a
                public final void a(int i12, int i13) {
                    SleepDetailAdapter.e(textView4, textView5, i12, i13);
                }
            });
            float f10 = sleepRecord.f20744h;
            textView6.setText(f10 > 0.0f ? String.valueOf(Math.round(f10)) : "--");
        } else if (itemType == 3) {
            ((MorningPulseView) baseViewHolder.getView(s.W1)).h(c.b(sleepRecord), c.a(sleepRecord));
        } else if (itemType == 4) {
            TextView textView7 = (TextView) baseViewHolder.getView(s.H);
            TextView textView8 = (TextView) baseViewHolder.getView(s.I);
            TextView textView9 = (TextView) baseViewHolder.getView(s.D);
            TextView textView10 = (TextView) baseViewHolder.getView(s.F);
            SleepBloodOxygenView sleepBloodOxygenView = (SleepBloodOxygenView) baseViewHolder.getView(s.P2);
            if (sleepRecord != null) {
                if (sleepRecord.f() != null) {
                    textView8.setText(sleepRecord.f().avg + "%");
                    textView9.setText(sleepRecord.f().max + "%");
                    textView10.setText(sleepRecord.f().min + "%");
                    if (sleepRecord.f().avg >= 95) {
                        textView7.setTextColor(this.f18554a.getResources().getColor(o.f26448b));
                        textView7.setText(u.f26896h);
                    } else {
                        textView7.setTextColor(this.f18554a.getResources().getColor(o.f26446a));
                        textView7.setText(u.f26890g);
                    }
                }
                sleepBloodOxygenView.setSleepBloodOxygen(sleepRecord.f());
            }
        }
    }
}
