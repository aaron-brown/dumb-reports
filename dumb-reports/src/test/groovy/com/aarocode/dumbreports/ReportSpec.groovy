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
package com.aarocode.dumbreports

import spock.lang.Specification

class ReportSpec extends Specification {
    class MockReport implements Report<String> {
        List<String> entries

        MockReport() {
            entries = new ArrayList<>()
        }

        Collection<String> getEntries() {
            return entries
        }
    }

    MockReport report

    def setup() {
        report = new MockReport()
    }

    void 'Validate empty Report'() {
        expect:
        report.entries != null
        report.size() == 0
    }

    void 'Validate population (1)'() {
        when:
        report.add(entry)

        then:
        report.size() == 1
        report.entries[0] == entry

        where:
        entry = 'foo'
    }

    void 'Validate population (Many)'() {
        when:
        report.add(entry0, entry1, entry2)

        then:
        report.size() == 3
        report.entries[0] == entry0
        report.entries[1] == entry1
        report.entries[2] == entry2

        where:
        entry0 = 'foo'
        entry1 = 'bar'
        entry2 = 'baz'
    }

    void 'Validate addAll()'() {
        when:
        report.addAll(entries)

        then:
        report.entries == entries

        where:
        entries = ['foo', 'bar', 'baz']
    }

    void 'Validate clear()'() {
        setup:
        report.addAll(entries)

        if (report.size() != 3) {
            throw new IllegalStateException("Test is not properly set up")
        }

        when:
        report.clear()

        then:
        report.size() == 0

        where:
        entries = ['foo', 'bar', 'baz']
    }
}