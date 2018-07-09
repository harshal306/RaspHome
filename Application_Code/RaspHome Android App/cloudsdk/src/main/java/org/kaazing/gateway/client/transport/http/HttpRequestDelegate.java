/**
 * Copyright (c) 2007-2014 Kaazing Corporation. All rights reserved.
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.kaazing.gateway.client.transport.http;

import org.kaazing.gateway.client.transport.BridgeDelegate;

import java.net.URL;
import java.nio.ByteBuffer;

public interface HttpRequestDelegate extends BridgeDelegate {

    void setRequestHeader(String header, String value);

    int getStatusCode();
    String getResponseHeader(String headerLocation);
    ByteBuffer getResponseText();

    void processOpen(String method, URL url, String origin, boolean async, long connectTimeout) throws Exception;
    void processSend(ByteBuffer content);
    void processAbort();
    
    void setListener(HttpRequestDelegateListener listener);

}