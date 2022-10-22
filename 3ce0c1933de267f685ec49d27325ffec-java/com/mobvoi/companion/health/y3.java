package com.mobvoi.companion.health;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.health.viewholder.BloodOxygenCardViewHolder;
import com.mobvoi.companion.health.viewholder.BodyMindCardViewHolder;
import com.mobvoi.companion.health.viewholder.CareNullCardViewHolder;
import com.mobvoi.companion.health.viewholder.FitnessCardViewHolder;
import com.mobvoi.companion.health.viewholder.HealthCardReportViewHolder;
import com.mobvoi.companion.health.viewholder.HealthCardViewHolder;
import com.mobvoi.companion.health.viewholder.McuActivityCardViewHolder;
import com.mobvoi.companion.health.viewholder.McuHeartRateCardViewHolder;
import com.mobvoi.companion.health.viewholder.NoiseCardViewHolder;
import com.mobvoi.companion.health.viewholder.PressureCardViewHolder;
import com.mobvoi.companion.health.viewholder.PulseCardViewHolder;
import com.mobvoi.companion.health.viewholder.SleepCardViewHolder;
import com.mobvoi.companion.health.viewholder.TemperatureCardViewHolder;
import com.mobvoi.companion.health.viewholder.i;
import java.util.HashMap;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.f;
import xc.b;
/* compiled from: TicCareTabAdapter.kt */
/* loaded from: classes2.dex */
public final class y3 extends RecyclerView.Adapter<i> implements com.mobvoi.companion.health.viewholder.a {

    /* renamed from: a  reason: collision with root package name */
    private final List<tc.i> f17158a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Integer> f17159b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Class<?>> f17160c = new SparseArray<>();

    /* compiled from: TicCareTabAdapter.kt */
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

    public y3(List<tc.i> list) {
        kotlin.jvm.internal.i.f(list, "list");
        this.f17158a = list;
        e("EMPTY_CARD_ONLY_CLIENT", CareNullCardViewHolder.class);
        e("CARD_HEALTH_REPORT", HealthCardReportViewHolder.class);
        e("CARD_AW_ACTIVITY", HealthCardViewHolder.class);
        e("CARD_MCU_ACTIVITY", McuActivityCardViewHolder.class);
        e("CARD_SPORT", FitnessCardViewHolder.class);
        e("CARD_SLEEP", SleepCardViewHolder.class);
        e("CARD_AW_HEART_RATE", PulseCardViewHolder.class);
        e("CARD_MCU_HEART_RATE", McuHeartRateCardViewHolder.class);
        e("CARD_BLOOD_OXYGEN", BloodOxygenCardViewHolder.class);
        e("CARD_TEMPERATION", TemperatureCardViewHolder.class);
        e("CARD_PRESSURE", PressureCardViewHolder.class);
        e("CARD_NOISE", NoiseCardViewHolder.class);
        e("CARD_BODY_MIND_STATE", BodyMindCardViewHolder.class);
    }

    private final void e(String str, Class<?> cls) {
        int size = this.f17159b.size() + 1;
        this.f17159b.put(str, Integer.valueOf(size));
        this.f17160c.put(size, cls);
    }

    /* renamed from: c */
    public void onBindViewHolder(i holder, int i10) {
        kotlin.jvm.internal.i.f(holder, "holder");
        b<?> c10 = this.f17158a.get(i10).c();
        if (c10 != null) {
            holder.bindData(c10, i10, this);
        }
    }

    /* renamed from: d */
    public i onCreateViewHolder(ViewGroup parent, int i10) {
        kotlin.jvm.internal.i.f(parent, "parent");
        try {
            Object newInstance = this.f17160c.get(i10).getDeclaredConstructor(ViewGroup.class).newInstance(parent);
            if (newInstance != null) {
                return (i) newInstance;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.HomeTabViewHolder");
        } catch (Exception e10) {
            k.d("HomeTabAdapter", e10.getMessage());
            return new CareNullCardViewHolder(parent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f17158a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        HashMap<String, Integer> hashMap = this.f17159b;
        String b10 = this.f17158a.get(i10).b();
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
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
