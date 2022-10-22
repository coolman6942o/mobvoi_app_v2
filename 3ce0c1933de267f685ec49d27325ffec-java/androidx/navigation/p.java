package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.e;
import androidx.navigation.h;
import androidx.navigation.q;
import c1.a;
import com.mobvoi.wear.util.TelephonyUtil;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: NavInflater.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f3528c = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    private Context f3529a;

    /* renamed from: b  reason: collision with root package name */
    private u f3530b;

    public p(Context context, u uVar) {
        this.f3529a = context;
        this.f3530b = uVar;
    }

    private static r a(TypedValue typedValue, r rVar, r rVar2, String str, String str2) throws XmlPullParserException {
        if (rVar == null || rVar == rVar2) {
            return rVar != null ? rVar : rVar2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private k b(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i10) throws XmlPullParserException, IOException {
        int depth;
        k a10 = this.f3530b.e(xmlResourceParser.getName()).a();
        a10.n(this.f3529a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if ("argument".equals(name)) {
                    g(resources, a10, attributeSet, i10);
                } else if ("deepLink".equals(name)) {
                    h(resources, a10, attributeSet);
                } else if (TelephonyUtil.KEY_SIM_ACTION.equals(name)) {
                    d(resources, a10, attributeSet, xmlResourceParser, i10);
                } else if ("include".equals(name) && (a10 instanceof m)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, w.f3573i);
                    ((m) a10).t(c(obtainAttributes.getResourceId(w.f3574j, 0)));
                    obtainAttributes.recycle();
                } else if (a10 instanceof m) {
                    ((m) a10).t(b(resources, xmlResourceParser, attributeSet, i10));
                }
            }
        }
        return a10;
    }

    private void d(Resources resources, k kVar, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i10) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f5553a);
        int resourceId = obtainAttributes.getResourceId(a.f5554b, 0);
        d dVar = new d(obtainAttributes.getResourceId(a.f5555c, 0));
        q.a aVar = new q.a();
        aVar.d(obtainAttributes.getBoolean(a.f5558f, false));
        aVar.g(obtainAttributes.getResourceId(a.f5561i, -1), obtainAttributes.getBoolean(a.f5562j, false));
        aVar.b(obtainAttributes.getResourceId(a.f5556d, -1));
        aVar.c(obtainAttributes.getResourceId(a.f5557e, -1));
        aVar.e(obtainAttributes.getResourceId(a.f5559g, -1));
        aVar.f(obtainAttributes.getResourceId(a.f5560h, -1));
        dVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && "argument".equals(xmlResourceParser.getName())) {
                f(resources, bundle, attributeSet, i10);
            }
        }
        if (!bundle.isEmpty()) {
            dVar.d(bundle);
        }
        kVar.o(resourceId, dVar);
        obtainAttributes.recycle();
    }

    private e e(TypedArray typedArray, Resources resources, int i10) throws XmlPullParserException {
        e.a aVar = new e.a();
        boolean z10 = false;
        aVar.c(typedArray.getBoolean(a.f5567o, false));
        ThreadLocal<TypedValue> threadLocal = f3528c;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(a.f5566n);
        Object obj = null;
        r<Integer> a10 = string != null ? r.a(string, resources.getResourcePackageName(i10)) : null;
        int i11 = a.f5565m;
        if (typedArray.getValue(i11, typedValue)) {
            r<Integer> rVar = r.f3546c;
            if (a10 == rVar) {
                int i12 = typedValue.resourceId;
                if (i12 != 0) {
                    obj = Integer.valueOf(i12);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    obj = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a10.c() + ". Must be a reference to a resource.");
                }
            } else {
                int i13 = typedValue.resourceId;
                if (i13 != 0) {
                    if (a10 == null) {
                        a10 = rVar;
                        obj = Integer.valueOf(i13);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + a10.c() + ". You must use a \"" + rVar.c() + "\" type to reference other resources.");
                    }
                } else if (a10 == r.f3554k) {
                    obj = typedArray.getString(i11);
                } else {
                    int i14 = typedValue.type;
                    if (i14 == 3) {
                        String charSequence = typedValue.string.toString();
                        if (a10 == null) {
                            a10 = r.d(charSequence);
                        }
                        obj = a10.h(charSequence);
                    } else if (i14 == 4) {
                        a10 = a(typedValue, a10, r.f3550g, string, "float");
                        obj = Float.valueOf(typedValue.getFloat());
                    } else if (i14 == 5) {
                        a10 = a(typedValue, a10, r.f3545b, string, "dimension");
                        obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i14 == 18) {
                        a10 = a(typedValue, a10, r.f3552i, string, "boolean");
                        if (typedValue.data != 0) {
                            z10 = true;
                        }
                        obj = Boolean.valueOf(z10);
                    } else if (i14 < 16 || i14 > 31) {
                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                    } else {
                        r<Float> rVar2 = r.f3550g;
                        if (a10 == rVar2) {
                            a10 = a(typedValue, a10, rVar2, string, "float");
                            obj = Float.valueOf(typedValue.data);
                        } else {
                            a10 = a(typedValue, a10, r.f3545b, string, "integer");
                            obj = Integer.valueOf(typedValue.data);
                        }
                    }
                }
            }
        }
        if (obj != null) {
            aVar.b(obj);
        }
        if (a10 != null) {
            aVar.d(a10);
        }
        return aVar.a();
    }

    private void f(Resources resources, Bundle bundle, AttributeSet attributeSet, int i10) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f5563k);
        String string = obtainAttributes.getString(a.f5564l);
        if (string != null) {
            e e10 = e(obtainAttributes, resources, i10);
            if (e10.c()) {
                e10.d(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void g(Resources resources, k kVar, AttributeSet attributeSet, int i10) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f5563k);
        String string = obtainAttributes.getString(a.f5564l);
        if (string != null) {
            kVar.a(string, e(obtainAttributes, resources, i10));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void h(Resources resources, k kVar, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, a.f5568p);
        String string = obtainAttributes.getString(a.f5571s);
        String string2 = obtainAttributes.getString(a.f5569q);
        String string3 = obtainAttributes.getString(a.f5570r);
        if (!TextUtils.isEmpty(string) || !TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string3)) {
            h.a aVar = new h.a();
            if (string != null) {
                aVar.d(string.replace("${applicationId}", this.f3529a.getPackageName()));
            }
            if (!TextUtils.isEmpty(string2)) {
                aVar.b(string2.replace("${applicationId}", this.f3529a.getPackageName()));
            }
            if (string3 != null) {
                aVar.c(string3.replace("${applicationId}", this.f3529a.getPackageName()));
            }
            kVar.b(aVar.a());
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
    }

    @SuppressLint({"ResourceType"})
    public m c(int i10) {
        int next;
        Resources resources = this.f3529a.getResources();
        XmlResourceParser xml = resources.getXml(i10);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        while (true) {
            try {
                try {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                } catch (Exception e10) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i10) + " line " + xml.getLineNumber(), e10);
                }
            } finally {
                xml.close();
            }
        }
        if (next == 2) {
            String name = xml.getName();
            k b10 = b(resources, xml, asAttributeSet, i10);
            if (b10 instanceof m) {
                return (m) b10;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }
}
