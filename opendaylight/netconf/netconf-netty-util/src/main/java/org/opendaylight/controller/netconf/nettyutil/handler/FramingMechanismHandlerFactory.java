/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.netconf.nettyutil.handler;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.MessageToByteEncoder;
import org.opendaylight.controller.netconf.util.messages.FramingMechanism;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FramingMechanismHandlerFactory {

    private static final Logger LOG = LoggerFactory.getLogger(FramingMechanismHandlerFactory.class);

    private FramingMechanismHandlerFactory() {
        // not called - private constructor for utility class
    }

    public static MessageToByteEncoder<ByteBuf> createHandler(FramingMechanism framingMechanism) {
        LOG.debug("{} framing mechanism was selected.", framingMechanism);
        if (framingMechanism == FramingMechanism.EOM) {
            return new EOMFramingMechanismEncoder();
        } else {
            return new ChunkedFramingMechanismEncoder();
        }
    }
}
