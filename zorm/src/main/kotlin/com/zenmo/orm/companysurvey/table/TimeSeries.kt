package com.zenmo.orm.companysurvey.table

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.timestamp

object TimeSeriesTable: Table("time_series") {
    val gridConnectionId = uuid("grid_connection_id").references(GridConnectionTable.id)
    val type = enumeration<TimeSeriesType>("type")
    val timestamp = timestamp("timestamp")

    override val primaryKey = PrimaryKey(gridConnectionId, type, timestamp)

    val value = float("value")
}

enum class TimeSeriesType {
    // Delivery from grid to end-user
    ELECTRICITY_QUARTER_HOURLY_DELIVERY_KWH,
    // Feed-in of end-user back in to the rid
    ELECTRICITY_QUARTER_HOURLY_FEED_IN_KWH,
    // Solar panel production
    ELECTRICITY_QUARTER_HOURLY_PRODUCTION_KWH,
    GAS_HOURLY_DELIVERY_M3,
}
