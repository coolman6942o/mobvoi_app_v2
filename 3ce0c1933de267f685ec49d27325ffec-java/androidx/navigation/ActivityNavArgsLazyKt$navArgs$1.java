package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.jvm.internal.Lambda;
import qo.a;
/* compiled from: ActivityNavArgsLazy.kt */
/* loaded from: classes.dex */
public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements a<Bundle> {
    final /* synthetic */ Activity $this_navArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityNavArgsLazyKt$navArgs$1(Activity activity) {
        super(0);
        this.$this_navArgs = activity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final Bundle invoke() {
        Intent intent = this.$this_navArgs.getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                return extras;
            }
            throw new IllegalStateException("Activity " + this.$this_navArgs + " has null extras in " + intent);
        }
        throw new IllegalStateException("Activity " + this.$this_navArgs + " has a null Intent");
    }
}
