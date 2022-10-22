package c;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class c extends c.a<Intent, ActivityResult> {

    /* compiled from: ActivityResultContracts.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    /* renamed from: d */
    public Intent a(Context context, Intent input) {
        i.f(context, "context");
        i.f(input, "input");
        return input;
    }

    /* renamed from: e */
    public ActivityResult c(int i10, Intent intent) {
        return new ActivityResult(i10, intent);
    }
}
