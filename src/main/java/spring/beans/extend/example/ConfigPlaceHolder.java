package spring.beans.extend.example;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by zhangjun on 2017/12/27.
 * <p>
 * 其他包出现过，只是为了粘贴过来总结spring扩展用法
 * </p>
 */
public class ConfigPlaceHolder extends PropertySourcesPlaceholderConfigurer {
    private String profile;
    private static final String DEFAULT_PROFILE_NAME = "profile.properties";
    private String profileFileName;
    private Properties properties;

    /**
     * 加载profile属性
     */
    private void loadConfig() {
        if (StringUtils.isNotBlank(profile)) {
            return;
        }
        try {
            if (StringUtils.isBlank(profileFileName)) {
                profileFileName = DEFAULT_PROFILE_NAME;
            }
            properties = PropertiesLoaderUtils.loadAllProperties(profileFileName);
            profile = properties.getProperty("profile");
            setProperties(properties);
        } catch (Exception e) {
            logger.error("load profileFile error,profileName is " + profileFileName, e);
            throw new RuntimeException("can't find properties in classpath");
        }
    }

    @Override
    public void setLocations(Resource... locations) {
        loadConfig();
        try {
            if (StringUtils.isBlank(profile)) {
                throw new Exception("profile is empty,please check default properties!");
            }
            List<Resource> resources = new ArrayList<>();
            if (locations != null) {
                for (Resource location : locations) {
                    ClassPathResource classPathResource = (ClassPathResource) location;
                    Resource resource = new ClassPathResource(classPathResource.getPath().replace("${profile}", profile));
                    if (checkClassPathResource(resource)) {
                        logger.info("load resource [" + resource.getFilename() + "]");
                        System.out.println("load resource [" + resource.getFilename() + "]");
                        setLocation(resource);
                        resources.add(resource);
                    }
                }
            }
            super.setLocations(resources.toArray(new Resource[resources.size()]));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("can't load properties file of profile " + profile, e);
        }
    }

    @Override
    public Properties mergeProperties() throws IOException {
        Properties properties = super.mergeProperties();
        properties.put("profile", profile);
        return properties;
    }

    private boolean checkClassPathResource(Resource resource) {
        String fileName = resource.getFilename();
        return resource.exists() && resource.isReadable()
                && "properties".equals(fileName.substring(fileName.lastIndexOf(".") + 1));
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getProfileFileName() {
        return profileFileName;
    }

    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}
