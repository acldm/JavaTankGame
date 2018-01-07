package Util;

import java.util.HashMap;

//使用该静态类统一管理输入输出
//使用一个HashMap存放按键状态，按下时为true,松开时为false
public class GInput {
	private static int currentKeyDown = -1;
	private GInput() {
		
	}
	
	private static HashMap<Integer, Boolean> keyDowns;
	
	static {
		keyDowns = new HashMap<Integer, Boolean>();
	}
	
	public static Boolean isKeyDown(Integer keyCode) {
		if (keyDowns.get(keyCode) == null) {
			return false;
		}
		else {

			return keyDowns.get(keyCode);
		}
	}

	public static int isKeyOnceDown() {
		int a = currentKeyDown;
		currentKeyDown = -1;
		return a;
	}
	
	public static void keyDown(Integer keyCode) {
		currentKeyDown = keyCode;
		keyDowns.put(keyCode, true);
	}
	
	public static void keyUp(Integer keyCode) {
		keyDowns.put(keyCode, false);
	}

	public static void clearKey() {
		keyDowns.clear();
	}
}
