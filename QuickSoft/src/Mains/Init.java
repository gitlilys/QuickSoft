package Mains;

import java.io.IOException;

import Utils.baseUtils;

/**
 * 
 * @author 罗渊
 *
 * 2017年6月1日
 */
public class Init {

	public static String creatText(int n) {
		String output = "";
		try {
			//生成一个长度为n的随机数组
			int[] v = baseUtils.getRandomIntArray(n);
			//将随机数组存入一个文件
			String URL = baseUtils.save2File(v);
			output = "生成成功！生成" + v.length + "个随机数！" + "\n" +
					"路径：" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
