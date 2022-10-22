package com.mobvoi.companion.health.viewholder;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.common.ui.view.BodyMindStateProgressBar;
import com.mobvoi.health.companion.heartrate.ui.detail.BodyMindDetailActivity;
import eg.c;
import java.util.Map;
import jh.h;
import kotlin.jvm.internal.i;
import xc.b;
import xf.a;
/* compiled from: BodyMindCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class BodyMindCardViewHolder extends i {
    private final TextView fatigueStateDesc = (TextView) this.itemView.findViewById(R.id.fatigue_desc);
    private final TextView energyStateDesc = (TextView) this.itemView.findViewById(R.id.energy_desc);
    private final BodyMindStateProgressBar fatigueBar = (BodyMindStateProgressBar) this.itemView.findViewById(R.id.fatigue_progress_bar);
    private final BodyMindStateProgressBar energyBar = (BodyMindStateProgressBar) this.itemView.findViewById(R.id.energy_progress_bar);
    private final TextView fatigueValueTv = (TextView) this.itemView.findViewById(R.id.fatigue_value);
    private final TextView energyValueTv = (TextView) this.itemView.findViewById(R.id.energy_value);
    private final TextView uploadDateTv = (TextView) this.itemView.findViewById(R.id.tv_time);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyMindCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_body_mind_state);
        i.f(parentView, "parentView");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ac  */
    @Override // com.mobvoi.companion.health.viewholder.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onBindData(b<?> data) {
        Map<Integer, ? extends a> a10;
        i.f(data, "data");
        if ((data instanceof xc.a) && data.c()) {
            xc.a aVar = (xc.a) data;
            Map<Integer, ? extends a> a11 = aVar.a();
            a aVar2 = null;
            a aVar3 = a11 == null ? null : a11.get(1);
            this.uploadDateTv.setVisibility(0);
            if (aVar3 != null) {
                int i10 = aVar3.f36538b;
                if (1 <= i10 && i10 <= 5) {
                    this.fatigueBar.setProgress(i10 * 10);
                    this.fatigueValueTv.setText(String.valueOf(aVar3.f36538b));
                    String[] stringArray = getContext().getResources().getStringArray(R.array.fatigue_levels);
                    i.e(stringArray, "context.resources.getStringArray(R.array.fatigue_levels)");
                    this.fatigueStateDesc.setText(stringArray[aVar3.f36538b - 1]);
                    this.uploadDateTv.setText(c.f(aVar3.f36539c));
                    a10 = aVar.a();
                    if (a10 != null) {
                        aVar2 = a10.get(2);
                    }
                    if (aVar2 != null) {
                        int i11 = aVar2.f36538b;
                        if (1 <= i11 && i11 <= 5) {
                            this.energyBar.setProgress(i11 * 10);
                            this.energyValueTv.setText(String.valueOf(aVar2.f36538b));
                            String[] stringArray2 = getContext().getResources().getStringArray(R.array.energy_levels);
                            i.e(stringArray2, "context.resources.getStringArray(R.array.energy_levels)");
                            this.energyStateDesc.setText(stringArray2[aVar2.f36538b - 1]);
                            this.uploadDateTv.setText(c.f(aVar2.f36539c));
                            return;
                        }
                    }
                    this.energyBar.setProgress(0);
                    this.energyValueTv.setText("-");
                    this.energyStateDesc.setText(getContext().getResources().getString(R.string.health_item_no_data));
                }
            }
            this.fatigueBar.setProgress(0);
            this.fatigueValueTv.setText("-");
            this.fatigueStateDesc.setText(getContext().getResources().getString(R.string.health_item_no_data));
            a10 = aVar.a();
            if (a10 != null) {
            }
            if (aVar2 != null) {
            }
            this.energyBar.setProgress(0);
            this.energyValueTv.setText("-");
            this.energyStateDesc.setText(getContext().getResources().getString(R.string.health_item_no_data));
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.fatigueBar.setProgress(0);
        this.fatigueValueTv.setText("-");
        TextView textView = this.fatigueStateDesc;
        Resources resources = getContext().getResources();
        int i10 = R.string.health_item_no_data;
        textView.setText(resources.getString(i10));
        this.energyBar.setProgress(0);
        this.energyValueTv.setText("-");
        this.energyStateDesc.setText(getContext().getResources().getString(i10));
        this.uploadDateTv.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "bodyMind");
        h.q0(getContext(), BodyMindDetailActivity.class);
    }
}
