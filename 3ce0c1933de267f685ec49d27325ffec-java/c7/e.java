package c7;

import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.internal.zzay;
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    private final ChannelClient.a f5585a;

    public e(ChannelClient.a aVar) {
        this.f5585a = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        return this.f5585a.equals(((e) obj).f5585a);
    }

    public final int hashCode() {
        return this.f5585a.hashCode();
    }

    @Override // com.google.android.gms.wearable.c
    public final void onChannelClosed(Channel channel, int i10, int i11) {
        zzay p10;
        ChannelClient.a aVar = this.f5585a;
        p10 = d.p(channel);
        aVar.a(p10, i10, i11);
    }

    @Override // com.google.android.gms.wearable.c
    public final void onChannelOpened(Channel channel) {
        zzay p10;
        ChannelClient.a aVar = this.f5585a;
        p10 = d.p(channel);
        aVar.b(p10);
    }

    @Override // com.google.android.gms.wearable.c
    public final void onInputClosed(Channel channel, int i10, int i11) {
        zzay p10;
        ChannelClient.a aVar = this.f5585a;
        p10 = d.p(channel);
        aVar.c(p10, i10, i11);
    }

    @Override // com.google.android.gms.wearable.c
    public final void onOutputClosed(Channel channel, int i10, int i11) {
        zzay p10;
        ChannelClient.a aVar = this.f5585a;
        p10 = d.p(channel);
        aVar.d(p10, i10, i11);
    }
}
