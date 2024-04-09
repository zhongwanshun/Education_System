package com.bjtu.edu.dto;

import java.io.InputStream;

/**
 * @project: mvc
 * @description: 图片处理构造类
 * @author: wanShun
 * @create: 2022/11/30
 */
public class ImageHolder {

	private String imageName;
	private InputStream image;

	public ImageHolder(String imageName, InputStream image) {
		this.imageName = imageName;
		this.image = image;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public InputStream getImage() {
		return image;
	}

	public void setImage(InputStream image) {
		this.image = image;
	}

}
