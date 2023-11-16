/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.nativetest.jdbc.features.algorithm;

import lombok.Getter;
import org.apache.shardingsphere.encrypt.api.context.EncryptContext;
import org.apache.shardingsphere.encrypt.api.encrypt.assisted.AssistedEncryptAlgorithm;

import java.util.Properties;

@SuppressWarnings("LombokGetterMayBeUsed")
public final class TestQueryAssistedShardingEncryptAlgorithm implements AssistedEncryptAlgorithm {
    
    @Getter
    private Properties props;
    
    @Override
    public String encrypt(final Object plainValue, final EncryptContext encryptContext) {
        return "assistedEncryptValue";
    }
    
    @Override
    public String getType() {
        return "assistedTest";
    }
    
    @Override
    public void init(final Properties props) {
        this.props = props;
    }
}
