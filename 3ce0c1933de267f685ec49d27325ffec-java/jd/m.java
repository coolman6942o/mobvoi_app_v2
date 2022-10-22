package jd;

import android.view.View;
import ce.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import jd.k;
import kc.a;
/* compiled from: StepChanger.java */
/* loaded from: classes2.dex */
public class m extends k<Integer> {

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f29546f;

    public m(h hVar, int i10) {
        super(hVar, Integer.valueOf(i10));
    }

    private void n() {
        String[] strArr = new String[16];
        for (int i10 = 0; i10 <= 15; i10++) {
            strArr[i10] = String.valueOf((i10 * 1000) + 5000);
        }
        float intValue = ((Integer) this.f29541c).intValue();
        float f10 = 5.0f;
        if (intValue != -1.0f) {
            f10 = (intValue - 5000.0f) / 1000.0f;
            if (f10 < 0.0f || f10 > 15) {
                f10 = 10000.0f;
            }
        }
        this.f29546f.setMaxValue(15);
        this.f29546f.setMinValue(0);
        this.f29546f.setDisplayedValues(strArr);
        this.f29546f.setValue((int) f10);
        this.f29546f.setPickerDividerColor(a.a(this.f29539a));
    }

    @Override // jd.k
    protected int e() {
        return ce.h.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        this.f29546f = (NumberPicker) view.findViewById(e.Q);
        n();
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [E, java.lang.Integer] */
    @Override // jd.k
    protected void j(View view) {
        float value = (this.f29546f.getValue() * 1000) + 5000;
        if (value != ((Integer) this.f29541c).intValue()) {
            k.c("HealthChanger", "the step changer is %f", Float.valueOf(value));
            int i10 = (int) value;
            this.f29541c = Integer.valueOf(i10);
            m(DataType.GoalTodayStep, value);
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(5, Integer.valueOf(i10));
            }
        }
    }
}
