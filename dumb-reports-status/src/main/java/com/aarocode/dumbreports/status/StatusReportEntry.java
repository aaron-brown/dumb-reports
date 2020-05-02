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

/**
 * Represents an {@link StatusReport#getEntries entry}.
 */
public class StatusReportEntry implements Serializable {
    /**
     * Status.
     */
    final Serializable status;

    /**
     * Entry.
     */
    final String entry;

    /**
     * Constructor.
     *
     * @param status Status.
     * @param entry  Entry.
     */
    public StatusReportEntry(final Serializable status, final String entry) {
        this.status = status;
        this.entry = entry;
    }

    public Serializable getStatus() {
        return status;
    }

    public String getEntry() {
        return entry;
    }
}