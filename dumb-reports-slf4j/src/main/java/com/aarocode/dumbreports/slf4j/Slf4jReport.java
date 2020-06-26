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

import com.aarocode.dumbreports.Report;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/**
 * <b>Slf4jReport</b> enables the use of a
 * {@link Report} to be used in the same manner
 * as a {@link Logger}.
 *
 * <p><b>Note</b>: This paradigm is limited to only
 * those {@link Logger} methods which take
 * {@code (String msg)} or
 * {@code (String msg, Throwable t)}.
 */
public class Slf4jReport implements Report<Slf4jReportEntry>, Serializable {
    /**
     * {@link Logger}.
     */
    private final Logger log;

    /**
     * Entries.
     */
    private List<Slf4jReportEntry> entries;

    /**
     * Constructor.
     *
     * @param log {@link Logger}.
     */
    public Slf4jReport(final Logger log) {
        this.entries = new ArrayList<>();
        this.log = log;
    }

    /**
     * {@inheritDoc}
     */
    public Collection<Slf4jReportEntry> getEntries() {
        return entries;
    }

    /**
     * Wraps {@link Logger#debug(String)}.
     *
     * @param msg Log Message.
     */
    public void debug(String msg) {
        log.debug(msg);
        add(new Slf4jReportEntry(Level.DEBUG, msg));
    }

    /**
     * Wraps {@link Logger#debug(String, Throwable)}.
     *
     * @param msg Log Message.
     * @param t   Cause.
     */
    public void debug(String msg, Throwable t) {
        log.debug(msg, t);
        add(new Slf4jReportEntry(Level.DEBUG, msg));
    }

    /**
     * Wraps {@link Logger#error(String)}.
     *
     * @param msg Log Message.
     */
    public void error(String msg) {
        log.error(msg);
        add(new Slf4jReportEntry(Level.ERROR, msg));
    }

    /**
     * Wraps {@link Logger#error(String, Throwable)}.
     *
     * @param msg Log Message.
     * @param t   Cause.
     */
    public void error(String msg, Throwable t) {
        log.error(msg, t);
        add(new Slf4jReportEntry(Level.ERROR, msg));
    }

    /**
     * Wraps {@link Logger#info(String)}.
     *
     * @param msg Log Message.
     */
    public void info(String msg) {
        log.info(msg);
        add(new Slf4jReportEntry(Level.INFO, msg));
    }

    /**
     * Wraps {@link Logger#info(String, Throwable)}.
     *
     * @param msg Log Message.
     * @param t   Cause.
     */
    public void info(String msg, Throwable t) {
        log.info(msg, t);
        add(new Slf4jReportEntry(Level.INFO, msg));
    }

    /**
     * Wraps {@link Logger#trace(String)}.
     *
     * @param msg Log Message.
     */
    public void trace(String msg) {
        log.trace(msg);
        add(new Slf4jReportEntry(Level.TRACE, msg));
    }

    /**
     * Wraps {@link Logger#trace(String, Throwable)}.
     *
     * @param msg Log Message.
     * @param t   Cause.
     */
    public void trace(String msg, Throwable t) {
        log.trace(msg, t);
        add(new Slf4jReportEntry(Level.TRACE, msg));
    }

    /**
     * Wraps {@link Logger#warn(String)}.
     *
     * @param msg Log Message.
     */
    public void warn(String msg) {
        log.warn(msg);
        add(new Slf4jReportEntry(Level.WARN, msg));
    }

    /**
     * Wraps {@link Logger#warn(String, Throwable)}.
     *
     * @param msg Log Message.
     * @param t   Cause.
     */
    public void warn(String msg, Throwable t) {
        log.warn(msg, t);
        add(new Slf4jReportEntry(Level.WARN, msg));
    }
}
