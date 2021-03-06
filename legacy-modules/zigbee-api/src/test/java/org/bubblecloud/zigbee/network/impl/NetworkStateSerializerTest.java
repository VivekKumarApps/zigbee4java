/**
 * Copyright 2013 Tommi S.E. Laukkanen
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
package org.bubblecloud.zigbee.network.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test for network state serialization.
 * @author <a href="mailto:tommi.s.e.laukkanen@gmail.com">Tommi S.E. Laukkanen</a>
 */
public class NetworkStateSerializerTest {

    @Test
    public void testSerializeNetworkState() {
        final ZigBeeNodeImpl node = new ZigBeeNodeImpl(1, "00:00:00:00:00:00:00:00", (short) 2);
        final ZigBeeEndpointImpl endpoint = new ZigBeeEndpointImpl(node, 1, 2, (byte) 3, (short) 4, new int[] {5}, new int[] {6});

        final ZigBeeNetwork zigBeeNetwork = new ZigBeeNetwork();
        zigBeeNetwork.addNode(node);
        zigBeeNetwork.addEndpoint(endpoint);

        final NetworkStateSerializer networkStateSerializer = new NetworkStateSerializer();
        final String networkState = networkStateSerializer.serialize(zigBeeNetwork);

        System.out.println(networkState);

        final ZigBeeNetwork zigBeeNetworkRestored = new ZigBeeNetwork();
        networkStateSerializer.deserialize(null, zigBeeNetworkRestored, networkState);

        Assert.assertEquals(1, zigBeeNetworkRestored.getDevices().size());
        Assert.assertEquals(1, zigBeeNetworkRestored.getEndpoints(
                zigBeeNetworkRestored.getDevices().keySet().iterator().next()).size());

        final String networkStateOfRestoredNetwork = networkStateSerializer.serialize(zigBeeNetworkRestored);
        Assert.assertEquals(networkState, networkStateOfRestoredNetwork);
    }

}
