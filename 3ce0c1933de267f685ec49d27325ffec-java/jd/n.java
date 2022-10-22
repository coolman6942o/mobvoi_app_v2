package jd;

import android.content.Context;
import android.view.View;
import ce.e;
import com.mobvoi.companion.base.ui.view.numberpicker.NumberPicker;
import com.mobvoi.companion.profile.h;
import jd.k;
import kc.a;
import xd.c;
/* compiled from: UnitChanger.java */
/* loaded from: classes2.dex */
public class n extends k {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f29547g = {"metric", "imperial"};

    /* renamed from: f  reason: collision with root package name */
    private NumberPicker f29548f;

    public n(h hVar) {
        super(hVar);
    }

    private int n(Context context) {
        return "imperial".equals(c.x().z(context)) ? 1 : 0;
    }

    private void o(String[] strArr, Context context) {
        this.f29548f.setMaxValue(strArr.length - 1);
        this.f29548f.setMinValue(0);
        this.f29548f.setDisplayedValues(strArr);
        this.f29548f.setValue(n(context));
        this.f29548f.setPickerDividerColor(a.a(this.f29539a));
    }

    @Override // jd.k
    protected int e() {
        return ce.h.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        this.f29548f = (NumberPicker) view.findViewById(e.Q);
        o(new String[]{this.f29539a.getString(ce.h.J), this.f29539a.getString(ce.h.I)}, this.f29539a);
    }

    @Override // jd.k
    protected void j(View view) {
        String str = f29547g[this.f29548f.getValue()];
        if (!com.mobvoi.companion.base.settings.a.getUnit(this.f29539a).equals(str)) {
            c.x().H(this.f29539a, str);
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(8, this.f29541c);
                return;
            }
            return;
        }
        this.f29540b.h(null);
    }
}
