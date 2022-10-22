package a0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class e {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final c[] f37a;

        public b(c[] cVarArr) {
            this.f37a = cVarArr;
        }

        public c[] a() {
            return this.f37a;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final String f38a;

        /* renamed from: b  reason: collision with root package name */
        private int f39b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f40c;

        /* renamed from: d  reason: collision with root package name */
        private String f41d;

        /* renamed from: e  reason: collision with root package name */
        private int f42e;

        /* renamed from: f  reason: collision with root package name */
        private int f43f;

        public c(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f38a = str;
            this.f39b = i10;
            this.f40c = z10;
            this.f41d = str2;
            this.f42e = i11;
            this.f43f = i12;
        }

        public String a() {
            return this.f38a;
        }

        public int b() {
            return this.f43f;
        }

        public int c() {
            return this.f42e;
        }

        public String d() {
            return this.f41d;
        }

        public int e() {
            return this.f39b;
        }

        public boolean f() {
            return this.f40c;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final h0.d f44a;

        /* renamed from: b  reason: collision with root package name */
        private final int f45b;

        /* renamed from: c  reason: collision with root package name */
        private final int f46c;

        /* renamed from: d  reason: collision with root package name */
        private final String f47d;

        public d(h0.d dVar, int i10, int i11, String str) {
            this.f44a = dVar;
            this.f46c = i10;
            this.f45b = i11;
            this.f47d = str;
        }

        public int a() {
            return this.f46c;
        }

        public h0.d b() {
            return this.f44a;
        }

        public String c() {
            return this.f47d;
        }

        public int d() {
            return this.f45b;
        }
    }

    private static int a(TypedArray typedArray, int i10) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i10);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List<List<byte[]>> c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static a d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    private static a e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), z.c.f37188g);
        String string = obtainAttributes.getString(z.c.f37189h);
        String string2 = obtainAttributes.getString(z.c.f37193l);
        String string3 = obtainAttributes.getString(z.c.f37194m);
        int resourceId = obtainAttributes.getResourceId(z.c.f37190i, 0);
        int integer = obtainAttributes.getInteger(z.c.f37191j, 1);
        int integer2 = obtainAttributes.getInteger(z.c.f37192k, AGCServerException.UNKNOW_EXCEPTION);
        String string4 = obtainAttributes.getString(z.c.f37195n);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(f(xmlPullParser, resources));
                    } else {
                        g(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new d(new h0.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
    }

    private static c f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), z.c.f37196o);
        int i10 = z.c.f37205x;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = z.c.f37198q;
        }
        int i11 = obtainAttributes.getInt(i10, AGCServerException.AUTHENTICATION_INVALID);
        int i12 = z.c.f37203v;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = z.c.f37199r;
        }
        boolean z10 = 1 == obtainAttributes.getInt(i12, 0);
        int i13 = z.c.f37206y;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = z.c.f37200s;
        }
        int i14 = z.c.f37204w;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = z.c.f37201t;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = z.c.f37202u;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = z.c.f37197p;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new c(string2, i11, z10, string, i15, resourceId);
    }

    private static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    private static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
