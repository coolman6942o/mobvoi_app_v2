package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [T, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        if (type == StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            } else if ("val".equals(jSONLexer.stringVal())) {
                jSONLexer.nextToken();
                defaultJSONParser.accept(17);
                obj2 = defaultJSONParser.parse();
                defaultJSONParser.accept(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = defaultJSONParser.parse();
        }
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            if (type == UUID.class) {
                return (T) UUID.fromString(str);
            }
            if (type == Class.class) {
                return (T) TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader);
            }
            if (type == Locale.class) {
                String[] split = str.split("_");
                if (split.length == 1) {
                    return (T) new Locale(split[0]);
                }
                if (split.length == 2) {
                    return (T) new Locale(split[0], split[1]);
                }
                return (T) new Locale(split[0], split[1], split[2]);
            } else if (type == URI.class) {
                return (T) URI.create(str);
            } else {
                if (type == URL.class) {
                    try {
                        return (T) new URL(str);
                    } catch (MalformedURLException e10) {
                        throw new JSONException("create url error", e10);
                    }
                } else if (type == Pattern.class) {
                    return (T) Pattern.compile(str);
                } else {
                    if (type == Charset.class) {
                        return (T) Charset.forName(str);
                    }
                    if (type == Currency.class) {
                        return (T) Currency.getInstance(str);
                    }
                    if (type == SimpleDateFormat.class) {
                        ?? r72 = (T) new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
                        r72.setTimeZone(defaultJSONParser.lexer.timeZone);
                        return r72;
                    } else if (type == Character.TYPE || type == Character.class) {
                        return (T) TypeUtils.castToChar(str);
                    } else {
                        return (T) TimeZone.getTimeZone(str);
                    }
                }
            }
        } else {
            throw new JSONException("except string value");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0166, code lost:
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected <T> T parseStackTraceElement(DefaultJSONParser defaultJSONParser) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (jSONLexer.token() == 8) {
            jSONLexer.nextToken();
            return null;
        } else if (jSONLexer.token() == 12 || jSONLexer.token() == 16) {
            int i10 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (true) {
                String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                if (scanSymbol == null) {
                    if (jSONLexer.token() == 13) {
                        jSONLexer.nextToken(16);
                        break;
                    } else if (jSONLexer.token() == 16) {
                        continue;
                    }
                }
                jSONLexer.nextTokenWithChar(':');
                if ("className".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str = null;
                    } else if (jSONLexer.token() == 4) {
                        str = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("methodName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str2 = null;
                    } else if (jSONLexer.token() == 4) {
                        str2 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("fileName".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        str3 = null;
                    } else if (jSONLexer.token() == 4) {
                        str3 = jSONLexer.stringVal();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("lineNumber".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        i10 = 0;
                    } else if (jSONLexer.token() == 2) {
                        i10 = jSONLexer.intValue();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("nativeMethod".equals(scanSymbol)) {
                    if (jSONLexer.token() == 8) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 6) {
                        jSONLexer.nextToken(16);
                    } else if (jSONLexer.token() == 7) {
                        jSONLexer.nextToken(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (scanSymbol != JSON.DEFAULT_TYPE_KEY) {
                    throw new JSONException("syntax error : " + scanSymbol);
                } else if (jSONLexer.token() == 4) {
                    String stringVal = jSONLexer.stringVal();
                    if (!stringVal.equals("java.lang.StackTraceElement")) {
                        throw new JSONException("syntax error : " + stringVal);
                    }
                } else if (jSONLexer.token() != 8) {
                    throw new JSONException("syntax error");
                }
                if (jSONLexer.token() == 13) {
                    jSONLexer.nextToken(16);
                    break;
                }
            }
        } else {
            throw new JSONException("syntax error: " + JSONToken.name(jSONLexer.token()));
        }
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                jSONSerializer.write("");
            } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Enumeration.class.isAssignableFrom(TypeUtils.getClass(type))) {
                serializeWriter.writeNull();
            } else {
                serializeWriter.write("[]");
            }
        } else if (obj instanceof Pattern) {
            jSONSerializer.write(((Pattern) obj).pattern());
        } else if (obj instanceof TimeZone) {
            jSONSerializer.write(((TimeZone) obj).getID());
        } else if (obj instanceof Currency) {
            jSONSerializer.write(((Currency) obj).getCurrencyCode());
        } else if (obj instanceof Class) {
            jSONSerializer.write(((Class) obj).getName());
        } else if (obj instanceof Character) {
            Character ch2 = (Character) obj;
            if (ch2.charValue() == 0) {
                jSONSerializer.write("\u0000");
            } else {
                jSONSerializer.write(ch2.toString());
            }
        } else {
            int i10 = 0;
            if (obj instanceof SimpleDateFormat) {
                String pattern = ((SimpleDateFormat) obj).toPattern();
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                    serializeWriter.writeString(pattern);
                    return;
                }
                serializeWriter.write(123);
                serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
                jSONSerializer.write(obj.getClass().getName());
                serializeWriter.write(44);
                serializeWriter.writeFieldName("val", false);
                serializeWriter.writeString(pattern);
                serializeWriter.write(125);
            } else if (obj instanceof JSONStreamAware) {
                ((JSONStreamAware) obj).writeJSONString(serializeWriter);
            } else if (obj instanceof JSONAware) {
                serializeWriter.write(((JSONAware) obj).toJSONString());
            } else if (obj instanceof JSONSerializable) {
                ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
            } else if (obj instanceof Enumeration) {
                Type type2 = null;
                if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0 && (type instanceof ParameterizedType)) {
                    type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                }
                Enumeration enumeration = (Enumeration) obj;
                SerialContext serialContext = jSONSerializer.context;
                jSONSerializer.setContext(serialContext, obj, obj2, 0);
                try {
                    serializeWriter.write(91);
                    while (enumeration.hasMoreElements()) {
                        Object nextElement = enumeration.nextElement();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            serializeWriter.write(44);
                        }
                        if (nextElement == null) {
                            serializeWriter.writeNull();
                        } else {
                            jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, Integer.valueOf(i11 - 1), type2);
                        }
                        i10 = i11;
                    }
                    serializeWriter.write(93);
                } finally {
                    jSONSerializer.context = serialContext;
                }
            } else {
                jSONSerializer.write(obj.toString());
            }
        }
    }
}
