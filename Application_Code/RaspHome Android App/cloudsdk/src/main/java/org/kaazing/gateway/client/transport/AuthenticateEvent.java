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

package org.kaazing.gateway.client.transport;

import java.util.logging.Logger;

public class AuthenticateEvent extends Event {
    private static final String CLASS_NAME = AuthenticateEvent.class.getName();
    private static final Logger LOG = Logger.getLogger(CLASS_NAME);

    private String challenge;

    /**
     * Authenticate Event
     * 
     * @param challenge
     */
    public AuthenticateEvent(String challenge) {
        super(Event.AUTHENTICATE);
        LOG.entering(CLASS_NAME, "<init>", new Object[] { type, challenge });
        this.challenge = challenge;
    }

    public String getChallenge() {
        LOG.exiting(CLASS_NAME, "getLocation", challenge);
        return challenge;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("AuthenticateEvent [type=" + type + " challenge=" + challenge + "{");
        for (Object a : params) {
            ret.append(a).append(" ");
        }
        return ret + "}]";
    }
}
