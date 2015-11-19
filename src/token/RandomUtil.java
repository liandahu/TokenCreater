package token;

import java.util.Random;

/**
 * ���������
 * 
 * @author liandahu
 *
 */
public class RandomUtil {
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String NUMBERCHAR = "0123456789";

	/**
	 * ����һ������������ַ���(ֻ������Сд��ĸ������)
	 * 
	 * @param length
	 *            ����ַ�������
	 * @return ����ַ���
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * ����һ���������������ĸ�ַ���(ֻ������Сд��ĸ)
	 * 
	 * @param length
	 *            ����ַ�������
	 * @return ����ַ���
	 */
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(LETTERCHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * ����һ���������������д��ĸ�ַ���(ֻ������Сд��ĸ)
	 * 
	 * @param length
	 *            ����ַ�������
	 * @return ����ַ���
	 */
	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	/**
	 * ����һ�������������Сд��ĸ�ַ���(ֻ������Сд��ĸ)
	 * 
	 * @param length
	 *            ����ַ�������
	 * @return ����ַ���
	 */
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/**
	 * ����һ�������Ĵ�0�ַ���
	 * 
	 * @param length
	 *            �ַ�������
	 * @return ��0�ַ���
	 */
	public static String generateZeroString(int length) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append('0');
		}
		return sb.toString();
	}

	/**
	 * ������������һ���������ַ��������Ȳ���ǰ�油0
	 * 
	 * @param num
	 *            ����
	 * @param fixdlenth
	 *            �ַ�������
	 * @return �������ַ���
	 */
	public static String toFixdLengthString(long num, int fixdlenth) {
		StringBuffer sb = new StringBuffer();
		String strNum = String.valueOf(num);
		if (fixdlenth - strNum.length() >= 0) {
			sb.append(generateZeroString(fixdlenth - strNum.length()));
		} else {
			throw new RuntimeException("������" + num + "ת��Ϊ����Ϊ" + fixdlenth
					+ "���ַ��������쳣��");
		}
		sb.append(strNum);
		return sb.toString();
	}

	/**
	 * ÿ�����ɵ�lenλ��������ͬ
	 * 
	 * @param param
	 * @return ����������
	 */
	public static int getNotSimple(int[] param, int len) {
		Random rand = new Random();
		for (int i = param.length; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = param[index];
			param[index] = param[i - 1];
			param[i - 1] = tmp;
		}
		int result = 0;
		for (int i = 0; i < len; i++) {
			result = result * 10 + param[i];
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println("����һ������������ַ���(ֻ������Сд��ĸ������):" + generateString(40));
		System.out
				.println("����һ���������������ĸ�ַ���(ֻ������Сд��ĸ):" + generateMixString(40));
		System.out.println("����һ���������������д��ĸ�ַ���(ֻ������Сд��ĸ):"
				+ generateLowerString(40));
		System.out.println("����һ�������������Сд��ĸ�ַ���(ֻ������Сд��ĸ):"
				+ generateUpperString(40));
		System.out.println("����һ�������Ĵ�0�ַ���:" + generateZeroString(40));
		System.out.println("������������һ���������ַ��������Ȳ���ǰ�油0:"
				+ toFixdLengthString(123, 40));
		int[] in = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("ÿ�����ɵ�lenλ��������ͬ:" + getNotSimple(in, 3));
	}
}
