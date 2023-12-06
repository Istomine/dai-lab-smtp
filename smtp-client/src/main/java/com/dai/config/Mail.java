package com.dai.config;

/**
 * Record to store an email who is caracterised by a subject and a body
 * @param subject subject of a mail
 * @param body body of the mail
 */
public record Mail(String subject, String body) {

}
