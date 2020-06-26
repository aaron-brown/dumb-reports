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
package com.aarocode.dumbreports;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Describes a <b>Report</b>.
 *
 * <p>The <b>Report</b> has a {@link Collection} of
 * <b>T</b>s, where each {@code T} is a descrete entry
 * within the report.
 */
public interface Report<T> {
    /**
     * Retrieve the list of {@link T Entries}.
     * @return {@link Collection entries}.
     */
    Collection<T> getEntries();

    @SuppressWarnings("unchecked")
    default boolean add(T... entries) {
        return getEntries().addAll(Arrays.stream(entries)
            .collect(Collectors.toList()));
    }

    default boolean addAll(Collection<T> entries) {
        return getEntries().addAll(entries);
    }

    default void clear() {
        getEntries().clear();
    }

    default int size() {
        return getEntries().size();
    }
}
