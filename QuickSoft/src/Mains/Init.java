package Mains;

import java.io.IOException;

import Utils.baseUtils;

/**
 * 
 * @author ��Ԩ
 *
 * 2017��6��1��
 */
public class Init {


	
	
	//����һ������ΪN��������ļ�
	public static String creatRandomText(int n) {
		String output = "";
		try {
			//����һ������Ϊn���������
			int[] v = baseUtils.getRandomIntArray(n);
			//������������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "���������" + "\n" +
					"·����" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//����һ������ΪN���������ļ�
	public static String creatAscendText(int n) {
		String output = "";
		try {
			//����һ������Ϊn����������
			int[] v = baseUtils.getAscendIntArray(n);
			//���������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "����������" + "\n" +
					"·����" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//����һ������ΪN�Ľ������ļ�
	public static String creatDescendText(int n) {
		String output = "";
		try {
			//����һ������Ϊn���������
			int[] v = baseUtils.getDescendIntArray(n);
			//������������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "����������" + "\n" +
					"·����" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
	//����һ������ΪN���ظ����ļ�
	public static String creatRepeatText(int n) {
		String output = "";
		try {
			//����һ������Ϊn���ظ�����
			int[] v = baseUtils.getRepeatIntArray(n);
			//���ظ��������һ���ļ�
			String URL = baseUtils.save2File(v);
			output = "���ɳɹ�������" + v.length + "���ظ�����" + "\n" +
					"·����" + URL;
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return output;
		}
	}
	
}
