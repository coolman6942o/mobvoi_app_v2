package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.r;
import java.util.ArrayDeque;
import java.util.Iterator;
/* compiled from: NavDeepLinkBuilder.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f3501a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f3502b;

    /* renamed from: c  reason: collision with root package name */
    private m f3503c;

    /* renamed from: d  reason: collision with root package name */
    private int f3504d;

    public i(Context context) {
        this.f3501a = context;
        if (context instanceof Activity) {
            this.f3502b = new Intent(context, context.getClass());
        } else {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            this.f3502b = launchIntentForPackage == null ? new Intent() : launchIntentForPackage;
        }
        this.f3502b.addFlags(268468224);
    }

    private void b() {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(this.f3503c);
        k kVar = null;
        while (!arrayDeque.isEmpty() && kVar == null) {
            k kVar2 = (k) arrayDeque.poll();
            if (kVar2.i() == this.f3504d) {
                kVar = kVar2;
            } else if (kVar2 instanceof m) {
                Iterator<k> it = ((m) kVar2).iterator();
                while (it.hasNext()) {
                    arrayDeque.add(it.next());
                }
            }
        }
        if (kVar != null) {
            this.f3502b.putExtra("android-support-nav:controller:deepLinkIds", kVar.d());
            return;
        }
        String h10 = k.h(this.f3501a, this.f3504d);
        throw new IllegalArgumentException("Navigation destination " + h10 + " cannot be found in the navigation graph " + this.f3503c);
    }

    public r a() {
        if (this.f3502b.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
            r b10 = r.e(this.f3501a).b(new Intent(this.f3502b));
            for (int i10 = 0; i10 < b10.g(); i10++) {
                b10.f(i10).putExtra("android-support-nav:controller:deepLinkIntent", this.f3502b);
            }
            return b10;
        } else if (this.f3503c == null) {
            throw new IllegalStateException("You must call setGraph() before constructing the deep link");
        } else {
            throw new IllegalStateException("You must call setDestination() before constructing the deep link");
        }
    }

    public i c(Bundle bundle) {
        this.f3502b.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
        return this;
    }

    public i d(int i10) {
        this.f3504d = i10;
        if (this.f3503c != null) {
            b();
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(NavController navController) {
        this(navController.g());
        this.f3503c = navController.k();
    }
}
