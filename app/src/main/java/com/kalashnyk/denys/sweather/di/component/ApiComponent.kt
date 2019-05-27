package com.kalashnyk.denys.sweather.di.component

import com.kalashnyk.denys.sweather.di.module.ApiModule
import com.kalashnyk.denys.sweather.di.scope.ApiScope
import com.kalashnyk.denys.sweather.repository.server.ServerCommunicator
import dagger.Component

@ApiScope
@Component(modules = [ApiModule::class])
interface ApiComponent {
    val serverCommunicator: ServerCommunicator
}
