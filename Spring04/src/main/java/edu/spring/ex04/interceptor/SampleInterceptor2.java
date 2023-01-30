package edu.spring.ex04.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor2 extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor2.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle ȣ�� =====");
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		Method method = handlerMethod.getMethod();
		// url ��ο� �ִ� bean ��ü
		logger.info("Bean : " + handlerMethod.getBean());
		// url ��ο� �ִ� method �̸�
		logger.info("method : " + method.getName());
		
		
		return true;
		// preHandle() ���ϰ��� �ǹ�
		// - true : ���� �����Ϸ��� �ߴ� ��Ʈ�ѷ� �޼ҵ� ����
		// - false : ��Ʈ�ѷ� �޼ҵ带 �������� ����
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHanle ȣ�� =====");
		// * ModelAndView ��ü
		// - intercept�� ��ο� �ִ� model�� view�� ������ ������
		String data = (String) modelAndView.getModel().get("data");
		logger.info("data : " + data);
		super.postHandle(request, response, handler, modelAndView);
	}
	


	
}




























