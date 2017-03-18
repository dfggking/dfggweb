package com.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {

	public static void main(String[] args) {
		File path = new File("D:/");
		String[] list;
		if(path.length() == 0){
			list = path.list();
		}else{
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile("资料");
				@Override
				public boolean accept(File dir, String name) {
					// TODO Auto-generated method stub
					return pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list){
			System.out.println(dirItem);
		}
	}
}
