package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class UPRadiationView extends View {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f24006a;

    /* renamed from: b  reason: collision with root package name */
    private int f24007b;

    /* renamed from: c  reason: collision with root package name */
    private int f24008c;

    /* renamed from: d  reason: collision with root package name */
    private Context f24009d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f24010e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        Paint f24011a;

        /* renamed from: b  reason: collision with root package name */
        int f24012b;

        /* renamed from: c  reason: collision with root package name */
        float f24013c;

        /* renamed from: d  reason: collision with root package name */
        int f24014d;

        private a() {
        }

        /* synthetic */ a(UPRadiationView uPRadiationView, byte b10) {
            this();
        }
    }

    public UPRadiationView(Context context) {
        this(context, null);
    }

    public UPRadiationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24009d = context;
        this.f24006a = Collections.synchronizedList(new ArrayList());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f24009d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i10 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((Activity) this.f24009d).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
        int i11 = displayMetrics2.heightPixels;
        if (i10 <= 0 || i11 <= 0) {
            throw new RuntimeException("size illegal");
        }
        this.f24007b = i10 / 2;
        this.f24008c = (i11 / 2) - b.f23349n;
        t tVar = new t(this);
        this.f24010e = tVar;
        tVar.sendEmptyMessage(0);
    }

    private static Paint a(int i10, float f10) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(f10);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(i10);
        paint.setColor(-1);
        return paint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(UPRadiationView uPRadiationView) {
        int i10;
        List<a> list = uPRadiationView.f24006a;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            a aVar = new a(uPRadiationView, (byte) 0);
            aVar.f24012b = 0;
            aVar.f24014d = 255;
            float f10 = 0 / 4;
            aVar.f24013c = f10;
            aVar.f24011a = a(255, f10);
            uPRadiationView.f24006a.add(aVar);
            return;
        }
        for (int i11 = 0; i11 < uPRadiationView.f24006a.size(); i11++) {
            a aVar2 = uPRadiationView.f24006a.get(i11);
            int i12 = aVar2.f24014d;
            if (i12 == 0) {
                uPRadiationView.f24006a.remove(i11);
                aVar2.f24011a = null;
            } else {
                aVar2.f24012b = aVar2.f24012b + 10;
                int i13 = i12 - 4;
                aVar2.f24014d = i13;
                if (i13 < 0) {
                    aVar2.f24014d = 0;
                }
                aVar2.f24013c = i10 / 4;
                aVar2.f24011a.setAlpha(aVar2.f24014d);
                aVar2.f24011a.setStrokeWidth(aVar2.f24013c);
                if (aVar2.f24012b == g.a(uPRadiationView.f24009d, 60.0f)) {
                    a aVar3 = new a(uPRadiationView, (byte) 0);
                    aVar3.f24012b = 0;
                    aVar3.f24014d = 255;
                    float f11 = 0 / 4;
                    aVar3.f24013c = f11;
                    aVar3.f24011a = a(255, f11);
                    uPRadiationView.f24006a.add(aVar3);
                }
            }
        }
    }

    public final void a() {
        this.f24009d = null;
        this.f24010e.removeCallbacksAndMessages(null);
        this.f24010e = null;
        List<a> list = this.f24006a;
        if (list != null) {
            list.clear();
        }
        this.f24006a = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (int i10 = 0; i10 < this.f24006a.size(); i10++) {
            a aVar = this.f24006a.get(i10);
            canvas.drawCircle(this.f24007b, this.f24008c, aVar.f24012b, aVar.f24011a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
    }
}
