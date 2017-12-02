package server;

import java.io.ByteArrayOutputStream;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import tools.DataTypeTranslater;

/**
 * 1.Size：类型为int，转化为byte数组后占4个字节。
 * 2.ProtoHead：消息类型（如：登陆？注册？）类型为ProtoHead，转化为byte数组后占4个字节。
 * 3.MessageId：一次消息的Id，类型为float，转化为byte数组后占4个字节。
 * 4.MessageBody：消息主体，类型根据ProtoHead 参数 使用 Protobuf 进行转化，占用的字节数为 size -
 * sizeOf(size) - sizeOf(ProtoHead) - sizeOf(MessageId)，也就是size 转化为int后的数值减去4 *3
 * 接到客户端数据时的粘包方式
 * 
 * @author Feng
 *
 */
public class MinaDecoder extends CumulativeProtocolDecoder {
	private ByteArrayOutputStream byteArrayOutputStream;

	@Override
	protected boolean doDecode(IoSession ioSession, IoBuffer ioBuffer, ProtocolDecoderOutput output) throws Exception {
		// 如果没有接收完Size部分（4字节），直接返回false,接收下批数据并且拼装在一起
		if (ioBuffer.remaining() < 4)
			return false;
		else {
			// 标记开始位置，如果一条消息没传输完成则返回到这个位置
			ioBuffer.mark();

			byteArrayOutputStream = new ByteArrayOutputStream();

			// 读取Size
			byte[] bytes = new byte[4];
			ioBuffer.get(bytes); // 读取4字节的Size
			byteArrayOutputStream.write(bytes);
			int bodyLength = DataTypeTranslater.bytesToInt(bytes, 0) - DataTypeTranslater.INT_SIZE; // 按小字节序转int

			// 如果body没有接收完整，直接返回false，出现断包
			if (ioBuffer.remaining() < bodyLength) {
				ioBuffer.reset(); // IoBuffer position回到原来标记的地方
				return false;
			} else {
				//todo 粘包，如果取完完整的一个包后还剩余数据，出现粘包， 当内容多时，返回true，因为需要再将本批数据进行读取，父类会将剩余的数据再次推送本类的doDecode方法
				byte[] bodyBytes = new byte[bodyLength];
				ioBuffer.get(bodyBytes);
				// String body = new String(bodyBytes, "UTF-8");
				byteArrayOutputStream.write(bodyBytes);

				// 创建对象
				NetworkPacket packetFromClient = new NetworkPacket(ioSession, byteArrayOutputStream.toByteArray());

				output.write(packetFromClient); // 解析出一条消息
				return true;
			}
		}
	}

}
