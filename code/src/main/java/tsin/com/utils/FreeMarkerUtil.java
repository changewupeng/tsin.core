package tsin.com.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import tsin.com.bean.FreeMarkerConfigParam;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerUtil {

    /**
     * 获取freemarker的配置信息
     *
     * @param templateLocation
     * @return
     */
    public static Configuration getConfiguration(String templateLocation) {
        Configuration cfg = null;
        try {
            cfg = new Configuration(Configuration.VERSION_2_3_23);
            ClassLoader classLoader = FreeMarkerUtil.class.getClassLoader();
            URL resource = classLoader.getResource(templateLocation);
            String path = resource.getPath();
            cfg.setDirectoryForTemplateLoading(new File(path));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
        } catch (Exception e) {
            throw new RuntimeException("生成freemarker配置信息出错" + e.getMessage());
        }
        return cfg;
    }

    /**
     * 获取freemarker模板
     *
     * @param configuration
     * @param templateName
     * @return
     */
    public static Template getTemplate(Configuration configuration, String templateName) {
        Template template = null;
        try {
            template = configuration.getTemplate(templateName);
        } catch (Exception e) {
            throw new RuntimeException("获取freemarker模板出错" + e.getMessage());
        }
        return template;
    }

    /**
     * 执行freemarker函数，生成结果
     * @param freeMarkerConfigParam
     * @param map
     */
    public static void generateFreeMarkerOutPut(FreeMarkerConfigParam freeMarkerConfigParam, Map map) {
        try {
            Configuration cfg = getConfiguration(freeMarkerConfigParam.getTemplateLocation());
            if(null!=cfg){
                Template template = getTemplate(cfg,freeMarkerConfigParam.getTemplateName());
                FileWriter out = new FileWriter(freeMarkerConfigParam.getOutputLocation()+File.separator+freeMarkerConfigParam.getOutputName());
                template.process(map,out);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){

        Map root = new HashMap();
        Map kk = new HashMap();
        root.put("user", "wupeng");
        kk.put("url","www.baidu.com");
        kk.put("name","baidu");
        root.put("net",kk);

        FreeMarkerConfigParam freeMarkerConfigParam = new FreeMarkerConfigParam();
        freeMarkerConfigParam.setTemplateLocation("freemarker/exampleTemplate/");
        freeMarkerConfigParam.setTemplateName("exampletemplate.html.ftl");
        freeMarkerConfigParam.setOutputLocation("/home/wupeng/myself/tsin.core/code/target/classes/freemarker/exampleTemplate/");
        freeMarkerConfigParam.setOutputName("exampletemplate.html");

        FreeMarkerUtil.generateFreeMarkerOutPut(freeMarkerConfigParam,root);

    }

}
