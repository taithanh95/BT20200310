package com.bof.thfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileManager {
	private final static int num = 11;
	private File fileSrc;
	private String path;

	public FileManager(String path) {
		this.path = path;
		this.fileSrc = new File(path);
	}

	public FileManager() {
	}

	public void validateFile() {
		if (!fileSrc.exists()) {
			System.out.println("Khong tim thay file du lieu!");
			return;
		}

		if (fileSrc.length() == 0) {
			System.out.println("Tep khong co du lieu dau vao!");
			return;
		}
	}
	
	public void writeText(String text, boolean isAppend) throws IOException {
		File file = new File(path);
		
		try {
			FileOutputStream out = new FileOutputStream(file, isAppend);
			byte[] buff = text.getBytes();
			out.write(buff);
			
			out.close();
			System.out.println("Ghi file thanh cong");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readText() {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		try {
			String text = "";
			FileInputStream in = new FileInputStream(file);
			byte buff[] = new byte[1024];
			
			int len = in.read(buff);
			while (len > 0) {
				text += new String(buff, 0, len);
				len = in.read(buff);
			}
			in.close();
			System.out.println("Text: " +"\n" + text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void findCoupleNumber(List<Integer> dataNumberList) {
		boolean checkFind = false;
		for (int i = 1; i < dataNumberList.size(); i++) {
			if (dataNumberList.get(0) + dataNumberList.get(i) == num) {
				checkFind = true;
				System.out.println(dataNumberList.get(0) + "," + dataNumberList.get(i));
				dataNumberList.remove(i);
				dataNumberList.remove(0);
				break;
			}
		}
		if (!checkFind)
			dataNumberList.remove(0);
		if (dataNumberList.size() >= 2)
			findCoupleNumber(dataNumberList);
	}
}
