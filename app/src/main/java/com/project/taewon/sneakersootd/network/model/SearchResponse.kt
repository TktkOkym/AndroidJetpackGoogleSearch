package com.project.taewon.sneakersootd.network.model

data class SearchResponse(
    var kind: String? = null,
    var url: Url? = null,
    var queries: Queries? = null,
    var context: Context? = null,
    var searchInformation: SearchInformation? = null,
    var items: List<Image>? = null
)