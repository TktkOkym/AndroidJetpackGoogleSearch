# Sneakers Ootd
  * API: Google Custom Search API
  * Used: Navigation Architecture Components, Dagger2, Retrofit, Room, Glide, 
  * Paging - Used Unbounded List and PositionalDataSource. Reference [#1](https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample), [#2](https://medium.com/@jungil.han/paging-library-%EA%B7%B8%EA%B2%83%EC%9D%B4-%EC%93%B0%EA%B3%A0%EC%8B%B6%EB%8B%A4-bc2ab4d27b87)

## Investigation
  * Cannot use livedata inside DataSource class -> Cannot invoke setValue on a background thread
  * Used Retrofit Call to retrieve the api response within DataSource class
## TODO
### Implement Favorites page using Roomdb
## Screenshot
<img src="https://github.com/TktkOkym/sneakers_ootd_google_custom_search_api/blob/master/Screenshot/sneakersOotd.gif" width="300" />
