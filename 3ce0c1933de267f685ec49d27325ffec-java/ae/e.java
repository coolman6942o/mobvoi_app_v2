package ae;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import ce.b;
import ce.c;
import ce.d;
import ce.h;
/* compiled from: WatchFaceItemView.java */
/* loaded from: classes2.dex */
public class e extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f189a;

    /* renamed from: b  reason: collision with root package name */
    private float f190b;

    /* renamed from: c  reason: collision with root package name */
    private float f191c;

    /* renamed from: d  reason: collision with root package name */
    private float f192d;

    /* renamed from: e  reason: collision with root package name */
    private float f193e;

    /* renamed from: f  reason: collision with root package name */
    private float f194f;

    /* renamed from: g  reason: collision with root package name */
    private float f195g;

    /* renamed from: h  reason: collision with root package name */
    private String f196h;

    /* renamed from: i  reason: collision with root package name */
    private String f197i;

    /* renamed from: j  reason: collision with root package name */
    Rect f198j;

    public e(Context context) {
        this(context, null);
    }

    public void a(com.mobvoi.companion.ui.e eVar) {
        setOnClickListener(eVar.onClickListener);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f189a.setColor(getResources().getColor(b.f5744a));
        this.f189a.setTextSize(this.f190b);
        Paint paint = this.f189a;
        String str = this.f196h;
        paint.getTextBounds(str, 0, str.length(), this.f198j);
        canvas.drawText(this.f196h, this.f193e, this.f192d + this.f198j.height(), this.f189a);
        this.f189a.setTextSize(this.f191c);
        Paint paint2 = this.f189a;
        String str2 = this.f197i;
        paint2.getTextBounds(str2, 0, str2.length(), this.f198j);
        canvas.drawText(this.f197i, this.f193e, this.f194f + this.f198j.height(), this.f189a);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) this.f195g, 1073741824));
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f198j = new Rect();
        this.f189a = new Paint(1);
        this.f190b = getResources().getDimension(c.f5752f);
        this.f191c = getResources().getDimension(c.f5749c);
        this.f192d = getResources().getDimension(c.f5751e);
        this.f193e = getResources().getDimension(c.f5750d);
        this.f194f = getResources().getDimension(c.f5748b);
        this.f195g = getResources().getDimension(c.f5747a);
        this.f196h = getResources().getString(h.f5869r0);
        this.f197i = getResources().getString(h.f5867q0);
        setBackground(getResources().getDrawable(d.f5753a));
    }
}
