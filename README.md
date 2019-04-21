# Sneakers Ootd
#### API
  * [Google Custom Search API](https://developers.google.com/custom-search/v1/overview)
#### Android JetPack
  * Navigation Architecture Components
  * LiveData
  * ViewModel
  * Room
  * DataBinding
  * AndroidX
  * Paging 
    - Used Unbounded List and PositionalDataSource. Referenced [Google Sample](https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample)
#### Other Libraries
  * Dagger2
  * Retrofit
  * Glide
#### Investigation
  * Cannot use livedata inside DataSource class, since it does not allow to invoke setValue on a background thread
#### TODO
  * Implement Favorites page using Roomdb
  * Implement Swipe to refresh 
  * Add unit tests
#### Screenshot
<img src="https://github.com/TktkOkym/sneakers_ootd_google_custom_search_api/blob/master/Screenshot/paging.gif" width="300" />
