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


	
	
	//生成一个长度为N的随机数文件
	public static String creatRandomText(int n, String tp) {
		String output = "";
		try {
			//生成一个长度为n的随机数组
			int[] v = baseUtils.getRandomIntArray(n);
			//将随机数组存入一个文件
			String URL = baseUtils.save2File(v, tp);
			output = "生成成功！生成" + v.length + "个随机数！" + "\n" +
					"路径：" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//生成一个长度为N的升序数文件
	public static String creatAscendText(int n, String tp) {
		String output = "";
		try {
			//生成一个长度为n的升序数组
			int[] v = baseUtils.getAscendIntArray(n);
			//将数组存入一个文件
			String URL = baseUtils.save2File(v, tp);
			output = "生成成功！生成" + v.length + "个升序数！" + "\n" +
					"路径：" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//生成一个长度为N的降序数文件
	public static String creatDescendText(int n, String tp) {
		String output = "";
		try {
			//生成一个长度为n的随机数组
			int[] v = baseUtils.getDescendIntArray(n);
			//将随机数组存入一个文件
			String URL = baseUtils.save2File(v, tp);
			output = "生成成功！生成" + v.length + "个降序数！" + "\n" +
					"路径：" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//生成一个长度为N的重复数文件
	public static String creatRepeatText(int n, String tp) {
		String output = "";
		try {
			//生成一个长度为n的重复数组
			int[] v = baseUtils.getRepeatIntArray(n);
			//将重复数组存入一个文件
			String URL = baseUtils.save2File(v, tp);
			output = "生成成功！生成" + v.length + "个重复数！" + "\n" +
					"路径：" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
