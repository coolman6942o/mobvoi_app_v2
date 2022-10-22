package com.unionpay.mobile.android.pboctransaction.sdapdu;

import android.content.Context;
import android.util.Log;
import com.unionpay.mobile.android.pboctransaction.AppIdentification;
import com.unionpay.mobile.android.pboctransaction.b;
import com.unionpay.mobile.android.pboctransaction.c;
import com.unionpay.mobile.android.pboctransaction.d;
import com.unionpay.mobile.android.pboctransaction.e;
import com.unionpay.mobile.android.utils.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class a implements c {

    /* renamed from: b  reason: collision with root package name */
    private Context f23839b = null;

    /* renamed from: a  reason: collision with root package name */
    NativeSDWriter f23838a = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23840c = false;

    private static ArrayList<com.unionpay.mobile.android.model.c> b(d dVar) {
        String a10;
        String str;
        String str2;
        if (dVar.a() == null) {
            str2 = " select UPCard failed!!!!";
        } else {
            String c10 = dVar.c();
            if (c10 == null) {
                str2 = " getBankCardFileEntry failed!!!!";
            } else {
                byte[] a11 = e.a(c10);
                int i10 = ((a11[0] & 255) << 24) | ((a11[1] & 255) << 16);
                int i11 = Integer.MIN_VALUE;
                int i12 = 0;
                for (int i13 = 0; i13 < 10; i13++) {
                    if ((i11 & i10) == 0) {
                        i12++;
                    }
                    i11 >>>= 1;
                }
                if (i12 <= 0) {
                    return null;
                }
                ArrayList<com.unionpay.mobile.android.model.c> arrayList = new ArrayList<>(i12);
                int i14 = 1;
                int i15 = Integer.MIN_VALUE;
                while (i14 <= i12 && i14 < 11) {
                    if ((i10 & i15) == 0 && (a10 = dVar.a(i14, com.unionpay.mobile.android.utils.c.a())) != null && a10.length() > 0) {
                        String d10 = e.d(a10.substring(0, 40));
                        try {
                            str = new String(e.a(d10), "gbk");
                        } catch (UnsupportedEncodingException e10) {
                            e10.printStackTrace();
                            str = d10;
                        }
                        String substring = a10.substring(40, 60);
                        arrayList.add(new com.unionpay.mobile.android.model.a(8, Integer.toString(i14), str, e.c(substring), 2));
                        k.c("uppay", i14 + "----" + substring);
                    }
                    i14++;
                    i15 >>>= 1;
                }
                return arrayList;
            }
        }
        Log.e("uppay", str2);
        return null;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final String a(String str) {
        return "";
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final ArrayList<com.unionpay.mobile.android.model.c> a(d dVar) {
        k.c("uppay", "SDEngine.readList() +++");
        ArrayList arrayList = null;
        if (!this.f23840c) {
            return null;
        }
        ArrayList<com.unionpay.mobile.android.model.c> arrayList2 = new ArrayList<>();
        String a10 = dVar.a(new AppIdentification("A0000003330101", "1.0"));
        if (a10 != null && a10.length() > 0) {
            arrayList = new ArrayList(1);
            arrayList.add(new com.unionpay.mobile.android.model.a(8, "A0000003330101", "", e.c(a10), 1));
            k.c("uppay", "A0000003330101----" + a10);
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.addAll(arrayList);
        }
        ArrayList<com.unionpay.mobile.android.model.c> b10 = b(dVar);
        if (b10 != null && b10.size() > 0) {
            arrayList2.addAll(b10);
        }
        k.c("uppay", "SDEngine.readList() ---");
        return arrayList2;
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a() {
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void a(b bVar, Context context) {
        this.f23839b = context;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final byte[] a(byte[] bArr, int i10) {
        NativeSDWriter nativeSDWriter = this.f23838a;
        return e.a(nativeSDWriter != null ? nativeSDWriter.a(e.a(bArr)) : "");
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void b() {
        this.f23838a = new NativeSDWriter();
        b.a();
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : b.f23841a) {
            arrayList.add(str);
        }
        this.f23840c = this.f23838a.a(arrayList);
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void c() {
        NativeSDWriter nativeSDWriter = this.f23838a;
        if (nativeSDWriter != null) {
            nativeSDWriter.a();
        }
    }

    @Override // com.unionpay.mobile.android.pboctransaction.c
    public final void d() {
    }
}
