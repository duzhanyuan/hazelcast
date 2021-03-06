/*
 * Copyright (c) 2008-2017, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.internal.networking;

import com.hazelcast.nio.Connection;

import java.io.IOException;

public interface ChannelInitializer<C extends Connection> {
    /**
     * Returned value could be null if not enough data is available to determine how to init (e.g. protocol info lacking)
     */
    InitResult<ChannelInboundHandler> initInbound(C connection, ChannelReader reader) throws IOException;

    InitResult<ChannelOutboundHandler> initOutbound(C connection, ChannelWriter writer, String protocol);
}
