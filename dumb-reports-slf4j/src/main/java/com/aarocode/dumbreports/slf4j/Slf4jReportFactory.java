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
package com.aarocode.dumbreports.slf4j;

import org.slf4j.Logger;
import org.slf4j.event.Level;

/**
 * Factory for {@link Slf4jReport Slf4jReports}.
 */
public class Slf4jReportFactory {
    /**
     * Constructor.
     */
    public Slf4jReportFactory() {

    }

    /**
     * Create {@link Slf4jReport Slf4jReports}.
     *
     * @param log {@link Logger}.
     *
     * @return {@link Slf4jReport}.
     */
    public Slf4jReport create(final Logger log) {
        return new Slf4jReport(log);
    }

    /**
     * Create {@link Slf4jReportEntry Slf4jReportEntries}.
     *
     * @param level {@link Level}.
     * @param message Message.
     *
     * @return {@link Slf4jReportEntry}.
     */
    public Slf4jReportEntry createEntry(final Level level, final String message) {
        return new Slf4jReportEntry(level, message);
    }
}