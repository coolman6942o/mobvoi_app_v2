package bj;

import android.view.View;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import java.util.ArrayList;
import java.util.List;
import jd.k;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.h;
/* compiled from: CalendarDaysChanger.kt */
/* loaded from: classes2.dex */
public final class a extends k<Integer> {

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f5164f;

    /* renamed from: g  reason: collision with root package name */
    private int f5165g;

    /* renamed from: h  reason: collision with root package name */
    private final List<Integer> f5166h = new ArrayList();

    /* compiled from: CalendarDaysChanger.kt */
    /* renamed from: bj.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0074a {
        private C0074a() {
        }

        public /* synthetic */ C0074a(f fVar) {
            this();
        }
    }

    static {
        new C0074a(null);
    }

    public a(int i10) {
        super(null, Integer.valueOf(i10));
    }

    private final void n() {
        int i10;
        int i11;
        if (this.f5165g == 1) {
            i11 = 8;
            i10 = 3;
        } else {
            i11 = 40;
            i10 = 24;
        }
        int i12 = i11 - i10;
        String[] strArr = new String[i12 + 1];
        this.f5166h.clear();
        if (i10 <= i11) {
            int i13 = i10;
            int i14 = 0;
            while (true) {
                i14++;
                i13++;
                strArr[i14] = this.f29539a.getString(sh.k.f34803g0, Integer.valueOf(i13));
                this.f5166h.add(Integer.valueOf(i13));
                if (i13 == i11) {
                    break;
                }
            }
        }
        Integer num = (Integer) this.f29541c;
        int intValue = num == null ? i10 : num.intValue();
        if (intValue >= 1) {
            i10 = intValue;
        }
        NumberPicker numberPicker = this.f5164f;
        if (numberPicker != null) {
            numberPicker.setDisplayedValues(strArr);
            numberPicker.setMaxValue(i12);
            numberPicker.setMinValue(0);
            numberPicker.setValue(i10);
            numberPicker.setPickerDividerColor(kc.a.a(this.f29539a));
        }
    }

    @Override // jd.k
    protected int e() {
        if (this.f5165g == 1) {
            return sh.k.f34864s1;
        }
        return sh.k.f34859r1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View dialogView) {
        i.f(dialogView, "dialogView");
        super.g(dialogView);
        this.f5164f = (NumberPicker) dialogView.findViewById(h.f34679p2);
        n();
    }

    @Override // jd.k
    protected void j(View view) {
        if (this.f29543e != null) {
            NumberPicker numberPicker = this.f5164f;
            Integer valueOf = numberPicker == null ? null : Integer.valueOf(numberPicker.getValue());
            if (valueOf != null) {
                this.f29543e.k(this.f5165g, this.f5166h.get(valueOf.intValue()));
            }
        }
    }

    public final void o(int i10) {
        this.f5165g = i10;
    }
}
