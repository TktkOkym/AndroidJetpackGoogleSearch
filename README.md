# Sneakers Ootd
#### API
  * [Google Custom Search API](https://developers.google.com/custom-search/v1/overview)
#### Android JetPack
  * Navigation Architecture Components
    - Issue: fragment re-created when navigating to next page
    - Reason: NavController ultimately calls "FragmentTransaction.replace", which remove currrent then add new Fragment. "FragmentTransaction.add"
    - Conclusion: It might not be a good idea to use Navigation Architecture Components in current stage, especially if you are using LiveData and PagedListView -> However, global variable is not getting removed after fragment 'replace', we can avoid calling redundant api call by checking null for the global variable when coming back from next page
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
#### Screenshot
<img src="https://github.com/TktkOkym/sneakers_ootd_google_custom_search_api/blob/master/Screenshot/sneakersOotd.gif" width="300" />
