package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.AppMeasurement;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.wear.util.TelephonyUtil;
import h6.f;
import j6.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;
/* loaded from: classes.dex */
public final class r5 extends z2 {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f9642g = {"firebase_", "google_", "ga_"};

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f9643c;

    /* renamed from: e  reason: collision with root package name */
    private int f9645e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f9646f = null;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f9644d = new AtomicLong(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    public r5(d2 d2Var) {
        super(d2Var);
    }

    private final boolean B0(String str, String str2) {
        if (str2 == null) {
            c().K().d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            c().K().d("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        c().K().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            c().K().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean C0(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public static f6 E(e6 e6Var, String str) {
        f6[] f6VarArr;
        for (f6 f6Var : e6Var.f9257c) {
            if (f6Var.f9274c.equals(str)) {
                return f6Var;
            }
        }
        return null;
    }

    private static Object F(int i10, Object obj, boolean z10) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return G(String.valueOf(obj), i10, z10);
            }
            return null;
        }
    }

    public static String G(String str, int i10, boolean z10) {
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (z10) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i10))).concat("...");
        }
        return null;
    }

    public static String H(String str, String[] strArr, String[] strArr2) {
        i.k(strArr);
        i.k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i10 = 0; i10 < min; i10++) {
            if (C0(str, strArr[i10])) {
                return strArr2[i10];
            }
        }
        return null;
    }

    private static void J(Bundle bundle, Object obj) {
        i.k(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", String.valueOf(obj).length());
        }
    }

    private static boolean P(Bundle bundle, int i10) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    private final boolean R(String str, String str2, int i10, Object obj, boolean z10) {
        Parcelable[] parcelableArr;
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i10) {
                    c().N().b("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            } else if ((obj instanceof Bundle) && z10) {
                return true;
            } else {
                if ((obj instanceof Parcelable[]) && z10) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            c().N().c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof ArrayList) || !z10) {
                    return false;
                } else {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    int i11 = 0;
                    while (i11 < size) {
                        Object obj2 = arrayList.get(i11);
                        i11++;
                        if (!(obj2 instanceof Bundle)) {
                            c().N().c("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean T(long[] jArr, int i10) {
        if (i10 >= (jArr.length << 6)) {
            return false;
        }
        return ((1 << (i10 % 64)) & jArr[i10 / 64]) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] U(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static long[] W(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 < bitSet.length()) {
                    if (bitSet.get(i12)) {
                        jArr[i10] = jArr[i10] | (1 << i11);
                    }
                }
            }
        }
        return jArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f6[] X(f6[] f6VarArr, String str, Object obj) {
        for (f6 f6Var : f6VarArr) {
            if (str.equals(f6Var.f9274c)) {
                f6Var.f9276e = null;
                f6Var.f9275d = null;
                f6Var.f9278g = null;
                if (obj instanceof Long) {
                    f6Var.f9276e = (Long) obj;
                } else if (obj instanceof String) {
                    f6Var.f9275d = (String) obj;
                } else if (obj instanceof Double) {
                    f6Var.f9278g = (Double) obj;
                }
                return f6VarArr;
            }
        }
        f6[] f6VarArr2 = new f6[f6VarArr.length + 1];
        System.arraycopy(f6VarArr, 0, f6VarArr2, 0, f6VarArr.length);
        f6 f6Var2 = new f6();
        f6Var2.f9274c = str;
        if (obj instanceof Long) {
            f6Var2.f9276e = (Long) obj;
        } else if (obj instanceof String) {
            f6Var2.f9275d = (String) obj;
        } else if (obj instanceof Double) {
            f6Var2.f9278g = (Double) obj;
        }
        f6VarArr2[f6VarArr.length] = f6Var2;
        return f6VarArr2;
    }

    public static Object Y(e6 e6Var, String str) {
        f6 E = E(e6Var, str);
        if (E == null) {
            return null;
        }
        String str2 = E.f9275d;
        if (str2 != null) {
            return str2;
        }
        Long l10 = E.f9276e;
        if (l10 != null) {
            return l10;
        }
        Double d10 = E.f9278g;
        if (d10 != null) {
            return d10;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b0(byte[] bArr) {
        i.k(bArr);
        int i10 = 0;
        i.n(bArr.length > 0);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (bArr[length] & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static boolean c0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!(packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null)) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d0(String str) {
        i.g(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private static int i0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        return "_id".equals(str) ? 256 : 36;
    }

    public static boolean j0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l0(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m0(String str) {
        i.g(str);
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    c10 = 0;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    c10 = 1;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean p0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean q0(zzeu zzeuVar, zzdz zzdzVar) {
        i.k(zzeuVar);
        i.k(zzdzVar);
        return !TextUtils.isEmpty(zzdzVar.f9860b);
    }

    private final boolean r0(Context context, String str) {
        b1 b1Var;
        Object e10;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo d10 = c.a(context).d(str, 64);
            if (d10 == null || (signatureArr = d10.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e11) {
            e10 = e11;
            b1Var = c().K();
            str2 = "Package name not found";
            b1Var.d(str2, e10);
            return true;
        } catch (CertificateException e12) {
            e10 = e12;
            b1Var = c().K();
            str2 = "Error obtaining certificate";
            b1Var.d(str2, e10);
            return true;
        }
    }

    public static Bundle[] s0(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    public static Object t0(Object obj) {
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        Throwable th2;
        try {
            if (obj == null) {
                return null;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                    try {
                        Object readObject = objectInputStream.readObject();
                        objectOutputStream.close();
                        objectInputStream.close();
                        return readObject;
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    th2 = th4;
                    objectInputStream = null;
                }
            } catch (Throwable th5) {
                th2 = th5;
                objectInputStream = null;
                objectOutputStream = null;
            }
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest z(String str) {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public final Bundle A(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            c().N().d("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A0(String str, String str2) {
        if (str2 == null) {
            c().K().d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            c().K().d("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                c().K().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    c().K().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (Q("event param", 40, r14) == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle B(String str, Bundle bundle, List<String> list, boolean z10, boolean z11) {
        int i10;
        String str2;
        boolean z12;
        int i11;
        Object obj;
        int i12;
        String str3;
        String str4;
        r5 r5Var;
        boolean z13;
        int i13;
        String[] strArr = null;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        Iterator<String> it = bundle.keySet().iterator();
        int i14 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (list == null || !list.contains(next)) {
                int i15 = 14;
                if (z10) {
                    if (A0("event param", next)) {
                        if (!S("event param", strArr, next)) {
                            i10 = 14;
                            if (i10 == 0) {
                                if (B0("event param", next)) {
                                    if (S("event param", strArr, next)) {
                                        if (Q("event param", 40, next)) {
                                            i15 = 0;
                                        }
                                    }
                                    i10 = i15;
                                }
                                i15 = 3;
                                i10 = i15;
                            }
                        }
                    }
                    i10 = 3;
                    if (i10 == 0) {
                    }
                }
                i10 = 0;
                if (i10 == 0) {
                }
            } else {
                i10 = 0;
            }
            if (i10 == 0) {
                Object obj2 = bundle.get(next);
                e();
                if (z11) {
                    if (obj2 instanceof Parcelable[]) {
                        i13 = ((Parcelable[]) obj2).length;
                    } else {
                        if (obj2 instanceof ArrayList) {
                            i13 = ((ArrayList) obj2).size();
                        }
                        z13 = true;
                        if (!z13) {
                            i11 = 17;
                            str2 = "_ev";
                            z12 = true;
                            if (i11 != 0 || str2.equals(next)) {
                                if (d0(next) || (i14 = i14 + 1) <= 25) {
                                    strArr = null;
                                } else {
                                    StringBuilder sb2 = new StringBuilder(48);
                                    sb2.append("Event can't contain more than 25 params");
                                    c().K().c(sb2.toString(), o().M(str), o().J(bundle));
                                    P(bundle2, 5);
                                }
                            } else if (P(bundle2, i11)) {
                                bundle2.putString(str2, G(next, 40, z12));
                                J(bundle2, bundle.get(next));
                            }
                        }
                    }
                    if (i13 > 1000) {
                        c().N().b("Parameter array is too long; discarded. Value kind, name, array length", "param", next, Integer.valueOf(i13));
                        z13 = false;
                        if (!z13) {
                        }
                    }
                    z13 = true;
                    if (!z13) {
                    }
                }
                if ((!s().A(j().A()) || !j0(str)) && !j0(next)) {
                    str2 = "_ev";
                    z12 = true;
                    i12 = 100;
                    str4 = "param";
                    r5Var = this;
                    str3 = next;
                    obj = obj2;
                } else {
                    i12 = 256;
                    str4 = "param";
                    r5Var = this;
                    str3 = next;
                    z12 = true;
                    obj = obj2;
                    str2 = "_ev";
                }
                i11 = r5Var.R(str4, str3, i12, obj, z11) ? 0 : 4;
                if (i11 != 0) {
                }
                if (d0(next)) {
                }
                strArr = null;
            } else if (P(bundle2, i10)) {
                bundle2.putString("_ev", G(next, 40, true));
                if (i10 == 3) {
                    J(bundle2, next);
                }
            }
            bundle2.remove(next);
            strArr = null;
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T C(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            c().K().a("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzeu D(String str, Bundle bundle, String str2, long j10, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (e0(str) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str2);
            return new zzeu(str, new zzer(o0(B(str, bundle2, f.b("_o"), false, false))), str2, j10);
        }
        c().K().d("Invalid conditional property event name", o().O(str));
        throw new IllegalArgumentException();
    }

    public final boolean D0(String str) {
        e();
        if (c.a(getContext()).a(str) == 0) {
            return true;
        }
        c().Q().d("Permission not granted", str);
        return false;
    }

    public final void I(int i10, String str, String str2, int i11) {
        N(null, i10, str, str2, i11);
    }

    public final void K(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                c().O().c("Not putting event parameter. Invalid value type. name, type", o().N(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void L(f6 f6Var, Object obj) {
        i.k(obj);
        f6Var.f9275d = null;
        f6Var.f9276e = null;
        f6Var.f9278g = null;
        if (obj instanceof String) {
            f6Var.f9275d = (String) obj;
        } else if (obj instanceof Long) {
            f6Var.f9276e = (Long) obj;
        } else if (obj instanceof Double) {
            f6Var.f9278g = (Double) obj;
        } else {
            c().K().d("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void M(j6 j6Var, Object obj) {
        i.k(obj);
        j6Var.f9414e = null;
        j6Var.f9415f = null;
        j6Var.f9417h = null;
        if (obj instanceof String) {
            j6Var.f9414e = (String) obj;
        } else if (obj instanceof Long) {
            j6Var.f9415f = (Long) obj;
        } else if (obj instanceof Double) {
            j6Var.f9417h = (Double) obj;
        } else {
            c().K().d("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void N(String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        P(bundle, i10);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        this.f9815a.o0().G(CameraConfig.CAMERA_FOCUS_AUTO, "_err", bundle);
    }

    public final boolean O(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(b().b() - j10) > j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean Q(String str, int i10, String str2) {
        if (str2 == null) {
            c().K().d("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        } else {
            c().K().b("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean S(String str, String[] strArr, String str2) {
        boolean z10;
        boolean z11;
        if (str2 == null) {
            c().K().d("Name is required and can't be null. Type", str);
            return false;
        }
        i.k(str2);
        int i10 = 0;
        while (true) {
            String[] strArr2 = f9642g;
            if (i10 >= strArr2.length) {
                z10 = false;
                break;
            } else if (str2.startsWith(strArr2[i10])) {
                z10 = true;
                break;
            } else {
                i10++;
            }
        }
        if (z10) {
            c().K().c("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            i.k(strArr);
            int i11 = 0;
            while (true) {
                if (i11 >= strArr.length) {
                    z11 = false;
                    break;
                } else if (C0(str2, strArr[i11])) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                c().K().c("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final byte[] V(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            c().K().d("Failed to gzip content", e10);
            throw e10;
        }
    }

    public final byte[] Z(g6 g6Var) {
        try {
            int f10 = g6Var.f();
            byte[] bArr = new byte[f10];
            h p10 = h.p(bArr, 0, f10);
            g6Var.b(p10);
            p10.B();
            return bArr;
        } catch (IOException e10) {
            c().K().d("Data loss. Failed to serialize batch", e10);
            return null;
        }
    }

    public final byte[] a0(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            c().K().d("Failed to ungzip content", e10);
            throw e10;
        }
    }

    public final int e0(String str) {
        if (!B0("event", str)) {
            return 2;
        }
        if (!S("event", AppMeasurement.a.f10131a, str)) {
            return 13;
        }
        return !Q("event", 40, str) ? 2 : 0;
    }

    public final int f0(String str) {
        if (!A0("user property", str)) {
            return 6;
        }
        if (!S("user property", AppMeasurement.e.f10135a, str)) {
            return 15;
        }
        return !Q("user property", 24, str) ? 6 : 0;
    }

    public final int g0(String str) {
        if (!B0("user property", str)) {
            return 6;
        }
        if (!S("user property", AppMeasurement.e.f10135a, str)) {
            return 15;
        }
        return !Q("user property", 24, str) ? 6 : 0;
    }

    public final boolean h0(String str) {
        if (TextUtils.isEmpty(str)) {
            c().K().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        i.k(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        c().K().d("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean k0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return s().M().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0067 -> B:16:0x0074). Please submit an issue!!! */
    public final long n0(Context context, String str) {
        e();
        i.k(context);
        i.g(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest z10 = z("MD5");
        long j10 = -1;
        j10 = 0;
        if (z10 == null) {
            c().K().a("Could not get MD5 instance");
        } else if (packageManager != null) {
            try {
            } catch (PackageManager.NameNotFoundException e10) {
                c().K().d("Package name not found", e10);
            }
            if (!r0(context, str)) {
                Signature[] signatureArr = c.a(context).d(getContext().getPackageName(), 64).signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    c().N().a("Could not get signatures");
                } else {
                    j10 = b0(z10.digest(signatureArr[0].toByteArray()));
                }
            }
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle o0(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object u02 = u0(str, bundle.get(str));
                if (u02 == null) {
                    c().N().d("Param value can't be null", o().N(str));
                } else {
                    K(bundle2, str, u02);
                }
            }
        }
        return bundle2;
    }

    public final Object u0(String str, Object obj) {
        boolean z10;
        int i10 = 256;
        if ("_ev".equals(str)) {
            z10 = true;
        } else {
            if (!j0(str)) {
                i10 = 100;
            }
            z10 = false;
        }
        return F(i10, obj, z10);
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return true;
    }

    public final int v0(String str, Object obj) {
        return "_ldl".equals(str) ? R("user property referrer", str, i0(str), obj, false) : R("user property", str, i0(str), obj, false) ? 0 : 7;
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final void w() {
        e();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                c().N().a("Utils falling back to Random for random id");
            }
        }
        this.f9644d.set(nextLong);
    }

    public final Object w0(String str, Object obj) {
        return F(i0(str), obj, "_ldl".equals(str));
    }

    public final long x0() {
        long andIncrement;
        long j10;
        if (this.f9644d.get() == 0) {
            synchronized (this.f9644d) {
                long nextLong = new Random(System.nanoTime() ^ b().b()).nextLong();
                int i10 = this.f9645e + 1;
                this.f9645e = i10;
                j10 = nextLong + i10;
            }
            return j10;
        }
        synchronized (this.f9644d) {
            this.f9644d.compareAndSet(-1L, 1L);
            andIncrement = this.f9644d.getAndIncrement();
        }
        return andIncrement;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SecureRandom y0() {
        e();
        if (this.f9643c == null) {
            this.f9643c = new SecureRandom();
        }
        return this.f9643c;
    }

    public final int z0() {
        if (this.f9646f == null) {
            this.f9646f = Integer.valueOf(com.google.android.gms.common.c.h().b(getContext()) / 1000);
        }
        return this.f9646f.intValue();
    }
}
