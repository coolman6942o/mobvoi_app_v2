package tb;

import android.content.Context;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.companion.WearableModule;
import com.mobvoi.companion.health.a4;
import com.mobvoi.companion.health.k1;
import com.mobvoi.companion.health.z3;
import com.mobvoi.companion.wear.WearNode;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.health.companion.system.WearDevices;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.CapabilityHelper;
import com.mobvoi.wear.info.WearInfo;
import com.mobvoi.wear.util.UnitsUtility;
import java.util.ArrayList;
import java.util.List;
import od.d;
/* compiled from: ITicWatchManager.java */
/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected Context f35107a;

    /* compiled from: ITicWatchManager.java */
    /* loaded from: classes2.dex */
    class a implements AccountManager.f {
        a(c cVar) {
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.f
        public void onCancel() {
        }

        @Override // com.mobvoi.assistant.account.data.AccountManager.f
        public void onEvent(AccountManager.AccountChangeEvent accountChangeEvent, AccountManager.h hVar) {
            if (accountChangeEvent == AccountManager.AccountChangeEvent.OnLogin || accountChangeEvent == AccountManager.AccountChangeEvent.OnLogout || accountChangeEvent == AccountManager.AccountChangeEvent.OnForceLogout) {
                fd.a.c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(z3 z3Var) {
        for (WearNode wearNode : WearPairingPool.i().g()) {
            WearInfo c10 = com.mobvoi.companion.wear.a.f().c(wearNode.nodeId);
            if (c10 != null) {
                List<String> parseCapabilities = CapabilityHelper.parseCapabilities(c10.wearCapability);
                if (TicwatchModels.isTicwatch(c10.wearType) && !TicwatchModels.isTicwatch1(c10.wearType)) {
                    String string = this.f35107a.getString(d.f31593w);
                    ArrayList arrayList = new ArrayList(parseCapabilities);
                    arrayList.add(string);
                    parseCapabilities = arrayList;
                }
                z3Var.b(WearDevices.DeviceType.Watch, wearNode.deviceId, c10.wearType, parseCapabilities);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean f(Context context) {
        return !com.mobvoi.companion.base.settings.a.isUnitMetric(context);
    }

    public void d(Context context) {
        WearableModule.init(context, WearableModule.WearableType.TicWatch);
        k1.a(new a4() { // from class: tb.a
            @Override // com.mobvoi.companion.health.a4
            public final void a(z3 z3Var) {
                c.this.c(z3Var);
            }
        });
        xd.c.x().B();
        fd.a.c();
        AccountManager.h().c(new a(this));
        UnitsUtility.setImperialGetter(b.f35106a);
    }

    public void e(Context context) {
        this.f35107a = context;
    }

    public void g() {
        WearableModule.finish();
    }
}
