package com.google.android.gms.wearable;

import android.os.Parcelable;
import com.google.android.gms.common.api.c;
import com.google.android.gms.wearable.l;
/* loaded from: classes.dex */
public abstract class ChannelClient extends c<l.a> {

    /* loaded from: classes.dex */
    public interface Channel extends Parcelable {
    }

    /* loaded from: classes.dex */
    public static abstract class a {
        public void a(Channel channel, int i10, int i11) {
            throw null;
        }

        public void b(Channel channel) {
            throw null;
        }

        public void c(Channel channel, int i10, int i11) {
            throw null;
        }

        public void d(Channel channel, int i10, int i11) {
            throw null;
        }
    }
}
