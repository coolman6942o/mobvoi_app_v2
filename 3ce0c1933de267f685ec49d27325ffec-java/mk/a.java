package mk;

import com.laser.tsm.sdk.AppConfig;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ApduUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f30836a = {-112, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f30837b = {0, 0};

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f30838c = "NFC_DISABLED".getBytes();

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f30839d = "SE_NOT_INIT".getBytes();

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f30840e = b.b("00A4040000");

    static {
        b.b("A000000151000000");
        b.b(AppConfig.APDU_SELECT_CRS);
        b.b("4F9F70");
        b.b("a00000015143525300");
    }

    public static List<String> a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new ArrayList();
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        short s10 = wrap.getShort();
        ArrayList arrayList = new ArrayList(s10 * 2);
        for (int i10 = 0; i10 < s10; i10++) {
            byte[] bArr2 = new byte[wrap.getShort() - 2];
            byte[] bArr3 = new byte[2];
            wrap.get(bArr2);
            arrayList.add(b.a(bArr2));
            wrap.get(bArr3);
            arrayList.add(b.a(bArr3));
        }
        return arrayList;
    }

    public static byte[] b(List<String> list, List<String> list2) {
        if (list.size() > list2.size()) {
            for (int i10 = 0; i10 < list.size() - list2.size(); i10++) {
                list2.add("9000");
            }
        } else if (list.size() < list2.size()) {
            for (int i11 = 0; i11 < list2.size() - list.size(); i11++) {
                list2.remove((list2.size() - 1) - i11);
            }
        }
        ArrayList arrayList = new ArrayList(list.size());
        int i12 = 2;
        for (String str : list) {
            byte[] b10 = b.b(str);
            arrayList.add(b10);
            i12 += b10.length + 2;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        for (String str2 : list2) {
            byte[] b11 = b.b(str2);
            arrayList2.add(b11);
            i12 += b11.length + 1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i12);
        allocate.putShort((short) list.size());
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            byte[] bArr = (byte[]) arrayList.get(i13);
            allocate.putShort((short) bArr.length);
            allocate.put(bArr);
            byte[] bArr2 = (byte[]) arrayList2.get(i13);
            allocate.put((byte) bArr2.length);
            allocate.put(bArr2);
        }
        return allocate.array();
    }

    public static boolean c(byte[] bArr, int i10, byte[] bArr2) {
        if (bArr2.length > bArr.length - i10) {
            return false;
        }
        for (int i11 = 0; i11 < bArr2.length; i11++) {
            if (bArr[i10 + i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(byte[] bArr, byte[] bArr2) {
        return c(bArr, 0, bArr2);
    }
}
