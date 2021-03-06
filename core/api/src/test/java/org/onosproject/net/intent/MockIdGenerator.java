/*
 * Copyright 2014-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.net.intent;

import org.onosproject.core.IdGenerator;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Mock id generator for testing.
 */
public class MockIdGenerator implements IdGenerator {

    private static boolean generatorIsBound = false;
    private static MockIdGenerator idGenerator;
    public static void bindNewGenerator() {
        if (!generatorIsBound) {
            generatorIsBound = true;
            idGenerator = new MockIdGenerator();
            Intent.unbindIdGenerator(idGenerator);
            Intent.bindIdGenerator(idGenerator);
        }
    }
    private AtomicLong nextId = new AtomicLong(0);

    @Override
    public long getNewId() {
        return nextId.getAndIncrement();
    }
}
