package com.project.taewon.googlesearch.network.response

import com.project.taewon.googlesearch.model.Image

data class SearchResponse(
    var kind: String? = null,
    var url: Url? = null,
    var queries: Queries? = null,
    var context: Context? = null,
    var searchInformation: SearchInformation? = null,
    var items: List<Image>? = null
)

data class Queries(
    var request: List<Request>? = null,
    var nextPage: List<NextPage>? = null
)

data class Request(
    var title: String?,
    var totalResults: String?,
    var searchTerms: String?,
    var count: Int?,
    var startIndex: Int?,
    var inputEncoding: String?,
    var outputEncoding: String?,
    var safe: String?,
    var cx: String?,
    var searchType: String?
)

data class NextPage(
    var title: String?,
    var totalResults: String?,
    var searchTerms: String?,
    var count: Int?,
    var startIndex: Int?,
    var inputEncoding: String?,
    var outputEncoding: String?,
    var safe: String?,
    var cx: String?,
    var searchType: String?
)

data class SearchInformation(
    var searchTime: Double?,
    var formattedSearchTime: String?,
    var totalResults: String?,
    var formattedTotalResults: String?
)

data class Context(var title: String? = null)

data class Url(
    var type: String?,
    var template: String?
)