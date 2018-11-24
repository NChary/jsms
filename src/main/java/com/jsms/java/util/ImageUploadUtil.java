package com.jsms.java.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import com.jsms.java.constants.JsfsLiterals;

import sun.misc.BASE64Decoder;

@Component
public class ImageUploadUtil {

	public String uploadProfileImag(String imgBase64,String code,int type){
		try {
			if(!imgBase64.isEmpty()){
				BASE64Decoder decoder = new BASE64Decoder();
				String img[] = imgBase64.split(",");
				byte[] decodedBytes = decoder.decodeBuffer(img[1]);
				String uploadFile=null;
				if(type==2){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/employee/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==3){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/agent/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==4){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/customer/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}

				ImageIO.setUseCache(false);

				File file = new File(uploadFile);

				FileOutputStream outStream = null;
				BufferedOutputStream bufferredOutputStream = null;

				outStream = new FileOutputStream(file, false);
				bufferredOutputStream = new BufferedOutputStream(outStream);
				bufferredOutputStream.write(decodedBytes);
				bufferredOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code+JsfsLiterals.IMAGE_EXTENSION;
	}
	
	public String uploadIdProofImag(String imgBase64,String code,int type){
		try {
			if(!imgBase64.isEmpty()){
				BASE64Decoder decoder = new BASE64Decoder();
				String img[] = imgBase64.split(",");
				byte[] decodedBytes = decoder.decodeBuffer(img[1]);
				String uploadFile=null;
				if(type==2){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/employee/idproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==3){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/agent/idproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==4){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/customer/idproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}

				ImageIO.setUseCache(false);

				File file = new File(uploadFile);

				FileOutputStream outStream = null;
				BufferedOutputStream bufferredOutputStream = null;

				outStream = new FileOutputStream(file, false);
				bufferredOutputStream = new BufferedOutputStream(outStream);
				bufferredOutputStream.write(decodedBytes);
				bufferredOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code+JsfsLiterals.IMAGE_EXTENSION;
	}
	
	public String uploadAddressProofImag(String imgBase64,String code,int type){
		try {
			if(!imgBase64.isEmpty()){
				BASE64Decoder decoder = new BASE64Decoder();
				String img[] = imgBase64.split(",");
				byte[] decodedBytes = decoder.decodeBuffer(img[1]);
				String uploadFile=null;
				if(type==2){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/employee/addressproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==3){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/agent/addressproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}else if(type==4){
					uploadFile = JsfsLiterals.UPLOAD_URL+"/customer/addressproof/"+code+JsfsLiterals.IMAGE_EXTENSION;
				}

				ImageIO.setUseCache(false);

				File file = new File(uploadFile);

				FileOutputStream outStream = null;
				BufferedOutputStream bufferredOutputStream = null;

				outStream = new FileOutputStream(file, false);
				bufferredOutputStream = new BufferedOutputStream(outStream);
				bufferredOutputStream.write(decodedBytes);
				bufferredOutputStream.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code+JsfsLiterals.IMAGE_EXTENSION;
	}
}
