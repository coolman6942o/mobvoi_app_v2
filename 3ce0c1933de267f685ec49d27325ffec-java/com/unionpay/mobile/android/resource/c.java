package com.unionpay.mobile.android.resource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.k;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static c f23982c;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Integer, WeakReference<Drawable.ConstantState>> f23983a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Context f23984b;

    private c(Context context) {
        this.f23984b = null;
        this.f23984b = context;
    }

    public static c a(Context context) {
        if (f23982c == null) {
            f23982c = new c(context);
        }
        return f23982c;
    }

    public final Drawable a(int i10, int i11, int i12) {
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3 = null;
        if (i10 < 0) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReference = this.f23983a.get(Integer.valueOf(i10));
        if (weakReference != null) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable();
            }
            this.f23983a.remove(Integer.valueOf(i10));
        }
        int i13 = (i10 / 1000) * 1000;
        int i14 = i10 - i13;
        if (i13 == 2000) {
            int[] iArr = b.f23974a[i14];
            drawable = h.a(a(iArr[0], i11, i12), a(iArr[1], i11, i12), a(iArr[2], i11, i12), a(iArr[3], i11, i12));
        } else if (i13 != 3000) {
            drawable = i13 != 4000 ? null : h.a(b.f23979f[i14], b.f23980g[i14], b.f23981h[i14]);
        } else {
            int i15 = b.f23978e[i14];
            int[] iArr2 = b.f23977d[i14];
            float[] fArr = b.f23975b[i14];
            float[] fArr2 = b.f23976c[i14];
            drawable = h.a(i15, iArr2, fArr, fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
        }
        if (drawable == null) {
            InputStream resourceAsStream = a.class.getClassLoader().getResourceAsStream("assets/data.bin");
            DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
            int i16 = (i10 - 1000) * 8;
            int i17 = i16;
            while (true) {
                long j10 = i17;
                try {
                    long skip = dataInputStream.skip(j10);
                    if (skip >= j10) {
                        break;
                    }
                    i17 = (int) (j10 - skip);
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            int i18 = readInt - (i16 + 8);
            while (true) {
                long j11 = i18;
                long skip2 = dataInputStream.skip(j11);
                if (skip2 >= j11) {
                    break;
                }
                i18 = (int) (j11 - skip2);
            }
            dataInputStream.mark(readInt2);
            Bitmap decodeStream = BitmapFactory.decodeStream(dataInputStream);
            Rect rect = new Rect();
            if (decodeStream.getNinePatchChunk() != null) {
                drawable2 = new NinePatchDrawable(this.f23984b.getResources(), decodeStream, decodeStream.getNinePatchChunk(), rect, null);
            } else if (-1 != i12 && -1 != i11) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, i11, i12, true);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                drawable2 = new BitmapDrawable(this.f23984b.getResources(), createScaledBitmap);
            } else if (-1 != i12 && -1 == i11) {
                int width = (int) ((decodeStream.getWidth() / decodeStream.getHeight()) * i12);
                k.a("img", "w=" + width + ",h=" + i12);
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeStream, width, i12, true);
                if (createScaledBitmap2 != decodeStream) {
                    decodeStream.recycle();
                }
                drawable2 = new BitmapDrawable(this.f23984b.getResources(), createScaledBitmap2);
            } else if (-1 == i11 || -1 != i12) {
                drawable2 = new BitmapDrawable(this.f23984b.getResources(), decodeStream);
            } else {
                Bitmap createScaledBitmap3 = Bitmap.createScaledBitmap(decodeStream, i11, (int) ((decodeStream.getHeight() / decodeStream.getWidth()) * i11), true);
                if (createScaledBitmap3 != decodeStream) {
                    decodeStream.recycle();
                }
                drawable2 = new BitmapDrawable(this.f23984b.getResources(), createScaledBitmap3);
            }
            dataInputStream.close();
            resourceAsStream.close();
            drawable3 = drawable2;
        } else {
            drawable3 = drawable;
        }
        if (drawable3 != null) {
            this.f23983a.put(Integer.valueOf(i10), new WeakReference<>(drawable3.getConstantState()));
        }
        return drawable3;
    }

    public final void a() {
        for (WeakReference<Drawable.ConstantState> weakReference : this.f23983a.values()) {
            Drawable.ConstantState constantState = weakReference.get();
            if (constantState != null) {
                Drawable newDrawable = constantState.newDrawable();
                if (newDrawable instanceof BitmapDrawable) {
                    ((BitmapDrawable) newDrawable).getBitmap().recycle();
                }
            }
        }
        this.f23983a.clear();
        f23982c = null;
    }
}
