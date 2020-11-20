package kr.co.hta.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 키보드 입력을 읽어서 타입별로 반환하는 기능을 제공하는 유틸클래스다.
 * @author lee_e
 *
 */
public class Keyboard {

	private static BufferedReader reader = null;
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	private Keyboard() {}
	
	/**
	 * 키보드 입력을 읽어서 정수로 제공한다.
	 * @return 정수, 예외가 발생하면 0을 반환한다.
	 */
	public static int nextInt() {
		try {
			return Integer.parseInt(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			return 0;
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 정수로 제공한다.
	 * @return 정수, 예외가 발생하면 0L을 반환한다.
	 */
	public static long nextLong() {
		try {
			return Long.parseLong(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			return 0L;
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 실수로 제공한다.
	 * @return 정수, 예외가 발생하면 0.0을 반환한다.
	 */
	public static double nextDouble() {
		try {
			return Double.parseDouble(reader.readLine());
		} catch (IOException | NumberFormatException e) {
			return 0.0;
		}
	}
	
	/**
	 * 키보드 입력을 읽어서 문자열로 제공한다.
	 * @return 정수, 예외가 발생하면 빈 문자열을 반환한다.
	 */
	public static String nextString() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return "";
		}
	}
}
