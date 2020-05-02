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

import spock.lang.Specification

class StatusReportSpec extends Specification {
    StatusReport report

    def setup() {
        report = new StatusReport()
    }

    void 'Validate initialization'() {
        setup:
        StatusReport reportA
        StatusReport reportB

        when:
        reportA = new StatusReport()
        reportB = new StatusReport(status)

        then:
        !reportA.status
        reportB.status == status

        where:
        status = 'foo'
    }

    void 'Validate add()'() {
        when:
        report.add('good', 'dog')

        then:
        !report.status
        report.entries.size() == 1

        report.entries[0].status == 'good'
        report.entries[0].entry == 'dog'

        when:
        report.add('mixed', 'bad', 'apple')

        then:
        report.status == 'mixed'
        report.entries.size() == 2

        report.entries[1].status == 'bad'
        report.entries[1].entry == 'apple'
    }
}