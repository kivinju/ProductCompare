package cn.edu.nju.apoc.outfilter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class BufServletOutputStream extends ServletOutputStream {
	ByteArrayOutputStream bufferedOut;
	public BufServletOutputStream() {
		bufferedOut = new ByteArrayOutputStream();
	}
	public void write(int i) throws IOException {
		bufferedOut.write(i);
	}
	public byte[] toByteArray() {
		return bufferedOut.toByteArray();
	}
	public void reset() {
		bufferedOut.reset();
	}
}
