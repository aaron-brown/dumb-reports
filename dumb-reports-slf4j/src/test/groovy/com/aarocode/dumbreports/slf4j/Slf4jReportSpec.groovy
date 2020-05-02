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
package com.aarocode.dumbreports.slf4j

import org.slf4j.Logger
import org.slf4j.event.Level
import spock.lang.Specification

class Slf4jReportSpec extends Specification {
    Slf4jReport report

    Logger log

    def setup() {
        log = Mock()

        report = new Slf4jReport(log)
    }

    void 'Validate log-wrapping'() {
        when:
        report.debug(debug)
        report.error(error)
        report.info(info)
        report.trace(trace)
        report.warn(warn)

        report.debug(debug, e)
        report.error(error, e)
        report.info(info, e)
        report.trace(trace, e)
        report.warn(warn, e)

        then:
        1 * log.debug(debug)
        1 * log.error(error)
        1 * log.info(info)
        1 * log.trace(trace)
        1 * log.warn(warn)

        1 * log.debug(debug, e)
        1 * log.error(error, e)
        1 * log.info(info, e)
        1 * log.trace(trace, e)
        1 * log.warn(warn, e)

        report.entries.size() == 10

        report.entries[0].level == Level.DEBUG
        report.entries[0].message == debug

        report.entries[1].level == Level.ERROR
        report.entries[1].message == error

        report.entries[2].level == Level.INFO
        report.entries[2].message == info

        report.entries[3].level == Level.TRACE
        report.entries[3].message == trace

        report.entries[4].level == Level.WARN
        report.entries[4].message == warn

        report.entries[5].level == Level.DEBUG
        report.entries[5].message == debug

        report.entries[6].level == Level.ERROR
        report.entries[6].message == error

        report.entries[7].level == Level.INFO
        report.entries[7].message == info

        report.entries[8].level == Level.TRACE
        report.entries[8].message == trace

        report.entries[9].level == Level.WARN
        report.entries[9].message == warn

        where:
        debug = 'debug'
        error = 'error'
        info = 'info'
        trace = 'trace'
        warn = 'warn'

        e = Mock(Exception)
    }
}