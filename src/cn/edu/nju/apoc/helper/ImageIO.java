package cn.edu.nju.apoc.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageIO {
	public byte[] imread(String path){
		try {
			File file = new File(path); 
			BufferedInputStream in = new  BufferedInputStream(new FileInputStream(file));
			byte[] im = new byte[(int) file.length()];
			in.read(im);
			in.close();
			return im;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean imwrite(String path,byte[] img){
		BufferedOutputStream out;
		try {
			out = new BufferedOutputStream(new FileOutputStream(new File(path)));
			out.write(img);
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
