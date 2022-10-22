package jd;

import android.view.View;
import ce.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import jd.k;
/* compiled from: ActiveHourChanger.java */
/* loaded from: classes2.dex */
public class a extends k<Integer> {

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f29523g = {6, 8, 10, 12, 14, 16};

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f29524f;

    public a(h hVar, int i10) {
        super(hVar, Integer.valueOf(i10));
    }

    private void n(NumberPicker numberPicker) {
        int[] iArr;
        int[] iArr2;
        int length = f29523g.length;
        String[] strArr = new String[length];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = f29523g;
            if (i11 >= iArr.length) {
                break;
            }
            strArr[i11] = this.f29539a.getString(ce.h.f5838c, Integer.valueOf(iArr[i11]));
            i11++;
        }
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(length - 1);
        numberPicker.setPickerDividerColor(kc.a.a(this.f29539a));
        float intValue = ((Integer) this.f29541c).intValue();
        if (intValue < 0.0f) {
            intValue = 10.0f;
        }
        int length2 = iArr.length / 2;
        while (true) {
            if (i10 >= f29523g.length) {
                break;
            } else if (intValue == iArr2[i10]) {
                length2 = i10;
                break;
            } else {
                i10++;
            }
        }
        numberPicker.setValue(length2);
    }

    @Override // jd.k
    protected int e() {
        return ce.h.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        NumberPicker numberPicker = (NumberPicker) view.findViewById(e.Q);
        this.f29524f = numberPicker;
        n(numberPicker);
    }

    /* JADX WARN: Type inference failed for: r5v4, types: [E, java.lang.Integer] */
    @Override // jd.k
    protected void j(View view) {
        int value = this.f29524f.getValue();
        int[] iArr = f29523g;
        k.c("HealthChanger", "the confirm item is %d", Integer.valueOf(iArr[value]));
        ?? valueOf = Integer.valueOf(iArr[value]);
        this.f29541c = valueOf;
        m(DataType.GoalTodayActive, Float.valueOf(((Integer) valueOf).intValue()).floatValue());
        k.a aVar = this.f29543e;
        if (aVar != null) {
            aVar.k(7, this.f29541c);
        }
    }
}
