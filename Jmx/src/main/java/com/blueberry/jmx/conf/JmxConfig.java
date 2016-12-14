package com.blueberry.jmx.conf;

import com.blueberry.jmx.controller.JmxController;
import com.blueberry.jmx.controller.JmxControllerManagedOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.export.assembler.InterfaceBasedMBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MBeanInfoAssembler;
import org.springframework.jmx.export.assembler.MethodNameBasedMBeanInfoAssembler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 12/14/2016.
 *
 * https://tomcat.apache.org/tomcat-8.0-doc/monitoring.html
 */
@Configuration
@EnableMBeanExport
public class JmxConfig {

//    @Bean
//    public MBeanExporter mBeanExporter(JmxController jmxController, MBeanInfoAssembler infoAssembler){
//        MBeanExporter exporter = new MBeanExporter();
//        Map<String,Object> beans = new HashMap<>();
//        beans.put("spitter:name=JmxController",jmxController);
//        exporter.setBeans(beans);
//        exporter.setAssembler(infoAssembler);
//        return  exporter;
//    }

//    /**
//     * 通过名称暴露方法
//     * @return
//     */
//    @Bean
//    public MethodNameBasedMBeanInfoAssembler methodNameBasedMBeanInfoAssembler(){
//        MethodNameBasedMBeanInfoAssembler assembler=
//                new MethodNameBasedMBeanInfoAssembler();
//        assembler.setManagedMethods("setCount","getCount");
//        return assembler;
//    }

//    /**
//     * 使用接口定义MBean的属性和操作
//     * @return
//     */
//    @Bean
//    public InterfaceBasedMBeanInfoAssembler interfaceBasedMBeanInfoAssembler(){
//        InterfaceBasedMBeanInfoAssembler assembler =
//                new InterfaceBasedMBeanInfoAssembler();
//        assembler.setManagedInterfaces(new Class<?>[]{JmxControllerManagedOperations.class});
//        return assembler;
//    }

}
