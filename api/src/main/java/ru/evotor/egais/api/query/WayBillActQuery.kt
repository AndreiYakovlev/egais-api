package ru.evotor.egais.api.query

import ru.evotor.egais.api.model.Version
import ru.evotor.egais.api.model.document.waybill.Status
import ru.evotor.egais.api.model.document.waybillact.AcceptType
import ru.evotor.egais.api.model.document.waybillact.Type
import ru.evotor.egais.api.model.document.waybillact.WayBillAct
import ru.evotor.egais.api.provider.waybillact.WayBillActContract
import ru.evotor.query.Cursor
import ru.evotor.query.FilterBuilder
import java.util.*

class WayBillActQuery : FilterBuilder<WayBillActQuery, WayBillActQuery.SortOrder, WayBillAct>(WayBillActContract.URI) {

    @JvmField
    val uuid = addFieldFilter<UUID>(WayBillActContract.COLUMN_UUID)
    @JvmField
    val docOwner = addFieldFilter<String>(WayBillActContract.COLUMN_OWNER)
    @JvmField
    val identity = addFieldFilter<String?>(WayBillActContract.COLUMN_IDENTITY)
    @JvmField
    val acceptType = addFieldFilter<AcceptType?>(WayBillActContract.COLUMN_TYPE)
    @JvmField
    val number = addFieldFilter<String>(WayBillActContract.COLUMN_NUMBER)
    @JvmField
    val creationDate = addFieldFilter<Date>(WayBillActContract.COLUMN_CREATION_DATE)
    @JvmField
    val wbRegId = addFieldFilter<String?>(WayBillActContract.COLUMN_WB_REG_ID)
    @JvmField
    val note = addFieldFilter<String?>(WayBillActContract.COLUMN_NOTE)
    @JvmField
    val type = addFieldFilter<Type?>(WayBillActContract.COLUMN_TYPE)
    @JvmField
    val version = addFieldFilter<Version?>(WayBillActContract.COLUMN_VERSION)
    @JvmField
    val status = addFieldFilter<Status>(WayBillActContract.COLUMN_STATUS)
    @JvmField
    val rejectComment = addFieldFilter<String?>(WayBillActContract.COLUMN_REJECT_COMMENT)

    override val currentQuery: WayBillActQuery
        get() = this

    class SortOrder : FilterBuilder.SortOrder<SortOrder>() {

        @JvmField
        val uuid = addFieldSorter(WayBillActContract.COLUMN_UUID)
        @JvmField
        val docOwner = addFieldSorter(WayBillActContract.COLUMN_OWNER)
        @JvmField
        val identity = addFieldSorter(WayBillActContract.COLUMN_IDENTITY)
        @JvmField
        val acceptType = addFieldSorter(WayBillActContract.COLUMN_TYPE)
        @JvmField
        val number = addFieldSorter(WayBillActContract.COLUMN_NUMBER)
        @JvmField
        val creationDate = addFieldSorter(WayBillActContract.COLUMN_CREATION_DATE)
        @JvmField
        val wbRegId = addFieldSorter(WayBillActContract.COLUMN_WB_REG_ID)
        @JvmField
        val note = addFieldSorter(WayBillActContract.COLUMN_NOTE)
        @JvmField
        val type = addFieldSorter(WayBillActContract.COLUMN_TYPE)
        @JvmField
        val version = addFieldSorter(WayBillActContract.COLUMN_VERSION)
        @JvmField
        val status = addFieldSorter(WayBillActContract.COLUMN_STATUS)
        @JvmField
        val rejectComment = addFieldSorter(WayBillActContract.COLUMN_REJECT_COMMENT)

        override val currentSortOrder: SortOrder
            get() = this

    }

    override fun getValue(cursor: Cursor<WayBillAct>): WayBillAct {
        return createWayBillAct(cursor)
    }

    private fun createWayBillAct(cursor: android.database.Cursor): WayBillAct {
        val columnUuid = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_UUID)
        val columnOwner = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_OWNER)
        val columnIdentity = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_IDENTITY)
        val columnAcceptType = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_ACCEPT_TYPE)
        val columnNumber = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_NUMBER)
        val columnDate = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_CREATION_DATE)
        val columnWbRegId = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_WB_REG_ID)
        val columnNote = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_NOTE)
        val columnType = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_TYPE)
        val columnVersion = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_VERSION)
        val columnStatus = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_STATUS)
        val columnRejectComment = cursor.getColumnIndexOrThrow(WayBillActContract.COLUMN_REJECT_COMMENT)

        return WayBillAct(
                UUID.fromString(cursor.getString(columnUuid)),
                cursor.getString(columnOwner),
                cursor.getString(columnIdentity),
                AcceptType.valueOf(cursor.getString(columnAcceptType)),
                cursor.getString(columnNumber),
                Date(cursor.getString(columnDate)),
                cursor.getString(columnWbRegId),
                cursor.getString(columnNote),
                Type.valueOf(cursor.getString(columnType)),
                Version.valueOf(cursor.getString(columnVersion)),
                ru.evotor.egais.api.model.document.waybillact.Status.valueOf(cursor.getString(columnStatus)),
                cursor.getString(columnRejectComment)
        )
    }
}