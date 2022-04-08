package kz.dev.marketplace_d.model.response

data class Good (
    val id: Int?,
    val title: String?,
    val original_price: String?,
    val discount_percent: String?,
    val price: String?,
    val images: List<String>?
        )

