package com.artion.prscrn;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

interface ImageType {
	public final static String JPG = "JPG";
	public final static String PNG = "PNG";
	public final static String GIF = "GIF";
}

/**
 * ��Ļ��ȡ �� �ο� http://www.iteye.com/topic/289052 ʵ�� cn.iamsese.prj.db.helper
 * Author: vb2005xu [JAVA����]
 */
public class ScreenDumpHelper {
	
	private final static String BASE_FILEPATH = "E:/PrScrn";
	
	/** ScreenDumpHelper ��̬���� */
	private static ScreenDumpHelper defaultScreenDumpHelper;
	
	private static boolean isAddFormat = true;

	/**
	 * ���� ScreenDumpHelper ��� ��̬ʵ��
	 * 
	 * @return ScreenDumpHelper
	 */
	public static ScreenDumpHelper getDefaultScreenDumpHelper() {
		if (defaultScreenDumpHelper == null)
			return new ScreenDumpHelper();
		return defaultScreenDumpHelper;
	}

	/**
	 * ���캯�������� ���������Ĭ��ֵ -- ȱʡΪȫ��
	 */
	public ScreenDumpHelper() {
		Dimension dime = Toolkit.getDefaultToolkit().getScreenSize();
		this.setScreenArea(new Rectangle(dime));
	}

	/**
	 * ���ý����ķ�Χ
	 */
	private Rectangle screenArea;

	public Rectangle getScreenArea() {
		return this.screenArea;
	}

	public void setScreenArea(Rectangle screenArea) {
		this.screenArea = screenArea;
	}

	public void setScreenArea(int x, int y, int width, int height) {
		this.screenArea = new Rectangle(x, y, width, height);
	}

	/**
	 * ����һ�� BufferedImage
	 * 
	 * @return
	 * @throws AWTException
	 */
	private BufferedImage getBufferedImage() throws AWTException {
		BufferedImage imgBuf = null;
		;
		imgBuf = (new Robot()).createScreenCapture(this.getScreenArea());
		return imgBuf;
	}

	/**
	 * �� ͼ������д�� �������ȥ,�����ٴ���
	 * 
	 * @param fileFormat
	 * @param output
	 * @return
	 */
	public boolean saveToOutputStream(String fileFormat, OutputStream output) {
		try {
			ImageIO.write(this.getBufferedImage(), fileFormat, output);
		} catch (AWTException e) {
			return false;
			// e.printStackTrace();
		} catch (IOException e) {
			return false;
			// e.printStackTrace();
		}
		return true;
	}

	/**
	 * �����ļ���ʽ ��������ļ�����
	 * 
	 * @param fileFormat
	 * @return
	 */
	public String getRandomFileName(String filePath, String fileFormat) {
		if(filePath == null){
			filePath = BASE_FILEPATH;
		}
		
		checkIfNeedCreateDir(filePath);
		
		return filePath + "/" + getFormatFileName(fileFormat);
	}
	
	public void checkIfNeedCreateDir(String filePath) {
		File file = new File(filePath);
		
		if(!file.exists()){
			file.mkdirs();
		}
	}

	/**
	 * ץȡ ָ������Ľ�ͼ ��ָ����ʽ���ļ��� -- ��������Ǻ���,���еĶ���Χ������չ���� * ͼƬ�ı��벢�����Ժ�׺�����ж�: ����s.jpg
	 * ��������png����,��ô���ͼƬ����png��ʽ��
	 * 
	 * @param fileName
	 * @param fileFormat
	 * @return boolean
	 */
	public boolean saveToFile(String filePath, String fileFormat) {
//		if (fileName == null)
			String fileName = getRandomFileName(filePath, fileFormat);
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			this.saveToOutputStream(fileFormat, fos);
		} catch (FileNotFoundException e) {
			System.out.println("�ǳ����ļ����ܴ����ֻ򸲸Ǵ��ļ�: " + fileName);
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * ץȡ ָ�� Rectangle ����Ľ�ͼ ��ָ����ʽ���ļ���
	 * 
	 * @param fileName
	 * @param fileFormat
	 * @param screenArea
	 * @return
	 */
	public boolean saveToFile(String fileName, String fileFormat,
			Rectangle screenArea) {
		this.setScreenArea(screenArea);
		return this.saveToFile(fileName, fileFormat);
	}

	/**
	 * ץȡ ָ������Ľ�ͼ ��ָ����ʽ���ļ���
	 * 
	 * @param fileName
	 * @param fileFormat
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public boolean saveToFile(String fileName, String fileFormat, int x, int y,
			int width, int height) {
		this.setScreenArea(x, y, width, height);
		return this.saveToFile(fileName, fileFormat);
	}

	/**
	 * ����ͼʹ�� JPG ����
	 * 
	 * @param fileName
	 */
	public void saveToJPG(String fileName) {
		this.saveToFile(fileName, ImageType.JPG);
	}

	public void saveToJPG(String fileName, Rectangle screenArea) {
		this.saveToFile(fileName, ImageType.JPG, screenArea);
	}

	public void saveToJPG(String filePath, int x, int y, int width, int height) {
		this.saveToFile(filePath, ImageType.JPG, x, y, width, height);
	}

	/**
	 * ����ͼʹ�� PNG ����
	 * 
	 * @param fileName
	 */
	public void saveToPNG(String fileName) {
		this.saveToFile(fileName, ImageType.PNG);
	}

	public void saveToPNG(String fileName, Rectangle screenArea) {
		this.saveToFile(fileName, ImageType.PNG, screenArea);
	}

	public void saveToPNG(String fileName, int x, int y, int width, int height) {
		this.saveToFile(fileName, ImageType.PNG, x, y, width, height);
	}

	public void saveToGIF(String fileName) {
		throw new UnsupportedOperationException("��֧�ֱ��浽GIF�ļ�");
		// this.saveToFile(fileName, ImageType.GIF);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		for (int i = 0; i < 5; i++)
//			ScreenDumpHelper.getDefaultScreenDumpHelper().saveToJPG(null,
//					i * 150, i * 150, 400, 300);
		
		String filePath = null;
		
		if(args != null && args.length > 0) {
			filePath = args[0];
			if(args.length > 1) {
				isAddFormat = Boolean.valueOf(args[1]);
			}
		}
		
		long t1 = System.currentTimeMillis();
		//��ȡ��Ļ�Ŀ�
		int w = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		//��ȡ��Ļ�ĸ�
		int h = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		System.out.println("w:h == " + w + " x " + h);
		
		ScreenDumpHelper.getDefaultScreenDumpHelper().saveToJPG(filePath, 0, 0, w, h);
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("��ʱ(ms)��" + (t2-t1));
	}

	public static String getFormatFileName(String fileFormat) {
		Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    	return sdf.format(date) + ((isAddFormat) ? ("." + fileFormat) : "");
    }
}
