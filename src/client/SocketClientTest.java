package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import protocol.ProtoHead;
import protocol.Msg.AddFriendMsg;
import protocol.Msg.ChangeFriendMsg;
import protocol.Msg.DeleteFriendMsg;
import protocol.Msg.GetPersonalInfoMsg;
import protocol.Msg.GetUserInfoMsg;
import protocol.Msg.LoginMsg;
import protocol.Msg.LogoutMsg;
import protocol.Msg.PersonalSettingsMsg;
import protocol.Msg.RegisterMsg;
import server.NetworkPacket;
import tools.DataTypeTranslater;
import tools.Debug;

public class SocketClientTest {

	public static final int HEAD_INT_SIZE = 4;
	public Socket socket;
	public InputStream inputStream;
	public OutputStream outputStream;

	// String host = "192.168.45.17"; // 要连接的服务端IP地址

	// public static final String host = "104.224.165.21"; // 要连接的服务端IP地址
	public static final String host = "127.0.0.1"; // 要连接的服务端IP地址
	// public static final String host = "192.168.1.103"; // 要连接的服务端IP地址
	// public static final String host = "192.168.45.17"; // 要连接的服务端IP地址

	int port = 8081; // 要连接的服务端对应的监听端口

	public static void main(String args[]) throws IOException {
		new SocketClientTest();
	}

	public SocketClientTest() throws UnknownHostException, IOException {
		// 为了简单起见，所有的异常都直接往外抛
		// int port = 8080; // 要连接的服务端对应的监听端口
		// 与服务端建立连接
		// 测心跳
		// testKeepAlive();
		// socket = new Socket(host, port);
		// inputStream = socket.getInputStream();
		// outputStream = socket.getOutputStream();

		// 测心跳
	//	testKeepAlive();
		//测注册
//	 testRegister();
	//	// 测登陆
	//	 testLogin();
		// 测个人设置
		// testPersonalSettings();

		// 测心跳
		// testKeepAlive();
		// 测注册
		// testRegister();

		// 测登陆
	//	 testLogin();
		// 测试个人设置
		// testPersonalSettings();

		// 测查看用户个人信息
		// testGetUserInfo();

		// 测添加好友
		 testAddFriend();

		// 测删除好友
		// testDeleteFriend();

		// 测退出登录
		// testLogout();

		// 测获取个人信息
		// testGetPersonalInfo();

		// new Thread(new readThread()).start();
	}

