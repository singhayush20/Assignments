package com.ayushsingh.ta_candidate.config.drive;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("drive")
public record DriveConfigurationProperties(String folderId, String urlPrefix) {
}
