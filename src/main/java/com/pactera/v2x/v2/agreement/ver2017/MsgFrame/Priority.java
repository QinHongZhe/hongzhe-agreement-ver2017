package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.OctetStringConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 表示消息优先级。数值长度占8位,其中低五位为0,为无效位,高三位为有效数据位。数值
 * 有效范围是B00000列B111000,0分别表示8档由低到高的优先级
 */
public class Priority {
  public static void per_encode(byte[] object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static byte[] per_decode(boolean align, InputStream in) throws IOException {
    return (byte[])TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1441927);
  
  public static final AsnConverter CONV = (AsnConverter) OctetStringConverter.INSTANCE;
}
