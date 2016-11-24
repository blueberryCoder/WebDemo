package com.blueberry.spittr;


import com.blueberry.spittr.conf.*;
import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;
import java.io.File;

/**
 * Created by Administrator on 2016/11/9.
 */
public class SpittrWebAppInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {


    private Logger logger = Logger.getLogger(SpittrWebAppInitializer.class);
    private String tempPath;

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebConfig.class, JspConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 添加过滤器
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

//        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", "");
//        myServlet.setMultipartConfig();
//        myServlet.addMapping("/xxx");
//        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", "");
//        myFilter.addMappingForUrlPatterns(null, false, "xx/xxx");
        File tempDir = new File(servletContext.getContextPath() + Constants.TEMP_PATH);
        if (!tempDir.exists()) {
            tempDir.mkdirs();
        }
        tempPath = tempDir.getAbsolutePath();
        logger.info(tempPath);
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        //暂时写一个绝对路径
        registration.setMultipartConfig(new MultipartConfigElement(tempPath));
    }


}
