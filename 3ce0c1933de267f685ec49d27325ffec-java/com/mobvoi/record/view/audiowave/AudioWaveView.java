package com.mobvoi.record.view.audiowave;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.mobvoi.record.e;
import com.mobvoi.record.j;
import io.m;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
/* compiled from: AudioWaveView.kt */
/* loaded from: classes2.dex */
public final class AudioWaveView extends View {

    /* renamed from: e  reason: collision with root package name */
    private final int f20717e;

    /* renamed from: g  reason: collision with root package name */
    private final int f20719g;

    /* renamed from: h  reason: collision with root package name */
    private final int f20720h;

    /* renamed from: i  reason: collision with root package name */
    private final int f20721i;

    /* renamed from: k  reason: collision with root package name */
    private final int f20723k;

    /* renamed from: l  reason: collision with root package name */
    private final int f20724l;

    /* renamed from: m  reason: collision with root package name */
    private final int f20725m;

    /* renamed from: n  reason: collision with root package name */
    private final int f20726n;

    /* renamed from: o  reason: collision with root package name */
    private final int f20727o;

    /* renamed from: p  reason: collision with root package name */
    private final Paint f20728p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f20729q;

    /* renamed from: r  reason: collision with root package name */
    private float f20730r;

    /* renamed from: s  reason: collision with root package name */
    private float f20731s;

    /* renamed from: t  reason: collision with root package name */
    private float f20732t;

    /* renamed from: u  reason: collision with root package name */
    private float f20733u;

    /* renamed from: v  reason: collision with root package name */
    private a f20734v;

    /* renamed from: x  reason: collision with root package name */
    private int f20736x;

    /* renamed from: a  reason: collision with root package name */
    private final int f20713a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    private final int f20714b = 1291845632;

    /* renamed from: c  reason: collision with root package name */
    private final int f20715c = 1712789533;

    /* renamed from: d  reason: collision with root package name */
    private int f20716d = getContext().getColor(e.f20407d);

    /* renamed from: f  reason: collision with root package name */
    private final int f20718f = vj.a.a(this, 8);

    /* renamed from: j  reason: collision with root package name */
    private final int f20722j = vj.a.a(this, 120);

    /* renamed from: w  reason: collision with root package name */
    private byte[] f20735w = new byte[0];

