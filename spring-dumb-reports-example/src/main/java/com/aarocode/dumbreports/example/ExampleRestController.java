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

import com.aarocode.dumbreports.status.StatusReport;
import com.aarocode.dumbreports.status.StatusReportFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/example")
public class ExampleRestController {
    /**
     * {@link StatusReportFactory}.
     */
    private final StatusReportFactory statusReportFactory;

    /**
     * Constructor.
     */
    ExampleRestController(final StatusReportFactory statusReportFactory) {
        this.statusReportFactory = statusReportFactory;
    }

    @RequestMapping(method = RequestMethod.GET)
    StatusReport example() {
        StatusReport report = statusReportFactory.create();
        report.add("COMPLETE", "Task 1 complete");
        report.add("MANUAL", "Task 2 needs to be done manually");
        report.add("FAILED", "Task 3 failed, cause: Mock failure");
        report.setStatus("COMPLETE_WITH_ERROR");

        return report;
    }
}