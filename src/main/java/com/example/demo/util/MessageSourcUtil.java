package com.example.demo.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author lyd
 * @Description: 国际化的核心类，主要就是通过这个类来获取不同语言的value信息
 * @date 13:59
 */
@Component
public class MessageSourcUtil {

	/**
	 * 设置默认语言环境为中文
	 */
	public static final Locale DEF_LOCALE = Locale.CHINA;

	private static MessageSource messageSource;

	public MessageSourcUtil(MessageSource messageSource) {
		MessageSourcUtil.messageSource = messageSource;
	}

	/**
	 * @param code key值，通过这个来获取不同语言下的value
	 * @param args 这是传入的占位符，可以为空
	 * @return {@link String}
	 */
	public static String getMessage(String code, Object... args) {
		// 获得当前的语言环境
		Locale locale = LocaleContextHolder.getLocale();
		if (locale == null) {
			locale = DEF_LOCALE;
		}
		return messageSource.getMessage(code, args, locale);
	}

	public static String getMessage(Locale locale, String code, Object... args) {
		return messageSource.getMessage(code, args, locale);
	}

}