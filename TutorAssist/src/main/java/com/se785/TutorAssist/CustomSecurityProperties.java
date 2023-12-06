package com.se785.TutorAssist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CustomSecurityProperties extends SecurityProperties {
    public CustomSecurityProperties() {
        // the default list is empty
        List<String> ignoredPaths = new ArrayList<>();
        ignoredPaths.add("none");
    }
}