package k0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final int f29688a;

    /* renamed from: b  reason: collision with root package name */
    private final c f29689b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29690c;

    public a(int i10, c cVar, int i11) {
        this.f29688a = i10;
        this.f29689b = cVar;
        this.f29690c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f29688a);
        this.f29689b.Q(this.f29690c, bundle);
    }
}
