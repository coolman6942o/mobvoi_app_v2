package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.theartofdev.edmodo.cropper.CropImageView;
/* loaded from: classes2.dex */
public class CropImageOptions implements Parcelable {
    public static final Parcelable.Creator<CropImageOptions> CREATOR = new a();
    public int A;
    public int B;
    public int C;
    public CharSequence D;
    public int E;
    public Uri F;
    public Bitmap.CompressFormat G;
    public int H;
    public int I;
    public int J;
    public CropImageView.RequestSizeOptions K;
    public boolean L;
    public Rect M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public boolean T;
    public CharSequence U;
    public int V;

    /* renamed from: a  reason: collision with root package name */
    public CropImageView.CropShape f23061a;

    /* renamed from: b  reason: collision with root package name */
    public float f23062b;

    /* renamed from: c  reason: collision with root package name */
    public float f23063c;

    /* renamed from: d  reason: collision with root package name */
    public CropImageView.Guidelines f23064d;

    /* renamed from: e  reason: collision with root package name */
    public CropImageView.ScaleType f23065e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23066f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f23067g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f23068h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f23069i;

    /* renamed from: j  reason: collision with root package name */
    public int f23070j;

    /* renamed from: k  reason: collision with root package name */
    public float f23071k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f23072l;

    /* renamed from: m  reason: collision with root package name */
    public int f23073m;

    /* renamed from: n  reason: collision with root package name */
    public int f23074n;

    /* renamed from: o  reason: collision with root package name */
    public float f23075o;

    /* renamed from: p  reason: collision with root package name */
    public int f23076p;

    /* renamed from: q  reason: collision with root package name */
    public float f23077q;

    /* renamed from: r  reason: collision with root package name */
    public float f23078r;

    /* renamed from: s  reason: collision with root package name */
    public float f23079s;

    /* renamed from: t  reason: collision with root package name */
    public int f23080t;

    /* renamed from: u  reason: collision with root package name */
    public float f23081u;

    /* renamed from: v  reason: collision with root package name */
    public int f23082v;

    /* renamed from: w  reason: collision with root package name */
    public int f23083w;

    /* renamed from: x  reason: collision with root package name */
    public int f23084x;

    /* renamed from: y  reason: collision with root package name */
    public int f23085y;

    /* renamed from: z  reason: collision with root package name */
    public int f23086z;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<CropImageOptions> {
        a() {
        }

        /* renamed from: a */
        public CropImageOptions createFromParcel(Parcel parcel) {
            return new CropImageOptions(parcel);
        }

        /* renamed from: b */
        public CropImageOptions[] newArray(int i10) {
            return new CropImageOptions[i10];
        }
    }

