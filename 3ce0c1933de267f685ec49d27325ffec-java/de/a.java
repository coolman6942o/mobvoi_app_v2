package de;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ce.e;
import ce.f;
import com.google.android.material.button.MaterialButton;
import p1.b;
/* compiled from: ActivityNewBindingWechatBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f25608a;

    /* renamed from: b  reason: collision with root package name */
    public final MaterialButton f25609b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f25610c;

    private a(ConstraintLayout constraintLayout, MaterialButton materialButton, TextView textView) {
        this.f25608a = constraintLayout;
        this.f25609b = materialButton;
        this.f25610c = textView;
    }

    public static a b(View view) {
        int i10 = e.f5775g;
        MaterialButton materialButton = (MaterialButton) b.a(view, i10);
        if (materialButton != null) {
            i10 = e.f5782j0;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                return new a((ConstraintLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static a e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.f5809c, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f25608a;
    }
}
