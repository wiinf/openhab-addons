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
package org.openhab.binding.modbus.deyeinverter.internal.dto;

import static org.openhab.core.io.transport.modbus.ModbusConstants.ValueType.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.function.Function;

import javax.measure.Unit;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.io.transport.modbus.ModbusConstants.ValueType;
import org.openhab.core.library.types.DateTimeType;
import org.openhab.core.library.types.DecimalType;
import org.openhab.core.library.types.OnOffType;
import org.openhab.core.library.types.OpenClosedType;
import org.openhab.core.library.types.QuantityType;
import org.openhab.core.library.unit.SIUnits;
import org.openhab.core.library.unit.Units;
import org.openhab.core.types.State;

/**
 * The {@link Deye3PhaseInverterRegisters} is responsible for defining Modbus registers and their units.
 *
 * @author Holger Friedrich - Initial contribution
 * @author Alexander Teterra - Transfered to Deye Inverter
 */
@NonNullByDefault
public enum DeyeInverterRegisters {
    // !!!IMPORTEND NOTE!!!: this list needs to be sorted by register number!

    // TODO implement remote control, registers 60-177

    TOU_TIME1(148, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),
    TOU_TIME2(149, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),
    TOU_TIME3(150, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),
    TOU_TIME4(151, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),
    TOU_TIME5(152, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),
    TOU_TIME6(153, UINT16, BigDecimal.ONE, timeFactory(), "configuration"),

    TOU_TIME1_MINBATTERYSOC(166, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),
    TOU_TIME2_MINBATTERYSOC(167, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),
    TOU_TIME3_MINBATTERYSOC(168, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),
    TOU_TIME4_MINBATTERYSOC(169, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),
    TOU_TIME5_MINBATTERYSOC(170, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),
    TOU_TIME6_MINBATTERYSOC(171, UINT16, BigDecimal.ONE, percentFactory(), "configuration"),

