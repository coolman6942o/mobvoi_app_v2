package ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.mobvoi.wear.util.LogCleaner;
import eg.c;
import kh.w;
import nf.f;
import nf.g;
import nf.m;
/* compiled from: BaseArtyScrollView.java */
/* loaded from: classes2.dex */
public abstract class o<VM extends w> extends NestedScrollView implements f<VM> {
    protected Context C;
    protected final long D;
    protected final long E;
    protected VM F;
    protected m G = new m();

    public o(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.C = context;
        U();
        long b10 = c.b(c.b(System.currentTimeMillis()));
        this.D = b10;
        this.E = b10 + LogCleaner.ONE_DAY;
    }

    public void T() {
        if (this.F != null) {
            this.G.clear();
            this.F.a();
            this.F = null;
        }
    }

    public abstract void U();

    public abstract void V();

    public abstract void setArtyBundleData(Bundle bundle);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // nf.f
    public /* bridge */ /* synthetic */ void setViewModel(g gVar) {
        setViewModel((o<VM>) ((w) gVar));
    }

    public void setViewModel(VM vm2) {
        if (vm2 != null) {
            this.F = vm2;
            V();
        }
    }
}
