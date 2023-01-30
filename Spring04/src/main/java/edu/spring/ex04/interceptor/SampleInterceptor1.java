package edu.spring.ex04.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor1 extends HandlerInterceptorAdapter{
	private static final Logger logger = LoggerFactory.getLogger(SampleInterceptor1.class);
	
	// * Interceptor
	// - ��Ʈ�ѷ��� ������ ��û(HttpRequest)�� ����(HttpResponse)�� ����ä�� ����
	// - Filter�� Spring Context �ܺο� �����Ͽ� ����
	// - Interceptor�� DispacherServlet�� Controller ���̿��� ����
	// - Interceptor�� Spring Context ���ο� ����

	// * Interceptor ����
	// - HandlerInterceptorAdapter�� ��ӹ޴� Ŭ������ ����
	// - servlet-context.xml�� bean�� url ���� ����
	
	// * Filter, Interceptor, AOP�� �� ��� �뵵�� ���� ����
	// <Filter>
	// - ��ü���� request, response�� ���� ó���� �ʿ��� ��
	// - ���� ���ڵ� ��..
	
	// <Interceptor>
	// - ���� �� ��Ű üũ �� HTTP �������� ������ ó���� �ʿ��� ��
	// - �α��� ���� üũ ��..
	
	// <AOP>
	// - �����Ͻ�(Service)������ ���� ������ ������ �ʿ��� ��
	// - ����, Ʈ�����, ���� ó�� ��...
	
	// * preHandle
	// - ��û(request)�� �ش��ϴ� ��Ʈ�ѷ� �޼ҵ尡 �����ϱ� ����
	// 	 ��û�� ����ä�� �ؾ��� ��ɵ��� �ۼ�
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle ȣ�� =====");
		return super.preHandle(request, response, handler);
	}
	
	
	// * postHandle
	// - ��Ʈ�ѷ� �޼ҵ尡 ����� ���Ŀ�, DispatcherServlet��
	//	 view(JSP)�� ó���ϱ� ���� �ؾ��� ��ɵ��� �ۼ�
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("===== postHanle ȣ�� =====");
		super.postHandle(request, response, handler, modelAndView);
	}
	
	// * afterCompletion
	// - DispatcherServlet�� ���� ȭ��ó�� (view, jsp)�� ���� �Ŀ� �ؾ��� ��ɵ��� �ۼ�
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("===== afterCompletion ȣ�� =====");
		super.afterCompletion(request, response, handler, ex);
	}
	
}




























