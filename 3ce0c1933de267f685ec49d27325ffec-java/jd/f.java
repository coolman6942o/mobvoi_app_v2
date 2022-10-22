package jd;

import android.text.TextUtils;
import android.view.View;
import ce.e;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.companion.unit.UnitPolicy;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.wear.util.UnitsUtility;
import ta.a;
/* compiled from: HeightImperialChanger.java */
/* loaded from: classes2.dex */
public class f extends e {

    /* renamed from: g  reason: collision with root package name */
    private NumberPicker f29534g;

    /* renamed from: h  reason: collision with root package name */
    private NumberPicker f29535h;

    public f(h hVar, float f10) {
        super(hVar, f10);
    }

    @Override // jd.k
    protected int d() {
        return ce.f.f5815i;
    }

    @Override // jd.k
    protected int e() {
        return ce.h.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.e, jd.k
    public void g(View view) {
        super.g(view);
        this.f29534g = (NumberPicker) view.findViewById(e.f5793p);
        this.f29535h = (NumberPicker) view.findViewById(e.C);
        this.f29533f = UnitPolicy.c(UnitPolicy.UNIT.IMPERIAL);
        n();
    }

    @Override // jd.k
    protected void j(View view) {
        int value = this.f29534g.getValue();
        int value2 = this.f29535h.getValue();
        String f10 = this.f29533f.f(Integer.valueOf(value), Integer.valueOf(value2));
        if (!f10.equals(a.k())) {
            m(DataType.InfoHeight, UnitsUtility.inch2Cm(value, value2));
            sa.a e10 = a.e();
            e10.height = f10;
            if (this.f29543e != null && !TextUtils.isEmpty(f10)) {
                this.f29543e.k(4, Float.valueOf(Float.parseFloat(f10)));
            }
            this.f29540b.h(e10);
            return;
        }
        this.f29540b.h(null);
    }

    protected void n() {
        String[] strArr = new String[6];
        for (int i10 = 2; i10 <= 7; i10++) {
            strArr[i10 - 2] = i10 + "'";
        }
        String[] strArr2 = new String[12];
        for (int i11 = 0; i11 <= 11; i11++) {
            strArr2[i11 + 0] = i11 + "''";
        }
        int[] h10 = this.f29533f.h(((Float) this.f29541c).floatValue() != -1.0f ? String.valueOf(this.f29541c) : a.k());
        this.f29534g.setPickerDividerColor(kc.a.a(this.f29539a));
        this.f29535h.setPickerDividerColor(kc.a.a(this.f29539a));
        this.f29534g.setMaxValue(7);
        this.f29534g.setMinValue(2);
        this.f29535h.setMaxValue(11);
        this.f29535h.setMinValue(0);
        this.f29534g.setValue(h10[0]);
        this.f29535h.setValue(h10[1]);
        this.f29534g.setDisplayedValues(strArr);
        this.f29535h.setDisplayedValues(strArr2);
    }
}
