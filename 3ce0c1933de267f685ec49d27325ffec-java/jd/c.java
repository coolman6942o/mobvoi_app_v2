package jd;

import android.view.View;
import android.widget.RadioButton;
import ce.e;
import ce.f;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.profile.h;
import com.mobvoi.health.common.data.pojo.DataType;
import jd.k;
import ta.a;
/* compiled from: GenderChanger.java */
/* loaded from: classes2.dex */
public class c extends k<Integer> {

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f29527f;

    /* renamed from: g  reason: collision with root package name */
    private RadioButton f29528g;

    public c(h hVar, int i10) {
        super(hVar, Integer.valueOf(i10));
    }

    private boolean n(RadioButton radioButton, RadioButton radioButton2) {
        int t10 = ((Integer) this.f29541c).intValue() == -1 ? a.t() : ((Integer) this.f29541c).intValue();
        return ((Integer) this.f29541c).intValue() == -1 ? (AccountConstant.Sex.MALE.ordinal() == t10 && radioButton.isChecked()) || (AccountConstant.Sex.FEMALE.ordinal() == t10 && radioButton2.isChecked()) : (1 == t10 && radioButton.isChecked()) || (t10 == 0 && radioButton2.isChecked());
    }

    @Override // jd.k
    protected int d() {
        return f.f5814h;
    }

    @Override // jd.k
    protected int e() {
        return ce.h.f5875u0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jd.k
    public void g(View view) {
        super.g(view);
        this.f29527f = (RadioButton) view.findViewById(e.W);
        this.f29528g = (RadioButton) view.findViewById(e.V);
        int t10 = ((Integer) this.f29541c).intValue() == -1 ? a.t() : ((Integer) this.f29541c).intValue();
        if (((Integer) this.f29541c).intValue() == -1) {
            if (AccountConstant.Sex.MALE.ordinal() == t10) {
                this.f29527f.setChecked(true);
            } else if (AccountConstant.Sex.FEMALE.ordinal() == t10) {
                this.f29528g.setChecked(true);
            }
        } else if (1 == t10) {
            this.f29527f.setChecked(true);
        } else if (t10 == 0) {
            this.f29528g.setChecked(true);
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [E, java.lang.Integer] */
    @Override // jd.k
    protected void j(View view) {
        int i10;
        if (n(this.f29527f, this.f29528g)) {
            this.f29540b.h(null);
        } else {
            sa.a e10 = a.e();
            if (this.f29527f.isChecked()) {
                e10.sex = AccountConstant.Sex.MALE.ordinal();
                i10 = 1;
            } else {
                i10 = 0;
                e10.sex = AccountConstant.Sex.FEMALE.ordinal();
            }
            this.f29541c = Integer.valueOf(i10);
            m(DataType.InfoGender, i10);
            k.a aVar = this.f29543e;
            if (aVar != null) {
                aVar.k(1, Integer.valueOf(i10));
            }
            this.f29540b.h(e10);
        }
        this.f29542d.dismiss();
    }
}
