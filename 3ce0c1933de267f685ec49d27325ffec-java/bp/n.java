package bp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import com.realsil.sdk.dfu.DfuException;
/* compiled from: DfuServiceInitiator.java */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final String f5465a;

    /* renamed from: b  reason: collision with root package name */
    private String f5466b;

    /* renamed from: e  reason: collision with root package name */
    private Uri f5469e;

    /* renamed from: f  reason: collision with root package name */
    private String f5470f;

    /* renamed from: g  reason: collision with root package name */
    private int f5471g;

    /* renamed from: h  reason: collision with root package name */
    private Uri f5472h;

    /* renamed from: i  reason: collision with root package name */
    private String f5473i;

    /* renamed from: j  reason: collision with root package name */
    private int f5474j;

    /* renamed from: k  reason: collision with root package name */
    private String f5475k;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5477m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f5478n;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f5482r;

    /* renamed from: v  reason: collision with root package name */
    private Parcelable[] f5486v;

    /* renamed from: w  reason: collision with root package name */
    private Parcelable[] f5487w;

    /* renamed from: x  reason: collision with root package name */
    private Parcelable[] f5488x;

    /* renamed from: y  reason: collision with root package name */
    private Parcelable[] f5489y;

    /* renamed from: z  reason: collision with root package name */
    private Parcelable[] f5490z;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5467c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5468d = true;

    /* renamed from: l  reason: collision with root package name */
    private int f5476l = -1;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5479o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f5480p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f5481q = false;

    /* renamed from: s  reason: collision with root package name */
    private int f5483s = 12;

    /* renamed from: t  reason: collision with root package name */
    private int f5484t = DfuException.ERROR_REMOTE_CRC_ERROR;

    /* renamed from: u  reason: collision with root package name */
    private int f5485u = 23;

    public n(String str) {
        this.f5465a = str;
    }

    private n a(Uri uri, String str, int i10, int i11, String str2) {
        this.f5469e = uri;
        this.f5470f = str;
        this.f5471g = i10;
        this.f5476l = i11;
        this.f5475k = str2;
        if ("application/zip".equals(str2)) {
            this.f5472h = null;
            this.f5473i = null;
            this.f5474j = 0;
        }
        return this;
    }

    public n b(String str) {
        this.f5466b = str;
        return this;
    }

    public n c(boolean z10) {
        this.f5477m = z10;
        return this;
    }

    public n d(boolean z10) {
        this.f5480p = z10;
        return this;
    }

    public n e(Uri uri, String str) {
        return a(uri, str, 0, 0, "application/zip");
    }

    public m f(Context context, Class<? extends g> cls) {
        if (this.f5476l != -1) {
            Intent intent = new Intent(context, cls);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f5465a);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", this.f5466b);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION", this.f5467c);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE", this.f5468d);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", this.f5475k);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", this.f5476l);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI", this.f5469e);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", this.f5470f);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID", this.f5471g);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI", this.f5472h);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH", this.f5473i);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID", this.f5474j);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", this.f5477m);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", this.f5478n);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU", this.f5479o);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME", this.f5481q);
            int i10 = this.f5484t;
            if (i10 > 0) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU", i10);
            }
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU", this.f5485u);
            intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU", this.f5480p);
            Boolean bool = this.f5482r;
            if (bool != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED", bool);
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE", this.f5483s);
            }
            Parcelable[] parcelableArr = this.f5486v;
            if (parcelableArr != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU", parcelableArr);
            }
            Parcelable[] parcelableArr2 = this.f5487w;
            if (parcelableArr2 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU", parcelableArr2);
            }
            Parcelable[] parcelableArr3 = this.f5488x;
            if (parcelableArr3 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU", parcelableArr3);
            }
            Parcelable[] parcelableArr4 = this.f5489y;
            if (parcelableArr4 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING", parcelableArr4);
            }
            Parcelable[] parcelableArr5 = this.f5490z;
            if (parcelableArr5 != null) {
                intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING", parcelableArr5);
            }
            if (Build.VERSION.SDK_INT < 26 || !this.f5468d) {
                context.startService(intent);
            } else {
                context.startForegroundService(intent);
            }
            return new m(context);
        }
        throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
    }
}
