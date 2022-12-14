package com.ta.utdid2.b.a;

import android.util.Xml;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes2.dex */
public class e {
    public static final void a(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        a aVar = new a();
        aVar.setOutput(outputStream, "utf-8");
        aVar.startDocument(null, Boolean.TRUE);
        aVar.setFeature(a.d(), true);
        a(map, (String) null, (XmlSerializer) aVar);
        aVar.endDocument();
    }

    public static Object b(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int next;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, ContactConstant.CallsRecordKeys.NAME);
        String name = xmlPullParser.getName();
        if (!name.equals(LpaConstants.VALUE_NULL)) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    } else if (next2 == 4) {
                        str = str + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE)));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE));
            } else if (name.equals("float")) {
                obj = Float.valueOf(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE));
            } else if (name.equals("double")) {
                obj = Double.valueOf(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE));
            } else if (name.equals("boolean")) {
                obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE));
            } else if (name.equals("int-array")) {
                xmlPullParser.next();
                int[] a10 = m25a(xmlPullParser, "int-array", strArr);
                strArr[0] = attributeValue;
                return a10;
            } else if (name.equals("map")) {
                xmlPullParser.next();
                HashMap a11 = m24a(xmlPullParser, "map", strArr);
                strArr[0] = attributeValue;
                return a11;
            } else if (name.equals("list")) {
                xmlPullParser.next();
                ArrayList a12 = a(xmlPullParser, "list", strArr);
                strArr[0] = attributeValue;
                return a12;
            } else {
                throw new XmlPullParserException("Unknown tag: " + name);
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + ">");
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }

    public static final void a(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag(null, LpaConstants.VALUE_NULL);
            xmlSerializer.endTag(null, LpaConstants.VALUE_NULL);
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
        }
        for (Map.Entry entry : map.entrySet()) {
            a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
    }

    public static final void a(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag(null, LpaConstants.VALUE_NULL);
            xmlSerializer.endTag(null, LpaConstants.VALUE_NULL);
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10), (String) null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
    }

    public static final void a(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, LpaConstants.VALUE_NULL);
            xmlSerializer.endTag(null, LpaConstants.VALUE_NULL);
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(bArr.length));
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 >> 4;
            sb2.append(i10 >= 10 ? (i10 + 97) - 10 : i10 + 48);
            int i11 = b10 & 255;
            sb2.append(i11 >= 10 ? (i11 + 97) - 10 : i11 + 48);
        }
        xmlSerializer.text(sb2.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    public static final void a(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, LpaConstants.VALUE_NULL);
            xmlSerializer.endTag(null, LpaConstants.VALUE_NULL);
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(iArr.length));
        for (int i10 : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, HealthDataProviderContracts.NAME_VALUE, Integer.toString(i10));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
    }

    public static final void a(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag(null, LpaConstants.VALUE_NULL);
            if (str != null) {
                xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
            }
            xmlSerializer.endTag(null, LpaConstants.VALUE_NULL);
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
        } else {
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                a((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                a((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                a((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                a((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                return;
            } else {
                throw new RuntimeException("writeValueXml: unable to write value " + obj);
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, ContactConstant.CallsRecordKeys.NAME, str);
            }
            xmlSerializer.attribute(null, HealthDataProviderContracts.NAME_VALUE, obj.toString());
            xmlSerializer.endTag(null, str2);
        }
    }

    public static final HashMap a(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) a(newPullParser, new String[1]);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final HashMap m24a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object b10 = b(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], b10);
                } else {
                    throw new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    public static final ArrayList a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static final int[] m25a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue(null, "num"))];
            int i10 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i10] = Integer.parseInt(xmlPullParser.getAttributeValue(null, HealthDataProviderContracts.NAME_VALUE));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i10++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static final Object a(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            } else if (eventType != 4) {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception unused) {
                    throw new XmlPullParserException("Unexpected call next(): " + xmlPullParser.getName());
                }
            } else {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
        }
        return b(xmlPullParser, strArr);
    }
}
