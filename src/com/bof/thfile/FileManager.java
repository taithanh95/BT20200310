package com.bof.thfile;

import java.io.*;
import java.util.List;
import java.util.Random;

public class FileManager {
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
	
	public void findCoupleNumber(int sum, List<Integer> dataNumberList) {
		boolean checkFind = false;
		for (int i = 1; i < dataNumberList.size(); i++) {
			if (dataNumberList.get(0) + dataNumberList.get(i) == sum) {
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
			findCoupleNumber(sum, dataNumberList);
	}

	public String writeTextFile(String filePath, List<String> data) {
		if (filePath == null || "".equals(filePath.trim()) || data == null || data.isEmpty()) {
			return "Data input is null";
		}
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			for (int i = 0; i < data.size(); i++) {
				bw.write(data.get(i));
				bw.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Exception when write file";
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return "OK";
	}

	public int getRandomBetweenRange(int min, int max) {
		return min + new Random().nextInt(max);
	}
}
