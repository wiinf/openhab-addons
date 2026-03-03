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
package org.openhab.binding.modbus.deyeinverter.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.binding.modbus.ModbusBindingConstants;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link ModbusDeyeInverterBindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Holger Friedrich - Initial contribution
 */
@NonNullByDefault
public class ModbusDeyeInverterBindingConstants {

    /// public static final String PROPERTY_MODEL_CODE = "modelCode"; //?
    public static final String PROPERTY_MODEL_TYPE = "modelType"; // ok
    public static final String PROPERTY_SERIAL_NO = "serialNumber"; // ok
    public static final String PROPERTY_RATED_POWER = "ratedPower"; // ok
    public static final String PROPERTY_MAX_ACTIVE_POWER = "maxActivePower";
    // public static final String PROPERTY_FIRMWARE_BMS = "firmwareBMS";
    // public static final String PROPERTY_FIRMWARE_WR = "firmwareWR";
    // public static final String PROPERTY_FIRMWARE_PV = "firmwarePV";

    /**
     * ThingType-ID for Inverter.
     */
    public static final ThingTypeUID THING_TYPE_DEYE_INVERTER = new ThingTypeUID(ModbusBindingConstants.BINDING_ID,
            "deye-inverter");
}