    TOU_TIME1_CHARGEFROMGRID(172, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME1_CHARGEFROMGEN(172, ValueType.BIT, 1, switchFactory(), "configuration"),
    TOU_TIME2_CHARGEFROMGRID(173, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME2_CHARGEFROMGEN(173, ValueType.BIT, 1, switchFactory(), "configuration"),
    TOU_TIME3_CHARGEFROMGRID(174, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME3_CHARGEFROMGEN(174, ValueType.BIT, 1, switchFactory(), "configuration"),
    TOU_TIME4_CHARGEFROMGRID(175, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME4_CHARGEFROMGEN(175, ValueType.BIT, 1, switchFactory(), "configuration"),
    TOU_TIME5_CHARGEFROMGRID(176, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME5_CHARGEFROMGEN(176, ValueType.BIT, 1, switchFactory(), "configuration"),
    TOU_TIME6_CHARGEFROMGRID(177, ValueType.BIT, 0, switchFactory(), "configuration"),
    TOU_TIME6_CHARGEFROMGEN(177, ValueType.BIT, 1, switchFactory(), "configuration"),

    // LIFPO_BATTERY_1_INFORMATION
    // LI_BATTERY1_CHARGING_VOLTAGE(210, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT),
    // "battery-information"), // NEW
    // LI_BATTERY1_UNCHARGING_VOLTAGE(211, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT),
    // "battery-information"), // NEW
    // LI_BATTERY1_CHARGING_LIMITED_CURRENT(212, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE),
    // "battery-information"), // NEW
    // LI_BATTERY1_UNCHARGING_LIMITED_CURRENT(213, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE),
    // "battery-information"), // NEW
    // LI_BATTERY1_SOC(214, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.PERCENT),
    // "battery-information"), // NEW
    // LI_BATTERY1_VOLTAGE(215, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT),
    // "battery-information"), // NEW
    // LI_BATTERY1_CURRENT(216, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE), "battery-information"), // NEW
    // LI_BATTERY1_TEMPERATUR(217, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(SIUnits.CELSIUS),
    // "battery-information"), // NEW
    // LI_BATTERY1_MAX_CHARGING_CURRENT(218, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE),
    // "battery-information"), // NEW
    // LI_BATTERY1_MAX_UNCHARGING_CURRENT(219, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE),
    // "battery-information"), // NEW
    // LI_BATTERY1_ALARM(220, UINT16, BigDecimal.ONE, contactFactory(), "battery-information"), // NEW
    // LI_BATTERY1_TYP(223, UINT16, BigDecimal.ONE, DecimalType::new, "battery-information"), // NEW
    // LI_BATTERY1_SOH(224, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.PERCENT),
    // "battery-information"), // NEW
    // LI_BATTERY1_CAPACITY(226, UINT16, BigDecimal.ONE, DecimalType::new, "battery-information"), // NEW
    // LI_BATTERY1_MANUFACTURE(229, UINT16, BigDecimal.ONE, DecimalType::new, "battery-information"), // NEW

    // ONLY READABLBE STATUS REGISTERS
    // ==========================
    // inverter-states
    // ==========================
    OPERATION_STATE(500, UINT16, BigDecimal.ONE, DecimalType::new, "overview"),

    DAILY_ENERGY_BOUGHT(520, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // NEW
    DAILY_ENERGY_SOLD(521, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // NEW
    TOTAL_ENERGY_BOUGHT(522, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // New
    TOTAL_ENERGY_SOLD(524, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // NEW

    DAILY_PV_GENERATION(529, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // OK
    TOTAL_PV_GENERATION(534, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.KILOWATT_HOUR), "overview"), // OK

    DC_TRANSFORMER_TEMPERATURE(540, INT16, ConversionConstants.DIV_BY_TEN, quantityFactory(SIUnits.CELSIUS),
            "overview"), // NEW
    HEAT_SINC_TEMPERATURE(541, INT16, ConversionConstants.DIV_BY_TEN, quantityFactory(SIUnits.CELSIUS), "overview"), // NEW

    // BATTERY_INFORMATION
    BATTERY1_TEMPERATUR(586, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(SIUnits.CELSIUS),
            "battery-information"), // NEW
    BATTERY1_VOLTAGE(587, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "battery-information"), // NEW
    BATTERY1_SOC(588, UINT16, ConversionConstants.DIV_BY_TEN, percentFactory(), "battery-information"), // NEW
    BATTERY2_SOC(589, UINT16, ConversionConstants.DIV_BY_TEN, percentFactory(), "battery-information"), // NEW
    BATTERY1_OUTPUTPOWER(590, UINT16, BigDecimal.ONE, DecimalType::new, "battery-information"), // NEW
    BATTERY1_CURRENT(591, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE), "battery-information"), // NEW
    BATTERY2_VOLTAGE(593, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "battery-information"), // NEW
    BATTERY2_CURRENT(594, UINT16, BigDecimal.ONE, quantityFactory(Units.AMPERE), "battery-information"), // NEW
    BATTERY2_OUTPUTPOWER(595, UINT16, BigDecimal.ONE, DecimalType::new, "battery-information"), // NEW
    BATTERY2_TEMPERATUR(596, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(SIUnits.CELSIUS),
            "battery-information"), // NEW

    // GRID INFORMATION
    GRID_L1_VOLTAGE(598, INT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "grid-information"),
    GRID_L2_VOLTAGE(599, INT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "grid-information"),
    GRID_L3_VOLTAGE(600, INT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "grid-information"),

    HIDDEN_GRID_FREQUENCY(609, UINT16, BigDecimal.ONE, quantityFactory(Units.HERTZ), "grid-information"),

    TOTAL_GRID_POWER(625, UINT16, BigDecimal.ONE, quantityFactory(Units.WATT), "grid-information"),
    HIDDEN_INVERTER_POWER(632, INT16, BigDecimal.ONE, quantityFactory(Units.WATT), "overview"),

    MPPT1_POWER(672, UINT16, BigDecimal.TEN, quantityFactory(Units.WATT), "mppt-information"),
    MPPT2_POWER(673, UINT16, BigDecimal.TEN, quantityFactory(Units.WATT), "mppt-information"),
    MPPT3_POWER(674, UINT16, BigDecimal.TEN, quantityFactory(Units.WATT), "mppt-information"),
    MPPT4_POWER(675, UINT16, BigDecimal.TEN, quantityFactory(Units.WATT), "mppt-information"),
    MPPT1_VOLTAGE(676, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "mppt-information"),
    MPPT1_CURRENT(677, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.AMPERE), "mppt-information"),
    MPPT2_VOLTAGE(678, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "mppt-information"),
    MPPT2_CURRENT(679, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.AMPERE), "mppt-information"),
    MPPT3_VOLTAGE(680, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "mppt-information"),
    MPPT3_CURRENT(681, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.AMPERE), "mppt-information"),
    MPPT4_VOLTAGE(682, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.VOLT), "mppt-information"),
    MPPT4_CURRENT(683, UINT16, ConversionConstants.DIV_BY_TEN, quantityFactory(Units.AMPERE), "mppt-information");

    // 0:off 2:on, special handling in MQ2200InverterHandler
    // HIDDEN_EPS_OUTPUT(46613, UINT16, BigDecimal.ONE, DecimalType::new, "emergency-power-supply");

    // does not work, always returns 7
    // WORK_MODE(49203, UINT16, BigDecimal.ONE, DecimalType::new, "overview"),

    // some registers in between cannot be read and will make the Modbus request fail
    // BLOCKER(MQ2200InverterHandler.ENFORCE_NEW_REQUEST, UINT16, BigDecimal.ONE, DecimalType::new, ""),
    // does not change during manual shutdown using the button on the device
    // SYSTEM_POWER_STATE(49228, UINT16, BigDecimal.ONE, DecimalType::new, "overview"),
    // idle state seems to be 0
    // IDLE_STATE(49229, UINT16, BigDecimal.ONE, DecimalType::new, "overview"),
    // IDLE_LOAD_POWER_THRESHOLD(49230, UINT16, BigDecimal.ONE, DecimalType::new, "overview");

    private final BigDecimal multiplier;
    private final int bitIndex;
    private final int registerNumber;
    private final ValueType type;

    private final Function<BigDecimal, BigDecimal> conversion;
    private final Function<BigDecimal, State> stateFactory;
    private final String channelGroup;

    DeyeInverterRegisters(int registerNumber, ValueType type, BigDecimal multiplier,
            Function<BigDecimal, State> stateFactory, Function<BigDecimal, BigDecimal> conversion,
            String channelGroup) {
        this.multiplier = multiplier;
        this.bitIndex = 0;
        this.registerNumber = registerNumber;
        this.type = type;
        this.conversion = conversion;
        this.stateFactory = stateFactory;
        this.channelGroup = channelGroup;
    }

    DeyeInverterRegisters(int registerNumber, ValueType type, int bitIndex, Function<BigDecimal, State> stateFactory,
            String channelGroup) {
        this.multiplier = new BigDecimal(1);
        this.bitIndex = bitIndex;
        this.registerNumber = registerNumber;
        this.type = type;
        this.conversion = Function.identity();
        this.stateFactory = stateFactory;
        this.channelGroup = channelGroup;
    }

    DeyeInverterRegisters(int registerNumber, ValueType type, BigDecimal multiplier,
            Function<BigDecimal, State> stateFactory, String channelGroup) {
        this.multiplier = multiplier;
        this.registerNumber = registerNumber;
        this.bitIndex = 0;
        this.type = type;
        this.conversion = Function.identity();
        this.stateFactory = stateFactory;
        this.channelGroup = channelGroup;
    }

    private static Function<BigDecimal, State> contactFactory() {
        return (BigDecimal value) -> value.intValue() == 0 ? OpenClosedType.CLOSED : OpenClosedType.OPEN;
    }

    private static Function<BigDecimal, State> switchFactory() {
        return (BigDecimal value) -> value.intValue() == 0 ? OnOffType.OFF : OnOffType.ON;
    }

    private static Function<BigDecimal, State> percentFactory() {
        return (BigDecimal value) -> new QuantityType<>(value, Units.PERCENT);
    }

    private static Function<BigDecimal, State> timeFactory() {
        return (BigDecimal value) -> new DateTimeType(
                ZonedDateTime.now().with(LocalTime.of((value.intValue() / 100), (value.intValue() % 100), 0, 0)));
    }

    /**
     * Creates a Function that creates {@link QuantityType} states with the given {@link Unit}.
     *
     * @param unit {@link Unit} to be used for the value.
     * @return Function for value creation.
     */
    private static Function<BigDecimal, State> quantityFactory(Unit<?> unit) {
        return (BigDecimal value) -> new QuantityType<>(value, unit);
    }

    /**
     * Returns the Modbus register number.
     *
     * @return Modbus register number.
     */
    public int getRegisterNumber() {
        return registerNumber;
    }

    /**
     * Returns the {@link ValueType} for the channel.
     *
     * @return {@link ValueType} for the channel.
     */
    public ValueType getType() {
        return type;
    }

    /**
     * Returns the count of registers read to return the value of this register.
     *
     * @return register count.
     */
    public int getRegisterCount() {
        return this.type.getBits() / 16;
    }

    /**
     * Returns the channel group.
     *
     * @return channel group id.
     */
    public String getChannelGroup() {
        return channelGroup;
    }

    /**
     * Returns the channel name.
     *
     * @return the channel name.
     */
    public String getChannelName() {
        return this.name().toLowerCase().replace('_', '-');
    }

    public int getBitIndex() {
        return bitIndex;
    }

    /**
     * Creates the {@link State} for the given register value.
     *
     * @param registerValue the value for the channel.
     * @return {@link State} for the given value.
     */
    public State createState(DecimalType registerValue) {
        final BigDecimal scaledValue = registerValue.toBigDecimal().multiply(this.multiplier);

        final BigDecimal convertedValue = conversion.apply(scaledValue);
        return this.stateFactory.apply(convertedValue);
    }
}
