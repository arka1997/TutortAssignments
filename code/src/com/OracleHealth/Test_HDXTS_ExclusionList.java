package com.OracleHealth;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Test_HDXTS_ExclusionList {
    private static List<String> results = new ArrayList<>();
    public static void main(String[] args) {
        List<String> validatedUrls = new ArrayList<>();
        validatedUrls.add("http://abcd/xyz/evgs/releases/cdf-degt/1.0.0/hdcvc-merchant-migr-1.0.0.jar");
        validatedUrls.add("http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound/1.0.21/hdxts-correspondence-batch-inbound-1.0.21.pom");
        collect(validatedUrls);
    }
    public static void collect(List<String> validatedUrls) {
        boolean boolStatus = true;
        for(String validateUrl : validatedUrls) { // 1 validate Url -> check with Patterns
            for (String patternUrl : HDXTS_EXCLUSION_LIST.keySet()) {
                System.out.println(patternUrl);
                boolStatus = validateUrl.matches(patternUrl);
                if ("true".equals(boolStatus)) {
                    System.out.println("got it");
                    boolStatus = false;
                }
            }
            if("false".equals(boolStatus)){
                results.addAll(validatedUrls);
            }
        }
        System.out.println(results);
    }
    public static final Map<String, String> HDXTS_EXCLUSION_LIST =
            Map.of(
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound/.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/hdxts-correspondence-realtime.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dep/hdxts-dep-dao-jpa-lib.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-api.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-ui.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-portal-ui.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-authorization-ui.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-security-core.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-core-audit.*",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-mock-idp.*",
                    "false"
            );
}
