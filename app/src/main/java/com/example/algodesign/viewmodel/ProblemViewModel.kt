package com.example.algodesign.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.algodesign.model.ProblemList
import com.example.algodesign.repository.ProblemRepository
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

class ProblemViewModel : ViewModel() ,KoinComponent{

private val repository by inject<ProblemRepository>()
private val context by inject<Context>()

     fun getProblemList(): Observable<ProblemList> {

        return Observable.create { emitter ->
          emitter.onNext(repository.getProblemList(context))

        }
    }


}
