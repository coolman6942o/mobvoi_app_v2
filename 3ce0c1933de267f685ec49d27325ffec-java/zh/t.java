package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ItemApolloAppRemindBinding.java */
/* loaded from: classes2.dex */
public final class t implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37597a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f37598b;

    /* renamed from: c  reason: collision with root package name */
    public final SwitchMaterial f37599c;

    private t(ConstraintLayout constraintLayout, TextView textView, SwitchMaterial switchMaterial) {
        this.f37597a = constraintLayout;
        this.f37598b = textView;
        this.f37599c = switchMaterial;
    }

    public static t b(View view) {
        int i10 = h.i_res_0x7f0b009b;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = h.f34622c3;
            SwitchMaterial switchMaterial = (SwitchMaterial) b.a(view, i10);
            if (switchMaterial != null) {
                return new t((ConstraintLayout) view, textView, switchMaterial);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34747p0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37597a;
    }
}
