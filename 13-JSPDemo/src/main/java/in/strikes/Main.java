package in.strikes;


import in.strikes.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JasperInitializer;
import org.apache.jasper.servlet.JspServlet;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.File;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        // Boiler-plate code
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);

        tomcat.getConnector();

        String contextPath = "";
        String baseDoc = new File("src/main/webapp").getAbsolutePath();

        Context context = tomcat.addWebapp(contextPath, baseDoc);

        context.addServletContainerInitializer(new JasperInitializer(), Set.of());

        Wrapper jspWrapper = Tomcat.addServlet(context, "jsp", new JspServlet());
        jspWrapper.setLoadOnStartup(3);
        context.addServletMappingDecoded("*.jsp", "jsp");
        context.addServletMappingDecoded("*.jspx", "jsp");

        // IOC Container app
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();

        springContext.register(WebConfig.class);

        // Dispatcher Servlet
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(springContext);

        Wrapper dispatcherWrapper = Tomcat.addServlet(
                context, "dispatcherServlet", dispatcherServlet);

        dispatcherWrapper.setLoadOnStartup(1);

        context.addServletMappingDecoded(
                "/", "dispatcherServlet");

        tomcat.start();

        System.out.println("Tomcat started on port 8080");

        // keep server running
        tomcat.getServer().await();
    }
}