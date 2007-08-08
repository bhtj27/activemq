/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.activemq.store.jdbc.adapter;

import org.apache.activemq.store.jdbc.Statements;

/**
 * JDBC Adapter for Informix database.
 * Because Informix database restricts length of composite primary keys, length of 
 * <i>container name</i> field and <i>subscription id</i> field must be reduced to 150 characters.
 * Therefore be sure not to use longer names for container name and subscription id than 150 characters.
 *  
 * @org.apache.xbean.XBean element="informixJDBCAdapter"
 */
public class InformixJDBCAdapter extends BlobJDBCAdapter {

    public void setStatements(Statements statements) {
        statements.setContainerNameDataType("VARCHAR(150)");
        statements.setStringIdDataType("VARCHAR(150)");
        statements.setLongDataType("INT8");
        statements.setBinaryDataType("BYTE");
        super.setStatements(statements);
    }

}
