package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.noise.NoiseDetailActivity;
import java.util.List;
import jh.h;
import kotlin.jvm.internal.i;
import qf.a;
import so.c;
import xc.b;
import xc.d;
/* compiled from: NoiseCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class NoiseCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvAverageTitle = (TextView) this.itemView.findViewById(R.id.tv_average_title);
    private final TextView tvLatestValue = (TextView) this.itemView.findViewById(R.id.tv_latest_value);
    private final TextView tvNoiseState = (TextView) this.itemView.findViewById(R.id.tv_noise_state);
    private final TextView tvNoiseUnit = (TextView) this.itemView.findViewById(R.id.tv_noise_unit);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoiseCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_noise);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    private final String getNoiseLevelString(int i10) {
        int i11;
        Context context = getContext();
        boolean z10 = true;
        if (i10 >= 0 && i10 <= 60) {
            i11 = R.string.home_tab_noise_little_state;
        } else {
            if (61 <= i10 && i10 <= 80) {
                i11 = R.string.home_tab_noise_middle_state;
            } else {
                if (81 > i10 || i10 > Integer.MAX_VALUE) {
                    z10 = false;
                }
                if (z10) {
                    i11 = R.string.home_tab_noise_high_state;
                } else {
                    i11 = R.string.common_unknown;
                }
            }
        }
        String string = context.getString(i11);
        i.e(string, "context.getString(\n            when (noiseValue) {\n                in 0..60 -> R.string.home_tab_noise_little_state\n                in 61..80 -> R.string.home_tab_noise_middle_state\n                in 81..Int.MAX_VALUE -> R.string.home_tab_noise_high_state\n                else -> R.string.common_unknown\n            }\n        )");
        return string;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int b10;
        int b11;
        int b12;
        int b13;
        i.f(data, "data");
        if (data instanceof d) {
            d dVar = (d) data;
            List<? extends a> a10 = dVar.a();
            if (a10 != null && (a10.isEmpty() ^ true)) {
                float f10 = Float.POSITIVE_INFINITY;
                float f11 = 0.0f;
                for (a aVar : dVar.a()) {
                    float[] f12 = aVar.f();
                    i.e(f12, "singleData.getValues()");
                    if (!(f12.length == 0)) {
                        int length = f12.length;
                        int i10 = 0;
                        while (i10 < length) {
                            float f13 = f12[i10];
                            i10++;
                            f11 = Math.max(f11, f13);
                            f10 = Math.min(f10, f13);
                        }
                    }
                }
                this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_today_noise_environment));
                TextView textView = this.tvLatestValue;
                Context context = getContext();
                int i11 = R.string.home_tab_noise_value_range;
                b10 = c.b(f10);
                b11 = c.b(f11);
                textView.setText(context.getString(i11, Integer.valueOf(b10), Integer.valueOf(b11)));
                this.tvNoiseUnit.setVisibility(0);
                b12 = c.b(f10);
                String noiseLevelString = getNoiseLevelString(b12);
                b13 = c.b(f11);
                String noiseLevelString2 = getNoiseLevelString(b13);
                if (TextUtils.equals(noiseLevelString, noiseLevelString2)) {
                    this.tvNoiseState.setText(noiseLevelString);
                } else {
                    this.tvNoiseState.setText(getContext().getString(R.string.home_tab_noise_state_range, noiseLevelString, noiseLevelString2));
                }
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_no_data));
        this.tvLatestValue.setText(this.emptyValueStr);
        this.tvNoiseState.setText(getContext().getString(R.string.common_unknown));
        this.tvNoiseUnit.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "noise");
        h.q0(getContext(), NoiseDetailActivity.class);
    }
}
