package ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyLatestValueCommonView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtySuggestContentView;
import gg.e;
import java.util.List;
import java.util.Map;
import nf.j;
import sh.h;
import sh.i;
/* compiled from: ArtyLatestView.java */
/* loaded from: classes2.dex */
public class f extends o<e> {
    ArtyLatestValueCommonView H;
    ArtyTipsTextView I;

    public f(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(Map map) {
        long j10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (j10 < ((Long) entry.getKey()).longValue()) {
                j10 = ((Long) entry.getKey()).longValue();
            }
        }
        if (j10 > 0 && map.get(Long.valueOf(j10)) != null) {
            this.H.setTodayArtyAllDataInfo((List) map.get(Long.valueOf(j10)));
        }
    }

    @Override // ui.o
    public void U() {
        LayoutInflater.from(this.C).inflate(i.O0, (ViewGroup) this, true);
        this.H = (ArtyLatestValueCommonView) findViewById(h.B_res_0x7f0b00b9);
        ArtySuggestContentView artySuggestContentView = (ArtySuggestContentView) findViewById(h.F_res_0x7f0b00be);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(h.v_res_0x7f0b00ab);
        this.I = (ArtyTipsTextView) findViewById(h.H);
    }

    @Override // ui.o
    public void V() {
        this.G.clear();
        this.G.a(j.b(((e) this.F).t(), new j.a() { // from class: ui.e
            @Override // nf.j.a
            public final void call(Object obj) {
                f.this.X((Map) obj);
            }
        }));
        long j10 = this.E;
        ((e) this.F).L(j10 - 604800000, j10, 0);
    }

    @Override // ui.o
    public void setArtyBundleData(Bundle bundle) {
        int i10 = bundle.getInt("data_type");
        int i11 = bundle.getInt("extra_diff_value");
        String string = bundle.getString("extra_tips_content");
        this.H.f(i10, i11);
        if (!TextUtils.isEmpty(string)) {
            this.I.setTips(string);
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
