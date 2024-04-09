package com.bjtu.edu.dto;

import java.io.InputStream;

/**
 * @project: mvc
 * @description: 文件处理构造类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class FileHolder {

	private String fileName;
	private InputStream file;

	public FileHolder(String fileName, InputStream file) {
		this.fileName = fileName;
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getFile() {
		return file;
	}

	public void setFile(InputStream file) {
		this.file = file;
	}
}