	/**
	 * ���ӷ�����
	 * 
	 * @throws UnknownHostException
	 * @throws IOException
	 * @author Feng
	 */
	public void link() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
		inputStream = socket.getInputStream();
		outputStream = socket.getOutputStream();
	}

	// 处理服务器回复问题
	public byte[] readFromServer() throws IOException {

		// inputStream = socket.getInputStream();
		byte[] byteArray = new byte[200];
		// System.out.println(in.read(byteArray));
		inputStream.read(byteArray);
		byteArray = cutResult(byteArray);

		// System.out.println("client �յ�Server ������ �� " + byteArray);
		// inputStream.close();

		// System.out.println("client 收到Server 发来的 ： " + byteArray);
		// inputStream.close();

		return byteArray;
	}

	public byte[] readFromServer(InputStream inputStream) throws IOException {
		byte[] byteArray = new byte[200];
		inputStream.read(byteArray);
		return byteArray;
	}

	public void writeToServer(byte[] arrayBytes) throws IOException {
		// outputStream = socket.getOutputStream();
		outputStream.write(arrayBytes);
		// outputStream.close();
	}

	public void writeToServer(OutputStream outputStreams, byte[] arrayBytes) throws IOException {
		// outputStream = socket.getOutputStream();
		outputStream.write(arrayBytes);
		// outputStream.close();
	}

	/**
	 * 永久读线程
	 * 
	 * @author Feng
	 * 
	 */
	class readThread implements Runnable {
		@Override
		public void run() {
			try {
				// socket = new Socket(host, port);
				while (true) {
					Thread.sleep(1000);
					byte[] arrayBytes = readFromServer();
					System.out.println("client 收到Server 发来的 ： " + arrayBytes);

					System.out.println("size:" + DataTypeTranslater.bytesToInt(arrayBytes, 0));
					System.out.println("Type:"
							+ ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(arrayBytes, HEAD_INT_SIZE))
									.toString());

					// 发回去
					writeToServer(arrayBytes);

				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 测试心跳功能
	 */
	public void testKeepAlive() {
		System.out.println("Start Test KeepAliveSyc!");
		try {
			socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			byte[] byteArray;
			// outputStream = socket.getOutputStream();
			// writeToServer(byteArray);

			// inputStream = socket.getInputStream();
			while (true) {
				byteArray = readFromServer();
				System.out.println("Bytes size : " + byteArray.length);
				// System.out.println("Client get (): " + byteArray);
				// System.err.println("Start");
				// for (byte b : byteArray)
				// System.err.println(b);
				// System.err.println("End");

				if (byteArray.length < HEAD_INT_SIZE) {
					System.out.println("貌似连接断了， 测试结束!");
					return;
				}
 
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("Real size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				// for (byte b : byteArray)
				// System.out.println(b);

				if (type == ProtoHead.ENetworkMessage.KEEP_ALIVE_SYNC) {
					// byteArray2 =
					// NetworkMessage.packMessage(ProtoHead.ENetworkMessage.KEEP_ALIVE_SYNC_VALUE,
					// NetworkMessage.getMessageID(byteArray), new byte[0]);
					// byteArray2 = new byte[size];
					// for (int i = 0; i < size; i++)
					// byteArray2[i] = byteArray[i];

					Debug.log("Response 'keepAlivePacket'");
					writeToServer(byteArray);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试注册功能
	 * 
	 * @author Feng
	 */
	public void testRegister() {
		RegisterMsg.RegisterReq.Builder builder = RegisterMsg.RegisterReq.newBuilder();
		//builder.setUserId("a3");
		builder.setUserPassword("123456");
		builder.setUserName("zbq");
		System.out.println("Start Test Register!");
		try {
			socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.REGISTER_REQ.getNumber(), builder.build()
					.toByteArray());
			System.out.println("MessageID : " + NetworkPacket.getMessageID(byteArray));
			writeToServer(byteArray);

			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.REGISTER_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];

					RegisterMsg.RegisterRsp response = RegisterMsg.RegisterRsp.parseFrom(objBytes);

					System.out.println("Response : "
							+ RegisterMsg.RegisterRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
					System.out.println("MessageID : " + NetworkPacket.getMessageID(byteArray));
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试注册功能(由JUnit调用)
	 * 
	 * @author Feng
	 * @return
	 * @throws IOException
	 */
	public byte[] testRegister_JUint(String userId, String userPassword, String userName) throws IOException {
		RegisterMsg.RegisterReq.Builder builder = RegisterMsg.RegisterReq.newBuilder();
		//builder.setUserId(userId);
		builder.setUserPassword(userPassword);
		builder.setUserName(userName);

		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.REGISTER_REQ.getNumber(), builder.build()
				.toByteArray());
		// System.out.println("MessageID : " +
		// NetworkMessage.getMessageID(byteArray));
		writeToServer(outputStream, byteArray);

		while (true) {
			byteArray = readFromServer(inputStream);
			if (NetworkPacket.getMessageType(byteArray) != ProtoHead.ENetworkMessage.REGISTER_RSP)
				continue;

			return cutResult(byteArray);
		}
	}

	/**
	 * 测试登陆功能(由JUnit调用)
	 * 
	 * @param userId
	 * @param userPassword
	 * @return
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public byte[] testLogin_JUint(String userName, String userPassword) throws UnknownHostException, IOException {
		LoginMsg.LoginReq.Builder builder = LoginMsg.LoginReq.newBuilder();
		builder.setUserName(userName);
		builder.setUserPassword(userPassword);

		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), builder.build()
				.toByteArray());
		// outputStream = socket.getOutputStream();
		writeToServer(byteArray);

		// inputStream = socket.getInputStream();
		while (true) {
			byteArray = readFromServer();

			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));

			if (type == ProtoHead.ENetworkMessage.LOGIN_RSP) {
				return byteArray;
			}
		}
	}

	/**
	 * 测试登陆功能
	 */
	public void testLogin() {

		LoginMsg.LoginReq.Builder builder = LoginMsg.LoginReq.newBuilder();
		builder.setUserName("zbq");
		builder.setUserPassword("123456");
		System.out.println("Start Test Login!");
		try {
			socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), builder.build()
					.toByteArray());
			// outputStream = socket.getOutputStream();
			writeToServer(byteArray);

			// inputStream = socket.getInputStream();
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.LOGIN_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];

					LoginMsg.LoginRsp response = LoginMsg.LoginRsp.parseFrom(objBytes);

					System.out
							.println("Response : " + LoginMsg.LoginRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
					break;
				}
			}
			inputStream.close();
			outputStream.close();
			socket.close();
			link();
			// 断后重测
			System.out.println("断后重测");
			byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), builder.build().toByteArray());
			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.LOGIN_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];

					LoginMsg.LoginRsp response = LoginMsg.LoginRsp.parseFrom(objBytes);

					System.out
							.println("Response : " + LoginMsg.LoginRsp.ResultCode.valueOf(response.getResultCode().getNumber()));

				}
				if (type == ProtoHead.ENetworkMessage.CHANGE_FRIEND_SYNC) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];
					ChangeFriendMsg.ChangeFriendSync response = ChangeFriendMsg.ChangeFriendSync.parseFrom(objBytes);
					System.out.println(response.getChangeType() + " " + response.getUserItem());
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试个人设置功能
	 * 
	 * @author WangFei
	 */
	public void testPersonalSettings() {
		PersonalSettingsMsg.PersonalSettingsReq.Builder builder = PersonalSettingsMsg.PersonalSettingsReq.newBuilder();
		builder.setUserName("bbss");
		// builder.setUserPassword("s1234");
		builder.setHeadIndex(5);
		System.out.println("start personalSettings test! ----------------------------");
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("a3");
			loginBuilder.setUserPassword("aa");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);

			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.PERSONALSETTINGS_REQ.getNumber(), builder
					.build().toByteArray());
			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.PERSONALSETTINGS_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];

					PersonalSettingsMsg.PersonalSettingsRsp response = PersonalSettingsMsg.PersonalSettingsRsp
							.parseFrom(objBytes);

					System.out.println("Response : "
							+ PersonalSettingsMsg.PersonalSettingsRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
				}
				if (type == ProtoHead.ENetworkMessage.OFFLINE_SYNC) {
					System.out.println("被下线");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试个人设置--JUnit调用
	 * 
	 * @param userName
	 * @param userPassword
	 * @return
	 * @throws IOException
	 * @author wangfei
	 */
	public byte[] testPersonalSettings_JUnit(String userName, String userPassword, int headIndex) throws IOException {
		PersonalSettingsMsg.PersonalSettingsReq.Builder builder = PersonalSettingsMsg.PersonalSettingsReq.newBuilder();
		builder.setUserName(userName);
		builder.setUserPassword(userPassword);
		builder.setHeadIndex(headIndex);
		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.PERSONALSETTINGS_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.PERSONALSETTINGS_RSP) {
				return byteArray;
			}
		}

	}

	/**
	 * 用于剪切从服务器发过来的byte[]
	 * 
	 * @param byteArray
	 * @return
	 */
	public byte[] cutResult(byte[] byteArray) {
		int size = DataTypeTranslater.bytesToInt(byteArray, 0);
		byte[] result = new byte[size];
		for (int i = 0; i < size; i++)
			result[i] = byteArray[i];

		return result;
	}

	/**
	 * 测试获取用户信息功能
	 * 
	 * @author wangfei
	 */
	public void testGetUserInfo() {
		GetUserInfoMsg.GetUserInfoReq.Builder builder = GetUserInfoMsg.GetUserInfoReq.newBuilder();
		builder.addTargetUserId("Fuck");
		System.out.println("start test SearchUser! -----------------------");
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("a");
			loginBuilder.setUserPassword("aa");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);

			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.GET_USERINFO_REQ.getNumber(), builder.build()
					.toByteArray());

			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.GET_USERINFO_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];

					GetUserInfoMsg.GetUserInfoRsp response = GetUserInfoMsg.GetUserInfoRsp.parseFrom(objBytes);

					System.out.println("Response : "
							+ GetUserInfoMsg.GetUserInfoRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
					if (response.getResultCode().equals(GetUserInfoMsg.GetUserInfoRsp.ResultCode.SUCCESS)) {
						System.out.println("searchResult UserId:" + response.getUserItem(0).getUserId() + "  UserName:"
								+ response.getUserItem(0).getUserName());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试获取用户信息--JUnit调用
	 * 
	 * @param targetUserId
	 * @return
	 * @throws IOException
	 * @author wangfei
	 */
	public byte[] testGetUserInfo_JUnit(String targetUserId) throws IOException {
		GetUserInfoMsg.GetUserInfoReq.Builder builder = GetUserInfoMsg.GetUserInfoReq.newBuilder();
		builder.addTargetUserId(targetUserId);
		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.GET_USERINFO_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.GET_USERINFO_RSP) {
				return byteArray;
			}
		}

	}

	/**
	 * 测试添加好友功能
	 * 
	 * @author wangfei
	 */
	public void testAddFriend() {
		AddFriendMsg.AddFriendReq.Builder builder = AddFriendMsg.AddFriendReq.newBuilder();
		builder.setFriendUserId("43c80f694bc94498ba8139e473c2287e");
		System.out.println("start test AddFriend! -----------------------");
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();

			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("zhoubaoqi8");
			loginBuilder.setUserPassword("123456");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);

			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.ADD_FRIEND_REQ.getNumber(), builder.build()
					.toByteArray());

			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.ADD_FRIEND_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];
					AddFriendMsg.AddFriendRsp response = AddFriendMsg.AddFriendRsp.parseFrom(objBytes);

					System.out.println("Response : "
							+ AddFriendMsg.AddFriendRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试添加好友--JUnit调用
	 * 
	 * @param friendUserId
	 * @return
	 * @throws IOException
	 */
	public byte[] testAddFriend_JUnit(String friendUserId) throws IOException {
		AddFriendMsg.AddFriendReq.Builder builder = AddFriendMsg.AddFriendReq.newBuilder();
		builder.setFriendUserId(friendUserId);

		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.ADD_FRIEND_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.ADD_FRIEND_RSP) {
				return byteArray;
			}
		}
	}

	/**
	 * 测试删除好友功能
	 * 
	 * @author wangfei
	 */
	public void testDeleteFriend() {
		DeleteFriendMsg.DeleteFriendReq.Builder builder = DeleteFriendMsg.DeleteFriendReq.newBuilder();
		builder.setFriendUserId("a1");
		System.out.println("start test DeleteFriend! -----------------------");
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("a2");
			loginBuilder.setUserPassword("s1234");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);
			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.DELETE_FRIEND_REQ.getNumber(), builder.build()
					.toByteArray());

			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				System.out.println("size: " + size);

				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println("Type : " + type.toString());

				if (type == ProtoHead.ENetworkMessage.DELETE_FRIEND_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];
					DeleteFriendMsg.DeleteFriendRsp response = DeleteFriendMsg.DeleteFriendRsp.parseFrom(objBytes);

					System.out.println("Response : "
							+ DeleteFriendMsg.DeleteFriendRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试删除好友--JUnit调用
	 * 
	 * @param friendUserId
	 * @return
	 * @throws IOException
	 * @author wangfei
	 */
	public byte[] testDeleteFriend_JUnit(String friendUserId) throws IOException {
		DeleteFriendMsg.DeleteFriendReq.Builder builder = DeleteFriendMsg.DeleteFriendReq.newBuilder();
		builder.setFriendUserId(friendUserId);
		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.DELETE_FRIEND_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.DELETE_FRIEND_RSP) {
				return byteArray;
			}
		}
	}

	/**
	 * 测试退出登录
	 * 
	 * @author wangfei
	 */
	public void testLogout() {
		LogoutMsg.LogoutReq.Builder builder = LogoutMsg.LogoutReq.newBuilder();
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("a2");
			loginBuilder.setUserPassword("aa");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);
			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGOUT_REQ.getNumber(), builder.build()
					.toByteArray());

			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				if (type == ProtoHead.ENetworkMessage.LOGOUT_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];
					LogoutMsg.LogoutRsp response = LogoutMsg.LogoutRsp.parseFrom(objBytes);
					System.out.println("Response : "
							+ LogoutMsg.LogoutRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试退出登录--JUnit调用
	 * 
	 * @return
	 * @throws IOException
	 * @author wangfei
	 */
	public byte[] testLogout_JUnit() throws IOException {
		LogoutMsg.LogoutReq.Builder builder = LogoutMsg.LogoutReq.newBuilder();
		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGOUT_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.LOGOUT_RSP) {
				return byteArray;
			}
		}
	}

	/**
	 * 测获取个人信息--包括基本信息和好友信息
	 * 
	 * @author wangfei
	 */
	public void testGetPersonalInfo() {
		System.out.println(" start test getPersonalInfo ---------");
		GetPersonalInfoMsg.GetPersonalInfoReq.Builder builder = GetPersonalInfoMsg.GetPersonalInfoReq.newBuilder();
		builder.setFriendInfo(true);
		builder.setUserInfo(true);
		builder.setGroupInfo(true);
		try {
			Socket socket = new Socket(host, port);
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			LoginMsg.LoginReq.Builder loginBuilder = LoginMsg.LoginReq.newBuilder();
			loginBuilder.setUserName("a3");
			loginBuilder.setUserPassword("aa");
			byte[] loginByteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.LOGIN_REQ.getNumber(), loginBuilder
					.build().toByteArray());
			writeToServer(loginByteArray);
			byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.GET_PERSONALINFO_REQ.getNumber(), builder
					.build().toByteArray());

			writeToServer(byteArray);
			while (true) {
				byteArray = readFromServer();
				System.out.println(" read from server !");
				int size = DataTypeTranslater.bytesToInt(byteArray, 0);
				ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
						HEAD_INT_SIZE));
				System.out.println(type);
				if (type == ProtoHead.ENetworkMessage.GET_PERSONALINFO_RSP) {
					byte[] objBytes = new byte[size - NetworkPacket.getMessageObjectStartIndex()];
					for (int i = 0; i < objBytes.length; i++)
						objBytes[i] = byteArray[NetworkPacket.getMessageObjectStartIndex() + i];
					GetPersonalInfoMsg.GetPersonalInfoRsp response = GetPersonalInfoMsg.GetPersonalInfoRsp.parseFrom(objBytes);
					System.out.println("Response : "
							+ GetPersonalInfoMsg.GetPersonalInfoRsp.ResultCode.valueOf(response.getResultCode().getNumber()));
					System.out.println(response.getUserInfo());
					System.out.println(response.getFriendsList());
					System.out.println(response.getGroupsList());
				}
			}
		} catch (IOException e) {

		}
	}

	/**
	 * 测获取个人信息--包括基本信息和好友信息 --JUnit调用
	 * 
	 * @return
	 * @author wangfei
	 * @throws IOException
	 * @time 2015-03-26
	 */
	public byte[] testGetPersonalInfo_JUnit(boolean userInfo, boolean friendInfo) throws IOException {
		GetPersonalInfoMsg.GetPersonalInfoReq.Builder builder = GetPersonalInfoMsg.GetPersonalInfoReq.newBuilder();
		builder.setUserInfo(userInfo);
		builder.setFriendInfo(friendInfo);
		byte[] byteArray = NetworkPacket.packMessage(ProtoHead.ENetworkMessage.GET_PERSONALINFO_REQ.getNumber(), builder.build()
				.toByteArray());
		writeToServer(byteArray);
		while (true) {
			byteArray = readFromServer();
			ProtoHead.ENetworkMessage type = ProtoHead.ENetworkMessage.valueOf(DataTypeTranslater.bytesToInt(byteArray,
					HEAD_INT_SIZE));
			if (type == ProtoHead.ENetworkMessage.GET_PERSONALINFO_RSP) {
				return byteArray;
			}
		}

	}

}
