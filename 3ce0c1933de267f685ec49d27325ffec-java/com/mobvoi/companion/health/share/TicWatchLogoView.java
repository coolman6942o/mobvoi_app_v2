package com.mobvoi.companion.health.share;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mobvoi.companion.R;
import io.m;
import kotlin.jvm.internal.i;
/* compiled from: TicWatchLogoView.kt */
/* loaded from: classes2.dex */
public final class TicWatchLogoView extends LinearLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicWatchLogoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.drawable.health_share_logo_bg);
        LayoutInflater.from(context).inflate(R.layout.layout_health_share_logo, (ViewGroup) this, true);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        m mVar = m.f28349a;
        ((ImageView) findViewById(R.id.mobvoiLogo)).setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TicWatchLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }
}
