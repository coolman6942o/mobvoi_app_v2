package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.FieldTypeResolver;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.IntegerCodec;
import com.alibaba.fastjson.serializer.StringCodec;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class DefaultJSONParser implements Closeable {
    public static final int NONE = 0;
    public static final int NeedToResolve = 1;
    public static final int TypeNameRedirect = 2;
    public ParserConfig config;
    protected ParseContext contex;
    private ParseContext[] contextArray;
    private int contextArrayIndex;
    private DateFormat dateFormat;
    private String dateFormatPattern;
    protected List<ExtraProcessor> extraProcessors;
    protected List<ExtraTypeProvider> extraTypeProviders;
    public FieldTypeResolver fieldTypeResolver;
    public final JSONLexer lexer;
    public int resolveStatus;
    private List<ResolveTask> resolveTaskList;
    public final SymbolTable symbolTable;

    /* loaded from: classes.dex */
    public static class ResolveTask {
        private final ParseContext context;
        public FieldDeserializer fieldDeserializer;
        public ParseContext ownerContext;
        private final String referenceValue;

        public ResolveTask(ParseContext parseContext, String str) {
            this.context = parseContext;
            this.referenceValue = str;
        }
    }

    public DefaultJSONParser(String str) {
        this(str, ParserConfig.global, JSON.DEFAULT_PARSER_FEATURE);
    }

    public final void accept(int i10) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == i10) {
            jSONLexer.nextToken();
            return;
        }
        throw new JSONException("syntax error, expect " + JSONToken.name(i10) + ", actual " + JSONToken.name(this.lexer.token));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addResolveTask(ResolveTask resolveTask) {
        if (this.resolveTaskList == null) {
            this.resolveTaskList = new ArrayList(2);
        }
        this.resolveTaskList.add(resolveTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkListResolve(Collection collection) {
        if (collection instanceof List) {
            ResolveTask lastResolveTask = getLastResolveTask();
            lastResolveTask.fieldDeserializer = new ResolveFieldDeserializer(this, (List) collection, collection.size() - 1);
            lastResolveTask.ownerContext = this.contex;
            this.resolveStatus = 0;
            return;
        }
        ResolveTask lastResolveTask2 = getLastResolveTask();
        lastResolveTask2.fieldDeserializer = new ResolveFieldDeserializer(collection);
        lastResolveTask2.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkMapResolve(Map map, Object obj) {
        ResolveFieldDeserializer resolveFieldDeserializer = new ResolveFieldDeserializer(map, obj);
        ResolveTask lastResolveTask = getLastResolveTask();
        lastResolveTask.fieldDeserializer = resolveFieldDeserializer;
        lastResolveTask.ownerContext = this.contex;
        this.resolveStatus = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            JSONLexer jSONLexer = this.lexer;
            if (jSONLexer.token == 20) {
                jSONLexer.close();
                return;
            }
            throw new JSONException("not close json text, token : " + JSONToken.name(this.lexer.token));
        } catch (Throwable th2) {
            this.lexer.close();
            throw th2;
        }
    }

    public void config(Feature feature, boolean z10) {
        this.lexer.config(feature, z10);
    }

    public String getDateFomartPattern() {
        return this.dateFormatPattern;
    }

    public DateFormat getDateFormat() {
        if (this.dateFormat == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.dateFormatPattern, this.lexer.locale);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(this.lexer.timeZone);
        }
        return this.dateFormat;
    }

    public List<ExtraProcessor> getExtraProcessors() {
        if (this.extraProcessors == null) {
            this.extraProcessors = new ArrayList(2);
        }
        return this.extraProcessors;
    }

    public List<ExtraTypeProvider> getExtraTypeProviders() {
        if (this.extraTypeProviders == null) {
            this.extraTypeProviders = new ArrayList(2);
        }
        return this.extraTypeProviders;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ResolveTask getLastResolveTask() {
        List<ResolveTask> list = this.resolveTaskList;
        return list.get(list.size() - 1);
    }

    public void handleResovleTask(Object obj) {
        List<ResolveTask> list = this.resolveTaskList;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                ResolveTask resolveTask = this.resolveTaskList.get(i10);
                FieldDeserializer fieldDeserializer = resolveTask.fieldDeserializer;
                if (fieldDeserializer != null) {
                    ParseContext parseContext = resolveTask.ownerContext;
                    Object obj2 = null;
                    Object obj3 = parseContext != null ? parseContext.object : null;
                    String str = resolveTask.referenceValue;
                    if (str.startsWith("$")) {
                        for (int i11 = 0; i11 < this.contextArrayIndex; i11++) {
                            if (str.equals(this.contextArray[i11].toString())) {
                                obj2 = this.contextArray[i11].object;
                            }
                        }
                    } else {
                        obj2 = resolveTask.context.object;
                    }
                    fieldDeserializer.setValue(obj3, obj2);
                }
            }
        }
    }

    public Object parse() {
        return parse(null);
    }

    public <T> List<T> parseArray(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        parseArray((Class<?>) cls, (Collection) arrayList);
        return arrayList;
    }

    public Object parseArrayWithType(Type type) {
        JSONLexer jSONLexer = this.lexer;
        if (jSONLexer.token == 8) {
            jSONLexer.nextToken();
            return null;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 1) {
            Type type2 = actualTypeArguments[0];
            if (type2 instanceof Class) {
                ArrayList arrayList = new ArrayList();
                parseArray((Class) type2, (Collection) arrayList);
                return arrayList;
            } else if (type2 instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type2;
                Type type3 = wildcardType.getUpperBounds()[0];
                if (!Object.class.equals(type3)) {
                    ArrayList arrayList2 = new ArrayList();
                    parseArray((Class) type3, (Collection) arrayList2);
                    return arrayList2;
                } else if (wildcardType.getLowerBounds().length == 0) {
                    return parse();
                } else {
                    throw new JSONException("not support type : " + type);
                }
            } else {
                if (type2 instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type2;
                    Type[] bounds = typeVariable.getBounds();
                    if (bounds.length == 1) {
                        Type type4 = bounds[0];
                        if (type4 instanceof Class) {
                            ArrayList arrayList3 = new ArrayList();
                            parseArray((Class) type4, (Collection) arrayList3);
                            return arrayList3;
                        }
                    } else {
                        throw new JSONException("not support : " + typeVariable);
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ArrayList arrayList4 = new ArrayList();
                    parseArray((ParameterizedType) type2, arrayList4);
                    return arrayList4;
                }
                throw new JSONException("TODO : " + type);
            }
        } else {
            throw new JSONException("not support type " + type);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x0231, code lost:
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0238, code lost:
        if (r3.token != 13) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x023a, code lost:
        r3.nextToken(16);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x023d, code lost:
        r0 = r19.config.getDeserializer(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0245, code lost:
        if ((r0 instanceof com.alibaba.fastjson.parser.JavaBeanDeserializer) == false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0247, code lost:
        r16 = ((com.alibaba.fastjson.parser.JavaBeanDeserializer) r0).createInstance(r19, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0250, code lost:
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0252, code lost:
        if (r16 != null) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0256, code lost:
        if (r7 != java.lang.Cloneable.class) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0258, code lost:
        r16 = new java.util.HashMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0264, code lost:
        if ("java.util.Collections$EmptyMap".equals(r6) == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0266, code lost:
        r16 = java.util.Collections.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x026b, code lost:
        r16 = r7.newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x026f, code lost:
        if (r13 != false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0271, code lost:
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0273, code lost:
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0274, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x027c, code lost:
        throw new com.alibaba.fastjson.JSONException("create instance error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x027d, code lost:
        r19.resolveStatus = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0282, code lost:
        if (r19.contex == null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0286, code lost:
        if ((r21 instanceof java.lang.Integer) != false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0288, code lost:
        popContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x028f, code lost:
        if (r20.size() <= 0) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0291, code lost:
        r0 = com.alibaba.fastjson.util.TypeUtils.cast((java.lang.Object) r20, (java.lang.Class<java.lang.Object>) r7, r19.config);
        parseObject(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x029a, code lost:
        if (r13 != false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x029c, code lost:
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x029e, code lost:
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x029f, code lost:
        r0 = r19.config.getDeserializer(r7).deserialze(r19, r7, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02a9, code lost:
        if (r13 != false) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02ab, code lost:
        r19.contex = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02ad, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0201 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0332 A[Catch: all -> 0x0687, TRY_LEAVE, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x033c A[Catch: all -> 0x0687, TRY_ENTER, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0387 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x04a6 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04b5 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:298:0x04be A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:299:0x04c2 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:301:0x04c7 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x054f A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x04d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:423:0x056a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c7 A[Catch: all -> 0x0687, TryCatch #0 {all -> 0x0687, blocks: (B:20:0x0063, B:23:0x006d, B:26:0x0076, B:29:0x0089, B:31:0x0093, B:34:0x009b, B:35:0x00b9, B:39:0x00c1, B:42:0x00cc, B:43:0x00d2, B:49:0x00e5, B:51:0x00ef, B:52:0x00f2, B:55:0x00f7, B:56:0x010d, B:66:0x0120, B:67:0x0126, B:69:0x012b, B:70:0x0130, B:72:0x0138, B:73:0x013c, B:76:0x0142, B:77:0x015c, B:78:0x015d, B:79:0x0177, B:85:0x0181, B:88:0x0190, B:89:0x0196, B:90:0x01b4, B:91:0x01b5, B:93:0x01be, B:97:0x01c7, B:100:0x01d3, B:101:0x01d9, B:117:0x01f8, B:119:0x0201, B:120:0x0205, B:123:0x020c, B:125:0x0214, B:127:0x0226, B:128:0x0231, B:130:0x023a, B:131:0x023d, B:133:0x0247, B:138:0x0258, B:139:0x025e, B:141:0x0266, B:142:0x026b, B:147:0x0275, B:148:0x027c, B:149:0x027d, B:151:0x0284, B:153:0x0288, B:154:0x028b, B:156:0x0291, B:160:0x029f, B:166:0x02b3, B:168:0x02bb, B:170:0x02c2, B:172:0x02d1, B:174:0x02d5, B:176:0x02db, B:179:0x02e0, B:181:0x02e4, B:182:0x02e7, B:184:0x02ef, B:187:0x02f5, B:188:0x0301, B:191:0x030a, B:194:0x0310, B:197:0x0316, B:198:0x0322, B:200:0x032e, B:202:0x0332, B:206:0x033c, B:207:0x0354, B:208:0x0355, B:209:0x0371, B:212:0x0376, B:218:0x0387, B:220:0x038d, B:222:0x0399, B:223:0x039f, B:225:0x03a4, B:226:0x03a8, B:233:0x03b8, B:237:0x03c7, B:240:0x03d8, B:241:0x03de, B:243:0x03e7, B:248:0x03f4, B:249:0x03f7, B:251:0x0401, B:252:0x0405, B:253:0x0408, B:255:0x040c, B:263:0x0421, B:264:0x0439, B:267:0x043e, B:270:0x044b, B:271:0x0451, B:273:0x0462, B:274:0x046d, B:277:0x0476, B:279:0x047c, B:282:0x0482, B:284:0x048c, B:286:0x0494, B:290:0x04a6, B:293:0x04ae, B:294:0x04b0, B:296:0x04b5, B:298:0x04be, B:299:0x04c2, B:301:0x04c7, B:302:0x04ca, B:304:0x04d0, B:306:0x04d7, B:313:0x04e5, B:314:0x04fd, B:317:0x0504, B:319:0x0510, B:322:0x0523, B:324:0x052f, B:325:0x053c, B:329:0x0546, B:332:0x054f, B:335:0x055c, B:336:0x0562, B:339:0x056e, B:342:0x057b, B:343:0x0581, B:345:0x058a, B:348:0x0597, B:349:0x059d, B:352:0x05a8, B:355:0x05b5, B:356:0x05bb, B:359:0x05c6, B:362:0x05d3, B:363:0x05d9, B:364:0x05e0, B:366:0x05e5, B:370:0x05ef, B:371:0x0607, B:372:0x0608, B:374:0x0619, B:375:0x061d, B:377:0x0626, B:384:0x063c, B:385:0x0654, B:386:0x0655, B:387:0x066d, B:388:0x066e, B:389:0x0686), top: B:394:0x0063, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object parseObject(Map map, Object obj) {
        boolean z10;
        Map<String, Object> map2;
        boolean z11;
        String str;
        char c10;
        char c11;
        boolean z12;
        char c12;
        boolean z13;
        Object obj2;
        int i10;
        String str2;
        Object obj3;
        Object obj4;
        String str3;
        String str4;
        JSONLexer jSONLexer = this.lexer;
        int i11 = jSONLexer.token;
        if (i11 == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (i11 == 12 || i11 == 16) {
            if (map instanceof JSONObject) {
                map2 = ((JSONObject) map).getInnerMap();
                z10 = true;
            } else {
                map2 = null;
                z10 = false;
            }
            boolean z14 = (jSONLexer.features & Feature.AllowISO8601DateFormat.mask) != 0;
            boolean z15 = jSONLexer.disableCircularReferenceDetect;
            ParseContext parseContext = this.contex;
            boolean z16 = false;
            while (true) {
                try {
                    char c13 = jSONLexer.f6710ch;
                    if (!(c13 == '\"' || c13 == '}')) {
                        jSONLexer.skipWhitespace();
                        c13 = jSONLexer.f6710ch;
                    }
                    while (c13 == ',') {
                        jSONLexer.next();
                        jSONLexer.skipWhitespace();
                        c13 = jSONLexer.f6710ch;
                    }
                    char c14 = JSONLexer.EOI;
                    if (c13 == '\"') {
                        String scanSymbol = jSONLexer.scanSymbol(this.symbolTable, '\"');
                        str4 = scanSymbol;
                        if (jSONLexer.f6710ch != ':') {
                            jSONLexer.skipWhitespace();
                            if (jSONLexer.f6710ch == ':') {
                                str4 = scanSymbol;
                            } else {
                                throw new JSONException("expect ':' at " + jSONLexer.pos + ", name " + ((Object) scanSymbol));
                            }
                        }
                    } else if (c13 == '}') {
                        int i12 = jSONLexer.f6709bp + 1;
                        jSONLexer.f6709bp = i12;
                        if (i12 < jSONLexer.len) {
                            c14 = jSONLexer.text.charAt(i12);
                        }
                        jSONLexer.f6710ch = c14;
                        jSONLexer.f6712sp = 0;
                        jSONLexer.nextToken(16);
                        return map;
                    } else if (c13 == '\'') {
                        String scanSymbol2 = jSONLexer.scanSymbol(this.symbolTable, '\'');
                        if (jSONLexer.f6710ch != ':') {
                            jSONLexer.skipWhitespace();
                        }
                        if (jSONLexer.f6710ch == ':') {
                            str4 = scanSymbol2;
                        } else {
                            throw new JSONException("expect ':' at " + jSONLexer.pos);
                        }
                    } else if (c13 == 26) {
                        throw new JSONException("syntax error, " + jSONLexer.info());
                    } else if (c13 == ',') {
                        throw new JSONException("syntax error, " + jSONLexer.info());
                    } else if ((c13 < '0' || c13 > '9') && c13 != '-') {
                        if (!(c13 == '{' || c13 == '[')) {
                            String scanSymbolUnQuoted = jSONLexer.scanSymbolUnQuoted(this.symbolTable);
                            jSONLexer.skipWhitespace();
                            char c15 = jSONLexer.f6710ch;
                            str4 = scanSymbolUnQuoted;
                            if (c15 != ':') {
                                throw new JSONException("expect ':' at " + jSONLexer.f6709bp + ", actual " + c15);
                            } else if (z10) {
                                str4 = scanSymbolUnQuoted.toString();
                            }
                        }
                        jSONLexer.nextToken();
                        Object parse = parse();
                        Object obj5 = parse;
                        if (z10) {
                            obj5 = parse.toString();
                        }
                        z11 = true;
                        str = obj5;
                        if (z11) {
                            int i13 = jSONLexer.f6709bp + 1;
                            jSONLexer.f6709bp = i13;
                            c10 = i13 >= jSONLexer.len ? (char) 26 : jSONLexer.text.charAt(i13);
                            jSONLexer.f6710ch = c10;
                            while (c10 <= ' ') {
                                if (c10 != ' ' && c10 != '\n' && c10 != '\r' && c10 != '\t' && c10 != '\f') {
                                    if (c10 != '\b') {
                                        break;
                                    }
                                }
                                jSONLexer.next();
                                c10 = jSONLexer.f6710ch;
                            }
                        } else {
                            c10 = jSONLexer.f6710ch;
                        }
                        jSONLexer.f6712sp = 0;
                        if (str != JSON.DEFAULT_TYPE_KEY && !jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            String scanSymbol3 = jSONLexer.scanSymbol(this.symbolTable, '\"');
                            Class<?> loadClass = TypeUtils.loadClass(scanSymbol3, this.config.defaultClassLoader);
                            if (loadClass != null) {
                                break;
                            }
                            map.put(JSON.DEFAULT_TYPE_KEY, scanSymbol3);
                        } else if (str == "$ref" || jSONLexer.isEnabled(Feature.DisableSpecialKeyDetect)) {
                            if (!z15 || z16) {
                                c11 = '\"';
                            } else {
                                ParseContext context = setContext(this.contex, map, obj);
                                if (parseContext == null) {
                                    parseContext = context;
                                }
                                c11 = '\"';
                                z16 = true;
                            }
                            if (c10 != c11) {
                                String scanStringValue = jSONLexer.scanStringValue(c11);
                                String str5 = scanStringValue;
                                if (z14) {
                                    JSONLexer jSONLexer2 = new JSONLexer(scanStringValue);
                                    Date date = scanStringValue;
                                    if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                                        date = jSONLexer2.calendar.getTime();
                                    }
                                    jSONLexer2.close();
                                    str5 = date;
                                }
                                if (map2 != null) {
                                    map2.put(str, str5);
                                } else {
                                    map.put(str, str5);
                                }
                            } else if ((c10 < '0' || c10 > '9') && c10 != '-') {
                                if (c10 == '[') {
                                    jSONLexer.token = 14;
                                    int i14 = jSONLexer.f6709bp + 1;
                                    jSONLexer.f6709bp = i14;
                                    jSONLexer.f6710ch = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                                    ArrayList arrayList = new ArrayList();
                                    if (!(obj != null && obj.getClass() == Integer.class)) {
                                        setContext(parseContext);
                                    }
                                    parseArray(arrayList, str);
                                    JSONArray jSONArray = new JSONArray(arrayList);
                                    if (map2 != null) {
                                        map2.put(str, jSONArray);
                                    } else {
                                        map.put(str, jSONArray);
                                    }
                                    int i15 = jSONLexer.token;
                                    if (i15 == 13) {
                                        jSONLexer.nextToken(16);
                                        if (!z15) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    } else if (i15 == 16) {
                                        z12 = z10;
                                    } else {
                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                    }
                                } else if (c10 == '{') {
                                    int i16 = jSONLexer.f6709bp + 1;
                                    jSONLexer.f6709bp = i16;
                                    jSONLexer.f6710ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
                                    jSONLexer.token = 12;
                                    boolean z17 = obj instanceof Integer;
                                    Map jSONObject = (Feature.OrderedField.mask & jSONLexer.features) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject();
                                    ParseContext context2 = (z15 || z17) ? null : setContext(parseContext, jSONObject, str);
                                    if (this.fieldTypeResolver != null) {
                                        if (str != null) {
                                            str2 = str.toString();
                                            z12 = z10;
                                        } else {
                                            z12 = z10;
                                            str2 = null;
                                        }
                                        Type resolve = this.fieldTypeResolver.resolve(map, str2);
                                        if (resolve != null) {
                                            obj2 = this.config.getDeserializer(resolve).deserialze(this, resolve, str);
                                            z13 = true;
                                            if (!z13) {
                                                obj2 = parseObject(jSONObject, str);
                                            }
                                            if (!(context2 == null || jSONObject == obj2)) {
                                                context2.object = map;
                                            }
                                            if (this.resolveStatus == 1) {
                                                checkMapResolve(map, str.toString());
                                            }
                                            if (map2 == null) {
                                                map2.put(str, obj2);
                                            } else {
                                                map.put(str, obj2);
                                            }
                                            if (z17) {
                                                setContext(parseContext, obj2, str);
                                            }
                                            i10 = jSONLexer.token;
                                            if (i10 != 13) {
                                                jSONLexer.nextToken(16);
                                                if (!z15) {
                                                    this.contex = parseContext;
                                                }
                                                if (!z15) {
                                                    this.contex = parseContext;
                                                }
                                                return map;
                                            } else if (i10 != 16) {
                                                throw new JSONException("syntax error, " + jSONLexer.info());
                                            }
                                        }
                                    } else {
                                        z12 = z10;
                                    }
                                    obj2 = null;
                                    z13 = false;
                                    if (!z13) {
                                    }
                                    if (context2 == null) {
                                        context2.object = map;
                                    }
                                    if (this.resolveStatus == 1) {
                                    }
                                    if (map2 == null) {
                                    }
                                    if (z17) {
                                    }
                                    i10 = jSONLexer.token;
                                    if (i10 != 13) {
                                    }
                                } else {
                                    z12 = z10;
                                    if (c10 == 't') {
                                        if (jSONLexer.text.startsWith("true", jSONLexer.f6709bp)) {
                                            jSONLexer.f6709bp += 3;
                                            jSONLexer.next();
                                            map.put(str, Boolean.TRUE);
                                        }
                                    } else if (c10 != 'f') {
                                        jSONLexer.nextToken();
                                        Object parse2 = parse();
                                        String str6 = str;
                                        if (map.getClass() == JSONObject.class) {
                                            str6 = str.toString();
                                        }
                                        map.put(str6, parse2);
                                        int i17 = jSONLexer.token;
                                        if (i17 == 13) {
                                            jSONLexer.nextToken(16);
                                            if (!z15) {
                                                this.contex = parseContext;
                                            }
                                            return map;
                                        }
                                        if (i17 != 16) {
                                            throw new JSONException("syntax error, " + jSONLexer.info());
                                        }
                                        z10 = z12;
                                    } else if (jSONLexer.text.startsWith("false", jSONLexer.f6709bp)) {
                                        jSONLexer.f6709bp += 4;
                                        jSONLexer.next();
                                        map.put(str, Boolean.FALSE);
                                    }
                                    c12 = jSONLexer.f6710ch;
                                    if (!(c12 == ',' || c12 == '}')) {
                                        jSONLexer.skipWhitespace();
                                        c12 = jSONLexer.f6710ch;
                                    }
                                    if (c12 == ',') {
                                        int i18 = jSONLexer.f6709bp + 1;
                                        jSONLexer.f6709bp = i18;
                                        jSONLexer.f6710ch = i18 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i18);
                                        z10 = z12;
                                    } else if (c12 == '}') {
                                        int i19 = jSONLexer.f6709bp + 1;
                                        jSONLexer.f6709bp = i19;
                                        char charAt = i19 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i19);
                                        jSONLexer.f6710ch = charAt;
                                        jSONLexer.f6712sp = 0;
                                        if (charAt == ',') {
                                            int i20 = jSONLexer.f6709bp + 1;
                                            jSONLexer.f6709bp = i20;
                                            jSONLexer.f6710ch = i20 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i20);
                                            jSONLexer.token = 16;
                                        } else if (charAt == '}') {
                                            int i21 = jSONLexer.f6709bp + 1;
                                            jSONLexer.f6709bp = i21;
                                            jSONLexer.f6710ch = i21 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i21);
                                            jSONLexer.token = 13;
                                        } else if (charAt == ']') {
                                            int i22 = jSONLexer.f6709bp + 1;
                                            jSONLexer.f6709bp = i22;
                                            jSONLexer.f6710ch = i22 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i22);
                                            jSONLexer.token = 15;
                                        } else {
                                            jSONLexer.nextToken();
                                        }
                                        if (!z15) {
                                            setContext(this.contex, map, obj);
                                        }
                                        if (!z15) {
                                            this.contex = parseContext;
                                        }
                                        return map;
                                    } else {
                                        throw new JSONException("syntax error, " + jSONLexer.info());
                                    }
                                }
                                z10 = z12;
                            } else {
                                map.put(str, jSONLexer.scanNumberValue());
                            }
                            z12 = z10;
                            c12 = jSONLexer.f6710ch;
                            if (c12 == ',') {
                                jSONLexer.skipWhitespace();
                                c12 = jSONLexer.f6710ch;
                            }
                            if (c12 == ',') {
                            }
                        } else {
                            jSONLexer.nextToken(4);
                            if (jSONLexer.token == 4) {
                                String stringVal = jSONLexer.stringVal();
                                jSONLexer.nextToken(13);
                                if ("@".equals(stringVal)) {
                                    ParseContext parseContext2 = this.contex;
                                    if (parseContext2 != null) {
                                        obj4 = parseContext2.object;
                                        if (!(obj4 instanceof Object[]) && !(obj4 instanceof Collection)) {
                                            ParseContext parseContext3 = parseContext2.parent;
                                            if (parseContext3 != null) {
                                                obj3 = parseContext3.object;
                                                if (jSONLexer.token != 13) {
                                                    jSONLexer.nextToken(16);
                                                    if (!z15) {
                                                        this.contex = parseContext;
                                                    }
                                                    return obj3;
                                                }
                                                throw new JSONException("syntax error, " + jSONLexer.info());
                                            }
                                        }
                                        obj3 = obj4;
                                        if (jSONLexer.token != 13) {
                                        }
                                    }
                                    obj3 = null;
                                    if (jSONLexer.token != 13) {
                                    }
                                } else {
                                    if ("..".equals(stringVal)) {
                                        obj4 = parseContext.object;
                                        if (obj4 == null) {
                                            addResolveTask(new ResolveTask(parseContext, stringVal));
                                            this.resolveStatus = 1;
                                        }
                                        obj3 = obj4;
                                        if (jSONLexer.token != 13) {
                                        }
                                    } else if ("$".equals(stringVal)) {
                                        ParseContext parseContext4 = parseContext;
                                        while (true) {
                                            ParseContext parseContext5 = parseContext4.parent;
                                            if (parseContext5 == null) {
                                                break;
                                            }
                                            parseContext4 = parseContext5;
                                        }
                                        Object obj6 = parseContext4.object;
                                        if (obj6 != null) {
                                            obj3 = obj6;
                                            if (jSONLexer.token != 13) {
                                            }
                                        } else {
                                            addResolveTask(new ResolveTask(parseContext4, stringVal));
                                            this.resolveStatus = 1;
                                        }
                                    } else {
                                        addResolveTask(new ResolveTask(parseContext, stringVal));
                                        this.resolveStatus = 1;
                                    }
                                    obj3 = null;
                                    if (jSONLexer.token != 13) {
                                    }
                                }
                            } else {
                                throw new JSONException("illegal ref, " + JSONToken.name(jSONLexer.token));
                            }
                        }
                    } else {
                        jSONLexer.f6712sp = 0;
                        jSONLexer.scanNumber();
                        try {
                            if (jSONLexer.token == 2) {
                                str3 = jSONLexer.integerValue();
                            } else {
                                str3 = jSONLexer.decimalValue(true);
                            }
                            if (z10) {
                                str3 = str3.toString();
                            }
                            if (jSONLexer.f6710ch == ':') {
                                str4 = str3;
                            } else {
                                throw new JSONException("parse number key error, " + jSONLexer.info());
                            }
                        } catch (NumberFormatException unused) {
                            throw new JSONException("parse number key error, " + jSONLexer.info());
                        }
                    }
                    z11 = false;
                    str = str4;
                    if (z11) {
                    }
                    jSONLexer.f6712sp = 0;
                    if (str != JSON.DEFAULT_TYPE_KEY) {
                    }
                    if (str == "$ref") {
                    }
                    if (!z15) {
                    }
                    c11 = '\"';
                    if (c10 != c11) {
                    }
                    z12 = z10;
                    c12 = jSONLexer.f6710ch;
                    if (c12 == ',') {
                    }
                    if (c12 == ',') {
                    }
                } finally {
                    if (!z15) {
                        this.contex = parseContext;
                    }
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i11) + ", " + jSONLexer.info());
        }
    }

    public String parseString() {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 4) {
            String stringVal = jSONLexer.stringVal();
            JSONLexer jSONLexer2 = this.lexer;
            char c10 = jSONLexer2.f6710ch;
            char c11 = JSONLexer.EOI;
            if (c10 == ',') {
                int i11 = jSONLexer2.f6709bp + 1;
                jSONLexer2.f6709bp = i11;
                if (i11 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i11);
                }
                jSONLexer2.f6710ch = c11;
                this.lexer.token = 16;
            } else if (c10 == ']') {
                int i12 = jSONLexer2.f6709bp + 1;
                jSONLexer2.f6709bp = i12;
                if (i12 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i12);
                }
                jSONLexer2.f6710ch = c11;
                this.lexer.token = 15;
            } else if (c10 == '}') {
                int i13 = jSONLexer2.f6709bp + 1;
                jSONLexer2.f6709bp = i13;
                if (i13 < jSONLexer2.len) {
                    c11 = jSONLexer2.text.charAt(i13);
                }
                jSONLexer2.f6710ch = c11;
                this.lexer.token = 13;
            } else {
                jSONLexer2.nextToken();
            }
            return stringVal;
        } else if (i10 == 2) {
            String numberString = jSONLexer.numberString();
            this.lexer.nextToken(16);
            return numberString;
        } else {
            Object parse = parse();
            if (parse == null) {
                return null;
            }
            return parse.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void popContext() {
        this.contex = this.contex.parent;
        ParseContext[] parseContextArr = this.contextArray;
        int i10 = this.contextArrayIndex;
        parseContextArr[i10 - 1] = null;
        this.contextArrayIndex = i10 - 1;
    }

    public void setContext(ParseContext parseContext) {
        if (!this.lexer.disableCircularReferenceDetect) {
            this.contex = parseContext;
        }
    }

    public void setDateFomrat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDateFormat(String str) {
        this.dateFormatPattern = str;
        this.dateFormat = null;
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig) {
        this(new JSONLexer(str, JSON.DEFAULT_PARSER_FEATURE), parserConfig);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object parse(Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 != 2) {
            boolean z10 = true;
            if (i10 == 3) {
                if ((jSONLexer.features & Feature.UseBigDecimal.mask) == 0) {
                    z10 = false;
                }
                Number decimalValue = jSONLexer.decimalValue(z10);
                this.lexer.nextToken();
                return decimalValue;
            } else if (i10 == 4) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken(16);
                if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                    JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                    try {
                        if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                            return jSONLexer2.calendar.getTime();
                        }
                    } finally {
                        jSONLexer2.close();
                    }
                }
                return stringVal;
            } else if (i10 == 12) {
                return parseObject((jSONLexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), obj);
            } else if (i10 != 14) {
                switch (i10) {
                    case 6:
                        jSONLexer.nextToken(16);
                        return Boolean.TRUE;
                    case 7:
                        jSONLexer.nextToken(16);
                        return Boolean.FALSE;
                    case 8:
                        break;
                    case 9:
                        jSONLexer.nextToken(18);
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 18) {
                            jSONLexer3.nextToken(10);
                            accept(10);
                            long longValue = this.lexer.integerValue().longValue();
                            accept(2);
                            accept(11);
                            return new Date(longValue);
                        }
                        throw new JSONException("syntax error, " + this.lexer.info());
                    default:
                        switch (i10) {
                            case 20:
                                if (jSONLexer.isBlankInput()) {
                                    return null;
                                }
                                throw new JSONException("syntax error, " + this.lexer.info());
                            case 21:
                                jSONLexer.nextToken();
                                HashSet hashSet = new HashSet();
                                parseArray(hashSet, obj);
                                return hashSet;
                            case 22:
                                jSONLexer.nextToken();
                                TreeSet treeSet = new TreeSet();
                                parseArray(treeSet, obj);
                                return treeSet;
                            case 23:
                                break;
                            default:
                                throw new JSONException("syntax error, " + this.lexer.info());
                        }
                }
                jSONLexer.nextToken();
                return null;
            } else {
                JSONArray jSONArray = new JSONArray();
                parseArray(jSONArray, obj);
                return jSONArray;
            }
        } else {
            Number integerValue = jSONLexer.integerValue();
            this.lexer.nextToken();
            return integerValue;
        }
    }

    public DefaultJSONParser(String str, ParserConfig parserConfig, int i10) {
        this(new JSONLexer(str, i10), parserConfig);
    }

    public void parseArray(Class<?> cls, Collection collection) {
        parseArray((Type) cls, collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ParseContext setContext(ParseContext parseContext, Object obj, Object obj2) {
        if (this.lexer.disableCircularReferenceDetect) {
            return null;
        }
        this.contex = new ParseContext(parseContext, obj, obj2);
        int i10 = this.contextArrayIndex;
        this.contextArrayIndex = i10 + 1;
        ParseContext[] parseContextArr = this.contextArray;
        if (parseContextArr == null) {
            this.contextArray = new ParseContext[8];
        } else if (i10 >= parseContextArr.length) {
            ParseContext[] parseContextArr2 = new ParseContext[(parseContextArr.length * 3) / 2];
            System.arraycopy(parseContextArr, 0, parseContextArr2, 0, parseContextArr.length);
            this.contextArray = parseContextArr2;
        }
        ParseContext[] parseContextArr3 = this.contextArray;
        ParseContext parseContext2 = this.contex;
        parseContextArr3[i10] = parseContext2;
        return parseContext2;
    }

    public DefaultJSONParser(char[] cArr, int i10, ParserConfig parserConfig, int i11) {
        this(new JSONLexer(cArr, i10, i11), parserConfig);
    }

    public void parseArray(Type type, Collection collection) {
        parseArray(type, collection, null);
    }

    public DefaultJSONParser(JSONLexer jSONLexer) {
        this(jSONLexer, ParserConfig.global);
    }

    /* JADX WARN: Finally extract failed */
    public void parseArray(Type type, Collection collection, Object obj) {
        ObjectDeserializer objectDeserializer;
        String str;
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 21 || i10 == 22) {
            jSONLexer.nextToken();
        }
        JSONLexer jSONLexer2 = this.lexer;
        if (jSONLexer2.token == 14) {
            if (Integer.TYPE == type) {
                objectDeserializer = IntegerCodec.instance;
                jSONLexer2.nextToken(2);
            } else if (String.class == type) {
                objectDeserializer = StringCodec.instance;
                jSONLexer2.nextToken(4);
            } else {
                objectDeserializer = this.config.getDeserializer(type);
                this.lexer.nextToken(12);
            }
            ParseContext parseContext = this.contex;
            if (!this.lexer.disableCircularReferenceDetect) {
                setContext(parseContext, collection, obj);
            }
            int i11 = 0;
            while (true) {
                try {
                    JSONLexer jSONLexer3 = this.lexer;
                    int i12 = jSONLexer3.token;
                    if (i12 == 16) {
                        jSONLexer3.nextToken();
                    } else if (i12 == 15) {
                        this.contex = parseContext;
                        jSONLexer3.nextToken(16);
                        return;
                    } else {
                        Object obj2 = null;
                        String str2 = null;
                        if (Integer.TYPE == type) {
                            collection.add(IntegerCodec.instance.deserialze(this, null, null));
                        } else if (String.class == type) {
                            if (i12 == 4) {
                                str = jSONLexer3.stringVal();
                                this.lexer.nextToken(16);
                            } else {
                                Object parse = parse();
                                if (parse != null) {
                                    str2 = parse.toString();
                                }
                                str = str2;
                            }
                            collection.add(str);
                        } else {
                            if (i12 == 8) {
                                jSONLexer3.nextToken();
                            } else {
                                obj2 = objectDeserializer.deserialze(this, type, Integer.valueOf(i11));
                            }
                            collection.add(obj2);
                            if (this.resolveStatus == 1) {
                                checkListResolve(collection);
                            }
                        }
                        JSONLexer jSONLexer4 = this.lexer;
                        if (jSONLexer4.token == 16) {
                            jSONLexer4.nextToken();
                        }
                        i11++;
                    }
                } catch (Throwable th2) {
                    this.contex = parseContext;
                    throw th2;
                }
            }
        } else {
            throw new JSONException("exepct '[', but " + JSONToken.name(this.lexer.token) + ", " + this.lexer.info());
        }
    }

    public DefaultJSONParser(JSONLexer jSONLexer, ParserConfig parserConfig) {
        this.dateFormatPattern = JSON.DEFFAULT_DATE_FORMAT;
        this.contextArrayIndex = 0;
        this.resolveStatus = 0;
        this.extraTypeProviders = null;
        this.extraProcessors = null;
        this.fieldTypeResolver = null;
        this.lexer = jSONLexer;
        this.config = parserConfig;
        this.symbolTable = parserConfig.symbolTable;
        char c10 = jSONLexer.f6710ch;
        char c11 = JSONLexer.EOI;
        if (c10 == '{') {
            int i10 = jSONLexer.f6709bp + 1;
            jSONLexer.f6709bp = i10;
            jSONLexer.f6710ch = i10 < jSONLexer.len ? jSONLexer.text.charAt(i10) : c11;
            jSONLexer.token = 12;
        } else if (c10 == '[') {
            int i11 = jSONLexer.f6709bp + 1;
            jSONLexer.f6709bp = i11;
            jSONLexer.f6710ch = i11 < jSONLexer.len ? jSONLexer.text.charAt(i11) : c11;
            jSONLexer.token = 14;
        } else {
            jSONLexer.nextToken();
        }
    }

    public Object[] parseArray(Type[] typeArr) {
        Object obj;
        boolean z10;
        Class<?> cls;
        int i10;
        JSONLexer jSONLexer = this.lexer;
        int i11 = jSONLexer.token;
        int i12 = 8;
        if (i11 == 8) {
            jSONLexer.nextToken(16);
            return null;
        } else if (i11 == 14) {
            Object[] objArr = new Object[typeArr.length];
            if (typeArr.length == 0) {
                jSONLexer.nextToken(15);
                JSONLexer jSONLexer2 = this.lexer;
                if (jSONLexer2.token == 15) {
                    jSONLexer2.nextToken(16);
                    return new Object[0];
                }
                throw new JSONException("syntax error, " + this.lexer.info());
            }
            jSONLexer.nextToken(2);
            int i13 = 0;
            while (i13 < typeArr.length) {
                JSONLexer jSONLexer3 = this.lexer;
                int i14 = jSONLexer3.token;
                if (i14 == i12) {
                    jSONLexer3.nextToken(16);
                    obj = null;
                } else {
                    Type type = typeArr[i13];
                    if (type == Integer.TYPE || type == Integer.class) {
                        if (i14 == 2) {
                            obj = Integer.valueOf(jSONLexer3.intValue());
                            this.lexer.nextToken(16);
                        } else {
                            obj = TypeUtils.cast(parse(), type, this.config);
                        }
                    } else if (type != String.class) {
                        if (i13 != typeArr.length - 1 || !(type instanceof Class)) {
                            cls = null;
                            z10 = false;
                        } else {
                            Class cls2 = (Class) type;
                            z10 = cls2.isArray();
                            cls = cls2.getComponentType();
                        }
                        if (!z10 || this.lexer.token == 14) {
                            obj = this.config.getDeserializer(type).deserialze(this, type, null);
                        } else {
                            ArrayList arrayList = new ArrayList();
                            ObjectDeserializer deserializer = this.config.getDeserializer(cls);
                            if (this.lexer.token != 15) {
                                while (true) {
                                    arrayList.add(deserializer.deserialze(this, type, null));
                                    JSONLexer jSONLexer4 = this.lexer;
                                    i10 = jSONLexer4.token;
                                    if (i10 != 16) {
                                        break;
                                    }
                                    jSONLexer4.nextToken(12);
                                }
                                if (i10 != 15) {
                                    throw new JSONException("syntax error, " + this.lexer.info());
                                }
                            }
                            obj = TypeUtils.cast(arrayList, type, this.config);
                        }
                    } else if (i14 == 4) {
                        obj = jSONLexer3.stringVal();
                        this.lexer.nextToken(16);
                    } else {
                        obj = TypeUtils.cast(parse(), type, this.config);
                    }
                }
                objArr[i13] = obj;
                JSONLexer jSONLexer5 = this.lexer;
                int i15 = jSONLexer5.token;
                if (i15 == 15) {
                    break;
                } else if (i15 == 16) {
                    if (i13 == typeArr.length - 1) {
                        jSONLexer5.nextToken(15);
                    } else {
                        jSONLexer5.nextToken(2);
                    }
                    i13++;
                    i12 = 8;
                } else {
                    throw new JSONException("syntax error, " + this.lexer.info());
                }
            }
            JSONLexer jSONLexer6 = this.lexer;
            if (jSONLexer6.token == 15) {
                jSONLexer6.nextToken(16);
                return objArr;
            }
            throw new JSONException("syntax error, " + this.lexer.info());
        } else {
            throw new JSONException("syntax error, " + this.lexer.info());
        }
    }

    public final void parseArray(Collection collection) {
        parseArray(collection, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d6 A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:23:0x0057, B:24:0x005d, B:25:0x0064, B:27:0x0069, B:30:0x0074, B:33:0x007b, B:35:0x0081, B:37:0x008d, B:40:0x0099, B:41:0x009f, B:43:0x00a8, B:46:0x00b0, B:48:0x00b9, B:51:0x00c5, B:52:0x00cb, B:54:0x00d4, B:55:0x00d7, B:59:0x00e1, B:60:0x00e4, B:62:0x00ea, B:83:0x0119, B:85:0x0121, B:89:0x012b, B:90:0x0138, B:91:0x0140, B:92:0x0147, B:93:0x0148, B:95:0x0155, B:96:0x0160, B:97:0x0165, B:98:0x016e, B:99:0x0176, B:100:0x0180, B:101:0x018a, B:103:0x01a2, B:105:0x01ad, B:106:0x01b3, B:107:0x01b8, B:109:0x01c5, B:110:0x01cb, B:111:0x01d0, B:112:0x01d6, B:113:0x01e4, B:115:0x01eb, B:116:0x01ee, B:118:0x01f4, B:120:0x01f8, B:125:0x0208, B:128:0x0214, B:131:0x0222, B:132:0x0228, B:133:0x022b), top: B:141:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01eb A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:23:0x0057, B:24:0x005d, B:25:0x0064, B:27:0x0069, B:30:0x0074, B:33:0x007b, B:35:0x0081, B:37:0x008d, B:40:0x0099, B:41:0x009f, B:43:0x00a8, B:46:0x00b0, B:48:0x00b9, B:51:0x00c5, B:52:0x00cb, B:54:0x00d4, B:55:0x00d7, B:59:0x00e1, B:60:0x00e4, B:62:0x00ea, B:83:0x0119, B:85:0x0121, B:89:0x012b, B:90:0x0138, B:91:0x0140, B:92:0x0147, B:93:0x0148, B:95:0x0155, B:96:0x0160, B:97:0x0165, B:98:0x016e, B:99:0x0176, B:100:0x0180, B:101:0x018a, B:103:0x01a2, B:105:0x01ad, B:106:0x01b3, B:107:0x01b8, B:109:0x01c5, B:110:0x01cb, B:111:0x01d0, B:112:0x01d6, B:113:0x01e4, B:115:0x01eb, B:116:0x01ee, B:118:0x01f4, B:120:0x01f8, B:125:0x0208, B:128:0x0214, B:131:0x0222, B:132:0x0228, B:133:0x022b), top: B:141:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f4 A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:23:0x0057, B:24:0x005d, B:25:0x0064, B:27:0x0069, B:30:0x0074, B:33:0x007b, B:35:0x0081, B:37:0x008d, B:40:0x0099, B:41:0x009f, B:43:0x00a8, B:46:0x00b0, B:48:0x00b9, B:51:0x00c5, B:52:0x00cb, B:54:0x00d4, B:55:0x00d7, B:59:0x00e1, B:60:0x00e4, B:62:0x00ea, B:83:0x0119, B:85:0x0121, B:89:0x012b, B:90:0x0138, B:91:0x0140, B:92:0x0147, B:93:0x0148, B:95:0x0155, B:96:0x0160, B:97:0x0165, B:98:0x016e, B:99:0x0176, B:100:0x0180, B:101:0x018a, B:103:0x01a2, B:105:0x01ad, B:106:0x01b3, B:107:0x01b8, B:109:0x01c5, B:110:0x01cb, B:111:0x01d0, B:112:0x01d6, B:113:0x01e4, B:115:0x01eb, B:116:0x01ee, B:118:0x01f4, B:120:0x01f8, B:125:0x0208, B:128:0x0214, B:131:0x0222, B:132:0x0228, B:133:0x022b), top: B:141:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x022e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b A[Catch: all -> 0x0236, TryCatch #0 {all -> 0x0236, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:23:0x0057, B:24:0x005d, B:25:0x0064, B:27:0x0069, B:30:0x0074, B:33:0x007b, B:35:0x0081, B:37:0x008d, B:40:0x0099, B:41:0x009f, B:43:0x00a8, B:46:0x00b0, B:48:0x00b9, B:51:0x00c5, B:52:0x00cb, B:54:0x00d4, B:55:0x00d7, B:59:0x00e1, B:60:0x00e4, B:62:0x00ea, B:83:0x0119, B:85:0x0121, B:89:0x012b, B:90:0x0138, B:91:0x0140, B:92:0x0147, B:93:0x0148, B:95:0x0155, B:96:0x0160, B:97:0x0165, B:98:0x016e, B:99:0x0176, B:100:0x0180, B:101:0x018a, B:103:0x01a2, B:105:0x01ad, B:106:0x01b3, B:107:0x01b8, B:109:0x01c5, B:110:0x01cb, B:111:0x01d0, B:112:0x01d6, B:113:0x01e4, B:115:0x01eb, B:116:0x01ee, B:118:0x01f4, B:120:0x01f8, B:125:0x0208, B:128:0x0214, B:131:0x0222, B:132:0x0228, B:133:0x022b), top: B:141:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ea A[Catch: all -> 0x0236, LOOP:1: B:61:0x00e8->B:62:0x00ea, LOOP_END, TryCatch #0 {all -> 0x0236, blocks: (B:12:0x0028, B:15:0x003c, B:20:0x004b, B:23:0x0057, B:24:0x005d, B:25:0x0064, B:27:0x0069, B:30:0x0074, B:33:0x007b, B:35:0x0081, B:37:0x008d, B:40:0x0099, B:41:0x009f, B:43:0x00a8, B:46:0x00b0, B:48:0x00b9, B:51:0x00c5, B:52:0x00cb, B:54:0x00d4, B:55:0x00d7, B:59:0x00e1, B:60:0x00e4, B:62:0x00ea, B:83:0x0119, B:85:0x0121, B:89:0x012b, B:90:0x0138, B:91:0x0140, B:92:0x0147, B:93:0x0148, B:95:0x0155, B:96:0x0160, B:97:0x0165, B:98:0x016e, B:99:0x0176, B:100:0x0180, B:101:0x018a, B:103:0x01a2, B:105:0x01ad, B:106:0x01b3, B:107:0x01b8, B:109:0x01c5, B:110:0x01cb, B:111:0x01d0, B:112:0x01d6, B:113:0x01e4, B:115:0x01eb, B:116:0x01ee, B:118:0x01f4, B:120:0x01f8, B:125:0x0208, B:128:0x0214, B:131:0x0222, B:132:0x0228, B:133:0x022b), top: B:141:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void parseArray(Collection collection, Object obj) {
        boolean z10;
        int i10;
        int i11;
        Number number;
        JSONLexer jSONLexer;
        JSONObject jSONObject;
        JSONLexer jSONLexer2 = this.lexer;
        int i12 = jSONLexer2.token;
        if (i12 == 21 || i12 == 22) {
            jSONLexer2.nextToken();
            i12 = this.lexer.token;
        }
        if (i12 == 14) {
            boolean z11 = this.lexer.disableCircularReferenceDetect;
            ParseContext parseContext = this.contex;
            if (!z11) {
                setContext(parseContext, collection, obj);
            }
            try {
                JSONLexer jSONLexer3 = this.lexer;
                char c10 = jSONLexer3.f6710ch;
                if (c10 != '\"') {
                    if (c10 == ']') {
                        jSONLexer3.next();
                        this.lexer.nextToken(16);
                        if (z11) {
                            return;
                        }
                        return;
                    } else if (c10 == '{') {
                        int i13 = jSONLexer3.f6709bp + 1;
                        jSONLexer3.f6709bp = i13;
                        jSONLexer3.f6710ch = i13 >= jSONLexer3.len ? JSONLexer.EOI : jSONLexer3.text.charAt(i13);
                        this.lexer.token = 12;
                    } else {
                        jSONLexer3.nextToken(12);
                    }
                } else if ((jSONLexer3.features & Feature.AllowISO8601DateFormat.mask) == 0) {
                    z10 = true;
                    i10 = 0;
                    while (true) {
                        if (z10) {
                            JSONLexer jSONLexer4 = this.lexer;
                            if (jSONLexer4.f6710ch == '\"') {
                                String scanStringValue = jSONLexer4.scanStringValue('\"');
                                JSONLexer jSONLexer5 = this.lexer;
                                char c11 = jSONLexer5.f6710ch;
                                if (c11 == ',') {
                                    int i14 = jSONLexer5.f6709bp + 1;
                                    jSONLexer5.f6709bp = i14;
                                    char charAt = i14 >= jSONLexer5.len ? JSONLexer.EOI : jSONLexer5.text.charAt(i14);
                                    jSONLexer5.f6710ch = charAt;
                                    collection.add(scanStringValue);
                                    if (this.resolveStatus == 1) {
                                        checkListResolve(collection);
                                    }
                                    if (charAt == '\"') {
                                        i10++;
                                    } else {
                                        this.lexer.nextToken();
                                        z10 = false;
                                    }
                                } else if (c11 == ']') {
                                    int i15 = jSONLexer5.f6709bp + 1;
                                    jSONLexer5.f6709bp = i15;
                                    jSONLexer5.f6710ch = i15 >= jSONLexer5.len ? JSONLexer.EOI : jSONLexer5.text.charAt(i15);
                                    collection.add(scanStringValue);
                                    if (this.resolveStatus == 1) {
                                        checkListResolve(collection);
                                    }
                                    this.lexer.nextToken(16);
                                    if (!z11) {
                                        this.contex = parseContext;
                                        return;
                                    }
                                    return;
                                } else {
                                    jSONLexer5.nextToken();
                                }
                            }
                        }
                        i11 = this.lexer.token;
                        while (i11 == 16) {
                            this.lexer.nextToken();
                            i11 = this.lexer.token;
                        }
                        JSONArray jSONArray = null;
                        jSONArray = null;
                        if (i11 != 2) {
                            number = this.lexer.integerValue();
                            this.lexer.nextToken(16);
                        } else if (i11 != 3) {
                            if (i11 == 4) {
                                String stringVal = this.lexer.stringVal();
                                this.lexer.nextToken(16);
                                jSONArray = stringVal;
                                if ((this.lexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                                    JSONLexer jSONLexer6 = new JSONLexer(stringVal);
                                    Date date = stringVal;
                                    if (jSONLexer6.scanISO8601DateIfMatch(true)) {
                                        date = jSONLexer6.calendar.getTime();
                                    }
                                    jSONLexer6.close();
                                    jSONArray = date;
                                }
                            } else if (i11 == 6) {
                                Boolean bool = Boolean.TRUE;
                                this.lexer.nextToken(16);
                                jSONArray = bool;
                            } else if (i11 == 7) {
                                Boolean bool2 = Boolean.FALSE;
                                this.lexer.nextToken(16);
                                jSONArray = bool2;
                            } else if (i11 == 8) {
                                this.lexer.nextToken(4);
                            } else if (i11 == 12) {
                                if ((this.lexer.features & Feature.OrderedField.mask) != 0) {
                                    jSONObject = new JSONObject(new LinkedHashMap());
                                } else {
                                    jSONObject = new JSONObject();
                                }
                                jSONArray = parseObject(jSONObject, Integer.valueOf(i10));
                            } else if (i11 == 20) {
                                throw new JSONException("unclosed jsonArray");
                            } else if (i11 == 23) {
                                this.lexer.nextToken(4);
                            } else if (i11 == 14) {
                                JSONArray jSONArray2 = new JSONArray();
                                parseArray(jSONArray2, Integer.valueOf(i10));
                                jSONArray = jSONArray2;
                            } else if (i11 != 15) {
                                jSONArray = parse();
                            } else {
                                this.lexer.nextToken(16);
                                if (!z11) {
                                    this.contex = parseContext;
                                    return;
                                }
                                return;
                            }
                            number = jSONArray;
                        } else {
                            JSONLexer jSONLexer7 = this.lexer;
                            if ((jSONLexer7.features & Feature.UseBigDecimal.mask) != 0) {
                                number = jSONLexer7.decimalValue(true);
                            } else {
                                number = jSONLexer7.decimalValue(false);
                            }
                            this.lexer.nextToken(16);
                        }
                        collection.add(number);
                        if (this.resolveStatus == 1) {
                            checkListResolve(collection);
                        }
                        jSONLexer = this.lexer;
                        if (jSONLexer.token == 16) {
                            char c12 = jSONLexer.f6710ch;
                            if (c12 == '\"') {
                                jSONLexer.pos = jSONLexer.f6709bp;
                                jSONLexer.scanString();
                            } else if (c12 >= '0' && c12 <= '9') {
                                jSONLexer.pos = jSONLexer.f6709bp;
                                jSONLexer.scanNumber();
                            } else if (c12 == '{') {
                                jSONLexer.token = 12;
                                int i16 = jSONLexer.f6709bp + 1;
                                jSONLexer.f6709bp = i16;
                                jSONLexer.f6710ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
                            } else {
                                jSONLexer.nextToken();
                            }
                        }
                        i10++;
                    }
                } else {
                    jSONLexer3.nextToken(4);
                }
                z10 = false;
                i10 = 0;
                while (true) {
                    if (z10) {
                    }
                    i11 = this.lexer.token;
                    while (i11 == 16) {
                    }
                    JSONArray jSONArray3 = null;
                    jSONArray3 = null;
                    if (i11 != 2) {
                    }
                    collection.add(number);
                    if (this.resolveStatus == 1) {
                    }
                    jSONLexer = this.lexer;
                    if (jSONLexer.token == 16) {
                    }
                    i10++;
                }
            } finally {
                if (!z11) {
                    this.contex = parseContext;
                }
            }
        } else {
            throw new JSONException("syntax error, expect [, actual " + JSONToken.name(i12) + ", pos " + this.lexer.pos);
        }
    }

    public <T> T parseObject(Class<T> cls) {
        return (T) parseObject(cls, (Object) null);
    }

    public <T> T parseObject(Type type) {
        return (T) parseObject(type, (Object) null);
    }

    public <T> T parseObject(Type type, Object obj) {
        JSONLexer jSONLexer = this.lexer;
        int i10 = jSONLexer.token;
        if (i10 == 8) {
            jSONLexer.nextToken();
            return null;
        }
        if (i10 == 4) {
            if (type == byte[].class) {
                T t10 = (T) jSONLexer.bytesValue();
                this.lexer.nextToken();
                return t10;
            } else if (type == char[].class) {
                String stringVal = jSONLexer.stringVal();
                this.lexer.nextToken();
                return (T) stringVal.toCharArray();
            }
        }
        try {
            return (T) this.config.getDeserializer(type).deserialze(this, type, obj);
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public void parseObject(Object obj) {
        Object obj2;
        Class<?> cls = obj.getClass();
        ObjectDeserializer deserializer = this.config.getDeserializer(cls);
        JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
        int i10 = this.lexer.token;
        if (i10 == 12 || i10 == 16) {
            while (true) {
                String scanSymbol = this.lexer.scanSymbol(this.symbolTable);
                if (scanSymbol == null) {
                    JSONLexer jSONLexer = this.lexer;
                    int i11 = jSONLexer.token;
                    if (i11 == 13) {
                        jSONLexer.nextToken(16);
                        return;
                    } else if (i11 == 16) {
                        continue;
                    }
                }
                FieldDeserializer fieldDeserializer = javaBeanDeserializer != null ? javaBeanDeserializer.getFieldDeserializer(scanSymbol) : null;
                if (fieldDeserializer == null) {
                    JSONLexer jSONLexer2 = this.lexer;
                    if ((jSONLexer2.features & Feature.IgnoreNotMatch.mask) != 0) {
                        jSONLexer2.nextTokenWithChar(':');
                        parse();
                        JSONLexer jSONLexer3 = this.lexer;
                        if (jSONLexer3.token == 13) {
                            jSONLexer3.nextToken();
                            return;
                        }
                    } else {
                        throw new JSONException("setter not found, class " + cls.getName() + ", property " + scanSymbol);
                    }
                } else {
                    FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
                    Class<?> cls2 = fieldInfo.fieldClass;
                    Type type = fieldInfo.fieldType;
                    if (cls2 == Integer.TYPE) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = IntegerCodec.instance.deserialze(this, type, null);
                    } else if (cls2 == String.class) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = parseString();
                    } else if (cls2 == Long.TYPE) {
                        this.lexer.nextTokenWithChar(':');
                        obj2 = IntegerCodec.instance.deserialze(this, type, null);
                    } else {
                        ObjectDeserializer deserializer2 = this.config.getDeserializer(cls2, type);
                        this.lexer.nextTokenWithChar(':');
                        obj2 = deserializer2.deserialze(this, type, null);
                    }
                    fieldDeserializer.setValue(obj, obj2);
                    JSONLexer jSONLexer4 = this.lexer;
                    int i12 = jSONLexer4.token;
                    if (i12 != 16 && i12 == 13) {
                        jSONLexer4.nextToken(16);
                        return;
                    }
                }
            }
        } else {
            throw new JSONException("syntax error, expect {, actual " + JSONToken.name(i10));
        }
    }

    public Object parseObject(Map map) {
        return parseObject(map, (Object) null);
    }

    public JSONObject parseObject() {
        return (JSONObject) parseObject((this.lexer.features & Feature.OrderedField.mask) != 0 ? new JSONObject(new LinkedHashMap()) : new JSONObject(), (Object) null);
    }
}
