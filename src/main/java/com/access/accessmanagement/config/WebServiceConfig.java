package com.access.accessmanagement.config;

import java.util.List;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
//import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter{
	
//	@Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(applicationContext);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean<>(servlet, "/ws/*");
//    }
//
//    @Bean(name = "myService")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema myServiceSchema) {
//        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
//        wsdl11Definition.setPortTypeName("MyServicePort");
//        wsdl11Definition.setLocationUri("/ws");
//        wsdl11Definition.setTargetNamespace("http://example.com/myservice");
//        wsdl11Definition.setSchema(myServiceSchema);
//        return wsdl11Definition;
//    }
//
//    @Bean
//    public XsdSchema myServiceSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
//    }

	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
	}

	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("AccessPort");
		definition.setTargetNamespace("http://access/management");
		definition.setLocationUri("/ws");
		definition.setSchema(coursesSchema);
		return definition;
	}

	@Bean
	public XsdSchema coursesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}


//	@Bean
//	public Wss4jSecurityInterceptor securityInterceptor() {
//		Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
//		securityInterceptor.setSecurementActions("UsernameToken");
//		securityInterceptor.setSecurementUsername("user");
//		securityInterceptor.setSecurementPassword("password");
//
//		return securityInterceptor;
//	}
//
//	@Override
//	public void addInterceptors(List<EndpointInterceptor> interceptors) {
//		interceptors.add(securityInterceptor());
//	}

}
