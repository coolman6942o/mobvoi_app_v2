package ub;

import android.app.Application;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.mobvoi.companion.wear.WearNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* compiled from: TicWatchNewDeviceManager.java */
/* loaded from: classes2.dex */
public abstract class f extends e {
    public f(Application application) {
        super(application);
    }

    @Override // qk.a
    public Bundle a() {
        return null;
    }

    @Override // qk.a
    public Class<?> c() {
        if (e()) {
            return j();
        }
        return null;
    }

    protected abstract Class j();

    public Map<Bundle, Class<? extends Fragment>> k() {
        List<WearNode> g10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (e() && (g10 = g()) != null && g10.size() > 0) {
            for (WearNode wearNode : g10) {
                Class j10 = j();
                Bundle bundle = new Bundle();
                bundle.putParcelable("wear_node", wearNode);
                bundle.putString("wear_node_id", wearNode.nodeId);
                linkedHashMap.put(bundle, j10);
            }
        }
        return linkedHashMap;
    }
}
