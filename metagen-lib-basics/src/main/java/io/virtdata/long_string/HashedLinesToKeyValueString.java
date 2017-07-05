/*
 *
 *       Copyright 2015 Jonathan Shook
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package io.virtdata.long_string;

import io.virtdata.api.ThreadSafeMapper;
import io.virtdata.long_collections.HashedLineToStringStringMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

@ThreadSafeMapper
public class HashedLinesToKeyValueString implements LongFunction<String> {
    private static final Logger logger = LoggerFactory.getLogger(HashedLinesToKeyValueString.class);

    private final HashedLineToStringStringMap lineDataMapper;

    public HashedLinesToKeyValueString(String paramFile, int maxsize) {
        lineDataMapper = new HashedLineToStringStringMap(paramFile, maxsize);
    }

    @Override
    public String apply(long input) {
        Map<String, String> stringStringMap = lineDataMapper.apply(input);
        String mapstring = stringStringMap.entrySet().stream().
                map(es -> es.getKey() + ":" + es.getValue() + ";")
                .collect(Collectors.joining());
        return mapstring;
    }

}
