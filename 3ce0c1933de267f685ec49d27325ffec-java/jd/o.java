package jd;

import android.view.View;
import ce.e;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.companion.unit.UnitPolicy;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.wear.util.UnitsUtility;
import jd.k;
import wd.a;
/* compiled from: WeightChanger.java */
/* loaded from: classes2.dex */
public class o extends k<Float> {

    /* renamed from: f  reason: collision with root package name */
    private a f29549f;

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f29550g;

    public o(h hVar, float f10) {
        super(hVar, Float.valueOf(f10));
    }

    private void n(NumberPicker numberPicker) {
        String[] strArr = new String[442];
        for (int i10 = 44; i10 <= 485; i10++) {
            strArr[i10 - 44] = i10 + numberPicker.getContext().getString(ce.h.M);
        }
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(441);
        numberPicker.setValue(this.f29549f.a(String.valueOf(this.f29541c)) - 44);
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setPickerDividerColor(kc.a.a(this.f29539a));
    }

    private void o(NumberPicker numberPicker) {
        String[] strArr = new String[201];
        for (int i10 = 20; i10 <= 220; i10++) {
            strArr[i10 - 20] = numberPicker.getContext().getString(ce.h.A, Integer.valueOf(i10));
        }
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(200);
        numberPicker.setValue((int) ((((Float) this.f29541c).floatValue() != -1.0f ? ((Float) this.f29541c).floatValue() : this.f29549f.e()) - 20.0f));
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setPickerDividerColor(kc.a.a(this.f29539a));
    }

    @Override // jd.k
    protected int e() {
        return ce.h.L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        this.f29549f = UnitPolicy.b();
        this.f29550g = (NumberPicker) view.findViewById(e.Q);
        if (!com.mobvoi.companion.base.settings.a.isUnitMetric(this.f29539a)) {
            n(this.f29550g);
        } else {
            o(this.f29550g);
        }
    }

    @Override // jd.k
    protected void j(View view) {
        int value = this.f29550g.getValue() + (!com.mobvoi.companion.base.settings.a.isUnitMetric(this.f29539a) ? 44 : 20);
        if (value != this.f29549f.a(ta.a.w())) {
            float pound2KgValue = !com.mobvoi.companion.base.settings.a.isUnitMetric(this.f29539a) ? UnitsUtility.pound2KgValue(value) : value;
            m(DataType.InfoWeight, pound2KgValue);
            sa.a e10 = ta.a.e();
            e10.weight = this.f29549f.d(value);
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(3, Float.valueOf(pound2KgValue));
            }
            this.f29540b.h(e10);
            return;
        }
        this.f29540b.h(null);
    }
}
