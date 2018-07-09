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

package org.kaazing.net.auth;

import java.net.PasswordAuthentication;

/**
 * A login handler is responsible for obtaining credentials from an arbitrary
 * source.
 * <p/>
 * Login Handlers can be associated with one or more {@link ChallengeHandler}
 * objects, to ensure that when a Challenge Handler requires credentials for a {@link ChallengeResponse},
 * the work is delegated to a {@link LoginHandler}.
 * <p/>
 * At client configuration time, a {@link LoginHandler} can be associated with a {@link ChallengeHandler} as follows:
 * <pre>
 * {@code
 *
 * BasicChallengeHandler basicChallengeHandler = ChallengeHandlerLoader.load(BasicChallengeHandler.class);
 * LoginHandler loginHandler = new LoginHandler() {
 *    public PasswordAuthentication getCredentials() {
 *        // Obtain credentials in an application-specific manner
 *    }
 * }
 * basicChallengeHandler.setLoginHandler(loginHandler);
 *    
 * }
 * </pre>
 */
public abstract class LoginHandler {

    /**
     * Default constructor.
     */
    protected LoginHandler() {
    }

    /**
     * Gets the password authentication credentials from an arbitrary source.
     * @return the password authentication obtained.
     */
    public abstract PasswordAuthentication getCredentials();

}