package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.drawable.ScanDrawable;
import com.huawei.hms.scankit.util.b;
import com.huawei.hms.scankit.util.c;
import com.realsil.sdk.dfu.DfuException;
import java.util.Locale;
/* compiled from: IRemoteLocalViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class v extends y {
    private ScanDrawable D;
    private ImageView E;
    private ImageView F;

    public v(Context context, int i10, IObjectWrapper iObjectWrapper, boolean z10, boolean z11) {
        super(context, i10, iObjectWrapper, z10, z11);
    }

    @Override // com.huawei.hms.scankit.y, com.huawei.hms.scankit.q
    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f15051e : DynamicModuleInitializer.getContext(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.y, com.huawei.hms.scankit.q
    public void f() {
        ImageView imageView;
        super.f();
        this.E = (ImageView) this.f15052f.findViewById(R.id.ivScan);
        this.F = (ImageView) this.f15052f.findViewById(R.id.back_img_in);
        ImageView imageView2 = this.E;
        if (imageView2 != null) {
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            if (c.a(this.f15051e).x > c.a(this.f15051e, DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR)) {
                layoutParams.width = c.a(this.f15051e).x / 2;
            } else {
                layoutParams.width = c.a(this.f15051e).x;
            }
            this.E.setLayoutParams(layoutParams);
            ScanDrawable scanDrawable = new ScanDrawable(this.f15051e.getResources());
            this.D = scanDrawable;
            this.E.setImageDrawable(scanDrawable);
        }
        ImageView imageView3 = this.F;
        if (imageView3 != null) {
            imageView3.setOnClickListener(new u(this));
        }
        if (!b.c((Activity) this.f15051e)) {
            TextView textView = (TextView) this.f15052f.findViewById(R.id.title_scan);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) textView.getLayoutParams();
            layoutParams2.setMargins(0, 0, 0, 0);
            layoutParams2.addRule(12);
            textView.setLayoutParams(layoutParams2);
        }
        if (b.b(this.f15051e)) {
            TextView textView2 = (TextView) this.f15052f.findViewById(R.id.title_scan);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) textView2.getLayoutParams();
            layoutParams3.setMargins(0, c.a(this.f15051e, 48), 0, 0);
            layoutParams3.addRule(10);
            textView2.setLayoutParams(layoutParams3);
        }
        if (!b.c((Activity) this.f15051e) && b.a(this.f15051e) && (imageView = this.f15085z) != null) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams4.setMarginEnd(c.a(this.f15051e, 40));
            this.f15085z.setLayoutParams(layoutParams4);
        }
    }

    @Override // com.huawei.hms.scankit.y
    protected void j() {
        if ((Locale.getDefault() != null && ("ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()))) || "fa".equals(Locale.getDefault().getLanguage())) {
            ImageView imageView = this.F;
            if (imageView != null) {
                imageView.setRotation(180.0f);
            }
            k();
        }
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        super.onStart();
        ScanDrawable scanDrawable = this.D;
        if (scanDrawable != null && !scanDrawable.isRunning()) {
            this.D.start();
        }
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        super.onStop();
        ScanDrawable scanDrawable = this.D;
        if (scanDrawable != null && scanDrawable.isRunning()) {
            this.D.stop();
        }
    }
}
