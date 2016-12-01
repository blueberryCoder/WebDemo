package com.blueberry.spittr.conf;

import com.blueberry.spittr.services.SpitterService;
import com.blueberry.spittr.services.impl.SpitterServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import javax.persistence.Basic;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Administrator on 12/1/2016.
 */
@Configurable
public class RpcConfig {

    @Bean
    public SpitterService spitterService() {
        return new SpitterServiceImpl();
    }
//
//    /**
//     * 导出RMI服务。
//     *
//     * @param spitterService
//     * @return
//     */
//    @Bean
//    public RmiServiceExporter rmiServiceExporter(SpitterService spitterService) {
//        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
//        rmiServiceExporter.setService(spitterService);
//        rmiServiceExporter.setServiceName("SpitterService");
//        rmiServiceExporter.setServiceInterface(SpitterService.class);
//        return rmiServiceExporter;
//    }
//
//    /**
//     * 客户端使用RMI服务
//     *
//     * @return
//     */
//    @Bean
//    public RmiProxyFactoryBean spitterService(){
//        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
//        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/SpitterService");
//        rmiProxyFactoryBean.setServiceInterface(SpitterService.class);
//        return rmiProxyFactoryBean;
//    }

//    /**
//     * 导出Hessian 服务。
//     * Hessian是基于Http的，所以HessianServiceExporter实现是一个SpringMvc控制器。
//     * 所以使用它需要配置 1.在ServletMapping中加入 {*.service},2配置HandlerMapping
//     *
//     * @param spitterService
//     * @return
//     */
//    @Bean
//    public HessianServiceExporter hessianServiceExporter(SpitterService spitterService) {
//        HessianServiceExporter exporter = new HessianServiceExporter();
//        exporter.setService(spitterService);
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }
//
//    /**
//     * 将/spitter.service的请求最终会被 hessianSpitterService bean所处理
//     * (hessianExportedSpitterService实际是SpitterServiceImpl的一个代理)
//     *
//     * @return
//     */
//    @Bean
//    public HandlerMapping hessianMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        Properties prop = new Properties();
//        prop.setProperty("/spitter.service", "hessianExportedSpitterService");
//        mapping.setMappings(prop);
//        return mapping;
//    }
//
//    /**
//     * Hessian客户端使用
//     * @return
//     */
//    @Bean
//    public HessianProxyFactoryBean hessianService(){
//        HessianProxyFactoryBean proxyFactoryBean = new HessianProxyFactoryBean();
//        proxyFactoryBean.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
//        proxyFactoryBean.setServiceInterface(SpitterService.class);
//        return proxyFactoryBean;
//    }


    /**
     * Burlap服务
     * Burlap服务的使用和Hessian类似
     * Burlap服务是xml和Hessian服务是二进制
     */


//    /**
//     * HttpInvoker
//     * 由Spring开发团队开发，配置和Hessian/Burlap类似
//     *
//     * @param spitterService
//     * @return
//     */
//    @Bean
//    public HttpInvokerServiceExporter httpInvokerServiceExporter(SpitterService spitterService) {
//        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
//        exporter.setService(spitterService);
//        exporter.setServiceInterface(SpitterService.class);
//        return exporter;
//    }
//
//    @Bean
//    public HandlerMapping httpInvokerMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        Properties prop = new Properties();
//        prop.setProperty("/spitter.service", "httpExportedSpitterService");
//        mapping.setMappings(prop);
//        return mapping;
//    }
//
//    /**
//     * 客户端使用 HttpInvoker
//     *
//     * @return
//     */
//    @Bean
//    public HttpInvokerProxyFactoryBean httpInvoker() {
//        HttpInvokerProxyFactoryBean proxyFactoryBean
//                = new HttpInvokerProxyFactoryBean();
//        proxyFactoryBean.setServiceUrl("http://localhost:8080/Spitter/spitter.service");
//        proxyFactoryBean.setServiceInterface(SpitterService.class);
//        return proxyFactoryBean;
//    }


//    /**
//     * 配置WebService导出
//     *
//     * @return
//     */
//    @Bean
//    public SimpleJaxWsServiceExporter jaxWsServiceExporter() {
//        SimpleJaxWsServiceExporter exporter
//                = new SimpleJaxWsServiceExporter();
//        exporter.setBaseAddress("http://localhost:8888/services/");
//        return exporter;
//    }
//
//
//    /**
//     * 客户端使用。
//     *
//     * @return
//     * @throws MalformedURLException
//     */
//    @Bean
//    public JaxWsPortProxyFactoryBean jaxWsService() throws MalformedURLException {
//        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
//
//        URL url = new URL("http://localhost:8080/services/SpitterServices?wsdl");
//        proxy.setWsdlDocumentUrl(url);
//        proxy.setNamespaceUri("http://spitter.com");
//        /**
//         * 剩下的service,port通常会在WSDL中确定。
//         *  假设WSDL文件如下:

//         * <wsdl:definitions targetNamespace="http://spitter.com">
//         *      ...
//         *      <wsdl:service name="spitterService">
//         *          <wsdl:port name="spitterServiceHttpPort"
//         *          binding="tns:spitterServiceHttpBinding"></wsdl:port>
//         *          </wsdl:service>
//         *      ...
//         *     </wsdl:definitions>
//         */
//
//        proxy.setServiceInterface(SpitterService.class);
//        return proxy;
//    }

}
