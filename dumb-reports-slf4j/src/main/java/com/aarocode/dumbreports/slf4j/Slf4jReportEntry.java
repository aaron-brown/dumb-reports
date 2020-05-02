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

import java.io.Serializable;
import org.slf4j.event.Level;

/**
 * Represents an {@link Slf4jReport#getEntries entry}.
 */
public class Slf4jReportEntry implements Serializable {
    /**
     * {@link Level}.
     */
    private final Level level;

    /**
     * Message.
     */
    private final String message;

    /**
     * Constructor.
     *
     * @param level {@link Level}.
     * @param message Message.
     */
    public Slf4jReportEntry(final Level level, final String message) {
        this.level = level;
        this.message = message;
    }

    public Level getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }
}
