package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.wear.common.base.WearPath;
import j0.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f2451k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f2452a;

    /* renamed from: b  reason: collision with root package name */
    Object f2453b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f2454c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f2455d;

    /* renamed from: e  reason: collision with root package name */
    public int f2456e;

    /* renamed from: f  reason: collision with root package name */
    public int f2457f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2458g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f2459h;

    /* renamed from: i  reason: collision with root package name */
    public String f2460i;

    /* renamed from: j  reason: collision with root package name */
    public String f2461j;

    public IconCompat() {
        this.f2452a = -1;
        this.f2454c = null;
        this.f2455d = null;
        this.f2456e = 0;
        this.f2457f = 0;
        this.f2458g = null;
        this.f2459h = f2451k;
        this.f2460i = null;
    }

    public static IconCompat a(Icon icon) {
        h.g(icon);
        int n10 = n(icon);
        if (n10 == 2) {
            return h(null, l(icon), j(icon));
        }
        if (n10 == 4) {
            return f(p(icon));
        }
        if (n10 == 6) {
            return d(p(icon));
        }
        IconCompat iconCompat = new IconCompat(-1);
        iconCompat.f2453b = icon;
        return iconCompat;
    }

    public static IconCompat b(Icon icon) {
        if (n(icon) == 2 && j(icon) == 0) {
            return null;
        }
        return a(icon);
    }

    static Bitmap c(Bitmap bitmap, boolean z10) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat d(Uri uri) {
        if (uri != null) {
            return e(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat e(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(6);
            iconCompat.f2453b = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat f(Uri uri) {
        if (uri != null) {
            return g(uri.toString());
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat g(String str) {
        if (str != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.f2453b = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Uri must not be null.");
    }

    public static IconCompat h(Resources resources, String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        } else if (i10 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2456e = i10;
            if (resources != null) {
                try {
                    iconCompat.f2453b = resources.getResourceName(i10);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f2453b = str;
            }
            iconCompat.f2461j = str;
            return iconCompat;
        } else {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
    }

    private static int j(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon resource", e12);
            return 0;
        }
    }

    private static String l(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon package", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon package", e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon package", e12);
            return null;
        }
    }

    private static int n(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e10);
            return -1;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e11);
            return -1;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e12);
            return -1;
        }
    }

    private static Uri p(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    private static String v(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public int i() {
        int i10 = this.f2452a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return j((Icon) this.f2453b);
        }
        if (i10 == 2) {
            return this.f2456e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String k() {
        int i10 = this.f2452a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return l((Icon) this.f2453b);
        }
        if (i10 != 2) {
            throw new IllegalStateException("called getResPackage() on " + this);
        } else if (TextUtils.isEmpty(this.f2461j)) {
            return ((String) this.f2453b).split(":", -1)[0];
        } else {
            return this.f2461j;
        }
    }

    public int m() {
        int i10 = this.f2452a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : n((Icon) this.f2453b);
    }

    public Uri o() {
        int i10 = this.f2452a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return p((Icon) this.f2453b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f2453b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream q(Context context) {
        Uri o10 = o();
        String scheme = o10.getScheme();
        if ("content".equals(scheme) || WearPath.RecorderV2.MAP_KEY_FILE.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(o10);
            } catch (Exception e10) {
                Log.w("IconCompat", "Unable to load image from URI: " + o10, e10);
                return null;
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f2453b));
            } catch (FileNotFoundException e11) {
                Log.w("IconCompat", "Unable to load image from path: " + o10, e11);
                return null;
            }
        }
    }

    public void r() {
        this.f2459h = PorterDuff.Mode.valueOf(this.f2460i);
        switch (this.f2452a) {
            case -1:
                Parcelable parcelable = this.f2455d;
                if (parcelable != null) {
                    this.f2453b = parcelable;
                    return;
                }
                throw new IllegalArgumentException("Invalid icon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2455d;
                if (parcelable2 != null) {
                    this.f2453b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2454c;
                this.f2453b = bArr;
                this.f2452a = 3;
                this.f2456e = 0;
                this.f2457f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2454c, Charset.forName("UTF-16"));
                this.f2453b = str;
                if (this.f2452a == 2 && this.f2461j == null) {
                    this.f2461j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2453b = this.f2454c;
                return;
        }
    }

    public void s(boolean z10) {
        this.f2460i = this.f2459h.name();
        switch (this.f2452a) {
            case -1:
                if (!z10) {
                    this.f2455d = (Parcelable) this.f2453b;
                    return;
                }
                throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z10) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f2453b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f2454c = byteArrayOutputStream.toByteArray();
                    return;
                }
                this.f2455d = (Parcelable) this.f2453b;
                return;
            case 2:
                this.f2454c = ((String) this.f2453b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2454c = (byte[]) this.f2453b;
                return;
            case 4:
            case 6:
                this.f2454c = this.f2453b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    @Deprecated
    public Icon t() {
        return u(null);
    }

    public String toString() {
        if (this.f2452a == -1) {
            return String.valueOf(this.f2453b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(v(this.f2452a));
        switch (this.f2452a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f2453b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f2453b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f2461j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(i())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f2456e);
                if (this.f2457f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f2457f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f2453b);
                break;
        }
        if (this.f2458g != null) {
            sb2.append(" tint=");
            sb2.append(this.f2458g);
        }
        if (this.f2459h != f2451k) {
            sb2.append(" mode=");
            sb2.append(this.f2459h);
        }
        sb2.append(")");
        return sb2.toString();
    }

    public Icon u(Context context) {
        Icon icon;
        switch (this.f2452a) {
            case -1:
                return (Icon) this.f2453b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                icon = Icon.createWithBitmap((Bitmap) this.f2453b);
                break;
            case 2:
                icon = Icon.createWithResource(k(), this.f2456e);
                break;
            case 3:
                icon = Icon.createWithData((byte[]) this.f2453b, this.f2456e, this.f2457f);
                break;
            case 4:
                icon = Icon.createWithContentUri((String) this.f2453b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    icon = Icon.createWithBitmap(c((Bitmap) this.f2453b, false));
                    break;
                } else {
                    icon = Icon.createWithAdaptiveBitmap((Bitmap) this.f2453b);
                    break;
                }
            case 6:
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    icon = Icon.createWithAdaptiveBitmapContentUri(o());
                    break;
                } else if (context != null) {
                    InputStream q5 = q(context);
                    if (q5 != null) {
                        if (i10 < 26) {
                            icon = Icon.createWithBitmap(c(BitmapFactory.decodeStream(q5), false));
                            break;
                        } else {
                            icon = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(q5));
                            break;
                        }
                    } else {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + o());
                    }
                } else {
                    throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + o());
                }
        }
        ColorStateList colorStateList = this.f2458g;
        if (colorStateList != null) {
            icon.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2459h;
        if (mode != f2451k) {
            icon.setTintMode(mode);
        }
        return icon;
    }

    private IconCompat(int i10) {
        this.f2452a = -1;
        this.f2454c = null;
        this.f2455d = null;
        this.f2456e = 0;
        this.f2457f = 0;
        this.f2458g = null;
        this.f2459h = f2451k;
        this.f2460i = null;
        this.f2452a = i10;
    }
}
