package sd;

import android.content.Context;
import com.bjleisen.bluetooth.DeviceInfo;
import com.bjleisen.bluetooth.IMultiBluetoothInterface;
import com.bjleisen.iface.sdk.bean.Capdu;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.common.base.WearPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mk.a;
import mk.b;
/* compiled from: MultiBluetoothCallback.java */
/* loaded from: classes2.dex */
public class d implements IMultiBluetoothInterface {

    /* renamed from: a  reason: collision with root package name */
    private Context f34409a;

    public d(Context context) {
        this.f34409a = context;
    }

    private List<Rapdu> a(qd.d dVar, List<Capdu> list) {
        ArrayList arrayList = new ArrayList();
        list.size();
        for (Capdu capdu : list) {
            byte[] b10 = b.b(capdu.getCpadu());
            k.c("MultiBluetoothCallback", "capdu index: %s, apdu %s, exp sw %s", Integer.valueOf(capdu.getIndex()), capdu.getCpadu(), Arrays.toString(capdu.getExpSw()));
            byte[] d10 = dVar.d(WearPath.TicPay.APDU, b10);
            k.c("MultiBluetoothCallback", "apdu response %s", b.a(d10));
            Rapdu rapdu = new Rapdu();
            rapdu.setIndex(capdu.getIndex());
            int length = d10.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(d10, 0, bArr, 0, length);
            rapdu.setRapdu(b.a(bArr));
            rapdu.setSw(b.a(new byte[]{d10[d10.length - 2], d10[d10.length - 1]}));
            arrayList.add(rapdu);
        }
        return arrayList;
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public void closeSEChannel() {
        b.h().c().g(WearPath.TicPay.CLOSE_SE, new byte[]{1});
        k.c("MultiBluetoothCallback", "closeSEChannel() called , Thread %s", Thread.currentThread());
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public int connectBluetoothDevice(DeviceInfo deviceInfo) {
        k.a("MultiBluetoothCallback", "connectBluetoothDevice() called with: deviceInfo = [" + deviceInfo.getDeviceName() + "]" + Thread.currentThread());
        return 0;
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public void disconnectBluetoothDevice() {
        k.a("MultiBluetoothCallback", "disconnectBluetoothDevice");
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public int getDeviceInfo(DeviceInfo deviceInfo) {
        byte[] d10 = b.h().c().d(WearPath.TicPay.DEVICE_INFO, new byte[]{1});
        if (d10 == null || d10.length == 0) {
            return 22;
        }
        String[] split = new String(d10).split(WearPath.TicPay.DIVIDER);
        k.c("MultiBluetoothCallback", "getDeviceInfo: %s", Arrays.toString(split));
        if (split.length != 5) {
            return 22;
        }
        deviceInfo.setDeviceId(split[0]);
        deviceInfo.setDeviceMac(split[1]);
        boolean a10 = q.a(this.f34409a, WearPath.TicPay.PAY, "bus_card_test_mode", false);
        if (TicwatchModels.CertModels.PRO3_BT.equalsIgnoreCase(split[2]) || "WH11014".equalsIgnoreCase(split[2])) {
            deviceInfo.setDeviceModel("WH11014");
        } else if (!a10 || !"TicWatch AW".equalsIgnoreCase(split[2])) {
            deviceInfo.setDeviceModel(split[2]);
        } else {
            deviceInfo.setDeviceModel(TicwatchModels.CertModels.PRO_BT_OLD);
        }
        deviceInfo.setDeviceName(split[3]);
        deviceInfo.setDeviceBaseVersion(split[4]);
        b.h().t(split[2]);
        return 0;
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public boolean queryBluetoothState() {
        return b.h().c().isConnected();
    }

    @Override // com.bjleisen.bluetooth.IMultiBluetoothInterface
    public List<Rapdu> transiveAPDU(List<Capdu> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        qd.d c10 = b.h().c();
        if (!c10.i()) {
            return a(c10, list);
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (Capdu capdu : list) {
            arrayList.add(capdu.getCpadu());
            arrayList2.add(c.h(capdu.getExpSw()));
            k.c("MultiBluetoothCallback", "capdu index: %s, apdu %s, exp sw %s", Integer.valueOf(capdu.getIndex()), capdu.getCpadu(), Arrays.toString(capdu.getExpSw()));
        }
        byte[] d10 = c10.d(WearPath.TicPay.APDUS, a.b(arrayList, arrayList2));
        k.c("MultiBluetoothCallback", "apdu response %s", b.a(d10));
        List<String> a10 = a.a(d10);
        ArrayList arrayList3 = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= a10.size()) {
                break;
            }
            Capdu capdu2 = list.get(i11);
            String str = a10.get(i10 + 1);
            Rapdu rapdu = new Rapdu();
            rapdu.setIndex(capdu2.getIndex());
            String str2 = a10.get(i10);
            rapdu.setRapdu(str2);
            rapdu.setSw(str);
            arrayList3.add(rapdu);
            k.c("MultiBluetoothCallback", "capdu index: %s, rapdu apdu %s, exp sw %s", Integer.valueOf(capdu2.getIndex()), str2, str);
            if (!c.m(capdu2.getExpSw(), str)) {
                k.s("MultiBluetoothCallback", "sw error: capdu index: %s, rapdu sw %s, exp sw %s", Integer.valueOf(capdu2.getIndex()), str, Arrays.toString(capdu2.getExpSw()));
                break;
            }
            i10 += 2;
            i11++;
        }
        return arrayList3;
    }
}
