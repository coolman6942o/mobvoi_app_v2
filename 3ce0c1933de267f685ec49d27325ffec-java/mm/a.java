package mm;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.text.TextUtils;
import cm.d;
import com.mobvoi.wear.util.LogCleaner;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.util.HashMap;
import java.util.List;
import ul.c;
import xl.b;
/* loaded from: classes2.dex */
public abstract class a extends xl.a {

    /* renamed from: j0  reason: collision with root package name */
    public UsbManager f30843j0;

    public a(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
        x();
    }

    public UsbDevice J(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UsbManager usbManager = this.f30843j0;
        if (usbManager == null) {
            il.b.l("mUsbManager == null");
            return null;
        }
        HashMap<String, UsbDevice> deviceList = usbManager.getDeviceList();
        if (deviceList != null && deviceList.size() > 0) {
            return deviceList.get(str);
        }
        il.b.c("no usb device exist");
        return null;
    }

    public void K() {
        synchronized (this.U) {
            if (this.T) {
                il.b.c("Remote busy now, just wait!");
                try {
                    this.U.wait(LogCleaner.ONE_MINUTE);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
                il.b.k(this.f36587a, "Remote idle now, just go!");
            }
        }
    }

    public void L() {
        int k10 = u().k();
        int l10 = u().l();
        if (l10 < 0 || l10 >= k10) {
            il.b.c("invalid FileIndex: " + l10 + ", reset to 0");
            l10 = 0;
        }
        u().z(l10);
        wl.a aVar = this.f36608v.get(l10);
        this.f36609w = aVar;
        if (aVar != null) {
            u().s(this.f36609w.w(), this.f36609w.O(), this.f36609w.T(), this.f36609w.k0(), t().Q());
        } else {
            il.b.l("mCurBinInputStream == null");
        }
        int i10 = l10 + 1;
        if (i10 < k10) {
            this.f36610x = this.f36608v.get(i10);
            this.f36611y = i10;
            return;
        }
        this.f36610x = null;
        this.f36611y = -1;
    }

    public void M() {
        m(this.f36609w);
        List<wl.a> r10 = ul.b.r(new c.b().f(t().y()).e(t().i()).h(this.G).i(t().k()).o(this.f36589c).g(this.H).k(v()).j(t().N()).l(t().P()).n(t().R(), t().D()).c());
        this.f36608v = r10;
        if (r10 == null || r10.size() <= 0) {
            il.b.l("pendingImageInputStreams == null || pendingImageInputStreams.size() <= 0");
            throw new OtaException("load image file error", 4097);
        }
        if (u().l() == 0) {
            int[] iArr = new int[this.f36608v.size()];
        }
        u().B(this.f36608v.size());
        il.b.j(u().toString());
        L();
    }

    @Override // xl.a
    public void x() {
        super.x();
        this.M = new d(this.f36590d, 2);
        if (this.f30843j0 == null) {
            UsbManager usbManager = (UsbManager) this.f36589c.getSystemService("usb");
            this.f30843j0 = usbManager;
            if (usbManager == null) {
                il.b.l("Unable to initialize mUsbManager.");
            }
        }
    }

    @Override // xl.a
    public int y() {
        int y10 = super.y();
        if (y10 != 0) {
            return y10;
        }
        if (!TextUtils.isEmpty(this.F)) {
            return 0;
        }
        if (this.f36587a) {
            il.b.l("invalid address: " + this.F);
            return 4112;
        }
        il.b.l("invalid address: ");
        return 4112;
    }
}
