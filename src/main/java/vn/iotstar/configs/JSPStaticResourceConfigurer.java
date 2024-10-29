package vn.iotstar.configs;

import org.apache.catalina.*;
import org.springframework.util.ResourceUtils;
import java.net.URI;
import java.net.URL;

public class JSPStaticResourceConfigurer implements LifecycleListener {

    private final Context context;
    private final String subPath = "/META-INF";

    public JSPStaticResourceConfigurer(Context context) {
        this.context = context;
    }

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        if (!event.getType().equals(Lifecycle.CONFIGURE_START_EVENT)) {
            return;
        }

        final URL finalLocation = getUrl();
        this.context.getResources().createWebResourceSet(
            WebResourceRoot.ResourceSetType.RESOURCE_JAR,
            "/",
            finalLocation,
            subPath
        );
    }

    private URL getUrl() {
        final URL location = this.getClass()
            .getProtectionDomain()
            .getCodeSource()
            .getLocation();

        if (ResourceUtils.isFileURL(location)) {
            return location;
        } else if (ResourceUtils.isJarURL(location)) {
            try {
                // When run as fat jar
                // Transform nested:/home/myfiles/Projects/myproj/myjar.jar/!BOOT-INF/classes/!/
                // to jar:file:/home/myfiles/Projects/myproj/myjar.jar!/
                String locationStr = location.getPath()
                    .replaceFirst("^nested:", "")
                    .replaceFirst("/!BOOT-INF/classes/!/$", "!/");

                return new URI("jar:file", locationStr, null).toURL();
            } catch (Exception e) {
                throw new IllegalStateException(
                    "Unable to add new JSP source URI to Tomcat resources", e
                );
            }
        } else {
            throw new IllegalStateException(
                "Cannot add Tomcat resources, unhandleable URL: " + location
            );
        }
    }
}