    /* compiled from: AudioWaveView.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void e(int i10);
    }

    public AudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int a10 = vj.a.a(this, 12);
        this.f20717e = a10;
        int a11 = vj.a.a(this, 6);
        this.f20719g = a11;
        int a12 = vj.a.a(this, 16);
        this.f20720h = a12;
        int a13 = vj.a.a(this, 8);
        this.f20721i = a13;
        this.f20723k = a12 + a13 + a10;
        int a14 = vj.a.a(this, 10);
        this.f20724l = a14;
        int a15 = vj.a.a(this, 50);
        this.f20725m = a15;
        this.f20726n = (a14 * 2) + a15;
        this.f20727o = a11 / 2;
        Paint b10 = vj.a.b(Integer.MIN_VALUE);
        b10.setStrokeWidth(vj.a.a(this, 1));
        b10.setTextAlign(Paint.Align.CENTER);
        b10.setTextSize(vj.a.a(this, 10));
        m mVar = m.f28349a;
        this.f20728p = b10;
        setWillNotDraw(false);
        d();
    }

    private final void a(Canvas canvas, float f10) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = 0;
        while (true) {
            int i15 = this.f20719g;
            if ((i14 * i15) + f10 < (-i15)) {
                i14++;
            }
        }
        while ((this.f20719g * i14) + f10 <= getWidth()) {
            boolean z10 = i14 % 5 == 0;
            this.f20728p.setColor(z10 ? this.f20713a : this.f20714b);
            float f11 = i14 * this.f20719g;
            int i16 = this.f20720h + this.f20721i;
            if (z10) {
                i13 = 0;
            } else {
                i13 = this.f20717e - this.f20718f;
            }
            canvas.drawLine(f11, i16 + i13, i10 * i14, i11 + i12 + this.f20717e, this.f20728p);
            if (i14 % 15 == 0) {
                String c10 = c((i14 / 5) * 10);
                this.f20728p.setColor(this.f20715c);
                canvas.drawText(c10, this.f20719g * i14, this.f20720h, this.f20728p);
            }
            i14++;
        }
    }

    private final void b(Canvas canvas, float f10) {
        int i10 = 0;
        while (true) {
            int i11 = this.f20727o;
            if ((i10 * i11) + f10 < (-i11)) {
                i10++;
            }
        }
        while ((this.f20727o * i10) + f10 <= getWidth()) {
            byte[] bArr = this.f20735w;
            if (i10 < bArr.length) {
                byte b10 = bArr[i10];
                this.f20728p.setColor(this.f20716d);
                int i12 = this.f20727o;
                int i13 = this.f20723k;
                int i14 = this.f20726n;
                int i15 = b10 / 2;
                canvas.drawLine(i10 * i12, ((i14 / 2) + i13) - i15, i12 * i10, i13 + (i14 / 2) + i15, this.f20728p);
                i10++;
            } else {
                return;
            }
        }
    }

    private final String c(int i10) {
        int i11 = i10 / 3600;
        int i12 = (i10 % 3600) / 60;
        int i13 = i10 % 60;
        StringBuilder sb2 = new StringBuilder();
        if (i11 > 0) {
            n nVar = n.f30086a;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11)}, 1));
            i.e(format, "java.lang.String.format(format, *args)");
            sb2.append(format);
            sb2.append(":");
        }
        n nVar2 = n.f30086a;
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i12)}, 1));
        i.e(format2, "java.lang.String.format(format, *args)");
        sb2.append(format2);
        sb2.append(":");
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i13)}, 1));
        i.e(format3, "java.lang.String.format(format, *args)");
        sb2.append(format3);
        String sb3 = sb2.toString();
        i.e(sb3, "builder.toString()");
        return sb3;
    }

    private final void d() {
        Drawable drawable = getContext().getDrawable(j.f20652a);
        i.d(drawable);
        i.e(drawable, "context.getDrawable(R.mipmap.ic_audio_wave_pointer)!!");
        this.f20729q = drawable;
    }

    public final byte[] getData() {
        return this.f20735w;
    }

    public final int getProgress() {
        return this.f20736x;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            this.f20728p.setColor(getContext().getColor(e.f20408e));
            canvas.drawRect(0.0f, this.f20723k, getWidth(), getHeight(), this.f20728p);
            canvas.save();
            float f10 = this.f20732t;
            float f11 = this.f20731s;
            float f12 = this.f20733u;
            float f13 = (f10 + f11 < (-f12) ? -f12 : f10 + f11 < 0.0f ? f10 + f11 : 0.0f) + this.f20722j;
            canvas.translate(f13, 0.0f);
            b(canvas, f13);
            a(canvas, f13);
            canvas.restore();
            Drawable drawable = this.f20729q;
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                Drawable drawable2 = this.f20729q;
                if (drawable2 != null) {
                    int i10 = this.f20722j;
                    int i11 = intrinsicWidth / 2;
                    drawable2.setBounds(i10 - i11, 0, i10 + i11, getHeight());
                    Drawable drawable3 = this.f20729q;
                    if (drawable3 != null) {
                        drawable3.draw(canvas);
                    } else {
                        i.u("progressDrawable");
                        throw null;
                    }
                } else {
                    i.u("progressDrawable");
                    throw null;
                }
            } else {
                i.u("progressDrawable");
                throw null;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        setMeasuredDimension(View.MeasureSpec.getSize(i10), this.f20723k + this.f20726n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
        if (r0 != 3) goto L23;
     */
    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.f20731s = motionEvent.getX() - this.f20730r;
                    postInvalidate();
                }
            }
            float f10 = this.f20732t + this.f20731s;
            this.f20732t = f10;
            this.f20731s = 0.0f;
            if (f10 > 0.0f) {
                this.f20732t = 0.0f;
            } else {
                float f11 = this.f20733u;
                if (f10 < (-f11)) {
                    this.f20732t = -f11;
                }
            }
            a aVar = this.f20734v;
            if (aVar != null) {
                aVar.e((int) (((-100) * this.f20732t) / this.f20733u));
            }
        } else {
            this.f20730r = motionEvent.getX();
        }
        return true;
    }

    public final void setCallback(a callback) {
        i.f(callback, "callback");
        this.f20734v = callback;
    }

    public final void setData(byte[] bArr) {
        i.f(bArr, "<set-?>");
        this.f20735w = bArr;
    }

    public final void setProgress(int i10) {
        this.f20736x = i10;
        this.f20732t = (-((this.f20735w.length * getProgress()) / 100)) * this.f20727o;
        postInvalidate();
    }

    public final void setRawData(byte[] raw) {
        int length;
        i.f(raw, "raw");
        this.f20735w = raw;
        this.f20733u = raw.length * this.f20727o;
        this.f20732t = (-((raw.length * getProgress()) / 100)) * this.f20727o;
        byte[] bArr = this.f20735w;
        int length2 = bArr.length;
        int i10 = 0;
        int i11 = 0;
        byte b10 = 0;
        while (i11 < length2) {
            byte b11 = bArr[i11];
            i11++;
            if (b11 > b10) {
                b10 = b11;
            }
        }
        if (b10 > 0 && this.f20735w.length - 1 >= 0) {
            while (true) {
                int i12 = i10 + 1;
                byte[] bArr2 = this.f20735w;
                bArr2[i10] = (byte) ((bArr2[i10] * this.f20725m) / b10);
                if (i12 > length) {
                    break;
                }
                i10 = i12;
            }
        }
        postInvalidate();
    }
}
