package com.github.aerialist7

import kotlin.js.Promise

object CesiumProviders {
    private val options = CreateWorldTerrainAsyncOptions(
        requestWaterMask = true,
        requestVertexNormals = false,
    )

    val terrainProviderPromise: Promise<CreateWorldTerrainAsyncOptions> =
        Promise { resolve, _ -> resolve(options) }
}

fun main() {
    CesiumProviders.terrainProviderPromise.then { console.log(it) }
}
