/*
 * Copyright 2020 Aaron Brown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.aarocode.dumbreports.spring.configuration;

import com.aarocode.dumbreports.status.StatusReportFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Configuration
@ConditionalOnClass(StatusReportFactory.class)
public class DumbStatusReportsAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public StatusReportFactory statusReportFactory() {
        return new StatusReportFactory();
    }
}
