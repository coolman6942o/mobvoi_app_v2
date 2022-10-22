package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
/* compiled from: EmojiSpan.java */
/* loaded from: classes.dex */
public abstract class h extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    private final f f2840b;

    /* renamed from: a  reason: collision with root package name */
    private final Paint.FontMetricsInt f2839a = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    private short f2841c = -1;

    /* renamed from: d  reason: collision with root package name */
    private float f2842d = 1.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        j0.h.h(fVar, "metadata cannot be null");
        this.f2840b = fVar;
    }

    public final f a() {
        return this.f2840b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f2841c;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f2839a);
        Paint.FontMetricsInt fontMetricsInt2 = this.f2839a;
        this.f2842d = (Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f) / this.f2840b.e();
        this.f2840b.e();
        short i12 = (short) (this.f2840b.i() * this.f2842d);
        this.f2841c = i12;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f2839a;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i12;
    }
}
