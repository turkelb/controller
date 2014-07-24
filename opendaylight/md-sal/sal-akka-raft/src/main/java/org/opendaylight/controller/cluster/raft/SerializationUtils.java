/*
 * Copyright (c) 2014 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.cluster.raft;

import org.opendaylight.controller.cluster.raft.messages.AppendEntries;

public class SerializationUtils {

    public static Object fromSerializable(Object serializable){
        if(serializable.getClass().equals(AppendEntries.SERIALIZABLE_CLASS)){
            return AppendEntries.fromSerializable(serializable);
        }
        return serializable;
    }

}
