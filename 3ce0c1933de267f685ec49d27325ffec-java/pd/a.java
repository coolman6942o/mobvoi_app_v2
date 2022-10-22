package pd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.switchmaterial.SwitchMaterial;
import od.b;
import od.c;
/* compiled from: FragmentControlTicPulseBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f32756a;

    /* renamed from: b  reason: collision with root package name */
    public final SwitchMaterial f32757b;

    private a(ConstraintLayout constraintLayout, SwitchMaterial switchMaterial, View view) {
        this.f32756a = constraintLayout;
        this.f32757b = switchMaterial;
    }

    public static a b(View view) {
        View a10;
        int i10 = b.m_res_0x7f0b0756;
        SwitchMaterial switchMaterial = (SwitchMaterial) p1.b.a(view, i10);
        if (switchMaterial != null && (a10 = p1.b.a(view, (i10 = b.o_res_0x7f0b0895))) != null) {
            return new a((ConstraintLayout) view, switchMaterial, a10);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(c.e_res_0x7f0e00c2, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f32756a;
    }
}
