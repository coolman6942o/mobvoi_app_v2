package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes.dex */
public final class DateCodec implements ObjectSerializer, ObjectDeserializer {
    public static final DateCodec instance = new DateCodec();

    private DateCodec() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.util.Calendar, T] */
    protected <T> T cast(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2, String str) {
        DateFormat dateFormat;
        if (obj2 == 0) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return (T) new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str2 = (String) obj2;
            if (str2.length() == 0) {
                return null;
            }
            JSONLexer jSONLexer = new JSONLexer(str2);
            try {
                if (jSONLexer.scanISO8601DateIfMatch(false)) {
                    ?? r22 = (T) jSONLexer.calendar;
                    return type == Calendar.class ? r22 : (T) r22.getTime();
                }
                if (str != null) {
                    dateFormat = new SimpleDateFormat(str);
                } else {
                    dateFormat = defaultJSONParser.getDateFormat();
                }
                try {
                    return (T) dateFormat.parse(str2);
                } catch (ParseException unused) {
                    return (T) new Date(Long.parseLong(str2));
                }
            } finally {
                jSONLexer.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        Date date;
        char[] cArr;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            serializeWriter.writeNull();
        } else if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
            if (obj instanceof Calendar) {
                date = ((Calendar) obj).getTime();
            } else {
                date = (Date) obj;
            }
            if ((serializeWriter.features & SerializerFeature.WriteDateUseDateFormat.mask) != 0) {
                DateFormat dateFormat = jSONSerializer.getDateFormat();
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer.locale);
                    dateFormat.setTimeZone(jSONSerializer.timeZone);
                }
                serializeWriter.writeString(dateFormat.format(date));
                return;
            }
            long time = date.getTime();
            int i10 = serializeWriter.features;
            if ((SerializerFeature.UseISO8601DateFormat.mask & i10) != 0) {
                SerializerFeature serializerFeature = SerializerFeature.UseSingleQuotes;
                if ((i10 & serializerFeature.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
                Calendar calendar = Calendar.getInstance(jSONSerializer.timeZone, jSONSerializer.locale);
                calendar.setTimeInMillis(time);
                int i11 = calendar.get(1);
                int i12 = calendar.get(2) + 1;
                int i13 = calendar.get(5);
                int i14 = calendar.get(11);
                int i15 = calendar.get(12);
                int i16 = calendar.get(13);
                int i17 = calendar.get(14);
                if (i17 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    SerializeWriter.getChars(i17, 23, cArr);
                    SerializeWriter.getChars(i16, 19, cArr);
                    SerializeWriter.getChars(i15, 16, cArr);
                    SerializeWriter.getChars(i14, 13, cArr);
                    SerializeWriter.getChars(i13, 10, cArr);
                    SerializeWriter.getChars(i12, 7, cArr);
                    SerializeWriter.getChars(i11, 4, cArr);
                } else if (i16 == 0 && i15 == 0 && i14 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    SerializeWriter.getChars(i13, 10, cArr);
                    SerializeWriter.getChars(i12, 7, cArr);
                    SerializeWriter.getChars(i11, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    SerializeWriter.getChars(i16, 19, cArr);
                    SerializeWriter.getChars(i15, 16, cArr);
                    SerializeWriter.getChars(i14, 13, cArr);
                    SerializeWriter.getChars(i13, 10, cArr);
                    SerializeWriter.getChars(i12, 7, cArr);
                    SerializeWriter.getChars(i11, 4, cArr);
                }
                serializeWriter.write(cArr);
                if ((serializeWriter.features & serializerFeature.mask) != 0) {
                    serializeWriter.write(39);
                } else {
                    serializeWriter.write(34);
                }
            } else {
                serializeWriter.writeLong(time);
            }
        } else if (obj.getClass() == Date.class) {
            serializeWriter.write("new Date(");
            serializeWriter.writeLong(((Date) obj).getTime());
            serializeWriter.write(41);
        } else {
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeLong(((Date) obj).getTime());
            serializeWriter.write(125);
        }
    }

    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.Calendar, T] */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.Calendar, T] */
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, String str) {
        Object obj2;
        T t10;
        int i10;
        Long l10;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i11 = jSONLexer.token();
        if (i11 == 2) {
            Long valueOf = Long.valueOf(jSONLexer.longValue());
            jSONLexer.nextToken(16);
            l10 = valueOf;
        } else if (i11 == 4) {
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            l10 = stringVal;
            if ((jSONLexer.features & Feature.AllowISO8601DateFormat.mask) != 0) {
                JSONLexer jSONLexer2 = new JSONLexer(stringVal);
                Date date = stringVal;
                if (jSONLexer2.scanISO8601DateIfMatch(true)) {
                    ?? r12 = (T) jSONLexer2.calendar;
                    if (type == Calendar.class) {
                        jSONLexer2.close();
                        return r12;
                    }
                    date = r12.getTime();
                }
                jSONLexer2.close();
                l10 = date;
            }
        } else if (i11 == 8) {
            jSONLexer.nextToken();
            obj2 = null;
            t10 = (T) cast(defaultJSONParser, type, obj, obj2, str);
            if (type != Calendar.class && !(t10 instanceof Calendar)) {
                Date date2 = (Date) t10;
                if (date2 == null) {
                    return null;
                }
                ?? r122 = (T) Calendar.getInstance(jSONLexer.timeZone, jSONLexer.locale);
                r122.setTime(date2);
                return r122;
            }
        } else if (i11 == 12) {
            jSONLexer.nextToken();
            if (jSONLexer.token() == 4) {
                if (JSON.DEFAULT_TYPE_KEY.equals(jSONLexer.stringVal())) {
                    jSONLexer.nextToken();
                    defaultJSONParser.accept(17);
                    Class<?> loadClass = TypeUtils.loadClass(jSONLexer.stringVal(), defaultJSONParser.config.defaultClassLoader);
                    if (loadClass != null) {
                        type = loadClass;
                    }
                    defaultJSONParser.accept(4);
                    defaultJSONParser.accept(16);
                }
                jSONLexer.nextTokenWithChar(':');
                if (jSONLexer.token() == 2) {
                    long longValue = jSONLexer.longValue();
                    jSONLexer.nextToken();
                    Long valueOf2 = Long.valueOf(longValue);
                    defaultJSONParser.accept(13);
                    l10 = valueOf2;
                } else {
                    throw new JSONException("syntax error : " + JSONToken.name(i10));
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            } else if ("val".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                Object parse = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
                l10 = parse;
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            l10 = defaultJSONParser.parse();
        }
        obj2 = l10;
        t10 = (T) cast(defaultJSONParser, type, obj, obj2, str);
        return type != Calendar.class ? t10 : t10;
    }
}
