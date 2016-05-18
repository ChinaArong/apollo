package com.ctrip.apollo;

import com.ctrip.apollo.common.controller.WebSecurityConfig;
import com.ctrip.apollo.configservice.ConfigServiceApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(excludeFilters = {@Filter(type = FilterType.ASSIGNABLE_TYPE, value = {
    LocalConfigServiceApplication.class, ConfigServiceApplication.class, WebSecurityConfig.class})})
@EnableAutoConfiguration
public class ConfigServiceTestConfiguration {

}