package com.example.algodesign.di

import com.example.algodesign.repository.ProblemRepository
import com.example.algodesign.viewmodel.ProblemViewModel
import org.koin.dsl.module

val myModule = module {
    factory { ProblemViewModel() }
    factory { ProblemRepository() }
}
