package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.navigation.t;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* compiled from: ActivityNavigator.java */
@t.b("activity")
/* loaded from: classes.dex */
public class b extends t<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f3431a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f3432b;

    /* compiled from: ActivityNavigator.java */
    /* loaded from: classes.dex */
    public static class a extends k {

        /* renamed from: i  reason: collision with root package name */
        private Intent f3433i;

        /* renamed from: j  reason: collision with root package name */
        private String f3434j;

        public a(t<? extends a> tVar) {
            super(tVar);
        }

        public final a A(ComponentName componentName) {
            if (this.f3433i == null) {
                this.f3433i = new Intent();
            }
            this.f3433i.setComponent(componentName);
            return this;
        }

        public final a B(Uri uri) {
            if (this.f3433i == null) {
                this.f3433i = new Intent();
            }
            this.f3433i.setData(uri);
            return this;
        }

        public final a C(String str) {
            this.f3434j = str;
            return this;
        }

        public final a D(String str) {
            if (this.f3433i == null) {
                this.f3433i = new Intent();
            }
            this.f3433i.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.k
        public void n(Context context, AttributeSet attributeSet) {
            super.n(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, w.f3565a);
            String string = obtainAttributes.getString(w.f3570f);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            D(string);
            String string2 = obtainAttributes.getString(w.f3566b);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                A(new ComponentName(context, string2));
            }
            z(obtainAttributes.getString(w.f3567c));
            String string3 = obtainAttributes.getString(w.f3568d);
            if (string3 != null) {
                B(Uri.parse(string3));
            }
            C(obtainAttributes.getString(w.f3569e));
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.k
        boolean s() {
            return false;
        }

        public final String t() {
            Intent intent = this.f3433i;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @Override // androidx.navigation.k
        public String toString() {
            ComponentName u10 = u();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            if (u10 != null) {
                sb2.append(" class=");
                sb2.append(u10.getClassName());
            } else {
                String t10 = t();
                if (t10 != null) {
                    sb2.append(" action=");
                    sb2.append(t10);
                }
            }
            return sb2.toString();
        }

        public final ComponentName u() {
            Intent intent = this.f3433i;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String w() {
            return this.f3434j;
        }

        public final Intent y() {
            return this.f3433i;
        }

        public final a z(String str) {
            if (this.f3433i == null) {
                this.f3433i = new Intent();
            }
            this.f3433i.setAction(str);
            return this;
        }
    }

    /* compiled from: ActivityNavigator.java */
    /* renamed from: androidx.navigation.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0038b implements t.a {

        /* renamed from: a  reason: collision with root package name */
        private final int f3435a;

        /* renamed from: b  reason: collision with root package name */
        private final androidx.core.app.b f3436b;

        public androidx.core.app.b a() {
            return this.f3436b;
        }

        public int b() {
            return this.f3435a;
        }
    }

    public b(Context context) {
        this.f3431a = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f3432b = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Override // androidx.navigation.t
    public boolean e() {
        Activity activity = this.f3432b;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    /* renamed from: f */
    public a a() {
        return new a(this);
    }

    final Context g() {
        return this.f3431a;
    }

    /* renamed from: h */
    public k b(a aVar, Bundle bundle, q qVar, t.a aVar2) {
        Intent intent;
        int intExtra;
        if (aVar.y() != null) {
            Intent intent2 = new Intent(aVar.y());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String w10 = aVar.w();
                if (!TextUtils.isEmpty(w10)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(w10);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + w10);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z10 = aVar2 instanceof C0038b;
            if (z10) {
                intent2.addFlags(((C0038b) aVar2).b());
            }
            if (!(this.f3431a instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (qVar != null && qVar.g()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.f3432b;
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", aVar.i());
            Resources resources = g().getResources();
            if (qVar != null) {
                int c10 = qVar.c();
                int d10 = qVar.d();
                if ((c10 <= 0 || !resources.getResourceTypeName(c10).equals("animator")) && (d10 <= 0 || !resources.getResourceTypeName(d10).equals("animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", c10);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", d10);
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(c10) + " and popExit resource " + resources.getResourceName(d10) + "when launching " + aVar);
                }
            }
            if (z10) {
                androidx.core.app.b a10 = ((C0038b) aVar2).a();
                if (a10 != null) {
                    androidx.core.content.b.m(this.f3431a, intent2, a10.b());
                } else {
                    this.f3431a.startActivity(intent2);
                }
            } else {
                this.f3431a.startActivity(intent2);
            }
            if (qVar == null || this.f3432b == null) {
                return null;
            }
            int a11 = qVar.a();
            int b10 = qVar.b();
            if ((a11 > 0 && resources.getResourceTypeName(a11).equals("animator")) || (b10 > 0 && resources.getResourceTypeName(b10).equals("animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(a11) + " and exit resource " + resources.getResourceName(b10) + "when launching " + aVar);
                return null;
            } else if (a11 < 0 && b10 < 0) {
                return null;
            } else {
                this.f3432b.overridePendingTransition(Math.max(a11, 0), Math.max(b10, 0));
                return null;
            }
        } else {
            throw new IllegalStateException("Destination " + aVar.i() + " does not have an Intent set.");
        }
    }
}
