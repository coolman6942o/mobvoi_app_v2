package com.mobvoi.companion.aw.watchfacecenter.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.s;
import com.mobvoi.companion.aw.watchfacecenter.t;
import kotlin.jvm.internal.i;
/* compiled from: ImageWatchFaceSelector.kt */
/* loaded from: classes2.dex */
public final class ImageWatchFaceSelector extends ConstraintLayout {

    /* renamed from: u  reason: collision with root package name */
    private boolean f16518u;

    /* renamed from: v  reason: collision with root package name */
    private TextView f16519v;

    /* renamed from: w  reason: collision with root package name */
    private ImageWatchFaceMask f16520w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWatchFaceSelector(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        String str;
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.f16482g, i10, 0);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(\n            attrs,\n            R.styleable.ImageWatchFaceSelector,\n            defStyleAttr,\n            0\n        )");
        int i11 = obtainStyledAttributes.getInt(t.f16484i, 0);
        this.f16518u = obtainStyledAttributes.getBoolean(t.f16483h, false);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(context).inflate(q.f_res_0x7f0e017c, (ViewGroup) this, true);
        View findViewById = findViewById(p.D_res_0x7f0b07a0);
        i.e(findViewById, "findViewById(R.id.tvDirectionName)");
        this.f16519v = (TextView) findViewById;
        View findViewById2 = findViewById(p.i_res_0x7f0b0442);
        i.e(findViewById2, "findViewById(R.id.mask)");
        this.f16520w = (ImageWatchFaceMask) findViewById2;
        TextView textView = this.f16519v;
        if (i11 == 0) {
            str = context.getString(s.n_res_0x7f1408a9);
        } else if (i11 != 1) {
            str = context.getString(s.m_res_0x7f1408a8);
        } else {
            str = context.getString(s.l_res_0x7f1408a7);
        }
        textView.setText(str);
        this.f16519v.setSelected(this.f16518u);
        ImageWatchFaceMask imageWatchFaceMask = this.f16520w;
        imageWatchFaceMask.setChosenState(this.f16518u);
        imageWatchFaceMask.setDirection(i11);
    }

    public final ImageWatchFaceMask getImageView() {
        return this.f16520w;
    }

    public final void setChosenState(boolean z10) {
        if (this.f16518u != z10) {
            this.f16518u = z10;
            this.f16519v.setSelected(z10);
            this.f16520w.setChosenState(z10);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWatchFaceSelector(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
