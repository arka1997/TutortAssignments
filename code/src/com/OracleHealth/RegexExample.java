package com.OracleHealth;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexExample {
    public static void main(String[] args) {
        // Define a string pattern
        String url = "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound/1.0.21/";

        String[] exclusionList = {
                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/batchinbound/hdxts-correspondence-batch-inbound.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/correspondence/hdxts-correspondence-realtime.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dep/hdxts-dep-dao-jpa-lib.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-api.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/eligibility-ui.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-portal-ui.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-authorization-ui.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/hdxts-dragonfly-security-core.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-core-audit.*",

                "http://nexus.edi.cerner.corp/content/repositories/releases/com/cerner/hdxts/dragonfly/security-mock-idp.*"
        };

        boolean anyMatch = Stream.of(exclusionList)
                .map(Pattern::compile).anyMatch(e -> e.matcher(url).matches());
        if (anyMatch) {
            System.out.println("The URL matches one of the patterns.");
        } else {
            System.out.println("The URL does not match any of the patterns.");
        }
    }
}
