package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
/* compiled from: TintableBackgroundView.java */
/* loaded from: classes.dex */
public interface b0 {
    ColorStateList getSupportBackgroundTintList();

    PorterDuff.Mode getSupportBackgroundTintMode();

    void setSupportBackgroundTintList(ColorStateList colorStateList);

    void setSupportBackgroundTintMode(PorterDuff.Mode mode);
}
