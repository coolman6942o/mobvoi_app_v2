package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.b;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class r implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f2420a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f2421b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent getSupportParentActivityIntent();
    }

    private r(Context context) {
        this.f2421b = context;
    }

    public static r e(Context context) {
        return new r(context);
    }

    public r a(Intent intent) {
        this.f2420a.add(intent);
        return this;
    }

    public r b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f2421b.getPackageManager());
        }
        if (component != null) {
            d(component);
        }
        a(intent);
        return this;
    }

    public r c(Activity activity) {
        Intent supportParentActivityIntent = activity instanceof a ? ((a) activity).getSupportParentActivityIntent() : null;
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = h.a(activity);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(this.f2421b.getPackageManager());
            }
            d(component);
            a(supportParentActivityIntent);
        }
        return this;
    }

    public r d(ComponentName componentName) {
        int size = this.f2420a.size();
        try {
            Intent b10 = h.b(this.f2421b, componentName);
            while (b10 != null) {
                this.f2420a.add(size, b10);
                b10 = h.b(this.f2421b, b10.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e10);
        }
    }

    public Intent f(int i10) {
        return this.f2420a.get(i10);
    }

    public int g() {
        return this.f2420a.size();
    }

    public void h() {
        i(null);
    }

    public void i(Bundle bundle) {
        if (!this.f2420a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f2420a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!b.l(this.f2421b, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f2421b.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f2420a.iterator();
    }
}
