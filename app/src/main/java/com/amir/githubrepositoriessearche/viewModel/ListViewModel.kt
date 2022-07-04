package com.amir.githubrepositoriessearche.viewModel
import androidx.lifecycle.ViewModel



class ListViewModel : ViewModel() {
//    private val githubService = GithubService()
//    private val disposable = CompositeDisposable()
//    val repositories = MutableLiveData<List<GithubResponse>>()
//    val repositoryLoadError = MutableLiveData<Boolean>()
//    val loading = MutableLiveData<Boolean>()
//
//
//    fun refresh() {
//        fetchRepositories()
//    }
//
//
//    private fun fetchRepositories() {
//        loading.value = true
//disposable.add(githubService.getRepositories()
//    .subscribeOn(Schedulers.newThread())
//    .observeOn(AndroidSchedulers.mainThread())
//    .subscribeWith(object :DisposableSingleObserver<List<GithubResponse>>(){
//        override fun onSuccess(value: List<GithubResponse>) {
//            repositories.value = value
//            repositoryLoadError.value=false
//            loading.value=false
//        }
//
//        override fun onError(e: Throwable) {
//            repositoryLoadError.value = true
//            loading.value=false
//        }
//
//    }))
//
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        disposable.clear()
//    }
}