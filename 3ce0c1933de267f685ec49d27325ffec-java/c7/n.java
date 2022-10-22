package c7;

import a6.d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.g;
/* loaded from: classes.dex */
public final class n extends d implements g {
    public n(DataHolder dataHolder, int i10) {
        super(dataHolder, i10);
    }

    @Override // com.google.android.gms.wearable.g
    public final String getId() {
        return c("asset_id");
    }

    @Override // com.google.android.gms.wearable.g
    public final String i() {
        return c("asset_key");
    }
}
