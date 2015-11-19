package token;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * ע�� by BigLake
 * @author Jaffee
 *
 */
public class TokenCreater {

	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	/**
	 * ����һ������������ַ���(������Сд��ĸ������)
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
	
	public static void main(String[] args) {
		Set<String> tokens = new HashSet<String>();
		for(int i=1; i<=10000; i++){
			String token = generateString(30);
			tokens.add(token);
			if(tokens.size() == 1000){
				break;
			}
		}
		for(String token : tokens){
			System.out.println(token);
		}
	}
	

	public static void add(){
		System.out.println("test ADD");
	}
	public static void test(){
		System.out.println("Hello World!");
	}
}
