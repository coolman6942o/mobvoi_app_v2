package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import b6.i;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
@KeepName
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f8820a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f8821b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8822c;

    /* renamed from: d  reason: collision with root package name */
    private final CursorWindow[] f8823d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8824e;

    /* renamed from: f  reason: collision with root package name */
    private final Bundle f8825f;

    /* renamed from: g  reason: collision with root package name */
    private int[] f8826g;

    /* renamed from: h  reason: collision with root package name */
    private int f8827h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8828i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f8829j = true;

    /* loaded from: classes.dex */
    public static class zaa extends RuntimeException {
        public zaa(String str) {
            super(str);
        }
    }

    static {
        new b(new String[0], null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DataHolder(int i10, String[] strArr, CursorWindow[] cursorWindowArr, int i11, Bundle bundle) {
        this.f8820a = i10;
        this.f8821b = strArr;
        this.f8823d = cursorWindowArr;
        this.f8824e = i11;
        this.f8825f = bundle;
    }

    private final void M0(String str, int i10) {
        Bundle bundle = this.f8822c;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "No such column: ".concat(valueOf) : new String("No such column: "));
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i10 < 0 || i10 >= this.f8827h) {
            throw new CursorIndexOutOfBoundsException(i10, this.f8827h);
        }
    }

    public final byte[] G0(String str, int i10, int i11) {
        M0(str, i10);
        return this.f8823d[i11].getBlob(i10, this.f8822c.getInt(str));
    }

    public final int H0(String str, int i10, int i11) {
        M0(str, i10);
        return this.f8823d[i11].getInt(i10, this.f8822c.getInt(str));
    }

    public final Bundle I0() {
        return this.f8825f;
    }

    public final int J0() {
        return this.f8824e;
    }

    public final String K0(String str, int i10, int i11) {
        M0(str, i10);
        return this.f8823d[i11].getString(i10, this.f8822c.getInt(str));
    }

    public final int L0(int i10) {
        int[] iArr;
        int i11 = 0;
        i.n(i10 >= 0 && i10 < this.f8827h);
        while (true) {
            iArr = this.f8826g;
            if (i11 >= iArr.length) {
                break;
            } else if (i10 < iArr[i11]) {
                i11--;
                break;
            } else {
                i11++;
            }
        }
        return i11 == iArr.length ? i11 - 1 : i11;
    }

    public final void N0() {
        this.f8822c = new Bundle();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            String[] strArr = this.f8821b;
            if (i11 >= strArr.length) {
                break;
            }
            this.f8822c.putInt(strArr[i11], i11);
            i11++;
        }
        this.f8826g = new int[this.f8823d.length];
        int i12 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f8823d;
            if (i10 < cursorWindowArr.length) {
                this.f8826g[i10] = i12;
                i12 += this.f8823d[i10].getNumRows() - (i12 - cursorWindowArr[i10].getStartPosition());
                i10++;
            } else {
                this.f8827h = i12;
                return;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this) {
            if (!this.f8828i) {
                this.f8828i = true;
                int i10 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f8823d;
                    if (i10 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i10].close();
                    i10++;
                }
            }
        }
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f8829j && this.f8823d.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 178);
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(obj);
                sb2.append(")");
                Log.e("DataBuffer", sb2.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final int getCount() {
        return this.f8827h;
    }

    public final boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.f8828i;
        }
        return z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.u(parcel, 1, this.f8821b, false);
        c6.a.w(parcel, 2, this.f8823d, i10, false);
        c6.a.l(parcel, 3, J0());
        c6.a.d(parcel, 4, I0(), false);
        c6.a.l(parcel, 1000, this.f8820a);
        c6.a.b(parcel, a10);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    /* loaded from: classes.dex */
    public static class a {
        private a(String[] strArr, String str) {
            String[] strArr2 = (String[]) i.k(strArr);
            new ArrayList();
            new HashMap();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(String[] strArr, String str, b bVar) {
            this(strArr, null);
        }
    }
}
