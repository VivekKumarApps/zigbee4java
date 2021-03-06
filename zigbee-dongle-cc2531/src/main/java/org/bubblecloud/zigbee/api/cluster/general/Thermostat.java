/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package org.bubblecloud.zigbee.api.cluster.general;

import org.bubblecloud.zigbee.api.cluster.Cluster;
import org.bubblecloud.zigbee.api.cluster.impl.api.core.Attribute;
import org.bubblecloud.zigbee.api.cluster.measurement_sensing.event.MeasuredValueListener;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision:  $ ($LastChangedDate: $)
 *
 */

public interface Thermostat extends Cluster {
	
    public Attribute getlocalTemperature();
    
    public Attribute getoccupiedCoolingSetpoint();

    public Attribute getoccupiedHeatingSetpoint();

    public Attribute getcontrolSequenceOfOperation();

    public Attribute getsystemMode();

    /**
     * @param mvl The {@link MeasuredValueListener} to subscribe for events
     * @since 0.6.0
     */
    public boolean subscribe(MeasuredValueListener mvl);

    /**
     * @param mvl The {@link MeasuredValueListener} to unsubscribe
     * @since 0.6.0
     */
    public boolean unsubscribe(MeasuredValueListener mvl);

}
