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

package org.apache.shardingsphere.test.natived.jdbc.databases;

import org.apache.shardingsphere.driver.api.yaml.YamlShardingSphereDataSourceFactory;
import org.apache.shardingsphere.test.natived.jdbc.commons.AbstractShardingCommonTest;
import org.apache.shardingsphere.test.natived.jdbc.commons.FileTestUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledInNativeImage;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

public class MSSQLServerTest {
    
    private AbstractShardingCommonTest abstractShardingCommonTest;
    
    @Test
    @EnabledInNativeImage
    void assertShardingInLocalTransactions() throws SQLException, IOException {
        DataSource dataSource = YamlShardingSphereDataSourceFactory.createDataSource(FileTestUtils.readFromFileURLString("test-native/yaml/databases/mssqlserver.yaml"));
        abstractShardingCommonTest = new AbstractShardingCommonTest(dataSource);
        this.initEnvironment();
        abstractShardingCommonTest.processSuccess();
        abstractShardingCommonTest.cleanEnvironment();
    }
    
    private void initEnvironment() throws SQLException {
        abstractShardingCommonTest.getOrderRepository().createTableInSQLServer();
        abstractShardingCommonTest.getOrderItemRepository().createTableInSQLServer();
        abstractShardingCommonTest.getAddressRepository().createTableInSQLServer();
        abstractShardingCommonTest.getOrderRepository().truncateTable();
        abstractShardingCommonTest.getOrderItemRepository().truncateTable();
        abstractShardingCommonTest.getAddressRepository().truncateTable();
    }
}