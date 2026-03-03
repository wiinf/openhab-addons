/*
 * Copyright (c) 2010-2026 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.modbus.deyeinverter.internal.config;

import org.eclipse.jdt.annotation.NonNullByDefault;

/**
 * The {@link Deye3PhaseInverterConfiguration} class contains fields mapping thing configuration parameters.
 *
 * @author Holger Friedrich - Initial contribution
 * @author Alexander Teterra - carry over from FoxESS Binding
 */
@NonNullByDefault
public class DeyeInverterConfiguration {
    public int pollInterval;
    public int maxTries;
}
