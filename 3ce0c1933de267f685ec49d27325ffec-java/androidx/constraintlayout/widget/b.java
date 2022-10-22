package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintLayoutStates.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f1845a;

    /* renamed from: b  reason: collision with root package name */
    c f1846b;

    /* renamed from: c  reason: collision with root package name */
    int f1847c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f1848d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<a> f1849e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<c> f1850f = new SparseArray<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1851a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<C0011b> f1852b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f1853c;

        /* renamed from: d  reason: collision with root package name */
        c f1854d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f1853c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.P5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.Q5) {
                    this.f1851a = obtainStyledAttributes.getResourceId(index, this.f1851a);
                } else if (index == h.R5) {
                    this.f1853c = obtainStyledAttributes.getResourceId(index, this.f1853c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1853c);
                    context.getResources().getResourceName(this.f1853c);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f1854d = cVar;
                        cVar.f(context, this.f1853c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        void a(C0011b bVar) {
            this.f1852b.add(bVar);
        }

        public int b(float f10, float f11) {
            for (int i10 = 0; i10 < this.f1852b.size(); i10++) {
                if (this.f1852b.get(i10).a(f10, f11)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: androidx.constraintlayout.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011b {

        /* renamed from: a  reason: collision with root package name */
        float f1855a;

        /* renamed from: b  reason: collision with root package name */
        float f1856b;

        /* renamed from: c  reason: collision with root package name */
        float f1857c;

        /* renamed from: d  reason: collision with root package name */
        float f1858d;

        /* renamed from: e  reason: collision with root package name */
        int f1859e;

        /* renamed from: f  reason: collision with root package name */
        c f1860f;

        public C0011b(Context context, XmlPullParser xmlPullParser) {
            this.f1855a = Float.NaN;
            this.f1856b = Float.NaN;
            this.f1857c = Float.NaN;
            this.f1858d = Float.NaN;
            this.f1859e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.f2023f6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.f2031g6) {
                    this.f1859e = obtainStyledAttributes.getResourceId(index, this.f1859e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f1859e);
                    context.getResources().getResourceName(this.f1859e);
                    if ("layout".equals(resourceTypeName)) {
                        c cVar = new c();
                        this.f1860f = cVar;
                        cVar.f(context, this.f1859e);
                    }
                } else if (index == h.f2039h6) {
                    this.f1858d = obtainStyledAttributes.getDimension(index, this.f1858d);
                } else if (index == h.f2047i6) {
                    this.f1856b = obtainStyledAttributes.getDimension(index, this.f1856b);
                } else if (index == h.f2055j6) {
                    this.f1857c = obtainStyledAttributes.getDimension(index, this.f1857c);
                } else if (index == h.f2063k6) {
                    this.f1855a = obtainStyledAttributes.getDimension(index, this.f1855a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        boolean a(float f10, float f11) {
            if (!Float.isNaN(this.f1855a) && f10 < this.f1855a) {
                return false;
            }
            if (!Float.isNaN(this.f1856b) && f11 < this.f1856b) {
                return false;
            }
            if (Float.isNaN(this.f1857c) || f10 <= this.f1857c) {
                return Float.isNaN(this.f1858d) || f11 <= this.f1858d;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, ConstraintLayout constraintLayout, int i10) {
        this.f1845a = constraintLayout;
        a(context, i10);
    }

    private void a(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        a aVar = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                char c10 = 1;
                if (eventType != 1) {
                    if (eventType == 0) {
                        xml.getName();
                    } else if (eventType == 2) {
                        String name = xml.getName();
                        c10 = 65535;
                        switch (name.hashCode()) {
                            case -1349929691:
                                if (name.equals("ConstraintSet")) {
                                    c10 = 4;
                                    break;
                                }
                                break;
                            case 80204913:
                                if (name.equals("State")) {
                                    c10 = 2;
                                    break;
                                }
                                break;
                            case 1382829617:
                                if (name.equals("StateSet")) {
                                    break;
                                }
                                break;
                            case 1657696882:
                                if (name.equals("layoutDescription")) {
                                    c10 = 0;
                                    break;
                                }
                                break;
                            case 1901439077:
                                if (name.equals("Variant")) {
                                    c10 = 3;
                                    break;
                                }
                                break;
                        }
                        if (c10 == 2) {
                            aVar = new a(context, xml);
                            this.f1849e.put(aVar.f1851a, aVar);
                        } else if (c10 == 3) {
                            C0011b bVar = new C0011b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (c10 == 4) {
                            b(context, xml);
                        }
                    }
                    eventType = xml.next();
                } else {
                    return;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        c cVar = new c();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            String attributeValue = xmlPullParser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains("/") ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1) {
                    if (attributeValue.length() > 1) {
                        identifier = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                cVar.n(context, xmlPullParser);
                this.f1850f.put(identifier, cVar);
                return;
            }
        }
    }

    public void c(e eVar) {
    }

    public void d(int i10, float f10, float f11) {
        c cVar;
        a aVar;
        int b10;
        c cVar2;
        int i11 = this.f1847c;
        if (i11 == i10) {
            if (i10 == -1) {
                aVar = this.f1849e.valueAt(0);
            } else {
                aVar = this.f1849e.get(i11);
            }
            int i12 = this.f1848d;
            if ((i12 == -1 || !aVar.f1852b.get(i12).a(f10, f11)) && this.f1848d != (b10 = aVar.b(f10, f11))) {
                if (b10 == -1) {
                    cVar2 = this.f1846b;
                } else {
                    cVar2 = aVar.f1852b.get(b10).f1860f;
                }
                if (b10 != -1) {
                    int i13 = aVar.f1852b.get(b10).f1859e;
                }
                if (cVar2 != null) {
                    this.f1848d = b10;
                    cVar2.c(this.f1845a);
                    return;
                }
                return;
            }
            return;
        }
        this.f1847c = i10;
        a aVar2 = this.f1849e.get(i10);
        int b11 = aVar2.b(f10, f11);
        if (b11 == -1) {
            cVar = aVar2.f1854d;
        } else {
            cVar = aVar2.f1852b.get(b11).f1860f;
        }
        if (b11 != -1) {
            int i14 = aVar2.f1852b.get(b11).f1859e;
        }
        if (cVar == null) {
            StringBuilder sb2 = new StringBuilder(79);
            sb2.append("NO Constraint set found ! id=");
            sb2.append(i10);
            sb2.append(", dim =");
            sb2.append(f10);
            sb2.append(", ");
            sb2.append(f11);
            Log.v("ConstraintLayoutStates", sb2.toString());
            return;
        }
        this.f1848d = b11;
        cVar.c(this.f1845a);
    }
}
