# Sneakers Ootd
#### API
  * [Google Custom Search API](https://developers.google.com/custom-search/v1/overview)
#### Android JetPack
  * Navigation Architecture Components
    - Issue: fragment re-created when coming back to tablayout/recyclerview from next page and current status is not being saved
    - Reason: NavController ultimately calls "FragmentTransaction.replace", which remove currrent then add new Fragment. "FragmentTransaction.add" should be called instead to retain its status
    - Conclusion: It might not be a good idea to use Navigation Architecturre Components in current stage, especially if you are using LiveData and PagedListView
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
