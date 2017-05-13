package Mains;

import java.io.IOException;

import Utils.baseUtils;

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
			
			//执行快速排序
//			int[] sortV = qSort(v);
			//排序完的数组写入文件
//			String sortURL = baseUtils.save2File(sortV);
//			System.out.println("排序成功！");
//			System.out.println("路径：" + URL);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
