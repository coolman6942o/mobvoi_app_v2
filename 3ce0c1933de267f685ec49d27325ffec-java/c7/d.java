package c7;

import b6.i;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.internal.zzay;
/* loaded from: classes.dex */
public final class d extends ChannelClient {
    /* JADX INFO: Access modifiers changed from: private */
    public static zzay p(Channel channel) {
        i.l(channel, "channel must not be null");
        return (zzay) channel;
    }
}
