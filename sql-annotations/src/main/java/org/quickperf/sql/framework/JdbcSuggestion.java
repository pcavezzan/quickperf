/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2019-2019 the original author or authors.
 */

package org.quickperf.sql.framework;

public enum JdbcSuggestion implements QuickPerfSuggestion {

    SERVER_ROUND_TRIPS {
        @Override
        public String getMessage() {
            return "You may decrease the number of select requests in order to reduce the cost of"
                    + System.lineSeparator()
                    + "server roundtrips: " + "https://blog.jooq.org/2017/12/18/the-cost-of-jdbc-server-roundtrips/";
        }
    }

}
