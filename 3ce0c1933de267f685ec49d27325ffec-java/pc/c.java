package pc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ce.f;
import com.mobvoi.companion.ui.e;
/* compiled from: ContentItemView.java */
/* loaded from: classes2.dex */
public class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private View f32744a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f32745b;

    public c(Context context) {
        super(context);
        b(null, 0);
    }

    private void b(AttributeSet attributeSet, int i10) {
        if (this.f32745b == null) {
            this.f32745b = LayoutInflater.from(getContext());
        }
        this.f32744a = this.f32745b.inflate(f.f5829w, (ViewGroup) this, true);
    }

    public void a(e eVar) {
        if (eVar != null) {
            ((TextView) findViewById(ce.e.f5770d0)).setText(eVar.titleResId);
            ((ImageView) findViewById(ce.e.f5804x)).setImageResource(eVar.iconResId);
            this.f32744a.setOnClickListener(eVar.onClickListener);
        }
    }
}
