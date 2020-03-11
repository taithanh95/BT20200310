package com.bof.thfile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
	private File fileSrc;

	public FileManager(String path) {
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

	public void sumOfNumber(List<String> dataNumberList) {
		int num = 11;
		for (int i = 0; i < dataNumberList.size() - 1; i++) {
			for (int j = i + 1; j < dataNumberList.size(); j++) {
				int value1 = Integer.parseInt(dataNumberList.get(i));
				int value2 = Integer.parseInt(dataNumberList.get(j));

				if (value1 + value2 == num) {
					System.out.println(value1 + "," + value2);
				}
			}
		}
	}
}
