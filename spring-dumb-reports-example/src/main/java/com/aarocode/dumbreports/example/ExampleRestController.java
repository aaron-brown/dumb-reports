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
package com.aarocode.dumbreports.examole;

import com.aarocode.dumbreports.slf4j.Slf4jReport;
import com.aarocode.dumbreports.slf4j.Slf4jReportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/example")
public class ExampleRestController {
    /**
     * {@link Slf4jReportFactory}.
     */
    private final Slf4jReportFactory slf4jReportFactory;

    /**
     * Logger.
     */
    private final Logger log = LoggerFactory.getLogger(ExampleRestController.class);

    /**
     * Constructor.
     */
    ExampleRestController(final Slf4jReportFactory slf4jReportFactory) {
        this.slf4jReportFactory = slf4jReportFactory;
    }

    @RequestMapping(method = RequestMethod.GET)
    Slf4jReport example() {
        Slf4jReport report = slf4jReportFactory.create(log);
        report.debug("This is an example debug");
        report.error("This is an example error");
        report.info("This is an example info");
        report.trace("This is an example trace");
        report.warn("This is an example warn");

        Exception e = new Exception("Example exception");

        report.debug("This is an example debug (with e)", e);
        report.error("This is an example error (with e)", e);
        report.info("This is an example info (with e)", e);
        report.trace("This is an example trace (with e)", e);
        report.warn("This is an example warn (with e)", e);

        return report;
    }
}