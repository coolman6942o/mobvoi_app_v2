package ae;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ce.e;
import ce.f;
/* compiled from: WatchCommonItemView.java */
/* loaded from: classes2.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Context f180a;

    /* renamed from: b  reason: collision with root package name */
    private View f181b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f182c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f183d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f184e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f185f;

    public c(Context context) {
        this(context, null);
    }

    private void b() {
        View inflate = LayoutInflater.from(this.f180a).inflate(f.f5823q, (ViewGroup) this, true);
        this.f181b = inflate;
        this.f182c = (ImageView) inflate.findViewById(e.f5804x);
        this.f183d = (TextView) this.f181b.findViewById(e.f5770d0);
        this.f184e = (ImageView) this.f181b.findViewById(e.E);
        this.f185f = (ImageView) this.f181b.findViewById(e.D);
    }

    public void a(com.mobvoi.companion.ui.e eVar) {
        this.f182c.setImageResource(eVar.iconResId);
        this.f183d.setText(eVar.titleResId);
        this.f184e.setVisibility(8);
        if (eVar.isBeta) {
            this.f185f.setVisibility(0);
        }
        setOnClickListener(eVar.onClickListener);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f180a = context;
        b();
    }
}
