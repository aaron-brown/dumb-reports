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
import com.aarocode.dumbreports.Report;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.Serializable;

/**
 * <b>StatusReport</b> is for creating reports
 * where its {@link #getEntries entries} are associated
 * with some kind of {@link StatusReportEntry#getStatus status}.
 *
 * <p>The <b>StatusReport</b> itself also has a
 * {@link #getStatus} status.
 */
public class StatusReport implements Report<StatusReportEntry>, Serializable {
    /**
     * Status (overall).
     */
    private Serializable status;

    /**
     * Entries.
     */
    private List<StatusReportEntry> entries;

    /**
     * Constructor.
     */
    public StatusReport() {
        entries = new ArrayList<>();
    }

    /**
     * Constructor.
     *
     * @param status Initial {@link #setStatus status}.
     *
     * Sets an initial {@link #setStatus status}.
     */
    public StatusReport(Serializable status) {
        this();
        this.status = status;
    }

    public Serializable getStatus() {
        return status;
    }

    public void setStatus(Serializable status) {
        this.status = status;
    }

    /**
     * {@inheritDoc}
     */
    public Collection<StatusReportEntry> getEntries() {
        return entries;
    }

    /**
     * Add a {@link StatusReportEntry} and
     * {@link #setStatus set status} at the same time.
     *
     * @param reportStatus {@link #setStatus Status}
     * @param status       Status
     * @param entry        Entry
     *
     * @return Same as {@link Collection#add}.
     */
    public boolean add(Serializable reportStatus, final Serializable status, final String entry) {
        setStatus(reportStatus);
        return add(status, entry);
    }

    /**
     * Add a {@link StatusReportEntry}.
     *
     * @param status Status
     * @param entry  Entry
     *
     * @return Same as {@link Collection#add}.
     */
    public boolean add(final Serializable status, final String entry) {
        return add(new StatusReportEntry(status, entry));
    }
}