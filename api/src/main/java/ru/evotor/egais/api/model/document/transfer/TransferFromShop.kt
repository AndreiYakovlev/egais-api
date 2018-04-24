package ru.evotor.egais.api.model.document.transfer

import ru.evotor.egais.api.model.document.EgaisDocument
import java.util.*

/**
 * Передача продукции из торгового зала на склад
 *
 * @property uuid Уникальный идентификатор
 * @property owner Кто подает документы
 * @property identity Идентификатор документа (клиентский)
 * @property transferNumber Номер документа
 * @property transferDate Дата составления
 * @property note Примечание
 * @property status Статус обработки документа
 * @property rejectComment Комментарий для отказа
 * @property replyId Уникальный идентификатор документа (присваивается УТМ); совпадает с идентификатором исходящего документа, который получили в ответе
 */
data class TransferFromShop(
        val uuid: UUID,
        val owner: String,
        val identity: String?,
        val transferNumber: String,
        val transferDate: Date?,
        val note: String?,
        var status: TransferStatus,
        val rejectComment: String?,
        val replyId: String?
) : EgaisDocument()