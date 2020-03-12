package com.bof.thfile.main;

import java.util.ArrayList;
import java.util.List;

import com.bof.thfile.FileManager;

public class Main {
	public static void main(String[] args) {
		FileManager test = new FileManager();
		List<String> dataNumberList = new ArrayList<>();
		dataNumberList.add("5");
		dataNumberList.add("4");
		dataNumberList.add("3");
		dataNumberList.add("7");
		dataNumberList.add("8");
		dataNumberList.add("4");
		dataNumberList.add("6");
		 
		test.sumOfNumber(dataNumberList );
		
	}
}
