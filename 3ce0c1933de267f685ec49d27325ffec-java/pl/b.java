package pl;

import android.content.Context;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import ql.a;
import ul.c;
/* loaded from: classes2.dex */
public class b extends BufferedInputStream {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f32871f = wk.b.f36300c;

    /* renamed from: a  reason: collision with root package name */
    public int f32872a;

    /* renamed from: b  reason: collision with root package name */
    public int f32873b;

    /* renamed from: c  reason: collision with root package name */
    public int f32874c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<a> f32875d;

    /* renamed from: e  reason: collision with root package name */
    public String f32876e;

    public b(String str, InputStream inputStream) {
        super(inputStream);
        if (available() >= 12) {
            this.f32876e = str;
            return;
        }
        throw new IOException("The input file size is less to 12, please check!");
    }

    public static b d(c cVar) {
        InputStream inputStream;
        b bVar = null;
        if (cVar == null) {
            return null;
        }
        if (cVar.c() == 1) {
            Context a10 = cVar.a();
            if (a10 == null) {
                il.b.c("please set the context first.");
                return null;
            }
            try {
                inputStream = a10.getAssets().open(cVar.d());
            } catch (IOException e10) {
                il.b.l(e10.toString());
                return null;
            }
        } else {
            try {
                inputStream = new BufferedInputStream(new FileInputStream(cVar.d()));
            } catch (FileNotFoundException e11) {
                il.b.l(e11.toString());
                inputStream = null;
            }
        }
        if (inputStream == null) {
            return null;
        }
        try {
            b bVar2 = new b(cVar.d(), inputStream);
            if (!bVar2.h()) {
                bVar2.close();
            } else {
                bVar = bVar2;
            }
            try {
                inputStream.close();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return bVar;
        } catch (IOException e13) {
            il.b.j(e13.toString());
            return null;
        }
    }

    public static a i(c cVar) {
        a aVar;
        Context a10 = cVar.a();
        String d10 = cVar.d();
        b d11 = d(cVar);
        if (d11 == null) {
            il.b.k(f32871f, "multiPackManager == null");
            try {
                aVar = a.d(a10, d10, a10.getAssets().open(d10), 0L);
                if (aVar != null) {
                    if (!aVar.I()) {
                        il.b.l("pack for MP can not be OTA");
                        throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
                    } else if (!cVar.r()) {
                        il.b.l("not support pack file.");
                        throw new LoadFileException("not support pack file.", 4107);
                    }
                } else if (!cVar.t()) {
                    il.b.l("not support single file.");
                    throw new LoadFileException("not support single file.", LoadFileException.ERROR_SINGLE_NOT_SUPPORT);
                }
            } catch (IOException e10) {
                il.b.l(e10.toString());
                return null;
            }
        } else if (cVar.n()) {
            int g10 = cVar.g();
            il.b.j(d11.toString());
            a c10 = d11.c(g10);
            if (c10 != null) {
                il.b.j(c10.toString());
                aVar = a.d(a10, d10, c10.b(a10), c10.f());
                if (aVar == null) {
                    il.b.l("sub combined file must be a pack file, preferredBudRole=" + g10);
                    throw new LoadFileException("sub combined file must be a pack file.", LoadFileException.ERROR_COMBINE_PACK_SUB_FILE_INVALID);
                } else if (!aVar.I()) {
                    il.b.l("pack for MP can not be OTA");
                    throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
                }
            } else {
                il.b.l("no bud item exist, preferredBudRole=" + g10);
                throw new LoadFileException("no combine bud item exist.", LoadFileException.ERROR_COMBINE_PACK_MISSING_BUD);
            }
        } else {
            il.b.l("not support combine pack file.");
            throw new LoadFileException("not support combine pack file.", 4103);
        }
        return aVar;
    }

    public static a n(c cVar) {
        a aVar;
        cVar.f();
        String d10 = cVar.d();
        b d11 = d(cVar);
        if (d11 == null) {
            il.b.k(f32871f, "multiPackManager == null");
            aVar = a.h(d10);
            if (aVar == null) {
                if (!cVar.t()) {
                    il.b.l("not support single file.");
                    throw new LoadFileException("not support single file.", LoadFileException.ERROR_SINGLE_NOT_SUPPORT);
                }
                return aVar;
            } else if (!aVar.I()) {
                il.b.l("pack for MP can not be OTA");
                throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
            } else if (!cVar.r()) {
                il.b.l("not support pack file.");
                throw new LoadFileException("not support pack file.", 4107);
            }
        } else if (cVar.n()) {
            int g10 = cVar.g();
            il.b.k(f32871f, d11.toString());
            a c10 = d11.c(g10);
            if (c10 != null) {
                il.b.k(f32871f, c10.toString());
                aVar = a.i(d10, c10.f(), c10.d());
                if (aVar == null) {
                    il.b.l("sub combined file must be a pack file, preferredBudRole=" + g10);
                    throw new LoadFileException("sub combined file must be a pack file.", LoadFileException.ERROR_COMBINE_PACK_SUB_FILE_INVALID);
                } else if (!aVar.I()) {
                    il.b.l("pack for MP can not be OTA");
                    throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
                }
            } else {
                il.b.l("no bud item exist, preferredBudRole=" + g10);
                throw new LoadFileException("no combine bud item exist.", LoadFileException.ERROR_COMBINE_PACK_MISSING_BUD);
            }
        } else {
            il.b.l("not support combine pack file.");
            throw new LoadFileException("not support combine pack file.", 4103);
        }
        il.b.k(f32871f, aVar.toString());
        return aVar;
    }

    public a c(int i10) {
        ArrayList<a> arrayList = this.f32875d;
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        Iterator<a> it = this.f32875d.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.a() == i10) {
                return next;
            }
        }
        return null;
    }

    public final boolean h() {
        byte[] bArr = new byte[12];
        read(bArr, 0, 12);
        int i10 = ((bArr[3] << 24) & (-16777216)) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255);
        this.f32872a = i10;
        if (i10 != -1768442424) {
            il.b.k(f32871f, String.format("invalid multi-pack signature(0x%08X) ", Integer.valueOf(i10)));
            return false;
        }
        this.f32873b = ((bArr[7] << 24) & (-16777216)) | ((bArr[6] << 16) & 16711680) | ((bArr[5] << 8) & 65280) | (bArr[4] & 255);
        this.f32874c = (bArr[8] & 255) | ((bArr[11] << 24) & (-16777216)) | ((bArr[10] << 16) & 16711680) | ((bArr[9] << 8) & 65280);
        this.f32875d = new ArrayList<>();
        int i11 = (this.f32874c * 8) + 12;
        byte[] bArr2 = new byte[8];
        for (int i12 = 0; i12 < this.f32874c; i12++) {
            read(bArr2, 0, 8);
            a c10 = a.c(this.f32876e, i11, bArr2);
            this.f32875d.add(c10);
            i11 += c10.e();
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Multi-pack: signature=" + String.format("0x%04X", Integer.valueOf(this.f32872a)) + ", version=" + String.format(Locale.US, "0x%08x(%d)", Integer.valueOf(this.f32873b), Integer.valueOf(this.f32873b)) + ", num=" + String.format("0x%04x", Integer.valueOf(this.f32874c)));
        ArrayList<a> arrayList = this.f32875d;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<a> it = this.f32875d.iterator();
            while (it.hasNext()) {
                sb2.append("\n" + it.next().toString());
            }
        }
        return sb2.toString();
    }
}
