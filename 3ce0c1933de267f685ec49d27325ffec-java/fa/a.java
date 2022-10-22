package fa;

import com.mobvoi.android.common.utils.k;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.h;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import kotlin.text.t;
import kotlin.text.u;
/* compiled from: AgpsNetUtil.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26369a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static String f26370b;

    /* renamed from: c  reason: collision with root package name */
    private static Integer f26371c;

    private a() {
    }

    private final byte[] a(String str) {
        k.a("AgpsNetUtil", i.n("AGPS params: ", str));
        String str2 = f26370b;
        i.d(str2);
        Integer num = f26371c;
        i.d(num);
        Socket socket = new Socket(str2, num.intValue());
        socket.setSoTimeout(8000);
        OutputStream outputStream = socket.getOutputStream();
        Charset charset = d.f30092a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes);
        outputStream.flush();
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(7000);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                outputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                i.e(byteArray, "byteArrayBuffer.toByteArray()");
                return byteArray;
            }
        }
    }

    public final byte[] b(String params) {
        List o02;
        List W;
        Object obj;
        Object obj2;
        String K;
        boolean D;
        boolean D2;
        boolean D3;
        i.f(params, "params");
        k.a("AgpsNetUtil", i.n("params: ", params));
        o02 = u.o0(params, new String[]{";"}, false, 0, 6, null);
        W = kotlin.collections.u.W(o02);
        Iterator it = W.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            D3 = t.D((String) obj, "domain", false, 2, null);
            if (D3) {
                break;
            }
        }
        String str = (String) obj;
        if (str != null) {
            W.remove(str);
            String substring = str.substring(7);
            i.e(substring, "(this as java.lang.String).substring(startIndex)");
            f26370b = substring;
        }
        Iterator it2 = W.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            D2 = t.D((String) obj2, "port", false, 2, null);
            if (D2) {
                break;
            }
        }
        String str2 = (String) obj2;
        if (str2 != null) {
            W.remove(str2);
            String substring2 = str2.substring(5);
            i.e(substring2, "(this as java.lang.String).substring(startIndex)");
            f26371c = Integer.valueOf(Integer.parseInt(substring2));
        }
        if (f26370b == null || f26371c == null) {
            return new byte[]{2};
        }
        try {
            K = kotlin.collections.u.K(W, ";", null, null, 0, null, null, 62, null);
            byte[] a10 = a(K);
            int i10 = 60;
            if (a10.length < 60) {
                i10 = a10.length;
            }
            byte[] copyOf = Arrays.copyOf(a10, i10);
            i.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            String str3 = new String(copyOf, d.f30092a);
            k.a("AgpsNetUtil", i.n("AGPS response head: ", str3));
            byte[] bArr = new byte[a10.length + 1];
            D = t.D(str3, "AGNSS data from CASIC.", false, 2, null);
            if (D) {
                bArr[0] = 0;
            } else {
                bArr[0] = 1;
            }
            h.e(a10, bArr, 1, 0, 0, 12, null);
            return bArr;
        } catch (Exception e10) {
            e10.printStackTrace();
            return new byte[]{-1};
        }
    }
}
