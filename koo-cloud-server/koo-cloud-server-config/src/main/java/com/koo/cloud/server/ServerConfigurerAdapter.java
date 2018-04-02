package com.koo.cloud.server;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

@Configuration
public class ServerConfigurerAdapter extends WebMvcConfigurerAdapter {
	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter stringConverter= new StringHttpMessageConverter();  
        stringConverter.setDefaultCharset(Charset.forName("UTF-8"));  
        
		return stringConverter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		
		
		converters.add(responseBodyConverter());
		
		FastJsonHttpMessageConverter4 fastJsonConverter = new FastJsonHttpMessageConverter4();  
		  
        FastJsonConfig fastJsonConfig = new FastJsonConfig();  
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));  
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);  
  
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);  
  
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();  
        MediaType text_plain = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));  
        MediaType text_html = new MediaType(MediaType.TEXT_HTML, Charset.forName("UTF-8"));  
        MediaType x_www_form_urlencoded_utf8 = new MediaType(MediaType.APPLICATION_FORM_URLENCODED, Charset.forName("UTF-8"));  
        supportedMediaTypes.add(text_html);  
        supportedMediaTypes.add(text_plain);  
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);  
        supportedMediaTypes.add(x_www_form_urlencoded_utf8);  
  
        fastJsonConverter.setSupportedMediaTypes(supportedMediaTypes);  
        
        converters.add(fastJsonConverter);
        
        super.configureMessageConverters(converters);
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		
	}

}