    public CropImageOptions() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f23061a = CropImageView.CropShape.RECTANGLE;
        this.f23062b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f23063c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f23064d = CropImageView.Guidelines.ON_TOUCH;
        this.f23065e = CropImageView.ScaleType.FIT_CENTER;
        this.f23066f = true;
        this.f23067g = true;
        this.f23068h = true;
        this.f23069i = false;
        this.f23070j = 4;
        this.f23071k = 0.1f;
        this.f23072l = false;
        this.f23073m = 1;
        this.f23074n = 1;
        this.f23075o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f23076p = Color.argb(170, 255, 255, 255);
        this.f23077q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f23078r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.f23079s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.f23080t = -1;
        this.f23081u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f23082v = Color.argb(170, 255, 255, 255);
        this.f23083w = Color.argb(119, 0, 0, 0);
        this.f23084x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f23085y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f23086z = 40;
        this.A = 40;
        this.B = 99999;
        this.C = 99999;
        this.D = "";
        this.E = 0;
        this.F = Uri.EMPTY;
        this.G = Bitmap.CompressFormat.JPEG;
        this.H = 90;
        this.I = 0;
        this.J = 0;
        this.K = CropImageView.RequestSizeOptions.NONE;
        this.L = false;
        this.M = null;
        this.N = -1;
        this.O = true;
        this.P = true;
        this.Q = false;
        this.R = 90;
        this.S = false;
        this.T = false;
        this.U = null;
        this.V = 0;
    }

    public void a() {
        if (this.f23070j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.f23063c >= 0.0f) {
            float f10 = this.f23071k;
            if (f10 < 0.0f || f10 >= 0.5d) {
                throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
            } else if (this.f23073m <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.f23074n <= 0) {
                throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
            } else if (this.f23075o < 0.0f) {
                throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
            } else if (this.f23077q < 0.0f) {
                throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
            } else if (this.f23081u < 0.0f) {
                throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
            } else if (this.f23085y >= 0) {
                int i10 = this.f23086z;
                if (i10 >= 0) {
                    int i11 = this.A;
                    if (i11 < 0) {
                        throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                    } else if (this.B < i10) {
                        throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                    } else if (this.C < i11) {
                        throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                    } else if (this.I < 0) {
                        throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                    } else if (this.J >= 0) {
                        int i12 = this.R;
                        if (i12 < 0 || i12 > 360) {
                            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                    }
                } else {
                    throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                }
            } else {
                throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
            }
        } else {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f23061a.ordinal());
        parcel.writeFloat(this.f23062b);
        parcel.writeFloat(this.f23063c);
        parcel.writeInt(this.f23064d.ordinal());
        parcel.writeInt(this.f23065e.ordinal());
        parcel.writeByte(this.f23066f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23067g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23068h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f23069i ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f23070j);
        parcel.writeFloat(this.f23071k);
        parcel.writeByte(this.f23072l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f23073m);
        parcel.writeInt(this.f23074n);
        parcel.writeFloat(this.f23075o);
        parcel.writeInt(this.f23076p);
        parcel.writeFloat(this.f23077q);
        parcel.writeFloat(this.f23078r);
        parcel.writeFloat(this.f23079s);
        parcel.writeInt(this.f23080t);
        parcel.writeFloat(this.f23081u);
        parcel.writeInt(this.f23082v);
        parcel.writeInt(this.f23083w);
        parcel.writeInt(this.f23084x);
        parcel.writeInt(this.f23085y);
        parcel.writeInt(this.f23086z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        TextUtils.writeToParcel(this.D, parcel, i10);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.F, i10);
        parcel.writeString(this.G.name());
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K.ordinal());
        parcel.writeInt(this.L ? 1 : 0);
        parcel.writeParcelable(this.M, i10);
        parcel.writeInt(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.R);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.T ? (byte) 1 : (byte) 0);
        TextUtils.writeToParcel(this.U, parcel, i10);
        parcel.writeInt(this.V);
    }

    protected CropImageOptions(Parcel parcel) {
        this.f23061a = CropImageView.CropShape.values()[parcel.readInt()];
        this.f23062b = parcel.readFloat();
        this.f23063c = parcel.readFloat();
        this.f23064d = CropImageView.Guidelines.values()[parcel.readInt()];
        this.f23065e = CropImageView.ScaleType.values()[parcel.readInt()];
        boolean z10 = true;
        this.f23066f = parcel.readByte() != 0;
        this.f23067g = parcel.readByte() != 0;
        this.f23068h = parcel.readByte() != 0;
        this.f23069i = parcel.readByte() != 0;
        this.f23070j = parcel.readInt();
        this.f23071k = parcel.readFloat();
        this.f23072l = parcel.readByte() != 0;
        this.f23073m = parcel.readInt();
        this.f23074n = parcel.readInt();
        this.f23075o = parcel.readFloat();
        this.f23076p = parcel.readInt();
        this.f23077q = parcel.readFloat();
        this.f23078r = parcel.readFloat();
        this.f23079s = parcel.readFloat();
        this.f23080t = parcel.readInt();
        this.f23081u = parcel.readFloat();
        this.f23082v = parcel.readInt();
        this.f23083w = parcel.readInt();
        this.f23084x = parcel.readInt();
        this.f23085y = parcel.readInt();
        this.f23086z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.E = parcel.readInt();
        this.F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.G = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = CropImageView.RequestSizeOptions.values()[parcel.readInt()];
        this.L = parcel.readByte() != 0;
        this.M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.N = parcel.readInt();
        this.O = parcel.readByte() != 0;
        this.P = parcel.readByte() != 0;
        this.Q = parcel.readByte() != 0;
        this.R = parcel.readInt();
        this.S = parcel.readByte() != 0;
        this.T = parcel.readByte() == 0 ? false : z10;
        this.U = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.V = parcel.readInt();
    }
}
