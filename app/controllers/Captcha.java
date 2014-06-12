package controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

import play.Logger;
import play.cache.Cache;
import play.mvc.Controller;
import play.mvc.Result;

public class Captcha extends Controller {

	public static Result getCaptCha(String captchaName) {
		
		DefaultKaptcha captchaPro = new DefaultKaptcha();
		captchaPro.setConfig(new Config(new Properties()));
		String text = captchaPro.createText();
		//Logger.debug("Captcha:" + text);// U can put the text in cache.
		//Cache.set("captcha_"+captchaName, text,120);	
		session("captcha_"+captchaName, text);
		BufferedImage img = captchaPro.createImage(text);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(img, "jpg", baos);
			baos.flush();
		} catch (IOException e) {
			Logger.debug(e.getMessage());
		}
		return ok(baos.toByteArray()).as("image/jpg");

	}
	
	public static boolean checkCaptcha(String captchaName,String captChaValue){
		String captChaStore = String.valueOf(session("captcha_"+captchaName));	
		Logger.info(captChaStore+"--"+captChaValue); 
		return captChaStore.equals(captChaValue);
	}
	
}
