package tsin.com.bean;

/**
 * @Author:wupeng
 * @time:2018-3-10
 * @desc:freeMarker工具类的参数设置
 */
public class FreeMarkerConfigParam {
    private String templateLocation;
    private String templateName;
    private String outputLocation;
    private String outputName;

    public FreeMarkerConfigParam() {
    }

    public FreeMarkerConfigParam(String templateLocation, String templateName, String outputLocation, String outputName) {
        this.templateLocation = templateLocation;
        this.templateName = templateName;
        this.outputLocation = outputLocation;
        this.outputName = outputName;
    }

    public String getTemplateLocation() {
        return templateLocation;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getOutputLocation() {
        return outputLocation;
    }

    public String getOutputName() {
        return outputName;
    }

    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setOutputLocation(String outputLocation) {
        this.outputLocation = outputLocation;
    }

    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }
}
