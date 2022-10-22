package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import java.util.Locale;
/* compiled from: IRemoteViewDelegateImpl.java */
/* loaded from: classes2.dex */
public class y extends q {
    private ImageView A;
    private TextView B;
    private IObjectWrapper C;

    /* renamed from: y  reason: collision with root package name */
    protected ViewfinderView f15084y;

    /* renamed from: z  reason: collision with root package name */
    protected ImageView f15085z;

    public y(Context context, int i10, IObjectWrapper iObjectWrapper, boolean z10, boolean z11) {
        super(context, i10, null, iObjectWrapper, z10, false, z11);
        this.C = iObjectWrapper;
        this.f15051e = context;
        this.f15050d = i10;
        this.f15064r = z10;
        this.f15062p = new Rect(-1, -1, -1, -1);
        this.f15067u = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView = this.B;
        if (textView != null) {
            textView.setText(R.string.scankit_light);
        }
    }

    @Override // com.huawei.hms.scankit.q
    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.f15051e : DynamicModuleInitializer.getContext(), false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.q
    public void f() {
        RelativeLayout relativeLayout;
        ProviderRemoteView d10 = d();
        this.f15052f = d10;
        if (Build.VERSION.SDK_INT >= 19 && (relativeLayout = (RelativeLayout) d10.findViewById(R.id.scan_title)) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height);
            layoutParams.setMargins(0, l(), 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.f15053g = (TextureView) this.f15052f.findViewById(R.id.surfaceView);
        ViewfinderView viewfinderView = (ViewfinderView) this.f15052f.findViewById(R.id.viewfinderView);
        this.f15084y = viewfinderView;
        C0559e eVar = new C0559e(this.f15051e, this.f15053g, viewfinderView, this.f15062p, this.f15050d, this.C, this.f15064r, "DefaultView", false);
        this.f15054h = eVar;
        eVar.b(this.f15067u);
        ImageView imageView = (ImageView) this.f15052f.findViewById(R.id.img_btn);
        this.f15085z = imageView;
        imageView.setOnClickListener(new w(this));
        this.f15069w = (LinearLayout) this.f15052f.findViewById(R.id.flash_light_ll);
        this.A = (ImageView) this.f15052f.findViewById(R.id.ivFlash);
        c();
        this.A.setOnClickListener(new x(this));
        this.B = (TextView) this.f15052f.findViewById(R.id.flash_light_text);
        e();
        j();
        k();
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.f15052f);
    }

    protected void j() {
        if ((Locale.getDefault() != null && ("ar".equals(Locale.getDefault().getLanguage()) || "ur".equals(Locale.getDefault().getLanguage()) || "ug".equals(Locale.getDefault().getLanguage()) || "iw".equals(Locale.getDefault().getLanguage()))) || "fa".equals(Locale.getDefault().getLanguage())) {
            TextView textView = (TextView) this.f15052f.findViewById(R.id.title_scan);
            ImageView imageView = (ImageView) this.f15052f.findViewById(R.id.back_img_in);
            if (imageView != null) {
                imageView.setRotation(180.0f);
            }
            if (textView != null) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                    layoutParams2.addRule(1, R.id.img_btn);
                    layoutParams2.rightMargin = 200;
                    textView.setLayoutParams(layoutParams);
                }
            }
            k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
        ViewGroup.LayoutParams layoutParams = this.f15069w.getLayoutParams();
        Context context = this.f15051e;
        if (context != null && context.getResources() != null && this.f15051e.getResources().getDisplayMetrics() != null && this.f15051e.getResources().getDisplayMetrics().widthPixels > 1990 && this.f15051e.getResources().getDisplayMetrics().widthPixels < 2300 && this.f15051e.getResources().getDisplayMetrics().heightPixels > 2190 && this.f15051e.getResources().getDisplayMetrics().heightPixels < 2600 && (layoutParams instanceof FrameLayout.LayoutParams)) {
            ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 150;
            this.f15069w.setLayoutParams(layoutParams);
        }
    }

    protected int l() {
        int identifier;
        Context context = this.f15051e;
        if (context == null || context.getResources() == null || (identifier = this.f15051e.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return this.f15051e.getResources().getDimensionPixelSize(identifier);
    }

    @Override // com.huawei.hms.scankit.q, android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        this.f15054h.e();
        m();
        SensorManager sensorManager = this.f15056j;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        this.f15057k = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.q, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.q
    public void c() {
        super.c();
        if (!this.f15058l) {
            this.f15069w.setVisibility(0);
        }
    }
}
