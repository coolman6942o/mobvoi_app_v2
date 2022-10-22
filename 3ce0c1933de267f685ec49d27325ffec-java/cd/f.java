package cd;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
/* compiled from: MapPoint.java */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public double f5722a;

    /* renamed from: b  reason: collision with root package name */
    public double f5723b;

    /* renamed from: c  reason: collision with root package name */
    public int f5724c;

    /* renamed from: d  reason: collision with root package name */
    public int f5725d;

    /* renamed from: e  reason: collision with root package name */
    public int f5726e;

    /* renamed from: f  reason: collision with root package name */
    public int f5727f;

    /* renamed from: g  reason: collision with root package name */
    public String f5728g;

    /* renamed from: h  reason: collision with root package name */
    public int f5729h;

    /* renamed from: i  reason: collision with root package name */
    public int f5730i;

    /* compiled from: MapPoint.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        double f5731a;

        /* renamed from: b  reason: collision with root package name */
        double f5732b;

        /* renamed from: c  reason: collision with root package name */
        int f5733c;

        /* renamed from: d  reason: collision with root package name */
        int f5734d;

        /* renamed from: e  reason: collision with root package name */
        int f5735e;

        /* renamed from: f  reason: collision with root package name */
        int f5736f;

        /* renamed from: g  reason: collision with root package name */
        String f5737g;

        /* renamed from: h  reason: collision with root package name */
        int f5738h;

        /* renamed from: i  reason: collision with root package name */
        int f5739i;

        public f a() {
            f fVar = new f();
            fVar.f5722a = this.f5731a;
            fVar.f5723b = this.f5732b;
            fVar.f5727f = this.f5736f;
            fVar.f5726e = this.f5735e;
            fVar.f5725d = this.f5734d;
            fVar.f5724c = this.f5733c;
            fVar.f5728g = this.f5737g;
            fVar.f5729h = this.f5738h;
            fVar.f5730i = this.f5739i;
            return fVar;
        }

        public a b(int i10) {
            this.f5736f = i10;
            return this;
        }

        public a c(int i10) {
            this.f5735e = i10;
            return this;
        }

        public a d(int i10) {
            this.f5734d = i10;
            return this;
        }

        public a e(int i10) {
            this.f5733c = i10;
            return this;
        }

        public a f(double d10) {
            this.f5731a = d10;
            return this;
        }

        public a g(double d10) {
            this.f5732b = d10;
            return this;
        }

        public a h(int i10) {
            this.f5738h = i10;
            return this;
        }

        public a i(int i10) {
            this.f5739i = i10;
            return this;
        }

        public a j(String str) {
            this.f5737g = str;
            return this;
        }
    }

    public Bitmap a() {
        Paint paint = new Paint();
        int i10 = this.f5726e;
        int i11 = i10 * 2;
        Bitmap createBitmap = Bitmap.createBitmap(i11, i11, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(this.f5724c);
        float f10 = i10;
        canvas.drawCircle(f10, f10, f10, paint);
        paint.setColor(this.f5725d);
        canvas.drawCircle(f10, f10, this.f5727f, paint);
        paint.setTextSize(this.f5730i);
        paint.setColor(this.f5729h);
        paint.setTextAlign(Paint.Align.CENTER);
        float width = canvas.getWidth() / 2;
        float height = (canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2.0f);
        if (!TextUtils.isEmpty(this.f5728g)) {
            canvas.drawText(this.f5728g, width, height, paint);
        }
        return createBitmap;
    }
}
