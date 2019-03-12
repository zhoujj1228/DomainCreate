package design.DomainCreate.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class StringUtil {
	
	public static void main(String[] args) {
		String changeCamelStrToDBStr = changeCamelStrToDBStr("MYLHashMap");
		System.out.println(changeCamelStrToDBStr);
		writeFile2();
	}
	
	public static String changeCamelStrToDBStr(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			int lastIndex = i - 1;
			if (Character.isUpperCase(charArray[i])) {
				if(lastIndex > -1){
					if (Character.isLowerCase(charArray[lastIndex])) {
						sb.append("_");
					}
				}else{
					//代表是首字母
				}
			}
			sb.append(charArray[i]);
		}
		return sb.toString().toUpperCase();
	}
	
	public static void writeFile2(){
		createFileDeleteSource("D:/Test/txt/20190308.txt");
		File file = new File("D:/Test/txt/20190308.txt");
		String row = "title" + "\r\n";
		row = row + "123456\r\n";
		row = row + "789\r\n";
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
			//没有文件就创建一个
			if(! file.exists()){
				file.createNewFile();
			} else {
				//如果已经存在记录，换行再写入
				row = row + "\r\n\r\n";
			}
			
			//true为追加内容，如果无，则覆盖内容
			bw.write(row);
			System.out.println(row);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static File createFileDeleteSource(String path){
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return file;
	}
}
