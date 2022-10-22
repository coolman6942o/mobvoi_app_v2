package dl;

import android.bluetooth.BluetoothGatt;
import il.b;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<Integer, String> f25663a;

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Integer, String> f25664b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<Integer, String> f25665c;

    static {
        HashMap<Integer, String> hashMap = new HashMap<>();
        f25663a = hashMap;
        hashMap.put(0, "UNKNOW");
        f25663a.put(1, "READ");
        f25663a.put(2, "READ_ENCRYPTED");
        f25663a.put(4, "READ_ENCRYPTED_MITM");
        f25663a.put(16, "WRITE");
        f25663a.put(32, "WRITE_ENCRYPTED");
        f25663a.put(64, "WRITE_ENCRYPTED_MITM");
        f25663a.put(128, "WRITE_SIGNED");
        f25663a.put(256, "WRITE_SIGNED_MITM");
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        f25664b = hashMap2;
        hashMap2.put(1, "BROADCAST");
        f25664b.put(128, "EXTENDED_PROPS");
        f25664b.put(32, "INDICATE");
        f25664b.put(16, "NOTIFY");
        f25664b.put(2, "READ");
        f25664b.put(64, "SIGNED_WRITE");
        f25664b.put(8, "WRITE");
        f25664b.put(4, "WRITE_NO_RESPONSE");
        HashMap<Integer, String> hashMap3 = new HashMap<>();
        f25665c = hashMap3;
        hashMap3.put(0, "UNKNOW");
        f25665c.put(1, "READ");
        f25665c.put(2, "READ_ENCRYPTED");
        f25665c.put(4, "READ_ENCRYPTED_MITM");
        f25665c.put(16, "WRITE");
        f25665c.put(32, "WRITE_ENCRYPTED");
        f25665c.put(64, "WRITE_ENCRYPTED_MITM");
        f25665c.put(128, "WRITE_SIGNED");
        f25665c.put(256, "WRITE_SIGNED_MITM");
    }

    public static List<String> a(int i10) {
        ArrayList arrayList = new ArrayList();
        if ((i10 & 1) == 1) {
            arrayList.add("BROADCAST");
        }
        if ((i10 & 2) == 2) {
            arrayList.add("READ");
        }
        if ((i10 & 4) == 4) {
            arrayList.add("WRITE_NO_RESPONSE");
        }
        if ((i10 & 8) == 8) {
            arrayList.add("WRITE");
        }
        return arrayList;
    }

    public static String b(int i10) {
        StringBuilder sb2 = new StringBuilder();
        List<String> a10 = a(i10);
        if (a10 != null && a10.size() > 0) {
            for (String str : a10) {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static boolean c(BluetoothGatt bluetoothGatt) {
        try {
            Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
            if (method != null) {
                return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
            }
        } catch (Exception e10) {
            b.l("refreshing device failed: " + e10.toString());
        }
        return false;
    }
}
