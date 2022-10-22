package jd;

import android.view.View;
import ce.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import com.unionpay.tsmservice.data.Constant;
import jd.k;
import kc.a;
/* compiled from: ExerciseGoalChanger.java */
/* loaded from: classes2.dex */
public class b extends k<Integer> {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f29525g = {"10", "20", "30", "40", Constant.TRANS_TYPE_LOAD, "90", "120"};

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f29526f;

    public b(h hVar, int i10) {
        super(hVar, Integer.valueOf(i10));
    }

    private void n(NumberPicker numberPicker) {
        int length = f29525g.length;
        String[] strArr = new String[length];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr2 = f29525g;
            if (i11 >= strArr2.length) {
                break;
            }
            strArr[i11] = this.f29539a.getString(ce.h.f5836b, strArr2[i11]);
            i11++;
        }
        numberPicker.setDisplayedValues(strArr);
        numberPicker.setMinValue(0);
        numberPicker.setMaxValue(length - 1);
        numberPicker.setPickerDividerColor(a.a(this.f29539a));
        int intValue = ((Integer) this.f29541c).intValue();
        while (true) {
            String[] strArr3 = f29525g;
            if (i10 >= strArr3.length) {
                i10 = -1;
                break;
            } else if (intValue == Integer.parseInt(strArr3[i10])) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            i10 = 2;
        }
        numberPicker.setValue(i10);
    }

    @Override // jd.k
    protected int e() {
        return ce.h.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        NumberPicker numberPicker = (NumberPicker) view.findViewById(e.Q);
        this.f29526f = numberPicker;
        n(numberPicker);
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [E, java.lang.Integer] */
    @Override // jd.k
    protected void j(View view) {
        int value = this.f29526f.getValue();
        String[] strArr = f29525g;
        k.a("HealthChanger", strArr[value]);
        ?? valueOf = Integer.valueOf(strArr[value]);
        this.f29541c = valueOf;
        m(DataType.GoalTodayExercise, ((Integer) valueOf).intValue() * 60);
        k.a aVar = this.f29543e;
        if (aVar != null) {
            aVar.k(6, this.f29541c);
        }
    }
}
