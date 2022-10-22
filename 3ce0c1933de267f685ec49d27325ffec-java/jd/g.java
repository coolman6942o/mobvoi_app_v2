package jd;

import android.view.View;
import ce.e;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.companion.unit.UnitPolicy;
import com.mobvoi.health.common.data.pojo.DataType;
import jd.k;
import wd.a;
/* compiled from: HeightMetricChanger.java */
/* loaded from: classes2.dex */
public class g extends e {

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f29536g;

    public g(h hVar, float f10) {
        super(hVar, f10);
    }

    @Override // jd.k
    protected int e() {
        return ce.h.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.e, jd.k
    public void g(View view) {
        super.g(view);
        this.f29536g = (NumberPicker) view.findViewById(e.Q);
        a c10 = UnitPolicy.c(UnitPolicy.UNIT.METRIC);
        this.f29533f = c10;
        if (c10 != null) {
            n();
        }
    }

    @Override // jd.k
    protected void j(View view) {
        float value = this.f29536g.getValue() + Math.min(((Float) this.f29541c).floatValue(), 90.0f);
        if (value != this.f29533f.h(ta.a.k())[0]) {
            sa.a e10 = ta.a.e();
            m(DataType.InfoHeight, value);
            e10.height = this.f29533f.f(Float.valueOf(value));
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(4, Float.valueOf(value));
            }
            this.f29540b.h(e10);
            return;
        }
        this.f29540b.h(null);
    }

    protected void n() {
        int min = (int) Math.min(((Float) this.f29541c).floatValue(), 90.0f);
        int i10 = 220 - min;
        String[] strArr = new String[i10 + 1];
        for (int i11 = min; i11 <= 220; i11++) {
            strArr[i11 - min] = i11 + this.f29536g.getContext().getString(ce.h.f5840d);
        }
        this.f29536g.setMaxValue(i10);
        this.f29536g.setMinValue(0);
        this.f29536g.setDisplayedValues(strArr);
        this.f29536g.setValue((int) ((((Float) this.f29541c).floatValue() != -1.0f ? ((Float) this.f29541c).floatValue() : this.f29533f.c()[0]) - min));
        this.f29536g.setPickerDividerColor(kc.a.a(this.f29539a));
    }
}
