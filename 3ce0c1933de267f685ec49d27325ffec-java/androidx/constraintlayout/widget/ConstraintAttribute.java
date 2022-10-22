package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* loaded from: classes.dex */
public class ConstraintAttribute {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1754a;

    /* renamed from: b  reason: collision with root package name */
    String f1755b;

    /* renamed from: c  reason: collision with root package name */
    private AttributeType f1756c;

    /* renamed from: d  reason: collision with root package name */
    private int f1757d;

    /* renamed from: e  reason: collision with root package name */
    private float f1758e;

    /* renamed from: f  reason: collision with root package name */
    private String f1759f;

    /* renamed from: g  reason: collision with root package name */
    boolean f1760g;

    /* renamed from: h  reason: collision with root package name */
    private int f1761h;

    /* loaded from: classes.dex */
    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1762a;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f1762a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1762a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1762a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1762a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1762a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1762a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1762a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1762a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public ConstraintAttribute(String str, AttributeType attributeType, Object obj, boolean z10) {
        this.f1754a = false;
        this.f1755b = str;
        this.f1756c = attributeType;
        this.f1754a = z10;
        f(obj);
    }

    private static int a(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> b(HashMap<String, ConstraintAttribute> hashMap, View view) {
        HashMap<String, ConstraintAttribute> hashMap2 = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    hashMap2.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod(str.length() != 0 ? "getMap".concat(str) : new String("getMap"), new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return hashMap2;
    }

    public static void c(Context context, XmlPullParser xmlPullParser, HashMap<String, ConstraintAttribute> hashMap) {
        AttributeType attributeType;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), h.f1989b4);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        AttributeType attributeType2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == h.f1997c4) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    char upperCase = Character.toUpperCase(str.charAt(0));
                    String substring = str.substring(1);
                    StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 1);
                    sb2.append(upperCase);
                    sb2.append(substring);
                    str = sb2.toString();
                }
            } else if (index == h.f2076m4) {
                str = obtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == h.f2005d4) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == h.f2021f4) {
                    attributeType = AttributeType.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == h.f2013e4) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == h.f2053j4) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == h.f2029g4) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == h.f2037h4) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == h.f2045i4) {
                    attributeType = AttributeType.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == h.f2069l4) {
                    attributeType = AttributeType.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == h.f2061k4) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                obj = valueOf;
                attributeType2 = attributeType;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new ConstraintAttribute(str, attributeType2, obj, z10));
        }
        obtainStyledAttributes.recycle();
    }

    public static void d(View view, HashMap<String, ConstraintAttribute> hashMap) {
        String str;
        Class<?> cls = view.getClass();
        for (String str2 : hashMap.keySet()) {
            ConstraintAttribute constraintAttribute = hashMap.get(str2);
            if (!constraintAttribute.f1754a) {
                String valueOf = String.valueOf(str2);
                str = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
            } else {
                str = str2;
            }
            try {
                switch (a.f1762a[constraintAttribute.f1756c.ordinal()]) {
                    case 1:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1757d));
                        break;
                    case 2:
                        cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f1760g));
                        break;
                    case 3:
                        cls.getMethod(str, CharSequence.class).invoke(view, constraintAttribute.f1759f);
                        break;
                    case 4:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1761h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f1761h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f1757d));
                        break;
                    case 7:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f1758e));
                        break;
                    case 8:
                        cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f1758e));
                        break;
                }
            } catch (IllegalAccessException e10) {
                String name = cls.getName();
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 34 + name.length());
                sb2.append(" Custom Attribute \"");
                sb2.append(str2);
                sb2.append("\" not found on ");
                sb2.append(name);
                Log.e("TransitionLayout", sb2.toString());
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                Log.e("TransitionLayout", e11.getMessage());
                String name2 = cls.getName();
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 34 + name2.length());
                sb3.append(" Custom Attribute \"");
                sb3.append(str2);
                sb3.append("\" not found on ");
                sb3.append(name2);
                Log.e("TransitionLayout", sb3.toString());
                String name3 = cls.getName();
                StringBuilder sb4 = new StringBuilder(name3.length() + 20 + String.valueOf(str).length());
                sb4.append(name3);
                sb4.append(" must have a method ");
                sb4.append(str);
                Log.e("TransitionLayout", sb4.toString());
            } catch (InvocationTargetException e12) {
                String name4 = cls.getName();
                StringBuilder sb5 = new StringBuilder(String.valueOf(str2).length() + 34 + name4.length());
                sb5.append(" Custom Attribute \"");
                sb5.append(str2);
                sb5.append("\" not found on ");
                sb5.append(name4);
                Log.e("TransitionLayout", sb5.toString());
                e12.printStackTrace();
            }
        }
    }

    public void e(View view, float[] fArr) {
        Class<?> cls = view.getClass();
        String valueOf = String.valueOf(this.f1755b);
        String concat = valueOf.length() != 0 ? "set".concat(valueOf) : new String("set");
        try {
            switch (a.f1762a[this.f1756c.ordinal()]) {
                case 2:
                    Method method = cls.getMethod(concat, Boolean.TYPE);
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(fArr[0] > 0.5f);
                    method.invoke(view, objArr);
                    return;
                case 3:
                    String valueOf2 = String.valueOf(this.f1755b);
                    throw new RuntimeException(valueOf2.length() != 0 ? "unable to interpolate strings ".concat(valueOf2) : new String("unable to interpolate strings "));
                case 4:
                    cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf((a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f))));
                    return;
                case 5:
                    Method method2 = cls.getMethod(concat, Drawable.class);
                    int a10 = a((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f));
                    int a11 = a((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f));
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor((a10 << 16) | (a((int) (fArr[3] * 255.0f)) << 24) | (a11 << 8) | a((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                    method2.invoke(view, colorDrawable);
                    return;
                case 6:
                    cls.getMethod(concat, Integer.TYPE).invoke(view, Integer.valueOf((int) fArr[0]));
                    return;
                case 7:
                    cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                case 8:
                    cls.getMethod(concat, Float.TYPE).invoke(view, Float.valueOf(fArr[0]));
                    return;
                default:
                    return;
            }
        } catch (IllegalAccessException e10) {
            String b10 = androidx.constraintlayout.motion.widget.a.b(view);
            StringBuilder sb2 = new StringBuilder(String.valueOf(concat).length() + 32 + String.valueOf(b10).length());
            sb2.append("cannot access method ");
            sb2.append(concat);
            sb2.append(" on View \"");
            sb2.append(b10);
            sb2.append("\"");
            Log.e("TransitionLayout", sb2.toString());
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            String b11 = androidx.constraintlayout.motion.widget.a.b(view);
            StringBuilder sb3 = new StringBuilder(String.valueOf(concat).length() + 21 + String.valueOf(b11).length());
            sb3.append("no method ");
            sb3.append(concat);
            sb3.append(" on View \"");
            sb3.append(b11);
            sb3.append("\"");
            Log.e("TransitionLayout", sb3.toString());
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
    }

    public void f(Object obj) {
        switch (a.f1762a[this.f1756c.ordinal()]) {
            case 1:
            case 6:
                this.f1757d = ((Integer) obj).intValue();
                return;
            case 2:
                this.f1760g = ((Boolean) obj).booleanValue();
                return;
            case 3:
                this.f1759f = (String) obj;
                return;
            case 4:
            case 5:
                this.f1761h = ((Integer) obj).intValue();
                return;
            case 7:
                this.f1758e = ((Float) obj).floatValue();
                return;
            case 8:
                this.f1758e = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(ConstraintAttribute constraintAttribute, Object obj) {
        this.f1754a = false;
        this.f1755b = constraintAttribute.f1755b;
        this.f1756c = constraintAttribute.f1756c;
        f(obj);
    }
}
