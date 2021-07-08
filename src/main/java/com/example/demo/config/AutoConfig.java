package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


/**
 * @author lyd
 * @Description:
 * @date 14:50
 */
@Configuration
public class AutoConfig implements WebMvcConfigurer {
	/**
	 * 这个如果不存在，则会抛异常: nested exception is java.lang.UnsupportedOperationException: Cannot change HTTP accept header - use a different locale resolution strategy
	 *
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		// 也可以换成 SessionLocalResolver, 区别在于国际化的应用范围
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		return localeResolver;
	}

	/**
	 * 根据请求参数，来设置本地化
	 *
	 * @return
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}


	/**
	 * 添加拦截器
	 *
	 * @param interceptorRegistry 拦截器注册
	 */
	@Override
	public void addInterceptors(InterceptorRegistry interceptorRegistry) {
		interceptorRegistry.addInterceptor(localeChangeInterceptor());
	}
}