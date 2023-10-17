package com.OracleHealth;

import java.util.Map;

public class Test_HDXTS_ExclusionList_REGEX {
    public static void main(String[] args) {
        Boolean bool = true;
        String url = "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound/";
        String pattern = "https://example.com/page\\d+";
//        boolStatus =
    }
    public static final Map<String, String> HDXTS_EXCLUSION_LIST =
            Map.of(
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/hdxts-correspondence-realtime/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dep/hdxts-dep-dao-jpa-lib/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-api/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-ui/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-portal-ui/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-authorization-ui/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-security-core/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-core-audit/",
                    "false",
                    "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-mock-idp/",
                    "false"
            );
}
