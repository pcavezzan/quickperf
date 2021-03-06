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

package org.quickperf.sql.select;

import org.quickperf.PerfIssue;
import org.quickperf.VerifiablePerformanceIssue;
import org.quickperf.measure.BooleanMeasure;
import org.quickperf.sql.annotation.DisableExactlySameSelects;
import org.quickperf.sql.framework.HibernateSuggestion;
import org.quickperf.sql.framework.SqlFrameworksInClassPath;

public class HasExactlySameSelectVerifier implements VerifiablePerformanceIssue<DisableExactlySameSelects, BooleanMeasure> {

    public static final HasExactlySameSelectVerifier INSTANCE = new HasExactlySameSelectVerifier();

    private HasExactlySameSelectVerifier() { }

    @Override
    public PerfIssue verifyPerfIssue(DisableExactlySameSelects annotation, BooleanMeasure nPlusOneSelectMeasure) {

        if(nPlusOneSelectMeasure.getValue()) {
            String description = "Exactly same SELECT requests";
            if(SqlFrameworksInClassPath.INSTANCE.containsHibernate()) {
                description += System.lineSeparator()
                             + HibernateSuggestion.SESSION.getMessage()
                ;
            }
            return new PerfIssue(description);
        }

        return PerfIssue.NONE;

    }

}
