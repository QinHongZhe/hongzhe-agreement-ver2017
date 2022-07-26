package com.pactera.v2x.v2.agreement.ver2017.SignalPhaseAndTiming;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.IntegerConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * 发送方为自己发送的同类消息,依次进行编号。编号数值为0~127
 * 当发送方开始发起某一类数据时,它可以随机选择起始编号,随后依次递增。发送方也可以在
 * 连续发送相同的数据帧时,选择使用相同的 Msgcount消息编号。编号到达127后,则下一个回到0
 */
public class MsgCount {
  public static void per_encode(Integer object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Integer per_decode(boolean align, InputStream in) throws IOException {
    return (Integer)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = SignalPhaseAndTiming.type(65537);
  
  public static final AsnConverter CONV = (AsnConverter) IntegerConverter.INSTANCE;
}
