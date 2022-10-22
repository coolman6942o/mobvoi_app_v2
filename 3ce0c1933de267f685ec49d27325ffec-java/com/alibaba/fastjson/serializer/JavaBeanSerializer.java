package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class JavaBeanSerializer implements ObjectSerializer {
    protected int features;
    private final FieldSerializer[] getters;
    private final FieldSerializer[] sortedGetters;
    protected String typeName;
    private static final char[] true_chars = {'t', 'r', 'u', 'e'};
    private static final char[] false_chars = {'f', 'a', 'l', 's', 'e'};

    public JavaBeanSerializer(Class<?> cls) {
        this(cls, (PropertyNamingStrategy) null);
    }

    private static Map<String, String> map(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, str);
        }
        return hashMap;
    }

    public Map<String, Object> getFieldValuesMap(Object obj) throws Exception {
        FieldSerializer[] fieldSerializerArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.sortedGetters.length);
        for (FieldSerializer fieldSerializer : this.sortedGetters) {
            linkedHashMap.put(fieldSerializer.fieldInfo.name, fieldSerializer.getPropertyValue(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0401 A[Catch: all -> 0x04c9, Exception -> 0x04cf, TryCatch #9 {Exception -> 0x04cf, all -> 0x04c9, blocks: (B:109:0x0158, B:111:0x0173, B:113:0x0177, B:117:0x017e, B:118:0x0182, B:120:0x0188, B:127:0x01a3, B:129:0x01aa, B:131:0x01ae, B:132:0x01be, B:134:0x01c2, B:135:0x01ce, B:137:0x01d2, B:138:0x01e2, B:139:0x01e9, B:144:0x01fa, B:146:0x0200, B:148:0x0207, B:150:0x020b, B:151:0x0210, B:153:0x0214, B:155:0x021b, B:156:0x021f, B:158:0x0225, B:169:0x0249, B:171:0x024d, B:173:0x0255, B:175:0x0259, B:176:0x025e, B:178:0x0262, B:179:0x0267, B:180:0x026e, B:182:0x0274, B:187:0x028e, B:189:0x0292, B:191:0x0299, B:193:0x029d, B:194:0x02a2, B:196:0x02a6, B:197:0x02ab, B:198:0x02b2, B:200:0x02b8, B:206:0x02d8, B:208:0x02dc, B:215:0x02f0, B:217:0x02f4, B:219:0x02f8, B:221:0x02fc, B:223:0x0300, B:225:0x0304, B:227:0x0308, B:229:0x030c, B:232:0x0316, B:234:0x031a, B:236:0x031e, B:240:0x0330, B:242:0x0339, B:244:0x033d, B:245:0x0341, B:246:0x0345, B:248:0x035a, B:252:0x0366, B:253:0x036a, B:257:0x0374, B:258:0x0377, B:261:0x037f, B:263:0x038a, B:265:0x038e, B:267:0x0393, B:271:0x03af, B:272:0x03b9, B:275:0x03c0, B:279:0x03ca, B:284:0x03d6, B:286:0x03dc, B:288:0x03e0, B:289:0x03e2, B:291:0x03ea, B:293:0x03ee, B:294:0x03f2, B:297:0x0401, B:298:0x040b, B:299:0x040e, B:301:0x0412, B:302:0x041b, B:305:0x0421, B:306:0x042c, B:311:0x043f, B:313:0x0448, B:316:0x044e, B:317:0x0453, B:318:0x045a, B:320:0x045e, B:321:0x0463, B:322:0x046a, B:325:0x0470, B:327:0x0479, B:332:0x048d, B:333:0x0492, B:334:0x0497, B:335:0x04a2, B:336:0x04a7, B:337:0x04ac, B:350:0x04e6, B:351:0x04ea, B:353:0x04f0, B:357:0x0500, B:359:0x0509, B:362:0x0518, B:364:0x051c, B:365:0x0520), top: B:391:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0500 A[Catch: all -> 0x04c9, Exception -> 0x04cf, TRY_ENTER, TryCatch #9 {Exception -> 0x04cf, all -> 0x04c9, blocks: (B:109:0x0158, B:111:0x0173, B:113:0x0177, B:117:0x017e, B:118:0x0182, B:120:0x0188, B:127:0x01a3, B:129:0x01aa, B:131:0x01ae, B:132:0x01be, B:134:0x01c2, B:135:0x01ce, B:137:0x01d2, B:138:0x01e2, B:139:0x01e9, B:144:0x01fa, B:146:0x0200, B:148:0x0207, B:150:0x020b, B:151:0x0210, B:153:0x0214, B:155:0x021b, B:156:0x021f, B:158:0x0225, B:169:0x0249, B:171:0x024d, B:173:0x0255, B:175:0x0259, B:176:0x025e, B:178:0x0262, B:179:0x0267, B:180:0x026e, B:182:0x0274, B:187:0x028e, B:189:0x0292, B:191:0x0299, B:193:0x029d, B:194:0x02a2, B:196:0x02a6, B:197:0x02ab, B:198:0x02b2, B:200:0x02b8, B:206:0x02d8, B:208:0x02dc, B:215:0x02f0, B:217:0x02f4, B:219:0x02f8, B:221:0x02fc, B:223:0x0300, B:225:0x0304, B:227:0x0308, B:229:0x030c, B:232:0x0316, B:234:0x031a, B:236:0x031e, B:240:0x0330, B:242:0x0339, B:244:0x033d, B:245:0x0341, B:246:0x0345, B:248:0x035a, B:252:0x0366, B:253:0x036a, B:257:0x0374, B:258:0x0377, B:261:0x037f, B:263:0x038a, B:265:0x038e, B:267:0x0393, B:271:0x03af, B:272:0x03b9, B:275:0x03c0, B:279:0x03ca, B:284:0x03d6, B:286:0x03dc, B:288:0x03e0, B:289:0x03e2, B:291:0x03ea, B:293:0x03ee, B:294:0x03f2, B:297:0x0401, B:298:0x040b, B:299:0x040e, B:301:0x0412, B:302:0x041b, B:305:0x0421, B:306:0x042c, B:311:0x043f, B:313:0x0448, B:316:0x044e, B:317:0x0453, B:318:0x045a, B:320:0x045e, B:321:0x0463, B:322:0x046a, B:325:0x0470, B:327:0x0479, B:332:0x048d, B:333:0x0492, B:334:0x0497, B:335:0x04a2, B:336:0x04a7, B:337:0x04ac, B:350:0x04e6, B:351:0x04ea, B:353:0x04f0, B:357:0x0500, B:359:0x0509, B:362:0x0518, B:364:0x051c, B:365:0x0520), top: B:391:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0518 A[Catch: all -> 0x04c9, Exception -> 0x04cf, TRY_ENTER, TryCatch #9 {Exception -> 0x04cf, all -> 0x04c9, blocks: (B:109:0x0158, B:111:0x0173, B:113:0x0177, B:117:0x017e, B:118:0x0182, B:120:0x0188, B:127:0x01a3, B:129:0x01aa, B:131:0x01ae, B:132:0x01be, B:134:0x01c2, B:135:0x01ce, B:137:0x01d2, B:138:0x01e2, B:139:0x01e9, B:144:0x01fa, B:146:0x0200, B:148:0x0207, B:150:0x020b, B:151:0x0210, B:153:0x0214, B:155:0x021b, B:156:0x021f, B:158:0x0225, B:169:0x0249, B:171:0x024d, B:173:0x0255, B:175:0x0259, B:176:0x025e, B:178:0x0262, B:179:0x0267, B:180:0x026e, B:182:0x0274, B:187:0x028e, B:189:0x0292, B:191:0x0299, B:193:0x029d, B:194:0x02a2, B:196:0x02a6, B:197:0x02ab, B:198:0x02b2, B:200:0x02b8, B:206:0x02d8, B:208:0x02dc, B:215:0x02f0, B:217:0x02f4, B:219:0x02f8, B:221:0x02fc, B:223:0x0300, B:225:0x0304, B:227:0x0308, B:229:0x030c, B:232:0x0316, B:234:0x031a, B:236:0x031e, B:240:0x0330, B:242:0x0339, B:244:0x033d, B:245:0x0341, B:246:0x0345, B:248:0x035a, B:252:0x0366, B:253:0x036a, B:257:0x0374, B:258:0x0377, B:261:0x037f, B:263:0x038a, B:265:0x038e, B:267:0x0393, B:271:0x03af, B:272:0x03b9, B:275:0x03c0, B:279:0x03ca, B:284:0x03d6, B:286:0x03dc, B:288:0x03e0, B:289:0x03e2, B:291:0x03ea, B:293:0x03ee, B:294:0x03f2, B:297:0x0401, B:298:0x040b, B:299:0x040e, B:301:0x0412, B:302:0x041b, B:305:0x0421, B:306:0x042c, B:311:0x043f, B:313:0x0448, B:316:0x044e, B:317:0x0453, B:318:0x045a, B:320:0x045e, B:321:0x0463, B:322:0x046a, B:325:0x0470, B:327:0x0479, B:332:0x048d, B:333:0x0492, B:334:0x0497, B:335:0x04a2, B:336:0x04a7, B:337:0x04ac, B:350:0x04e6, B:351:0x04ea, B:353:0x04f0, B:357:0x0500, B:359:0x0509, B:362:0x0518, B:364:0x051c, B:365:0x0520), top: B:391:0x0158 }] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0548 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:391:0x0158 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0107 A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TryCatch #6 {Exception -> 0x009b, all -> 0x0096, blocks: (B:40:0x0089, B:42:0x008d, B:43:0x0091, B:51:0x00ab, B:53:0x00b4, B:57:0x00c3, B:60:0x00ca, B:62:0x00d1, B:68:0x00dd, B:70:0x00e3, B:72:0x00ee, B:73:0x00f6, B:82:0x0107, B:83:0x010b, B:85:0x0111, B:92:0x012a), top: B:396:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x012a A[Catch: all -> 0x0096, Exception -> 0x009b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {Exception -> 0x009b, all -> 0x0096, blocks: (B:40:0x0089, B:42:0x008d, B:43:0x0091, B:51:0x00ab, B:53:0x00b4, B:57:0x00c3, B:60:0x00ca, B:62:0x00d1, B:68:0x00dd, B:70:0x00e3, B:72:0x00ee, B:73:0x00f6, B:82:0x0107, B:83:0x010b, B:85:0x0111, B:92:0x012a), top: B:396:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013b  */
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        FieldSerializer[] fieldSerializerArr;
        Throwable th2;
        SerialContext serialContext;
        Exception e10;
        Exception e11;
        boolean z10;
        boolean z11;
        List<BeforeFilter> list;
        int i10;
        boolean z12;
        int i11;
        FieldSerializer[] fieldSerializerArr2;
        List<AfterFilter> list2;
        int i12;
        int i13;
        boolean z13;
        List<PropertyFilter> list3;
        List<ValueFilter> list4;
        List<NameFilter> list5;
        List<PropertyPreFilter> list6;
        boolean z14;
        long j10;
        boolean z15;
        int i14;
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        Object obj3;
        boolean z19;
        int i15;
        Object valueOf;
        IdentityHashMap<Object, SerialContext> identityHashMap;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
            return;
        }
        SerialContext serialContext2 = jSONSerializer.context;
        if ((serialContext2 == null || (serialContext2.features & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) && (identityHashMap = jSONSerializer.references) != null && identityHashMap.containsKey(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        int i16 = serializeWriter.features;
        if ((SerializerFeature.SortField.mask & i16) != 0) {
            fieldSerializerArr = this.sortedGetters;
        } else {
            fieldSerializerArr = this.getters;
        }
        SerialContext serialContext3 = jSONSerializer.context;
        if ((i16 & SerializerFeature.DisableCircularReferenceDetect.mask) == 0) {
            jSONSerializer.context = new SerialContext(serialContext3, obj, obj2, this.features);
            if (jSONSerializer.references == null) {
                jSONSerializer.references = new IdentityHashMap<>();
            }
            jSONSerializer.references.put(obj, jSONSerializer.context);
        }
        int i17 = this.features;
        int i18 = SerializerFeature.BeanToArray.mask;
        boolean z20 = ((i17 & i18) == 0 && (serializeWriter.features & i18) == 0) ? false : true;
        char c10 = z20 ? '[' : '{';
        char c11 = z20 ? ']' : '}';
        try {
            int i19 = serializeWriter.count + 1;
            if (i19 > serializeWriter.buf.length) {
                try {
                    if (serializeWriter.writer == null) {
                        serializeWriter.expandCapacity(i19);
                    } else {
                        serializeWriter.flush();
                        i19 = 1;
                    }
                } catch (Exception e12) {
                    e10 = e12;
                    serialContext = serialContext3;
                    String str2 = "write javaBean error";
                    if (obj2 != null) {
                    }
                    throw new JSONException(str2, e10);
                } catch (Throwable th3) {
                    th2 = th3;
                    serialContext = serialContext3;
                    jSONSerializer.context = serialContext;
                    throw th2;
                }
            }
            serializeWriter.buf[serializeWriter.count] = c10;
            serializeWriter.count = i19;
            if (fieldSerializerArr.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                jSONSerializer.incrementIndent();
                jSONSerializer.println();
            }
            int i20 = this.features;
            int i21 = SerializerFeature.WriteClassName.mask;
            if ((i20 & i21) == 0) {
                int i22 = serializeWriter.features;
                if ((i21 & i22) == 0 || (type == null && (i22 & SerializerFeature.NotWriteRootClassName.mask) != 0 && jSONSerializer.context.parent == null)) {
                    z10 = false;
                    if (z10 || obj.getClass() == type) {
                        z11 = false;
                    } else {
                        serializeWriter.writeFieldName(jSONSerializer.config.typeKey, false);
                        String str3 = this.typeName;
                        if (str3 == null) {
                            str3 = obj.getClass().getName();
                        }
                        jSONSerializer.write(str3);
                        z11 = true;
                    }
                    char c12 = !z11 ? ',' : (char) 0;
                    list = jSONSerializer.beforeFilters;
                    if (list != null) {
                        for (BeforeFilter beforeFilter : list) {
                            c12 = beforeFilter.writeBefore(jSONSerializer, obj, c12);
                        }
                    }
                    boolean z21 = c12 != ',';
                    i10 = serializeWriter.features;
                    if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
                        if ((SerializerFeature.UseSingleQuotes.mask & i10) == 0) {
                            z12 = true;
                            boolean z22 = (SerializerFeature.UseSingleQuotes.mask & i10) != 0;
                            boolean z23 = (SerializerFeature.NotWriteDefaultValue.mask & i10) != 0;
                            List<PropertyFilter> list7 = jSONSerializer.propertyFilters;
                            List<NameFilter> list8 = jSONSerializer.nameFilters;
                            List<ValueFilter> list9 = jSONSerializer.valueFilters;
                            boolean z24 = z21;
                            List<PropertyPreFilter> list10 = jSONSerializer.propertyPreFilters;
                            i11 = 0;
                            while (i11 < fieldSerializerArr.length) {
                                try {
                                    try {
                                        FieldSerializer fieldSerializer = fieldSerializerArr[i11];
                                        c11 = c11;
                                        FieldInfo fieldInfo = fieldSerializer.fieldInfo;
                                        fieldSerializerArr = fieldSerializerArr;
                                        Class<?> cls = fieldInfo.fieldClass;
                                        int i23 = i11;
                                        String str4 = fieldInfo.name;
                                        boolean z25 = z22;
                                        boolean z26 = z12;
                                        if ((SerializerFeature.SkipTransientField.mask & serializeWriter.features) == 0 || fieldInfo.field == null || !fieldInfo.fieldTransient) {
                                            if (list10 != null) {
                                                for (PropertyPreFilter propertyPreFilter : list10) {
                                                    if (!propertyPreFilter.apply(jSONSerializer, obj, str4)) {
                                                        z14 = false;
                                                        break;
                                                    }
                                                }
                                            }
                                            z14 = true;
                                            if (z14) {
                                                Object obj4 = null;
                                                if (fieldInfo.fieldAccess) {
                                                    if (cls == Integer.TYPE) {
                                                        i14 = fieldInfo.field.getInt(obj);
                                                        j10 = 0;
                                                        z16 = false;
                                                        z15 = false;
                                                        z17 = true;
                                                    } else if (cls == Long.TYPE) {
                                                        j10 = fieldInfo.field.getLong(obj);
                                                        z17 = true;
                                                        z16 = false;
                                                        i14 = 0;
                                                        z15 = false;
                                                    } else if (cls == Boolean.TYPE) {
                                                        z15 = fieldInfo.field.getBoolean(obj);
                                                        j10 = 0;
                                                        z17 = true;
                                                        z16 = false;
                                                        i14 = 0;
                                                    } else {
                                                        obj4 = fieldInfo.field.get(obj);
                                                    }
                                                    if (list7 == null) {
                                                        if (z17) {
                                                            list6 = list10;
                                                            if (cls == Integer.TYPE) {
                                                                obj4 = Integer.valueOf(i14);
                                                            } else if (cls == Long.TYPE) {
                                                                obj4 = Long.valueOf(j10);
                                                            } else if (cls == Boolean.TYPE) {
                                                                obj4 = Boolean.valueOf(z15);
                                                            }
                                                            z16 = true;
                                                        } else {
                                                            list6 = list10;
                                                        }
                                                        Iterator<PropertyFilter> it = list7.iterator();
                                                        while (it.hasNext()) {
                                                            PropertyFilter next = it.next();
                                                            it = it;
                                                            if (!next.apply(obj, str4, obj4)) {
                                                                z18 = false;
                                                                break;
                                                            }
                                                        }
                                                    } else {
                                                        list6 = list10;
                                                    }
                                                    z18 = true;
                                                    if (z18) {
                                                        list4 = list9;
                                                        list5 = list8;
                                                        list3 = list7;
                                                        z13 = z23;
                                                        i11 = i23 + 1;
                                                        z22 = z25;
                                                        z12 = z26;
                                                        list10 = list6;
                                                        list8 = list5;
                                                        list9 = list4;
                                                        list7 = list3;
                                                        z23 = z13;
                                                    } else {
                                                        if (list8 != null) {
                                                            if (z17 && !z16) {
                                                                if (cls == Integer.TYPE) {
                                                                    valueOf = Integer.valueOf(i14);
                                                                } else if (cls == Long.TYPE) {
                                                                    valueOf = Long.valueOf(j10);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    valueOf = Boolean.valueOf(z15);
                                                                }
                                                                obj4 = valueOf;
                                                                z16 = true;
                                                            }
                                                            Iterator<NameFilter> it2 = list8.iterator();
                                                            list5 = list8;
                                                            str = str4;
                                                            while (it2.hasNext()) {
                                                                NameFilter next2 = it2.next();
                                                                it2 = it2;
                                                                str = next2.process(obj, str, obj4);
                                                            }
                                                        } else {
                                                            list5 = list8;
                                                            str = str4;
                                                        }
                                                        if (list9 != null) {
                                                            if (z17 && !z16) {
                                                                if (cls == Integer.TYPE) {
                                                                    obj4 = Integer.valueOf(i14);
                                                                } else if (cls == Long.TYPE) {
                                                                    obj4 = Long.valueOf(j10);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    obj4 = Boolean.valueOf(z15);
                                                                }
                                                                z16 = true;
                                                            }
                                                            Iterator<ValueFilter> it3 = list9.iterator();
                                                            list4 = list9;
                                                            Object obj5 = obj4;
                                                            while (it3.hasNext()) {
                                                                ValueFilter next3 = it3.next();
                                                                it3 = it3;
                                                                obj5 = next3.process(obj, str4, obj5);
                                                            }
                                                            obj3 = obj4;
                                                            obj4 = obj5;
                                                        } else {
                                                            list4 = list9;
                                                            obj3 = obj4;
                                                        }
                                                        if (!z16 || obj4 != null || z20 || fieldSerializer.writeNull) {
                                                            list3 = list7;
                                                        } else {
                                                            list3 = list7;
                                                            if ((serializeWriter.features & SerializerFeature.WriteMapNullValue.mask) == 0) {
                                                                z13 = z23;
                                                                i11 = i23 + 1;
                                                                z22 = z25;
                                                                z12 = z26;
                                                                list10 = list6;
                                                                list8 = list5;
                                                                list9 = list4;
                                                                list7 = list3;
                                                                z23 = z13;
                                                            }
                                                        }
                                                        if (!z16 || obj4 == null || !z23 || (!((cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Long.TYPE || cls == Float.TYPE || cls == Double.TYPE) && (obj4 instanceof Number) && ((Number) obj4).byteValue() == 0) && (cls != Boolean.TYPE || !(obj4 instanceof Boolean) || ((Boolean) obj4).booleanValue()))) {
                                                            if (z24) {
                                                                int i24 = serializeWriter.count + 1;
                                                                if (i24 > serializeWriter.buf.length) {
                                                                    if (serializeWriter.writer == null) {
                                                                        serializeWriter.expandCapacity(i24);
                                                                    } else {
                                                                        serializeWriter.flush();
                                                                        i24 = 1;
                                                                    }
                                                                }
                                                                z13 = z23;
                                                                serializeWriter.buf[serializeWriter.count] = ',';
                                                                serializeWriter.count = i24;
                                                                if ((serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                                                    jSONSerializer.println();
                                                                }
                                                            } else {
                                                                z13 = z23;
                                                            }
                                                            if (str != str4) {
                                                                if (!z20) {
                                                                    serializeWriter.writeFieldName(str, true);
                                                                }
                                                                jSONSerializer.write(obj4);
                                                            } else if (obj3 != obj4) {
                                                                if (!z20) {
                                                                    fieldSerializer.writePrefix(jSONSerializer);
                                                                }
                                                                jSONSerializer.write(obj4);
                                                            } else {
                                                                if (!z20) {
                                                                    if (z26) {
                                                                        char[] cArr = fieldSerializer.name_chars;
                                                                        int length = cArr.length;
                                                                        int i25 = serializeWriter.count + length;
                                                                        if (i25 > serializeWriter.buf.length) {
                                                                            if (serializeWriter.writer == null) {
                                                                                serializeWriter.expandCapacity(i25);
                                                                            } else {
                                                                                int i26 = 0;
                                                                                do {
                                                                                    char[] cArr2 = serializeWriter.buf;
                                                                                    int length2 = cArr2.length;
                                                                                    int i27 = serializeWriter.count;
                                                                                    int i28 = length2 - i27;
                                                                                    System.arraycopy(cArr, i26, cArr2, i27, i28);
                                                                                    serializeWriter.count = serializeWriter.buf.length;
                                                                                    serializeWriter.flush();
                                                                                    length -= i28;
                                                                                    i26 += i28;
                                                                                } while (length > serializeWriter.buf.length);
                                                                                i15 = i26;
                                                                                i25 = length;
                                                                                System.arraycopy(cArr, i15, serializeWriter.buf, serializeWriter.count, length);
                                                                                serializeWriter.count = i25;
                                                                            }
                                                                        }
                                                                        i15 = 0;
                                                                        System.arraycopy(cArr, i15, serializeWriter.buf, serializeWriter.count, length);
                                                                        serializeWriter.count = i25;
                                                                    } else {
                                                                        fieldSerializer.writePrefix(jSONSerializer);
                                                                    }
                                                                }
                                                                if (!z17 || z16) {
                                                                    if (z20) {
                                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                    } else if (cls == String.class) {
                                                                        if (obj4 == null) {
                                                                            int i29 = serializeWriter.features;
                                                                            int i30 = SerializerFeature.WriteNullStringAsEmpty.mask;
                                                                            if ((i29 & i30) == 0 && (fieldSerializer.features & i30) == 0) {
                                                                                serializeWriter.writeNull();
                                                                            }
                                                                            serializeWriter.writeString("");
                                                                        } else {
                                                                            String str5 = (String) obj4;
                                                                            if (z25) {
                                                                                serializeWriter.writeStringWithSingleQuote(str5);
                                                                            } else {
                                                                                serializeWriter.writeStringWithDoubleQuote(str5, (char) 0, true);
                                                                            }
                                                                        }
                                                                    } else if (!fieldInfo.isEnum) {
                                                                        fieldSerializer.writeValue(jSONSerializer, obj4);
                                                                    } else if (obj4 == null) {
                                                                        serializeWriter.writeNull();
                                                                    } else if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) != 0) {
                                                                        String str6 = ((Enum) obj4).toString();
                                                                        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
                                                                            serializeWriter.writeStringWithSingleQuote(str6);
                                                                        } else {
                                                                            serializeWriter.writeStringWithDoubleQuote(str6, (char) 0, false);
                                                                        }
                                                                    } else {
                                                                        serializeWriter.writeInt(((Enum) obj4).ordinal());
                                                                    }
                                                                    z24 = true;
                                                                    i11 = i23 + 1;
                                                                    z22 = z25;
                                                                    z12 = z26;
                                                                    list10 = list6;
                                                                    list8 = list5;
                                                                    list9 = list4;
                                                                    list7 = list3;
                                                                    z23 = z13;
                                                                } else if (cls == Integer.TYPE) {
                                                                    int i31 = i14;
                                                                    if (i31 == Integer.MIN_VALUE) {
                                                                        serializeWriter.write("-2147483648");
                                                                    } else {
                                                                        int i32 = 0;
                                                                        while ((i31 < 0 ? -i31 : i31) > SerializeWriter.sizeTable[i32]) {
                                                                            i32++;
                                                                        }
                                                                        int i33 = i32 + 1;
                                                                        if (i31 < 0) {
                                                                            i33++;
                                                                        }
                                                                        int i34 = serializeWriter.count + i33;
                                                                        if (i34 > serializeWriter.buf.length) {
                                                                            if (serializeWriter.writer == null) {
                                                                                serializeWriter.expandCapacity(i34);
                                                                            } else {
                                                                                char[] cArr3 = new char[i33];
                                                                                SerializeWriter.getChars(i31, i33, cArr3);
                                                                                serializeWriter.write(cArr3, 0, i33);
                                                                                z19 = true;
                                                                                if (!z19) {
                                                                                    SerializeWriter.getChars(i31, i34, serializeWriter.buf);
                                                                                    serializeWriter.count = i34;
                                                                                }
                                                                            }
                                                                        }
                                                                        z19 = false;
                                                                        if (!z19) {
                                                                        }
                                                                    }
                                                                } else if (cls == Long.TYPE) {
                                                                    jSONSerializer.out.writeLong(j10);
                                                                } else if (cls == Boolean.TYPE) {
                                                                    if (z15) {
                                                                        SerializeWriter serializeWriter2 = jSONSerializer.out;
                                                                        char[] cArr4 = true_chars;
                                                                        serializeWriter2.write(cArr4, 0, cArr4.length);
                                                                    } else {
                                                                        SerializeWriter serializeWriter3 = jSONSerializer.out;
                                                                        char[] cArr5 = false_chars;
                                                                        serializeWriter3.write(cArr5, 0, cArr5.length);
                                                                    }
                                                                }
                                                            }
                                                            z24 = true;
                                                            i11 = i23 + 1;
                                                            z22 = z25;
                                                            z12 = z26;
                                                            list10 = list6;
                                                            list8 = list5;
                                                            list9 = list4;
                                                            list7 = list3;
                                                            z23 = z13;
                                                        }
                                                        z13 = z23;
                                                        i11 = i23 + 1;
                                                        z22 = z25;
                                                        z12 = z26;
                                                        list10 = list6;
                                                        list8 = list5;
                                                        list9 = list4;
                                                        list7 = list3;
                                                        z23 = z13;
                                                    }
                                                } else {
                                                    obj4 = fieldSerializer.getPropertyValue(obj);
                                                }
                                                j10 = 0;
                                                z17 = false;
                                                z16 = true;
                                                i14 = 0;
                                                z15 = false;
                                                if (list7 == null) {
                                                }
                                                z18 = true;
                                                if (z18) {
                                                }
                                            }
                                        }
                                        list4 = list9;
                                        list6 = list10;
                                        list5 = list8;
                                        list3 = list7;
                                        z13 = z23;
                                        i11 = i23 + 1;
                                        z22 = z25;
                                        z12 = z26;
                                        list10 = list6;
                                        list8 = list5;
                                        list9 = list4;
                                        list7 = list3;
                                        z23 = z13;
                                    } catch (Exception e13) {
                                        e10 = e13;
                                        serialContext = serialContext3;
                                        String str22 = "write javaBean error";
                                        if (obj2 != null) {
                                            try {
                                                str22 = str22 + ", fieldName : " + obj2;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                th2 = th;
                                                jSONSerializer.context = serialContext;
                                                throw th2;
                                            }
                                        }
                                        throw new JSONException(str22, e10);
                                    } catch (Throwable th5) {
                                        th2 = th5;
                                        serialContext = serialContext3;
                                        jSONSerializer.context = serialContext;
                                        throw th2;
                                    }
                                } catch (Exception e14) {
                                    e11 = e14;
                                    serialContext = serialContext3;
                                    e10 = e11;
                                    String str222 = "write javaBean error";
                                    if (obj2 != null) {
                                    }
                                    throw new JSONException(str222, e10);
                                } catch (Throwable th6) {
                                    th = th6;
                                    serialContext = serialContext3;
                                    th2 = th;
                                    jSONSerializer.context = serialContext;
                                    throw th2;
                                }
                            }
                            fieldSerializerArr2 = fieldSerializerArr;
                            char c13 = c11;
                            char c14 = 0;
                            c14 = ',';
                            list2 = jSONSerializer.afterFilters;
                            if (list2 != null) {
                                if (z24) {
                                }
                                for (AfterFilter afterFilter : list2) {
                                    c14 = afterFilter.writeAfter(jSONSerializer, obj, c14);
                                }
                            }
                            if (fieldSerializerArr2.length > 0 && (serializeWriter.features & SerializerFeature.PrettyFormat.mask) != 0) {
                                jSONSerializer.decrementIdent();
                                jSONSerializer.println();
                            }
                            i12 = serializeWriter.count + 1;
                            if (i12 > serializeWriter.buf.length) {
                                if (serializeWriter.writer == null) {
                                    serializeWriter.expandCapacity(i12);
                                } else {
                                    serializeWriter.flush();
                                    i13 = 1;
                                    serializeWriter.buf[serializeWriter.count] = c13;
                                    serializeWriter.count = i13;
                                    jSONSerializer.context = serialContext3;
                                }
                            }
                            i13 = i12;
                            serializeWriter.buf[serializeWriter.count] = c13;
                            serializeWriter.count = i13;
                            jSONSerializer.context = serialContext3;
                        }
                    }
                    z12 = false;
                    if ((SerializerFeature.UseSingleQuotes.mask & i10) != 0) {
                    }
                    if ((SerializerFeature.NotWriteDefaultValue.mask & i10) != 0) {
                    }
                    List<PropertyFilter> list72 = jSONSerializer.propertyFilters;
                    List<NameFilter> list82 = jSONSerializer.nameFilters;
                    List<ValueFilter> list92 = jSONSerializer.valueFilters;
                    boolean z242 = z21;
                    List<PropertyPreFilter> list102 = jSONSerializer.propertyPreFilters;
                    i11 = 0;
                    while (i11 < fieldSerializerArr.length) {
                    }
                    fieldSerializerArr2 = fieldSerializerArr;
                    char c132 = c11;
                    char c142 = 0;
                    c142 = ',';
                    list2 = jSONSerializer.afterFilters;
                    if (list2 != null) {
                    }
                    if (fieldSerializerArr2.length > 0) {
                        jSONSerializer.decrementIdent();
                        jSONSerializer.println();
                    }
                    i12 = serializeWriter.count + 1;
                    if (i12 > serializeWriter.buf.length) {
                    }
                    i13 = i12;
                    serializeWriter.buf[serializeWriter.count] = c132;
                    serializeWriter.count = i13;
                    jSONSerializer.context = serialContext3;
                }
            }
            z10 = true;
            if (z10) {
            }
            z11 = false;
            if (!z11) {
            }
            list = jSONSerializer.beforeFilters;
            if (list != null) {
            }
            if (c12 != ',') {
            }
            i10 = serializeWriter.features;
            if ((SerializerFeature.QuoteFieldNames.mask & i10) != 0) {
            }
            z12 = false;
            if ((SerializerFeature.UseSingleQuotes.mask & i10) != 0) {
            }
            if ((SerializerFeature.NotWriteDefaultValue.mask & i10) != 0) {
            }
            List<PropertyFilter> list722 = jSONSerializer.propertyFilters;
            List<NameFilter> list822 = jSONSerializer.nameFilters;
            List<ValueFilter> list922 = jSONSerializer.valueFilters;
            boolean z2422 = z21;
            List<PropertyPreFilter> list1022 = jSONSerializer.propertyPreFilters;
            i11 = 0;
            while (i11 < fieldSerializerArr.length) {
            }
            fieldSerializerArr2 = fieldSerializerArr;
            char c1322 = c11;
            char c1422 = 0;
            c1422 = ',';
            list2 = jSONSerializer.afterFilters;
            if (list2 != null) {
            }
            if (fieldSerializerArr2.length > 0) {
            }
            i12 = serializeWriter.count + 1;
            if (i12 > serializeWriter.buf.length) {
            }
            i13 = i12;
            serializeWriter.buf[serializeWriter.count] = c1322;
            serializeWriter.count = i13;
            jSONSerializer.context = serialContext3;
        } catch (Exception e15) {
            e11 = e15;
            serialContext = serialContext3;
        } catch (Throwable th7) {
            th = th7;
            serialContext = serialContext3;
        }
    }

    public JavaBeanSerializer(Class<?> cls, PropertyNamingStrategy propertyNamingStrategy) {
        this(cls, cls.getModifiers(), null, false, true, true, true, propertyNamingStrategy);
    }

    public JavaBeanSerializer(Class<?> cls, String... strArr) {
        this(cls, cls.getModifiers(), map(strArr), false, true, true, true, null);
    }

    public JavaBeanSerializer(Class<?> cls, int i10, Map<String, String> map, boolean z10, boolean z11, boolean z12, boolean z13, PropertyNamingStrategy propertyNamingStrategy) {
        this.features = 0;
        String[] strArr = null;
        JSONType jSONType = z11 ? (JSONType) cls.getAnnotation(JSONType.class) : null;
        if (jSONType != null) {
            this.features = SerializerFeature.of(jSONType.serialzeFeatures());
            String typeName = jSONType.typeName();
            this.typeName = typeName;
            if (typeName.length() == 0) {
                this.typeName = null;
            }
        }
        List<FieldInfo> computeGetters = TypeUtils.computeGetters(cls, i10, z10, jSONType, map, false, z12, z13, propertyNamingStrategy);
        ArrayList arrayList = new ArrayList();
        for (FieldInfo fieldInfo : computeGetters) {
            arrayList.add(new FieldSerializer(fieldInfo));
        }
        FieldSerializer[] fieldSerializerArr = (FieldSerializer[]) arrayList.toArray(new FieldSerializer[arrayList.size()]);
        this.getters = fieldSerializerArr;
        strArr = jSONType != null ? jSONType.orders() : strArr;
        if (strArr == null || strArr.length == 0) {
            FieldSerializer[] fieldSerializerArr2 = new FieldSerializer[fieldSerializerArr.length];
            System.arraycopy(fieldSerializerArr, 0, fieldSerializerArr2, 0, fieldSerializerArr.length);
            Arrays.sort(fieldSerializerArr2);
            if (Arrays.equals(fieldSerializerArr2, fieldSerializerArr)) {
                this.sortedGetters = fieldSerializerArr;
            } else {
                this.sortedGetters = fieldSerializerArr2;
            }
        } else {
            List<FieldInfo> computeGetters2 = TypeUtils.computeGetters(cls, i10, z10, jSONType, map, true, z12, z13, propertyNamingStrategy);
            ArrayList arrayList2 = new ArrayList();
            for (FieldInfo fieldInfo2 : computeGetters2) {
                arrayList2.add(new FieldSerializer(fieldInfo2));
            }
            this.sortedGetters = (FieldSerializer[]) arrayList2.toArray(new FieldSerializer[arrayList2.size()]);
        }
    }
}
