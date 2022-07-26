package com.pactera.v2x.v2.agreement.ver2017.MsgFrame;

import org.asnlab.asndt.runtime.conv.AsnConverter;
import org.asnlab.asndt.runtime.conv.VectorConverter;
import org.asnlab.asndt.runtime.type.AsnType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;

/**
 * 定义交通参与者列表。应用于RSM消息中,表示所有或部分RSU当前探测到的交通参与者信息
 */
public class ParticipantList {
  public static void per_encode(Vector<ParticipantData> object, boolean align, OutputStream out) throws IOException {
    TYPE.encode(object, (byte) (align ? 4 : 3), CONV, out);
  }
  
  public static Vector<ParticipantData> per_decode(boolean align, InputStream in) throws IOException {
    return (Vector<ParticipantData>)TYPE.decode(in, (byte) (align ? 4 : 3), CONV);
  }
  
  public static final AsnType TYPE = MsgFrame.type(1310838);
  
  public static final AsnConverter CONV = (AsnConverter)new VectorConverter((AsnConverter)ParticipantData.CONV);
}
