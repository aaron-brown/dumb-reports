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
package com.aarocode.dumbreports.status;

import java.io.Serializable;

public class StatusReportFactory {
    /**
     * Constructor.
     */
    public StatusReportFactory() {

    }

    /**
     * Create a {@link StatusReport}.
     *
     * @return {@link StatusReport}.
     */
    public StatusReport create() {
        return new StatusReport();
    }

    /**
     * Create a {@link StatusReport}.
     *
     * @param status {@link StatusReport#setStatus status}.
     *
     * @return {@link StatusReport}.
     */
    public StatusReport create(Serializable status) {
        return new StatusReport(status);
    }

    /**
     * Create a {@link StatusReportEntry}.
     *
     * @param status Status
     * @param entry  Entry
     *
     * @return {@link StatusReportEntry}.
     */
    public StatusReportEntry createEntry(final Serializable status, final String entry) {
        return new StatusReportEntry(status, entry);
    }
}