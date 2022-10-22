package com.mobvoi.companion.health;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.health.viewholder.ArrhythmiaCardViewHolder;
import com.mobvoi.companion.health.viewholder.ArtyCardViewHolder;
import com.mobvoi.companion.health.viewholder.AtrialFibrillationCardViewHolder;
import com.mobvoi.companion.health.viewholder.BloodOxygenCardViewHolder;
import com.mobvoi.companion.health.viewholder.BodyMindCardViewHolder;
import com.mobvoi.companion.health.viewholder.CardManagementViewHolder;
import com.mobvoi.companion.health.viewholder.EmptyViewHolder;
import com.mobvoi.companion.health.viewholder.FitnessCardViewHolder;
import com.mobvoi.companion.health.viewholder.HealthCardReportViewHolder;
import com.mobvoi.companion.health.viewholder.HealthCardViewHolder;
import com.mobvoi.companion.health.viewholder.HeartHealth24hDetectViewHolder;
import com.mobvoi.companion.health.viewholder.McuActivityCardViewHolder;
import com.mobvoi.companion.health.viewholder.McuHeartRateCardViewHolder;
import com.mobvoi.companion.health.viewholder.NoiseCardViewHolder;
import com.mobvoi.companion.health.viewholder.PrematureBeatCardViewHolder;
import com.mobvoi.companion.health.viewholder.PressureCardViewHolder;
import com.mobvoi.companion.health.viewholder.PulseCardViewHolder;
import com.mobvoi.companion.health.viewholder.SleepCardViewHolder;
import com.mobvoi.companion.health.viewholder.TemperatureCardViewHolder;
import com.mobvoi.companion.health.viewholder.i;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.f;
import xc.b;
/* compiled from: HomeTabAdapter.kt */
/* loaded from: classes2.dex */
public final class t1 extends RecyclerView.Adapter<i> implements com.mobvoi.companion.health.viewholder.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<tc.i> f17053a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f17054b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Class<?>> f17055c = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private View f17056d;

    /* compiled from: HomeTabAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public t1(List<tc.i> list) {
        kotlin.jvm.internal.i.f(list, "list");
        this.f17053a = list;
        f("EMPTY_CARD_ONLY_CLIENT", EmptyViewHolder.class);
        f("CARD_ARTY_REPORT", ArtyCardViewHolder.class);
        f("CARD_HEALTH_REPORT", HealthCardReportViewHolder.class);
        f("CARD_AW_ACTIVITY", HealthCardViewHolder.class);
        f("CARD_MCU_ACTIVITY", McuActivityCardViewHolder.class);
        f("CARD_SPORT", FitnessCardViewHolder.class);
        f("CARD_SLEEP", SleepCardViewHolder.class);
        f("CARD_AW_HEART_RATE", PulseCardViewHolder.class);
        f("CARD_MCU_HEART_RATE", McuHeartRateCardViewHolder.class);
        f("CARD_BLOOD_OXYGEN", BloodOxygenCardViewHolder.class);
        f("CARD_TEMPERATION", TemperatureCardViewHolder.class);
        f("CARD_PRESSURE", PressureCardViewHolder.class);
        f("CARD_NOISE", NoiseCardViewHolder.class);
        f("CARD_ATRIAL_FIBRILLATION", AtrialFibrillationCardViewHolder.class);
        f("CARD_ARRHYTHMIA", ArrhythmiaCardViewHolder.class);
        f("CARD_PREMATURE_BEAT", PrematureBeatCardViewHolder.class);
        f("CARD_BODY_MIND_STATE", BodyMindCardViewHolder.class);
        f("CARD_HEART_24H_DETECT", HeartHealth24hDetectViewHolder.class);
        f("CARD_MANAGE_ONLY_CLIENT", CardManagementViewHolder.class);
    }

    private final void c(i iVar) {
        View view;
        if ((iVar instanceof EmptyViewHolder) && (view = this.f17056d) != null) {
            ((EmptyViewHolder) iVar).attachBehindView(view);
        }
    }

    private final void f(String str, Class<?> cls) {
        int size = this.f17054b.size() + 1;
        this.f17054b.put(str, Integer.valueOf(size));
        this.f17055c.put(size, cls);
    }

    /* renamed from: d */
    public void onBindViewHolder(i holder, int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        b<?> c10 = this.f17053a.get(i10).c();
        if (c10 != null) {
            holder.bindData(c10, i10, this);
        }
    }

    /* renamed from: e */
    public i onCreateViewHolder(ViewGroup parent, int i10) {
        i iVar;
        Object newInstance;
        kotlin.jvm.internal.i.f(parent, "parent");
        try {
            newInstance = this.f17055c.get(i10).getDeclaredConstructor(ViewGroup.class).newInstance(parent);
        } catch (Exception e10) {
            k.e("HomeTabAdapter", "create view holder error", e10);
            iVar = new EmptyViewHolder(parent);
        }
        if (newInstance != null) {
            iVar = (i) newInstance;
            c(iVar);
            return iVar;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.HomeTabViewHolder");
    }

    public final void g(View view) {
        this.f17056d = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f17053a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        HashMap<String, Integer> hashMap = this.f17054b;
        String b10 = this.f17053a.get(i10).b();
        if (b10 == null) {
            b10 = "";
        }
        Integer num = hashMap.get(b10);
        if (num == null) {
            num = -1;
        }
        return num.intValue();
    }

    @Override // com.mobvoi.companion.health.viewholder.a
    public void removeItem(int i10) {
        if (i10 >= 0 && i10 < this.f17053a.size()) {
            this.f17053a.remove(i10);
            notifyItemRemoved(i10);
            notifyItemRangeChanged(i10, this.f17053a.size() - i10);
        }
    }
}
