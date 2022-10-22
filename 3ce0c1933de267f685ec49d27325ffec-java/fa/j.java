package fa;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import io.m;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import kotlin.text.u;
import oo.b;
/* compiled from: PicDialUtil.kt */
/* loaded from: classes2.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f26390a;

    /* renamed from: d  reason: collision with root package name */
    private List<Bitmap> f26393d;

    /* renamed from: g  reason: collision with root package name */
    private final Bitmap f26396g;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f26391b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private final Paint f26392c = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private int f26394e = -1;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f26395f = b();

    public j(Context context) {
        i.f(context, "context");
        this.f26390a = context;
        Bitmap createBitmap = Bitmap.createBitmap(360, 360, Bitmap.Config.ARGB_8888);
        i.e(createBitmap, "createBitmap(DIAL_DIAMETER, DIAL_DIAMETER, Bitmap.Config.ARGB_8888)");
        this.f26396g = createBitmap;
    }

    private final Bitmap b() {
        Bitmap bitmap = Bitmap.createBitmap(360, 360, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        this.f26391b.setColor(-256);
        canvas.drawCircle(180.0f, 180.0f, 180.0f, this.f26391b);
        i.e(bitmap, "bitmap");
        return bitmap;
    }

    private final void c(Canvas canvas) {
        List<Bitmap> list = this.f26393d;
        if (list != null) {
            float f10 = 6 + 93.0f;
            Bitmap bitmap = list.get(3);
            Bitmap bitmap2 = bitmap;
            canvas.drawBitmap(bitmap2, f10, 250.0f, this.f26392c);
            float width = f10 + bitmap2.getWidth() + 3;
            int[] iArr = {6, 5, 5, 5, 5};
            for (int i10 = 0; i10 < 5; i10++) {
                bitmap = list.get(iArr[i10]);
                Bitmap bitmap3 = bitmap;
                canvas.drawBitmap(bitmap3, width, 250.0f, this.f26392c);
                width += bitmap3.getWidth();
            }
            canvas.drawBitmap(list.get(4), 93.0f, 250.0f + bitmap.getHeight() + 10, this.f26392c);
        }
    }

    private final void d(Canvas canvas) {
        this.f26392c.setColorFilter(new PorterDuffColorFilter(this.f26394e, PorterDuff.Mode.SRC_IN));
        int[] iArr = {0, 1, 2, 0, 0};
        float f10 = 45.0f;
        for (int i10 = 0; i10 < 5; i10++) {
            int i11 = iArr[i10];
            List<Bitmap> list = this.f26393d;
            i.d(list);
            Bitmap bitmap = list.get(i11);
            canvas.drawBitmap(bitmap, f10, 100.0f, this.f26392c);
            f10 += bitmap.getWidth();
        }
    }

    /* JADX WARN: Finally extract failed */
    private final List<Bitmap> f() {
        AssetManager assets = this.f26390a.getResources().getAssets();
        String[] strArr = {"apolloDial/icon_time_num_0.png", "apolloDial/icon_time_num_8.png", "apolloDial/icon_time_num_colon.png", "apolloDial/icon_step.png", "apolloDial/stepProcess/icon_step_process_8.png", "apolloDial/stepNum/icon_step_num_0.png", "apolloDial/stepNum/icon_step_num_2.png"};
        ArrayList arrayList = new ArrayList(7);
        for (int i10 = 0; i10 < 7; i10++) {
            InputStream open = assets.open(strArr[i10]);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                b.a(open, null);
                arrayList.add(decodeStream);
            } finally {
                try {
                    throw th;
                } catch (Throwable th2) {
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v8, types: [android.graphics.Bitmap] */
    private final void l(String str, ZipOutputStream zipOutputStream) {
        boolean I;
        int i10;
        String[] strArr;
        boolean o10;
        Throwable th2;
        j jVar = this;
        AssetManager assets = jVar.f26390a.getResources().getAssets();
        String[] list = assets.list(str);
        if (list != null) {
            int length = list.length;
            boolean z10 = false;
            int i11 = 0;
            while (i11 < length) {
                String name = list[i11];
                i.e(name, "name");
                I = u.I(name, ".", z10, 2, null);
                if (!I) {
                    jVar.l(i.n("apolloDial/", name), zipOutputStream);
                    strArr = list;
                    i10 = length;
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(name));
                    o10 = t.o(name, ".png", z10, 2, null);
                    if (o10) {
                        InputStream open = assets.open(str + '/' + ((Object) name));
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inMutable = true;
                            ?? decodeStream = BitmapFactory.decodeStream(open, null, options);
                            if (decodeStream == 0) {
                                strArr = list;
                                i10 = length;
                                th2 = null;
                            } else {
                                int width = decodeStream.getWidth();
                                int height = decodeStream.getHeight();
                                if (height > 0) {
                                    int i12 = z10;
                                    while (true) {
                                        int i13 = (i12 == true ? 1 : 0) + 1;
                                        if (width > 0) {
                                            int i14 = z10;
                                            while (true) {
                                                int i15 = (i14 == true ? 1 : 0) + 1;
                                                int pixel = decodeStream.getPixel(i14, i12);
                                                if (Color.alpha(pixel) == 0) {
                                                    strArr = list;
                                                    i10 = length;
                                                } else {
                                                    strArr = list;
                                                    i10 = length;
                                                    decodeStream.setPixel(i14, i12, Color.argb(Color.alpha(pixel), Color.red(e()), Color.green(e()), Color.blue(e())));
                                                }
                                                if (i15 >= width) {
                                                    break;
                                                }
                                                i14 = i15;
                                                list = strArr;
                                                length = i10;
                                            }
                                        } else {
                                            strArr = list;
                                            i10 = length;
                                        }
                                        if (i13 >= height) {
                                            break;
                                        }
                                        z10 = false;
                                        i12 = i13;
                                        list = strArr;
                                        length = i10;
                                    }
                                } else {
                                    strArr = list;
                                    i10 = length;
                                }
                                decodeStream.compress(Bitmap.CompressFormat.PNG, 100, zipOutputStream);
                                decodeStream.recycle();
                                m mVar = m.f28349a;
                                th2 = null;
                            }
                            b.a(open, th2);
                            z10 = false;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    } else {
                        strArr = list;
                        i10 = length;
                        InputStream open2 = assets.open(str + '/' + ((Object) name));
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = open2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            z10 = false;
                            m mVar2 = m.f28349a;
                            Throwable th3 = null;
                        } finally {
                            try {
                                throw th;
                            } finally {
                            }
                        }
                    }
                    zipOutputStream.closeEntry();
                }
                i11++;
                jVar = this;
                list = strArr;
                length = i10;
            }
        }
    }

    public final byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        l("apolloDial", zipOutputStream);
        zipOutputStream.putNextEntry(new ZipEntry("pic_dial_bg.png"));
        this.f26395f.compress(Bitmap.CompressFormat.PNG, 100, zipOutputStream);
        zipOutputStream.closeEntry();
        Bitmap createBitmap = Bitmap.createBitmap(240, 240, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        matrix.postScale(0.6666667f, 0.6666667f);
        canvas.drawBitmap(this.f26396g, matrix, this.f26391b);
        zipOutputStream.putNextEntry(new ZipEntry("pic_dial_pre.png"));
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, zipOutputStream);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        i.e(byteArray, "byteArrayOutputStream.toByteArray()");
        return byteArray;
    }

    public final int e() {
        return this.f26394e;
    }

    public final Bitmap g() {
        if (this.f26393d == null) {
            this.f26393d = f();
        }
        Canvas canvas = new Canvas(this.f26396g);
        canvas.drawBitmap(this.f26395f, 0.0f, 0.0f, this.f26391b);
        d(canvas);
        c(canvas);
        return this.f26396g;
    }

    public final void h() {
        this.f26394e = -1;
        this.f26395f = b();
    }

    public final Bitmap i(Bitmap bitmap) {
        i.f(bitmap, "bitmap");
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint(1);
        canvas.drawCircle(bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f, Math.min(bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        i.e(output, "output");
        return output;
    }

    public final void j(Bitmap bitmap) {
        i.f(bitmap, "<set-?>");
        this.f26395f = bitmap;
    }

    public final void k(int i10) {
        this.f26394e = i10;
    }
}
