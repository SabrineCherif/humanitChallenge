package coya.auto.task;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static TestProperties INSTANCE;
    private static final String HOMEPAGE_KEY = "homePage";
    private static final String IMPRESSUM_PAGE_KEY = "impressumPage";
    private static final String COYACARE_PAGE_KEY = "coyaCarePage";
    private static final String HOMEPAGE_EN_KEY = "homePageEnglish";
    private static final String PROPERTIES_FILE_NAME = "/test.properties";

    private final Properties properties;

    private TestProperties() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(PROPERTIES_FILE_NAME));
        this.properties = new Properties(properties);
    }

    private static synchronized TestProperties getINSTANCE() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new TestProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return INSTANCE;
    }

    public static String getHomePageUrl() {
        return getINSTANCE().properties.getProperty(HOMEPAGE_KEY);
    }

    public static String getImpreesumUrl() {
        return getINSTANCE().properties.getProperty(IMPRESSUM_PAGE_KEY);
    }
    
    public static String getCoyaCareUrl() {
        return getINSTANCE().properties.getProperty(COYACARE_PAGE_KEY);
    }
    
    public static String getHomePageEnUrl() {
        return getINSTANCE().properties.getProperty(HOMEPAGE_EN_KEY);
    }
}
